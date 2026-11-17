package com.mycompany.pencatatan_keuangan_mahasiswa;

/**
 * Komponen internal yang merepresentasikan dompet (saldo) seorang mahasiswa.
 * Ini adalah contoh Composition: class {@code SistemKeuangan} memiliki
 * instance {@code Dompet} yang dibuat langsung di dalam konstructor.
 */
public class Dompet {
    private static double saldo;

    public Dompet() {
        this.saldo = 0.0;
    }

    public Dompet(double saldoAwal) {
        saldo = saldoAwal;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        Dompet.saldo = saldo;
    }

    public static void deposit(double amount) {
        if (amount > 0) {
            saldo += amount;
            System.out.println("[INFO] Deposit berhasil: Rp" + amount);
        } else {
            System.out.println("[ERROR] Deposit harus lebih dari 0");
        }
    }

    public static void withdraw(double amount) {
        if (amount > 0 && amount <= saldo) {
            saldo -= amount;
            System.out.println("[INFO] Penarikan berhasil: Rp" + amount);
        } else {
            System.out.println("[ERROR] Penarikan gagal, saldo tidak cukup atau nilai tidak valid");
        }
    }

    private double saldo;

    public Dompet() {
        this.saldo = 0.0;
    }

    public Dompet(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            saldo += amount;
            System.out.println("[INFO] Deposit berhasil: Rp" + amount);
        } else {
            System.out.println("[ERROR] Deposit harus lebih dari 0");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= saldo) {
            saldo -= amount;
            System.out.println("[INFO] Penarikan berhasil: Rp" + amount);
        } else {
            System.out.println("[ERROR] Penarikan gagal, saldo tidak cukup atau nilai tidak valid");
        }
    }
}
