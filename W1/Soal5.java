package W1;

import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        int totallenght = A.length() + B.length();
        System.out.println(totallenght);

        if (A.compareTo(B) >0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        String capA = A.substring(0,1).toUpperCase() + A.substring(1);
        String capB = B.substring(0,1).toUpperCase() + B.substring(1);

        System.out.println(capA + " " + capB);
    }
}
