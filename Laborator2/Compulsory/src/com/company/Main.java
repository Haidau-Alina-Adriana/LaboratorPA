package com.company;

public class Main {

    public static void main(String[] args) {
        Event e1 = new Event("C1", 100, 8, 10);
        Event e2 = new Event("C2", 100, 10, 12);
        Event e3 = new Event("L1", 30, 8, 10);
        Event e4 = new Event("L2", 30, 8, 10);
        Event e5 = new Event("L3", 30, 10, 12);

        Room r1 = new Room("401", RoomType.COMPUTER_LAB, 30);
        Room r2 = new Room("403", RoomType.COMPUTER_LAB, 30);
        Room r3 = new Room("405", RoomType.COMPUTER_LAB, 30);
        Room r4 = new Room("309", RoomType.LECTURE_HALL, 100);

        System.out.println("Event 1: " + e1.toString());
        System.out.println("Event 2: " + e2.toString());
        System.out.println("Event 3: " + e3.toString());
        System.out.println("Event 4: " + e4.toString());
        System.out.println("Event 5: " + e5.toString());

        System.out.println("Room 1: " + r1.toString());
        System.out.println("Room 2: " + r2.toString());
        System.out.println("Room 3: " + r3.toString());
        System.out.println("Room 4: " + r4.toString());

    }
}
