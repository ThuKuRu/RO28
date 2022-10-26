import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;

public class InputFromConsole {
    public static void main(String[] args) throws ParseException {
        // Question 1:
        System.out.println("Question 1: ");
        for (int i = 0 ; i < 3 ; i++){
            System.out.println("Số thứ " + (i + 1) + " = " );
            Scanner k = new Scanner(System.in);
            int x = k.nextInt();
            System.out.println("Số bạn vừa nhập là: " + x + "\n");
        }

        // Question 2:
        System.out.println("\nQuestion 2: ");
        for (int i = 0 ; i < 2 ; i++){
            System.out.println("Số thứ " + (i + 1) + " = " );
            Scanner k = new Scanner(System.in);
            float x = k.nextFloat();
            System.out.println("Số bạn vừa nhập là: " + x + "\n");
        }

        // Question 3:
        System.out.println("\nQuestion 3: ");
        System.out.println(" Họ :");
        Scanner k1 = new Scanner(System.in);
        String str1 = k1.nextLine();
        System.out.println(" Tên :");
        Scanner k2 = new Scanner(System.in);
        String str2 = k2.nextLine();
        System.out.println( str1 + " " + str2);

        // Question 4:
        System.out.println("\nQuestion 4: ");
        System.out.println(" Ngày sinh :");
        Scanner k3 = new Scanner(System.in);
        String s = k3.next();
        String d = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(d);
        Date date = simpleDateFormat.parse(s);
        System.out.println(s);

        // Question 5:
        System.out.println("\nQuestion 5: ");
        inputAccount();

        // Question 6:
        System.out.println("\nQuestion 6: ");
        InputDepartment();

        // Question 7:
        System.out.println("Nhập vào 1 số chẵn: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println("Số vừa nhập là: " + number);
        } else {
            System.out.println("Nhập sai, vui lòng nhập lại");
        }

        // Question 8:
        Scanner s1 = new Scanner(System.in);
        int n = s1.nextInt();
        System.out.println("mời bạn nhập vào chức năng muốn sử dụng");
        switch(n){
            case 1:
                inputAccount();
                break;
            case 2:
                InputDepartment();
                break;
            default:
            System.out.println("Mời bạn nhập lại");
        }

    }

    public static void inputAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Account ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();
        System.out.print(" Username: ");
        String userName = scanner.nextLine();

        System.out.print(" Department: ");
        String department = scanner.nextLine();

        System.out.print(" Position ID (tu 1 -> 5): ");
        int position = scanner.nextInt(6);
        switch (position) {
            case 1:
                System.out.print("Dev");
                break;
            case 2:
                System.out.print("Test");
                break;
            case 3:
                System.out.print("ScrumMaster");
                break;
            case 4:
                System.out.print("PM");
                break;
            default:
                System.out.print("SA");
        }

        System.out.print("\nGroup: ");
        scanner.nextLine();
        String groups = scanner.nextLine();

        System.out.print("\nCreateDate: ");
        String date = scanner.nextLine();
    }

    public static void InputDepartment(){
        Scanner scanner = new Scanner(System.in);

        System.out.print(" DepartmentID: ");
        int id = scanner.nextInt();

        System.out.print(" DepartmentName: ");
        String department = scanner.nextLine();
    }

}

