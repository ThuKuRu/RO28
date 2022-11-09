package backend.Collection;

import com.sun.source.doctree.SeeTree;
import entity.Student;

import java.util.*;

public class Question3 {
    Scanner scanner = new Scanner(System.in);

    Set<Student> students = new HashSet<>();

    public void question3(){
        students.add(new Student("Nguyễn Văn A"));
        students.add(new Student("Nguyễn Văn B"));
        students.add(new Student("Nguyễn Văn C"));
        students.add(new Student("Nguyễn Văn D"));
        students.add(new Student("Nguyễn Văn A"));

        System.out.println(" Tổng số phần tử của students: " + students.size());
        printStudent();
    }

    public void printStudent(){
        List<Student> listStudents = new ArrayList<>();
        for(Iterator<Student> it = students.iterator(); it.hasNext(); ) {
            Student i = it.next();
            listStudents.add(i);
        }
        System.out.println(" Phần tử thứ 4 của students: " + listStudents.get(3));
    }


}
