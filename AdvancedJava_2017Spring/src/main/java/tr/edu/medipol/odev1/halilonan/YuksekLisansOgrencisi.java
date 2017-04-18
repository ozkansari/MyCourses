package tr.edu.medipol.odev1.halilonan;

public class YuksekLisansOgrencisi extends Ogrenci {
public String danismanHoca;
	
	public YuksekLisansOgrencisi(String danismanHoca, 
			String adSoyad, String bolum) {
		super(adSoyad.toLowerCase(), bolum);
		this.danismanHoca = danismanHoca;
		
	}

	@Override
	public String ogrenciBilgileriAl() {
		return ogrenciTipiniAl() + "Ogrenci Ad�: " + adSoyad + "  Ogrenci Bolumu: " + bolum;
		
	
	}
	
	// Override & Overload
	@Override
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		String ekBilgi = super.ogrenciBilgileriAl(ekstraBilgi);
		if (ekstraBilgi) {
			ekBilgi += ogrenciBilgileriAl() + " ek bilgi....";
		} else {
			ekBilgi += ogrenciBilgileriAl();
		}
		return ekBilgi;
	
	}

	@Override
	public String ogrenciTipiniAl() {
		return "Yuksek Lisans Ogrencisi:";
	}
}
