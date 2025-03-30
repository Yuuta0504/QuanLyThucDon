package GUI;

import javax.swing.*;
import java.awt.*;

class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo gradient từ màu xanh dương sang xanh tím
        GradientPaint gradient = new GradientPaint(0, 0, new Color(0, 153, 255),
                getWidth(), getHeight(), new Color(102, 0, 204));
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}

public class Login {
    public static void main(String[] args) {
                // Tạo frame
                JFrame frame = new JFrame("Đăng nhập");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setLocationRelativeTo(null);


                // Panel chính
                JPanel panel = new GradientPanel();
                panel.setLayout(new GridBagLayout());
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
