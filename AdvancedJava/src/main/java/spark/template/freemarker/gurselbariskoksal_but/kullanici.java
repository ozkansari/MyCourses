package spark.template.freemarker.gurselbariskoksal_but;
/**
 * Kullanici nesnesi.
 * @author bariskoksal
 *  http://localhost:4567/giris_sayfasi
 * http://localhost:4567/yonetici
 * localhost:4567
 */

public class kullanici {

    private String kullanici_adi, kullanici_tipi, cinsiyet, sifre;
    private int yas;

    /**
     * Kullanici objesi constructeri.
     * @param kullanici_adi  kullanıcı adi
     * @param kullanici_tipi  admin yada normal
     * @param yas admin yada normal
     * @param cinsiyet
     * @param sifre
     */

    public kullanici(String kullanici_adi, String kullanici_tipi, int yas, String cinsiyet , String sifre){
        super();
        this.kullanici_adi = kullanici_adi ;
        this.kullanici_tipi = kullanici_tipi ;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
        this.sifre = sifre;


    }
    /**
     * Kullanici objesine ait get set metodlari.
     */

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

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

}