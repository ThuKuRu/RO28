import java.time.LocalDate;
import java.time.LocalTime;

public class Exam {
    int                 examID;

    int                 code;

    String              title;

    CategoryQuestion    categoryID;

    LocalTime duration;

    Group               creatorID;

    LocalDate createDate;

    @Override
    public String toString() {
        return "Exam{" +
                "examID=" + examID +
                ", code=" + code +
                ", title='" + title + '\'' +
                ", categoryID=" + categoryID +
                ", duration=" + duration +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                '}';
    }
}
