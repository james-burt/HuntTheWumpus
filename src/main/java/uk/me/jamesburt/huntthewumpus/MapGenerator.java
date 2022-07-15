package uk.me.jamesburt.huntthewumpus;

import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;

import java.util.List;

public interface MapGenerator {
    public List<Room> createNewMap();
}
