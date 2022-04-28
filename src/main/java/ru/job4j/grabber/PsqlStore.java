package ru.job4j.grabber;

import java.sql.*;
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
                "insert into post(name, text, link, created) values(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getDescription());
            ps.setString(3, post.getLink());
            ps.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
            ps.execute();
        }
    }

    @Override
    public List<Post> getAll() throws SQLException {
        List<Post> post = new ArrayList<>();
        Statement statement = cn.createStatement();
        String sql = "Select * from post";
        ResultSet rslSet = statement.executeQuery(sql);
        while(rslSet.next()) {
            post.add(new Post(rslSet.getInt("id"),
                    rslSet.getString("title"),
                    rslSet.getString("link"),
                    rslSet.getString("description"),
                    rslSet.getTimestamp("created").toLocalDateTime()
                    ));
        }
        return post;
    }

    @Override
    public Post findById(int id) throws SQLException {
        Post post = null;
        Statement statement = cn.createStatement();
        String sql = String.format("select * from post where id = %o", id);
        ResultSet rsl = statement.executeQuery(sql);
        if (rsl.next()) {
            post = new Post(rsl.getInt("id"),
                    rsl.getString("title"),
                    rsl.getString("link"),
                    rsl.getString("description"),
                    rsl.getTimestamp("created").toLocalDateTime());
        }
        return post;
    }
}
