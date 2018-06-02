package spark.template.freemarker.alicancelik;

public class Kitap {
    private int id;
    private String kitapadi;
    private String yazaradi;
    private String yazarsoyadi;
    private String yayinevi;
    private int fiyat;

    public static int ID = 1;

    // Source>Generate Constructor using fields
    public Kitap( int id, String kitapadi, String yazaradi,String yazarsoyadi,String  yayinevi,int fiyat) {
        this.id = id;
        this.kitapadi = kitapadi;
        this.yazaradi = yazaradi;
        this.yazarsoyadi = yazarsoyadi;
        this.yayinevi=yayinevi;
        this.fiyat = fiyat;
    }
    // Source>Generate getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getKitapadi() {
        return kitapadi;
    }
    public void setKitapadiAdi(String kitapadi) {
        this.kitapadi = kitapadi;
    }

    public String getYazaradi() {
        return yazaradi;
    }

    public void setYazaradi(String yazaradi) {
        this.yazaradi = yazaradi;
    }
    public String getYazarsoyadi() {
        return yazarsoyadi;
    }

    public void setYazarsoyadi(String yazarsoyadi) {
        this.yazarsoyadi = yazarsoyadi;
    }
    public String getYayinevi() {
        return yayinevi;
    }

    public void setYayinevi(String yayinevi) {
        this.yayinevi = yayinevi;
    }
    public int getFiyat() {
        return fiyat;
    }
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
