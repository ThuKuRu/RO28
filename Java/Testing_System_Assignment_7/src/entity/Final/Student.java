package entity.Final;

public class Student {
    private final int id;

    private String name;


    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public void study(){
        System.out.println(" Đang học bài...");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
