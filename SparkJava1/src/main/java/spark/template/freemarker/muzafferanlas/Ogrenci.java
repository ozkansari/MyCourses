package spark.template.freemarker.muzafferanlas;
public class Ogrenci {

    public String adSoyad;
    public String bolum;
    public String ogrenciNo;
    public String ogrenciTipi;
    public String ogrenciDers;



    public Ogrenci(String adSoyad,
                   String ogrenciTipi,
                   String bolum,
                    String ogrenciNo,
                   String ogrenciDers
                     ){
        this.adSoyad = adSoyad;
        this.ogrenciTipi = ogrenciTipi;
        this.bolum = bolum;
        this.ogrenciNo=ogrenciNo;
        this.ogrenciDers = ogrenciDers;

    }

    public String ogrenciBilgi(){
    return "Öğrenci No : <b>" + this.ogrenciNo + "</b> &nbsp;&nbsp;|&nbsp; " +" Öğrenci Adı Soyadı : <b>"+ this.adSoyad+"</b>";
    }
    public String ogrenciBilgileriAl() {
       return  "&nbsp; [&nbsp; Öğrenci Tipi : &nbsp;  <b>" + this.ogrenciTipi  + "</b> &nbsp;] <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  [&nbsp;  Öğrenci Bölümü : &nbsp;  <b>"+ this.bolum +"</b> &nbsp;]  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  [&nbsp;  Öğrenci Ek Ders : &nbsp;  <b>"+  this.ogrenciDers +"</b> &nbsp;] " ;
    };

    public String ogrenciBilgileriAl(boolean ekstraBilgi) {
        return "";
    }


}

