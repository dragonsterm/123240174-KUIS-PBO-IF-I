/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123240174.kuis;

/**
 *
 * @author Lab Informatika
 */
public class KirimRegular extends PaketKiriman implements DiskonOngkir {
    private int diskon;

    public KirimRegular(int OngkirDasar, int hargaPaket) throws DataKirimTidakValidException {
        super("Kirim Regular", OngkirDasar, hargaPaket);
    }
    
    @Override
    public void cetakInfoDiskon(int hargaPaket) {
        if (hargaPaket >= 30000) {
            diskon = getOngkirDasar();
            if (diskon >= 40000) {
                diskon = 40000;
            }
        } else {
            diskon = 0;
        }
        System.out.println("Diskon anda adalah: Rp." + diskon);
    }
    
    @Override
    public int hitungTotalHarga() {
        cetakInfoDiskon(getHargaPaket());
        return getOngkirDasar() - diskon;
    }
}
