package tr.edu.medipol.vize1.recepsezeraydogan_atakantalay_cemhanoglu;

public class Personel {
    private int id;
    private String adi;
    private String soyadi;
    private int telefon;
    private int tckimlik;

    public Personel() {
    }

    public Personel(int id, String adi, String soyadi, int telefon, int tckimlik) {
        this.id = id;
        this.adi = adi;
        this.soyadi = soyadi;
        this.telefon = telefon;
        this.tckimlik = tckimlik;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getTckimlik() {
        return tckimlik;
    }

    public void setTckimlik(int tckimlik) {
        this.tckimlik = tckimlik;
    }


}
