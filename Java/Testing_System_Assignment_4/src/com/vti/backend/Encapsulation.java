package com.vti.backend;

import com.vti.entity.Encapsulation.Student;

public class Encapsulation {
    public void question1() {
        Student student1 = new Student("Nguyễn Thị Thu", "Bắc Ninh");
        student1.setScore(9);

        Student student2 = new Student("Lê Thị Lan", "Hà Nội");
        student2.setScore(10);

        Student student3 = new Student("Trần Hữu Tiến", "Hải Dương");
        student3.setScore(4);

        student3.plusScore(3);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }
}
