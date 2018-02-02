package spark.template.freemarker.recepsezeraydogan;
public class Musteri {
    private String adi;

    public Musteri(String adi, String soyadi, String adres, int kkbilgisi, int tckimlik, int telno) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.adres = adres;
        this.kkbilgisi = kkbilgisi;
        this.tckimlik = tckimlik;
        this.telno = telno;
    }

    private String soyadi;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getKkbilgisi() {
        return kkbilgisi;
    }

    public void setKkbilgisi(int kkbilgisi) {
        this.kkbilgisi = kkbilgisi;
    }

    public int getTckimlik() {
        return tckimlik;
    }

    public void setTckimlik(int tckimlik) {
        this.tckimlik = tckimlik;
    }

    public int getTelno() {
        return telno;
    }

    public void setTelno(int telno) {
        this.telno = telno;
    }

    private String adres;
    private int kkbilgisi;
    private int tckimlik;
    private int telno;
}
