package entity.Exception;

public class Position {
    int     positionID;

    PositionName positionName;

    public Position() {
        input();
    }

    public enum PositionName{
        DEV, TEST, SCRUM_MASTER, PM;
    }

    private void input() {
        System.out.println("Nhập id : ");
        positionID = ScannerUtils.inputInt("Please input a id as int, please input again.");

        System.out.println("Nhập tên : ");
        positionName = PositionName.valueOf(ScannerUtils.inputString("Please input a name, please input again."));
    }


    @Override
    public String toString() {
        return "Position{" +
                "positionID=" + positionID +
                ", positionName=" + positionName +
                '}';
    }
}
