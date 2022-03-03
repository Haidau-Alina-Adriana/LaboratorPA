package com.company;

public class LectureHall extends Room {

    private String operatingSystem;

    public LectureHall(String name, String type, int capacity, String operatingSystem) {
        super(name, type, capacity);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    void setType(String type) {
        this.type = type;
    }
}
