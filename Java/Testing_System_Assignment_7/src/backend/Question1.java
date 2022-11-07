package backend;

import entity.Student;

public class Question1 {
    private Student[] students;

    public void question1()throws Exception{
        students = new Student[3];
        students[0] = new Student(" Nguyễn Văn A ");
        students[1] = new Student(" Nguyễn Văn B ");
        students[2] = new Student(" Nguyễn Văn C ");

        for(Student student : students){
            System.out.println(student);
        }

        Student.college = " Đại học công nghệ ";

        for(Student student : students){
            System.out.println(student);
        }

    }
}
