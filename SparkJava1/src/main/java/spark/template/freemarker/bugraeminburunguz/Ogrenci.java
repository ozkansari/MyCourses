package spark.template.freemarker.bugraeminburunguz;
import java.util.List;

public class Ogrenci {

    public String adSoyad;
    public String bolum;
    public String ogrenciTipi;
    public int numara;
    private List<Ders> ogrencininDersleri;

    public Ogrenci(String adSoyad,
                   String ogrenciTipi,
                   String bolum,
                   int numara) {
        this.adSoyad = adSoyad;
        this.bolum = bolum;
        this.ogrenciTipi = ogrenciTipi;
        this.numara = numara;
    }

    public Ogrenci() {
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getOgrenciTipi() {
        return ogrenciTipi;
    }

    public void setOgrenciTipi(String ogrenciTipi) {
        this.ogrenciTipi = ogrenciTipi;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public List<Ders> getOgrencininDersleri() {
        return ogrencininDersleri;
    }

    public void setOgrencininDersleri(List<Ders> ogrencininDersleri) {
        this.ogrencininDersleri = ogrencininDersleri;
    }

    public String ogrenciDetayliBilgileriAl() {

        return "Ad Soyad : " + this.adSoyad + " - " + "Bölüm : " + this.bolum + " - " + "Öğrenci Tipi " + this.ogrenciTipi + " - " + "Numara : " + this.numara;
    }

    ;

    public String ogrenciNumara() {

        return String.valueOf(this.numara);
    }

    ;

    public String ogrenciIsim() {

        return this.adSoyad;
    }

    ;

    public String ogrenciBolum() {

        return String.valueOf(this.bolum);
    }

    ;

    public String ogrenciTipi() {

        return String.valueOf(this.ogrenciTipi);
    }

    ;


    public String ogrenciBilgileriAl(boolean ekstraBilgi) {
        return "";
    }
}

