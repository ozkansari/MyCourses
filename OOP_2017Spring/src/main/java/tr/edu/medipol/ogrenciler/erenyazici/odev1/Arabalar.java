package tr.edu.medipol.ogrenciler.erenyazici.odev1;


public class Arabalar {

	String model;
	String marka;
	int beygir;
	
	public Arabalar (String model,String marka,int beygir){
		
		this.model=model;
		this.marka=marka;
		this.beygir=beygir;
		
	}
	
	public String ArabaModel() {
		
		return model;
	}
	
	public String ArabaMarka(){
		
		return marka;
	}
	
	public int ArabaBeygir(){
		
		return beygir;
	}
	
	
	
	
	
	
}
