package com.mycompany.pencatatan_keuangan_mahasiswa;

/**
 * Model class untuk merepresentasikan data Mahasiswa / Anggota.
 * Digunakan sebagai Value pada HashMap dengan NPM sebagai Key.
 */
public class Mahasiswa {
    private String npm;
    private String nama;
    private String jurusan;

    public Mahasiswa(String npm, String nama, String jurusan) {
        this.npm = npm;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void tampilkanBaris() {
        System.out.printf("%-15s %-25s %-25s%n", npm, nama, jurusan);
    }

    @Override
    public String toString() {
        return "NPM: " + npm + " | Nama: " + nama + " | Jurusan: " + jurusan;
    }
}
