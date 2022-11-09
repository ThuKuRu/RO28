package backend.Collection;

import entity.Student;

import java.util.*;

public class Question1 {
    static Scanner scanner = new Scanner(System.in);
    public void question1(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyễn Văn A"));
        students.add(new Student("Nguyễn Văn B"));
        students.add(new Student("Nguyễn Văn C"));
        students.add(new Student("Nguyễn Văn D"));
        students.add(new Student("Nguyễn Văn A"));
        students.add(new Student("Nguyễn Văn A"));
        students.add(new Student("Nguyễn Văn C"));
        students.add(new Student("Nguyễn Văn D"));

        System.out.println(" Tổng số phần tử của students: " + students.size());

        System.out.println(" Phần tử thứ 4 của students: " + students.get(3));

        System.out.println(" Phần tử đầu và phần tử cuối của students: " + students.get(0) + " và " + students.get(students.size() - 1));

        System.out.println(" Danh sách students: ");
        for(Student student : students){
           System.out.println(student);
        }
        for(int i = 0; i < students.size(); i ++){
            System.out.println(students.get(i));
        }
        System.out.println(" Thêm 1 phần tử vào vị trí đầu của students: ");
       students.add(0, new Student("Nguyễn Văn E"));
        for(Student student : students){
            System.out.println(student);
        }

        System.out.println(" Thêm 1 phần tử vào vị trí cuối của students:");
        students.add(students.size() , new Student("Nguyễn Văn F"));
        for(Student student : students){
            System.out.println(student);
        }

        System.out.println(" Đảo ngược vị trí của student");
        Collections.reverse(students);
        for(Student student : students){
            System.out.println(student);
        }

        findID(students);

        findName(students);

        sameName(students);

        removeStudentName(students, 2);

        removeStudent(students, 5);

        copyStudent(students);
    }

    public  void findID(List<Student> students){
        System.out.println(" Nhập ID muốn tìm kiếm: ");
        int findID = scanner.nextInt();
        int c = 0;
        for(int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == findID) {
                System.out.println(students.get(i));
                c++;
            }
        }
        if(c == 0){
            System.out.println(" Không tìm thấy student có id " + findID);
        }

    }

    public  void findName(List<Student> students){
        System.out.println(" Nhập tên muốn tìm: ");
        Scanner scanner1 = new Scanner(System.in);
        String findName = scanner1.nextLine();
        int c = 0;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getName().equals(findName)){
                System.out.println(students.get(i));
                c++;
            }
        }
        if(c == 0){
            System.out.println(" Không tìm thấy student có name là " + findName);
        }
    }

    /**
     * Find same name
     * @return No return
     * */
    public void sameName(List<Student> students) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < students.size(); i++) {
            if (map.get(students.get(i).getName()) != null) {
                map.put(students.get(i).getName(), map.get(students.get(i).getName()) + 1);
            } else {
                map.put(students.get(i).getName(), 1);
            }
        }
        boolean flag = false;
        // show Map
        Set set = map.keySet();
        for (Object key : set) {
            if (map.get(key) > 1) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.println(" Không có student nào trùng tên.");
        } else {
            System.out.println(" Danh sách trùng tên là: ");
            for (Object key : set) {
                if (map.get(key) > 1) {
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getName().equals(key)) {
                            System.out.println(students.get(i));
                        }
                    }
                }
            }
        }
    }

    public void removeStudentName(List<Student> students,int id){
        int k = 0;
        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                students.get(i).setName(null);
                k = i;
            }
        }
        System.out.println(students.get(k));
    }

    public void removeStudent(List<Student> students,int id){
        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                students.remove(i);
                System.out.println(" Xóa thành công");
            }
        }
        System.out.println(" Danh sách sau khi xóa: ");
        for (Student student : students){
            System.out.println(student);
        }
    }

    public void copyStudent(List<Student> students) {
        List<Student> studentCopies = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            studentCopies.add(new Student(students.get(i).getName()));
        }
        System.out.println(" Danh sách studentCopies là: ");
        for (Student studentcopy : studentCopies) {
            System.out.println(studentcopy);
        }
    }
}
