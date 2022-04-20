package com.company;

import java.util.List;

public class Board {
    private final List<String> words;
    private final Bag bag = new Bag();
    private Game game;

    public Board(List<String> words, Game game) {
        this.words = words;
        this.game = game;
    }

    public List<String> getWords() {
        return words;
    }

    public synchronized int addWord(Player player, String word) {

        while ((Game.turn % game.getPlayers().size()) != player.getIndex() && bag.getTiles().size() > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int obtainedScore = 0;
        if (Game.getDictionary().isWord(word)) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                for (Tile t : bag.getTiles()) {
                    if (t.getLetter() == letter) {
                        obtainedScore += t.getPoints();
                        break;
                    }
                }
            }
            obtainedScore *= word.length();
            words.add(word);
            System.out.println("Player " + player.getIndex() + " added word: " + word + " to the table, and gained "
                    + obtainedScore + " points.");
        } else {
            System.out.println("Not a valid word!");
        }

        Game.turn++;
        notifyAll();
        return obtainedScore;
    }

    @Override
    public String toString() {
        return words.toString();
    }


}
