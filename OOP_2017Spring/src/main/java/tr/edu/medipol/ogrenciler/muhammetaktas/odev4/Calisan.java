package tr.edu.medipol.ogrenciler.muhammetaktas.odev4;

public abstract class Calisan  {
protected String adSoyad;
protected String girisYili;
	
	public Calisan(String calisanAdSoyad, String calisanGirisYili) {
		adSoyad = calisanAdSoyad;
		girisYili = calisanGirisYili;
	}
	public abstract String CalisanTipi();

}
