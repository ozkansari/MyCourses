package spark.template.freemarker.huseyinsirtikara;


public class Ogrenci {

	public String adSoyad;
	public String bolum;
	public String ogrenciTipi;
	public int ogrenciNumara;

	public Ogrenci(String adSoyad, String bolum, String ogrenciTipi, int ogrenciNumara) {
		this.adSoyad = adSoyad;
		this.bolum = bolum;
		this.ogrenciTipi = ogrenciTipi;
		this.ogrenciNumara = ogrenciNumara;
	}
/*
	public Ogrenci(String adSoyad,
				   String ogrenciTipi,
				   String bolum){
		this.adSoyad = adSoyad;
		this.bolum = bolum;
		this.ogrenciTipi = ogrenciTipi;
	}
	*/
	public String ogrenciBilgileriAl() {
		return this.adSoyad + " - " + this.bolum;
	};
	public String ogrenciBilgileriAl2() {
		return this.adSoyad + " - " + this.bolum+" No:"+ogrenciNumara;
	};

	public int ogrenciNumarasi(){
		return this.ogrenciNumara;
	}
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		return "";
	}
}


