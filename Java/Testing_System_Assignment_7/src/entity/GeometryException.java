package entity;


public class GeometryException extends Exception{
    public GeometryException() {
        super("Số lượng hình tối đa là: " + Configs.SO_LUONG_HINH_TOI_DA);
    }
}
