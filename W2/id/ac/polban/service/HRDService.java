package W2.id.ac.polban.service;

import W2.id.ac.polban.model.Karyawan; 

public class HRDService {
    
    public void promosikan(Karyawan karyawan, String jabatanBaru) {
        if (jabatanBaru.equals("Junior") || jabatanBaru.equals("Middle") || jabatanBaru.equals("Senior")) {
            karyawan.setJabatan(jabatanBaru);
            System.out.println("Berhasil: Jabatan " + karyawan.getNama() + " naik menjadi " + jabatanBaru);
        } else {
            System.out.println("Gagal: Jabatan '" + jabatanBaru + "' tidak valid.");
        }
    }
}
