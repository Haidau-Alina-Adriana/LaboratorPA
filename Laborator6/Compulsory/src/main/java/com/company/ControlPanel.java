package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private final JButton loadButton = new JButton("Load");
    private final JButton saveButton = new JButton("Save");
    private final JButton exitButton = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(loadButton);
        add(saveButton);
        add(exitButton);
        setLayout(new GridLayout(1, 3));
        loadButton.addActionListener(this::loadGame);
        saveButton.addActionListener(this::saveGame);
        exitButton.addActionListener(this::exitGame);
    }

    private void loadGame(ActionEvent e) {
    }

    private void saveGame(ActionEvent e) {
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}