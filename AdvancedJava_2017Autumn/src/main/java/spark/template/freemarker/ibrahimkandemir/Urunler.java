package spark.template.freemarker.ibrahimkandemir;

public class Urunler {
	
	private int id;
	private float urunFiyati, urunIndirimliFiyati;
	private String urunBasligi, marka, kargoBilgisi, kargoTeslimat, urunAciklamasi;
	
	public static int ID = 1;
	
	
	
	
	public Urunler(int id, String urunBasligi, String marka, float urunFiyati, float urunIndirimliFiyati, String kargoBilgisi, String kargoTeslimat, String urunAciklamasi)
	{
		this.id = id;
		this.urunBasligi = urunBasligi;
		this.marka = marka;
		this.urunFiyati = urunFiyati;
		this.urunIndirimliFiyati = urunIndirimliFiyati;
		this.kargoBilgisi = kargoBilgisi;
		this.kargoTeslimat = kargoTeslimat;
		this.urunAciklamasi = urunAciklamasi;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getUrunFiyati() {
		return urunFiyati;
	}

	public void setUrunFiyati(float urunFiyati) {
		this.urunFiyati = urunFiyati;
	
	}

	public float getUrunIndirimliFiyati() {
		return urunIndirimliFiyati;
	}

	public void setUrunIndirimliFiyati(float urunIndirimliFiyati) {
		this.urunIndirimliFiyati = urunIndirimliFiyati;
	}

	public String getUrunBasligi() {
		return urunBasligi;
	}

	public void setUrunBasligi(String urunBasligi) {
		this.urunBasligi = urunBasligi;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getKargoBilgisi() {
		return kargoBilgisi;
	}

	public void setKargoBilgisi(String kargoBilgisi) {
		this.kargoBilgisi = kargoBilgisi;
	}

	public String getKargoTeslimat() {
		return kargoTeslimat;
	}

	public void setKargoTeslimat(String kargoTeslimat) {
		this.kargoTeslimat = kargoTeslimat;
	}

	public String getUrunAciklamasi() {
		return urunAciklamasi;
	}

	public void setUrunAciklamasi(String urunAciklamasi) {
		this.urunAciklamasi = urunAciklamasi;
	}
	


}
