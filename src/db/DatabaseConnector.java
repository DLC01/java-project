package db;

import java.sql.*;

public class DatabaseConnector {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:studentdb.db");
                System.out.println("✅ Connected to SQLite database successfully!");
                initializeDatabase();
            } catch (ClassNotFoundException e) {
                System.err.println("SQLite JDBC Driver not found!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Database connection failed!");
                e.printStackTrace();
            }
        }
        return conn;
    }

    private static void initializeDatabase() {
        try (Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS students (" +
                    "roll INTEGER PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "age INTEGER NOT NULL, " +
                    "course TEXT NOT NULL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
