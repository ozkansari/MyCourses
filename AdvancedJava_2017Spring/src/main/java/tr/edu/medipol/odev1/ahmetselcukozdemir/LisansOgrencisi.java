package tr.edu.medipol.odev1.ahmetselcukozdemir;

/**
 * Created by ASO on 9.04.2017.
 */
public class LisansOgrencisi extends Ogrenci {

    public LisansOgrencisi(String adSoyad, String bolum) {

        super(adSoyad, bolum);
    }

    @Override
    public String ogrenciBilgileriAl() {

        return ogrenciTipiniAl() + " " +  adSoyad;
    }

    @Override
    public String ogrenciTipiniAl() {

        return "Lisans Ogrencisi";
    }
}
