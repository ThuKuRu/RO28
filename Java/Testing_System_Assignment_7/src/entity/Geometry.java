package entity;

import java.util.Scanner;

public abstract class Geometry {
    public static int count = 0;

    private float a;

    private float b;

    public abstract Float perimeter(Float a, Float b);

    public abstract Float acreage(Float a, Float b);

    public Geometry(Float a, Float b) throws Exception{
        super();
        count++;
        if(count > Configs.SO_LUONG_HINH_TOI_DA){
            throw new GeometryException();
        }else{
            this.a = a;
            this.b = b;
        }
    }
}
