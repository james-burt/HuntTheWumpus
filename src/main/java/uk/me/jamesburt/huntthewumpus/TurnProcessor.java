package uk.me.jamesburt.huntthewumpus;

import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;
import uk.me.jamesburt.huntthewumpus.model.Turn;

public class TurnProcessor {
    public GameState updateGameState(GameState gameState, Turn turn) {
        return new GameState(new Room("Updated room"));
    }
}
