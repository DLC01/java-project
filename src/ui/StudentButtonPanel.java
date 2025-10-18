package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentButtonPanel extends JPanel {
    private JButton btnAdd, btnUpdate, btnDelete, btnView;

    public StudentButtonPanel() {
        setLayout(new GridLayout(1, 4, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnView = new JButton("View All");

        add(btnAdd);
        add(btnUpdate);
        add(btnDelete);
        add(btnView);
    }

    public void setAddAction(ActionListener l) { btnAdd.addActionListener(l); }
    public void setUpdateAction(ActionListener l) { btnUpdate.addActionListener(l); }
    public void setDeleteAction(ActionListener l) { btnDelete.addActionListener(l); }
    public void setViewAction(ActionListener l) { btnView.addActionListener(l); }
}
