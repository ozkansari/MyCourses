package tr.edu.medipol.hafta4;

public abstract class Ogrenci {

	public String adSoyad;
	public String bolum;
	
	public Ogrenci(String adSoyad,
			String bolum){
		this.adSoyad = adSoyad;
		this.bolum = bolum;
	}
	
	public abstract String ogrenciBilgileriAl();
	
	public abstract String ogrenciTipiniAl();
	
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		return "Ogrenci";
	}
}


