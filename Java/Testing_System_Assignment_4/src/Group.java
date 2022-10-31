import java.time.LocalDate;

public class Group {
    int         groupID;

    String      groupName;

    String creator;

    LocalDate createDate;

    Account[] accounts;

    public Group(){

    }

    public Group(String groupName, String creator,  Account[] accounts, LocalDate createDate){
        this.groupName = groupName;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    public Group(int id, String name, Account creator, String[] usernames, LocalDate createDate) {
        this.groupID = id;
        this.groupName = name;
        this.creator = String.valueOf(creator);
        Account[] accounts = new Account[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            accounts[i] = new Account(LocalDate.parse(usernames[i]));
        }
        this.createDate = createDate;
    }



    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", creatorID=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
