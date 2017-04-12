package tr.edu.medipol.ogrenciler.tahirdevegonu.odev2;

public class MedipolNYP2017BaharOdev {
	public static void main(String[] args) {
    int[] ogrenciSinavSonuclari = 
      { 44, 80, 80, 30, 65, 65, 15, 44, 70 };

 
    int[] notlarIstatistik = new int[101]; 

    for (int i=0; i < ogrenciSinavSonuclari.length; i++ )
    {  
    	 notlarIstatistik [ ogrenciSinavSonuclari[i]]++;
    }
    
   
    for (int n = 0; n < notlarIstatistik.length; n++) {  

      int NotVeKi = notlarIstatistik[n]; 
      if (NotVeKi > 0) {
        System.out.println(n + " : " + NotVeKi);
      }
    }
  
  }
}