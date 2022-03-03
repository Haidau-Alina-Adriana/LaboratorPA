package com.company;

public class ComputerLab extends Room {

    private boolean hasProjector;

    public ComputerLab(String name, String type, int capacity, boolean hasProjector) {
        super(name, type, capacity);
        this.hasProjector = hasProjector;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    @Override
    void setType(String type) {
        this.type = type;
    }
}
