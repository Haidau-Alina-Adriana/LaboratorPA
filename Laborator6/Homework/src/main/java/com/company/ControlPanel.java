package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private final JButton loadButton = new JButton("Load");
    private final JButton saveButton = new JButton("Save");
    private final JButton exportButton = new JButton("Export");
    private final JButton exitButton = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(loadButton);
        add(saveButton);
        add(exportButton);
        add(exitButton);
        setLayout(new GridLayout(1, 3));
        loadButton.addActionListener(this::loadGame);
        saveButton.addActionListener(this::saveGame);
        exportButton.addActionListener(this::exportGame);
        exitButton.addActionListener(this::exitGame);
    }

    private void loadGame(ActionEvent e) {
        Game game;
        try {
            ObjectMapper mapper = new ObjectMapper();
            game = new ObjectMapper().readValue(new File("savedGame.json"), Game.class);
            System.out.println(game.toString());
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    private void saveGame(ActionEvent e) {
        Game game = frame.canvas.getCurrentGame();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("savedGame.json"), game);
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    private void exportGame(ActionEvent e) {
        BufferedImage image = frame.canvas.getCurrentState();
        try {
            ImageIO.write(image, "png", new File("drawing.png"));
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}