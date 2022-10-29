import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.text.ParseException;

public class InputFromConsole {

    public static void main(String[] args) throws ParseException {
        Department dep1 = new Department();
        dep1.departmentID = 1;
        dep1.departmentName = "Marketing";

        Department dep2 = new Department();
        dep2.departmentID = 2;
        dep2.departmentName = "Sale";

        Department dep3 = new Department();
        dep3.departmentID = 3;
        dep3.departmentName = "Bảo vệ";

        // Position
        Position pos1 = new Position();
        pos1.positionID = 1;
        pos1.positionName = Position.PositionName.DEV;

        Position pos2 = new Position();
        pos2.positionID = 2;
        pos2.positionName = Position.PositionName.TEST;

        Position pos3 = new Position();
        pos3.positionID = 3;
        pos3.positionName = Position.PositionName.PM;

        // Account
        Account acc1 = new Account();
        acc1.accountID = 1;
        acc1.email = "abc1@gmail.com";
        acc1.username = "Username1";
        acc1.fullName = "FullName12345";
        acc1.departmentID = dep1;
        acc1.positionID = pos3;
        acc1.createDate = LocalDate.of(2022, 5, 23);

        Account acc2 = new Account();
        acc2.accountID = 2;
        acc2.email = "abc2@gmail.com";
        acc2.username = "Username2";
        acc2.fullName = "FullName234";
        acc2.departmentID = dep2;
        acc2.positionID = pos2;
        acc2.createDate = LocalDate.of(2020, 5, 25);

        Account acc3 = new Account();
        acc3.accountID = 3;
        acc3.email = "abc3@gmail.com";
        acc3.username = "Username3";
        acc3.fullName = "FullName3";
        acc3.departmentID = dep3;
        acc3.positionID = pos1;
        acc3.createDate = LocalDate.of(2019, 2, 28);

        // Group
        Group gr1 = new Group();
        gr1.groupID = 1;
        gr1.groupName = "GroupName1";
        gr1.creatorID = acc3;
        gr1.createDate = LocalDate.of(2019, 9, 29);

        Group gr2 = new Group();
        gr2.groupID = 1;
        gr1.groupName = "GroupName2";
        gr2.creatorID = acc2;
        gr2.createDate = LocalDate.of(2016, 8, 28);

        Group gr3 = new Group();
        gr3.groupID = 1;
        gr3.groupName = "GroupName1";
        gr3.creatorID = acc2;
        gr3.createDate = LocalDate.of(2018, 12, 30);

//        // Question 1:
//        System.out.println("Question 1: ");
//        for (int i = 0 ; i < 3 ; i++){
//            System.out.println("Số thứ " + (i + 1) + " = " );
//            Scanner k = new Scanner(System.in);
//            int x = k.nextInt();
//            System.out.println("Số bạn vừa nhập là: " + x + "\n");
//        }
//
//        // Question 2:
//        System.out.println("\nQuestion 2: ");
//        for (int i = 0 ; i < 2 ; i++){
//            System.out.println("Số thứ " + (i + 1) + " = " );
//            Scanner k = new Scanner(System.in);
//            float x = k.nextFloat();
//            System.out.println("Số bạn vừa nhập là: " + x + "\n");
//        }
//
//        // Question 3:
//        System.out.println("\nQuestion 3: ");
//        System.out.println(" Họ :");
//        Scanner k1 = new Scanner(System.in);
//        String str1 = k1.nextLine();
//        System.out.println(" Tên :");
//        Scanner k2 = new Scanner(System.in);
//        String str2 = k2.nextLine();
//        System.out.println( str1 + " " + str2);
//
//        // Question 4:
//        System.out.println("\nQuestion 4: ");
//        System.out.println(" Ngày sinh :");
//        Scanner k3 = new Scanner(System.in);
//        String s = k3.next();
//        String d = "dd/MM/yyyy";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(d);
//        Date date = simpleDateFormat.parse(s);
//        System.out.println(s);
//
//
//        // Question 5:
//        System.out.println("\nQuestion 5: ");
//        inputAccount();
//
//        // Question 6:
//        System.out.println("\nQuestion 6: ");
//        inputDepartment();
//
//        // Question 7:
//        System.out.println("\nQuestion 7: ");
//        System.out.println("Nhập vào 1 số chẵn: ");
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//        scanner.close();
//        if (number % 2 == 0) {
//            System.out.println("Số vừa nhập là: " + number);
//        } else {
//            System.out.println("Nhập sai, vui lòng nhập lại");
//        }
//
//        // Question 8:
//        System.out.println("\nQuestion 8: ");
//        System.out.println("mời bạn nhập vào chức năng muốn sử dụng");
//        Scanner s1 = new Scanner(System.in);
//        scanner.close();
//        int n = s1.nextInt();
//        switch(n){
//            case 1:
//                inputAccount();
//                break;
//            case 2:
//                inputDepartment();
//                break;
//            default:
//            System.out.println("Mời bạn nhập lại");
//        }

        // Question 9:
        System.out.println("\nQuestion 9: ");
        Account[] acounts1 = {acc1, acc2, acc3};
        Group[] groups = {gr1, gr2, gr3};
         Scanner t = new Scanner(System.in);
         int n = 0;
        while (n != 6) {
            System.out.println(" ====================================================================================MENU====================================================================================");
            System.out.println(" 1.In ra tên các usernames \t 2.Nhập vào username của account \t 3.In ra tên các group \t 4.nhập vào tên của group \t 5.Thêm account vào group  \t 6.Thoát chương trình\n");
            System.out.println(" Chọn chức năng: ");
            int k = t.nextInt();
            n = k;
                switch (k) {
                    case 1:
                        inputAccount();
                        break;
                    case 2:
                        inputUsername();
                        break;
                    case 3:
                        outputGroup(groups);
                        break;
                    case 4:
                        inputGroup();
                        break;
                    case 5:
                        inputGroupUser();
                        break;
                    default:
                        if (n != 6) {
                            System.out.println(" Vui lòng nhập lại: ");
                        } else {
                            System.out.println(" Bạn đã thoát ra khỏi chương trình");
                        }
                }
        }

        // Question 10:
        System.out.println("\nQuestion 10: ");
        Scanner t1 = new Scanner(System.in);
        int n1 = 0;
        while (n1 != 4) {
            System.out.println(" ====================================================================================MENU====================================================================================");
            System.out.println(" 1.Tạo account \t 2.Tạo department \t 3.Thêm group vào account \t 4.Thoát chương trình\n");
            System.out.println(" Mời bạn nhập vào chức năng muốn sử dụng: ");
            int k1 = t.nextInt();
            n1 = k1;
            switch (k1) {
                case 1:
                    outputUser(acounts1);
                    break;
                case 2:
                    inputDepartment();
                    break;
                case 3:
                    inputGroupUser();
                    System.out.println(" \"Bạn có muốn thực hiện chức năng khác không? ( 0: kết thúc chương trình ; 1: nếu muốn tiếp tục)");
                    Scanner t2 = new Scanner(System.in);
                    int k2 = t2.nextInt();
                    if(k2 == 0){
                        n1 = 4;
                    }
                default:
                    if(n1 != 4){
                        System.out.println(" Vui lòng nhập lại: ");
                    }else{
                        System.out.println(" Bạn đã thoát ra khỏi chương trình");
                        break;
                    }
                break;
            }
        }

        // Question 11:
        System.out.println("\nQuestion 11: ");
        Scanner t2 = new Scanner(System.in);
        int n2 = 0;
        while (n2 != 5) {
            System.out.println(" ====================================================================================MENU====================================================================================");
            System.out.println(" 1.Tạo account \t 2.Tạo department \t 3.Thêm group vào account \t  4.Thêm account vào 1 nhóm ngẫu nhiên \t 5.Thoát chương trình\n");
            System.out.println(" Mời bạn nhập vào chức năng muốn sử dụng: ");
            int k2 = t.nextInt();
            n2 = k2;
            switch (k2) {
                case 1:
                    outputUser(acounts1);
                    break;
                case 2:
                    inputDepartment();
                    break;
                case 3:
                    inputGroupUser();
                    break;
                case 4:
                    inputAccount();
                    String a = inputUsername();
                    String[] groupNames = {gr1.groupName, gr2.groupName, gr3.groupName};
                    Random b = new Random(groupNames.length);
                    System.out.println(a + " thuộc group " + b);
                    break;
                default:
                    if(n2 != 5){
                        System.out.println(" Vui lòng nhập lại: ");
                    }else{
                        System.out.println(" Bạn đã thoát ra khỏi chương trình");
                    }
            }
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
        scanner.close();
    }

    public static void inputDepartment(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(" DepartmentID: ");
        int id = scanner.nextInt();
        scanner.close();
        Scanner scanner1 = new Scanner(System.in);
        System.out.print(" DepartmentName: ");
        String department = scanner1.nextLine();
    }

    static void outputUser(Account accounts[] ){
        for(int i = 0; i < accounts.length; i++) {
            System.out.println(" Account thứ " + (i + 1) + " là:");
            System.out.println(" ID: " + accounts[i].accountID);
            System.out.println(" Email: " + accounts[i].email);
            System.out.println(" Username: " + accounts[i].username);
        }
    }

    static String inputUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Username: ");
        String userName = scanner.nextLine();
        return userName;
    }

    static void outputGroup(Group groups[]){
        for(int i = 0; i < groups.length; i++) {
            System.out.println(" Account thứ " + (i + 1) + " là:");
            System.out.println(" ID: " + groups[i].groupID);
            System.out.println(" GroupName: " + groups[i].groupName);
            System.out.println(" Creator: " + groups[i].creatorID.fullName);
            System.out.println(" Ngày tạo: " + groups[i].createDate);
        }
    }

    static String inputGroup(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nhập tên group: ");
        String name = scanner.nextLine();
        return name;
    }

    static void inputGroupUser(){
        String a = inputUsername();
        String b = inputGroup();
        System.out.println(a + " thuộc group " + b);
    }


}

