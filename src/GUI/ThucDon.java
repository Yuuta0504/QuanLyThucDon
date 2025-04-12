package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Model.Dish;

public class ThucDon extends JPanel {

    public ThucDon() {
        setLayout(new BorderLayout());

        // Panel nền Gradient
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(111, 143, 255);
                Color color2 = new Color(167, 193, 255);
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        backgroundPanel.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(backgroundPanel);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);

        // Thêm từng nhóm món ăn
        backgroundPanel.add(createLoaiMonSection(" Món chính", getMonChinh()));
        backgroundPanel.add(createLoaiMonSection(" Món phụ", getMonPhu()));
        backgroundPanel.add(createLoaiMonSection(" Nước uống", getDoUong()));

        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createLoaiMonSection(String title, ArrayList<Dish> danhSachMon) {
        JPanel section = new JPanel();
        section.setLayout(new BorderLayout());
        section.setOpaque(false);
        section.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        // Tiêu đề loại món
        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(Color.WHITE);
        section.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các món ăn
        JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        itemPanel.setOpaque(false);

        for (Dish mon : danhSachMon) {
            itemPanel.add(createMonAnCard(mon)); // Sửa chỗ này dùng đúng hàm xử lý click
        }

        section.add(itemPanel, BorderLayout.CENTER);
        return section;
    }

    private JPanel createMonAnCard(Dish mon) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(200, 120));
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
        card.setOpaque(true);

        JLabel tenMon = new JLabel(mon.ten, SwingConstants.CENTER);
        tenMon.setFont(new Font("Arial", Font.BOLD, 18));
        tenMon.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));

        JLabel giaMon = new JLabel(mon.gia, SwingConstants.CENTER);
        giaMon.setFont(new Font("Arial", Font.PLAIN, 14));
        giaMon.setForeground(Color.DARK_GRAY);
        giaMon.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));

        card.add(tenMon, BorderLayout.NORTH);
        card.add(giaMon, BorderLayout.SOUTH);

        // Click để hiện dialog chi tiết
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showChiTietMonDialog(mon);
            }
        });

        return card;
    }

    private void showChiTietMonDialog(Dish mon) {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Chọn món - " + mon.ten, true);
        dialog.setSize(350, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel lblTen = new JLabel(mon.ten);
        lblTen.setFont(new Font("Arial", Font.BOLD, 20));
        lblTen.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblGia = new JLabel("Giá: " + mon.gia);
        lblGia.setFont(new Font("Arial", Font.PLAIN, 14));
        lblGia.setAlignmentX(Component.CENTER_ALIGNMENT);

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner spinner = new JSpinner(spinnerModel);
        JLabel lblSoLuong = new JLabel("Số lượng:");
        lblSoLuong.setFont(new Font("Arial", Font.PLAIN, 14));

        JTextArea txtGhiChu = new JTextArea(3, 20);
        txtGhiChu.setLineWrap(true);
        txtGhiChu.setWrapStyleWord(true);
        JScrollPane scrollGhiChu = new JScrollPane(txtGhiChu);
        scrollGhiChu.setBorder(BorderFactory.createTitledBorder("Ghi chú"));

        JButton btnThem = new JButton("Thêm món");
        btnThem.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnThem.addActionListener(e -> {
            int soLuong = (Integer) spinner.getValue();
            String ghiChu = txtGhiChu.getText();
            System.out.println("Đã chọn: " + mon.ten + " | SL: " + soLuong + " | Ghi chú: " + ghiChu);
            // TODO: Gửi dữ liệu đến đơn hàng
            dialog.dispose();
        });

        panel.add(lblTen);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(lblGia);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        panel.add(lblSoLuong);
        panel.add(spinner);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        panel.add(scrollGhiChu);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnThem);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }

    // Dữ liệu mẫu
    private ArrayList<Dish> getMonChinh() {
        ArrayList<Dish> list = new ArrayList<>();
        list.add(new Dish("Phở bò", "30.000đ"));
        list.add(new Dish("Cơm tấm", "35.000đ"));
        list.add(new Dish("Bún chả", "40.000đ"));
        return list;
    }

    private ArrayList<Dish> getMonPhu() {
        ArrayList<Dish> list = new ArrayList<>();
        list.add(new Dish("Bánh mì", "15.000đ"));
        list.add(new Dish("Chả giò", "20.000đ"));
        return list;
    }

    private ArrayList<Dish> getDoUong() {
        ArrayList<Dish> list = new ArrayList<>();
        list.add(new Dish("Trà đá", "5.000đ"));
        list.add(new Dish("Nước cam", "20.000đ"));
        return list;
    }
}

