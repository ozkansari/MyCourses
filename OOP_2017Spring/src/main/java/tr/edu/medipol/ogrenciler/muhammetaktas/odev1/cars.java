package tr.edu.medipol.ogrenciler.muhammetaktas.odev1;

public class cars {
	public String marka;
	public String model;
	public int uretimYili;
	public String renk;
		public cars(String marka, String model, int uretimYili, String renk){
				this.marka=marka;
				this.model=model;
				this.uretimYili=uretimYili;
				this.renk=renk;
		}
		public String arabaOzellikleri(){
			return "Marka: "+marka+"\nModel: "+model+"\nYılı: "+uretimYili+"\nRengi :"+renk+"\n------------";
		}
}
