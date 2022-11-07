package backend;

import entity.Student;

public class Question4 {
    private Student[] students;

    public void question4() throws Exception {
        students = new Student[3];

        students[0] = new Student(" Nguyễn Văn A ");
        students[1] = new Student(" Nguyễn Văn B ");
        students[2] = new Student(" Nguyễn Văn C ");

        Student.changeCollege("Đại học Bách Khoa hà Nội");

        for (Student student : students) {
            System.out.println(Student.getCollege());
        }
    }
}
