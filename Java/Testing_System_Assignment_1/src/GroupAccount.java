import java.time.LocalDate;

public class GroupAccount {
    Group       groupID;

    Account     accountID;

    LocalDate joinDate;

    @Override
    public String toString() {
        return "GroupAccount{" +
                "groupID=" + groupID +
                ", accountID=" + accountID +
                ", joinDate=" + joinDate +
                '}';
    }
}
