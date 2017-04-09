package tr.edu.medipol.ogrenciler.batinarslan.odev4;


public abstract class Calisan {
	protected String CalisanADSoyad;
	protected String Tel;
	protected String Adres;
	protected String Pozisyon;
	
	public Calisan(String CalisanAdSoyad,String CalisanTel,String CalisanAdres,String CalisanPozisyon) {
		CalisanADSoyad = CalisanAdSoyad;
		Tel = CalisanTel;
		Adres = CalisanAdres;
		Pozisyon = CalisanPozisyon;
	}
}

