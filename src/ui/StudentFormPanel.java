package ui;

import model.Student;
import javax.swing.*;
import java.awt.*;

public class StudentFormPanel extends JPanel {
    private JTextField txtRoll, txtName, txtAge, txtCourse;

    public StudentFormPanel() {
        setLayout(new GridLayout(4, 2, 10, 10));
        setBorder(BorderFactory.createTitledBorder("Student Details"));
        setBackground(new Color(52, 73, 94));

        JLabel lblRoll = new JLabel("Roll No:"); lblRoll.setForeground(Color.WHITE);
        JLabel lblName = new JLabel("Name:"); lblName.setForeground(Color.WHITE);
        JLabel lblAge = new JLabel("Age:"); lblAge.setForeground(Color.WHITE);
        JLabel lblCourse = new JLabel("Course:"); lblCourse.setForeground(Color.WHITE);

        txtRoll = createField();
        txtName = createField();
        txtAge = createField();
        txtCourse = createField();

        add(lblRoll); add(txtRoll);
        add(lblName); add(txtName);
        add(lblAge); add(txtAge);
        add(lblCourse); add(txtCourse);
    }

    private JTextField createField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(new RoundedBorder(10));
        return field;
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
        try { return Integer.parseInt(txtRoll.getText().trim()); }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter a valid Roll Number.");
            return null;
        }
    }
}

