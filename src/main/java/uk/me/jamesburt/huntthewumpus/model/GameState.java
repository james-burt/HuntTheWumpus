package uk.me.jamesburt.huntthewumpus.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
public class GameState {

    private Room currentRoom;
    private List<Room> map;

    public GameState(Room currentRoom, List<Room> map) {
        if(map==null || map.size()==0) {
            throw new IllegalArgumentException("Map must contain rooms");
        }
        // Check the current room is in the map
        this.currentRoom = currentRoom;
        this.map = map;
    }

    // Reinstate lombok
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public List<Room> getMap() {return map;}


}
