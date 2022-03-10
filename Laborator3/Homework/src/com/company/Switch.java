package com.company;

public class Switch extends Node implements Identifiable {
    private String address;
    private int layer;

    public Switch(String address, int layer) {
        this.layer = layer;
        this.address = address;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "layer=" + layer +
                '}';
    }
}
