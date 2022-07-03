package uk.me.jamesburt.huntthewumpus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Turn;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestTurnProcessor {

    @InjectMocks
    TurnProcessor turnProcessor;

    @Test
    public void testUpdateGameState() {
        // given
        GameState initialGameState = new GameState();
        Turn turn = new Turn();

        // when
        GameState response = turnProcessor.updateGameState(initialGameState, turn);

        // then
        assertNotNull(response);
        assertNotEquals(initialGameState, response);

    }

}