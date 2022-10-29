package src;

import java.time.LocalDate;

public class Question {
    int                 questionID;

    String              content;

    CategoryQuestion    categoryID;

    TypeQuestion        typeID;

    Group     creatorID;

    LocalDate createDate;

    @Override
    public String toString() {
        return "Question{" +
                "questionID=" + questionID +
                ", content='" + content + '\'' +
                ", categoryID=" + categoryID +
                ", typeID=" + typeID +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                '}';
    }
}
