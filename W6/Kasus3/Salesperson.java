package W6.Kasus3;

public class Salesperson implements Comparable {
    private String firstName, lastName;
    private int totalSales;

    public Salesperson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    public String toString() {
        return lastName + ", " + firstName + ":\t" + totalSales;
    }

    public boolean equals(Object other) {
        return (lastName.equals(((Salesperson) other).getLastName()) &&
                firstName.equals(((Salesperson) other).getFirstName()));
    }

    public int compareTo(Object other) {
        Salesperson otherSalesperson = (Salesperson) other;

        if (this.totalSales != otherSalesperson.totalSales) {
            return this.totalSales - otherSalesperson.totalSales;
        } else {
            int lastNameCompare = this.lastName.compareTo(otherSalesperson.lastName);
            if (lastNameCompare != 0) {
                return lastNameCompare;
            }
            return this.firstName.compareTo(otherSalesperson.firstName);
        }
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getSales() { return totalSales; }
}