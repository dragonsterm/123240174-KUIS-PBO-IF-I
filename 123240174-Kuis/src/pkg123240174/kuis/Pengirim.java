/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123240174.kuis;

/**
 *
 * @author Lab Informatika
 */
public class Pengirim {
    private static int counter = 0;
    private String idPengirim;
    private String nama;

    public Pengirim(String nama) {
        counter++;
        this.idPengirim = String.format("P%03d", counter);
        this.nama = nama;
    }

    public String getIdPengirim() {
        return idPengirim;
    }

    public String getNama() {
        return nama;
    }
}
