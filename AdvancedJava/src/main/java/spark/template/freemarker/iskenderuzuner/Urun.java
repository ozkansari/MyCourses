package spark.template.freemarker.iskenderuzuner;

public class Urun {
    private int id;
    private String kitapadi;
    private int fiyati;
    private String yazaradi;
    private String yazarsoyadi;
    private String yayinevi;
    public static int ID = 1;



    // Source>Generate Constructor using fields
    public Urun(int id, String kitapadi,String yazaradi, int fiyati,String yazarsoyadi,String yayinevi) {
        this.id = id;
        this.kitapadi = kitapadi;
        this.yazaradi = yazaradi;
        this.fiyati = fiyati;
        this.yazarsoyadi = yazarsoyadi;
        this.yayinevi = yayinevi;
    }
    // Source>Generate getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getKitap() {
        return kitapadi;
    }
    public void setKitap(String kitapadi) {
        this.kitapadi = kitapadi;
    }
    public int getFiyati() {
        return fiyati;
    }
    public void setFiyati(int fiyat) {
        this.fiyati = fiyati;
    }
    public String getYazar() { return yazaradi;}
    public void setYazar(String yazaradi) {this.yazaradi = yazaradi;}

    public String getYazarSoyadi() { return yazarsoyadi; }
    public void setYazarSoyadi(String yazarsoyadi) { this.yazarsoyadi = yazarsoyadi; }
    
    public String getYayinEvi() { return yayinevi; }
    public void setYayinEvi(String yayinevi) { this.yayinevi = yayinevi; }


}
