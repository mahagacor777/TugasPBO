/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pencatatan_keuangan_mahasiswa;

/**
 *
 * @author novik
 * 
 * Class Pengeluran adalah subclass dari Transaksi
 */
 public class Pengeluaran extends Transaksi { //extends berarti class Pengeluaran mewarisi atribut dan metod yang dimiliki oleh class Transaksi

    
    // ATRIBUT
    
    private String kategori;  //enkapsulasi variabel 


    // CONSTRUCTOR
  
    public Pengeluaran( //konstruktor pengeluaran menerima semua yang diperlukan untuk membuat objek pengeluaran
            int id,
            String tanggal,
            double nominal,
            String keterangan,
            String kategori) {

        // Memanggil constructor superclass
        super(id, tanggal, nominal, keterangan); //super untuk memanggil konstruktor dari Transaksi

        // Menggunakan this dengan settter
        setKategori(kategori);
    }

   
    // getter dan setter
    

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        if (kategori != null && !kategori.trim().isEmpty()) {
            this.kategori = kategori;
        } else {
            this.kategori = "Lainnya";
        }
    }

    
    // overriding


    @Override
    public void tampilkanInfo() {

        System.out.printf(
                "%-4d %-14s %-15s Rp%-12.0f %-25s Kategori: %s%n",
                getId(),
                getTanggal(),
                "Pengeluaran",
                getNominal(),
                getKeterangan(),
                kategori
        );
    }

    
}
