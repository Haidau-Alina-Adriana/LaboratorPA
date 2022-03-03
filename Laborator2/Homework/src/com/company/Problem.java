package com.company;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Event> events;
    private List<Room> rooms;

    public Problem() {
        this.events = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public Problem(List<Event> events, List<Room> rooms) {
        this.events = new ArrayList<>();
        this.events = events;
        this.rooms = new ArrayList<>();
        this.rooms = rooms;
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

    @Override
    public String toString() {
        return "Problem{" +
                "events=" + events +
                ", rooms=" + rooms +
                '}';
    }
}