package W10.Task2; 

import java.util.HashSet;

public class CountrySet {
    public static void main(String[] args) {
        HashSet<String> countries = new HashSet<>();
        
        countries.add("Indonesia");
        countries.add("Japan");
        countries.add("South Korea");
        countries.add("Malaysia");
        countries.add("Singapore");
        countries.add("Indonesia"); 

        System.out.println("=== Daftar Negara (HashSet) ===");
        System.out.println(countries); 
    }
}