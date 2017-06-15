package spark.template.freemarker.ahmetselcukozdemir;

public class Dersler {
	public String dersAdi;
	public String dersHoca;
	
	public Dersler(String dersAdi, 
			String dersHoca 
			){
		this.dersAdi = dersAdi;
		this.dersHoca = dersHoca;
	}
	
	public String dersBilgileriAl() {
		return this.dersAdi + " - " + this.dersHoca;
	};
	
	public String dersBilgileriAl(boolean ekstraBilgi) {
		return "";
	}
}
