package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private final List<String> solution;

    /**
     * Constructorul default al clasei Solution
     */
    public Solution() {
        this.solution = new ArrayList<>();
    }

    public List<String> getSolution() {
        return solution;
    }

    /**
     * @param pb Metoda calculeaza o solutie fezabila de tip Greedy care parcurge fiecare eveniment in cautarea celui care se termina
     *           cel mai devreme. Va verifica daca sala are o capacitate egala cu numarul de participanti, apoi va verifica daca sala
     *           este libera in intervalul la care are loc evenimentul
     */
    public void computeSolution(Problem pb) {
        int numberOfRooms = pb.getRooms().size();
        int numberOfEvents = pb.getEvents().size();

        List<Event> copyEvents = new ArrayList<>(pb.getEvents());
        List<Room> copyRooms = new ArrayList<>(pb.getRooms());

        List<String> unassignedEvents = new ArrayList<>();
        String[] intervalsRooms = new String[numberOfRooms];

        while (numberOfEvents > 0) {
            int index = 0;
            for (int i = 1; i < numberOfEvents; i++) {
                if (copyEvents.get(i).getEnd() < copyEvents.get(index).getEnd()) {
                    index = i;
                }
            }
            boolean foundRoom = false;
            for (int i = 0; i < numberOfRooms; i++) {
                if (copyEvents.get(index).getSize() == copyRooms.get(i).getCapacity()) {
                    if (checkIfIntervalIsFree(intervalsRooms[i], copyEvents.get(index))) {

                        String newInterval = intervalsRooms[i] + copyEvents.get(index).getStart() +
                                "-" + copyEvents.get(index).getEnd() + ", ";
                        intervalsRooms[i] = newInterval;

                        String assignEventToRoom = copyEvents.get(index).getName() +
                                " -> " + copyRooms.get(i).getName();

                        solution.add(assignEventToRoom);
                        foundRoom = true;
                        break;
                    }
                }
            }
            if (!foundRoom) {
                unassignedEvents.add("Event " + copyEvents.get(index).getName() + " has been left unscheduled.");
            }
            numberOfEvents--;
            copyEvents.remove(index);
        }
        this.solution.addAll(unassignedEvents);
    }

    /**
     * @param intervals starea salii in anumite intervale de timp
     * @param e         evenimentul pentru care se cauta sala
     * @return se va returna false daca sala contine intervalul parametrului eveniment
     */
    public boolean checkIfIntervalIsFree(String intervals, Event e) {
        if (intervals == null) {
            return true;
        }
        String interval = e.getStart() + "-" + e.getEnd();
        return !intervals.contains(interval);
    }

    /**
     * afiseaza solutia instantei
     */
    public void printSolution() {
        for (String assignment : solution) {
            System.out.println(assignment);
        }
    }

    @Override
    public String toString() {
        return "Solution{" +
                "solution=" + solution +
                '}';
    }
}
