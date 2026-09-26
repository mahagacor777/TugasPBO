/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pencatatan_keuangan_mahasiswa;

/**
 *
 * @author novik
 */
public class Transaksi  {

    
    // ATRIBUT dan FIELD

    private int id;
    private String tanggal;
    private double nominal;
    private String keterangan;

    // Variabel static untuk menghitung jumlah objek transaksi
    private static int jumlahTransaksi = 0;

    
    // CONSTRUCTOR
    
    public Transaksi(int id, String tanggal, double nominal, String keterangan) {
        this.id = id;
        this.tanggal = tanggal;
        setNominal(nominal);
        setKeterangan(keterangan);

        // Setiap objek Transaksi dibuat, counter bertambah
        jumlahTransaksi++;
    }

   
    // GETTER DAN SETTER
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        if (tanggal != null && !tanggal.trim().isEmpty()) {
            this.tanggal = tanggal;
        }
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        if (nominal > 0) {
            this.nominal = nominal;
        } else {
            System.out.println("Nominal harus lebih dari 0.");
        }
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        if (keterangan != null && !keterangan.trim().isEmpty()) {
            this.keterangan = keterangan;
        }
    }

    // ==============================
    // STATIC METHOD
    // ==============================

    public static int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    // ==============================
    // METHOD
    // ==============================

    public void tampilkanInfo() {
        System.out.printf(
                "%-4d %-14s %-15s Rp%-12.0f %-25s%n",
                id,
                tanggal,
                "Transaksi",
                nominal,
                keterangan
        );
    }

    
    // METHOD OVERLOADING
 
    // cari berdasarkan ID
    public boolean cari(int id) {
        return this.id == id;
    }

    // cari berdasarkan keterangan
    public boolean cari(String keterangan) {
        return this.keterangan.toLowerCase()
                .contains(keterangan.toLowerCase());
    }
}
    
