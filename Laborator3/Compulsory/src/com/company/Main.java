package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Computer v1 = new Computer("", 16);
        Router v2 = new Router("");
        Switch v3 = new Switch(true);
        Switch v4 = new Switch(false);
        Router v5 = new Router("");
        Computer v6 = new Computer("", 32);

        v1.setName("Computer A");
        v2.setName("Router A");
        v3.setName("Switch A");
        v4.setName("Switch B");
        v5.setName("Router B");
        v6.setName("Computer B");

        List<Node> networkNodes = new ArrayList<>();
        networkNodes.add(v1);
        networkNodes.add(v2);
        networkNodes.add(v3);
        networkNodes.add(v4);
        networkNodes.add(v5);
        networkNodes.add(v6);

        Network network = new Network(networkNodes);
        for (int i = 0, n = network.getNodes().size(); i < n; i++) {
            System.out.println("Node " + i + " : " + networkNodes.get(i).getName());
        }

    }
}
