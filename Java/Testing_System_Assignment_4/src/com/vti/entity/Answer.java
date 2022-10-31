package com.vti.entity;

public class Answer {

     int          answerID;

    String       content;

    Question     questionID;

    boolean      isCorrect;

    @Override
    public String toString() {
        return "Answer{" +
                "answerID=" + answerID +
                ", content='" + content + '\'' +
                ", questionID=" + questionID +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
