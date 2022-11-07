package entity;

public class Student {
    public static String college ;
    public static int count = 0;

    public static int max = 7;
    public static int moneyGroup = 0;
    private int id;

    private String name;

    public Student(String name) throws Exception{
        if( count > max){
           throw new Exception(" Không thể thêm quá 7 sinh viên");
        }
        this.id = ++count;
        this.name = name;
        moneyGroup += 100;
    }

    public static int getMoneyGroup(int i) {
        moneyGroup = moneyGroup + i;
        return moneyGroup;
    }


    public static void changeCollege(String college) {
        Student.college = college;
    }

    public static String getCollege() {
        return college;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", collge='" + college + '\'' +
                '}';
    }
}
