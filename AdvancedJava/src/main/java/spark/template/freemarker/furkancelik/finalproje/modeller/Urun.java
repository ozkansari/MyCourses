package spark.template.freemarker.furkancelik.finalproje.modeller;

public class Urun {

    private int urunId;
    private String urunAdi;
    private String urunKategori;
    private int fiyat;

    public Urun(int urunId, String urunAdi, String urunKategori, int fiyat) {
        this.urunId = urunId;
        this.urunAdi = urunAdi;
        this.urunKategori = urunKategori;
        this.fiyat = fiyat;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunKategori() {
        return urunKategori;
    }

    public void setUrunKategori(String urunKategori) {
        this.urunKategori = urunKategori;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
