package spark.template.freemarker.havvagamzeakbas;

public class Urun {
    private int id;
    private String urunAdi;
    private int fiyat;
  
    public static int ID = 1;
    
    // Source>Generate Constructor using fields
    public Urun(int id, String urunAdi, int fiyat) {
        this.id = id;
        this.urunAdi = urunAdi;
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
    public int getFiyat() {
        return fiyat;
    }
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
}
