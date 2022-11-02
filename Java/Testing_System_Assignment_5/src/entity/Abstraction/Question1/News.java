package entity.Abstraction.Question1;

public class News implements INews{

        private int id;

        private static String title;

        private static String publishDate;

        private static String author;

        private static String content;

        private static float averageRate;

        private int[] rates;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return News.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor(String author) {
        return News.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public int[] getRates() {
        return rates;
    }

    public void setRates(int[] rates) {
        this.rates = rates;
    }

    @Override
    public void Display() {

    }

    @Override
    public float Calculate() {
        return 0;
    }

    @Override
    public float Calculate(int[] rates) {
        return 0;
    }

    @Override
    public void display() {
        System.out.println( "title='" + title + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", averageRate=" + averageRate );
    }




    @Override
    public float calculate() {
        averageRate = (float) (rates[0] + rates[1] + rates[2])/3;
        return averageRate;
    }

    @Override
    public float calculate(int[] rates) {
        return 0;
    }

    public void setRates() {
        this.averageRate = averageRate;
    }
}
