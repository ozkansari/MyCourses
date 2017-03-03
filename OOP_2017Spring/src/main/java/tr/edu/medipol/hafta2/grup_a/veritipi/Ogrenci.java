package tr.edu.medipol.hafta2.grup_a.veritipi;

public class Ogrenci {

	// DEGISKENLER ----------------
	
	private int ogrenciNo;
	private String ad;
	private String soyad;
	
	// YAPILANDIRICI / CONSTRUCTOR
	
	public Ogrenci(int ogrenciNo,
			 String ad,
			 String soyad) {
		this.ad = ad;
		this.soyad = soyad;
		this.ogrenciNo = ogrenciNo;
	}
	
	// METODLAR
	
	public String ogrenciIsminiVer() {
		String adSoyad = this.ad + " " + this.soyad;
		return adSoyad;
	}
	
	
}
