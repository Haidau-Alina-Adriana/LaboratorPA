package com.company;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.*;

public class Game implements Serializable {
    private Board board;
    private List<Player> players;
    private Map<Stone, Player> positions;

    public Game() {
    }

    public Game(Board board) {
        this.board = board;
        this.positions = new TreeMap<>();
        for (Stone stone : board.getEdges().keySet()) {
            positions.put(stone, null);
        }
    }

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = new ArrayList<>();
        this.players = players;
        this.positions = new TreeMap<>();
        for (Stone stone : board.getEdges().keySet()) {
            positions.put(stone, null);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Map<Stone, Player> getPositions() {
        return positions;
    }

    public void setPositions(Map<Stone, Player> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
                ", players=" + players +
                ", positions=" + positions +
                '}';
    }
}
