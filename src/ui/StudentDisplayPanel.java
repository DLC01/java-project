package ui;

import model.Student;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentDisplayPanel extends JPanel {
    private JTextArea txtArea;

    public StudentDisplayPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Student Records"));
        txtArea = new JTextArea(10, 40);
        txtArea.setEditable(false);
        add(new JScrollPane(txtArea), BorderLayout.CENTER);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showStudents(List<Student> list) {
        txtArea.setText("");
        if (list.isEmpty()) {
            txtArea.setText("No student records found.");
            return;
        }
        for (Student s : list) {
            txtArea.append("Roll: " + s.getRoll() + ", Name: " + s.getName() +
                    ", Age: " + s.getAge() + ", Course: " + s.getCourse() + "\n");
        }
    }
}
