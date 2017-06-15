package spark.template.freemarker.fundakavak;
import java.util.List;

/**
 * Created by berka on 27.05.2017.
 */
public class Ogrenci {
    public String ad;
    public String tip;
    public String bolum;
    public int no;
    public List<Ders> secilenDersler;

    public Ogrenci(String adSoyad,
                   String ogrenciTipi,
                   String bolum,
                   int no) {
        this.ad = ad;
        this.tip = tip;
        this.bolum = bolum;
        this.no = no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String adSoyad) {
        this.ad = ad;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String Tip) {
        this.tip = tip;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<Ders> getSecilenDersler() {
        return secilenDersler;
    }

    public void setSecilenDersler(List<Ders> secilenDersler) {
        this.secilenDersler = secilenDersler;
    }

    public String ogrenciDetayliBilgileriAl() {

        return "Ad - Soyad : " + this.ad + " - " + "Öğrenci Tipi " + this.tip + " - " + "Bölüm : " + this.bolum + "Öğrenci No : " + this.no;
    };

    public String ogrenciIsim() {

        return this.ad;
    };

    public String ogrenciBolum() {

        return String.valueOf(this.bolum);
    };

    public String ogrenciTipi() {

        return String.valueOf(this.tip);
    };

    public String ogrenciNo() {

        return String.valueOf(this.no);
    };

    public String ogrenciBilgileriAl(boolean ekstraBilgi) {
        return "";
    }

}
