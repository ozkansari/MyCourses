package tr.edu.medipol.odev;

// Bu Sinif tanimini hic bir sekilde degistirmeyin
// Bu Sinif tanimini hic bir sekilde degistirmeyin
public abstract class Ogrenci implements Comparable<Ogrenci> {
	private String no;
	private String adSoyad;
	
	public Ogrenci(String ogrenciNo, String ogrenciAd) {
		this.no = ogrenciNo;
		this.adSoyad = ogrenciAd;
	}
	
	public String getNo() {
		return no;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public abstract String ogrenciTipi();
  
	public int compareTo(Ogrenci o) {
		return this.no.compareTo(o.ad);
	}
}
