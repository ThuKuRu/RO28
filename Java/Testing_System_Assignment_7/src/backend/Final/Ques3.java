package backend.Final;

import entity.Final.PrimaryStudent;
import entity.Final.ScannerUtils;
import entity.Final.SecondaryStudent;
import entity.Final.Student;

import java.util.Scanner;

public class Ques3 {
    public static void question3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ID: ");
        int id = scanner.nextInt();
        System.out.println(" Họ tên: ");
        String name = ScannerUtils.inputString(" nhập 1 xâu");
        Student student = new Student(id, name);
        System.out.println(" Thông tin sinh viên vừa nhập: " + student);
        PrimaryStudent primaryStudent = new PrimaryStudent(id, name);
        System.out.println(primaryStudent);
        SecondaryStudent secondaryStudent = new SecondaryStudent(id, name);
        System.out.println(secondaryStudent);
        secondaryStudent.study();


    }
}
