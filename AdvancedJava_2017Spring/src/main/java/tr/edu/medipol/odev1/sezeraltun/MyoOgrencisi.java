package tr.edu.medipol.odev1.sezeraltun;

public class MyoOgrencisi extends Ogrenci {
	
	public MyoOgrencisi(String adSoyad, String bolum)
	{
		super(adSoyad, bolum);
		
	}

	@Override
	public String ogrenciBilgileriAl() {
		return ogrenciTipiniAl() + " " +  adSoyad;
	}

	@Override
	public String ogrenciTipiniAl() {
		return "Myo Ogrencisi";
	}

}
