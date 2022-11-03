package entity;

import java.util.Scanner;

public class NhanVien extends CanBo{
    private String congViec;

    public NhanVien() {
        super();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Công  việc: ");
        congViec = scanner.nextLine();
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }
}
