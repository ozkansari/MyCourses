package tr.edu.medipol.ogrenciler.muhittinayri.odev2;


public class OgrenciNotlari {

	public static void main(String[] args) {

		int[]OgrenciSinav={90,90,85,80,85,100,75,70,70,50,75,100,75,50};
		int[] notlarIstatistik = new int[101];
		
		notlarIstatistik[90]=2;
		notlarIstatistik[85]=2;
		notlarIstatistik[80]=1;
		notlarIstatistik[100]=2;
		notlarIstatistik[75]=3;
		notlarIstatistik[70]=2;
		notlarIstatistik[50]=2;
		
		for (int i = 0; i < OgrenciSinav.length; i++) {
			int Not = OgrenciSinav[i];
			System.out.println(Not);
		}
			
		 for (int n = 0; n < notlarIstatistik.length; n++) {  
			 int notAlanSayisi = notlarIstatistik[n]; 
		      if (notAlanSayisi > 0) {
		        System.out.println(n + " : " + notAlanSayisi + " Ki�i Bu notu alm��t�r.");
		      }
		    }
		 }

	}

