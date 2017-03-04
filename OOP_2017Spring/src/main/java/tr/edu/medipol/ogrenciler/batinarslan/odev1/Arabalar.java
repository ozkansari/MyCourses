package tr.edu.medipol.ogrenciler.batinarslan.odev1;


public class Arabalar {
		    
		    public String Marka;
			public String Durumu;
			public String Takas;
		

			
			public Arabalar(String Marka,String Durumu,String Takas){
				
				this.Durumu=Durumu;
				this.Takas=Takas;
				this.Marka=Marka;
				System.out.println(Marka+" Marka \n"+" Durumu:"+Durumu+"\n Takas:"+Takas);
			}
				

				public String ozellikler(){
					return " Marka : "+ Marka +" Takas : "+ Takas + "Durumu : " + Durumu;
				}
				
		}
	


