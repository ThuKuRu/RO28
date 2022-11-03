package backend;
import java.util.Scanner;

import entity.QLCB;

public class Exercise2 {
    public void question1_2() {
        Scanner scanner = new Scanner(System.in);
        QLCB qlcb = new QLCB();

        int n = 0;
        while (n != 5) {
            System.out.println("Mời bạn nhập vào chức năng muốn dùng\n" +
                    "1.Thêm mới cán bộ\t" + "2.Tìm kiếm theo họ tên\t"
                    + "3.Hiện thị thông tin về danh sách các cán bộ.\t" + "4.Nhập vào tên của cán bộ và delete cán bộ đó\t"
                    + "5.Thoát khỏi chương trình.");
            System.out.print("Mời bạn chọn chức năng: ");
            int choose = scanner.nextInt();
            n = choose;
            switch (n) {
                case 1:
                    qlcb.addCanBo();
                    break;
                case 2:
                    qlcb.findByName();
                    break;
                case 3:
                    qlcb.printListCanBo();
                    break;
                case 4:
                    qlcb.deleteCanBo();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Bạn đã nhập sai. Bạn chỉ được nhập từ 1 tới 5 thôi!");
                    break;
            }
        }
    }
}
