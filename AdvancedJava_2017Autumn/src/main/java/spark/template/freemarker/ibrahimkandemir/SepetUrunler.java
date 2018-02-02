package spark.template.freemarker.ibrahimkandemir;

public class SepetUrunler {
	
	private int id;
	private float urunFiyati, urunToplamFiyati;
	private String urunBasligi, marka;
	
	
	public static int ID = 1;
	
	
	public SepetUrunler(int id, String urunBasligi, String marka, float urunFiyati, float urunToplamFiyati) {
		this.id = id;
		this.urunBasligi = urunBasligi;
		this.marka = marka;
		this.urunFiyati = urunFiyati;
		this.urunToplamFiyati = urunToplamFiyati;
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	public float getUrunFiyati() {
		return urunFiyati;
	}

	public void setUrunFiyati(float urunFiyati) {
		this.urunFiyati = urunFiyati;
	}

	public float getUrunToplamFiyati() {
		return urunToplamFiyati;
	}

	public void setUrunToplamFiyati(float urunToplamFiyati) {
		this.urunToplamFiyati = urunToplamFiyati;
	}


}
