package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag(10);
    private final Board board = new Board(new ArrayList<>());
    private final Dictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    private int turn = 0;

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "Game{" +
                "bag=" + bag +
                ", players=" + players +
                '}';
    }
}
