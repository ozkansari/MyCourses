package spark.template.freemarker.recepefemayoglu;
/**
 * Created by Efe Mayoğlu on 21.5.2017.
 */
public class OgrenciDers {
    private String OgrenciNumara,DersId;

    public String getOgrenciNumara() {
        return OgrenciNumara;
    }

    public void setOgrenciNumara(String ogrenciNumara) {
        this.OgrenciNumara = ogrenciNumara;
    }

    public String getDersId() {
        return DersId;
    }

    public void setDersId(String dersId) {
        this.DersId = dersId;
    }

    public OgrenciDers(String ogrenciNumara, String dersId) {
        this.OgrenciNumara = ogrenciNumara;
        this.DersId = dersId;

    }
}
