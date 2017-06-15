package spark.template.freemarker.fundakavak;
import java.util.List;

/**
 * Created by berka on 27.05.2017.
 */
public class Ders {
    public String dersAdi;
    public int dersKredi;
    public int dersAKTS;
    public int dersId;
    public List<Ogrenci> dersinOgrencileri;

    public Ders(String dersAdi, int dersKredi, int dersAKTS, int dersId) {
        this.dersAdi = dersAdi;
        this.dersKredi = dersKredi;
        this.dersAKTS = dersAKTS;
        this.dersId = dersId;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getDersKredi() {
        return dersKredi;
    }

    public void setDersKredi(int dersKredi) {
        this.dersKredi = dersKredi;
    }

    public int getDersAKTS() {
        return dersAKTS;
    }

    public void setDersAKTS(int dersAKTS) {
        this.dersAKTS = dersAKTS;
    }

    public int getDersId() {
        return dersId;
    }

    public void setDersId(int dersId) {
        this.dersId = dersId;
    }

    public List<Ogrenci> getDersinOgrencileri() {
        return dersinOgrencileri;
    }

    public void setDersinOgrencileri(List<Ogrenci> dersinOgrencileri) {
        this.dersinOgrencileri = dersinOgrencileri;
    }

    public String dersId() {

        return String.valueOf(this.dersId);
    }
}