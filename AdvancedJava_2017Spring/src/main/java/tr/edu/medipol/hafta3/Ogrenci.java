package tr.edu.medipol.hafta3;

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
		return null;
	};
	
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		return "";
	}
}


