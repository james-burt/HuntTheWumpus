package uk.me.jamesburt.huntthewumpus;

import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;

import java.util.List;

public class GameStateLoader {

    private final MapGenerator mapGenerator;

    GameState currentGameState = null;

    public GameStateLoader(MapGenerator mapGenerator) {
        this.mapGenerator = mapGenerator;
    }

    public GameState getCurrentState() {
        if(currentGameState==null) {
            List<Room> newMap = mapGenerator.createNewMap();
            currentGameState = new GameState(newMap.get(0), newMap);
        }
        return currentGameState;
    }
}
