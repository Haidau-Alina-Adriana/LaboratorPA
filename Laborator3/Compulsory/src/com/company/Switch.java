package com.company;

public class Switch extends Node {
    private boolean managed;

    public Switch() {
        this.managed = true;
    }

    public Switch(boolean managed) {
        this.managed = managed;
    }

    public boolean isManaged() {
        return managed;
    }

    public void setManaged(boolean managed) {
        this.managed = managed;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "managed=" + managed +
                '}';
    }
}
