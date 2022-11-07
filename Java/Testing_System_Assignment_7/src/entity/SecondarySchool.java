package entity;

public final class SecondarySchool {
    public static int count = 0;
    private int id;

    private String name;

    public SecondarySchool(String name) throws Exception{
        this.id = ++count;
        this.name = name;
    }
}
