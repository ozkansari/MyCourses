package spark.template.freemarker.filizdagdeviren;

public class Ogrenci {
	public String adSoyad;
	public String ogrenciNo;
	public String ogrenciTipi;
	public String ogrenciTipiId;
	public String bolum;
		
		public Ogrenci(String ders,
				String ogrenciNo, 
				String ogrenciTipi,
				String ogrenciId, 
				String bolum
				){
			this.adSoyad = adSoyad;
			this.ogrenciNo = ogrenciNo;
			this.ogrenciTipi = ogrenciTipi;
			this.ogrenciTipiId = ogrenciTipiId;
			this.bolum = bolum;
		}
		
		public String dersBilgileriAl() {
			return this.adSoyad + " - " + this.ogrenciNo + " - " + this.ogrenciTipi+ " - " + this.ogrenciTipi+ " - " + this.bolum;
		};
		
		public String dersBilgileriAl(boolean ekstraBilgi) {
			return "";
		}

}
