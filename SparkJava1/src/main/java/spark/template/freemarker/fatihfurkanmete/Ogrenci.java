package spark.template.freemarker.fatihfurkanmete;
import java.util.List;

/**
 * Created by Mete on 25.05.2017.
 */
public class Ogrenci {

    public String adSoyad;
    public String bolum;
    public int numara;
    public String ogrenciTipi;


    public Ogrenci(String adSoyad, String ogrenciTipi, String bolum, int numara) {

        this.adSoyad = adSoyad;
        this.bolum = bolum;
        this.ogrenciTipi = ogrenciTipi;
        this.numara = numara;
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





}



