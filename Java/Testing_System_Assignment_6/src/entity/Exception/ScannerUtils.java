package entity.Exception;

import java.util.Scanner;

public class ScannerUtils {
          static Scanner scanner = new Scanner(System.in);

//            String errorMessage;
//            String age = null;
//            do{
//                System.out.println(" Input: ");
//                String age1 = scanner.nextLine();
//                age = age1;
//                try {
//                    int i = Integer.parseInt(age1);
//                    System.out.println(age1);
//                    break;
//                } catch (NumberFormatException e) {
//                    String mess = scanner.nextLine();
//                    System.out.println(mess);
//                }

//            }while( age != null );

        public static int inputInt(String errorMessage){
            while (true) {
                try {
                    return Integer.parseInt(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.err.println(errorMessage);
                }
            }
        }

        public  float inputFloat(String errorMessage) {
            while (true) {
                try {
                    return Float.parseFloat(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.err.println(errorMessage);
                }
            }
        }

        public  double inputDouble(String errorMessage) {
            while (true) {
                try {
                    return Double.parseDouble(scanner.nextLine().trim());
                } catch (Exception e) {
                    System.err.println(errorMessage);
                }
            }
        }

        public static String inputString(String errorMessage) {
            while (true) {
                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                } else {
                    System.err.println(errorMessage);
                }
            }
        }

        public static int inputAge() {
            while (true) {
                int age = inputInt("Wrong inputing! Please input an age as int, input again.");

                if (age <= 0) {
                    System.err.println("Wrong inputing! The age must be greater than 0, please input again.");

                } else {
                    return age;
                }
            }
        }

        public  int inputAgeGreaterThan18() {
            while (true) {
                int age = inputAge();

                if (age >= 18) {
                    return age;

                } else {
                    System.out.println("Wrong inputing! The age must be greater than 18, please input again.");
                }
            }
        }



}
