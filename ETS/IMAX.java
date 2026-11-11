package ETS;

public class IMAX extends Tiket implements DapatDicek {
    private String status;

    public IMAX(String kodeBooking, Pesanan pesanan, String status) {
        super(kodeBooking, pesanan);
        this.status = status;
    }


    @Override
    public String cekStatus() {
        return status;
    }

    @Override
    public double hitungHarga() {
        int kursi = getPesanan().getJumlahKursi();
        double hargaKursi = kursi * 75000;
        if (kursi >= 4) {
            hargaKursi = hargaKursi - (hargaKursi * 0.1);
        }
        return hargaKursi + 10000;
    }
}