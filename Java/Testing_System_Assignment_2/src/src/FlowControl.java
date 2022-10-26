import com.sun.source.tree.WhileLoopTree;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;

public class FlowControl {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // Department
        Department dep1 = new Department();
        dep1.departmentID = 1;
        dep1.departmentName = "Marketing";

        Department dep2 = new Department();
        dep2.departmentID = 2;
        dep2.departmentName = "Sale";

        Department dep3 = new Department();
        dep3.departmentID = 3;
        dep3.departmentName = "Bảo vệ";

        // Position
        Position pos1 = new Position();
        pos1.positionID = 1;
        pos1.positionName = Position.PositionName.DEV;

        Position pos2 = new Position();
        pos2.positionID = 2;
        pos2.positionName = Position.PositionName.TEST;

        Position pos3 = new Position();
        pos3.positionID = 3;
        pos3.positionName = Position.PositionName.PM;

        // Account
        Account acc1 = new Account();
        acc1.accountID = 1;
        acc1.email = "abc1@gmail.com";
        acc1.username = "Username1";
        acc1.fullName = "FullName12345";
        acc1.departmentID = dep1;
        acc1.positionID = pos3;
        acc1.createDate = LocalDate.of(2022, 5, 23);

        Account acc2 = new Account();
        acc2.accountID = 2;
        acc2.email = "abc2@gmail.com";
        acc2.username = "Username2";
        acc2.fullName = "FullName234";
        acc2.departmentID = dep2;
        acc2.positionID = pos2;
        acc2.createDate = LocalDate.of(2020, 5, 25);

        Account acc3 = new Account();
        acc3.accountID = 3;
        acc3.email = "abc3@gmail.com";
        acc3.username = "Username3";
        acc3.fullName = "FullName3";
        acc3.departmentID = dep3;
        acc3.positionID = pos1;
        acc3.createDate = LocalDate.of(2019, 2, 28);

        // Group
        Group gr1 = new Group();
        gr1.groupID = 1;
        gr1.groupName = "GroupName1";
        gr1.creatorID = acc3;
        gr1.createDate = LocalDate.of(2019, 9, 29);

        Group gr2 = new Group();
        gr2.groupID = 1;
        gr1.groupName = "GroupName2";
        gr2.creatorID = acc2;
        gr2.createDate = LocalDate.of(2016, 8, 28);

        Group gr3 = new Group();
        gr3.groupID = 1;
        gr3.groupName = "GroupName1";
        gr3.creatorID = acc2;
        gr3.createDate = LocalDate.of(2018, 12, 30);

        // TypeQuestion
        TypeQuestion tyq1 = new TypeQuestion();
        tyq1.typeID = 1;
        tyq1.typeName = TypeQuestion.TypeName.ESSAY;

        TypeQuestion tyq2 = new TypeQuestion();
        tyq2.typeID = 2;
        tyq2.typeName = TypeQuestion.TypeName.MULTIPLE_CHOICE;

        TypeQuestion tyq3 = new TypeQuestion();
        tyq3.typeID = 3;
        tyq3.typeName = TypeQuestion.TypeName.MULTIPLE_CHOICE;

        // CategoryQuestion
        CategoryQuestion caq1 = new CategoryQuestion();
        caq1.categoryID = 1;
        caq1.categoryName = CategoryQuestion.CategoryName.JAVA;

        CategoryQuestion caq2 = new CategoryQuestion();
        caq2.categoryID = 2;
        caq2.categoryName = CategoryQuestion.CategoryName.RUBY;

        CategoryQuestion caq3 = new CategoryQuestion();
        caq3.categoryID = 3;
        caq3.categoryName = CategoryQuestion.CategoryName.SQL;

        // Question
        Question q1 = new Question();
        q1.questionID = 1;
        q1.content = "Java Question";
        q1.creatorID = gr1;
        q1.categoryID = caq1;
        q1.typeID = tyq2;
        q1.createDate = LocalDate.of(2022, 10, 19);

        Question q2 = new Question();
        q2.questionID = 2;
        q2.content = "Java Question";
        q2.creatorID = gr2;
        q2.categoryID = caq2;
        q2.typeID = tyq3;
        q2.createDate = LocalDate.of(2022, 10, 19);

        Question q3 = new Question();
        q3.questionID = 1;
        q3.content = "Java Question";
        q3.creatorID = gr3;
        q3.categoryID = caq3;
        q3.typeID = tyq1;
        q3.createDate = LocalDate.of(2022, 10, 19);

        // Answer
        Answer a1 = new Answer();
        a1.answerID = 1;
        a1.content = "Answer1";
        a1.questionID = q3;
        a1.isCorrect = false;

        Answer a2 = new Answer();
        a2.answerID = 2;
        a2.content = "Answer2";
        a2.questionID = q2;
        a2.isCorrect = true;

        Answer a3 = new Answer();
        a3.answerID = 3;
        a3.content = "Answer3";
        a3.questionID = q1;
        a3.isCorrect = false;

        // Exam
        Exam e1 = new Exam();
        e1.examID = 1;
        e1.code = 1;
        e1.title = "Java";
        e1.categoryID = caq1;
        e1.creatorID = gr2;
        e1.duration = LocalTime.of(2, 0, 0, 0);
        e1.createDate = LocalDate.of(2022, 10, 19);

        Exam e2 = new Exam();
        e2.examID = 1;
        e2.code = 1;
        e2.title = "SQL";
        e2.categoryID = caq2;
        e2.creatorID = gr1;
        e2.duration = LocalTime.of(1, 30, 0, 0);
        e2.createDate = LocalDate.of(2022, 10, 19);

        Exam e3 = new Exam();
        e3.examID = 1;
        e3.code = 1;
        e3.title = "Ruby";
        e3.categoryID = caq3;
        e3.creatorID = gr3;
        e3.duration = LocalTime.of(0, 45, 0, 0);
        e3.createDate = LocalDate.of(2022, 10, 19);

        // Question 1:
        System.out.println("Question 1: ");
        if (acc2.departmentID == null) {
            System.out.println(" Nhân viên này chưa có phòng ban");
        } else {
            System.out.println(" Phòng ban của nhân viên này là : " + acc2.departmentID.departmentName);
        }

        // Question 2:
        System.out.println("\nQuestion 2: ");
        Group[] groupOfAccount1 = {gr1};
        acc1.groups = groupOfAccount1;

        Group[] groupOfAccount2 = {gr3};
        acc2.groups = groupOfAccount2;

        Group[] groupOfAccount3 = {gr1};
        acc3.groups = groupOfAccount3;

        if (acc2.groups == null || acc2.groups.length == 0) {
            System.out.println(" Nhân viên này chưa có group");
        } else if (acc2.groups.length == 1 || acc2.groups.length == 2) {
            System.out.println(" Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (acc2.groups.length == 3) {
            System.out.println(" Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println(" Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

        // Question 3:
        System.out.println("\nQuestion 3: ");
        System.out.println(acc2.departmentID == null
                ? " Nhân viên này chưa có phòng ban"
                : " Phòng ban của nhân viên này là : " + acc2.departmentID.departmentName);

        // Question 4:
        System.out.println("\nQuestion 4: ");
        System.out.println(acc1.Position == "DEV"
                ? " Đây là Developer"
                : " Người này không phải là Developer");

        // Question 5:
        System.out.println("\nQuestion 5: ");
        Account[] accountOfGroups1 = { acc1, acc2, acc3 };
        gr1.accounts = accountOfGroups1;
        int x = gr1.accounts.length;
        switch (x){
            case 1:
                System.out.println(" Nhóm có một thành viên");
                break;
            case 2:
                System.out.println(" Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println(" Nhóm có ba thành viên");
                break;
            default:
                System.out.println(" Nhóm có nhiều thành viên");
        }

        // Question 6:
        System.out.println("\nQuestion 6: ");
        int y = acc2.groups.length;
        switch (y){
            case 0:
                System.out.println(" Nhân viên này chưa có group");
                break;
            case 1:
                System.out.println(" Group của nhân viên này là: " + acc2.groups[0].groupName);
                break;
            case 2:
                System.out.println(" Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println(" Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println(" Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

        // Question 7:
        System.out.println("\nQuestion 7: ");
        int z = 0;
        if(acc1.Position == "DEV"){
            z = 1;
        }
        switch(z){
            case 1:
                System.out.println(" Đây là Developer");
                break;
            default:
                System.out.println(" Người này không phải là Developer");
        }

        // Question 8:
        System.out.println("\nQuestion 8: ");
        int i = 0;
        Account[] accounts = { acc1, acc2, acc3 };
        for (Account account : accounts) {
            i = i + 1;
            System.out.println(" Acc" + i);
            System.out.println(" Email: " + account.email);
            System.out.println(" FullName: " + account.fullName);
            System.out.println(" Name Department: " + account.departmentID.departmentName);
        }
        // Question 9:
        System.out.println("\nQuestion 9: ");
        int i1 =0;
        Department[] departments = {dep1, dep2, dep3};
        for (Department department : departments){
            i1 = i1 + 1;
            System.out.println(" Phòng ban thứ " + i1);
            System.out.println(" ID: " + department.departmentID);
            System.out.println(" Name: "+ department.departmentName);
        }

        // Question 10:
        System.out.println("\nQuestion 10: ");
        for(int j = 0; j < accounts.length; j++){
            System.out.println(" Thông tin account thứ " + (j + 1) + " là: ");
            System.out.println(" Email: " + accounts[j].email);
            System.out.println(" FullName: " + accounts[j].fullName);
            System.out.println(" Phòng ban: " + accounts[j].departmentID.departmentName);
        }

        // Question 11:
        System.out.println("\nQuestion 11: ");
        for(int t = 0; t < departments.length; t++ ){
            System.out.println(" Thông tin department thứ " + (t + 1) + " là: ");
            System.out.println(" ID: " + departments[t].departmentID);
            System.out.println(" Name: "+ departments[t].departmentName);
        }
        // Question 12:
        System.out.println("\nQuestion 12: ");
        for (int a = 0; a < 2; a++){
            System.out.println(" Thông tin department thứ " + (a + 1) + " là: ");
            System.out.println(" ID: " + departments[a].departmentID);
            System.out.println(" Name: "+ departments[a].departmentName);
        }
        // Question 13:
        System.out.println("\nQuestion 13: ");
        for(int b = 0; b < accounts.length; b++){
            if(b != 1) {
                System.out.println(" Thông tin account thứ " + (b + 1) + " là: ");
                System.out.println(" Email: " + accounts[b].email);
                System.out.println(" FullName: " + accounts[b].fullName);
                System.out.println(" Phòng ban: " + accounts[b].departmentID.departmentName);
            }
        }

        // Question 14:
        System.out.println("\nQuestion 14: ");
        for(int c = 0; c < accounts.length; c++){
            if(accounts[c].accountID < 4) {
                System.out.println(" Thông tin account thứ " + (c + 1) + " là: ");
                System.out.println(" Email: " + accounts[c].email);
                System.out.println(" FullName: " + accounts[c].fullName);
                System.out.println(" Phòng ban: " + accounts[c].departmentID.departmentName);
            }
        }

        // Question 15:
        System.out.println("\nQuestion 15: ");
        for (int d = 2; d <= 20; d = d + 2) {
            System.out.println(d);
        }

        // Question 16:
        System.out.println("\nQuestion 16: ");
        // 16.10:
        System.out.println("Question 16_10: ");
        int e = 0;
        while(e < accounts.length){
            System.out.println(" Thông tin account thứ " + (e + 1) + " là: ");
            System.out.println(" Email: " + accounts[e].email);
            System.out.println(" FullName: " + accounts[e].fullName);
            System.out.println(" Phòng ban: " + accounts[e].departmentID.departmentName);
            e++;
        }

        //16.11
        System.out.println("Question 16_11: ");
        int i2 = 0;
        while (i2 < departments.length){
            System.out.println(" Thông tin department thứ " + (i2 + 1) + " là: ");
            System.out.println(" ID: " + departments[i2].departmentID);
            System.out.println(" Name: " + departments[i2].departmentName);
            i2++;
        }

        //16.12
        System.out.println("Question 16_12: ");
        int i3 = 0;
        while (i3 < 2){
            System.out.println(" Thông tin department thứ " + (i3 + 1) + " là: ");
            System.out.println(" ID: " + departments[i3].departmentID);
            System.out.println(" Name: "+ departments[i3].departmentName);
            i3++;
        }

        //16.13
        System.out.println("Question 16_13: ");
        int i4 = 0;
        while (i4 < accounts.length){
            if (i4 == 1) {
                i4++;
                continue;
            }
                System.out.println(" Thông tin account thứ " + (i4 + 1) + " là: ");
                System.out.println(" Email: " + accounts[i4].email);
                System.out.println(" FullName: " + accounts[i4].fullName);
                System.out.println(" Phòng ban: " + accounts[i4].departmentID.departmentName);
                i4++;
        }

        //16.14
        System.out.println("Question 16_14: ");
        int i5 = 0;
        while (i5 < accounts.length){
            if(accounts[i5].accountID < 4) {
                System.out.println(" Thông tin account thứ " + (i5 + 1) + " là: ");
                System.out.println(" Email: " + accounts[i5].email);
                System.out.println(" FullName: " + accounts[i5].fullName);
                System.out.println(" Phòng ban: " + accounts[i5].departmentID.departmentName);
                i5++;
            }
        }

        //16.15
        System.out.println("Question 16_15: ");
        int i6 = 0;
        while(i6 <= 20){
            System.out.println(i6);
            i6 = i6 + 2;
        }

        // Question 17:
        System.out.println("\nQuestion 17: ");
        //17.10
        System.out.println("Question 17_10: ");
        int k = 0;
        do{
            System.out.println(" Thông tin account thứ " + (k + 1) + " là: ");
            System.out.println(" Email: " + accounts[k].email);
            System.out.println(" FullName: " + accounts[k].fullName);
            System.out.println(" Phòng ban: " + accounts[k].departmentID.departmentName);
            k++;
        } while (k != accounts.length);

        //17.11
        System.out.println("Question 17_11: ");
        int u = 0;
        do{
            System.out.println(" Thông tin department thứ " + (u + 1) + " là: ");
            System.out.println(" ID: " + departments[u].departmentID);
            System.out.println(" Name: " + departments[u].departmentName);
            u++;
        }while (u != departments.length);

        //17.12
        System.out.println("Question 17_12: ");
        int r = 0;
        do{
            System.out.println(" Thông tin department thứ " + (r + 1) + " là: ");
            System.out.println(" ID: " + departments[r].departmentID);
            System.out.println(" Name: " + departments[r].departmentName);
            r++;
        }while (r != 2);

        //17.13
        System.out.println("Question 17_13: ");
        int q = 0;
        do{
            if (q == 1) {
                q++;
                continue;
            }
            System.out.println(" Thông tin department thứ " + (q + 1) + " là: ");
            System.out.println(" ID: " + departments[q].departmentID);
            System.out.println(" Name: " + departments[q].departmentName);
            q++;
        }while (q != departments.length);

        //17.14
        System.out.println("Question 17_14: ");
        int p = 0;
        do{
            if(accounts[p].accountID < 4) {
                System.out.println(" Thông tin account thứ " + (p + 1) + " là: ");
                System.out.println(" Email: " + accounts[p].email);
                System.out.println(" FullName: " + accounts[p].fullName);
                System.out.println(" Phòng ban: " + accounts[p].departmentID.departmentName);
                p++;
            }
        }while (p != accounts.length);

        //17.15
        System.out.println("Question 17_15: ");
        int w = 0;
        do{
            System.out.println(w);
            w = w + 2;
        }while(w != 22);

    }
}


