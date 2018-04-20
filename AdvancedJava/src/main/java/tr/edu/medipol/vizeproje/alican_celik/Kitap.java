package tr.edu.medipol.vizeproje.alican_celik;
public class Kitap {
    private int id;
    private String kitapadi;
    private String kitapturu;
    private String yayinevi;
    private String yazaradi;
    private int sayfasayisi;
    public Kitap() {
    }

    public int getSayfasayisi() {
        return sayfasayisi;
    }

    public void setSayfasayisi(int sayfasayisi) {
        this.sayfasayisi = sayfasayisi;
    }

    public Kitap(int id, String kitapadi, String kitapturu, int sayfasayisi, String yayinevi, String yazaradi) {
        super();
        this.id = id;
        this.kitapadi = kitapadi;
        this.kitapturu = kitapturu;
        this.yayinevi = yayinevi;
        this.yazaradi = yazaradi;
        this.sayfasayisi = sayfasayisi;


    }

    public String getYazaradi() {
        return yazaradi;
    }

    public void setYazaradi(String yazaradi) {
        this.yazaradi = yazaradi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitapadi() {
        return kitapadi;
    }

    public void setKitapadi(String kitapadi) {
        this.kitapadi = kitapadi;
    }

    public String getKitapturu() {
        return kitapturu;
    }

    public void setKitapturu(String kitapturu){this.kitapturu = kitapturu;}

    public String getYayinevi() {
        return yayinevi;
    }

    public void setYayinevi(String yayinevi) {
        this.yayinevi = yayinevi;
    }


}

