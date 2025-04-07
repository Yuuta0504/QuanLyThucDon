package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register{
    public static void main(String[] args) {
        // Khởi tạo cửa sổ JFrame
        JFrame frame = new JFrame("Đăng Ký");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new GradientPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Các thành phần của form
        JLabel title = new JLabel("Đăng Kí");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy= 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        JTextField usernameField = new JTextField(20);
        usernameField.setBorder(BorderFactory.createTitledBorder("Nhap Email"));
        usernameField.setCaretColor(Color.BLUE);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(usernameField, gbc);


        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBorder(BorderFactory.createTitledBorder("Nhap mat khau"));
        passwordField.setCaretColor(Color.BLUE);
        gbc.gridy = 2;
        panel.add(passwordField, gbc);


        JPasswordField confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setBorder(BorderFactory.createTitledBorder("Xac nhan mat khau"));
        confirmPasswordField.setCaretColor(Color.BLUE);
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(confirmPasswordField, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton registerButton = new JButton("Đăng ký");
        panel.add(registerButton, gbc);

        JButton backtoLogin = new JButton("Quay lại trang Đăng nhập");
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(backtoLogin, gbc);

        backtoLogin.addActionListener(e -> {
            frame.dispose();
            Login.main(new String[]{});
        });
        // Xử lý sự kiện khi nhấn nút Đăng ký
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng điền đầy đủ thông tin!");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Mật khẩu xác nhận không khớp!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Đăng ký thành công!");
                    // Lưu trữ hoặc xử lý dữ liệu ở đây
                }
            }
        });

        // Thêm các thành phần vào cửa sổ
        frame.add(panel);
        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
