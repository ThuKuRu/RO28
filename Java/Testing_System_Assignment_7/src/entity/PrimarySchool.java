package entity;

public final class PrimarySchool {
    public static int count = 0;
    private int id;

    private String name;

    public PrimarySchool(String name) throws Exception{
        this.id = ++count;
        this.name = name;
    }
}
