package spark.template.freemarker.sezerozaltun;


public class Ogrenci {

	public String adSoyad;
	public String bolum;
	public String ogrenciTipi;
	public String ogrenciNo;
	
	public Ogrenci(String ogrenciNo,String adSoyad, 
			String ogrenciTipi, 
			String bolum){
		this.adSoyad = adSoyad;
		this.bolum = bolum;
		this.ogrenciTipi = ogrenciTipi;
		this.ogrenciNo = ogrenciNo;
	}
	
	public String ogrenciBilgileriAl() {
		return this.ogrenciNo + "-"+  this.adSoyad + " - "  + this.bolum + " -" + this.ogrenciTipi;
	};
	
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		return "";
	}
}


