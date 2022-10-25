import java.time.LocalDate;
import java.time.LocalTime;

public class Program {
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

        //GroupAccount
        GroupAccount gra1 = new GroupAccount();
        gra1.groupID = gr3;
        gra1.accountID = acc2;
        gra1.joinDate = LocalDate.of(2021, 11, 11);

        GroupAccount gra2 = new GroupAccount();
        gra2.groupID = gr1;
        gra2.accountID = acc2;
        gra2.joinDate = LocalDate.of(2012, 5, 20);

        GroupAccount gra3 = new GroupAccount();
        gra3.groupID = gr2;
        gra3.accountID = acc3;
        gra3.joinDate = LocalDate.of(2020, 10, 9);

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

        // ExamQuestion
        ExamQuestion exq1 = new ExamQuestion();
        exq1.examID = e1;
        exq1.questionID = q2;

        ExamQuestion exq2 = new ExamQuestion();
        exq2.examID = e3;
        exq2.questionID = q2;

        ExamQuestion exq3 = new ExamQuestion();
        exq3.examID = e2;
        exq3.questionID = q1;

        // System.out.println(dep1);
        // System.out.println(pos1);
        // System.out.println(acc1);
        // System.out.println(gr1);
        // System.out.println(gra1);
        // System.out.println(caq1);
        // System.out.println(tyq1);
        // System.out.println(q1);
        // System.out.println(a1);
        // System.out.println(e1);
        // System.out.println(exq1);

        // Question 7:
        switch (acc1.positionID){
            case pos1:
                System.out.println("Đây là Developer");
            case pos2:
                System.out.println("Người này không phải là Developer");
            case pos3:
                System.out.println("Người này không phải là Developer");
        }
    }
    }

