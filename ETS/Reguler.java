package ETS;

public class Reguler extends Tiket {
    public Reguler(String kodeBooking, Pesanan pesanan) {
        super(kodeBooking, pesanan);
    }

    @Override
    public double hitungHarga() {
        int kursi = getPesanan().getJumlahKursi();
        double harga = kursi * 40000;
        if (getPesanan().isAkhirPekan()) {
            harga += kursi * 10000;
        }   
        return harga;
    }
}
