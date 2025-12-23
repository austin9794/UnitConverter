package unitconverter;

import javax.swing.*;
import java.awt.*;

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

        setLayout(new BorderLayout(10, 10));

        // ===== TOP PANEL =====
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        categoryBox = new JComboBox<>(new String[]{"Temperature", "Weight"});
        conversionBox = new JComboBox<>();

        updateConversions();

        categoryBox.addActionListener(e -> updateConversions());

        topPanel.add(new JLabel("Conversion Type:"));
        topPanel.add(categoryBox);
        topPanel.add(new JLabel("Conversion:"));
        topPanel.add(conversionBox);

        // ===== CENTER PANEL =====
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        inputField = new JTextField();
        outputField = new JTextField();
        outputField.setEditable(false);

        centerPanel.add(new JLabel("Input Value:"));
        centerPanel.add(inputField);
        centerPanel.add(new JLabel("Output Value:"));
        centerPanel.add(outputField);

        // ===== BUTTON =====
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(e -> performConversion());

        // ===== ADD PANELS =====
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(convertButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateConversions() {
        conversionBox.removeAllItems();

        if (categoryBox.getSelectedItem().equals("Temperature")) {
            conversionBox.addItem("Celsius → Fahrenheit");
            conversionBox.addItem("Fahrenheit → Celsius");
        } else {
            conversionBox.addItem("Kg → Lb");
            conversionBox.addItem("Lb → Kg");
        }
    }

    private void performConversion() {
        try {
            double input = Double.parseDouble(inputField.getText());
            String conversion = (String) conversionBox.getSelectedItem();

            double result = 0;

            switch (conversion) {
                case "Celsius → Fahrenheit":
                    result = TemperatureConverter.celsiusToFahrenheit(input);
                    break;
                case "Fahrenheit → Celsius":
                    result = TemperatureConverter.fahrenheitToCelsius(input);
                    break;
                case "Kg → Lb":
                    result = WeightConverter.kgToLb(input);
                    break;
                case "Lb → Kg":
                    result = WeightConverter.lbToKg(input);
                    break;    
            }

            outputField.setText(String.valueOf(result));

            } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid number.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );




