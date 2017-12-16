package tr.edu.medipol.hafta03;

import java.util.HashMap;
import java.util.Map;

public class SinifListesi {
	public static void main(String[] args) {

		int [] notlar = {10,10,20,65,65,65,10,20,100};
		
		System.out.println("Yontem 1 - Array ile: ");
		hesaplaYontem1(notlar);
		
		System.out.println("Yontem 2 - Map ile: ");
		hesaplaYontem2(notlar);
	}

	private static void hesaplaYontem2(int[] notlar) {
		Map<Integer, Integer> notIstatistik = new HashMap<Integer, Integer>();
		for (int i = 0; i < notlar.length; i++) {
			
			Integer notDegeri = notlar[i];
			Integer notAlanSayisi = notIstatistik.get(notDegeri);
			
			if (notAlanSayisi == null) {
				notIstatistik.put(notDegeri, 1);
			} else {
				notIstatistik.put(notDegeri, notAlanSayisi+1);
			}
		}
	
		for (Map.Entry<Integer, Integer> entry: notIstatistik.entrySet()) {
			int notAlanSayisi = entry.getValue();
			Integer notDegeri = entry.getKey();
			System.out.println(notDegeri + " : " + notAlanSayisi);
		}
	}
	
	/**
	 * @param notlar
	 */
	private static void hesaplaYontem1(int[] notlar) {
		int [] istatistik = new int [101];
		for (int i = 0; i < notlar.length; i++) {
			int notDegeri = notlar[i];
			istatistik[notDegeri]++;
		}
		
		for (int notDegeri = 0; notDegeri < istatistik.length; notDegeri++) {
			int notAlanSayisi = istatistik[notDegeri];
			if (notAlanSayisi>0) {
				System.out.println(notDegeri + " : " + notAlanSayisi);
			}
			
		}
	}
	
}
