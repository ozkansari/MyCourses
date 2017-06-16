package spark.template.freemarker.recepaykut;

public class Ogrenci {

	public String adSoyad;
	public String bolum;
	public String ogrenciNo;
	public String ogrenciDers;
	
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