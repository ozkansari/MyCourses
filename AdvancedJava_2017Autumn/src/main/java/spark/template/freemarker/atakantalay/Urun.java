package spark.template.freemarker.atakantalay;

public class Urun {
    public Urun(int id, String ad, String tur, int stok,int deger) {
        this.id = id;
        this.ad = ad;
        this.tur = tur;
        this.stok = stok;
        this.deger =deger;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    public int getDeger() {
        return deger;
    }

    public void setDeger(int deger) {
        this.deger = deger;
    }
    private int stok;
    private int id;
    private  String ad;
    private  String tur;
    private  int deger;
    public static int ID;
}
