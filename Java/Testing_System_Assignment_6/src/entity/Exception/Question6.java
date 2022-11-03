package entity.Exception;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args){
        inputAge();
    }

    public static void inputAge(){
        Scanner scanner = new Scanner(System.in);
        String age = null;
        do{
            System.out.println(" Tuổi: ");
            String age1 = scanner.nextLine();
            age = age1;
            try {
                int i = Integer.parseInt(age1);
                System.out.println(age1);
                break;
            } catch (NumberFormatException e) {
                System.out.println(" \" wrong inputing! Please input an age as int, input again \" ");
            }

        }while( age != null );
    }
}
