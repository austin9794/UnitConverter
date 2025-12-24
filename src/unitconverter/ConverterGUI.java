package unitconverter;

import java.awt.*;
import javax.swing.*;

public class ConverterGUI extends JFrame {

    private JComboBox<String> categoryBox;
    private JComboBox<String> conversionBox;
    private JTextField inputField;
    private JTextField outputField;

    public ConverterGUI() {
        setTitle("Unit Converter");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setTitle("Unit Converter");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center screen

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);

        JLabel titleLabel = new JLabel("Unit Converter", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(new Color(40, 40, 40));

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        mainPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBackground(Color.WHITE);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(labelFont);

        JLabel conversionLabel = new JLabel("Conversion:");
        conversionLabel.setFont(labelFont);

        JLabel valueLabel = new JLabel("Value:");
        valueLabel.setFont(labelFont);

        inputPanel.add(categoryLabel);
        inputPanel.add(categoryBox);

        inputPanel.add(conversionLabel);
        inputPanel.add(conversionBox);

        inputPanel.add(valueLabel);
        inputPanel.add(inputField);

        inputPanel.add(new JLabel()); // spacer
        inputPanel.add(convertButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        convertButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        convertButton.setBackground(new Color(33, 150, 243)); // blue
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);

        convertButton.addMouseListener(new MouseAdapter() {
    public void mouseEntered(MouseEvent e) {
        convertButton.setBackground(new Color(30, 136, 229));
    }

    public void mouseExited(MouseEvent e) {
        convertButton.setBackground(new Color(33, 150, 243));
    }
});

resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
resultLabel.setForeground(new Color(0, 128, 0));
resultLabel.setHorizontalAlignment(SwingConstants.CENTER);




