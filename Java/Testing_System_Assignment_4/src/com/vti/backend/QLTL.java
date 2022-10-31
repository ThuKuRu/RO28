package com.vti.backend;

import com.vti.entity.Inheritance.Question4.Bao;
import com.vti.entity.Inheritance.Question4.Sach;
import com.vti.entity.Inheritance.Question4.TaiLieu;
import com.vti.entity.Inheritance.Question4.TapChi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLTL {
    private List<TaiLieu> taiLieus;

    public QLTL() {
        taiLieus = new ArrayList<>();
    }

    // a) Thêm mới tài liêu: Sách, tạp chí, báo.
    public void inputTaiLieu() {
        int n;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số tài liệu mà bạn muốn nhập:  ");
        n = scanner.nextInt();

        byte choose;
        TaiLieu taiLieu = new TaiLieu();
        for (int i = 0; i < n; i++) {

            System.out.println("Bạn muốn nhập tài liệu nào? (1:Sách || 2: Tạp chí || 3: Báo) ");
            choose = scanner.nextByte();

            switch (choose) {
                case 1:
                    taiLieu = new Sach();
                    break;
                case 2:
                    taiLieu = new TapChi();
                    break;
                case 3:
                    taiLieu = new Bao();
                    break;
                default:
                    System.out.println("Nhập sai !");
                    i--;
                    break;
            }
            taiLieu.input();
            taiLieus.add(taiLieu);
        }
    }

    // b) Xoá tài liệu theo mã tài liệu.
    public void deleteTaiLieu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập mã tài liệu cần xóa: ");
        int maTaiLieu = scanner.nextInt();

        for (TaiLieu taiLieu : taiLieus) {
            if (maTaiLieu == taiLieu.getMaTaiLieu()) {
                taiLieus.remove(taiLieu);
            }
        }
    }

    // c) Hiện thị thông tin về tài liệu.
    public void printTaiLieu() {
        for (TaiLieu taiLieu : taiLieus) {
            taiLieu.getInfor();
        }
    }

    // d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
    public void findTaiLieu() {
        Scanner scanner = new Scanner(System.in);

        int choose;
        System.out.println("Bạn muốn tìm kiếm theo loại nào? (1:Sách || 2: Tạp chí || 3: Báo)");
        choose = scanner.nextByte();

        switch (choose) {
            case 1:
                for (TaiLieu taiLieu : taiLieus) {
                    if (taiLieu instanceof Sach) {
                        taiLieu.getInfor();
                    }
                }
                break;
            case 2:
                for (TaiLieu taiLieu : taiLieus) {
                    if (taiLieu instanceof TapChi) {
                        taiLieu.getInfor();
                    }
                }
                break;
            case 3:
                for (TaiLieu taiLieu : taiLieus) {
                    if (taiLieu instanceof Bao) {
                        taiLieu.getInfor();
                    }
                }
                break;
            default:
                System.out.println("Nhập sai !");
                break;
        }
    }

}
