package ui;

import model.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class StudentDisplayPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public StudentDisplayPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Student Records"));
        setBackground(new Color(52, 73, 94));

        tableModel = new DefaultTableModel(new Object[]{"Roll", "Name", "Age", "Course"}, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(75, 135, 185));
        table.getTableHeader().setForeground(Color.WHITE);

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable t, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(t, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? new Color(236, 240, 241) : new Color(189, 195, 199));
                } else {
                    c.setBackground(new Color(100, 160, 210));
                }
                return c;
            }
        });

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void showMessage(String message) { JOptionPane.showMessageDialog(this, message); }

    public void showStudents(List<Student> students) {
        tableModel.setRowCount(0);
        if (students.isEmpty()) { JOptionPane.showMessageDialog(this, "No student records found."); return; }
        for (Student s : students) tableModel.addRow(new Object[]{s.getRoll(), s.getName(), s.getAge(), s.getCourse()});
    }
}
