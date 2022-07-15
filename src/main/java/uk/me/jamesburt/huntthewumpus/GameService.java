package uk.me.jamesburt.huntthewumpus;

import uk.me.jamesburt.huntthewumpus.exceptions.RoomNotAccessibleException;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Turn;

/**
 * A simple service that allows interaction with a game. This is a controller in the MVC sense, but is
 * called a service to make it easier to follow.
 */
public class GameService {

    private final TextViewMaker textViewMaker;
    private final GameStateLoader gameStateLoader;
    private final TurnProcessor turnProcessor;

    public GameService(TextViewMaker textViewMaker,
                       GameStateLoader gameStateLoader,
                       TurnProcessor turnProcessor) {
        this.textViewMaker = textViewMaker;
        this.gameStateLoader = gameStateLoader;
        this.turnProcessor = turnProcessor;
    }

    public String startGame() {
        return textViewMaker.generateText(gameStateLoader.getCurrentState());
    }

    public String handleTurn(Turn turn) {
        GameState initialGameState = gameStateLoader.getCurrentState();
        GameState updatedGameState;
        try {
            updatedGameState = turnProcessor.updateGameState(initialGameState, turn);
        } catch (RoomNotAccessibleException rnae) {
            // TODO need to manage text generation
            return "You cannot reach room " + turn.getTargetRoom() + " from room " + initialGameState.getCurrentRoom().getRoomNumber();
        }
        return textViewMaker.generateText(updatedGameState);
    }
}
