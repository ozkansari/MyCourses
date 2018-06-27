package spark.template.freemarker.betulozdemir_but;


public class Betul_Ozdemir_Kullanici {
	private String kullaniciAdi;
	private String kullaniciTipi;
	private int yas;
	private String sifre;
	private String cinsiyet;
	private int id;

	public Betul_Ozdemir_Kullanici() {

	}

	public void Betül_Özdemir_Kullanici(int id,String kullaniciAdi, String kullaniciTipi, int yas,String cinsiyet,String sifre) {
		this.id = id;
		this.kullaniciAdi = kullaniciAdi;
		this.kullaniciTipi = kullaniciTipi;
		this.yas = yas;
		this.cinsiyet = cinsiyet;
		this.sifre = sifre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}


	public void setKullaniciTipi(String kullaniciTipi) {
		this.kullaniciTipi = kullaniciTipi;
		
		
	
	}

	public String getcinsiyet() {
		return cinsiyet;
	}


	public void setcinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	

	public int getyas() {
		return yas;
	}

	public void setyas(int yas) {
		this.yas = yas;
	}

	
	public String getsifre() {
		return sifre;
	}

	
	public void setsifre(String sifre) {
		this.sifre = sifre;
	}


	
}