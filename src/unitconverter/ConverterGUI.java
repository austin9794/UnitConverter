package unitconverter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConverterGUI extends JFrame {

    private JComboBox<String> categoryBox;
    private JComboBox<String> conversionBox;
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton convertButton;

    public ConverterGUI() {

        private void updateConversionOptions() {
        conversionBox.removeAllItems();

        String category = (String) categoryBox.getSelectedItem();


        // Frame setup
        setTitle("Unit Converter");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);

        // Title
        JLabel titleLabel = new JLabel("Unit Converter", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(new Color(40, 40, 40));

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.WHITE);
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // Initialise components
        categoryBox = new JComboBox<>(new String[]{"Temperature", "Weight", "Length"});
        conversionBox = new JComboBox<>();
        inputField = new JTextField();
        convertButton = new JButton("Convert");
        resultLabel = new JLabel(" ", SwingConstants.CENTER);

        // Input panel
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

        // Button styling
        convertButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        convertButton.setBackground(new Color(33, 150, 243));
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

        // Result panel
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resultLabel.setForeground(new Color(0, 128, 0));

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBackground(Color.WHITE);
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
