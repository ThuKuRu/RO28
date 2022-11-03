package entity.Exception;

public class Department {
    int     departmentID;

    String  departmentName;

    public Department() {
        input();
    }

    public Department(int i, String name) {
        this.departmentID = i;
        this.departmentName = name;
    }

    private void input() {
        System.out.println("Nhập id : ");
        departmentID = ScannerUtils.inputInt("Please input a id as int, please input again.");

        System.out.println("Nhập tên : ");
        departmentName = ScannerUtils.inputString("Please input a name, please input again.");
    }


    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
