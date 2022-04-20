package com.company;

import java.util.List;
import java.util.Scanner;

public class Player implements Runnable {
    private final String name;
    private Game game;
    private int score;
    private int index;
    public boolean running = true;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    private synchronized boolean submitWord() {
        while ((Game.turn % game.getPlayers().size()) != this.index && game.getBag().getTiles().size() > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<Tile> extracted = game.getBag().extractTiles(7);
        notifyAll();

        if (extracted.isEmpty()) {
            setRunning(false);
            game.stopDaemonThread();
            return false;
        }
        StringBuilder word = new StringBuilder();
        for (Tile tile : extracted) {
            word.append(tile.getLetter());
        }
        String wordCreatedByThread = Game.dictionary.createWordFromRandomLetters(word.toString());
        score += game.getBoard().addWord(this, wordCreatedByThread);

//        String wordCreatedByUser = getWordFromUser(word.toString(), index);
//        score += game.getBoard().addWord(this, wordCreatedByUser);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return true;
    }

    public String getWordFromUser(String word, int index) {
        Scanner input = new Scanner(System.in);
        System.out.println("Player " + index + "'s turn.\n" + "Available letters: ");
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.charAt(i) + " ");
        }
        System.out.print("\nWord: ");
        String wordCreatedByUser = input.next();
        return wordCreatedByUser;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setGame(Game game) {
        this.game = game;
    }


    @Override
    public void run() {
        while (running) {
            if (game.getBag().getTiles().size() == 0) {
                break;
            }
            submitWord();
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", game=" + game +
                ", score=" + score +
                ", index=" + index +
                '}';
    }
}