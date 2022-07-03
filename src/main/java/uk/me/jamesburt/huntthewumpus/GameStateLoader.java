package uk.me.jamesburt.huntthewumpus;

import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;

public class GameStateLoader {
    public GameState getCurrentState() {
        return new GameState(new Room("Test room"));
    }
}
