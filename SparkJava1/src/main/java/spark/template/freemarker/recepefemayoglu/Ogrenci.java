package spark.template.freemarker.recepefemayoglu;
/**
 * Created by Efe Mayoğlu on 21.5.2017.
 */
public class Ogrenci {
	private String Ad,Soyad,Numara;
	private OgrenciTipi OgrenciTipi;
	private String OgrenciTipiId;

	public String getAd() {
		return Ad;
	}

	public void setAd(String ad) {
		Ad = ad;
	}

	public String getSoyad() {
		return Soyad;
	}

	public OgrenciTipi getOgrenciTipi() {
		return OgrenciTipi;
	}

	public void setOgrenciTipi(OgrenciTipi ogrenciTipi) {
		OgrenciTipi = ogrenciTipi;
	}

	public String getOgrenciTipiId() {
		return OgrenciTipiId;
	}

	public void setOgrenciTipiId(String ogrenciTipiId) {
		OgrenciTipiId = ogrenciTipiId;
	}

	public void setSoyad(String soyad) {
		Soyad = soyad;
	}

	public String getNumara() {
		return Numara;
	}

	public void setNumara(String numara) {
		Numara = numara;
	}


	public Ogrenci(String ad, String soyad, String numara, String ogrenciTipi) {
		this.Ad = ad;
		this.Soyad = soyad;
		this.Numara = numara;
		this.OgrenciTipiId = ogrenciTipi;
	}

	public String ogrenciBilgi(){
		return "Ad :"+getAd()+" Soyad:"+getSoyad();
	}
}
