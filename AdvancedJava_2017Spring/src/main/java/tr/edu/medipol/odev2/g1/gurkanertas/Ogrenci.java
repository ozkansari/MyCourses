package tr.edu.medipol.odev2.g1.gurkanertas;
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
	
	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public int getNumara() {
		return numara;
	}

	public void setNumara(int numara) {
		this.numara = numara;
	}

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

