package src;

import java.time.LocalDate;

public class Exercise2_DefaultValue {
    public static void main(String[] args) {
        Question1();
    }

    static void Question1(){
       String[] accounts = {};
       for(int i = 0; i < 5; i++){
           System.out.println(" Account thứ " + (i + 1));
           System.out.println(" Email: " + " \" Email" + (i + 1) + "\"");
           System.out.println(" FullName: " + " \" FullName" + (i + 1) + "\"");
           LocalDate localdate = LocalDate.now();
           System.out.println(" CreateDate: " + localdate);
       }
    }
}
