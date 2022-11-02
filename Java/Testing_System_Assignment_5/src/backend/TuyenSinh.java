package backend;

import entity.Abstraction.Question2.Exeminees;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh{
    private Scanner scanner;

    private List<Exeminees> examinees;

    public TuyenSinh() {
        examinees = new ArrayList<Exeminees>();
        scanner = new Scanner(System.in);
    }


    @Override
    public void insert() {
        System.out.println("Nhập số thí sinh muốn nhập: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Exeminees examinee = new Exeminees();
            examinee.nhap();
            examinees.add(examinee);
        }
    }

    @Override
    public void print() {
        for (Exeminees examinee : examinees) {
            System.out.println(examinee);
        }
    }

    @Override
    public void search() {
            System.out.println("Nhập sbd cần tìm: ");
            String sbd = scanner.nextLine();
            for (Exeminees examinee : examinees) {
                if (examinee.getId().equals(sbd)) {
                    System.out.println(examinee);
                }
            }
        }
}
