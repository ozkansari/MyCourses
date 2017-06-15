package spark.template.freemarker.resulvural;

public class Ogrenci {

	public String adSoyad;
	public String bolum;
	
	public Ogrenci(String adSoyad, 
			String ogrenciTipi, 
			String bolum){
		this.adSoyad = adSoyad;
		this.bolum = bolum;
	}
	
	public String ogrenciBilgileriAl() {
		return this.adSoyad + " - " + this.bolum;
	};
	
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		return "";
	}
}

