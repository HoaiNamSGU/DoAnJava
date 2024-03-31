package test;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class JTableDeleteRowExample extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public JTableDeleteRowExample() {
        setTitle("JTable Delete Row Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Dữ liệu mảng 2D để hiển thị trong JTable
        Object[][] data = {
                {"John", 25, "Male"},
                {"Anna", 30, "Female"},
                {"Tom", 35, "Male"},
                {"Emily", 28, "Female"}
        };

        // Tên cột
        String[] columnNames = {"Name", "Age", "Gender"};

        // Khởi tạo DefaultTableModel với dữ liệu và tên cột
        model = new DefaultTableModel(data, columnNames);

        // Khởi tạo JTable với DefaultTableModel
        table = new JTable(model);

        // Thêm JTable vào JScrollPane để có thanh cuộn nếu cần
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Button để xóa hàng được chọn
        JButton deleteButton = new JButton("Delete Selected Row");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(JTableDeleteRowExample.this,
                            "No row selected!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(deleteButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTableDeleteRowExample().setVisible(true);
            }
        });
    }
}

