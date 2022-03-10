package com.company;

public class Switch extends Node {
    private int layer;

    public Switch() {
        this.layer = 2;
    }

    public Switch(int layer) {
        this.layer = layer;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "layer=" + layer +
                '}';
    }
}
