package spark.template.freemarker.batuhankizil.finalproje.model;

import java.math.BigDecimal;

public class Urun {

    public Urun(){}

    public Urun(String urun_adi, String urun_kategori, Double fiyat) {
        this.urun_adi = urun_adi;
        this.urun_kategori = urun_kategori;
        this.fiyat = fiyat;
    }

    private int urun_id;
    private String urun_adi;
    private String urun_kategori;
    private Double fiyat;

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getUrun_kategori() {
        return urun_kategori;
    }

    public void setUrun_kategori(String urun_kategori) {
        this.urun_kategori = urun_kategori;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }
}
