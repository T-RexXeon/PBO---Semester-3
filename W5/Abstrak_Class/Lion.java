package W5.Abstrak_Class;

public class Lion extends Animal {
    public Lion(String nama, String asal, int jumlahKaki) {
        super(nama, asal, jumlahKaki);
    }

    @Override
    public void toShout() {
        System.out.println(getNama() + " (Lion) says: Roaaarrr!");
    }
}
