package tr.edu.medipol.vize1.recepsezeraydogan_atakantalay_cemhanoglu;

public class Urun {
    private int id;
    private String urunadi;
    private int fiyat;
    private String marka;
    private String model;
    private int stok;
    public Urun() {
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Urun(int id, String urunadi, int fiyat, String marka) {
        super();
        this.id = id;
        this.urunadi = urunadi;
        this.fiyat = fiyat;
        this.marka = marka;
        this.model = model;
        this.stok = stok;


    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) throws Exception {
        if (fiyat <= 0) {
            throw new Exception();
        }
        this.fiyat = fiyat;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }


}

