package tr.edu.medipol.ogrenciler.cihangunacti.odev2;


public class not {

	public static void main(String[] args) {
		int[] ogrenciNotlari = 
		      { 65, 80, 80, 20, 65, 65, 15, 80, 70 };
		System.out.println("Notlar");
		
		
		for (int i = 0; i < ogrenciNotlari.length; i++) {
			int notlar = ogrenciNotlari[i];
			System.out.println(notlar);
			
		}
		 		
					
		    int[] notlarIstatistik = new int[101]; 
		    for (int i = 0; i < ogrenciNotlari.length; i++) {
				int notDegeri = ogrenciNotlari[i];
				notlarIstatistik[notDegeri]++;
			}
			
		   
		  
		    for (int n = 0; n < notlarIstatistik.length; n++) {  
		      
		      int notAlanSayisi = notlarIstatistik[n]; 
		      
		      if (notAlanSayisi > 0) {
		        System.out.println(n + " : " + notAlanSayisi);
		     
		      }
		      
		    }
		    
		  }
		

	}


