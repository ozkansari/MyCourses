package tr.edu.medipol.odev1.sefaokuyucu;

public class OgrenciDoktora extends Ogrenci{
	
	public OgrenciDoktora(String adSoyad, String bolum) {
		super(adSoyad, bolum);

	}

	@Override
	public String ogrenciBilgileriAl() {
		return ogrenciTipiniAl() + " " +  adSoyad;
	}
	
	@Override
	public String ogrenciTipiniAl() {
		return "Doktora Ogrencisi";
	}
	

}
