package uk.me.jamesburt.huntthewumpus.testfactories;

import uk.me.jamesburt.huntthewumpus.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomFactory {

    public static List<Room> aSimpleMap() {
        List<Room> singleExit = Arrays.asList(new Room[]{new Room(2, "Test Room", new ArrayList<>())});

        return Arrays.asList(new Room(1, "A simple room", singleExit));

    }

    public static Room aSimpleRoom() {
        List<Room> singleExit = Arrays.asList(new Room[]{new Room(2, "Test Room", new ArrayList<>())});

        return new Room(1, "A simple room", singleExit);
    }

    public static Room aRoomWithTwoExits() {
        Room room1 = new Room(1, "First Room");
        Room room2 = new Room(2, "Second Room");
        Room room3 = new Room(3, "Third Room");
        room1.setExits(Arrays.asList(new Room[]{room2, room3}));
        room2.setExits(Arrays.asList(new Room[]{room1}));
        room3.setExits(Arrays.asList(new Room[]{room1}));
        return room1;

    }
}
