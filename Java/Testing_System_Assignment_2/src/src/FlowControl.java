import java.time.LocalDate;
import java.time.LocalTime;

public class FlowControl {
    /*
     Question 1:
     Kiểm tra account thứ 2
     Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
     "Nhân viên này chưa có phòng ban"
      Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là ..."
    */
            if(acc2.departmentID == null){
                System.out.println(" Nhân viên này chưa có phòng ban");
            }else{
                System.out.println(" Phòng ban của nhân viên này là : " + acc2.departmentID);
            }


    // Question 2:
    int count = 0;
         if(gr1.creatorID == acc2){
        count = count + 1;
    }
        if(gr2.creatorID == acc2){
        count = count + 1;
    }
        if(gr3.creatorID == acc2){
        count = count + 1;
    }
        if(count == 0){
        System.out.println("Nhân viên này chưa có group");
    } else if (count == 1 || count == 2) {
        System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
    } else if (count == 3) {
        System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
    }else
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
}

        // Question 3:
            System.out.println(acc2.departmentID == null
            ? " Nhân viên này chưa có phòng ban"
            : " Phòng ban của nhân viên này là : " + acc2.departmentID);

        // Question 4:
                 System.out.println(acc1.positionID == pos1
                ? "Đây là Developer"
                : "Người này không phải là Developer");
                }
        // Question 5:
                    int i = 0;
                    if (gra1.groupID == gr1) {
                    i = i + 1;
                    };
                    if (gra2.groupID == gr1) {
                    i = i + 1;
                    };
                    if (gra3.groupID == gr1) {
                    i = i + 1;
                    };
                    switch (i) {
                    case 1:
                    System.out.println("Nhóm có một thành viên");
                    break;
                    case 2:
                    System.out.println("Nhóm có hai thành viên");
                    break;
                    case 3:
                    System.out.println("Nhóm có ba thành viên");
                    break;
                    case 4:
        System.out.println("Nhóm có nhiều thành viên");
        break;
        }

        // Question 6:
        int count = 0;
        if (gr1.creatorID == acc2) {
        count = count + 1;
        }
        if (gr2.creatorID == acc2) {
        count = count + 1;
        }
        if (gr3.creatorID == acc2) {
        count = count + 1;
        }
        switch (count) {
        case 1:
        System.out.println("Nhân viên này chưa có group");
        case 2:
        System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        case 3:
        System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        case 4:
        System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
}


