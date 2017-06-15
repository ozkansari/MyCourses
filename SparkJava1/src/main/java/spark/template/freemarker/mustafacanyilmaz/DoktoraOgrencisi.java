package spark.template.freemarker.mustafacanyilmaz;

public class DoktoraOgrencisi extends Ogrenci {

	

	public DoktoraOgrencisi(int Id, String adSoyad, String ogrenciTipi, String bolum, String ogrenciYas,
			String ogrenciDers1, String ogrenciDers2) {
		super(Id, adSoyad, ogrenciTipi, bolum, ogrenciYas, ogrenciDers1, ogrenciDers2);
		// TODO Auto-generated constructor stub
	}

	public String ogrenciBilgileriAl() {
		return this.adSoyad + " - " + this.bolum + " - " + this.ogrenciTipi;
	};
	
	


}
