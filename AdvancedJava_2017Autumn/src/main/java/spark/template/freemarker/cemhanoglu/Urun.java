package spark.template.freemarker.cemhanoglu;

public class Urun {
    public static int ID;
    private String marka;
    private String model;
    private int adet;
    private int fiyat;


    public Urun(int id,String marka, String model, int adet, int fiyat) {
        this.marka = marka;
        this.model = model;
        this.adet = adet;
        this.fiyat = fiyat;
    }


    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }



}
