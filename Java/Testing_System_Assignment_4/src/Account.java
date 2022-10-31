import java.time.LocalDate;

public class Account {
    int             accountID;

    String          email;

    String          username;

    String          fullName;

    Department      departmentID;

    Position        position;

    LocalDate createDate;

    public Account(){

    }

    public Account(Department departmentID){

        this.departmentID = departmentID;
    }

    public Account(Position positionID){
        this.position = position;
    }

    public Account(LocalDate createDate){
        this.createDate = createDate;
    }

    public Account(int id, String email, String username, String firstname, String lastname, Position position){
        this.accountID = id;
        this.email = email;
        this.username = username;
        this.fullName = firstname + lastname;
        this.position = position;
        this.createDate = LocalDate.now();
    }

    public Account(int id, String email, String username, String firstname, String lastname){
        this.accountID = id;
        this.email = email;
        this.username = username;
        this.fullName = firstname + lastname;
    }

    public Account(int id, String email, String username, String firstname, String lastname, Position position, LocalDate createDate){
        this.accountID = id;
        this.email = email;
        this.username = username;
        this.fullName = firstname + lastname;
        this.position = position;
        this.createDate = createDate;
    }



    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", departmentID=" + departmentID +
                ", positionID=" + position +
                ", createDate=" + createDate +
                '}';
    }
}
