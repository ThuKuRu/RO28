package entity.Exception;

public class Account {
    private int id;
    private String email;
    private String username;
    private String fullname;
    private int age;

    public Account() {
        input();
    }

    private void input() {
        System.out.println("Nhập id: ");
        id = ScannerUtils.inputInt("Please input a number as int, please input again.");

        System.out.println("Nhập email: ");
        email = ScannerUtils.inputString("Please input a email, please input again.");

        System.out.println("Nhập username: ");
        username = ScannerUtils.inputString("Please input a String, please input again.");

        System.out.println("Nhập fullname: ");
        fullname = ScannerUtils.inputString("Please input a String, please input again.");

        System.out.println("Nhập tuổi của bạn: ");
        age = ScannerUtils.inputAge();

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                '}';
    }
}
