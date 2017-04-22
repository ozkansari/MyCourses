package tr.edu.medipol.odev2.g5.recepefemayoglu;

public abstract class Ogrenci {

	public String ad,soyad;
	public String bolum;
	
	public Ogrenci(String ad,String soyad){
		this.ad = ad;
		this.soyad = soyad;
	}
	public Ogrenci(String ad,String soyad,String bolum){
		this.ad = ad;
		this.soyad = soyad;
		this.bolum  = bolum;
	}
	
	public abstract String ogrenciTipi();
}
