package uk.me.jamesburt.huntthewumpus;

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

    public String handleTurn(Turn turn) {
        GameState initialGameState = gameStateLoader.getCurrentState();
        GameState updatedGamrState = turnProcessor.updateGameState(initialGameState, turn);
        return textViewMaker.generateText(updatedGamrState);
    }
}
