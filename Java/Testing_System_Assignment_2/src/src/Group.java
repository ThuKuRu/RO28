import java.time.LocalDate;

public class Group {
    public Account[] accounts;
    int         groupID;

    String      groupName;

    Account     creatorID;

    LocalDate createDate;

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                '}';
    }
}