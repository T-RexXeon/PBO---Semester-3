package ETS;

public class Main {
    public static void main(String[] args) {

        Pesanan p1 = new Pesanan("K001", "Jejak Nusantara", 2, false);
        Pesanan p2 = new Pesanan("K002", "Rumah Kenangan", 3, true);
        Pesanan p3 = new Pesanan("K003", "Galaksi Terakhir", 4, false);
        Pesanan p4 = new Pesanan("K004", "Senja di Bandung", 2, true);

        Tiket[] daftarTiket = {
            new Reguler("REG001", p1),
            new Reguler("REG002", p2),
            new IMAX("IMX001", p3, "KURSI TERKONFIRMASI"),
            new Premiere("PRM001", p4, "MENUNGGU PEMBAYARAN")
        };

        double totalPendapatan = 0;
        double totalTertinggi = 0;
        String kodeTermahal = "";

        for (Tiket t : daftarTiket) {

            System.out.println(t.getKodeBooking() + " | " + t.getPesanan().getJudulFilm());
            System.out.println("Kursi : " + t.getPesanan().getJumlahKursi());
            System.out.println("Harga : Rp" + String.format("%.0f", t.hitungHarga()));
            System.out.println("Total : Rp" + String.format("%.0f", t.hitungTotal()));

            totalPendapatan += t.hitungTotal();

            if (t.hitungTotal() > totalTertinggi) {
                totalTertinggi = t.hitungTotal();
                kodeTermahal = t.getKodeBooking();
            }

            if (t instanceof DapatDicek) {
                System.out.println("Status : " + ((DapatDicek) t).cekStatus());
            }
            if (t instanceof DapatDibatalkan) {
                System.out.println("Refund : Rp" + String.format("%.0f", ((DapatDibatalkan) t).hitungRefund()));
            }

            System.out.println();
        }

        System.out.println("Total pendapatan : Rp" + String.format("%.0f", totalPendapatan));
        System.out.println("Tiket termahal   : " + kodeTermahal);
        System.out.println("Jumlah tiket     : " + Tiket.getJumlahTiket());
    }
}