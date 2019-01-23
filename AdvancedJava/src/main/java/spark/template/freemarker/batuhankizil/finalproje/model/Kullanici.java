package spark.template.freemarker.batuhankizil.finalproje.model;

public class Kullanici {

    public Kullanici(){}

    public Kullanici(String kullanici_adi, String kullanici_tipi, int yas, String cinsiyet, String sifre) {
        this.kullanici_adi = kullanici_adi;
        this.kullanici_tipi = kullanici_tipi;
        this.yas = yas;
        this.cinsiyet = cinsiyet;
        this.sifre = sifre;
    }

    private String kullanici_adi;
    private String kullanici_tipi;
    private int yas;
    private String cinsiyet;
    private String sifre;

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getKullanici_tipi() {
        return kullanici_tipi;
    }

    public void setKullanici_tipi(String kullanici_tipi) {
        this.kullanici_tipi = kullanici_tipi;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
