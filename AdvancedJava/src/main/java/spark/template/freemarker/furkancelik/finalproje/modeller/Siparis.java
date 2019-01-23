package spark.template.freemarker.furkancelik.finalproje.modeller;

public class Siparis {


    public Siparis(int siparisId, String kullaniciAdi, String urunIdler, int toplamUcret) {
        this.siparisId = siparisId;
        this.kullaniciAdi = kullaniciAdi;
        this.urunIdler = urunIdler;
        this.toplamUcret = toplamUcret;
    }

    private int siparisId;

    private String kullaniciAdi;

    private String urunIdler;

    private int toplamUcret;

    public int getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(int siparisId) {
        this.siparisId = siparisId;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getUrunIdler() {
        return urunIdler;
    }

    public void setUrunIdler(String urunIdler) {
        this.urunIdler = urunIdler;
    }

    public int getToplamUcret() {
        return toplamUcret;
    }

    public void setToplamUcret(int toplamUcret) {
        this.toplamUcret = toplamUcret;
    }
}
