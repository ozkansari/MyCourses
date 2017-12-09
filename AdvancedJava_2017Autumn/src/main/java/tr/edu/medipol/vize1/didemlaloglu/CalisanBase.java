package tr.edu.medipol.vize1.didemlaloglu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class CalisanBase {
    private String ad;
    private String Soyad;
    private String meslek;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    } 

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }
    
    public CalisanBase(String ad, String soyad, String meslek){
        this.setAd(ad);
        this.setSoyad(soyad);
        this.setMeslek(meslek);
    }
}

