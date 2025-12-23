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




