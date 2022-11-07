package entity;

public class Circle extends Geometry{
    public Circle(Float a, Float b) throws Exception{
        super(a, b);
    }

    @Override
    public Float perimeter(Float a, Float b) {
        return 2 * Configs.PI * a;
    }

    @Override
    public Float acreage(Float a, Float b) {
        return Configs.PI * a * a;
    }
}
