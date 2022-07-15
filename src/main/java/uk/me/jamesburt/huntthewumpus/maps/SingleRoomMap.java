package uk.me.jamesburt.huntthewumpus.maps;

import uk.me.jamesburt.huntthewumpus.MapGenerator;
import uk.me.jamesburt.huntthewumpus.model.Room;

import java.util.ArrayList;
import java.util.List;

public class SingleRoomMap implements MapGenerator {
    @Override
    public List<Room> createNewMap() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Test room"));
        return rooms;
    }
}

