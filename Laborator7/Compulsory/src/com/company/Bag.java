package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> tiles;

    public Bag(int numberOfSameTile) {
        this.tiles = new ArrayList<>();
        Random randomNumberOfPoints = new Random();
        for (char c = 'a'; c < 'z'; c++) {
            int result = randomNumberOfPoints.nextInt(50);
            for (int i = 0; i < numberOfSameTile; i++) {
                this.tiles.add(new Tile(c, result));
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        Random randomTile = new Random();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            int result = randomTile.nextInt(tiles.size());
            extracted.add(tiles.get(result));
            tiles.remove(tiles.get(result));
        }
        return extracted;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "tiles=" + tiles +
                '}';
    }
}