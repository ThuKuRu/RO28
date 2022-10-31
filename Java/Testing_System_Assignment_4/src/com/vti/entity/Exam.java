package com.vti.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Exam {
    private int                 examID;

    private int                 code;

    private String              title;

    private CategoryQuestion    category;

    private LocalTime           duration;

    private Group               creator;

    private LocalDate           createDate;

    public int getId() {
        return examID;
    }

    public void setId(int id) {
        this.examID = examID;
    }

    public int getCode(){
        return code;
    }

    public void setCode(){
        this.code = code;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(){
        this.title = title;
    }

    public CategoryQuestion getCategoryQuestion(){
        return category;
    }

    public void setCategoryQuestion(){
        this.category = category;
    }

    public LocalTime getTime(){
        return duration;
    }

    public void setDuration(){
        this.duration = duration;
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
        return "Exam{" +
                "examID=" + examID +
                ", code=" + code +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", duration=" + duration +
                ", creatorID=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
