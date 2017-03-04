package tr.edu.medipol.ogrenciler.mucahiddeniz.odev1;


public class Araba {
	
	String marka,model,renk,vites,yakitTipi;
	int yil,kapiSayisi;
	float km;
	
	public Araba(String marka, String model, String renk, String vites, String yakitTipi, int yil, int kapi, float km){
		this.marka = marka;
		this.model = model;
		this.renk = renk;
		this.vites = vites;
		this.yakitTipi = yakitTipi;
		this.yil = yil;
		this.kapiSayisi = kapiSayisi;
		this.km = km;
	}
	
	public void calistir(){
		System.out.println("Ara� �al��t�..");
	}
	
	public void stopEttir(){
		System.out.println("Arac�n motoru kapand�..");
	}
	
	public void gazaBas(){
		System.out.print("Gaza bast�n�z..");
	}
	
	public void freneBas(){
		System.out.print("Frene bast�n�z..");
	}
	
	public void farAc(){
		System.out.print("Farlar� a�t�n�z..");
	}
	
	public void farKapat(){
		System.out.print("Farlar� kapatt�n�z..");
	}

}
