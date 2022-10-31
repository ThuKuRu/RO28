package com.vti.entity;

import java.time.LocalDate;

public class Question {
    private int                 questionID;

    private String              content;

    private CategoryQuestion    category;

    private TypeQuestion        type;

    private Group     creator;

    private LocalDate createDate;

    public int getId() {
        return questionID;
    }

    public void setId(int id) {
        this.questionID = questionID;
    }

    public String getContent(){
        return content;
    }

    public void setContent(){
        this.content = content;
    }

    public CategoryQuestion getCategoryQuestion(){
        return category;
    }

    public void setCategoryQuestion(){
        this.category = category;
    }

    public TypeQuestion getType(){
        return type;
    }

    public void setType(){
        this.type = type;
    }

    public Group getCreator(){
        return creator;
    }

    public void setCreator(){
        this.creator = creator;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", typeID=" + type +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }

}
