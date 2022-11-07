package entity;

public class MyMath {
    public static final float PI = 3.14f;

    public static float sum(int a, int b) {
        return a + b;
    }

    public static int min(int a, int b) {
        if(a < b){
            return a;
        }else{
            return b;
        }
    }

    public static int max(int a, int b) {
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
}
