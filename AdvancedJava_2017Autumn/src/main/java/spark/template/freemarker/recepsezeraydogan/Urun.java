package spark.template.freemarker.recepsezeraydogan;

public class Urun {
    private int id;
    private String marka;
    private int fiyat;
    private String model;
    private int adet;
    private int kategori;
    private String temelBilgiler;

    public static int ID = 1;



    // Source>Generate Constructor using fields
    public Urun(int id, String marka,String model,int adet,int kategori, int fiyat,String temelBilgiler) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.adet = adet;
        this.kategori = kategori;
        this.fiyat = fiyat;
        this.temelBilgiler = temelBilgiler;
    }
    // Source>Generate getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarka() {
        return marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public int getFiyat() {
        return fiyat;
    }
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }
    public String getModel() { return model;}
    public void setModel(String model) {this.model = model;}
    public int getAdet() {return adet;}
    public void setAdet(int adet) {this.adet = adet;}
    public int getKategori() {return kategori;}
    public void setKategori(int kategori) {this.kategori = kategori;}
    public String getTemelBilgiler() { return temelBilgiler; }
    public void setTemelBilgiler(String temelBilgiler) { this.temelBilgiler = temelBilgiler; }


}
