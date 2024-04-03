package test;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("InputDialog Example");

        String input = JOptionPane.showInputDialog(frame, "Nhập vào một giá trị:");

        if (input != null && !input.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Giá trị đã nhập: " + input);
        } else {
            JOptionPane.showMessageDialog(frame, "Bạn không nhập giá trị!");
        }

        // Đặt kích thước cho cửa sổ JFrame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
