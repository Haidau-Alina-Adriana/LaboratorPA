package com.company;

import java.util.*;

public class Algorithm {
    private Map<Node, Integer> times;

    public Algorithm(Network network, Node startingPoint) {
        this.times = new HashMap<>();
        for (int i = 0, n = network.getNodes().size(); i < n; i++) {
            if (network.getNodes().get(i).equals(startingPoint)) {
                times.put(network.getNodes().get(i), 0);
            } else {
                times.put(network.getNodes().get(i), Integer.MAX_VALUE);
            }
        }
    }

    public Map<Node, Integer> getTimes() {
        return times;
    }

    public void getShortestTimes(Network network, Node startingPoint) {
        List<Node> identifiableNetNodes = new LinkedList<>(network.getNodes());
        List<Node> visitedNodes = new ArrayList<>();
        List<Node> unvisitedNodes = new LinkedList<>(identifiableNetNodes);

        for (int i = 0; i < unvisitedNodes.size(); i++) {
            int smallerTime = Integer.MAX_VALUE;
            Node currentNode = unvisitedNodes.get(i);
            for (Map.Entry<Node, Integer> entry : times.entrySet()) {
                if (entry.getValue() < smallerTime && !visitedNodes.contains(entry.getKey())) {
                    smallerTime = entry.getValue();
                    currentNode = entry.getKey();
                }
            }
            Map<Node, Integer> costs = new HashMap<>(currentNode.getCost());
            for (Map.Entry<Node, Integer> iterator : costs.entrySet()) {
                int newTime = times.get(currentNode) + iterator.getValue();
                if (newTime < times.get(iterator.getKey())) {
                    times.replace(iterator.getKey(), newTime);
                }
            }
            visitedNodes.add(currentNode);
        }
        for (Map.Entry<Node, Integer> n : times.entrySet()) {
            System.out.println("De la: " + startingPoint.getName() + " la " + n.getKey().getName() + "     " + " = " + n.getValue());
        }
    }

    @Override
    public String toString() {
        return "Algorithm{" +
                "times=" + times +
                '}';
    }
}
