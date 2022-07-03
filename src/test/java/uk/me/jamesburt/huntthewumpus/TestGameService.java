package uk.me.jamesburt.huntthewumpus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;
import uk.me.jamesburt.huntthewumpus.model.Turn;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TestGameService {

    @Mock
    TextViewMaker textViewMaker;

    @Mock
    GameStateLoader gameStateLoader;

    @Mock
    TurnProcessor turnProcessor;

    @InjectMocks
    GameService gameService;



    @Test
    public void testGetGameState() {
        // given
        // TODO gamestate be updated in a NextTurnProcessor, which resolves the gamestate and saves it
        GameState initialState = new GameState(new Room("TestGameServiceRoom"));
        Turn turn = new Turn();
        when(gameStateLoader.getCurrentState()).thenReturn(initialState);
        when(textViewMaker.generateText(any())).thenReturn("View");
        when(turnProcessor.updateGameState(initialState, turn)).thenReturn(new GameState(new Room("Result room")));

        // when
        String s = gameService.handleTurn(turn);

        // then
        assertEquals("View", s);

    }
}
