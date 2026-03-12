/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg123240174.kuis;

import java.util.Scanner;

/**
 *
 * @author Lab Informatika
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner sc = new Scanner(System.in);
         boolean exit = false;
         int maxDelivery = 100;
         int jumlahPengiriman = 0;
         Pengirim[] daftarPengirim = new Pengirim[maxDelivery];
         PaketKiriman[] daftarPaketPengirim = new PaketKiriman[maxDelivery];
         
         do {
             System.out.println("=== SISTEM PENGIRIMAN PAKET - JasaKirimKita ===");
             System.out.println("1. Tambah Pengiriman");
             System.out.println("2. Keluar");
             System.out.print("Pilih Menu: ");
             int pilihan = sc.nextInt();
             sc.nextLine();
             switch (pilihan) {
                 case 1:
                     System.out.println("--- Data Pengirim ---");
                     System.out.print("Nama: ");
                     String nama = sc.nextLine();
                     
                     System.out.println("---Data Paket ---");
                     System.out.print("Harga paket/barang: ");
                     int hargaPaket = sc.nextInt();
                     try {
                         if (hargaPaket <= 0) {
                             throw new DataKirimTidakValidException(" Harga paket harus lebih dari 0!");
                         }
                        sc.nextLine();
                        System.out.print("Ongkos Kirim Dasar: ");
                        int OngkosKirim = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Jenis Pengiriman (1. Regular / 2. Ekspres /3. SameDay): ");
                        int jenisPengiriman = sc.nextInt();
                        sc.nextLine();
                        PaketKiriman paket = null;
                        if (jenisPengiriman == 1) {
                            paket = new KirimRegular(OngkosKirim, hargaPaket);
                        } else if (jenisPengiriman == 2) {
                            paket = new KirimExpres(OngkosKirim, hargaPaket);
                        } else if (jenisPengiriman == 3) {
                            paket = new KirimSameDay(OngkosKirim, hargaPaket);
                        } else {
                            System.out.println("Pilihan tidak valid");
                        }
                        Pengirim pengirim = new Pengirim(nama);
                        daftarPengirim[jumlahPengiriman] = pengirim;
                        daftarPaketPengirim[jumlahPengiriman] = paket;
                        jumlahPengiriman++;
                        System.out.println("[OK] Pengiriman berhasil ditambahkan!");
                       
                     } catch ( DataKirimTidakValidException e) {
                         System.err.println("[ERROR]" + e.getMessage());
                         
                     }
                     break;
                 case 2:
                     exit = true;
                     break;
                 default:
                     System.out.println("Pilihan Tidak Valid");
             }
         } while (!exit);
         System.out.println("====== REKAP PENGIRIMAN ======");
         for (int i = 0; i < jumlahPengiriman; i++) {
             Pengirim p = daftarPengirim[i];
             PaketKiriman k = daftarPaketPengirim[i];
             System.out.println("Pengirim: " + p.getNama());
             System.out.println("Paket: " + k.getNamaPacket());
             System.out.println("Harga Ongkir: " + k.hitungTotalHarga());
         }
    }
    
}
