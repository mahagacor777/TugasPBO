package com.mycompany.pencatatan_keuangan_mahasiswa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * CLASS UTAMA - APLIKASI PENCATATAN KEUANGAN MAHASISWA
 * 
 
 * 1. Exception Handling:
 *    - Custom Exception: KeuanganException
 *    - throw & throws untuk validasi input dan pencarian data
 *    - try-catch-finally untuk menangani error (InputMismatchException, KeuanganException)
 * 2. Collection Framework:
 *    - ArrayList<Transaksi>: penyimpanan dinamis objek transaksi (.add, .get, .size, .isEmpty)
 *    - HashMap<String, Mahasiswa>: penyimpanan data mahasiswa/pengguna berbasis Key-Value (.put, .containsKey, .get)
 * 3. Tampilan CLI interaktif dan rapi
 */
public class Pencatatan_keuangan_mahasiswa {
    // Composition: Dompet internal milik sistem keuangan
    private static Dompet dompet = new Dompet();
    // Aggregation: collections managed here
    static Scanner input = new Scanner(System.in);
    static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    static HashMap<String, Mahasiswa> dataMahasiswa = new HashMap<>();

    // Scanner untuk membaca input dari keyboard
    static Scanner input = new Scanner(System.in);

    // 1. COLLECTION FRAMEWORK: ArrayList untuk menyimpan objek transaksi secara dinamis
    static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    // 2. COLLECTION FRAMEWORK: HashMap untuk data mahasiswa/anggota (Key = NPM, Value = Objek Mahasiswa)
    static HashMap<String, Mahasiswa> dataMahasiswa = new HashMap<>();

    public static void main(String[] args) {
        // Inisialisasi data awal (dummy) sesuai ketentuan:
        // 3-5 data transaksi pada ArrayList & 2-3 data pada HashMap
        inisialisasiDataAwal();

        int pilihan = 0;

        do {
            tampilkanMenu();

            try {
                System.out.print("Pilih menu (1-7) : ");
                pilihan = input.nextInt();
                input.nextLine(); // Membersihkan sisa newline

                switch (pilihan) {
                    case 1:
                        menuTambahData();
                        break;
                    case 2:
                        tampilkanSemuaData();
                        break;
                    case 3:
                        menuPencarianData();
                        break;
                    case 4:
                        tampilkanStatistik();
                        break;
                    case 5:
                        menuKelolaMahasiswa();
                        break;
                    case 6:
                        // Association simulation between Mahasiswa and Transaksi
                        menuAssociation();
                        break;
                    case 7:
                        System.out.println();
                        System.out.println("========================================");
                        System.out.println("     Terima kasih telah menggunakan     ");
                        System.out.println("      Aplikasi Keuangan Mahasiswa       ");
                        System.out.println("========================================");
                        break;
                        System.out.println();
                        System.out.println("========================================");
                        System.out.println("     Terima kasih telah menggunakan     ");
                        System.out.println("      Aplikasi Keuangan Mahasiswa       ");
                        System.out.println("========================================");
                        break;
                    default:
                        // Melemparkan custom exception jika menu tidak valid
                        throw new KeuanganException("Pilihan menu [" + pilihan + "] tidak tersedia! Silakan pilih angka 1 - 6.");
                }

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("[ERROR CATCH] Input tidak valid! Menu harus berupa bilangan bulat.");
                input.nextLine(); // Membersihkan buffer scanner dari input yang salah
            } catch (KeuanganException e) {
                System.out.println();
                System.out.println("[ERROR CATCH] " + e.getMessage());
            } catch (Exception e) {
                System.out.println();
                System.out.println("[ERROR CATCH] Terjadi kesalahan tak terduga: " + e.getMessage());
            } finally {
                // Keterangan finally wajib tercetak jelas di terminal
                System.out.println("[FINALLY] Operasi menu selesai diproses.");
            }

        } while (pilihan != 6);

        input.close();
    }

    /**
     * Mengisi data awal dummy:
     * - 4 data pada ArrayList (kriteria 3-5 data)
     * - 3 data pada HashMap (kriteria 2-3 data)
     */
    public static void inisialisasiDataAwal() {
        // Data awal ArrayList menggunakan method .add()
        daftarTransaksi.add(new Pemasukan(1, "2026-11-01", 500000.0, "Uang Saku Bulanan", "Uang Saku"));
        daftarTransaksi.add(new Pengeluaran(2, "2026-11-02", 35000.0, "Makan Siang Kantin", "Makanan"));
        daftarTransaksi.add(new Pengeluaran(3, "2026-11-03", 120000.0, "Beli Modul Kuliah", "Kuliah"));
        daftarTransaksi.add(new Pemasukan(4, "2026-11-05", 750000.0, "Beasiswa Prestasi", "Beasiswa"));

        // Data awal HashMap menggunakan method .put()
        dataMahasiswa.put("23081010001", new Mahasiswa("23081010001", "Novik Ramadhan", "Informatika"));
        dataMahasiswa.put("23081010002", new Mahasiswa("23081010002", "Ahmad Fauzi", "Sistem Informasi"));
        dataMahasiswa.put("23081010003", new Mahasiswa("23081010003", "Siti Aisyah", "Teknik Komputer"));
    }

    /**
     * Menampilkan Menu Utama CLI
     */
    public static void tampilkanMenu() {
        System.out.println();
        System.out.println("==================================================");
        System.out.println("       APLIKASI PENCATATAN KEUANGAN MAHASISWA     ");
        System.out.println("==================================================");
        System.out.println("1. Tambah Transaksi Baru (ArrayList .add)");
        System.out.println("2. Tampilkan Seluruh Transaksi (ArrayList .get)");
        System.out.println("3. Pencarian Data Transaksi (throw & throws)");
        System.out.println("4. Statistik Keuangan");
        System.out.println("5. Kelola Data Mahasiswa (HashMap Key-Value)");
        System.out.println("6. Simulasi Association (Transaksi & Mahasiswa)");
        System.out.println("7. Keluar");
        System.out.println("==================================================");
        System.out.println();
        System.out.println("==================================================");
        System.out.println("       APLIKASI PENCATATAN KEUANGAN MAHASISWA     ");
        System.out.println("==================================================");
        System.out.println("1. Tambah Transaksi Baru (ArrayList .add)");
        System.out.println("2. Tampilkan Seluruh Transaksi (ArrayList .get)");
        System.out.println("3. Pencarian Data Transaksi (throw & throws)");
        System.out.println("4. Statistik Keuangan");
        System.out.println("5. Kelola Data Mahasiswa (HashMap Key-Value)");
        System.out.println("6. Keluar");
        System.out.println("==================================================");
    }

    // =========================================================================
    // FITUR 1: TAMBAH DATA (ARRAYLIST & EXCEPTION HANDLING)
    // =========================================================================

    public static void menuTambahData() {
        try {
            prosesTambahData();
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("[ERROR CATCH] Input angka tidak valid! Pastikan tipe data sesuai (contoh: nominal angka).");
            input.nextLine(); // Bersihkan buffer
        } catch (KeuanganException e) {
            System.out.println();
            System.out.println("[ERROR CATCH] Gagal menambah transaksi: " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Blok finally dieksekusi: Proses penambahan transaksi selesai.");
        }
    }

    /**
     * Method untuk memproses penambahan data.
     * Menggunakan throws KeuanganException untuk melemparkan kesalahan validasi.
     */
    public static void prosesTambahData() throws KeuanganException {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("          TAMBAH DATA TRANSAKSI BARU          ");
        System.out.println("==============================================");
        System.out.println("1. Pengeluaran");
        System.out.println("2. Pemasukan");
        System.out.print("Pilih tipe transaksi (1/2): ");

        int tipe = input.nextInt();
        input.nextLine();

        // Validasi tipe transaksi menggunakan throw
        if (tipe != 1 && tipe != 2) {
            throw new KeuanganException("Tipe transaksi [" + tipe + "] tidak valid! Hanya diperbolehkan 1 atau 2.");
        }

        // Generate ID berdasarkan ukuran ArrayList saat ini (.size())
        int id = daftarTransaksi.size() + 1;

        System.out.print("Tanggal (YYYY-MM-DD): ");
        String tanggal = input.nextLine();
        validasiString("Tanggal", tanggal);

        System.out.print("Nominal (Rp)        : ");
        double nominal = input.nextDouble();
        input.nextLine();
        validasiNominal(nominal);

        System.out.print("Keterangan          : ");
        String keterangan = input.nextLine();
        validasiString("Keterangan", keterangan);

        if (tipe == 1) {
            // PENGELUARAN
            System.out.println();
            System.out.println("Kategori Pengeluaran:");
            System.out.println("1. Makanan");
            System.out.println("2. Transportasi");
            System.out.println("3. Kuliah");
            System.out.println("4. Hiburan");
            System.out.println("5. Lainnya");
            System.out.print("Pilih kategori (1-5): ");

            int pilihanKategori = input.nextInt();
            input.nextLine();

            String kategori;
            switch (pilihanKategori) {
                case 1: kategori = "Makanan"; break;
                case 2: kategori = "Transportasi"; break;
                case 3: kategori = "Kuliah"; break;
                case 4: kategori = "Hiburan"; break;
                case 5: kategori = "Lainnya"; break;
                default:
                    throw new KeuanganException("Kategori pengeluaran nomor [" + pilihanKategori + "] tidak valid!");
            }

            // Menambahkan objek Pengeluaran ke ArrayList menggunakan method .add()
            Pengeluaran pengeluaran = new Pengeluaran(id, tanggal, nominal, keterangan, kategori);
            pengeluaran.prosesSpesifik();
            daftarTransaksi.add(pengeluaran);

        } else {
            // PEMASUKAN
            System.out.println();
            System.out.println("Sumber Pemasukan:");
            System.out.println("1. Uang Saku");
            System.out.println("2. Beasiswa");
            System.out.println("3. Gaji");
            System.out.println("4. Lainnya");
            System.out.print("Pilih sumber (1-4): ");

            int pilihanSumber = input.nextInt();
            input.nextLine();

            String sumber;
            switch (pilihanSumber) {
                case 1: sumber = "Uang Saku"; break;
                case 2: sumber = "Beasiswa"; break;
                case 3: sumber = "Gaji"; break;
                case 4: sumber = "Lainnya"; break;
                default:
                    throw new KeuanganException("Sumber pemasukan nomor [" + pilihanSumber + "] tidak valid!");
            }

            // Menambahkan objek Pemasukan ke ArrayList menggunakan method .add()
            Pemasukan pemasukan = new Pemasukan(id, tanggal, nominal, keterangan, sumber);
            pemasukan.prosesSpesifik();
            daftarTransaksi.add(pemasukan);
        }

        System.out.println();
        System.out.println(">> SUKSES: Transaksi berhasil ditambahkan ke ArrayList!");
    }

    // =========================================================================
    // FITUR 2: TAMPILKAN SELURUH DATA (ARRAYLIST .isEmpty, .size, .get)
    // =========================================================================

    public static void tampilkanSemuaData() {
        try {
            System.out.println();
            System.out.println("=========================================================================================");
            System.out.println("                                SELURUH DATA TRANSAKSI                                   ");
            System.out.println("=========================================================================================");

            // Menggunakan method .isEmpty() pada ArrayList
            if (daftarTransaksi.isEmpty()) {
                throw new KeuanganException("Daftar transaksi masih kosong! Belum ada data untuk ditampilkan.");
            }

            System.out.printf("%-4s %-14s %-15s %-15s %-25s %s%n",
                    "ID", "TANGGAL", "TIPE", "NOMINAL", "KETERANGAN", "DETAIL");
            System.out.println("-----------------------------------------------------------------------------------------");

            // Menggunakan method .size() dan .get() pada ArrayList
            for (int i = 0; i < daftarTransaksi.size(); i++) {
                Transaksi t = daftarTransaksi.get(i);
                t.tampilkanInfo();
            }

            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Total transaksi tersimpan (ArrayList.size) : " + daftarTransaksi.size());

        } catch (KeuanganException e) {
            System.out.println("[ERROR CATCH] " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Blok finally dieksekusi: Proses penayangan data selesai.");
        }
    }

    // =========================================================================
    // FITUR 3: PENCARIAN DATA (THROW, THROWS, TRY-CATCH-FINALLY)
    // =========================================================================
    public static void menuPencarianData() {
        try {
            prosesPencarianData();
        } catch (InputMismatchException e) {
            System.out.println();
            System.out.println("[ERROR CATCH] Input pilihan pencarian harus berupa angka!");
            input.nextLine();
        } catch (KeuanganException e) {
            System.out.println();
            System.out.println("[ERROR CATCH] Pencarian Gagal: " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Blok finally dieksekusi: Sesi pencarian data selesai.");
        }
    }

    /**
     * Melakukan pencarian data dengan throws KeuanganException jika tidak ditemukan.
     */
    public static void prosesPencarianData() throws KeuanganException {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("                PENCARIAN DATA                ");
        System.out.println("==============================================");

        // Validasi menggunakan .isEmpty()
        if (daftarTransaksi.isEmpty()) {
            throw new KeuanganException("Tidak dapat mencari data karena daftar transaksi kosong!");
        }

        System.out.println("1. Cari berdasarkan ID Transaksi");
        System.out.println("2. Cari berdasarkan Kata Kunci Keterangan");
        System.out.print("Pilih opsi pencarian (1/2): ");

        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan ID yang dicari: ");
            int cariId = input.nextInt();
            input.nextLine();

            boolean ditemukan = false;
            for (int i = 0; i < daftarTransaksi.size(); i++) {
                Transaksi t = daftarTransaksi.get(i);
                if (t.cari(cariId)) {
                    if (!ditemukan) {
                        System.out.println("\n>> Data Ditemukan:");
                    }
                    t.tampilkanInfo();
                    ditemukan = true;
                }
            }

            // Lempar custom exception jika data tidak ditemukan
            if (!ditemukan) {
                throw new KeuanganException("Data transaksi dengan ID [" + cariId + "] tidak ditemukan!");
            }

        } else if (pilihan == 2) {
            System.out.print("Masukkan kata kunci keterangan: ");
            String kataKunci = input.nextLine();
            validasiString("Kata Kunci", kataKunci);

            boolean ditemukan = false;
            for (int i = 0; i < daftarTransaksi.size(); i++) {
                Transaksi t = daftarTransaksi.get(i);
                if (t.cari(kataKunci)) {
                    if (!ditemukan) {
                        System.out.println("\n>> Data Ditemukan:");
                    }
                    t.tampilkanInfo();
                    ditemukan = true;
                }
            }

            // Lempar custom exception jika data tidak ditemukan
            if (!ditemukan) {
                throw new KeuanganException("Data transaksi dengan kata kunci '" + kataKunci + "' tidak ditemukan!");
            }

        } else {
            throw new KeuanganException("Opsi pencarian [" + pilihan + "] tidak valid! Pilih 1 atau 2.");
        }
    }

    // =========================================================================
    // FITUR 4: STATISTIK KEUANGAN (ARRAYLIST ITERASI & HITUNG SALDO)
    // =========================================================================

    public static void tampilkanStatistik() {
        try {
            if (daftarTransaksi.isEmpty()) {
                throw new KeuanganException("Belum ada data transaksi untuk kalkulasi statistik!");
            }

            double totalPemasukan = 0;
            double totalPengeluaran = 0;

            for (int i = 0; i < daftarTransaksi.size(); i++) {
                Transaksi t = daftarTransaksi.get(i);
                if (t instanceof Pemasukan) {
                    totalPemasukan += t.getNominal();
                } else if (t instanceof Pengeluaran) {
                    totalPengeluaran += t.getNominal();
                }
            }

            double saldo = totalPemasukan - totalPengeluaran;

            System.out.println();
            System.out.println("==============================================");
            System.out.println("              STATISTIK KEUANGAN              ");
            System.out.println("==============================================");
            System.out.printf("Total Pemasukan   : Rp%,.0f%n", totalPemasukan);
            System.out.printf("Total Pengeluaran : Rp%,.0f%n", totalPengeluaran);
            System.out.printf("Saldo Akhir       : Rp%,.0f%n", saldo);
            System.out.println("----------------------------------------------");

            if (saldo > 0) {
                System.out.println("Status : Kondisi Keuangan Sehat (Saldo Positif).");
            } else if (saldo == 0) {
                System.out.println("Status : Saldo Habis (Impas).");
            } else {
                System.out.println("Status : Defisit! Pengeluaran melebihi pemasukan.");
            }
            System.out.println("==============================================");

        } catch (KeuanganException e) {
            System.out.println("[ERROR CATCH] " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Blok finally dieksekusi: Perhitungan statistik selesai.");
        }
    }

    // =========================================================================
    // FITUR 5: KELOLA DATA MAHASISWA / ANGGOTA (HASHMAP KEY-VALUE)
    // =========================================================================

    public static void menuKelolaMahasiswa() {
        int subPilihan = 0;
        do {
            try {
                System.out.println();
                System.out.println("==============================================");
                System.out.println("        KELOLA DATA MAHASISWA (HASHMAP)       ");
                System.out.println("==============================================");
                System.out.println("1. Tampilkan Semua Mahasiswa (HashMap values)");
                System.out.println("2. Tambah Data Mahasiswa Baru (HashMap .put)");
                System.out.println("3. Cari Mahasiswa Berdasarkan NPM (HashMap .get)");
                System.out.println("4. Kembali ke Menu Utama");
                System.out.println("==============================================");
                System.out.print("Pilih opsi (1-4): ");

                subPilihan = input.nextInt();
                input.nextLine();

                switch (subPilihan) {
                    case 1:
                        tampilkanSemuaMahasiswa();
                        break;
                    case 2:
                        tambahMahasiswaBaru();
                        break;
                    case 3:
                        cariMahasiswaByNPM();
                        break;
                    case 4:
                        System.out.println("Kembali ke menu utama...");
                        break;
                    default:
                        throw new KeuanganException("Pilihan submenu [" + subPilihan + "] tidak valid! Masukkan angka 1-4.");
                }

            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("[ERROR CATCH] Input harus berupa bilangan bulat!");
                input.nextLine();
            } catch (KeuanganException e) {
                System.out.println();
                System.out.println("[ERROR CATCH] " + e.getMessage());
            } catch (Exception e) {
                System.out.println();
                System.out.println("[ERROR CATCH] Kesalahan: " + e.getMessage());
            } finally {
                System.out.println("[FINALLY] Blok finally dieksekusi: Operasi data mahasiswa selesai.");
            }
        } while (subPilihan != 4);
    }

    /**
     * Menampilkan semua data mahasiswa dari HashMap
     */
    public static void tampilkanSemuaMahasiswa() throws KeuanganException {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("                    DAFTAR MAHASISWA TERDAFTAR                   ");
        System.out.println("=================================================================");

        // Validasi HashMap kosong
        if (dataMahasiswa.isEmpty()) {
            throw new KeuanganException("Belum ada data mahasiswa yang terdaftar di sistem.");
        }

        System.out.printf("%-15s %-25s %-25s%n", "NPM (KEY)", "NAMA MAHASISWA", "JURUSAN");
        System.out.println("-----------------------------------------------------------------");

        // Menampilkan seluruh data menggunakan perulangan Map.Entry / values()
        for (Map.Entry<String, Mahasiswa> entry : dataMahasiswa.entrySet()) {
            Mahasiswa mhs = entry.getValue();
            mhs.tampilkanBaris();
        }

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Total mahasiswa terdaftar: " + dataMahasiswa.size() + " orang.");
    }

    /**
     * Menambahkan Mahasiswa baru ke HashMap dengan validasi duplikasi NPM (.containsKey) dan penambahan (.put)
     */
    public static void tambahMahasiswaBaru() throws KeuanganException {
        System.out.println();
        System.out.println("--- Tambah Data Mahasiswa Baru ---");
        System.out.print("Masukkan NPM (Key)     : ");
        String npm = input.nextLine();
        validasiString("NPM", npm);

        // Validasi menggunakan method .containsKey()
        if (dataMahasiswa.containsKey(npm)) {
            throw new KeuanganException("Mahasiswa dengan NPM [" + npm + "] sudah terdaftar! Gunakan NPM yang berbeda.");
        }

        System.out.print("Masukkan Nama Lengkap  : ");
        String nama = input.nextLine();
        validasiString("Nama Mahasiswa", nama);

        System.out.print("Masukkan Jurusan/Prodi : ");
        String jurusan = input.nextLine();
        validasiString("Jurusan", jurusan);

        // Memasukkan ke HashMap menggunakan method .put()
        Mahasiswa mhsBaru = new Mahasiswa(npm, nama, jurusan);
        dataMahasiswa.put(npm, mhsBaru);

        System.out.println();
        System.out.println(">> SUKSES: Data mahasiswa berhasil ditambahkan ke HashMap dengan Key: " + npm);
    }

    /**
     * Mencari data Mahasiswa di HashMap menggunakan .containsKey() dan .get()
     */
    public static void cariMahasiswaByNPM() throws KeuanganException {
        System.out.println();
        System.out.println("--- Cari Data Mahasiswa Berdasarkan NPM ---");
        System.out.print("Masukkan NPM yang dicari: ");
        String npm = input.nextLine();
        validasiString("NPM", npm);

        // Validasi menggunakan method .containsKey()
        if (!dataMahasiswa.containsKey(npm)) {
            throw new KeuanganException("Mahasiswa dengan NPM [" + npm + "] TIDAK DITEMUKAN dalam sistem!");
        }

        // Mengambil objek mahasiswa menggunakan method .get()
        Mahasiswa mhs = dataMahasiswa.get(npm);

        System.out.println();
        System.out.println(">> DATA MAHASISWA DITEMUKAN:");
        System.out.println("NPM     : " + mhs.getNpm());
        System.out.println("Nama    : " + mhs.getNama());
        System.out.println("Jurusan : " + mhs.getJurusan());
    }

    

    /**
     * Memvalidasi bahwa nominal tidak boleh kurang dari atau sama dengan 0.
     * Menggunakan throws KeuanganException dan throw new KeuanganException.
     */
    public static void validasiNominal(double nominal) throws KeuanganException {
        if (nominal <= 0) {
            throw new KeuanganException("Nominal harus lebih dari 0! Nominal yang dimasukkan: Rp" + nominal);
        }
    }

    /**
     * Memvalidasi bahwa input teks tidak boleh kosong atau null.
     */
    public static void validasiString(String namaField, String nilai) throws KeuanganException {
        if (nilai == null || nilai.trim().isEmpty()) {
            throw new KeuanganException("Field [" + namaField + "] tidak boleh kosong!");
        }
    }
}
