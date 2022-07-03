package uk.me.jamesburt.huntthewumpus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Turn;

import static org.junit.Assert.*;
import static uk.me.jamesburt.huntthewumpus.model.Turn.TurnType.MOVE;
import static uk.me.jamesburt.huntthewumpus.model.Turn.TurnType.SHOOT;
import static uk.me.jamesburt.huntthewumpus.testfactories.RoomFactory.aRoomWithTwoExits;
import static uk.me.jamesburt.huntthewumpus.testfactories.RoomFactory.aSimpleRoom;

@RunWith(MockitoJUnitRunner.class)
public class TestTurnProcessor {

    @InjectMocks
    TurnProcessor turnProcessor;

    @Test
    public void testUpdateGameState() {
        // given
        GameState initialGameState = new GameState(aSimpleRoom());
        Turn turn = new Turn(MOVE, 2);

        // when
        GameState response = turnProcessor.updateGameState(initialGameState, turn);

        // then
        assertNotNull(response);
        assertNotEquals(initialGameState, response);
    }

    @Test
    public void testUpdateGameStateIllegalMove() {
        // given
        Turn turn = new Turn(MOVE, 4);
        GameState initialGameState = new GameState(aRoomWithTwoExits());

        // when
        try {
            turnProcessor.updateGameState(initialGameState, turn);
            fail("An exception is expected");
        } catch (RuntimeException re) {
            assertEquals("Room not accessible", re.getMessage());
        }
    }

    @Test
    public void testUpdateGameStateIllegalMoveSameRoom() {
        // given
        Turn turn = new Turn(MOVE, 1);
        GameState initialGameState = new GameState(aRoomWithTwoExits());

        // when
        try {
            turnProcessor.updateGameState(initialGameState, turn);
            fail("An exception is expected");
        } catch (RuntimeException re) {
            assertEquals("This is the same room", re.getMessage());
        }
    }

    @Test
    public void testUpdateGameStateShootNotImplemented() {
        // given
        Turn turn = new Turn(SHOOT, 1);
        GameState initialGameState = new GameState(aRoomWithTwoExits());

        // when
        try {
            turnProcessor.updateGameState(initialGameState, turn);
            fail("An exception is expected");
        } catch (UnsupportedOperationException uoe) {
            // Exception expected
        }
    }
}