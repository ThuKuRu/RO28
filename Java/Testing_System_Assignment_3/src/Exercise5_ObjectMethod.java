package src;

public class Exercise5_ObjectMethod {
    public static void main(String[] args){
        // Department
        Department dep1 = new Department();
        dep1.departmentID = 1;
        dep1.departmentName = "Marketing";

        Department dep2 = new Department();
        dep2.departmentID = 2;
        dep2.departmentName = "Sale";

        Department dep3 = new Department();
        dep3.departmentID = 3;
        dep3.departmentName = "Accounting";

        Department dep4 = new Department();
        dep4.departmentID = 4;
        dep4.departmentName = "Boss of director";

        Department dep5 = new Department();
        dep5.departmentID = 5;
        dep5.departmentName = "Waiting room";

        Department[] departments = {dep1, dep2, dep3, dep4, dep5};

        System.out.println("Question 1: ");
        question1(dep1);
        System.out.println("Question 2: ");
        question2(departments);
        System.out.println("Question 3: ");
        question3(dep1);
        System.out.println("Question 4: ");
        question4(dep1);
        System.out.println("Question 5: ");
        question5(dep1, dep2);
        System.out.println("Question 6: ");
        question6(departments);
        System.out.println("Question 7: ");
        question7(departments);
    }

    static void question1(Department department){
            System.out.println(" Phòng ban thứ nhất: ");
            System.out.println(" ID: " + department.departmentID);
            System.out.println(" DepartmentName: " + department.departmentName);
    }

    static void question2(Department[] departments){
        for(int i = 0; i < departments.length; i++) {
            System.out.println(" Phòng ban thứ " + (i + 1) + ":");
            System.out.println(" ID: " + departments[i].departmentID);
            System.out.println(" DepartmentName: " + departments[i].departmentName);
        }
    }

    static void question3(Department department){
        System.out.println(" Địa chỉ phòng ban thứ nhất: " + department.hashCode());
    }

    static void question4(Department department){
        if(department.departmentName.equals("Phòng A")){
            System.out.println(" Phòng ban thứ 1 có tên là \"phòng A\"");
        }else {
            System.out.println(" Phòng ban thứ 1 không phải tên là \"phòng A\"");
        }
    }

    static void question5(Department dep1, Department dep2){
        if(dep1.departmentName.equals(dep2.departmentName)){
            System.out.println(" Hai phòng ban này bằng nhau");
        }else{
            System.out.println(" Hai phòng ban này không bằng nhau");
        }
    }

    static void question6(Department[] departments){
        for (int i = 0; i < departments.length; i++) {
            for (int j = 0; j < departments.length - 1; j++) {
                if (departments[i].departmentName.compareToIgnoreCase(departments[j].departmentName) < 0) {
                    Department temp = departments[i];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }
        for(int i = 0; i < departments.length; i++) {
            System.out.println(departments[i].departmentName);
        }
    }

    static void question7(Department[] departments){
        for (int i = 0; i < departments.length; i++) {
            String r = reverseWords(departments[i].departmentName);
            for (int j = 0; j < departments.length - 1; j++) {
                String reverseName = reverseWords(departments[j].departmentName);
                if (r.compareToIgnoreCase(reverseName) < 0) {
                    Department temp = departments[i];
                    departments[i] = departments[j];
                    departments[j] = temp;
                }
            }
        }
        for(int i = 0; i < departments.length; i++) {
            System.out.println(departments[i].departmentName);
        }
    }

    private static String reverseWords(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");

        String[] words = str.split(" ");

        str = "";
        for (int i = words.length - 1; i >= 0; i--) {
            str += words[i] + " ";
        }

        return str.substring(0, str.length() - 2);
    }
}
