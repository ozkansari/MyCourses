package spark.template.freemarker.mustafacumhur_oksuz;

public class Sepet {

    private String kitapAdi;
    private Yazar yazar;

    public Sepet(String kitapAdi,
                 String yazarAdi, String yazarSoyadi) {
        this.kitapAdi = kitapAdi;
        this.yazar = new Yazar(yazarAdi, yazarSoyadi);
    }

    public String getKitapAdi() {
        return kitapAdi;
    }
    public Yazar getYazar() {
        return yazar;
    }

}

