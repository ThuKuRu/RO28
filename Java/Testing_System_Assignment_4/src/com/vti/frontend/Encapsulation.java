package com.vti.frontend;

import com.vti.entity.Encapsulation.Student;

public class Encapsulation {
    public static void main(String[] args){

        // a)
        System.out.println("a)");
        Student student = new Student("Nguyễn Thị Thu", "Bắc Ninh");
        System.out.println(student);

        // b)
        System.out.println("b)");
        Student student1 = new Student("Nguyễn Thị Thu Huệ", "Bắc Ninh");
        student1.setScore(8);
        System.out.println(student1);

        // c)
        student1.plusScore(1);
        System.out.println(student1);

    }
}
