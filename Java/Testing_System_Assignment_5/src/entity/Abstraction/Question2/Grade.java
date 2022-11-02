package entity.Abstraction.Question2;

public class Grade {
    private String name;

    private String list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getList() {
        if (name.equals("A")) {
            list = "Toán, Lý, Hóa";

        } else if (name.equals("B")) {
            list = "Toán, Hóa, Sinh";

        } else if (name.equals("C")) {
            list = "Văn, Sử, Địa";

        } else {
            list = "Không xác định";
        }
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
