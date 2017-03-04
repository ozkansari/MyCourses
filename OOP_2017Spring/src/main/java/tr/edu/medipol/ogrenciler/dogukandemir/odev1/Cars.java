package tr.edu.medipol.ogrenciler.dogukandemir.odev1;


public class Cars {
			public String marka;
			public String model;
			public String max_hiz;
			public String vites;
			public String beygir;
			public String hizlanma;
			public int yil;
		public Cars(String marka, String model, String max_hiz, String vites, String beygir,String hizlanma, int yil){
			this.marka=marka;
			this.model=model;
			this.max_hiz=max_hiz;
			this.vites=vites;
			this.beygir=beygir;
			this.hizlanma=hizlanma;
			this.yil=yil;
		}
		public String ozellikler(){
			return "Marka: "+marka
					+"\nModel: "+model
					+"\nMAX HIZ: "+max_hiz
					+"\nVites: "+vites
					+"\nBEYG�R: "+beygir
					+"\nHIZLANMA(0-100km)"+hizlanma
					+"\nY�l: "+yil;
		}
}
