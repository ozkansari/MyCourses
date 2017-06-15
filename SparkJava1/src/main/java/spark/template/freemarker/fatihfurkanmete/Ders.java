package spark.template.freemarker.fatihfurkanmete;
import java.util.List;

/**
 * Created by Mete on 25.05.2017.
 */
public class Ders {

    public int dersId;
    public String dersAdi;
    public List<Ogrenci> dersinOgrencileri;

    public Ders(String dersAdi, int dersId) {
        this.dersId = dersId;
        this.dersAdi = dersAdi;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getDersId() {
        return dersId;
    }

    public void setDersId(int dersId) {
        this.dersId = dersId;
    }

    public String dersId() {return String.valueOf(this.dersId);}

}
