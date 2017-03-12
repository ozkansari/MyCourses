package tr.edu.medipol.ogrenciler.talhakarakaya.odev2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MedipolNYP2017BaharOdev2 {
	public static void main(String[] args) {
		Integer[] ogrenciSinavSonuclari = { 65, 80, 80, 20, 65, 65, 15, 80, 70 };

		
		int[] notlarIstatistik = new int[101];

		List<Integer> notList = Arrays.asList(ogrenciSinavSonuclari);
		Set<Integer> tekilList = new HashSet<Integer>(notList);   // set<t�r�> setin ismi
																

		for (int not : tekilList) {
			System.out.println("Not : " + not + " ka� tane : " + Collections.frequency(notList, not));
		}
	}
}