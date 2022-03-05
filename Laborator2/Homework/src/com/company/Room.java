package com.company;

public abstract class Room {

    private String name;
    protected String type;
    private int capacity;

    /**
     * Constructor cu toti parametrii
     *
     * @param name     numele salii
     * @param type     tipul salii
     * @param capacity capacitatea salii
     */
    public Room(String name, String type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room(" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", capacity=" + capacity +
                ')';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Room)) {
            return false;
        }
        if (this == obj) return true;
        Room other = (Room) obj;
        return name.equals(other.name);
    }

}
