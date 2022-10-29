import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Exercise1_DatatypeCasting {
    public static void main(String[] args) {
        System.out.println("Question 1: ");
        question1();
        System.out.println("Question 2: ");
        question2();
        System.out.println("Question 3: ");
        question3();
        System.out.println("Question 4: ");
        question4();
    }
    static void question1(){
        float a1 = 5240.5f , a2 = 10970.055f;
        int b1 = (int) a1;
        int b2 = (int) a2;
        System.out.println("Lương của Account1 là: " + b1 + "$");
        System.out.println("Lương của Account2 là: " + b2 + "$");
    }

    static int question2(){
        Random h = new Random();
        int g = h.nextInt(99999);
        if(0 < g && g < 10){
            System.out.println("0000" + g);
        } else if (10 < g && g < 100) {
            System.out.println("000" + g);
        } else if (100 < g && g < 1000) {
            System.out.println("00" + g);
        } else if (1000 < g && g < 10000) {
            System.out.println("0" + g);
        }else {
            System.out.println(g);
        }
        return g;
    }

    static void question3(){
        int k = question2();
        String s = Integer.toString(k);
        System.out.println(" Hai số cuối của dãy là: " + s.substring(3));
    }

    static void question4(){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b;
        do {
             b = scanner.nextInt();
             if(b == 0){
                 System.out.println(" Vui lòng nhập b khác 0");
             }
        }while ( b == 0 );
        float c = (float)a / (float) b;
        System.out.println("Thương của chúng là: ");
        System.out.format(Locale.FRANCE,"%f%n%n", c);
    }

}
