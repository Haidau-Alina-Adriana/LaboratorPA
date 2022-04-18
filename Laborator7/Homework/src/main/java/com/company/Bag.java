package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> tiles;

    public Bag() {
        this.tiles = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            switch (c) {
                case 'a':
                case 'i':
                    for (int i = 0; i < 9; i++) {
                        this.tiles.add(new Tile(c, 1));
                    }
                    break;
                case 'b':
                case 'c':
                case 'm':
                case 'p':
                    for (int i = 0; i < 2; i++) {
                        this.tiles.add(new Tile(c, 3));
                    }
                    break;
                case 'd':
                    for (int i = 0; i < 4; i++) {
                        this.tiles.add(new Tile(c, 2));
                    }
                    break;
                case 'e':
                    for (int i = 0; i < 12; i++) {
                        this.tiles.add(new Tile(c, 1));
                    }
                    break;
                case 'f':
                case 'h':
                case 'v':
                case 'w':
                case 'y':
                    for (int i = 0; i < 2; i++) {
                        this.tiles.add(new Tile(c, 4));
                    }
                    break;
                case 'g':
                    for (int i = 0; i < 3; i++) {
                        this.tiles.add(new Tile(c, 2));
                    }
                    break;
                case 'j':
                case 'x':
                    this.tiles.add(new Tile(c, 8));
                    break;
                case 'k':
                    this.tiles.add(new Tile(c, 5));
                    break;
                case 'l':
                    this.tiles.add(new Tile(c, 1));
                    break;
                case 'n':
                case 'r':
                case 't':
                    for (int i = 0; i < 6; i++) {
                        this.tiles.add(new Tile(c, 1));
                    }
                    break;
                case 'o':
                    for (int i = 0; i < 8; i++) {
                        this.tiles.add(new Tile(c, 1));
                    }
                    break;
                case 'q':
                case 'z':
                    this.tiles.add(new Tile(c, 10));
                    break;
                case 's':
                case 'u':
                    for (int i = 0; i < 4; i++) {
                        this.tiles.add(new Tile(c, 1));
                    }
                    break;
                default:
                    break;
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