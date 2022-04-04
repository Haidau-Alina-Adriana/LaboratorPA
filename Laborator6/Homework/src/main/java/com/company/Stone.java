package com.company;

public class Stone implements Comparable<Stone>{
    private int index;
    private int x, y;

    public Stone() {
    }

    public Stone(int index, int x, int y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Stone{" +
                "index=" + index +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
    @Override
    public int compareTo(Stone stone) {
        return (int)(this.index - stone.getIndex());
    }
}
