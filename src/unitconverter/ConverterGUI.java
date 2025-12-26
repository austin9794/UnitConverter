package unitconverter;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;



public class ConverterGUI extends JFrame {

    private JComboBox<String> categoryBox;
    private JComboBox<String> conversionBox;
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton convertButton;
    private ArrayList<String> history;
    private DefaultListModel<String> historyModel;
    private JList<String> historyList;
    private JButton historyButton;


    public ConverterGUI() {
        // Window setup
        setTitle("Unit Converter");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);

        // ===== Title =====
        JLabel titleLabel = new JLabel("Unit Converter", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(new Color(40, 40, 40));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // ===== Input Panel =====
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBackground(Color.WHITE);
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(labelFont);

        JLabel conversionLabel = new JLabel("Conversion:");
        conversionLabel.setFont(labelFont);

        JLabel valueLabel = new JLabel("Value:");
        valueLabel.setFont(labelFont);

        categoryBox = new JComboBox<>(new String[]{"Temperature", "Weight", "Length"});
        conversionBox = new JComboBox<>();

        inputField = new JTextField();
        convertButton = new JButton("Convert");

        inputPanel.add(categoryLabel);
        inputPanel.add(categoryBox);
        inputPanel.add(conversionLabel);
        inputPanel.add(conversionBox);
        inputPanel.add(valueLabel);
        inputPanel.add(inputField);
        inputPanel.add(new JLabel());
        inputPanel.add(convertButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel historyPanel = new JPanel(new BorderLayout(5, 5));
        historyPanel.setPreferredSize(new Dimension(160, 0));
        historyPanel.setBackground(Color.WHITE);

        JLabel historyTitle = new JLabel("History", SwingConstants.CENTER);
        historyTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane historyScroll = new JScrollPane(historyList);

        JButton clearHistoryButton = new JButton("Clear");
        clearHistoryButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));

       clearHistoryButton.addActionListener(e -> {
           history.clear();
           historyModel.clear();
        });

        historyPanel.add(historyTitle, BorderLayout.NORTH);
        historyPanel.add(historyScroll, BorderLayout.CENTER);
        historyPanel.add(clearHistoryButton, BorderLayout.SOUTH);

        mainPanel.add(historyPanel, BorderLayout.EAST);

        // ===== Button Styling =====
        convertButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        convertButton.setBackground(new Color(33, 150, 243));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);

        historyButton = new JButton("History");
        historyButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));


        convertButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                convertButton.setBackground(new Color(30, 136, 229));
            }

            public void mouseExited(MouseEvent e) {
                convertButton.setBackground(new Color(33, 150, 243));
            }
        });

        // ===== Result =====
        resultLabel = new JLabel("Result:", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resultLabel.setForeground(new Color(0, 128, 0));

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBackground(Color.WHITE);
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        // ===== Logic =====
        updateConversionOptions();
        categoryBox.addActionListener(e -> updateConversionOptions());
        convertButton.addActionListener(e -> performConversion());

        history = new ArrayList<>();
        historyModel = new DefaultListModel<>();
        historyList = new JList<>(historyModel);
        historyList.setFont(new Font("Segoe UI", Font.PLAIN, 12));


        setVisible(true);
    }

    // ================= Conversion Options =================
    private void updateConversionOptions() {
        conversionBox.removeAllItems();
        String category = (String) categoryBox.getSelectedItem();

        if (category.equals("Temperature")) {
            conversionBox.addItem("Celsius → Fahrenheit");
            conversionBox.addItem("Fahrenheit → Celsius");
        } 
        else if (category.equals("Weight")) {
            conversionBox.addItem("Kilograms → Pounds");
            conversionBox.addItem("Pounds → Kilograms");
        } 
        else if (category.equals("Length")) {
            conversionBox.addItem("Meters → Kilometers");
            conversionBox.addItem("Kilometers → Meters");
            conversionBox.addItem("Centimeters → Meters");
            conversionBox.addItem("Meters → Centimeters");
        }
    }

    // ================= Perform Conversion =================
    private void performConversion() {
        try {
            double input = Double.parseDouble(inputField.getText());
            String category = (String) categoryBox.getSelectedItem();
            String conversion = (String) conversionBox.getSelectedItem();
            double result = 0;

            switch (category) {
                case "Temperature":
                    if (conversion.equals("Celsius → Fahrenheit")) {
                        result = TemperatureConverter.celsiusToFahrenheit(input);
                    } else {
                        result = TemperatureConverter.fahrenheitToCelsius(input);
                    }
                    break;

                case "Weight":
                    if (conversion.equals("Kilograms → Pounds")) {
                        result = WeightConverter.kgToLb(input);
                    } else {
                        result = WeightConverter.lbToKg(input);
                    }
                    break;

                case "Length":
                    if (conversion.equals("Meters → Kilometers")) {
                        result = LengthConverter.metersToKilometers(input);
                    } 
                    else if (conversion.equals("Kilometers → Meters")) {
                        result = LengthConverter.kilometersToMeters(input);
                    } 
                    else if (conversion.equals("Centimeters → Meters")) {
                        result = LengthConverter.centimetersToMeters(input);
                    } 
                    else if (conversion.equals("Meters → Centimeters")) {
                        result = LengthConverter.metersToCentimeters(input);
                    }
                    break;
            }

            String record = input + " → " + result;
            resultLabel.setText("Result: " + result);

            history.add(record);
            historyModel.addElement(record);


        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid number.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
