package com.company;

public abstract class Node implements Comparable<Node> {
    private String name;
    private String hardwareAddress;
    private String location;

    public Node() {
        this.name = "";
        this.hardwareAddress = "";
        this.location = "";
    }

    public Node(String name, String hardwareAddress, String location) {
        this.name = name;
        this.hardwareAddress = hardwareAddress;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHardwareAddress() {
        return hardwareAddress;
    }

    public void setHardwareAddress(String hardwareAddress) {
        this.hardwareAddress = hardwareAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", hardwareAddress='" + hardwareAddress + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public int compareTo(Node other) {
        if (this.getName() != null && other.getName() != null)
            return this.name.compareTo(other.name);
        else {
            System.out.println("Null name!");
            return 0;
        }
    }

}
