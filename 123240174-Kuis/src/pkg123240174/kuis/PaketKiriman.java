/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123240174.kuis;

/**
 *
 * @author Lab Informatika
 */
public abstract class PaketKiriman {
    private String namaPacket;
    private int OngkirDasar;
    private int hargaPaket;

    public PaketKiriman(String namaPacket, int OngkirDasar, int hargaPaket) throws DataKirimTidakValidException {
        if (OngkirDasar <= 0) {
            throw new DataKirimTidakValidException("[ERROR] Ongkos kirim dasar harus lebih dari 0!");
        }
        this.namaPacket = namaPacket;
        this.OngkirDasar = OngkirDasar;
        this.hargaPaket = hargaPaket;
    }
    
    public abstract int hitungTotalHarga();

    public int getOngkirDasar() {
        return OngkirDasar;
    }

    public String getNamaPacket() {
        return namaPacket;
    }
    
    public int getHargaPaket() {
        return hargaPaket;
    }
}
