package GUI;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(String[] args) {
                // Tạo frame
                JFrame frame = new JFrame("User Login");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setLocationRelativeTo(null);

                // Panel chính
                JPanel panel = new JPanel();
                panel.setLayout(new GridBagLayout());
                panel.setBackground(Color.WHITE);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);

                // Icon user
                JLabel iconLabel = new JLabel();
                iconLabel.setIcon(new ImageIcon("icon-7797704_1280.png")); // Thay bằng đường dẫn ảnh avatar
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                panel.add(iconLabel, gbc);

                // Tiêu đề "User Login"
                JLabel titleLabel = new JLabel("Đăng nhập");
                titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
                gbc.gridy = 1;
                panel.add(titleLabel, gbc);

                // Ô nhập Email
                JTextField emailField = new JTextField(20);
                emailField.setBorder(BorderFactory.createTitledBorder("Email Id"));
                gbc.gridy = 2;
                gbc.gridwidth = 2;
                panel.add(emailField, gbc);

                // Ô nhập Password
                JPasswordField passwordField = new JPasswordField(20);
                passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
                gbc.gridy = 3;
                panel.add(passwordField, gbc);

                // Nút Login
                JButton loginButton = new JButton("Login");
                loginButton.setBackground(new Color(76, 175, 80));
                loginButton.setForeground(Color.BLACK);
                gbc.gridy = 4;
                panel.add(loginButton, gbc);

                // Link quên mật khẩu
                JLabel forgotLabel = new JLabel("Forgot Username / Password?");
                forgotLabel.setForeground(Color.BLUE);
                gbc.gridy = 5;
                panel.add(forgotLabel, gbc);

                // Thêm panel vào frame
                frame.add(panel);
                frame.setVisible(true);

    }
}
