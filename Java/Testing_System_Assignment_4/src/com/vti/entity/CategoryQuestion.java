package com.vti.entity;

public class CategoryQuestion {
    private int     categoryID;

    private CategoryName  categoryName;

    public enum  CategoryName{
        JAVA, SQL, POSTMAN, RUBY;
    }

    public int getID(){
        return categoryID;
    }

    public void setID(){
        this.categoryID = categoryID;
    }

    public CategoryName getName(){
        return categoryName;
    }

    public void setName(){
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "categoryID=" + categoryID +
                ", categoryName=" + categoryName +
                '}';
    }
}
