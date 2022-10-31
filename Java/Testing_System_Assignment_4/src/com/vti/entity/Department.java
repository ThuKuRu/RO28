package com.vti.entity;

public class Department {
    public int     departmentID;

    public String  departmentName;

    public Department(){

    }

    public Department(String name){
        this.departmentID = 1;
        this.departmentName = name;
    }

    public int getID(){
        return departmentID;
    }

    public void setID() {
        this.departmentID = departmentID;
    }

    public String getName(){
        return departmentName;
    }

    public void setName() {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
