public class CategoryQuestion {
    int     categoryID;

    CategoryName  categoryName;

    public enum  CategoryName{
        JAVA, SQL, POSTMAN, RUBY;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "categoryID=" + categoryID +
                ", categoryName=" + categoryName +
                '}';
    }
}
