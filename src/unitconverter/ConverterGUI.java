package unitconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ConverterGUI extends JFrame {

    private JComboBox<String> categoryBox;
    private JComboBox<String> conversionBox;
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton historyButton;
    private JButton convertButton;

    private ArrayList<String> history = new ArrayList<>();
    private DefaultListModel<String> historyModel = new DefaultListModel<>();

    public ConverterGUI() {
        setTitle("Unit Converter");
        setSize(450, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(buildHeader(), BorderLayout.NORTH);
        add(buildForm(), BorderLayout.CENTER);
        add(buildResult(), BorderLayout.SOUTH);

        setVisible(true);
    }

    /* ---------------- HEADER ---------------- */

    private JPanel buildHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(10, 15, 0, 15));

        JLabel title = new JLabel("Unit Converter");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));

        historyButton = new JButton("History");
        historyButton.addActionListener(e -> showHistoryDialog());

        header.add(title, BorderLayout.WEST);
        header.add(historyButton, BorderLayout.EAST);

        return header;
    }

    /* ---------------- FORM ---------------- */

    private JPanel buildForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        categoryBox = new JComboBox<>(new String[]{"Temperature", "Weight", "Length"});
        conversionBox = new JComboBox<>();
        inputField = new JTextField();

        updateConversions();
        categoryBox.addActionListener(e -> updateConversions());

        convertButton = new JButton("Convert");
        convertButton.addActionListener(e -> performConversion());

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        panel.add(categoryBox, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Conversion:"), gbc);
        gbc.gridx = 1;
        panel.add(conversionBox, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Value:"), gbc);
        gbc.gridx = 1;
        panel.add(inputField, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(convertButton, gbc);

        return panel;
    }

    /* ---------------- RESULT ---------------- */

    private JPanel buildResult() {
        JPanel panel = new JPanel();
        resultLabel = new JLabel(" ");
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resultLabel.setForeground(new Color(0, 128, 0));
        panel.add(resultLabel);
        return panel;
    }

    /* ---------------- LOGIC ---------------- */

    private void updateConversions() {
        conversionBox.removeAllItems();
        String category = (String) categoryBox.getSelectedItem();

        if (category.equals("Temperature")) {
            conversionBox.addItem("Celsius → Fahrenheit");
            conversionBox.addItem("Fahrenheit → Celsius");
        } else if (category.equals("Weight")) {
            conversionBox.addItem("Kg → Lb");
            conversionBox.addItem("Lb → Kg");
        } else {
            conversionBox.addItem("Meters → Feet");
            conversionBox.addItem("Feet → Meters");
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
                case "Meters → Feet":
                    result = LengthConverter.metersToFeet(input);
                    break;
                case "Feet → Meters":
                    result = LengthConverter.feetToMeters(input);
                    break;
            }

            String record = input + " → " + result;
            history.add(record);
            historyModel.addElement(record);

            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid number.");
        }
    }

    private void clearFields() {
    inputField.setText("");
    outputField.setText("");
    resultLabel.setText("Result:");

categoryBox.addActionListener(e -> {
    updateConversions();   // existing method you already have
    clearFields();
});





    /* ---------------- HISTORY DIALOG ---------------- */

    private void showHistoryDialog() {
        JDialog dialog = new JDialog(this, "Conversion History", true);
        dialog.setSize(300, 350);
        dialog.setLocationRelativeTo(this);

        JList<String> list = new JList<>(historyModel);
        JScrollPane scroll = new JScrollPane(list);

        JButton clear = new JButton("Clear");
        clear.addActionListener(e -> {
            history.clear();
            historyModel.clear();
        });

        JButton close = new JButton("Close");
        close.addActionListener(e -> dialog.dispose());

        JPanel buttons = new JPanel();
        buttons.add(clear);
        buttons.add(close);

        dialog.add(scroll, BorderLayout.CENTER);
        dialog.add(buttons, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
}

