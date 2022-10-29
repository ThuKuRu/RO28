package src;

import java.util.Locale;

public class Exercise3_BoxingUnboxing {
    public static void main(String[] args) {
        System.out.println(" Question 1: ");
        question1();
        System.out.println(" Question 2: ");
        question2();
        System.out.println(" Question 3: ");
        question3();
    }
    static void question1(){
        int i = 5000;
        float k = (float) i;
        System.out.format(Locale.FRANCE,"%10.2f%n%n", k);
    }

    static void question2(){
        String v = "1234567";
        int a = Integer.parseInt(v);
        System.out.println(a);
    }

    static void question3(){
        String v = "1234567";
        int b = Integer.parseInt(v);
        System.out.println(b);
    }


}
