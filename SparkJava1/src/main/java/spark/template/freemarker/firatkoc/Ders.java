package spark.template.freemarker.firatkoc;

public class Ders {

    public String ad,akts;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAkts() {
        return akts;
    }

    public void setAkts(String akts) {
        this.akts = akts;
    }

    public Ders(String ad, String akts) {
        this.ad = ad;
        this.akts = akts;
    }
}
