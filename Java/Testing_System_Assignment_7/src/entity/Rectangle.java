package entity;

public class Rectangle extends Geometry{
     public Rectangle(Float a, Float b) throws Exception{
         super(a, b);
     }

    @Override
    public Float perimeter(Float a, Float b) {
        return 2 * (a + b) ;
    }

    @Override
    public Float acreage(Float a, Float b) {
        return a * b;
    }
}
