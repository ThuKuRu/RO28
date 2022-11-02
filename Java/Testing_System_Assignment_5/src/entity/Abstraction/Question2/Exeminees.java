package entity.Abstraction.Question2;

import java.util.Scanner;

public class Exeminees{
    private String id;
    private String name;
    private String address;
    private byte level;
    private Grade grade;

    public String getId() {
        return id;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số báo danh: ");
        id = scanner.nextLine();

        System.out.println("Nhập họ tên: ");
        name = scanner.nextLine();

        System.out.println("Nhập địa chỉ: ");
        address = scanner.nextLine();

        System.out.println("Nhập mức ưu tiên: ");
        level = scanner.nextByte();

        System.out.println("Nhập khối A/B/C");
        grade = new Grade();
        String list = scanner.nextLine();
        grade.setName(list);
    }

    @Override
    public String toString() {
        return "TuyenSinh{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", level=" + level +
                ", grade=" + grade +
                '}';
    }
}
