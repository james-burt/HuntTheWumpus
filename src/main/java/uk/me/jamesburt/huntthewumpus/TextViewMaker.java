package uk.me.jamesburt.huntthewumpus;

import uk.me.jamesburt.huntthewumpus.model.GameState;
import uk.me.jamesburt.huntthewumpus.model.Room;

import java.util.List;

public class TextViewMaker {
    public String generateText(GameState gameState) {
        Room currentRoom = gameState.getCurrentRoom();

        StringBuffer response = new StringBuffer("You are in room ");
        response.append(currentRoom.getRoomNumber());
        response.append(". ");
        response.append(currentRoom.getDescription());
        response.append(".");
        List<Room> exits = currentRoom.getExits();
        if(exits.size()>0) {
            response.append(" You can go from here to room ");
            response.append(exits.get(0).getRoomNumber());
        }
        for(int i=1;i<exits.size();i++) {
            response.append(", "+exits.get(i).getRoomNumber());
        }
        return response.toString();
    }
}
