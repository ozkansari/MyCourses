package spark.template.freemarker.kerimbiber;

public class Ogrenci {

    public String adSoyad;
    public String bolum;
    public String ogrenciNo;
    public String ogrenciTipi;

    public Ogrenci(String adSoyad,
                   String ogrenciTipi,
                   String bolum,
                    String ogrenciNo){
        this.adSoyad = adSoyad;
        this.ogrenciTipi = ogrenciTipi;
        this.bolum = bolum;
        this.ogrenciNo=ogrenciNo;
    }

    public String ogrenciBilgi(){
    return this.ogrenciNo + "- " + this.adSoyad;
    }
    public String ogrenciBilgileriAl() {
       return this.ogrenciTipi  +" - "+ this.bolum ;
    };

    public String ogrenciBilgileriAl(boolean ekstraBilgi) {
        return "";
    }
}