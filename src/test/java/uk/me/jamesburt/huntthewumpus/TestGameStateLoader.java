package uk.me.jamesburt.huntthewumpus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.model.GameState;

import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class TestGameStateLoader {

    @InjectMocks
    GameStateLoader gameStateLoader;

    @Test
    public void testGetGameState() {
        GameState gameState = gameStateLoader.getCurrentState();
        assertNotNull(gameState);
    }
}
