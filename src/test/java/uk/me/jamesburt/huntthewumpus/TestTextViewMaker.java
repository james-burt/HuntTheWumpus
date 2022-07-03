package uk.me.jamesburt.huntthewumpus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.model.GameState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(MockitoJUnitRunner.class)
public class TestTextViewMaker {

    @InjectMocks
    TextViewMaker textViewMaker;

    @Test
    public void testGetGameState() {
        GameState gameState = new GameState();
        String s = textViewMaker.generateText(gameState);
        assertEquals("", s);
    }
}
