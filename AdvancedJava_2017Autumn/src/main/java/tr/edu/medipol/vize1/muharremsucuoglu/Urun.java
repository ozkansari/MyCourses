package tr.edu.medipol.vize1.muharremsucuoglu;

public class Urun {
    private String urunAdi;
    private String urunKategori;
    private int urunID;
    private String urunFiyat;

    public String getUrunAdi() {
        return urunAdi;
    }

    void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUrunKategori() {
        return urunKategori;
    }

    void setUrunKategori(String urunKategori) {
        this.urunKategori = urunKategori;
    }

    int getUrunID() {
        return urunID;
    }

    void setUrunID(int urunID) {
        this.urunID = urunID;
    }

    public String getUrunFiyat() {
        return urunFiyat;
    }

    void setUrunFiyat(String urunFiyat) {
        this.urunFiyat = urunFiyat;
    }

    @Override
    public String toString() {
        return "Ürün Adı='" + urunAdi + '\'' +
                "Kategori='" + urunKategori + '\'' +
                "ID=" + urunID +
                "Fiyat='" + urunFiyat + '\'';
    }
}
