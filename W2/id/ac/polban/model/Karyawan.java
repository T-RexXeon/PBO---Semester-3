package id.ac.polban.model;

public class Karyawan {
    public static final String NAMA_PERUSAHAAN = "PT. Polban Sejahtera";
    private static int totalKaryawan = 0; 

    private String idKaryawan;
    private String nama;
    private String jabatan;
    
    private Departmen Departmen; 

    public Karyawan(String idKaryawan, String nama, String jabatan, Departmen departmen) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.jabatan = jabatan;
        this.Departmen = departmen;
        totalKaryawan++; 
    }

    public String getNama() { return nama; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    public static int getTotalKaryawan() { return totalKaryawan; }

    public void tampilkanProfil() {
        System.out.println("ID Karyawan : " + this.idKaryawan);
        System.out.println("Nama        : " + this.nama);
        System.out.println("Jabatan     : " + this.jabatan);
        System.out.println("Departmen  : " + this.Departmen.getNamaDept());
        System.out.println("---------------------------------");
    }
}