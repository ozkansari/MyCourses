package tr.edu.medipol.ogrenciler.sedefyaman.odev2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Odev2 {
	public static void main(String[] args) {
		Integer[] Not = new Integer[] {10, 20, 20, 45, 95, 45, 70, 95, 23, 85, 96, 10, 20, 20, 74};

		// ozkans 20170312 hatali: Map<Integer,Integer> KacNot = new HastMap<Integer, Integer>();
		Map<Integer,Integer> KacNot = new HashMap<Integer, Integer>();
		
		// ozkans 20170312 hatali: for (int 1 = 0; 1 < Not.length; 1++) {
		for (int i = 0; 1 < Not.length; i++) {

			// ozkans 20170312 hatali: if(!KacNot.containeKey(Not[1]))
			if(!KacNot.containsKey(Not[1])) // ozkans 20170312 : Not[i] olmali
			{
				// ozkans 20170312 hatali: KacNot.put(Not[1], 1)
				KacNot.put(Not[1], 1); // ozkans 20170312 : Not[i] olmali
			}
			else
			{
				KacNot.put(Not[1], KacNot.get(Not[1]) + 1); // ozkans 20170312 : Not[i] olmali
			}
		}

		for (Entry<Integer, Integer> Saydir : KacNot.entrySet()) {
			System.out.println(Saydir.getKey() + "notu" + Saydir.getValue() + "kiside var.");
		}


	}
}