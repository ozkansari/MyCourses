package tr.edu.medipol.ogrenciler.muhammetaktas.odev2;

import java.util.Random;

public class notlar {
	public static void main(String[] args) {
		Random r = new Random();
        int[] ogrenciSinavSonuclari=new int[62]; //50 kişilik sınıfın notları random olarak atandı
        for (int i = 0; i < 50; i++) {
            ogrenciSinavSonuclari[i]=r.nextInt(100);     
        }
        
	    int[] notlarIstatistik = new int[101];
	    
	    
	    for(int i = 0; i < ogrenciSinavSonuclari.length; i++){
	    	int sayac = 0;
	    	for(int j = 0; j < ogrenciSinavSonuclari.length; j++){
	    		if(ogrenciSinavSonuclari[i] == ogrenciSinavSonuclari[j]){
	    			sayac++;
	    		}
	    	}
	    	notlarIstatistik[ogrenciSinavSonuclari[i]] = sayac; 
	    }
	    for (int n = 0; n < notlarIstatistik.length; n++) {  

	      int notAlanSayisi = notlarIstatistik[n]; 
	      if (notAlanSayisi > 0) {
	        System.out.println(n + " : " + notAlanSayisi);
	      }
	    }
	  }
}
