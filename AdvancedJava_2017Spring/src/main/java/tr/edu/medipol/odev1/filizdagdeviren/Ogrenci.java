package tr.edu.medipol.odev1.filizdagdeviren;

public abstract class Ogrenci {

	protected String adSoyad;
	public String bolum;
	
	public Ogrenci(String adSoyad,
			String bolum){
		this.adSoyad = adSoyad;
		this.bolum = bolum;
	}
	
	public abstract String 
		ogrenciBilgileriAl();
	
	public abstract String 
		ogrenciTipiniAl();
	
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		String bilgi = "Ogrenci: ";
		bilgi += bolum.trim();
		bilgi += adSoyad.toUpperCase();  
		bilgi += ogrenciBilgileriAl();
		
		return  bilgi;
	}

}
