package model;

import db.DatabaseConnector;
import java.sql.*;

public class UserDAO {
    private Connection conn;

    public UserDAO() {
        conn = DatabaseConnector.getConnection();
        initializeAdmin();
    }

    private void initializeAdmin() {
        try (Statement stmt = conn.createStatement()) {
            // Create table if not exists
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                    "username TEXT PRIMARY KEY, " +
                    "password TEXT NOT NULL)";
            stmt.execute(sql);

            // Insert default admin if table empty
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM users");
            if (rs.next() && rs.getInt("count") == 0) {
                sql = "INSERT INTO users(username, password) VALUES('admin', 'admin123')";
                stmt.execute(sql);
                System.out.println("✅ Default admin created: admin/admin123");
            }
        } catch (SQLException e) {
            System.err.println("Error initializing users: " + e.getMessage());
        }
    }

    public boolean validateUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error validating user: " + e.getMessage());
            return false;
        }
    }
}
