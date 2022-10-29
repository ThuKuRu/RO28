package src;

import java.util.Scanner;

import static java.lang.Character.toUpperCase;


public class Exercise4_String {
    public static void main(String[] args) {
        System.out.println("Question 1: ");
        question1();
        System.out.println("Question 2: ");
        question2();
        System.out.println("Question 3: ");
        question3();
        System.out.println("Question 4: ");
        question4();
        System.out.println("Question 5: ");
        question5();
        System.out.println("Question 6: ");
        question6();
        System.out.println("Question 7: ");
        question7();
        System.out.println("Question 8: ");
        question8();
        System.out.println("Question 9: ");
        question9();
        System.out.println("Question 10: ");
        question10();
        System.out.println("Question 11: ");
        question11();
        System.out.println("Question 12: ");
        question12();
        System.out.println("Question 13: ");
        question13();
        System.out.println("Question 14: ");
        question14();
        System.out.println("Question 15: ");
        question15();
        System.out.println("Question 16: ");
        question16();
    }
    static void question1(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] b = a.split("\\s");
        System.out.println("Số lượng các từ trong xâu kí tự: " + b.length);
    }

    static void question2(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(a +  " " + b);
    }
    static void question3(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();

        String firstLetter = a.substring(0, 1);
        String remainingLetters = a.substring(1, a.length());
        if(a.charAt(0) < 'z' && a.charAt(0) > 'a'){
            firstLetter = firstLetter.toUpperCase();
        }
        System.out.println(firstLetter + remainingLetters);
    }
    static void question4(){
        System.out.println(" Tên: ");
        Scanner scanner = new Scanner(System.in);
        String b = scanner.nextLine();
        for(int i = 0; i < b.length(); i++){
            Character a = b.charAt(i);
            a = toUpperCase(a);
            System.out.println(" Ký tự thứ " + (i + 1) + " là: " + a);
        }
    }
    static void question5(){
        System.out.println(" Họ: ");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println(" Tên: ");
        String b = scanner.nextLine();
        System.out.println(" Họ tên: " + a + " " + b);
    }
    static void question6(){
        System.out.println(" Họ tên đầy đủ: ");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] b = a.split("\\s");
        String firstName = b[0];
        String middleName = b[1];
        String lastName = b[2];
            System.out.println(" Họ là: " + firstName );
            System.out.println(" Tên đệm là: " + middleName);
            System.out.println(" Tên là: " + lastName);
    }
    static void question7(){
        System.out.println(" Họ tên đầy đủ: ");
        Scanner scanner = new Scanner(System.in);
        String fullName;
        fullName = scanner.nextLine();
        fullName = fullName.trim();
        fullName = fullName.replaceAll("\\s+", " ");
        System.out.println("Xóa dấu cách: " + fullName);
        String[] words = fullName.split(" ");
        fullName = "";
        for (String word : words) {
            String firstCharacter = word.substring(0, 1).toUpperCase();
            String leftCharacter = word.substring(1);
            word = firstCharacter + leftCharacter;
            fullName += word + " ";
        }
        System.out.println("Viết hoa chữ cái mỗi từ: " + fullName);
    }
    static void question8(){
        String[] groupNames = {" Java ", " Lập trình Java", " Học Java", " Python"};
        for(String groupName : groupNames){
            if(groupName.contains("Java")){
                System.out.println(groupName);
            }
        }
    }
    static void question9(){
        String[] groupNames = {"Java", " Lập trình Java", " Học Java", " Python", "java", "jaVa"};
        for(String groupName : groupNames){
            if(groupName.equals("Java")){
                System.out.println(groupName);
            }
        }
    }
    static void question10(){
        System.out.println(" Chuỗi thứ 1: ");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println(" Chuỗi thứ 2: ");
        String b = scanner.nextLine();
        String dao = new String();
        for (int i = a.length() - 1; i >= 0; i--) {
            dao += a.substring(i, i + 1);
        }
        if( dao.equals(b)){
            System.out.println(a + " và " + b + " là 2 chuỗi đảo ngược");
        }else {
            System.out.println(a + " và " + b + " không phải 2 chuỗi đảo ngược");
        }
    }
    static void question11(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int count = 0;
        for(int i = 0; i <a.length(); i++){
            if(a.charAt(i) == 'a'){
                count++;
            }
        }
        System.out.println(" Số lần xuất hiện kí tự a là: " + count);
    }
    static void question12(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String reverse = new String();
        for (int i = a.length() - 1; i >= 0; i--) {
            reverse += a.substring(i, i + 1);
        }
        System.out.println(" Chuỗi sau khi đảo: " + reverse);
    }
    static void question13(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int count = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) > '0' && a.charAt(i) <= '9') {
                count = 25;
            }
        }
        if(count == 25){
            System.out.println(" False");
        }else{
            System.out.println(" True");
        }
    }
    static void question14(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String replace = new String();
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == 'c'){
                replace = replace + '*';
            }else {
                replace += a.charAt(i);
            }
        }
        System.out.println(replace);
    }
    static void question15(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String str = new String();
        str = a.trim();
        str = a.replaceAll("\\s+", " ");

        String[] words = a.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
    }
    static void question16(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int n = scanner.nextInt();
        if (a == null || a.isEmpty() || a.length() % n != 0) {
            System.out.println("No");
            return;
        }

        for (int i = 0; i < a.length(); i += n) {
            System.out.println(a.substring(i, i + n));
        }

    }

}
