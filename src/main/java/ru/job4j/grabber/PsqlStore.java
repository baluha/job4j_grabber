package ru.job4j.grabber;

import ru.job4j.quartz.AlertRabbit;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.Timestamp;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cn;

    public PsqlStore(Properties cfg) {
        try {
            Class.forName(cfg.getProperty("driver-class-name"));
        } catch (Exception e) {
         throw new IllegalStateException(e);
        }
        try {
            cn = DriverManager.getConnection(cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public void save(Post post) throws SQLException {
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
        }
    }

    @Override
    public List<Post> getAll() throws SQLException {
        List<Post> post = new ArrayList<>();
        try(PreparedStatement statement = cn.prepareStatement("Select * from post")) {
            try (ResultSet rslSet = statement.executeQuery()) {
                while (rslSet.next()) {
                    post.add(getPost(rslSet));
                }
            }
        }
        return post;
    }

    @Override
    public Post findById(int id) throws SQLException {
        Statement statement = cn.createStatement();
        String sql = String.format("select * from post where id = %o", id);
        ResultSet rsl = statement.executeQuery(sql);
        return rsl.next() ? getPost(rsl) : null;
    }

    public Post getPost(ResultSet rsl) throws SQLException {
            return new Post(rsl.getInt("id"),
                    rsl.getString("title"),
                    rsl.getString("link"),
                    rsl.getString("description"),
                    rsl.getTimestamp("created").toLocalDateTime());

    }

    public static void main(String[] args) throws SQLException {
        Properties properties = AlertRabbit.getProperties();
        PsqlStore psqlStore = new PsqlStore(properties);
        Post post = new Post(
                "java-developer",
                "https://career.habr.com/vacancies/1",
                "Сиди за монитором all day long и имитируй бурную деятельность",
                LocalDateTime.now());
        psqlStore.save(post);
        System.out.println(psqlStore.getAll());
        System.out.println("-|-|-|-|-|-|-|-|-|-|-");
        System.out.println(psqlStore.findById(2));
    }
}
