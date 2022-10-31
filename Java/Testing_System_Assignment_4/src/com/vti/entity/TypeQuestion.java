package com.vti.entity;

public class TypeQuestion {
    private int             typeID;

    private TypeName        typeName;

    public enum  TypeName{
        ESSAY, MULTIPLE_CHOICE;
    }

    public int getID(){
        return typeID;
    }

    public void setID(){
        this.typeID = typeID;
    }

    public TypeName getName(){
        return typeName;
    }

    public void setName(){
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "typeID=" + typeID +
                ", typeName=" + typeName +
                '}';
    }
}
