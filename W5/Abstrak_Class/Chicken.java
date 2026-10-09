package W5.Abstrak_Class;

public class Chicken extends Animal {
    public Chicken(String nama, String asal, int jumlahKaki) {
        super(nama, asal, jumlahKaki);
    }

    @Override
    public void toShout() {
        System.out.println(getNama() + " (Chicken) says: Petok Petok!");
    }
}