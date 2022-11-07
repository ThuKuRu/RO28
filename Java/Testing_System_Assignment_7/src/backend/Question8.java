package backend;

import entity.Circle;
import entity.Geometry;
import entity.Rectangle;

public class Question8 {
    private static Geometry[] geometries;

    public static void question8() throws Exception {
        geometries = new Geometry[10];
        geometries[0] = new Circle( 2.5F, 2.5F);
        geometries[1] = new Circle( 8.5F, 8.5F);
        geometries[2] = new Circle( 7F, 7F);
        geometries[3] = new Circle( 0.5F, 0.5F);
        geometries[4] = new Rectangle(3f, 4f);
        geometries[4] = new Rectangle(2.5f, 5.5f);

        }


}
