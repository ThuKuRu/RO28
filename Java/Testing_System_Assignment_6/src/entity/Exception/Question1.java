package entity.Exception;

public class Question1 {
    public static void main(String[] args){
        try {
            float result = divide(7, 0);
            System.out.println(result);
        }catch (ArithmeticException e){
            System.out.println(" cannot divide 0 ");
        }
    }

    public static float divide(int a, int b){
        return a / b;

    }
}
