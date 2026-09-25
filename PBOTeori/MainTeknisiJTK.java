package PBOTeori;

class PeminjamanBarang {
    private String idPeminjaman;
    private String namaPeminjam;
    private String namaBarang;
    private String status;

    public PeminjamanBarang(String idPeminjaman, String namaPeminjam, String namaBarang, String status){
        this.idPeminjaman = idPeminjaman;
        this.namaPeminjam = namaPeminjam;
        this.namaBarang = namaBarang;
        this.status = status;
    }

    public String getIdPeminjaman(){
        return idPeminjaman;
    }

    public String getNamaPeminjam(){
        return namaPeminjam;
    }
    
    public String getNamaBarang(){
        return namaBarang;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String statusBaru){
        if (statusBaru.equals("Dipinjam") || statusBaru.equals("Dikembalikan") || statusBaru.equals("Terlambat")){
            this.status = statusBaru;
            System.out.println("Berhasil: Status peminjaman " + this.namaBarang + " oleh " + this.namaPeminjam + " telah diupdate menjadi " + statusBaru);
        } else {
            System.out.println("Gagal, Status '" + statusBaru + "' tidak valid di sistem Teknisi JTK");
        }
    }

    public void tampilkanDataPeminjaman(){
        System.out.println("Nama Peminjam: " + this.namaPeminjam);
        System.out.println("ID Peminjaman: " + this.idPeminjaman);
        System.out.println("Nama Barang  : " + this.namaBarang);
        System.out.println("Status       : " + this.status);
    }
}

public class MainTeknisiJTK {
    public static void main(String[] args) {
        System.out.println("=== SISTEM PEMINJAMAN TEKNISI JTK ===");
        
        PeminjamanBarang pinjam1 = new PeminjamanBarang("TRX-001", "Budi Raharjo", "Proyektor Epson", "Dipinjam");
        PeminjamanBarang pinjam2 = new PeminjamanBarang("TRX-002", "Siti Aminah", "Kabel HDMI 10m", "Dikembalikan");

        System.out.println("\n[ Data Awal Peminjaman ]");
        pinjam1.tampilkanDataPeminjaman();
        System.out.println("-------------------------");
        pinjam2.tampilkanDataPeminjaman();

        System.out.println("\n[ Proses Update Status Budi ]");
        pinjam1.setStatus("Diambil Teman"); 
        pinjam1.setStatus("Terlambat");

        System.out.println("\n[ Data Peminjaman Setelah Update ]");
        pinjam1.tampilkanDataPeminjaman();
    }
}