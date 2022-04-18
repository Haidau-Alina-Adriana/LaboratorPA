package com.company;

public class Continent {
    private static int index = 1;
    private int id;
    private String name;

    public Continent() {
    }

    public Continent(String name) {
        this.id = index;
        this.name = name;
        index++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
