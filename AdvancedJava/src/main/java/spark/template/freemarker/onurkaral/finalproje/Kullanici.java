package spark.template.freemarker.onurkaral.finalproje;

public class Kullanici {
    private String kullaniciAdi;
    private String kullaniciTipi;
    private int yas;
    private String cinsiyet;
    private String sifre;

    public Kullanici(String kullaniciAdi, String kullaniciTipi, int yas, String cinsiyet, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciTipi = kullaniciTipi;
        this.yas = yas;
        this.cinsiyet = cinsiyet;
        this.sifre = sifre;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getKullaniciTipi() {
        return kullaniciTipi;
    }

    public int getYas() {
        return yas;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public String getSifre() {
        return sifre;
    }
}
