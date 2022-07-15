package uk.me.jamesburt.huntthewumpus.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
public class GameState {

    private Room currentRoom;
    private List<Room> map;

    public GameState(List<Room> map) {
        if(map==null || map.size()==0) {
            throw new IllegalArgumentException("Map must contain rooms");
        }
        // TODO is starting with first room sensible?
        this.currentRoom = map.get(0);
        this.map = map;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

}
