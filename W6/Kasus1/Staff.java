public class Staff {
    private StaffMember[] staffList;

    public Staff() {
        staffList = new StaffMember[8];

        staffList[0] = new Executive("Sam", "123 Main St.", "555-0469", "123-45-6789", 2423.07);
        staffList[1] = new Employee("Carla", "456 Oak St.", "555-0101", "987-65-4321", 1250.00);
        staffList[2] = new Employee("Woody", "789 Pine St.", "555-0103", "123-88-9999", 1250.00);
        staffList[3] = new Hourly("Diane", "1011 Elm St.", "555-0123", "456-78-9012", 10.55);
        
        // Perhatikan Volunteer hanya menggunakan 3 parameter
        staffList[4] = new Volunteer("Norm", "1213 Maple St.", "555-0100");
        staffList[5] = new Volunteer("Cliff", "1415 Birch St.", "555-0102");

        ((Hourly) staffList[3]).addHours(40);

        staffList[6] = new Commission("Budi", "Jl. Mawar No. 5", "555-0199", "111-22-3333", 6.25, 0.20);
        staffList[7] = new Commission("Siti", "Jl. Melati No. 8", "555-0188", "444-55-6666", 9.75, 0.15);

        ((Commission) staffList[6]).addHours(35);
        ((Commission) staffList[6]).addSales(400);

        ((Commission) staffList[7]).addHours(40);
        ((Commission) staffList[7]).addSales(950);
    }

    public void payday() {
        double amount;

        for (int count = 0; count < staffList.length; count++) {
            System.out.println(staffList[count]);

            amount = staffList[count].pay();

            if (amount == 0.0)
                System.out.println("Thanks!");
            else
                System.out.println("Paid: $" + amount);

            System.out.println("-----------------------------------");
        }
    }
}