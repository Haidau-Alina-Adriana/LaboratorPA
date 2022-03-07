package com.company;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Event> events;
    private List<Room> rooms;

    /**
     * Constructorul default al clasei Problem
     */
    public Problem() {
        this.events = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    /**
     * Constructorul clasei Problem
     * primeste o lista de evenimente si una de sali disponibile pe care o instantiaza
     *
     * @param events evenimente
     * @param rooms  sali
     */
    public Problem(List<Event> events, List<Room> rooms) {
        this.events = new ArrayList<>();
        this.events = events;
        this.rooms = new ArrayList<>();
        this.rooms = rooms;
    }

    /**
     * @param event Metoda adauga un eveniment nou in lista de evenimente doar dupa ce verifica daca
     *              aceasta nu exista deja in lista
     */
    public void addEvent(Event event) {
        for (Event e : events) {
            if (e.equals(event)) {
                System.out.println("Event " + event.getName() + " already exists!");
                return;
            }
        }
        events.add(event);
        System.out.println("Event " + event.getName() + " successfully added!");
    }

    /**
     * @param room Metoda adauga o sala noua in lista de sali doar dupa ce verifica daca
     *             aceasta nu exista deja in lista
     */
    public void addRoom(Room room) {
        for (Room r : rooms) {
            if (r.equals(room)) {
                System.out.println("Room " + room.getName() + " already exists!");
                return;
            }
        }
        rooms.add(room);
        System.out.println("Room " + room.getName() + " successfully added!");
    }

    /**
     * Metoda fara parametri care afiseaza instanta problemei
     */
    public void printProblemInfo() {
        System.out.println("\nEvents: ");
        for (int i = 0, n = events.size(); i < n; i++) {
            System.out.println("Event " + (i + 1) + " -> name: " + events.get(i).getName() + ", size: " + events.get(i).getSize() +
                    ", start: " + events.get(i).getStart() + ", end: " + events.get(i).getEnd());
        }
        System.out.println("Rooms: ");
        for (int i = 0, n = rooms.size(); i < n; i++) {
            System.out.println("Room " + (i + 1) + " -> name: " + rooms.get(i).getName() + ", capacity: " + rooms.get(i).getCapacity());
        }
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "events=" + events +
                ", rooms=" + rooms +
                '}';
    }
}