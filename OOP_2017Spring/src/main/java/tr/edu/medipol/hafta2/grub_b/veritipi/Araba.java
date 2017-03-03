package tr.edu.medipol.hafta2.grub_b.veritipi;

public class Araba {

	// DEGISKENLER
	private String marka;
	private int id;
	
	// CONSTRUCTOR
	

		public Araba(String marka) {
			this.marka = marka;
		}
	
	// METODLAR
	
	public String getMarka(){
		return marka;
	}
	
	public void setMarka(String m) {
		this.marka = m;
	}
}
