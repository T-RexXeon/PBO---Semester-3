package id.ac.polban.service;

import id.ac.polban.model.*; 

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
