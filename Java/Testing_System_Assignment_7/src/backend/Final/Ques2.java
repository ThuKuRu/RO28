package backend.Final;

import entity.Final.ScannerUtils;
import entity.Final.Student;

import java.util.Scanner;

public class Ques2 {
    public void question2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ID: ");
        int id = scanner.nextInt();
        System.out.println(" Họ tên: ");
        String name = ScannerUtils.inputString(" nhập 1 xâu");
        Student student = new Student(id, name);
        System.out.println(" Thông tin sinh viên vừa nhập: " + student);
    }
}
