package ETS;

public class Pesanan {
    private String kodePesanan;
    private String judulFilm;
    private int jumlahKursi;
    private boolean akhirPekan;

    public Pesanan(String kodePesanan, String judulFilm, int JumlahKursi, boolean AkhirPekan) {
        this.kodePesanan = kodePesanan;
        this.judulFilm = judulFilm;
        this.jumlahKursi = JumlahKursi;
        this.akhirPekan = AkhirPekan;
    }

    public String getKodePesanan() { return kodePesanan; }
    public String getJudulFilm() { return judulFilm; }
    public int getJumlahKursi() { return jumlahKursi; }
    public boolean isAkhirPekan() { return akhirPekan; }
}