package uk.me.jamesburt.huntthewumpus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static uk.me.jamesburt.huntthewumpus.testfactories.RoomFactory.aSimpleRoom;


@RunWith(MockitoJUnitRunner.class)
public class TestGameStateLoader {

    @Mock
    MapGenerator mapGenerator;

    @InjectMocks
    GameStateLoader gameStateLoader;

    @Test
    public void testGetGameStateNoCurrentGame() {
        List<Room> simpleMap = Arrays.asList(aSimpleRoom());
        GameState generatedGameState = new GameState(simpleMap);
        when(mapGenerator.createNewMap()).thenReturn(simpleMap);

        GameState createdState = gameStateLoader.getCurrentState();

        assertEquals(createdState, generatedGameState);
    }

    /**
     * This test is very similar to the first, but with the addition that the second call
     * does not produce a second call to create the game
     */
    @Test
    public void testGetGameStateWithCurrentGame() {
        List<Room> simpleMap = Arrays.asList(aSimpleRoom());
        GameState generatedGameState = new GameState(simpleMap);
        when(mapGenerator.createNewMap()).thenReturn(simpleMap);

        gameStateLoader.getCurrentState();
        GameState createdState = gameStateLoader.getCurrentState();

        assertEquals(createdState, generatedGameState);
        verify(mapGenerator, times(1)).createNewMap();
    }
}
