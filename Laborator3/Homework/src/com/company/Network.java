package com.company;

import java.util.*;

public class Network {
    private List<Node> nodes;

    public Network() {
        this.nodes = new ArrayList<>();
    }

    public Network(List<Node> nodes) {
        this.nodes = new ArrayList<>();
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        for (Node n : nodes) {
            if (n.getName() == node.getName()) {
                System.out.println("Node " + node.getName() + " already exists!");
                return;
            }
        }
        this.nodes.add(node);
    }

    public void displayNetwork() {
        System.out.println("The network:\nFrom - To : Cost");
        for (int i = 0, n = nodes.size(); i < n; i++) {
            Map<Node, Integer> nodeCosts = new HashMap<>(nodes.get(i).getCost());
            if (nodeCosts.size() == 0) {
                System.out.println();
            } else {
                for (Map.Entry<Node, Integer> entry : nodeCosts.entrySet()) {
                    System.out.print("v" + (i + 1) + " -- ");
                    for (int j = 0, m = nodes.size(); j < m; j++) {
                        if (nodes.get(j).getName() == entry.getKey().getName()) {
                            System.out.println("v" + (j + 1) + " : " + entry.getValue());
                            break;
                        }
                    }
                }
            }
        }

    }

    public void displayIdentifiableNodes() {
        List<Node> identifiableNodes = new ArrayList<>();
        for (int i = 0, n = nodes.size(); i < n; i++) {
            if (nodes.get(i) instanceof Identifiable) {
                identifiableNodes.add(nodes.get(i));
            }
        }
        Collections.sort(identifiableNodes, Node::compareByHardwareAddress);
        System.out.println("Identifiable nodes in network: ");
        for (Node node : identifiableNodes) {
            System.out.println(node.getName());
        }
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}
