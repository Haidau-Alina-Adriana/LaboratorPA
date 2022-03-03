package com.company;

public class Main {

    public static void main(String[] args) {
        Problem pb = new Problem();
        Event e1 = new Event("C1", 100, 8, 10);
        Event e2 = new Event("C2", 100, 10, 12);
        Event e3 = new Event("L1", 30, 8, 10);
        Event e4 = new Event("L2", 30, 8, 10);
        Event e5 = new Event("L3", 30, 10, 12);
//        Event e6 = new Event("L3", 30, 10, 12);

        ComputerLab r1 = new ComputerLab("401","ComputerLab", 30, true);
        ComputerLab r2 = new ComputerLab("403", "ComputerLab", 30, true);
        ComputerLab r3 = new ComputerLab("405", "ComputerLab", 30, false);
        LectureHall r4 = new LectureHall("309", "LectureHall", 100, "Windows 10");

        pb.addEvent(e1);
        pb.addEvent(e2);
        pb.addEvent(e3);
        pb.addEvent(e4);
        pb.addEvent(e5);
//        pb.addEvent(e6);

        pb.addRoom(r1);
        pb.addRoom(r2);
        pb.addRoom(r3);
        pb.addRoom(r4);

//        System.out.println(pb.toString());

        Solution sol = new Solution();
        sol.computeSolution(pb);
    }
}
