package uk.me.jamesburt.huntthewumpus.model;


import java.util.ArrayList;
import java.util.List;

public class Room {

    private final int roomNumber;
    String description = "No description";
    private List<Room> exits;

    public Room(String description) {
        this.description = description;
        this.roomNumber = 1;
        this.exits = new ArrayList<>();
    }

    public Room(int roomNumber, String description) {
        this.roomNumber = roomNumber;
        this.description = description;
        this.exits = new ArrayList<>();
    }

    public Room(int roomNumber, String roomDescription, ArrayList<Room> exits) {
        this.roomNumber = roomNumber;
        this.description = roomDescription;
        this.exits = exits;

    }

    public String getDescription() {
        return description;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setExits(List<Room> exits) {
        this.exits = exits;
    }

    public List<Room> getExits() {
        return exits;
    }
}
