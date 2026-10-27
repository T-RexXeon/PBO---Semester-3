package W7.Kasus3;

import java.util.Scanner;

// Reads integers from the user and prints the factorial of each. 
public class Factorials {
    public static void main(String[] args) {
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);
        
        while (keepGoing.equalsIgnoreCase("y")) {
            System.out.print("Enter an integer: ");
            int val = scan.nextInt();
            
            try {
                System.out.println("Factorial (" + val + ") = " + MathUtils.factorial(val)); 
            } catch (IllegalArgumentException e) {
                // Menangkap exception dari MathUtils dan mencetak pesan error
                System.out.println(e.getMessage());
            }
            
            System.out.print("Another factorial? (y/n) ");
            keepGoing = scan.next();
        }
        
        scan.close();
    }
}