package src;

public class Position {
    int     positionID;

    PositionName positionName;

    public enum PositionName{
        DEV, TEST, SCRUM_MASTER, PM;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionID=" + positionID +
                ", positionName=" + positionName +
                '}';
    }
}
