package spark.template.freemarker.sefaokuyucu;

public class Ogrenci {

    public String adSoyad;
    public String bolum;
    public String ogrenciNo;
    public String ogrenciTipi;
    public String ders;
    public Ogrenci(String adSoyad,
                   String ogrenciTipi,
                   String bolum,
                    String ogrenciNo){
        this.adSoyad = adSoyad;
        this.ogrenciTipi = ogrenciTipi;
        this.bolum = bolum;
        this.ogrenciNo=ogrenciNo;
    }

    public Ogrenci(String ders) {
		this.ders = ders;
	}

	public String ogrenciBilgi(){
    return this.ogrenciNo + "- " + this.adSoyad;
    }
	public String dersListesi() {
	       return this.ders = ders ;
	    };
    public String ogrenciBilgileriAl() {
       return this.ogrenciTipi  +" - "+ this.bolum ;
    };

    public String ogrenciNosu() {
        return this.ogrenciNo;
     };
     
    public String ogrenciBilgileriAl(boolean ekstraBilgi) {
        return "";
    }
}
