package backend;

import entity.PrimarySchool;
import entity.SecondarySchool;
import entity.Student;

public class Question6 {
    private static Student[] students;
    private static PrimarySchool[] primarySchoolStudents;
    private static SecondarySchool[] secondarySchoolStudents;
    public static void question6() throws Exception {
        students = new Student[6];
        students[0] = new Student(" Nguyễn Văn A ");
        students[1] = new Student(" Nguyễn Văn B ");
        students[2] = new Student(" Nguyễn Văn C ");

        primarySchoolStudents = new PrimarySchool[10];
        primarySchoolStudents[0] = new PrimarySchool(" Nguyễn Thị Thu");
        primarySchoolStudents[1] = new PrimarySchool(" Nguyễn Thị Thu Huệ");

        secondarySchoolStudents = new SecondarySchool[10];
        secondarySchoolStudents[0] = new SecondarySchool(" Trần Thu Hà");
        secondarySchoolStudents[1] = new SecondarySchool(" Trịnh Thu Trang");

        System.out.println(" Số Student được sinh ra: ");
        System.out.println(Student.count);
        System.out.println(" Số PrimaryStudent được sinh ra: ");
        System.out.println(PrimarySchool.count);
        System.out.println(" Số SecondaryStudent được sinh ra: ");
        System.out.println(SecondarySchool.count);

    }
}
