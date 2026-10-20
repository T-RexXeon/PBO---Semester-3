package W6.Kasus3;

public class WeeklySales {
    public static void main(String[] args) {
        Salesperson[] salesStaff = new Salesperson[10];

        salesStaff[0] = new Salesperson("Jane", "Jones", 3000);
        salesStaff[1] = new Salesperson("Daffy", "Duck", 4935);
        salesStaff[2] = new Salesperson("James", "Kirk", 3000);
        salesStaff[3] = new Salesperson("Barney", "Gumble", 2000);
        salesStaff[4] = new Salesperson("Jim", "Halpert", 8000);
        salesStaff[5] = new Salesperson("Michael", "Scott", 3000);
        salesStaff[6] = new Salesperson("Dwight", "Schrute", 8000);
        salesStaff[7] = new Salesperson("Andy", "Bernard", 1500);
        salesStaff[8] = new Salesperson("Pam", "Beesly", 3000);
        salesStaff[9] = new Salesperson("Creed", "Bratton", 500);

        Sorting.insertionSort(salesStaff);

        System.out.println("\nRanking of Sales People\n");
        for (Salesperson s : salesStaff) {
            System.out.println(s);
        }
    }
}