package uk.me.jamesburt.huntthewumpus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.exceptions.RoomNotAccessibleException;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;
import uk.me.jamesburt.huntthewumpus.model.Turn;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static uk.me.jamesburt.huntthewumpus.model.Turn.TurnType.MOVE;
import static uk.me.jamesburt.huntthewumpus.testfactories.RoomFactory.aSimpleRoom;


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
    public void testStartGame() {
        GameState gameState = new GameState(Arrays.asList(aSimpleRoom()));
        when(gameStateLoader.getCurrentState()).thenReturn(gameState);
        when(textViewMaker.generateText(gameState)).thenReturn("Test data");

        String response = gameService.startGame();

        assertEquals(response, "Test data");
    }


    @Test
    public void testGetGameState() {
        // given
        // TODO gamestate be updated in a NextTurnProcessor, which resolves the gamestate and saves it
        List<Room> simpleMap = Arrays.asList(aSimpleRoom());
        GameState initialState = new GameState(Arrays.asList(aSimpleRoom()));
        Turn turn = new Turn(MOVE, 1);
        when(gameStateLoader.getCurrentState()).thenReturn(initialState);
        when(textViewMaker.generateText(any())).thenReturn("View");
        // TODO make this more precise
        when(turnProcessor.updateGameState(initialState, turn)).thenReturn(new GameState(simpleMap));

        // when
        String s = gameService.handleTurn(turn);

        // then
        assertEquals("View", s);

    }

    @Test
    public void getGameStateRoomNotAccessible() {
        // given
        // We use a simple room in the state since the map navigation is managed by the gameStateLoader mock
        GameState initialState = new GameState(Arrays.asList(aSimpleRoom()));
        Turn turn = new Turn(MOVE, 6);
        when(gameStateLoader.getCurrentState()).thenReturn(initialState);
        verifyNoInteractions(textViewMaker);
        when(turnProcessor.updateGameState(initialState, turn)).thenThrow(new RoomNotAccessibleException());

        // when
        String s = gameService.handleTurn(turn);

        // then
        assertEquals("You cannot reach room 6 from room 1", s);

    }
}
