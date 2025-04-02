package GUI;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Tạo gradient từ màu xanh dương sang xanh tím
        GradientPaint gradient = new GradientPaint(0, 0, new Color(78, 93, 248), getWidth(), getHeight(), new Color(196, 215, 248, 226));
        g2d.setPaint(gradient);
        g2d.fillRect(1, 2, getWidth(), getHeight());
    }
}

public class Login {
    public static void main(String[] args) {
        // Tạo frame
        JFrame frame = new JFrame("Đăng nhập");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
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
        emailField.setBorder(BorderFactory.createTitledBorder("Email/ID"));
        emailField.setCaretColor(Color.blue);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(emailField, gbc);

        // Ô nhập Password
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        passwordField.setCaretColor(Color.blue);
        gbc.gridy = 3;
        panel.add(passwordField, gbc);
        // Nút Login
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(76, 175, 80));
        loginButton.setForeground(Color.BLACK);
        gbc.gridy = 4;
        panel.add(loginButton, gbc);

        //Chuyển qua trang đăng kí
        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(250, 54, 54));
        registerButton.setForeground(Color.BLACK);
        gbc.gridy = 5;
        panel.add(registerButton, gbc);

        registerButton.addActionListener(e -> {
            frame.dispose();
            Register.main(new String[]{});
        });

        // Link quên mật khẩu
        JLabel forgotLabel = new JLabel("Forgot Username / Password?");
        forgotLabel.setForeground(Color.YELLOW);
        gbc.gridy = 6;
        panel.add(forgotLabel, gbc);

        forgotLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                forgotLabel.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                forgotLabel.setForeground(Color.YELLOW);
            }
        });


        // Thêm panel vào frame
        frame.add(panel);
        frame.setVisible(true);

    }
}
