package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev2;


public class Main {
	public static void main(String[] args) {
	    int[] ogrenciSinavSonuclari = 
	      { 65, 80, 80, 20, 65, 65, 15, 80, 70 };
	    
	    	    
	    int[] notlarIstatistik = new int[101]; 
	    
	    for(int i=0; i<ogrenciSinavSonuclari.length; i++){
	    	  
	    	  
	    	for(int j=0; j<notlarIstatistik.length; j++){
	    		
	    		if(ogrenciSinavSonuclari[i] == j){
	    			
	    			notlarIstatistik[j]++;
	    		}
	    	}	   
	    }
	
	    for (int i = 0; i < ogrenciSinavSonuclari.length; i++) {
	             System.out.println(i+".not:"+ogrenciSinavSonuclari[i]); 
	     }

	    System.out.println("\nNotlar� alan o�renci sayisi: \n");
	    for (int n = 0; n < notlarIstatistik.length; n++) {  
	         int notAlanSayisi = notlarIstatistik[n]; 
	         	if (notAlanSayisi > 0) {
	         		System.out.println(n + " : " + notAlanSayisi);
	      }	      
	    }	    
	    
	}
}	




