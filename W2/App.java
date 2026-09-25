
import id.ac.polban.model.Karyawan; 
import id.ac.polban.model.Departmen; 
import id.ac.polban.service.HRDService; 

public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEM HRD " + Karyawan.NAMA_PERUSAHAAN + " ===\n");
        
        Departmen deptIT = new Departmen("Information Technology");
        
        Karyawan karyawan1 = new Karyawan("EMP-001", "Budi Raharjo", "Junior", deptIT);
        
        System.out.println("[ Data Awal ]");
        karyawan1.tampilkanProfil();
        
        HRDService hrd = new HRDService();
        System.out.println("[ Proses Update Jabatan ]");
        hrd.promosikan(karyawan1, "Middle");
        
        System.out.println("\n[ Data Setelah Update ]");
        karyawan1.tampilkanProfil();

        // Mengakses Static Method
        System.out.println("Total Karyawan Terdaftar: " + Karyawan.getTotalKaryawan());
    }
}