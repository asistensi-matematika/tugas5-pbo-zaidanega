package TUGAS5;
import static TUGAS5.PERPUSTAKAAN.header;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    Scanner CNDL = new Scanner(System.in);
        BUKU[] PERPUS = new BUKU[10000];
        int n = 0;
        double SumHalaman = 0;
        double FiksiHalaman = 0;
        double NonFiksiHalaman = 0;
        double StandardDeviation = 0;
        double FiksiStandardDeviation = 0;
        double NonFiksiStandardDeviation = 0;
        Random RNDM = new Random();
        int Fiksi = 0;
        int NonFiksi = 0;

        for (int i = 0; i < PERPUS.length; i++) {
            int coinflip = RNDM.nextInt(2) + 1;
            if (coinflip == 1) {
                PERPUS[i] = new FIKSI();
            }
            if (coinflip == 2) {
                PERPUS[i] = new NONFIKSI();
            }
        }

        PERPUS[0] = new BUKU("Budi Pergi ke Pasar", "Bambamg Hermanto", "Fiksi", 358);
        Fiksi += 1;
        FiksiHalaman += 358;
        SumHalaman += 358;
        n += 1;

        PERPUS[1] = new BUKU("Sempak Teles", "Yahya Muhammad", "NonFiksi",138 );
        NonFiksi += 1;
        NonFiksiHalaman += 138;
        SumHalaman += 138;
        n += 1;

        PERPUS[2] = new BUKU("Liona & Richardo", "Mulyadi", "NonFiksi", 162);
        NonFiksi += 1;
        NonFiksiHalaman += 162;
        SumHalaman += 162;
        n += 1;

        int pil = 1;
        do {

            header("PERPUSTAKAAN.txt");
            System.out.println("");

            System.out.println("Data Buku : ");
            for (int i = 0; i < n; i++) {
                System.out.println("[" + (i + 1) + "] " + PERPUS[i].getJudul() + "\t| " + PERPUS[i].getPengarang());
            }
            System.out.println("==========================================================================================");
            System.out.println("[1]. Input Buku Baru");
            System.out.println("[2]. Modifikasi Detail Buku");
            System.out.println("[3]. Hapus Buku");
            System.out.println("[0]. Exit");
            System.out.println("==========================================================================================");

            double Avrg = SumHalaman / n;
            for (int i = 0; i < n; i++) {
                StandardDeviation = Math.pow((PERPUS[i].getHalaman() - Avrg), 2);
            }

            double AvrgFiksi = FiksiHalaman / Fiksi;
            double AvrgNonFiksi = NonFiksiHalaman / NonFiksi;
            for (int i = 0; i < n; i++) {
                if (PERPUS[i].getTipe() == "Fiksi") {
                    FiksiStandardDeviation = Math.pow((PERPUS[i].getHalaman() - AvrgFiksi), 2);
                } else {
                    NonFiksiStandardDeviation = Math.pow((PERPUS[i].getHalaman()- AvrgNonFiksi), 2);
                }
            }

            System.out.println("Jumlah Buku di Dalam Perpustakaan: " + n);
            System.out.println("Rata-Rata Halaman Buku dalam Perpustakaan: " + Avrg);
            System.out.println("Standar Deviasi Halaman Buku dalam Perpustakaan: " + Math.sqrt(StandardDeviation / n));
            System.out.println("==========================================================================================");
            System.out.println("Jumlah Buku Fiksi dalam Perpustakaan: " + Fiksi);
            System.out.println("Rata-Rata Halaman Buku Fiksi dalam Perpustakaan: " + AvrgFiksi);
            System.out.println("Standar deviasi Halaman Buku Fiksi dalam Perpustakaan: " + Math.sqrt(FiksiStandardDeviation / Fiksi));
            System.out.println("==========================================================================================");
            System.out.println("Jumlah Buku Non Fiksi dalam Perpustakaan : " + NonFiksi);
            System.out.println("Rata-Rata Halaman Buku Non Fiksi dalam Perpustakaan: " + AvrgNonFiksi);
            System.out.println("Standar deviasi Halaman Buku Non Fiksi dalam Perpustakaan: " + Math.sqrt(NonFiksiStandardDeviation / NonFiksi));
            System.out.println("==========================================================================================");
            System.out.print("MASUKKAN PILIHAN : ");
            int pilihan = CNDL.nextInt();
            if (pilihan == 1) {

                header("BUKUBARU.txt");
                System.out.println("");

                n += 1;

                System.out.print("Input Judul Buku : \n> ");
                String Judul = CNDL.next();
                PERPUS[n - 1].setJudul(Judul);
                System.out.print("Input Pengarang Buku : \n> ");
                String Pengarang = CNDL.next();
                PERPUS[n - 1].setPengarang(Pengarang);
                System.out.print("input jumlah Halaman Buku : \n> ");
                int Halaman = CNDL.nextInt();
                PERPUS[n - 1].setHalaman(Halaman);

                int coinflip = RNDM.nextInt(2) + 1;
                if (coinflip == 1) {
                    PERPUS[n - 1] = new BUKU(Judul, Pengarang, "Fiksi", Halaman);
                    Fiksi += 1;
                    FiksiHalaman += Halaman;
                    SumHalaman += Halaman;
                }
                if (coinflip == 2) {
                    PERPUS[n - 1] = new BUKU(Judul, Pengarang, "NonFiksi", Halaman);
                    NonFiksi += 1;
                    NonFiksiHalaman += Halaman;
                    SumHalaman += Halaman;
                }

            } else if (pilihan == 2) {

                header("UBAHBUKU.txt");
                System.out.println("");

                System.out.println("Pilih Buku Yang Akan Diubah : ");
                for (int i = 0; i < n; i++) {
                    System.out.println("[" + (i + 1) + "] " + PERPUS[i].getJudul() + "\t| " + PERPUS[i].getPengarang());
                }
                int UbahBuku = CNDL.nextInt();
                System.out.print("Input Judul Buku : \n> ");
                String Judul = CNDL.next();
                PERPUS[UbahBuku - 1].setJudul(Judul);
                System.out.print("Input Pengarang Buku : \n> ");
                String Pengarang = CNDL.next();
                PERPUS[UbahBuku - 1].setPengarang(Pengarang);
                 
                System.out.print("input jumlah Halaman BUKU : \n> ");
                int Halaman = CNDL.nextInt();
                int OldHalaman = PERPUS[UbahBuku - 1].getHalaman();
                PERPUS[UbahBuku - 1].setHalaman(Halaman);
                SumHalaman = SumHalaman - OldHalaman + Halaman;
                if (PERPUS[UbahBuku - 1].getTipe() == "Fiksi") {
                    FiksiHalaman = FiksiHalaman - OldHalaman + PERPUS[UbahBuku-1].getHalaman();
                } else {
                    NonFiksiHalaman = NonFiksiHalaman - OldHalaman + PERPUS[UbahBuku-1].getHalaman();
                }
            } else if (pilihan == 3) {

                header("HAPUSBUKU.txt");
                System.out.println("");

                System.out.println("Pilih BUKU yang akan dihapus : ");
                for (int i = 0; i < n; i++) {
                    System.out.println("[" + (i + 1) + "] " + PERPUS[i].getJudul() + "\t| " + PERPUS[i].getPengarang());
                }
                int Delete = CNDL.nextInt();
                for (int i = Delete; i < n; i++) {
                    PERPUS[Delete-1]=PERPUS[i];
                }

                SumHalaman -= PERPUS[Delete-1].getHalaman();
                
                if (PERPUS[Delete-1].getTipe() == "Fiksi") {
                    Fiksi -= 1;
                    FiksiHalaman -= PERPUS[Delete-1].getHalaman();
                    n -= 1;
                } else {
                    NonFiksi -= 1;
                    NonFiksiHalaman -= PERPUS[Delete-1].getHalaman();
                    n -= 1;
                }
            } else {
                pil = 0;
            }
        } while (pil != 0);
    }
    }
    
