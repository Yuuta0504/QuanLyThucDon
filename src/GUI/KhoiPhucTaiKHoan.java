package GUI;


import UTIL.OTPManager;


import javax.swing.*;
import java.awt.*;

public class KhoiPhucTaiKHoan {
    public static void show(String email) {
        JFrame frame = new JFrame("Khôi phục tài khoản");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new GradientPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(panel);

        JLabel khoiphuc = new JLabel("Khôi phục tài khoản");
        khoiphuc.setForeground(new Color(35, 35, 35));
        khoiphuc.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(khoiphuc, gbc);

        JTextField ma = new JTextField(20);
        ma.setCaretColor(new Color(12, 33, 255));
        ma.setBorder(BorderFactory.createTitledBorder("Nhập mã khôi phục"));
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(ma, gbc);

        JButton send = new JButton("Gửi");
        send.setForeground(Color.BLACK);
        send.setBackground(Color.WHITE);
        gbc.gridy = 3;
        panel.add(send, gbc);
        send.addActionListener(e -> {
            String enteredOtp = ma.getText().trim();
            if (OTPManager.verifyOTP(email, enteredOtp)) {
                OTPManager.removeOTP(email); // xoá sau khi dùng
                JOptionPane.showMessageDialog(frame, "Xác thực thành công!");
                frame.dispose();
                ResetPasswordGUI.show(email);
            } else {
                JOptionPane.showMessageDialog(frame, "Mã xác thực không đúng!");
            }
        });
        frame.setVisible(true);
    }
}
