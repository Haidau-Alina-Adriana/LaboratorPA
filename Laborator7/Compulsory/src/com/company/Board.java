package com.company;

import java.util.List;

public class Board {
    private final List<String> words;

    public Board(List<String> words) {
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }

    public synchronized void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    @Override
    public String toString() {
        return words.toString();
    }


}
