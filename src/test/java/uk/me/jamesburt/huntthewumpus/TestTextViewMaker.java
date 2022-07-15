package uk.me.jamesburt.huntthewumpus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Room> simpleMap = aSimpleMap();
        GameState gameState = new GameState(simpleMap.get(0), simpleMap);

        // when
        String s = textViewMaker.generateText(gameState);

        // then
        String expectedOutput = "You are in room 1. A simple room. You can go from here to room 2";
        assertEquals(expectedOutput, s);
    }


    @Test
    public void testGetGameStateRoomWithNoExits() {
        List<Room> simpleMap = Arrays.asList(new Room(1, "A simple room" ));
        GameState gameState = new GameState(simpleMap.get(0), simpleMap);

        // when
        String s = textViewMaker.generateText(gameState);

        // then
        String expectedOutput = "You are in room 1. A simple room.";
        assertEquals(expectedOutput, s);
    }

    @Test
    public void testGetGameStateThreeRooms() {

        List<Room> simpleMap = Arrays.asList(aRoomWithTwoExits());
        GameState gameState = new GameState(simpleMap.get(0), simpleMap);

        // when
        String s = textViewMaker.generateText(gameState);

        // then
        String expectedOutput = "You are in room 1. First Room. You can go from here to room 2, 3";
        assertEquals(expectedOutput, s);
    }
}
