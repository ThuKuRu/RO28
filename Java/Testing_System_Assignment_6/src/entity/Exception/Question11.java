package entity.Exception;

import backend.InvalidAgeInputingException;

public class Question11 {
    private int id;
    private String email;
    private String username;
    private String fullname;
    private int age;

    public Question11() throws InvalidAgeInputingException {
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
        age = inputAge();

    }

    private int inputAge() throws InvalidAgeInputingException {
        int age = ScannerUtils.inputInt("Please input an age as int, please input again.");

        if (age < 0) {
            throw new InvalidAgeInputingException("The age must be greater than 0, please input again.");
        }

        return age;
    }

    @Override
    public String toString() {
        return "Question11{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                '}';
    }
}
