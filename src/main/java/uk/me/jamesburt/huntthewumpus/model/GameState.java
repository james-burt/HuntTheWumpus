package uk.me.jamesburt.huntthewumpus.model;

public class GameState {

    private Room currentRoom;

    public GameState(Room initialRoom) {
        this.currentRoom = initialRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
