package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board(new ArrayList<>(), this);
    public static final MockDictionary dictionary = new MockDictionary("dictionary.txt");
    private final List<Player> players = new ArrayList<>();
    private static int index = 0;
    public static int turn = 0;
    private final static DaemonThread daemonThread = new DaemonThread();

    public void addPlayer(Player player) {
        players.add(player);
        player.setIndex(index);
        index++;
        player.setGame(this);
    }

    public void play() {
        daemonThread.setDaemon(true);
        daemonThread.setRunning(true);
        daemonThread.start();

        while (bag.getTiles().size() != 0) {
            new Thread(players.get(0)).start();
            new Thread(players.get(1)).start();
            new Thread(players.get(2)).start();
            if (bag.getTiles().size() == 0) {
                daemonThread.setEndTime(new Date());
                break;
            }
        }
    }

    public void stopDaemonThread() {
        daemonThread.setRunning(false);
    }

    public double getGameDuration() {
        return daemonThread.getDuration();
    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public static Dictionary getDictionary() {
        return dictionary;
    }

    @Override
    public String toString() {
        return "Game{" +
                "bag=" + bag +
                ", board=" + board +
                ", dictionary=" + dictionary +
                ", players=" + players +
                ", turn=" + turn +
                '}';
    }
}
