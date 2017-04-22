package tr.edu.medipol.odev1.g7.firatkoc;
public abstract class Ogrenci {

	protected String adSoyad;
	public String bolum;
	public int numara;
	public Ogrenci(String adSoyad,
			String bolum,int numara){
		this.adSoyad = adSoyad;
		this.bolum = bolum;
		this.numara = numara;
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

