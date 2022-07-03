package uk.me.jamesburt.huntthewumpus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Turn;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TestGameService {

    @Mock
    TextViewMaker textViewMaker;

    @Mock
    GameStateLoader gameStateLoader;

    @InjectMocks
    GameService gameService;

    @Test
    public void testGetGameState() {
        // given
        // TODO gamestate be updated in a NextTurnProcessor, which resolves the gamestate and saves it
        when(textViewMaker.generateText(any())).thenReturn("View");
        when(gameStateLoader.getCurrentState()).thenReturn(new GameState());
        Turn turn = new Turn();

        // when
        String s = gameService.handleTurn(turn);

        // then
        assertEquals("View", s);

    }
}
