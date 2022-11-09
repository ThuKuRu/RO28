package backend.Collection;

import entity.Student;

import java.util.*;

public class Question2 {
    List<Student> students = new ArrayList<>();

    public void question2(){
        students.add(new Student("Nguyễn Văn Nam"));
        students.add(new Student("Nguyễn Văn Huyên"));
        students.add(new Student("Trần Văn Nam"));
        students.add(new Student("Nguyễn Văn A"));

        stack();

        queue();
    }

    public void stack(){
        Stack<Student> stack = new Stack<Student>();
        for(int i =0; i < students.size(); i++){
            stack.push(students.get(i));
        }
        System.out.println(" Thứ tự tới của student theo thứ tự từ muôn nhất tới sớm nhất");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public void queue(){
        Queue<Student> queue = new LinkedList<>();
        for(int i =0; i < students.size(); i++){
            queue.add(students.get(i));
        }
        System.out.println(" Thứ tự tới của student theo thứ tự từ sớm nhất tới muộn nhất");
        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }

    }
}
