package tr.edu.medipol.odev1.g1.bayramozkanozmutlu;

public class LisansOgrencisi extends Ogrenci {
	
	public LisansOgrencisi(String adSoyad, String bolum) {
		super(adSoyad, bolum);
	}

	@Override
	public String ogrenciBilgileriAl() {
		return ogrenciTipiniAl() + " " +  adSoyad;
	}
	
	@Override
	public String ogrenciTipiniAl() {
		return "Lisans Ogrencisi";
	}

}
