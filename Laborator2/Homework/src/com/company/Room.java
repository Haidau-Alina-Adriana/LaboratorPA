package com.company;

public abstract class Room {

    private String name;
    private int capacity;

    /**
     * Constructor cu toti parametrii
     *
     * @param name     numele salii
     * @param capacity capacitatea salii
     */
    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
