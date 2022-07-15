package uk.me.jamesburt.huntthewumpus;

import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;

public class GameStateLoader {

    private final MapGenerator mapGenerator;

    GameState currentGameState = null;

    public GameStateLoader(MapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    public GameState getCurrentState() {
        if(currentGameState==null) {
            currentGameState = new GameState(mapGenerator.createNewMap());
        }
        return currentGameState;
    }
}
