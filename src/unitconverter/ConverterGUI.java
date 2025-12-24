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

