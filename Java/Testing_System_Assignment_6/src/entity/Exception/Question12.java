package entity.Exception;

import backend.InvalidAgeInputingException;

import static entity.Exception.ScannerUtils.inputAge;

public class Question12 {
    private int id;
    private String email;
    private String username;
    private String fullname;
    private int age;

    public Question12() throws InvalidAgeInputingException {
        input();
    }

    private void input() throws InvalidAgeInputingException {
        System.out.println("Nhập id: ");
        id = ScannerUtils.inputInt("Please input a number as int, please input again.");

        System.out.println("Nhập email: ");
        email = ScannerUtils.inputString("Please input a email, please input again.");

        System.out.println("Nhập username: ");
        username = ScannerUtils.inputString("Please input a String, please input again.");

        System.out.println("Nhập fullname: ");
        fullname = ScannerUtils.inputString("Please input a String, please input again.");

        System.out.println("Nhập tuổi của bạn: ");
        age = inputAccountAge();

    }

    private int inputAccountAge() {
        while (true) {
            int age = inputAge();
            if (age < 18) {
                System.out.println("Your age must be greater than 18, please input again.");
            } else {
                return age;
            }
        }
    }

    @Override
    public String toString() {
        return "Question12{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                '}';
    }
}
