package GUI;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(new BorderLayout());

        JLabel greeting = new JLabel("👋 Xin chào, Bách!");
        greeting.setFont(new Font("Arial", Font.BOLD, 24));
        greeting.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));

        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(1, 3, 20, 20));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        statsPanel.setBackground(new Color(240, 240, 240));

        statsPanel.add(createStatCard("🍽 Món ăn", "25"));
        statsPanel.add(createStatCard("🧾 Hóa đơn", "12"));
        statsPanel.add(createStatCard("💰 Doanh thu", "2,300,000đ"));

        add(greeting, BorderLayout.NORTH);
        add(statsPanel, BorderLayout.CENTER);
    }

    private JPanel createStatCard(String title, String value) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(150, 100));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel labelTitle = new JLabel(title);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 16));
        labelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelValue = new JLabel(value);
        labelValue.setFont(new Font("Arial", Font.PLAIN, 20));
        labelValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(Box.createVerticalStrut(15));
        card.add(labelTitle);
        card.add(Box.createVerticalStrut(10));
        card.add(labelValue);

        return card;
    }
}

