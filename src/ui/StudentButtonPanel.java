package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentButtonPanel extends JPanel {
    private JButton btnAdd, btnUpdate, btnDelete, btnView;

    public StudentButtonPanel() {
        setLayout(new GridLayout(1, 4, 15, 15));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnAdd = createButton("Add");
        btnUpdate = createButton("Update");
        btnDelete = createButton("Delete");
        btnView = createButton("View All");

        add(btnAdd); add(btnUpdate); add(btnDelete); add(btnView);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(75, 135, 185));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setBorder(new RoundedBorder(10));
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) { btn.setBackground(new Color(100, 160, 210)); }
            public void mouseExited(java.awt.event.MouseEvent evt) { btn.setBackground(new Color(75, 135, 185)); }
        });
        return btn;
    }

    public void setAddAction(ActionListener l) { btnAdd.addActionListener(l); }
    public void setUpdateAction(ActionListener l) { btnUpdate.addActionListener(l); }
    public void setDeleteAction(ActionListener l) { btnDelete.addActionListener(l); }
    public void setViewAction(ActionListener l) { btnView.addActionListener(l); }
}
