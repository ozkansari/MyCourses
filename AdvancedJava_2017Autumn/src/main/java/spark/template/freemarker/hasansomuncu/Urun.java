package spark.template.freemarker.hasansomuncu;

public class Urun {
    private int id;
    private String urunAdi;
    private String aciklama;
    private int fiyat;
  
    public static int ID = 1;
    
    // Source>Generate Constructor using fields
    public Urun(int id, String urunAdi, String aciklama, int fiyat) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
    }
    // Source>Generate getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUrunAdi() {
        return urunAdi;
    }
    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }
    
    public String getAciklama() {
        return aciklama;
    }
    
    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
    public int getFiyat() {
        return fiyat;
    }
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
