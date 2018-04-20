package tr.edu.medipol.vizeproje.iskender_uzuner;

import java.util.ArrayList;
import java.util.Arrays;

public class KitapListele {
    private int id;
    private String kitapadi;
    private String yazari;
    private String turu;
    private String yayinevi;
    private int sayfasayisi;

    public KitapListele() {
    }

    public KitapListele(int id, String kitapadi, String yazari, String turu, String yayinevi , int sayfasayisi) {
        super();
        this.id = id;
        this.kitapadi = kitapadi;
        this.yazari = yazari;
        this.turu = turu;
        this.yayinevi = yayinevi;
        this.sayfasayisi = sayfasayisi;
    }
    
    //�r�nlerimiz
    public static ArrayList<KitapListele> kitaplar = new ArrayList<KitapListele>(
            Arrays.asList(
            new KitapListele(1, "K�z�l Dosya", "�skender Uzuner", "Roman","Ren Yay�nc�l�k",592)
         )
    );

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitapAdi() {
        return kitapadi;
    }

    public void setKitapAdi(String kitapadi) {
        this.kitapadi = kitapadi;
    }

    public String getYazari() {
        return yazari;
    }

    public void setYazari(String yazari) {
        this.yazari = yazari;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getYayinEvi() {
        return yayinevi;
    }

    public void setYayinEvi(String yayinevi) {
        this.yayinevi = yayinevi;
    }
    
    public int getSayfaSayisi() {
        return sayfasayisi;
    }

    public void setSayfaSayisi(int sayfasayisi) {
        this.sayfasayisi = sayfasayisi;
    }
    
    public static ArrayList<KitapListele> getKitaplar() {
        return kitaplar;
    }

    public static void setUrunler(ArrayList<KitapListele> urunler) {
    	KitapListele.kitaplar = urunler;
    }
}
