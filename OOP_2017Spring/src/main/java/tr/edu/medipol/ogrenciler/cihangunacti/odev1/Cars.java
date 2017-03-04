package tr.edu.medipol.ogrenciler.cihangunacti.odev1;


public class Cars {
			public String marka;
			public String model;
			public String motor_hacmi;
			public String vites;
			public String yakit;
			public int yil;
		public Cars(String marka, String model, String motor_hacmi, String vites, String yakit, int yil){
			this.marka=marka;
			this.model=model;
			this.motor_hacmi=motor_hacmi;
			this.vites=vites;
			this.yakit=yakit;
			this.yil=yil;
		}
		public String ozellikler(){
			return "Marka: "+marka
					+"\nModel: "+model
					+"\nMotor Hacmi: "+motor_hacmi
					+"\nVites: "+vites
					+"\nYak�t: "+yakit
					+"\nY�l: "+yil;
		}
}
