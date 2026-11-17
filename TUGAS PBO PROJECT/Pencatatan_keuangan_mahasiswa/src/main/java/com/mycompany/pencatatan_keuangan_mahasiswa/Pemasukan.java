/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pencatatan_keuangan_mahasiswa;

/**
 *
 * @author novik
 */



public class Pemasukan extends Transaksi implements ValidasiTransaksi,CetakLaporan{

    
    
    private String sumber;


    // KONSTRUCTOR
    
    public Pemasukan(
            int id,
            String tanggal,
            double nominal,
            String keterangan,
            String sumber) {

        /*
         * SUPER digunakan untuk memanggil constructor
        
         
         */
        super(id, tanggal, nominal, keterangan);

        /*
         * Setelah atribut milik superclass diproses,
         * kita mengatur atribut khusus Pemasukan,
         * yaitu sumber.
         */
        setSumber(sumber);
    }


   
    public String getSumber() {

        return sumber;
    }


    
    /*
     * Setter digunakan untuk mengubah sumber pemasukan.
     *
     * Validasi dilakukan untuk memastikan sumber
     * tidak kosong.
     */
    public void setSumber(String sumber) {

        if (sumber != null
                && !sumber.trim().isEmpty()) {

            /*
             
             * this.sumber -> atribut milik objek
             * sumber      -> parameter method
             */
            this.sumber = sumber;

        } else {

            
            this.sumber = "Lainnya";
        }
    }

    @Override
    public void prosesSpesifik() {
        System.out.println("[INFO] Memproses data Pemasukan dari sumber: " + sumber);
        
    }
    
    @Override
    public boolean validasiNominalData() {
        System.out.println("[VALIDASI] Pemasukan ID " + getId() + " valid dengan nominal: Rp" + getNominal());
        return getNominal() > 0;
    }
    
    @Override
    public void cetakStrukDigital() {
        System.out.println("[CETAK] Struk Digital Pemasukan berhasil dicetak untuk: " + getKeterangan());
    }
    
    
     
    @Override
    public void tampilkanInfo() {

        
        System.out.printf(
                "%-4d %-14s %-15s Rp%-12.0f %-25s Sumber: %s%n",
                getId(),
                getTanggal(),
                "Pemasukan",
                getNominal(),
                getKeterangan(),
                sumber
        );
    }
}