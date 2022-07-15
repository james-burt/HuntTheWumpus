package uk.me.jamesburt.huntthewumpus.maps;

import org.junit.Test;
import uk.me.jamesburt.huntthewumpus.MapGenerator;
import uk.me.jamesburt.huntthewumpus.model.Room;

import java.util.List;

import static org.junit.Assert.*;

public class TestLinearMap {

    @Test
    public void createNewMapNegativeRooms() {
        try {
            new LinearMap(-1);
            fail("An exception should be thrown");
       } catch (IllegalArgumentException iae) {
            assertEquals("Number of rooms must be greater than zero", iae.getMessage());
        }
    }

    @Test
    public void createNewMapOneRoom() {
        MapGenerator mapGenerator = new LinearMap(1);
        List<Room> map = mapGenerator.createNewMap();
        assertEquals(1, map.size());
        Room singleRoom = map.get(0);
        assertEquals(1, singleRoom.getRoomNumber());
        assertEquals("Room 1", singleRoom.getDescription());
        assertTrue(singleRoom.getExits().isEmpty());
    }

    @Test
    public void createNewMapFourRooms() {
        MapGenerator mapGenerator = new LinearMap(4);
        List<Room> map = mapGenerator.createNewMap();
        assertEquals(4, map.size());

        for(int i=0;i<4;i++) {
            Room currentRoomToCheck = map.get(i);
            assertEquals((i+1), currentRoomToCheck.getRoomNumber());
            assertEquals("Room "+(i+1), currentRoomToCheck.getDescription());
            int currentRoomUnderTestRoomNumber = currentRoomToCheck.getRoomNumber();
            if(i<3) {
                List<Room> exits = currentRoomToCheck.getExits();
                assertTrue(exits.stream().anyMatch(room -> room.getRoomNumber()==(currentRoomUnderTestRoomNumber+1)));
            }
            if(i>1) {
                List<Room> exits = currentRoomToCheck.getExits();
                assertTrue(exits.stream().anyMatch(room -> room.getRoomNumber()==(currentRoomUnderTestRoomNumber -1)));
            }

        }
    }

}