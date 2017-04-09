package tr.edu.medipol.ogrenciler.muhittinayri.odev4;


public abstract class Calisanlar {
	protected String adSoyad;
	protected String Tarih;
	protected String Ucret;
	protected String CalismaSekli;
	protected String CalisanTipi;
	public Calisanlar(String CAdSoyad,String CTh,String CUt,String CSk,String Ct) {
		adSoyad = CAdSoyad;
		Tarih = CTh;
		Ucret = CUt;
		CalismaSekli=CSk;
		CalisanTipi=Ct;
		
	}
}
