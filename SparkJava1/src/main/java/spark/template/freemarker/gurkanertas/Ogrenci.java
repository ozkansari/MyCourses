package spark.template.freemarker.gurkanertas;
public class Ogrenci {

	public String adSoyad;
	public String bolum;
	public String Numara;
	public String ogrenciTipi;
	public Ogrenci(String adSoyad,
			String ogrenciTipi,
			String bolum,
			String numara){
		this.ogrenciTipi = ogrenciTipi;
		this.adSoyad = adSoyad;
		this.bolum = bolum;
		this.Numara = numara;
	}
	public Ogrenci(String adSoyad,
				   String bolum,
				   String numara){
		this.adSoyad = adSoyad;
		this.bolum = bolum;
		this.Numara = numara;
	}


	public String ogrenciBilgi(){ return "Ad soyad:"+this.adSoyad+" Numara:"+this.getNumara();}
	public String ogrenciBilgileriAl() { return this.adSoyad + "  Bölümü: " + this.bolum+ " Numarası:"+Numara+" Öğrenci Tipi"+ogrenciTipi;};
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		return "";
	}

	public String getNumara() {
		return Numara;
	}
	public String checkDurumu = "";

	public String getCheckDurumu() {
		return checkDurumu;
	}
}


