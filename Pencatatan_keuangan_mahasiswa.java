package com.mycompany.pencatatan_keuangan_mahasiswa;

import java.util.Scanner;

/*
 
 * CLASS UTAMA

 *
 * 
 * Struktur program secara sederhana:
 *
 *     Pencatatan_keuangan_mahasiswa.java() ==>> Menu(Tambah Data, Tampilkan Data, Pencarian, Statistik, Keluar)
 *       |
 *      
 */
public class Pencatatan_keuangan_mahasiswa {

    
    /*
     * Scanner digunakan untuk membaca input dari keyboard.
     
     */
    static Scanner input = new Scanner(System.in);


    
   
    /*
     * Array ini digunakan untuk menyimpan objek transaksi. Array menggunakan tipe Transaksi.
     
      Namun array memiliki kaluaran dan masukan    
      karena keduanya merupakan subclass dari Transaksi.
     
      maka menggunakan sifat polimorpisme
    
    maksimal transaksi adalah 100 agar membatasi terjadinya Stackoverflow
     */
    static Transaksi[] daftarTransaksi = new Transaksi[100];


    //Penghitung Data//

    /*
      Variabel ini digunakan untuk mengetahui berapa banyak data yang saat ini telah dimasukkan ke array//
     
     
   */
    static int jumlahData = 0;


    
    /*
      Program akan mulai menjalankan instruksi dari
      method ini.
     */
    public static void main(String[] args) {

        /*
          Variabel pilihan digunakan untuk menyimpan
          pilihan menu dari pengguna.
         */
        int pilihan;


       
        do {

            //menampilkan menu utama
            tampilkanMenu();

            // Meminta pilihan pengguna.
            System.out.print("Pilih menu : ");

           
            pilihan = input.nextInt();

            
            input.nextLine();


            /*
             * SWITCH digunakan untuk menentukan aksi
             * berdasarkan pilihan pengguna.
             */
            switch (pilihan) {

                case 1:

                    // Menjalankan method tambahData().
                    tambahData();
                    break;


                case 2:

                    // Menampilkan semua transaksi.
                    tampilkanSemuaData();
                    break;


                case 3:

                    // Menjalankan fitur pencarian.
                    pencarianData();
                    break;


                case 4:

                    // Menampilkan statistik keuangan(selisih pengeluaran dan pemasukan)
                    tampilkanStatistik();
                    break;


                case 5:

                    // Program akan keluar dari perulangan.
                    System.out.println();
                    System.out.println(
                            "========================================"
                    );
                    System.out.println(
                            " Terima kasih telah menggunakan"
                    );
                    System.out.println(
                            "    Aplikasi Keuangan Mahasiswa"
                    );
                    System.out.println(
                            "========================================"
                    );
                    break;


                default:

                    /*
                     * Jika pengguna memasukkan angka selain
                     * 1 sampai 5, program memberikan pesan .
                     */
                    System.out.println(
                            "Pilihan tidak tersedia!"
                    );
            }

        /*
         * Perulangan berhenti jika pilihan == 5.
         */
        } while (pilihan != 5);


        /*
         * Setelah program selesai,
         * Scanner ditutup untuk melepaskan resource.
         */
        input.close();
    }


    
    

    /*
     * Method ini bertugas menampilkan menu utama.
     *
     * Memisahkan menu ke method tersendiri membuat kode
     * main() lebih rapi dan mudah dibaca.
     */
    public static void tampilkanMenu() {

        System.out.println();
        System.out.println(
                "========================================="
        );
        System.out.println(
                "       APLIKASI PENCATATAN KEUANGAN MAHASISWA"
        );
        System.out.println(
                "========================================="
        );

        System.out.println("1. Tambah Data Baru");
        System.out.println("2. Tampilkan Seluruh Data");
        System.out.println("3. Pencarian Data");
        System.out.println("4. Statistik Keuangan");
        System.out.println("5. Keluar");

        System.out.println(
                "========================================"
        );
    }


    

   /*
     * Pengguna dapat memilih pengeluaran dan pemasukan
     *
     * 
     * Kemudian objek yang dibuat dimasukkan ke dalam
     * array daftarTransaksi.
     */
    public static void tambahData() {

        System.out.println();
        System.out.println(
                "=============================================="
        );
        System.out.println(
                "               TAMBAH DATA"
        );
        System.out.println(
                "=============================================="
        );


        //tipe transaksi
        System.out.println("1. Pengeluaran");
        System.out.println("2. Pemasukan");

        System.out.print("Pilih tipe transaksi : ");

        int tipe = input.nextInt();
        input.nextLine();



        //Hanya angka 1 dan 2 yang diperbolehkan.//
    
        if (tipe != 1 && tipe != 2) {

            System.out.println(
                    "Tipe transaksi tidak valid!"
            );

            return;
        }


       
        /*
         * ID dibuat berdasarkan jumlah data saat ini.
         *
         * jika jumlahData = 0,
         * ID pertama = 1. Jika jumlah data 5 maka id terakhir = 6
         
          
        */
        int id = jumlahData + 1;


        //input tanggal pengeluaran
        //input jumlah uamg
        System.out.print("Tanggal       : ");
        String tanggal = input.nextLine();


        System.out.print("Nominal       : ");
        double nominal = input.nextDouble();

        
       //   Membersihkan ENTER setelah nextDouble().//
         
        input.nextLine();


       /*
         * Nominal harus lebih besar dari 0.
         *
          Jika tidak valid, return digunakan untuk menghentikan method tambahData().
         */
        if (nominal <= 0) {

            System.out.println(
                    "Nominal harus lebih dari 0!"
            );

            return;
        }


        System.out.print("Keterangan    : ");
        String keterangan = input.nextLine();


        //buat objek berdasarkan tipe. Pengeluaran/pemasukkan

        /*
         * IF-ELSE digunakan untuk menentukan subclass
         * yang akan dibuat.
          Jika tipe == 1:     buat objek Pengeluaran.
          Jika tipe == 2:     buat objek Pemasukan.
         */
        if (tipe == 1) {


            

            System.out.println();
            System.out.println(
                    "Kategori Pengeluaran:"
            );

            System.out.println("1. Makanan");
            System.out.println("2. Transportasi");
            System.out.println("3. Kuliah");
            System.out.println("4. Hiburan");
            System.out.println("5. Lainnya");

            System.out.print("Pilih kategori : ");

            int pilihanKategori = input.nextInt();
            input.nextLine();



             // Variabel kategori akan menyimpan nama kategori berdasarkan pilihan.
           
            String kategori;


            //pilih kategori pengeluaran dengan switch
            switch (pilihanKategori) {

                case 1:
                    kategori = "Makanan";
                    break;

                case 2:
                    kategori = "Transportasi";
                    break;

                case 3:
                    kategori = "Kuliah";
                    break;

                case 4:
                    kategori = "Hiburan";
                    break;

                case 5:
                    kategori = "Lainnya";
                    break;

                default:

                    /*
                     * Jika pilihan tidak tersedia,
                     * kategori otomatis menjadi Lainnya.
                     */
                    kategori = "Lainnya";

                    System.out.println(
                            "Kategori tidak valid. "
                            + "Dipilih Lainnya."
                    );
            }


          
           //Di sini terjadi OBJECT inisiation. Keyword "new" digunakan untuk membuat objek dari class Pengeluaran.
             /*
              Objek tersebut kemudian disimpan ke dalam
             array bertipe transaksi */
           daftarTransaksi[jumlahData]
                    = new Pengeluaran(
                            id,
                            tanggal,
                            nominal,
                            keterangan,
                            kategori
                    );


        } else {


            //input pemasukan

            System.out.println();
            System.out.println(
                    "Sumber Pemasukan:"
            );

            System.out.println("1. Uang Saku");
            System.out.println("2. Beasiswa");
            System.out.println("3. Gaji");
            System.out.println("4. Lainnya");

            System.out.print("Pilih sumber : ");

            int pilihanSumber = input.nextInt();
            input.nextLine();


            String sumber;


            //memilih sumber pemasukkan
            switch (pilihanSumber) {

                case 1:
                    sumber = "Uang Saku";
                    break;

                case 2:
                    sumber = "Beasiswa";
                    break;

                case 3:
                    sumber = "Gaji";
                    break;

                case 4:
                    sumber = "Lainnya";
                    break;

                default:

                    sumber = "Lainnya";

                    System.out.println(
                            "Sumber tidak valid. "
                            + "Dipilih Lainnya."
                    );
            }


            
            /*
             * Membuat objek Pemasukan menggunakan keyword new.
             */
             // Karena Pemasukan extends Transaksi, objek Pemasukan dapat disimpan dalam array Transaksi.
             
            daftarTransaksi[jumlahData]
                    = new Pemasukan(
                            id,
                            tanggal,
                            nominal,
                            keterangan,
                            sumber
                    );
        }


        
        /*
         * Setelah objek berhasil dimasukkan ke array,
         * jumlahData ditambah satu.
         */
        jumlahData++;


        System.out.println();
        System.out.println(
                "Data berhasil ditambahkan!"
        );
    }


    
    /*
     * Method ini menampilkan seluruh objek yang ada
     * di dalam array daftarTransaksi.
     */
    public static void tampilkanSemuaData() {

        System.out.println();
        System.out.println(
                "===========================================" );

        System.out.println(
                "             SELURUH TRANSAKSI"
        );
        System.out.println(
                "================================================="
   );


        //cek data kosong
        if (jumlahData == 0) {

            System.out.println(
                    "Belum ada data transaksi."
            );

            return;
        }
        System.out.printf(
                "%-4s %-14s %-15s %-15s %-25s %s%n",
                "ID",
                "TANGGAL",
                "TIPE",
                "NOMINAL",
                "KETERANGAN",
                "DETAIL"
        );


        System.out.println(
                "--------------------------------------------------------------------------"
        );


        
        //mengakses semua objek yang ada di dalam array//
        for (int i = 0; i < jumlahData; i++) {


            /*
             * Method tampilkanInfo() dipanggil melalui
             * reference bertipe Transaksi.
             *
             * Namun Java akan melihat objek sebenarnya.
             *
             *
             * 
             * menerapkan kembali polimorpisme
             */
            daftarTransaksi[i].tampilkanInfo();
        }


        System.out.println(
                "--------------------------------------------------------------------------"
        );


        /*
         * Memanggil static method milik class Transaksi.
         */
        System.out.println(
                "Total objek transaksi : "
                + Transaksi.getJumlahTransaksi()
        );
    }



    /*
     * Method ini digunakan untuk mencari transaksi. Bisa cari dari id atau keterangan
    
    id yakni urutan inputan atau nomer
     *
     
     *
     *  menggunakan METHOD OVERLOADING
     * yang telah dibuat di class Transaksi:
     *
     *     cari(int)
     *     cari(String)
     */
    public static void pencarianData() {

        System.out.println();
        System.out.println(
                "=========================================="
        );

        System.out.println(
                "            PENCARIAN DATA"
        );

        System.out.println(
                "===================================="
        );


        // Jika belum ada data, pencarian tidak dapat dilakukan.
        if (jumlahData == 0) {

            System.out.println(
                    "Belum ada data transaksi."
            );

            return;
        }


        System.out.println("1. Cari berdasarkan ID");
        System.out.println("2. Cari berdasarkan Keterangan");

        System.out.print("Pilih : ");

        int pilihan = input.nextInt();
        input.nextLine();


        /*
         * Variabel ditemukan digunakan untuk mengetahui
         * apakah data yang dicari tersedia atau tidak.
         */
        boolean ditemukan = false;


        //cari berdasarkan id dengan nextint

        if (pilihan == 1) {

            System.out.print("Masukkan ID : ");

            int id = input.nextInt();
            input.nextLine();


            /*
             * Melakukan perulangan terhadap seluruh data.
             */
            for (int i = 0; i < jumlahData; i++) {


                /*
                 * Di sini dipanggil:
                 *
                 *     cari(int)
                 *
                 * karena parameter yang diberikan adalah
                 * variabel id bertipe int.
                 *
                 * Ini merupakan penerapan METHOD OVERLOADING.
                 */
                if (daftarTransaksi[i].cari(id)) {

                    System.out.println();
                    System.out.println(
                            "Data ditemukan:"
                    );


                    /*
                     * Menampilkan data menggunakan method
                     * yang telah dioverride oleh subclass.
                     */
                    daftarTransaksi[i].tampilkanInfo();


                    ditemukan = true;
                }
            }


        //mencari berdasarkan keterangan
        } else if (pilihan == 2) {

            System.out.print(
                    "Masukkan kata kunci : "
            );

            String kataKunci = input.nextLine();


            for (int i = 0; i < jumlahData; i++) {


                /*
                 * Di sini dipanggil yakni cari(String)
                 *
                 * karena parameter yang diberikan adalah
                 * String.
                 *
                 * Method ini berbeda parameter dengan cari(int), sehingga merupakan OVERLOADING.
                 */
                if (daftarTransaksi[i]
                        .cari(kataKunci)) {


                    System.out.println();


                    daftarTransaksi[i]
                            .tampilkanInfo();


                    ditemukan = true;
                }
            }


        } else {

            
             // Jika pilihan bukan 1 atau 2, //
             System.out.println(
                    "Pilihan tidak valid!"
            );

            return;
        }


        
        /*
         * Jika setelah seluruh data diperiksa tidak ada
         * yang ditemukan, tampilkan pesan.
         */
        if (!ditemukan) {

            System.out.println(
                    "Data tidak ditemukan."
            );
        }
    }


    //metod statistik keuangan
    /*
     * Method ini digunakan untuk menghitung:
     *
     * 1. Total pemasukan
     * 2. Total pengeluaran
     * 3. Saldo
     */
    public static void tampilkanStatistik() {

        
        double totalPemasukan = 0;
        double totalPengeluaran = 0;

//periksa transaksi apakah masuk pengeluaran atau pemasukan
        for (int i = 0; i < jumlahData; i++) {


            /*
             * instanceof digunakan untuk mengecek
             * apakah objek merupakan instance dari class
             * tertentu.
             *
             * Jika objek merupakan Pemasukan,
             * nominalnya ditambahkan ke totalPemasukan.
             */
            if (daftarTransaksi[i]
                    instanceof Pemasukan) {


                totalPemasukan
                        += daftarTransaksi[i]
                                .getNominal();


            /*
             * Jika objek merupakan Pengeluaran,
             * nominalnya ditambahkan ke totalPengeluaran.
             */
            } else if (daftarTransaksi[i]
                    instanceof Pengeluaran) {


                totalPengeluaran
                        += daftarTransaksi[i]
                                .getNominal();
            }
        }


        //Hitung Saldo dari pengeluaran dan pemasukan
        /*
         * Saldo diperoleh dari total pemasukan - total pengeluaran
         */
        double saldo =
                totalPemasukan - totalPengeluaran;


        
        System.out.println();
        System.out.println(
                "=============================================="
        );

        System.out.println(
                "             STATISTIK KEUANGAN"
        );

        System.out.println(
                "=========================================="
        );


        
        System.out.printf(
                "Total Pemasukan   : Rp%,.0f%n",
                totalPemasukan
        );


        System.out.printf(
                "Total Pengeluaran : Rp%,.0f%n",
                totalPengeluaran
        );


        System.out.printf(
                "Saldo             : Rp%,.0f%n",
                saldo
        );


        System.out.println(
                "============================="
        );


        
        //if statment untuk mennentukan kondisi saldo

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