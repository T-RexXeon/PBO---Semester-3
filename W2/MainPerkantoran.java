package W2;

class Karyawan{
    private String idKaryawan;
    private String nama;
    private String jabatan;

    public Karyawan(String idKaryawan, String nama, String jabatan){
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public String getIdKaryawan(){
        return idKaryawan;
    }

    public String getNama(){
        return nama;
    }

    public String getJabatan(){
        return jabatan;
    }

    public void setJabatan(String jabatanBaru){
        if (jabatanBaru.equals("Junior") || jabatanBaru.equals("Middle") || jabatanBaru.equals("Senior")){
            this.jabatan = jabatanBaru;
            System.out.println("Berhasil: Jabatan " + this.nama + " telah diupdate menjadi " + jabatanBaru);
        } else {
            System.out.println("Gagal, Jabatan '" + jabatanBaru + "' tidak valid di sistem perkantoran ini");
        }
    }

    public void tampilkanProfil(){
        System.out.println("Nama:" + this.nama);
        System.out.println("ID Karyawan:" + this.idKaryawan);
        System.out.println("Jabatan:" + this.jabatan);
    }
}

public class MainPerkantoran {
    public static void main(String[] args) {
        System.out.println("=== SISTEM HRD PERKANTORAN ===");
        
        Karyawan karyawan1 = new Karyawan("EMP-001", "Budi Raharjo", "Junior");
        Karyawan karyawan2 = new Karyawan("EMP-002", "Siti Aminah", "Senior");

        System.out.println("\n[ Data Awal Karyawan ]");
        karyawan1.tampilkanProfil();
        karyawan2.tampilkanProfil();

        System.out.println("[ Proses Update Jabatan Budi ]");
        karyawan1.setJabatan("Super Boss"); 
        karyawan1.setJabatan("Middle");

        System.out.println("\n[ Data Karyawan Setelah Update ]");
        karyawan1.tampilkanProfil();
    }
}
