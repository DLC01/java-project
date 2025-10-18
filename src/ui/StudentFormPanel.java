package ui;

import model.Student;
import javax.swing.*;
import java.awt.*;

public class StudentFormPanel extends JPanel {
    private JTextField txtRoll, txtName, txtAge, txtCourse;

    public StudentFormPanel() {
        setLayout(new GridLayout(4, 2, 10, 10));
        setBorder(BorderFactory.createTitledBorder("Student Details"));

        add(new JLabel("Roll No:"));
        txtRoll = new JTextField();
        add(txtRoll);

        add(new JLabel("Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Age:"));
        txtAge = new JTextField();
        add(txtAge);

        add(new JLabel("Course:"));
        txtCourse = new JTextField();
        add(txtCourse);
    }

    public Student getStudentInput() {
        try {
            int roll = Integer.parseInt(txtRoll.getText().trim());
            String name = txtName.getText().trim();
            int age = Integer.parseInt(txtAge.getText().trim());
            String course = txtCourse.getText().trim();

            if (name.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return null;
            }

            return new Student(roll, name, age, course);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input! Roll and Age must be numbers.");
            return null;
        }
    }

    public Integer getRollNumber() {
        try {
            return Integer.parseInt(txtRoll.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid Roll Number.");
            return null;
        }
    }
}
