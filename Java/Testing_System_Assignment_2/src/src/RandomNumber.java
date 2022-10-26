import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class RandomNumber {
    public static void main(String[] args){
        // Question 1:
        System.out.println("Question 1: ");
        Random generator = new Random();
        System.out.println("Random Integer: " + generator.nextInt());

        // Question 2:
        System.out.println("\nQuestion 2: ");
        Random f = new Random();
        System.out.println("Random Integer: " + f.nextFloat());

        // Question 3:
        System.out.println("\nQuestion 3: ");
        String[] names =  {"Hoa", "Nam", "Hoàng", "Thu", "Hiếu", "Tuấn Anh", "Hạnh"};
        Random i = new Random(names.length);
        System.out.println(" Tên của 1 bạn ngẫu nhiên là: " + names[i.nextInt(names.length)]);

        // Question 4:
        System.out.println("\nQuestion 4: ");
        int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
        int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
        Random k = new Random(names.length);
        long randomInt = minDay + k.nextInt(maxDay - minDay);
        LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
        System.out.println(randomDay);

        // Question 5:
        System.out.println("\nQuestion 5: ");
        Random l = new Random(365);
        int now = (int) LocalDate.now().toEpochDay();
        randomInt = now - l.nextInt(365);
        randomDay = LocalDate.ofEpochDay(randomInt);
        System.out.println(randomDay);

        // Question 6:
        System.out.println("\nQuestion 6: ");
        Random m = new Random();
        int now1 = (int) LocalDate.now().toEpochDay();
        randomInt = now1 - m.nextInt(2022*365);
        randomDay = LocalDate.ofEpochDay(randomInt);
        System.out.println(randomDay);

        // Question 7:
        System.out.println("\nQuestion 7: ");
        Random h = new Random();
        int g = 100 + h.nextInt(999-100+1);
        System.out.println(g);
    }

}
