package com.company;

public class Main {

    public static void main(String[] args) {
        Computer v1 = new Computer("", 16);
        Router v2 = new Router("");
        Switch v3 = new Switch("", 2);
        Switch v4 = new Switch("", 3);
        Router v5 = new Router("");
        Computer v6 = new Computer("", 32);

        v1.setName("Computer A");
        v1.setHardwareAddress("00-0C-27-00-00-05");
        v1.setCost(v2, 10);
        v1.setCost(v3, 50);

        v2.setName("Router A");
        v2.setHardwareAddress("00-0A-29-6C-F3-E5");
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);

        v3.setName("Switch A");
        v3.setHardwareAddress("00-FF-71-B3-E4-48");
        v3.setCost(v4, 20);

        v4.setName("Switch B");
        v4.setHardwareAddress("00-0B-07-B2-05-E3");
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);

        v5.setName("Router B");
        v5.setHardwareAddress("FC-E1-E3-BA-92-E9");
        v5.setCost(v6, 20);

        v6.setName("Computer B");
        v6.setHardwareAddress("FA-E4-E3-BA-92-E8");


        Network network = new Network();
        network.addNode(v1);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v4);
        network.addNode(v5);
        network.addNode(v6);

        network.displayNetwork();
        network.displayIdentifiableNodes();

    }
}
