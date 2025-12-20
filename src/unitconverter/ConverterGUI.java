package unitconverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterGUI {

    private JFrame frame;
    private JTextField inputField;
    private JLabel resultLabel;
    private JComboBox<String> conversionBox;

    public ConverterGUI() {
        frame = new JFrame("Unit Converter");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel title = new JLabel("Select Conversion:");
        title.setBounds(20, 20, 150, 25);
        frame.add(title);

        conversionBox = new JComboBox<>(new String[]{
                "Celsius → Fahrenheit",
                "Fahrenheit → Celsius",
                "Kilograms → Pounds",
                "Pounds → Kilograms"
        });
        conversionBox.setBounds(180, 20, 180, 25);
        frame.add(conversionBox);

