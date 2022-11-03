package entity.Exception;

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args){
        System.out.println(" Tuổi: ");
        Scanner scanner = new Scanner(System.in);
        String age = scanner.nextLine();
        inputAge(age);
    }

    public static void inputAge(String i){
        try {
            int age = Integer. parseInt(i);
            System.out.println(age);
        }catch (NumberFormatException e){
            System.out.println(" \" wrong inputing! Please input an age as int, input again \" ");
        }
    }


}
