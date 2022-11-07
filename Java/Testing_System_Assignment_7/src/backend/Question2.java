package backend;

import entity.Student;

public class Question2 {
    private Student[] students;

    public void question2()throws Exception{
        int k = 0;
        students = new Student[3];
        for (int i = 0; i < 3; i++){
            Student.moneyGroup += 100;
        }
        k = Student.moneyGroup;
        System.out.println(k);
        System.out.println(" Số tiền của nhóm ban đầu: ");
        System.out.println(Student.getMoneyGroup(0));

        System.out.println(" Số tiền của nhóm sau khi Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan: ");
        System.out.println(Student.getMoneyGroup(- 50) );

        System.out.println(" Số tiền của nhóm sau khi Student thứ 2 lấy 20k đi mua bánh mì: ");
        System.out.println(Student.getMoneyGroup(- 20));

        System.out.println(" Số tiền của nhóm sau khi Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm: ");
        System.out.println(Student.getMoneyGroup(- 150) );

        System.out.println(" Số tiền sau khi cả nhóm mỗi người lại đóng quỹ mỗi người 50k: ");
        System.out.println(Student.getMoneyGroup(+ 150));
    }
}
