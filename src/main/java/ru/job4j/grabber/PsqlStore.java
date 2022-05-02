package ru.job4j.grabber;

import org.slf4j.Logger;
import ru.job4j.quartz.AlertRabbit;

import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.Timestamp;

public class PsqlStore implements Store, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(PsqlStore.class.getName());
    private Connection cn;

    public PsqlStore(Properties cfg) {
        try {
            Class.forName(cfg.getProperty("driver-class-name"));
        } catch (Exception e) {
         LOG.error("Exception in reading properties file", e);
        }
        try {
            cn = DriverManager.getConnection(cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password"));
        } catch (Exception e) {
            LOG.error("Exception in reading properties file", e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public void save(Post post)  {
        try (PreparedStatement ps = cn.prepareStatement(
                "insert into post(title, description, link, created) values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getDescription());
            ps.setString(3, post.getLink());
            ps.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
            ps.execute();
            try (ResultSet getGeneratedKeys = ps.getGeneratedKeys()) {
                if (getGeneratedKeys.next()) {
                    post.setId(getGeneratedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in saving post in database", e);
        }
    }

    @Override
    public List<Post> getAll(){
        List<Post> post = new ArrayList<>();
        try(PreparedStatement statement = cn.prepareStatement("Select * from post")) {
            try (ResultSet rslSet = statement.executeQuery()) {
                while (rslSet.next()) {
                    post.add(getPost(rslSet));
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in getting list of posts", e);
        }
        return post;
    }

    @Override
    public Post findById(int id) {
        Post post = null;
        try (PreparedStatement ps = cn.prepareStatement(
                String.format("select * from post where id = %o", id))) {
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    post = getPost(resultSet);
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in find by id method", e);
        }
        return post;
    }

    public Post getPost(ResultSet rsl){
        Post post = new Post();
        try {
            post = new Post(rsl.getInt("id"),
                    rsl.getString("title"),
                    rsl.getString("link"),
                    rsl.getString("description"),
                    rsl.getTimestamp("created").toLocalDateTime());
        } catch (Exception e) {
            LOG.error("Exception in getPost method", e);
        }
        return post;
    }

    public static void main(String[] args) {
        Properties properties = AlertRabbit.getProperties();
        PsqlStore psqlStore = new PsqlStore(properties);
        Post post = new Post(
                "java-developer",
                "https://career.habr.com/vacancies/1",
                "Сиди за монитором all day long и имитируй бурную деятельность",
                LocalDateTime.now());
        psqlStore.save(post);
        System.out.println(psqlStore.findById(1));
        System.out.println("-|-|-|-|-|-|-|-|-|-|-");
        psqlStore.getAll().forEach(System.out::println);
    }
}
