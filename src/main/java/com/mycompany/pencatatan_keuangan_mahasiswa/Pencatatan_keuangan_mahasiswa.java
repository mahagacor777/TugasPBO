/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pencatatan_keuangan_mahasiswa;

/**
 *
 * @author novik
 */
public class Pencatatan_keuangan_mahasiswa {

    public static void main(String[] args) {
            if (saldo > 0) {
    
                /*
                 * Jika saldo lebih dari 0, maka uang masih tersisa
                 
                */
                System.out.println(
                        "Status : Saldo masih positif."
                );
    
    
            } else if (saldo == 0) {
    
                /*
                 * Jika saldo sama dengan 0,
                 * pemasukan dan pengeluaran memiliki nilai sama.
                 */
                System.out.println(
                        "Status : Saldo habis."
                );
    
    
            } else {
    
                
                 //  Jika saldo kurang dari 0,
                 // berarti total pengeluaran lebih besar,, daripada total pemasukan.//
                
                System.out.println(
                        "Status : Pengeluaran melebihi pemasukan!"
                );
            }
    }
}
