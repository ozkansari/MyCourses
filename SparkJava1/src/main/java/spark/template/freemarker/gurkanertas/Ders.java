package spark.template.freemarker.gurkanertas;

public class Ders {
    public String dersAdi;
public String dersKodu;

    public Ders(String dersAdi, String dersKodu) {
        this.dersAdi = dersAdi;
        this.dersKodu = dersKodu;
    }
    public String dersBilgileriAl() { return this.dersAdi + " - " + this.dersKodu;}

    public String getDersKodu() {
        return dersKodu;
    }
}
