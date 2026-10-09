package W5.Abstrak_Class;

public class Dog extends Animal {
    public Dog(String nama, String asal, int jumlahKaki) {
        super(nama, asal, jumlahKaki);
    }

    @Override
    public void toShout() {
        System.out.println(getNama() + " (Dog) says: Guk Guk!");
    }
}