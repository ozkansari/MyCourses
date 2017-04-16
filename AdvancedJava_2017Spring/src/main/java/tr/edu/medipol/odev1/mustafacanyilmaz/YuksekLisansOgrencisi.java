package tr.edu.medipol.odev1.mustafacanyilmaz;

public class YuksekLisansOgrencisi extends Ogrenci {
	
	public String danismanHoca;
	public YuksekLisansOgrencisi(String danismanHoca, 
			String adSoyad, String bolum) {
		super(adSoyad.toLowerCase(), bolum);
		this.danismanHoca = danismanHoca;	
	}
	public String ogrenciBilgileriAl() {
		// TODO Auto-generated method stub
		return ogrenciTipiniAl()+ " " + adSoyad;
	}

	public String ogrenciTipiniAl() {
		// TODO Auto-generated method stub
		return "Yüksek Lisans Ogrencisi " ;
	}
	
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		String ekBilgi = super.ogrenciBilgileriAl(ekstraBilgi);
		if (ekstraBilgi) {
			ekBilgi += ogrenciBilgileriAl() + " ek bilgi....";
		} else {
			ekBilgi += ogrenciBilgileriAl();
		}
		return ekBilgi;
	
	}
	
	
	

}
