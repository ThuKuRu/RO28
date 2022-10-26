import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class SystemOutPrintf {
public static void main(String[] args){
    // Question 1:
    System.out.println("Question 1: ");
    int i = 5;
    System.out.println("\t" + i);

    // Question 2:
    System.out.println("\nQuestion 2: ");
    int j = 100000000;
    System.out.format("\n\t%,d%n%n", j);

    // Question 3:
    System.out.println("\nQuestion 3: ");
    float k = 5.567098f;
    System.out.format(Locale.FRANCE,"%10.4f%n%n", k);

    // Question 4:
    System.out.println("\nQuestion 4: ");
    String hs = (" Nguyễn Văn A");
    System.out.printf("Tên tôi là" + hs + " và tôi đang độc thân\n");

    // Question 5:
    System.out.println("\nQuestion 5: ");
    String d = "dd/MM/yyyy HH:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(d);
    String date = simpleDateFormat.format(new Date());
    System.out.println(date);

}
}
