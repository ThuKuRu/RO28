import java.time.LocalDate;

public class Module {
    public static void main(String[] args){
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

        Account[] accounts = {acc1, acc2, acc3};
        // Question 1:
        System.out.println("Question 1: ");
        inputInteger1();

        // Question 2:
        System.out.println("Question 2: ");
        outputAccount(accounts);

        // Question 3:
        System.out.println("Question 3: ");
        inputInteger2();
    }

    static void inputInteger1(){
        System.out.println("Các số chẵn nguyên dương nhỏ hơn 10 là: ");
        for(int i = 0; i < 10 ; i++){
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
    static void outputAccount(Account[] accounts){
        for(int i = 0; i < accounts.length; i++){
            System.out.println(" Account thứ " + (i +1) + " là:");
            System.out.println(" ID: " + accounts[i].accountID);
            System.out.println(" Email: " + accounts[i].email);
            System.out.println(" Username: " + accounts[i].username);
            System.out.println(" Fullname: " + accounts[i].fullName);
            System.out.println(" Department: " + accounts[i].departmentID.departmentName);
            System.out.println(" Position: " + accounts[i].positionID.positionName);
            System.out.println(" Ngày tạo: " + accounts[i].createDate);
        }
    }

    static void inputInteger2() {
        System.out.println("Các số nguyên dương nhỏ hơn 10 là: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
