package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    private JLabel label;
    private JSpinner width;
    private JSpinner height;
    private final JButton createButton = new JButton("Create");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        this.label = new JLabel("Grid size:");
        height = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        width = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        add(label);
        add(height);
        add(width);
        add(createButton);
        createButton.addActionListener(this::createGame);
    }

    public int getRows(){
        return (int) height.getValue();
    }

    public int getCols(){
        return (int) width.getValue();
    }

    private void createGame(ActionEvent e) {
        frame.canvas.setRows((int)this.height.getValue());
        frame.canvas.setCols((int)this.width.getValue());
        frame.canvas.callInit();
    }


}