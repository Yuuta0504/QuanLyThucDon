package GUI;

import DAO.UserDAO;
import Model.User;
import UTIL.OTPManager;
import UTIL.SendEmail;

import javax.swing.*;
import java.awt.*;

public class ForgetGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quên Mất Khẩu");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel main = new GradientPanel();
        main.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 10, 10);
        main.setBackground(new Color(13, 105, 237));

        JLabel title = new JLabel("Quên Mật khẩu");
        title.setForeground(new Color(29, 37, 50));
        title.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        main.add(title, gbc);

        // Email input
        JTextField emailField = new JTextField(20);
        emailField.setBorder(BorderFactory.createTitledBorder("Nhập email đã đăng ký"));
        emailField.setCaretColor(Color.BLACK);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        main.add(emailField, gbc);

        // Gửi yêu cầu khôi phục
        JButton submitBtn = new JButton("Gửi yêu cầu");
        submitBtn.setBackground(Color.WHITE);
        emailField.addActionListener(e -> submitBtn.doClick());
        submitBtn.setForeground(Color.BLACK);
        submitBtn.setFocusPainted(false);
        gbc.gridy = 3;
        main.add(submitBtn, gbc);

        // Quay lại đăng nhập
        JButton backBtn = new JButton("Quay lại đăng nhập");
        backBtn.setBackground(Color.LIGHT_GRAY);
        backBtn.setForeground(Color.BLACK);
        backBtn.setFocusPainted(false);
        gbc.gridy = 4;
        main.add(backBtn, gbc);

        // Sự kiện cho nút quay lại
        backBtn.addActionListener(e -> {
            frame.dispose();
            Login.main(new String[]{}); // quay lại trang login
        });

        // Sự kiện cho nút gửi
        submitBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            User user = UserDAO.findUserbyEmail(email);
            if (user == null) {
                JOptionPane.showMessageDialog(frame, "Email không tồn tại!");
            } else {
                submitBtn.setEnabled(false);
                submitBtn.setText("Đang gửi...");

                new Thread(() -> {
                    try {
                        String otp = String.valueOf((int)(Math.random() * 900000) + 100000);
                        OTPManager.storeOTP(user.getEmail(), otp); // Lưu OTP
                        SendEmail.send(user.getEmail(), otp); // Gửi mail

                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(frame, "Mã xác thực đã được gửi đến email của bạn!");
                            frame.dispose();
                            KhoiPhucTaiKHoan.show(user.getEmail());
                        });
                    } catch (Exception ex) {
                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(frame, "Đã xảy ra lỗi khi gửi email: " + ex.getMessage());
                            submitBtn.setEnabled(true);
                            submitBtn.setText("Gửi yêu cầu");
                        });
                    }
                }).start();
            }
        });


        frame.add(main);
        frame.setVisible(true);
    }
}
