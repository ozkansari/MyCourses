package spark.template.freemarker.mustafacanyilmaz;

public class Ogrenci {
	
	
	public int Id;
	public String adSoyad;
	public String bolum;
	public String ogrenciTipi;
	public String ogrenciYas;
	public String ogrenciDers1;
	public String ogrenciDers2;
	
	public Ogrenci(int Id, String adSoyad, String ogrenciTipi, 
			String bolum,String ogrenciYas, String ogrenciDers1,String ogrenciDers2){
		this.Id = Id;
		this.adSoyad = adSoyad;
		this.bolum = bolum;
		this.ogrenciTipi = ogrenciTipi;
		this.ogrenciYas = ogrenciYas;
		this.ogrenciDers1 = ogrenciDers1;
		this.ogrenciDers2 = ogrenciDers2;
		
	}
	
	public String ogrenciBilgileriAl() {
		return this.adSoyad + " - " + this.bolum + " - " + this.ogrenciTipi;
	};
	
	public String ogrenciDetayiniAl(){
		
		return this.adSoyad + " - " +  this.ogrenciYas  + " - " +  this.ogrenciDers1  + " - " +  this.ogrenciDers2;
		
	}
	public String ogrenciIdAl(){
		return String.valueOf(this.Id);
	}
	public String ogrenciAdAl(){
		return this.adSoyad;
	}
	public String ogrenciTipAl(){
		return this.ogrenciTipi;
	}
	public String ogrenciBolumAl(){
		return this.bolum;
	}
	public String ogrenciYasAl(){
		return this.ogrenciYas;
	}
	public String ogrenciDers1Al(){
		return this.ogrenciDers1;
	}
	public String ogrenciDers2Al(){
		return this.ogrenciDers2;
	}
	
	public String ogrenciBilgileriAl(boolean ekstraBilgi) {
		return "";
	}
	

}
