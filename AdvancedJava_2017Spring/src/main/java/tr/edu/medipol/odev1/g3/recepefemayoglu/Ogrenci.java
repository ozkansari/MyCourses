package tr.edu.medipol.odev1.g3.recepefemayoglu;

public abstract class Ogrenci {

	public String ad,soyad;
	
	public Ogrenci(String ad,String soyad){
		this.ad = ad;
		this.soyad = soyad;
	}
	
	public abstract String ogrenciTipi();
}
