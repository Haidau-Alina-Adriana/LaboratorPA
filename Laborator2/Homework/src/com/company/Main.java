package com.company;

/**
 * @author Haidau Alina-Adriana
 */

public class Main {

    public static void main(String[] args) {

        Problem problem = new Problem();
        Event e1 = new Event("C1", 100, 8, 10);
        Event e2 = new Event("C2", 100, 10, 12);
        Event e3 = new Event("L1", 30, 8, 10);
        Event e4 = new Event("L2", 30, 8, 10);
        Event e5 = new Event("L3", 30, 10, 12);
        Event e9 = new Event("L3", 30, 10, 12);

//        Event e6 = new Event("L4", 30, 10,12);
//        Event e7 = new Event("L5", 30, 8, 10);
//        Event e8 = new Event("L6", 30, 8, 10);

        ComputerLab r1 = new ComputerLab("401", "ComputerLab", 30, true);
        ComputerLab r2 = new ComputerLab("403", "ComputerLab", 30, true);
        ComputerLab r3 = new ComputerLab("405", "ComputerLab", 30, false);
        LectureHall r4 = new LectureHall("309", "LectureHall", 100, "Windows 10");

        problem.addEvent(e1);
        problem.addEvent(e2);
        problem.addEvent(e3);
        problem.addEvent(e4);
        problem.addEvent(e5);
        problem.addEvent(e9);

//        problem.addEvent(e6);
//        problem.addEvent(e7);
//        problem.addEvent(e8);

        problem.addRoom(r1);
        problem.addRoom(r2);
        problem.addRoom(r3);
        problem.addRoom(r4);


        Solution sol = new Solution();
        sol.computeSolution(problem);
        sol.printSolution();
    }
}
