package spark.template.freemarker.bayramozkanozmutlu;
public class Ogrenci {

    public String adSoyad;
    public String bolum;
    public String ogrenciNo;
    public String ogrenciTipi;
    public String ogrenciDers;
    public String DersAd;

    public Ogrenci(String adSoyad, String DersAd,String ogrenciTipi, String bolum, String ogrenciNo, String ogrenciDers){
        this.adSoyad = adSoyad;
        this.DersAd = DersAd;
        this.ogrenciTipi = ogrenciTipi;
        this.bolum = bolum;
        this.ogrenciNo=ogrenciNo;
        this.ogrenciDers=ogrenciDers;
    }

    public String ogrenciBilgi(){
    return "Ad ve Soyad : "+ this.adSoyad +" - "+ "Öðrenci No : "+ this.ogrenciNo;
    }
    
    public String ogrenciBilgileriAl() {
       return "Bölüm : "+ this.bolum  +" - "+ "Ders :"+ this.ogrenciDers +" - "+  "Okul Tipi :" + this.ogrenciTipi ;
    };
    public String ogrencidersBilgileriAl() {
        return "Ders : "+ this.DersAd  ;
     };
    public String ogrenciBilgisi() {
        return this.ogrenciTipi;
     };
     
     public String ogrenciNosu() {
         return this.ogrenciNo;
      };
    
    public String ogrenciBilgileriAl(boolean ekstraBilgi) {
        return "";
    }
}
