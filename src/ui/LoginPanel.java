package ui;

import model.UserDAO;
import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private UserDAO userDAO;

    public LoginPanel() {
        userDAO = new UserDAO();

        setTitle("Login - Student Management System");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));
        setLocationRelativeTo(null);

        add(new JLabel("Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        btnLogin = new JButton("Login");
        add(new JLabel()); // empty cell
        add(btnLogin);

        btnLogin.addActionListener(e -> login());
    }

    private void login() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        if (userDAO.validateUser(username, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            // Open main student management GUI
            SwingUtilities.invokeLater(() -> {
                new StudentManagementSystemGUI().setVisible(true);
            });
            dispose(); // close login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }
}

