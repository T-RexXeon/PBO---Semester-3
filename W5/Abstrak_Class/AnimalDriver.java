package W5.Abstrak_Class;

public class AnimalDriver {
    public static void main(String[] args) {
        Animal dog = new Dog("Heli", "Indonesia", 4);
        Animal chicken = new Chicken("Rambo", "Amerika", 2);
        Animal lion = new Lion("Simba", "Afrika", 4);

        System.out.println("Nama: " + dog.getNama() + ", Asal: " + dog.getAsal() + ", Kaki: " + dog.getJumlahKaki());
        dog.toShout();
        dog.toEat();
        System.out.println("-------------------------");

        System.out.println("Nama: " + chicken.getNama() + ", Asal: " + chicken.getAsal() + ", Kaki: " + chicken.getJumlahKaki());
        chicken.toShout();
        chicken.toEat();
        System.out.println("-------------------------");

        System.out.println("Nama: " + lion.getNama() + ", Asal: " + lion.getAsal() + ", Kaki: " + lion.getJumlahKaki());
        lion.toShout();
        lion.toEat();
    }
}