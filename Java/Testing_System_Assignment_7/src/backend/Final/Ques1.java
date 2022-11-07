package backend.Final;

import entity.Final.MyMath;

import java.util.Scanner;

public class Ques1 {
    public void question1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" a = ");
        int a = scanner.nextInt();
        System.out.println(" Tổng của a và PI là: " + MyMath.sum(a));

        System.out.println(" Thay đổi PI = 3.15");
        MyMath.PI = 3.15f;
    }
}
