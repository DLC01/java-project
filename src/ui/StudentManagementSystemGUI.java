package ui;

import model.StudentDAO;
import model.Student;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentManagementSystemGUI extends JFrame {
    private StudentFormPanel formPanel;
    private StudentButtonPanel buttonPanel;
    private StudentDisplayPanel displayPanel;
    private StudentDAO dao;

    public StudentManagementSystemGUI() {
        dao = new StudentDAO();
        setTitle("Student Management System (SQLite)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(34, 45, 65));

        formPanel = new StudentFormPanel();
        buttonPanel = new StudentButtonPanel();
        displayPanel = new StudentDisplayPanel();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        formPanel.setBackground(new Color(34, 45, 65));
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Student Details",
                0, 0, new Font("Arial", Font.BOLD, 14), Color.WHITE));

        buttonPanel.setBackground(new Color(34, 45, 65));
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60)); // keep buttons visible

        displayPanel.setBackground(new Color(34, 45, 65));
        displayPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Student Records",
                0, 0, new Font("Arial", Font.BOLD, 14), Color.WHITE));

        add(formPanel);
        add(buttonPanel);
        add(displayPanel);

        formPanel.setBackground(new Color(52, 73, 94));
        buttonPanel.setBackground(new Color(52, 73, 94));
        displayPanel.setBackground(new Color(52, 73, 94));

        buttonPanel.setAddAction(e -> addStudent());
        buttonPanel.setUpdateAction(e -> updateStudent());
        buttonPanel.setDeleteAction(e -> deleteStudent());
        buttonPanel.setViewAction(e -> viewStudents());
    }

    private void addStudent() {
        Student s = formPanel.getStudentInput();
        if (s == null) return;
        if (dao.addStudent(s)) displayPanel.showMessage("Student added successfully!");
        else displayPanel.showMessage("Error adding student.");
    }

    private void updateStudent() {
        Student s = formPanel.getStudentInput();
        if (s == null) return;
        if (dao.updateStudent(s)) displayPanel.showMessage("Student updated successfully!");
        else displayPanel.showMessage("Error updating student.");
    }

    private void deleteStudent() {
        Integer roll = formPanel.getRollNumber();
        if (roll == null) return;
        if (dao.deleteStudent(roll)) displayPanel.showMessage("Student deleted successfully!");
        else displayPanel.showMessage("Error deleting student.");
    }

    private void viewStudents() {
        List<Student> students = dao.getAllStudents();
        displayPanel.showStudents(students);
    }
}

