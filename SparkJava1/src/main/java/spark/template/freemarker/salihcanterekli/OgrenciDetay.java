package spark.template.freemarker.salihcanterekli;
public class OgrenciDetay {

    public String adSoyad;
    public String bolum;
    public String ogrenciNo;
    public String ogrenciTipi;
    public String ogrenciDers;

    public OgrenciDetay(String adSoyad,
                   String ogrenciTipi,
                   String bolum,
                   String ogrenciNo,
                   String ogrenciDers
    ){
        this.adSoyad = adSoyad;
        this.ogrenciTipi = ogrenciTipi;
        this.bolum = bolum;
        this.ogrenciNo=ogrenciNo;
        this.ogrenciDers= ogrenciDers;
    }

    public String OgrBilgi(){
        return this.ogrenciNo + "- " + this.adSoyad;
    }
    public String OgrDetay() {
        return this.ogrenciTipi  +" - "+ this.bolum + " - " + this.ogrenciDers ;
    };

    public String OgrListe() {
        return this.ogrenciNo  +" - "+ this.adSoyad + " - " + this.ogrenciDers ;
    };

    public String ogrenciBilgileriAl(boolean ekstraBilgi) {
        return "";
    }

    public String OgrNo() {
        return this.ogrenciNo;
    };

    public String OgrAd() {
        return this.adSoyad;
    };

    public String OgrDers() {
        return this.ogrenciDers;
    };

    public String OgrTip() {
        return this.ogrenciTipi;
    };
    public String OgrBolum() {
        return this.bolum;
    };


}
