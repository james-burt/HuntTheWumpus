package uk.me.jamesburt.huntthewumpus;

import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;
import uk.me.jamesburt.huntthewumpus.model.Turn;

import java.util.List;
import java.util.Optional;

public class TurnProcessor {
    public GameState updateGameState(GameState gameState, Turn turn) {

        if(Turn.TurnType.SHOOT.equals(turn.getTurnType())) {
            throw new UnsupportedOperationException();
        }
        if(turn.getTargetRoom() == gameState.getCurrentRoom().getRoomNumber()) {
            throw new RuntimeException("This is the same room");
        }
        List<Room> possibleExits = gameState.getCurrentRoom().getExits();
        Optional<Room> targetRoom = possibleExits.stream().filter(p -> p.getRoomNumber()== turn.getTargetRoom()).findFirst();
        if(!targetRoom.isPresent()) {
            throw new RuntimeException("Room not accessible");
        }
        return new GameState(new Room("Updated room"));
    }
}
