package spark.template.freemarker.oguzhanyalcin;

public class Ogrenci {

    private int id;
    private String adSoyad;
    private String bolum;
    private String ogrenciTipi;
    private int numara;
    // public String ders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getOgrenciTipi() {
        return ogrenciTipi;
    }

    public void setOgrenciTipi(String ogrenciTipi) {
        this.ogrenciTipi = ogrenciTipi;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public Ogrenci(int id, String adSoyad, String ogrenciTipi, String bolum, int numara) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.bolum = bolum;
        this.ogrenciTipi = ogrenciTipi;
        this.numara = numara;
    }

    public Ogrenci(String adSoyad, String ogrenciTipi, String bolum, int numara) {
        this.adSoyad = adSoyad;
        this.bolum = bolum;
        this.ogrenciTipi = ogrenciTipi;
        this.numara = numara;
    }


    public String ogrenciAdSoyadAl() {

        return this.adSoyad; //+ " - " +  "Bölüm : "+ this.bolum + " - "+  "Öğrenci Tipi "+this.ogrenciTipi + " - " +  "Numara : "+this.numara;
    }

    ;

    public String ogrenciBolumAl() {

        return "Bölüm : " + this.bolum; //+ " - "+  "Öğrenci Tipi "+this.ogrenciTipi + " - " +  "Numara : "+this.numara;
    }

    ;

    public String ogrenciTipiAl() {

        return "Öğrenci Tipi " + this.ogrenciTipi;// + " - " +  "Numara : "+this.numara;
    }

    ;

    public String ogrenciNoAl() {

        return "Numara : " + this.numara;
    }

    ;


    public String ogrenciBilgiAl() {

        return this.adSoyad + " - " + this.bolum + " - " + this.ogrenciTipi + " - " + +this.numara;
    }

    ;

    public String ogrenciBilgileriAl(boolean ekstraBilgi) {
        return "";
    }
}

