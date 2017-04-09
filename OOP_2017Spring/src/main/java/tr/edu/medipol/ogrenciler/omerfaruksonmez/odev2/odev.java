package tr.edu.medipol.ogrenciler.omerfaruksonmez.odev2;


import java.util.Arrays;

public class odev {

	  public static void main(String[] args) {
	    int[] ogrenciSinavSonuclari = { 70, 85, 80, 25, 70, 65, 15, 85, 75 };
	    
	    // 100 farkli not olabilir
	    int[] notlarIstatistik = new int[100]; 
	    	    
	    
	    for(int i = 0; i < ogrenciSinavSonuclari.length; i++){
	    	
	    	int say = 0;
	    	
	    	for(int j = 0; j < ogrenciSinavSonuclari.length; j++){
	    			say++;
	    	//	}
	    	//}
	    	} // ozkans duzeltme
	    	
	    	notlarIstatistik[ogrenciSinavSonuclari[i]] = say; 
	    	
	    }

	    // Hesaplama sonucunu ekrana yaz
	    // 0dan 100e tum notlari ekrana yaz
	    for (int n = 0; n < notlarIstatistik.length; n++) {  
	      // o notu kac kisinin aldigi bilgisi 
	      // notlarIstatistik[n] icinde olmali
	      int notAlanSayisi = notlarIstatistik[n]; 
	      if (notAlanSayisi > 0) {
	        System.out.println(n + " : " + notAlanSayisi);
	      }
	    }
	    // Program ornek ciktisi:
	    // 20 : 1
	    // 25 : 1
	    // 70 : 3
	    // 75 : 1
	    // 85 : 3  
	  }
}