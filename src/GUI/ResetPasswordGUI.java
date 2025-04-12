package GUI;

import DAO.UserDAO;

import javax.swing.*;
import java.awt.*;

public class ResetPasswordGUI {
    public static void show(String email) {
        JFrame frame = new JFrame("Đặt lại mật khẩu");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new GradientPanel();
        panel.setLayout(new GridLayout(3, 1, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JPasswordField newPassword = new JPasswordField();
        newPassword.setBorder(BorderFactory.createTitledBorder("Mật khẩu mới"));

        JPasswordField confirmPassword = new JPasswordField();
        confirmPassword.setBorder(BorderFactory.createTitledBorder("Xác nhận mật khẩu"));

        JButton submit = new JButton("Đổi mật khẩu");

        submit.addActionListener(e -> {
            String pass1 = new String(newPassword.getPassword());
            String pass2 = new String(confirmPassword.getPassword());

            if (!pass1.equals(pass2)) {
                JOptionPane.showMessageDialog(frame, "Mật khẩu không khớp!");
            } else if (pass1.length() < 6) {
                JOptionPane.showMessageDialog(frame, "Mật khẩu quá ngắn!");
            } else {
                boolean success = UserDAO.updatePassword(email, pass1);
                if (success) {
                    JOptionPane.showMessageDialog(frame, "Đổi mật khẩu thành công!");
                    frame.dispose();
                    Login.main(new String[]{}); // Quay lại trang đăng nhập
                } else {
                    JOptionPane.showMessageDialog(frame, "Cập nhật mật khẩu thất bại!");
                }
            }

        });

        panel.add(newPassword);
        panel.add(confirmPassword);
        panel.add(submit);

        frame.add(panel);
        frame.setVisible(true);
    }
}
