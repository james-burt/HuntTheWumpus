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


@RunWith(MockitoJUnitRunner.class)
public class TestTextViewMaker {

    @InjectMocks
    TextViewMaker textViewMaker;

    @Test
    public void testGetGameState() {
        String roomDescription = "The floor is icy";
        GameState gameState = new GameState(new Room(1, roomDescription, new ArrayList<Room>()));

        // when
        String s = textViewMaker.generateText(gameState);

        // then
        String expectedOutput = "You are in room 1. The floor is icy.";
        assertEquals(expectedOutput, s);
    }

    @Test
    public void testGetGameStateThreeRooms() {
        Room room1 = new Room(1, "First Room");
        Room room2 = new Room(2, "Second Room");
        Room room3 = new Room(3, "Third Room");
        room1.setExits(Arrays.asList(new Room[]{room2, room3}));
        room2.setExits(Arrays.asList(new Room[]{room1}));
        room3.setExits(Arrays.asList(new Room[]{room1}));

        GameState gameState = new GameState(room1);

        // when
        String s = textViewMaker.generateText(gameState);

        // then
        String expectedOutput = "You are in room 1. First Room. You can go from here to room 2, 3";
        assertEquals(expectedOutput, s);
    }
}
