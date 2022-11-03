package entity;

import java.util.Scanner;

public class CanBo {
    private String hoTen;
    private int tuoi;
    private GioiTinh gioiTinh;
    private String diaChi;

    public CanBo(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public CanBo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập vào họ tên: ");
        hoTen = scanner.nextLine();
        System.out.print("Mời bạn nhập vào tuổi: ");
        tuoi = scanner.nextInt();
        System.out.println(" Địa chỉ: ");
        diaChi = scanner.nextLine();
        System.out.print("Mời bạn nhập gioi tinh(1: Nam, 2: Nu, 3: KhongBiet): ");
        int i = scanner.nextInt();
        setGioiTinh(i);

    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    private void setGioiTinh(int gioiTinh) {
        if (gioiTinh == 1) {
            this.gioiTinh = GioiTinh.NAM;
        } else if (gioiTinh == 2) {
            this.gioiTinh = GioiTinh.NU;
        } else {
            this.gioiTinh = GioiTinh.KHONGBIET;
        }
    }

    @Override
    public String toString() {
        return "CanBo [hoTen=" + hoTen + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + "]";
    }

}
