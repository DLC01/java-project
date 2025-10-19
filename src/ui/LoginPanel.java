
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
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel background = new JPanel();
        background.setBackground(new Color(34, 45, 65));
        background.setLayout(new GridBagLayout());
        add(background);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("Student Management System", JLabel.CENTER);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        background.add(lblTitle, gbc);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1; gbc.gridwidth = 1;
        background.add(lblUsername, gbc);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        txtUsername.setBorder(new RoundedBorder(10));
        gbc.gridx = 1;
        background.add(txtUsername, gbc);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 2;
        background.add(lblPassword, gbc);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        txtPassword.setBorder(new RoundedBorder(10));
        gbc.gridx = 1;
        background.add(txtPassword, gbc);

        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(75, 135, 185));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setBorder(new RoundedBorder(10));
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        background.add(btnLogin, gbc);

        btnLogin.addActionListener(e -> login());
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) { btnLogin.setBackground(new Color(100, 160, 210)); }
            public void mouseExited(java.awt.event.MouseEvent evt) { btnLogin.setBackground(new Color(75, 135, 185)); }
        });
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
            SwingUtilities.invokeLater(() -> new StudentManagementSystemGUI().setVisible(true));
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }
}
