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

    public GameService(TextViewMaker textViewMaker, GameStateLoader gameStateLoader) {
        this.textViewMaker = textViewMaker;
        this.gameStateLoader = gameStateLoader;
    }

    public String handleTurn(Turn turn) {
        GameState gameState = gameStateLoader.getCurrentState();
        return textViewMaker.generateText(gameState);
    }
}
