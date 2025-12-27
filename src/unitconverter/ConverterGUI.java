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