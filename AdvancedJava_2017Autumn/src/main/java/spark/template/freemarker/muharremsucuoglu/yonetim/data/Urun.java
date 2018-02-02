package spark.template.freemarker.muharremsucuoglu.yonetim.data;

import spark.template.freemarker.muharremsucuoglu.kullanici.Sepet;

public class Urun extends Sepet {

    public int urunNo;
    Sepet sepet = new Sepet();
    private String urunAdi;
    private String urunKategori;
    private double fiyat;

    public Urun(String urunAdi,
                double fiyat,
                String urunKategori,
                int urunNo) {
        this.urunAdi = urunAdi;
        this.urunKategori = urunKategori;
        this.fiyat = fiyat;
        this.urunNo = urunNo;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunKategori() {
        return urunKategori;
    }

    public void setUrunKategori(String urunKategori) {
        this.urunKategori = urunKategori;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public int getUrunNo() {
        return urunNo;
    }

    public void setUrunNo(int urunNo) {
        this.urunNo = urunNo;
    }

    public String urunNo() {

        return String.valueOf(this.urunNo);
    }

    public String urunAdi() {

        return this.urunAdi;
    }

    public String urunKategori() {

        return String.valueOf(this.urunKategori);
    }

    public String urunFiyat() {

        return String.valueOf(this.fiyat);
    }

    public String urunSecildiMi() {
        return String.valueOf(this.sepet.getCount());
    }
}

