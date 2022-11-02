package frontend;

import backend.MyNews;

import java.util.Scanner;

public class DemoProgram {
    public static void main(String[] args){
        MyNews myNews = new MyNews();
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        while (k != 4) {
            System.out.println("                              MyNews                              ");
            System.out.println(" 1. Insert news \t 2. View list news \t 3. Average rate \t 4. Exit");
            System.out.println(" Chọn chức năng: ");
            int input = scanner.nextInt();
            k = input;
            switch (k) {
                case 1:
                    myNews.insertNews();
                    break;
                case 2:
                    myNews.viewListNews();
                    break;
                case 3:
                    myNews.averageRate();
                    break;
                default:
                    if (k != 4) {
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
