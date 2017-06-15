package spark.template.freemarker.recepefemayoglu;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Efe Mayoğlu on 21.5.2017.
 */
public class Ders {
    private String Ad,Akts,Id;
    private List<Ogrenci> ogrenciListesi = new ArrayList<>();

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        this.Ad = ad;
    }

    public String getAkts() {
        return Akts;
    }

    public Ders(String ad, String akts, String id) {
        Ad = ad;
        Akts = akts;
        Id = id;
    }

    public void setAkts(String akts) {
        this.Akts = akts;
    }

    public List<Ogrenci> getOgrenciListesi() {
        return ogrenciListesi;
    }

    public void setOgrenciListesi(List<Ogrenci> ogrenciListesi) {
        this.ogrenciListesi = ogrenciListesi;
    }

    public Ders(String ad, String akts) {
        this.Ad = ad;
        this.Akts = akts;
    }
}
