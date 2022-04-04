package com.company;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Board {

    private Map<Stone, List<Stone>> edges;

    public Board() {
    }

    public Board(Map<Stone, List<Stone>> edges) {
        this.edges = new TreeMap<>();
        this.edges = edges;
    }

    public Map<Stone, List<Stone>> getEdges() {
        return edges;
    }

    public void setEdges(Map<Stone, List<Stone>> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Board{" +
                "edges=" + edges +
                '}';
    }
}
