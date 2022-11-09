package entity;

public class Student {
    public static int count  = 0;
    private int id;

    private String name;

    public Student(){

    }

    public Student(String name) {
        id = ++count;
        this.name = name;

    }


    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
