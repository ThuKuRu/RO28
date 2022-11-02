package com.vti.entity;

public class Position {
    public int     positionID;

    public PositionName positionName;

    public Position(int i, String sale) {
        this.positionID = i;
        this.positionName = PositionName.valueOf(sale);
    }

    public Position() {

    }

    public enum PositionName{
        DEV, TEST, SCRUM_MASTER, PM;
    }

    public int getID(){
        return positionID;
    }

    public void setID(){
        this.positionID = positionID;
    }

    public PositionName getName(){
        return positionName;
    }

    public void setName(){
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionID=" + positionID +
                ", positionName=" + positionName +
                '}';
    }
}
