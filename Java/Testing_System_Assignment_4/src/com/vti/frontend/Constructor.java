package com.vti.frontend;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

import java.time.LocalDate;

public class Constructor {
    public static void main(String[] args){
        // Question 1:
        // a)
        Department dep1 = new Department();
        dep1.departmentID = 25;
        dep1.departmentName = "Bảo Vệ";

        // b)
        Department dep2 = new Department("Giám Đốc");
        System.out.println(dep2);
        System.out.println(dep1);

        // Question 2:
        Position pos1 = new Position();
        pos1.positionID = 1;
        pos1.positionName = Position.PositionName.DEV;
        Position pos2 = new Position();
        pos2.positionID = 2;
        pos2.positionName = Position.PositionName.SCRUM_MASTER;

        Position pos3 = new Position();
        pos3.positionID = 3;
        pos3.positionName = Position.PositionName.PM;
        // a)
        Account acc1 = new Account();
        acc1.accountID = 1;
        acc1.setEmail("abc1@gmail.com");
        acc1.setUsername("Username1");
        acc1.fullName = "FullName12345";
        acc1.departmentID = dep1;
        acc1.setPosition(pos1);
        acc1.setCreateDate(LocalDate.of(2022, 5, 23));
        // b)
        Account acc2 = new Account(2, "Thu8avukiet@gmail.com", "ThuKuRu", "Nguyễn Thị", "Thu");
        //c)
        Account acc3 = new Account(2, "Thu8avukiet@gmail.com", "ThuKuRu", "Nguyễn Thị", "Thu", pos1);
        //d)
        Account acc4 = new Account(2, "Thu8avukiet@gmail.com", "ThuKuRu", "Nguyễn Thị", "Thu", pos2, LocalDate.of(2020, 5, 25));
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println(acc4);

        // Question 3:
        // a)
        Group gr1 = new Group();
        gr1.groupID = 1;
        gr1.groupName = "GroupName1";
        gr1.setCreator(acc3);
        gr1.setCreateDate(LocalDate.of(2019, 9, 29));
        // b)
        Account[] accounts = {acc1, acc3, acc4};
        Group gr2 = new Group("Thực Tập", acc4.fullName, accounts , LocalDate.of(2019, 8, 30));
        // c)
        Account[] usernames = {acc1, acc2};
        Group gr3 = new Group("Hust", acc2.fullName, usernames, LocalDate.of(2019, 8, 30));
        System.out.println(gr1);
        System.out.println(gr2);
        System.out.println(gr3);

    }

}
