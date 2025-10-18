package model;

import db.DatabaseConnector;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() {
        conn = DatabaseConnector.getConnection();
    }

    public boolean addStudent(Student s) {
        String sql = "INSERT INTO students(roll, name, age, course) VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, s.getRoll());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getCourse());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
            return false;
        }
    }

    public boolean updateStudent(Student s) {
        String sql = "UPDATE students SET name=?, age=?, course=? WHERE roll=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getRoll());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int roll) {
        String sql = "DELETE FROM students WHERE roll=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, roll);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("roll"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching students: " + e.getMessage());
        }
        return list;
    }
}
