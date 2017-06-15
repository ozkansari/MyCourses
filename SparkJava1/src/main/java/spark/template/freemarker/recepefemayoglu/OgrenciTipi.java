package spark.template.freemarker.recepefemayoglu;
/**
 * Created by Efe Mayoğlu on 21.5.2017.
 */
public class OgrenciTipi {
    private String Tip,Id,KacYillik;

    public OgrenciTipi(String tip, String id, String kacYillik) {
        this.Tip = tip;
        this.Id = id;
        this.KacYillik = kacYillik;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public OgrenciTipi(String tip, String kacYillik) {
        this.Tip = tip;
        this.KacYillik = kacYillik;
    }

    public String getTip() {
        return Tip;
    }

    public void setTip(String tip) {
        this.Tip = tip;
    }

    public String getKacYillik() {
        return KacYillik;
    }

    public void setKacYillik(String kacYillik) {
        this.KacYillik= kacYillik;
    }
}
