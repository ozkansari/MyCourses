package tr.edu.medipol.ogrenciler.mucahiddeniz.odev2;
import java.util.Arrays;

/**
 * ozkans 20170308 istenildigi gibi calismiyor
 * Not:55
 */
public class Odev2 {

	public static void main(String[] args){
		
		int[] sinavSonuclari = {10,20,80,20,30,30};
		int[] Istatistik = new int[101];
		Arrays.sort(sinavSonuclari);
		
		for(int i=0; i<sinavSonuclari.length; i++){
			if(i == sinavSonuclari[i]){
				int deger = 0;
				deger++;
				Istatistik[i] = deger;
			}
		}
		
		for	(int j=0; j<sinavSonuclari.length; j++){
			int notDegeri = sinavSonuclari[j];
			System.out.println(notDegeri);
		}
		  for (int n = 0; n < sinavSonuclari.length; n++) {  
		      int notAlanSayisi = Istatistik[n]; 

		      if (notAlanSayisi > 0) {

		        System.out.println(n + " : " + notAlanSayisi);
		      }

		    }

	}
	
}
