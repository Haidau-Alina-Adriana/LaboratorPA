package com.company;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    private JLabel label;
    private JSpinner width;
    private JSpinner height;
    private final JButton createBtn = new JButton("Create");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        this.label = new JLabel("Grid size:");
        width = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        height = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        add(label);
        add(width);
        add(height);
        add(createBtn);
    }


}