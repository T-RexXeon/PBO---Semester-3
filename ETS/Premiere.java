package ETS;

public class Premiere extends Tiket implements DapatDicek, DapatDibatalkan {
    private String status;

    public Premiere(String kodeBooking, Pesanan pesanan, String status) {
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
        double harga = kursi * 120000 + 25000;
        if (getPesanan().isAkhirPekan()) {
            harga = harga + (harga * 0.2);
        }
        return harga;
    }

    @Override 
    public double hitungRefund(){
        return hitungTotal() * 0.5;
    }
}
