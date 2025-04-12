
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Login {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Đăng nhập");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JLabel lblUsername = new JLabel("Tên đăng nhập:");
            gbc.gridx = 0;
            gbc.gridy = 0;
            frame.add(lblUsername, gbc);

            JTextField txtUsername = new JTextField(20);
            gbc.gridx = 1;
            gbc.gridy = 0;
            frame.add(txtUsername, gbc);

            JLabel lblPassword = new JLabel("Mật khẩu:");
            gbc.gridx = 0;
            gbc.gridy = 1;
            frame.add(lblPassword, gbc);

            JPasswordField txtPassword = new JPasswordField(20);
            gbc.gridx = 1;
            gbc.gridy = 1;
            frame.add(txtPassword, gbc);

            JCheckBox chkRemember = new JCheckBox("Ghi nhớ cho lần sau");
            gbc.gridx = 1;
            gbc.gridy = 2;
            frame.add(chkRemember, gbc);

            JButton btnLogin = new JButton("Đăng nhập");
            gbc.gridx = 1;
            gbc.gridy = 3;
            frame.add(btnLogin, gbc);

            btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = txtUsername.getText();
                    String password = new String(txtPassword.getPassword());
                    JOptionPane.showMessageDialog(frame, "Tên đăng nhập: " + username + "\nMật khẩu: " + password);
                }
            });

            frame.setVisible(true);
        }
    }

