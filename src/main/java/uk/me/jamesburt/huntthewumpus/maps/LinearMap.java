package uk.me.jamesburt.huntthewumpus.maps;

import uk.me.jamesburt.huntthewumpus.MapGenerator;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;

import javax.swing.tree.RowMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearMap implements MapGenerator {

    private final int numberOfRooms;

    public LinearMap(int rooms) {
        if(rooms<1) {
            throw new IllegalArgumentException("Number of rooms must be greater than zero");
        }
        this.numberOfRooms = rooms;
    }

    @Override
    public List<Room> createNewMap() {
        List<Room> map = new ArrayList<>();
        // Create initial set of rooms
        for(int i=0;i<numberOfRooms;i++) {
            Room newRoom = new Room(i + 1, "Room " + (i + 1), new ArrayList<>());
            map.add(newRoom);
        }
        for(int i=0;i<numberOfRooms;i++) {
            List<Room> exits = new ArrayList<>();
            if(i<(numberOfRooms-1)) {
                Room nextRoomInLine = map.get(i + 1);
                exits.add(nextRoomInLine);
            }
            if(i>0) {
                Room previousRoomInLine = map.get(i - 1);
                exits.add(previousRoomInLine);
            }
            map.get(i).setExits(exits);
        }
        return map;
    }
}

