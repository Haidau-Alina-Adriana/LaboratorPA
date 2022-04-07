package com.company;

import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private int score;
    private boolean running;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        StringBuilder word = new StringBuilder();
        for (Tile tile : extracted) {
            word.append(tile.getLetter());
        }
        game.getBoard().addWord(this, word.toString());

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        submitWord();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", game=" + game +
                ", score=" + score +
                ", running=" + running +
                '}';
    }
}