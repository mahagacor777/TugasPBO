package com.mycompany.pencatatan_keuangan_mahasiswa;

/**
 * Custom Exception untuk menangani kesalahan pada aplikasi keuangan mahasiswa.
 * Turunan dari class Exception.
 */
public class KeuanganException extends Exception {

    public KeuanganException(String pesan) {
        super(pesan);
    }

    public KeuanganException(String pesan, Throwable penyebab) {
        super(pesan, penyebab);
    }
}
