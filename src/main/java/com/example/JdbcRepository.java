package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class JdbcRepository implements Repository {

    @Autowired
    private DataSource dataSource;


    @Override
    public Hello getHello(long helloId) throws Exception {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT id, text FROM hello WHERE id = ?")) {
            ps.setLong(1, helloId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new Exception("No repository with ID " + helloId);
                else return rsHello(rs);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public String testDb() throws SQLException {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1+1")) {
            rs.next();
            int two = rs.getInt(1);
            return "Database connectivity seems " + (two == 2 ? "OK." : "weird!");
        }
    }


    private Hello rsHello(ResultSet rs) throws SQLException {
        return new Hello(rs.getLong("id"), rs.getString("title"));
    }
}
