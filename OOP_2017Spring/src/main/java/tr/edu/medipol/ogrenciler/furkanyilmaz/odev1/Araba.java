package tr.edu.medipol.ogrenciler.furkanyilmaz.odev1;


public class Araba {

		public String Marka;
		public String Renk;
		public String Yakit;
		
		public Araba (String Marka,String Renk,String Yakit){
		
			
			this.Marka=Marka;
			this.Renk=Renk;
			this.Yakit=Yakit;
			
			System.out.println(Marka+"\n"+Renk+"\n"+Yakit);
			
		}
		
           public String ozellikler(){
			
			return "Marka : "+ Marka + "Renk : "+ Renk + "Yak�t :"+Yakit;
		}
	}


	


