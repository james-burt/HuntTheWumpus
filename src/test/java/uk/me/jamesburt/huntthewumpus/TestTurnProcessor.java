package uk.me.jamesburt.huntthewumpus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.exceptions.AlreadyInRoomException;
import uk.me.jamesburt.huntthewumpus.exceptions.RoomNotAccessibleException;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;
import uk.me.jamesburt.huntthewumpus.model.Turn;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static uk.me.jamesburt.huntthewumpus.model.Turn.TurnType.MOVE;
import static uk.me.jamesburt.huntthewumpus.model.Turn.TurnType.SHOOT;
import static uk.me.jamesburt.huntthewumpus.testfactories.RoomFactory.*;

@RunWith(MockitoJUnitRunner.class)
public class TestTurnProcessor {

    @InjectMocks
    TurnProcessor turnProcessor;

    @Test
    public void testUpdateGameState() {
        // given
        List<Room> simpleMap = Arrays.asList(aSimpleRoom());
        GameState initialGameState = new GameState(simpleMap.get(0), simpleMap);
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
        List<Room> simpleMap = Arrays.asList(aRoomWithTwoExits());
        GameState initialGameState = new GameState(simpleMap.get(0), simpleMap);

        // when
        try {
            turnProcessor.updateGameState(initialGameState, turn);
            fail("An exception is expected");
        } catch (RoomNotAccessibleException re) {
        }
    }

    @Test
    public void testUpdateGameStateIllegalMoveSameRoom() {
        // given
        Turn turn = new Turn(MOVE, 1);
        List<Room> simpleMap = Arrays.asList(aRoomWithTwoExits());
        GameState initialGameState = new GameState(simpleMap.get(0), simpleMap);

        // when
        try {
            turnProcessor.updateGameState(initialGameState, turn);
            fail("An exception is expected");
        } catch (AlreadyInRoomException re) {

        }
    }

    @Test
    public void testUpdateGameStateShootNotImplemented() {
        // given
        Turn turn = new Turn(SHOOT, 1);
        List<Room> simpleMap = Arrays.asList(aRoomWithTwoExits());
        GameState initialGameState = new GameState(simpleMap.get(0), simpleMap);

        // when
        try {
            turnProcessor.updateGameState(initialGameState, turn);
            fail("An exception is expected");
        } catch (UnsupportedOperationException uoe) {
            // Exception expected
        }
    }
}