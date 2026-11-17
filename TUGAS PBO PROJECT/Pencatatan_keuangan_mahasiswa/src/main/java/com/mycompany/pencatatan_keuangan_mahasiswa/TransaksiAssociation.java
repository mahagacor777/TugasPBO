package com.mycompany.pencatatan_keuangan_mahasiswa;

/**
 * Demonstrates Association between Mahasiswa (entity) and Transaksi (action).
 * This class provides a static helper to process a transaction for a given mahasiswa.
 */
public class TransaksiAssociation {
    public static void prosesAssociation(Mahasiswa mahasiswa, Transaksi transaksi) {
        System.out.println("[ASSOCIATION] Memproses transaksi untuk Mahasiswa: " + mahasiswa.getNama() + " (NPM: " + mahasiswa.getNpm() + ")");
        // Call specific processing of the transaction (polymorphic)
        transaksi.prosesSpesifik();
        // Validate transaction
        if (transaksi instanceof ValidasiTransaksi) {
            boolean valid = ((ValidasiTransaksi) transaksi).validasiNominalData();
            if (!valid) {
                System.out.println("[ASSOCIATION] Transaksi tidak valid, dibatalkan.");
                return;
            }
        }
        // Update dompet via composition (shared instance in main class)
        if (transaksi instanceof Pemasukan) {
            Dompet.deposit(((Pemasukan) transaksi).getNominal());
        } else if (transaksi instanceof Pengeluaran) {
            Dompet.withdraw(((Pengeluaran) transaksi).getNominal());
        }
        // Tampilkan info transaksi dan saldo akhir
        transaksi.tampilkanInfo();
        System.out.println("[INFO] Saldo akhir dompet: Rp" + Dompet.getSaldo());
    }
}
