import java.time.LocalDate;

public class Account {
    int             accountID;

    String          email;

    String          username;

    String          fullName;

    Department      departmentID;

    Position        positionID;

    LocalDate createDate;

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", departmentID=" + departmentID +
                ", positionID=" + positionID +
                ", createDate=" + createDate +
                '}';
    }
}


