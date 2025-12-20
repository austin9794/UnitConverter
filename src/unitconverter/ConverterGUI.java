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

        

