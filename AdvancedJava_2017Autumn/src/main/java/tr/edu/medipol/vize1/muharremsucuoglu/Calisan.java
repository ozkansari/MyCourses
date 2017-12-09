package tr.edu.medipol.vize1.muharremsucuoglu;

public class Calisan {
    private String adi;
    private String cinsiyet;
    private String calisanTipi;
    private int calisanNo;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getCalisanTipi() {
        return calisanTipi;
    }

    public void setCalisanTipi(String calisanTipi) {
        this.calisanTipi = calisanTipi;
    }

    public int getCalisanNo() {
        return calisanNo;
    }

    public void setCalisanNo(int calisanNo) {
        this.calisanNo = calisanNo;
    }

    @Override
    public String toString() {
        return
                "adi= " + adi + '\'' +
                        "cinsiyet= " + cinsiyet + '\'' +
                        "calisanNo= " + calisanNo;
    }
}
