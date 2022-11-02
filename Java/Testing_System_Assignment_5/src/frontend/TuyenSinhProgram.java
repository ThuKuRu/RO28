package frontend;

import backend.TuyenSinh;

import java.util.Scanner;

public class TuyenSinhProgram {
    public static void main(String[] args){
        TuyenSinh tuyenSinh = new TuyenSinh();
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while(n != 4) {
            System.out.println("===========================================MENU============================================");
            System.out.println("1. Thêm mới thí sinh \t 2. Hiện thông tin thí sinh \t Tìm kiếm theo số báo danh \t 4. Thoát");
            System.out.println("Chọn chức năng: ");
            int k = scanner.nextInt();
            n = k;
            switch (n) {

                case 1:
                    tuyenSinh.insert();
                    break;

                case 2:
                    tuyenSinh.print();
                    break;

                case 3:
                    tuyenSinh.search();
                    break;

                default:
                    if (n != 4) {
                        System.out.println(" Vui lòng nhập lại: ");
                    } else {
                        System.out.println(" Bạn đã thoát ra khỏi chương trình");
                        break;
                    }
                    break;
            }
        }
    }
}
