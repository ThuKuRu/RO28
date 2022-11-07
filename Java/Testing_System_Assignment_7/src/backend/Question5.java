package backend;

import entity.Student;

public class Question5 {
    private Student[] students;

    public void question5() throws Exception {
        students = new Student[6];
        students[0] = new Student(" Nguyễn Văn A ");
        students[1] = new Student(" Nguyễn Văn B ");
        students[2] = new Student(" Nguyễn Văn C ");

        System.out.println("Số sinh viên được tạo: ");
        System.out.println(Student.count);
    }

}
