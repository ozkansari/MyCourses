package tr.edu.medipol.odev1.g1.sefaokuyucu;

public class YuksekLisansOgrencisi extends Ogrenci {

public String Hoca;
	
	public YuksekLisansOgrencisi(String danismanHoca, 
			String adSoyad, String bolum) {
		super(adSoyad.toLowerCase(), bolum);
		this.Hoca = danismanHoca;
		
	}

	@Override
	public String ogrenciBilgileriAl() {
		return ogrenciTipiniAl() + " " + adSoyad;
	}
	
	
	@Override
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		String ekBilgi = super.ogrenciBilgileriAl(ekstraBilgi);
		if (ekstraBilgi) {
			ekBilgi += ogrenciBilgileriAl() + "Detayl� Bilgi...";
		} else {
			ekBilgi += ogrenciBilgileriAl();
		}
		return ekBilgi;
	
	}

	@Override
	public String ogrenciTipiniAl() {
		return "Yuksek Lisans Ogrencisi";
	}
	
}
