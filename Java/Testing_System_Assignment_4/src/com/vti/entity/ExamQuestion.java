package com.vti.entity;

public class ExamQuestion {
    private Exam            exam;

    private Question        question;

    public Exam getExam(){
        return exam;
    }

    public void setExam(){
        this.exam = exam;
    }

    public Question getQuestion(){
        return question;
    }

    public void setQuestion(){
        this.question = question;
    }

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "examID=" + exam +
                ", questionID=" + question +
                '}';
    }
}
