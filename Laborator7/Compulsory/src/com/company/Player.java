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
//        System.out.println("Extracted tiles: " + extracted);
        if (extracted.isEmpty()) {
            return false;
        }
        StringBuilder word = new StringBuilder();
        for(Tile tile :  extracted){
            word.append(tile.getLetter());
        }
        game.getBoard().addWord(this, word.toString());
//        System.out.println("");
//        make the player sleep 50 ms;
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