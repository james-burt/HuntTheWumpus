package uk.me.jamesburt.huntthewumpus.model;

public class Turn {

    private final TurnType turnType;
    private final int targetRoom;

    public Turn(TurnType turnType, int targetRoom) {
        this.turnType = turnType;
        this.targetRoom = targetRoom;
    }

    public int getTargetRoom() {
        return targetRoom;
    }

    public TurnType getTurnType() {
        return turnType;
    }

    public enum TurnType {
        MOVE,
        SHOOT
    }

}
