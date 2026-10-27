package W7.Kasus3;

// Provides static mathematical utility functions.
public class MathUtils {
    // --------------------------------------------------- 
    // Returns the factorial of the argument given
    // ---------------------------------------------------
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Error: Factorial tidak didefinisikan untuk bilangan negatif.");
        }
        if (n > 16) {
            throw new IllegalArgumentException("Error: Nilai terlalu besar. Factorial hanya terdefinisi hingga 16 untuk mencegah overflow.");
        }
        
        int fac = 1;
        for (int i = n; i > 0; i--) {
            fac *= i;
        }
        return fac;
    }
}