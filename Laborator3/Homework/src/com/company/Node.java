package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String name;
    private String hardwareAddress;
    private String location;
    private Map<Node, Integer> cost;


    public Node() {
        this.name = "";
        this.hardwareAddress = "";
        this.location = "";
        this.cost = new HashMap<>();

    }

    public Node(String name, String hardwareAddress, String location, HashMap<Node, Integer> cost) {
        this.name = name;
        this.hardwareAddress = hardwareAddress;
        this.location = location;
        this.cost = new HashMap<>();
        this.cost = cost;
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

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<Node, Integer> cost) {
        this.cost = cost;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", hardwareAddress='" + hardwareAddress + '\'' +
                ", location='" + location + '\'' +
                ", cost=" + cost +
                '}';
    }

    public static int compareByHardwareAddress(Node first, Node second) {
        if (first.getHardwareAddress() != null && second.getHardwareAddress() != null)
            return first.hardwareAddress.compareTo(second.hardwareAddress);
        else {
            System.out.println("Null hardware address!");
            return 0;
        }
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
