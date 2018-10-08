/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas_5;

import java.io.Serializable;

/**
 *
 * @author ErwindKristian
 */
public class Participant_TCP implements Serializable {
    private String nim;
    private String nama;
    private String jurusan;
    private String asal;

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getAsal() {
        return asal;
    }

    @Override
    public String toString() {
        return nim + " " + nama + " " + jurusan + " " + asal + " ";
    }
}
