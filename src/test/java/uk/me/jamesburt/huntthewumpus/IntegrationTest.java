package uk.me.jamesburt.huntthewumpus;

import org.junit.Ignore;
import org.junit.Test;
import uk.me.jamesburt.huntthewumpus.maps.LinearMap;
import uk.me.jamesburt.huntthewumpus.model.Turn;

import static org.junit.Assert.assertEquals;

/**
 * Adding a simple integration test which sets up a full game and plays it through. This is included
 * as a means of demonstrating the API that is under production. Where methods are not yet available they
 * will be commented out and a TODO added.
 */
public class IntegrationTest {

    @Test
    @Ignore
    public void exploreMap() {

        MapGenerator mapGenerator = new LinearMap(3);
        GameStateLoader gameStateLoader = new GameStateLoader(mapGenerator);
        TurnProcessor turnProcessor = new TurnProcessor();

        // TODO creating a new gameService should create a map if needed
        GameService gameService = new GameService(new TextViewMaker(),
                gameStateLoader,
                turnProcessor);

        String initialState = gameService.startGame();
        assert(initialState.contains("You are in room 1"));

        String turn1 = gameService.handleTurn(new Turn(Turn.TurnType.MOVE, 2));
        String expectedString = "You are in room 2. Updated room.";
        assertEquals(expectedString, turn1);

        String turn2 = gameService.handleTurn(new Turn(Turn.TurnType.MOVE, 3));
        expectedString = "You are in room 3";
        assertEquals(expectedString, turn2);

        String illegalMove = gameService.handleTurn(new Turn(Turn.TurnType.MOVE, 1));
        expectedString = "You cannot reach room 1 from room 3";
        assertEquals(expectedString, illegalMove);

        String sameRoomMove = gameService.handleTurn(new Turn(Turn.TurnType.MOVE, 3));
        expectedString = "You are already in room 3";
        assertEquals(expectedString, sameRoomMove);

    }
}
