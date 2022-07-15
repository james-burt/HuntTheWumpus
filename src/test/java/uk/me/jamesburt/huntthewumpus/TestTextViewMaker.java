package uk.me.jamesburt.huntthewumpus;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;

import static org.junit.Assert.assertEquals;
import static uk.me.jamesburt.huntthewumpus.testfactories.RoomFactory.*;


@RunWith(MockitoJUnitRunner.class)
public class TestTextViewMaker {

    @InjectMocks
    TextViewMaker textViewMaker;

    @Test
    public void testGetGameState() {
        GameState gameState = new GameState(aSimpleMap());

        // when
        String s = textViewMaker.generateText(gameState);

        // then
        String expectedOutput = "You are in room 1. A simple room. You can go from here to room 2";
        assertEquals(expectedOutput, s);
    }


    @Test
    public void testGetGameStateRoomWithNoExits() {
        GameState gameState = new GameState(aSimpleMap());

        // when
        String s = textViewMaker.generateText(gameState);

        // then
        String expectedOutput = "You are in room 1. A simple room. You can go from here to room 2";
        assertEquals(expectedOutput, s);
    }

    @Test
    public void testGetGameStateThreeRooms() {

        GameState gameState = new GameState(Arrays.asList(aRoomWithTwoExits()));

        // when
        String s = textViewMaker.generateText(gameState);

        // then
        String expectedOutput = "You are in room 1. First Room. You can go from here to room 2, 3";
        assertEquals(expectedOutput, s);
    }
}
