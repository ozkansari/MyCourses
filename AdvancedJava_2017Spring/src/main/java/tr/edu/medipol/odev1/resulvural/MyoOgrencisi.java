package tr.edu.medipol.odev1.resulvural;

/**
 * Created by Rsl on 9.04.2017.
 */

public class MyoOgrencisi extends  Ogrenci {
    public MyoOgrencisi(String adSoyad, String bolum)
    {
        super(adSoyad, bolum);

    }

    @Override
    public String ogrenciBilgileriAl() {

        return ogrenciTipiniAl() + " " +  adSoyad;
    }

    @Override
    public String ogrenciTipiniAl() {

        return "Myo Öğrencisi";
    }

}
