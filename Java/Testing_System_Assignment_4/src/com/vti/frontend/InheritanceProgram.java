package com.vti.frontend;

import com.vti.backend.QLCB;
import com.vti.backend.QLTL;
import com.vti.backend.Inheritance;

import java.util.Scanner;

public class InheritanceProgram {
    public static void main(String[] args) {
        Inheritance inheritance = new Inheritance();
        question1_2();
        inheritance.question3();
        question4();
    }



    private static void menuQuesion1_2() {
        System.out.println("==========================================MENU==========================================");
        System.out.println(" 1. Thêm cán bộ \t 2. Hiện cán bộ \t 3.Tìm cán bộ  \t 4. Xóa cán bộ \t 5. Thoát ");
    }

    public static void question1_2() {
        QLCB qlcb = new QLCB();

        byte choose;
        do {
            Scanner scanner = new Scanner(System.in);
            menuQuesion1_2();
            choose = scanner.nextByte();

            switch (choose) {
                case 1:
                    qlcb.addCanBo();
                    break;
                case 2:
                    qlcb.printInforCanBo();
                    break;
                case 3:
                    qlcb.findCanBo();
                    break;
                case 4:
                    qlcb.deleteCanBo();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Nhập sai ! Vui lòng nhập lại");
                    break;
            }
        } while (choose != 5);

    }

    private static void menuQuestion4() {
        System.out.println("==========================================MENU==========================================");
        System.out.println(" 1. Thêm tài liệu \t 2. Hiện tài liệu \t 3. Tìm tài liệu \t 4. Xóa tài liệu \t 5. Thoát ");
    }

    public static void question4() {
        QLTL qltl = new QLTL();

        byte choose;
        do {
            menuQuestion4();
            Scanner scanner = new Scanner(System.in);

            choose = scanner.nextByte();
            switch (choose) {
                case 1:
                    qltl.inputTaiLieu();
                    break;
                case 2:
                    qltl.printTaiLieu();
                    break;
                case 3:
                    qltl.findTaiLieu();
                    break;
                case 4:
                    qltl.deleteTaiLieu();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Nhập sai ! Vui lòng nhập lại");
                    break;
            }
        } while (choose != 5);
    }
}
