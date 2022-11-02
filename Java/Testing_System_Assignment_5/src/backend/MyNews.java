package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Abstraction.Question1.News;

public class MyNews extends News{
    private List<News> newsList;

    public MyNews() {
        newsList = new ArrayList<>();
    }
    public void insertNews(){
        News news = new News();
        int[] rates = new int[3];

        Scanner scanner = new Scanner(System.in);
        News object = new News();
        System.out.println(" Title: ");
        String title = scanner.nextLine();
        object.setTitle(title);
        System.out.println(" PublishDate: ");
        String pub = scanner.nextLine();
        object.setPublishDate(pub);
        System.out.println(" Author: ");
        String author = scanner.nextLine();
        object.setAuthor(author);
        System.out.println(" Content: ");
        String content = scanner.nextLine();
        object.setContent(content);
        System.out.println(" Vui lòng đánh giá:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Đánh giá " + (i + 1) + ": ");
            rates[i] = scanner.nextInt();
        }
        news.setRates(rates);

        newsList.add(news);
    }

    public void viewListNews(){
        for (News news : newsList) {
            news.display();
        }
    }

    public void averageRate(){
        for (News news : newsList) {
            System.out.println("Title: " + news.getTitle() +"\n" + " Average Rate: " + news.calculate());
        }
    }
}
