package spark.template.freemarker.halilonan;
import java.util.ArrayList;

public class Ogrenci {

    public String adSoyad;
    public String bolum;
    public String ogrenciNo;
    public String ogrenciTipi;
    public String Ders;

    public Ogrenci(String adSoyad,
                   String ogrenciTipi,
                   String bolum,
                    String ogrenciNo, String Ders
                    ){
        this.adSoyad = adSoyad;
        this.ogrenciTipi = ogrenciTipi;
        this.bolum = bolum;
        this.ogrenciNo=ogrenciNo;
        this.Ders=Ders;
    }

   
    public String ogrenciBilgileri() {
       return  this.ogrenciNo+" - "+this.adSoyad;
    };
    public String ogrenciBilgileriDetay() {
    	
    
        return "Öðrenci No: " + this.ogrenciNo+" - "+
         	   "Öðrenci Adý: " + this.adSoyad +" - "+ 
         	   "Öðrenci Tipi: " + this.ogrenciTipi  +" - "+ 
         	   "Öðrenci Bölümü: " + this.bolum +" - "+ 
         	   "Öðrenci Dersi: " + this.Ders ;
     };

    public String ogrenciBilgileriAl(boolean ekstraBilgi) {
        return "";
    }
}
