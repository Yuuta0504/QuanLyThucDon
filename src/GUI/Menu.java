package GUI;

import javax.swing.*;
import java.awt.*;

public class  Menu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Chính");
        frame.setSize(1200, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Panel Chinh
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //sidebar
        JPanel left_column = new JPanel();
        left_column.setBackground(new Color(29, 37, 50));
        left_column.setLayout(new BorderLayout());
        left_column.setPreferredSize(new Dimension(200, 0));
        panel.add(left_column, BorderLayout.WEST);

        //main menu
        CardLayout cardLayout = new CardLayout();
        GradientPanel right_column = new GradientPanel();
        right_column.setLayout(cardLayout);
        panel.add(right_column, BorderLayout.CENTER);

        // Tiêu đề sidebar
        JLabel sidebar = new JLabel("Trang Chủ");
        sidebar.setForeground(new Color(228, 228, 228));
        sidebar.setFont(new Font("Arial", Font.BOLD, 24));
        sidebar.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa trong JLabel

        // Tạo panel bọc tiêu đề
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(29, 37, 50)); // Phải cùng màu với sidebar
        titlePanel.add(sidebar);
        left_column.add(titlePanel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new Color(29, 37, 50));

        String[] menuItems = {"Thực đơn", "Hóa đơn", "Bàn ăn", "Thoát"};
        for (String item : menuItems) {
            JButton btn = new JButton(item);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(180, 40));
            btn.setForeground(new Color(213, 213, 213));
            btn.setBackground(new Color(29, 37, 50));
            btn.setFont(new Font("Arial", Font.PLAIN, 16));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);

            // Tạo wrapper panel chứa mỗi button
            JPanel btnWrapper = new JPanel();
            btnWrapper.setLayout(new FlowLayout(FlowLayout.CENTER));
            btnWrapper.setMaximumSize(new Dimension(200, 50));
            btnWrapper.setBackground(new Color(29, 37, 50)); // màu nền mặc định
            btnWrapper.add(btn);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10))); // khoảng cách
            menuPanel.add(btnWrapper);

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btnWrapper.setBackground(Color.WHITE);
                    btn.setBackground(Color.WHITE);
                    btn.setForeground(Color.BLACK);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btnWrapper.setBackground(new Color(29, 37, 50));
                    btn.setBackground(new Color(29, 37, 50));
                    btn.setForeground(new Color(213, 213, 213));
                }
            });
//            JPanel thucdon = new JPanel();
//            thucdon.setOpaque(false);
//            thucdon.setLayout(new BorderLayout());
//            thucdon.add(new JLabel("Đây là giao diện Thực đơn", SwingConstants.CENTER), BorderLayout.CENTER);
//            right_column.add(thucdon, "Thực đơn");
//            JPanel thucdon = new JPanel();
            ThucDon thucdon = new ThucDon();
            right_column.add(thucdon, "Thực đơn");


            JPanel hoadon = new JPanel();
            hoadon.setOpaque(false);
            hoadon.setLayout(new BorderLayout());
            hoadon.add(new JLabel("Đây là giao diện Hoá đơn", SwingConstants.CENTER), BorderLayout.CENTER);
            right_column.add(hoadon, "Hoá Đơn");

            JPanel banan = new JPanel();
            banan.setOpaque(false);
            banan.setLayout(new BorderLayout());
            banan.add(new JLabel("Đây là giao diện Bàn ăn", SwingConstants.CENTER), BorderLayout.CENTER);
            right_column.add(banan, "Bàn ăn");


            if (item.equals("Thực đơn")) {
                btn.addActionListener(e -> cardLayout.show(right_column, "Thực đơn"));
            }

            if (item.equals("Hóa đơn")) {
                btn.addActionListener(e -> cardLayout.show(right_column, "Hoá Đơn"));
            }

            if (item.equals("Bàn ăn")) {
                btn.addActionListener(e -> cardLayout.show(right_column, "Bàn ăn"));
            }
            if (item.equals("Thoát")) {
                btn.addActionListener(e -> {
                    int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát chứ?");
                    if (choice == JOptionPane.YES_OPTION) {
                        frame.dispose();
                        Login.main(new String[]{});
                    }
                });
            }
        }

        left_column.add(menuPanel, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}