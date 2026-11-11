package ETS;

public abstract class Tiket {
    public static final double PAJAK = 0.10;
    private static int jumlahTiket;
    private String kodeBooking;
    private Pesanan pesanan;

    public Tiket(String kodeBooking, Pesanan pesanan) {
        this.kodeBooking = kodeBooking;
        this.pesanan = pesanan;
        jumlahTiket++;
    }

    public String getKodeBooking() { return kodeBooking; }
    public Pesanan getPesanan() { return pesanan; }
    public static int getJumlahTiket() { return jumlahTiket; }

    public abstract double hitungHarga();

    public final double hitungTotal() {
        return hitungHarga() + (hitungHarga() * PAJAK);
    }
}
