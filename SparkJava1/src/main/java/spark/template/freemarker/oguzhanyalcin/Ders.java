package spark.template.freemarker.oguzhanyalcin;
/**
 * Created by Erhan on 24.05.2017.
 */
public class Ders {
    private int id;
    private String ad;

    public Ders(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
