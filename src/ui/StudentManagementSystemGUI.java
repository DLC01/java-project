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
        setSize(600, 600);
        setLayout(new BorderLayout());

        formPanel = new StudentFormPanel();
        buttonPanel = new StudentButtonPanel();
        displayPanel = new StudentDisplayPanel();

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.SOUTH);

        // Button Actions
        buttonPanel.setAddAction(e -> addStudent());
        buttonPanel.setUpdateAction(e -> updateStudent());
        buttonPanel.setDeleteAction(e -> deleteStudent());
        buttonPanel.setViewAction(e -> viewStudents());
    }

    private void addStudent() {
        Student s = formPanel.getStudentInput();
        if (s == null) return;
        if (dao.addStudent(s))
            displayPanel.showMessage("Student added successfully!");
        else
            displayPanel.showMessage("Error adding student.");
    }

    private void updateStudent() {
        Student s = formPanel.getStudentInput();
        if (s == null) return;
        if (dao.updateStudent(s))
            displayPanel.showMessage("Student updated successfully!");
        else
            displayPanel.showMessage("Error updating student.");
    }

    private void deleteStudent() {
        Integer roll = formPanel.getRollNumber();
        if (roll == null) return;
        if (dao.deleteStudent(roll))
            displayPanel.showMessage("Student deleted successfully!");
        else
            displayPanel.showMessage("Error deleting student.");
    }

    private void viewStudents() {
        List<Student> students = dao.getAllStudents();
        displayPanel.showStudents(students);
    }
}
