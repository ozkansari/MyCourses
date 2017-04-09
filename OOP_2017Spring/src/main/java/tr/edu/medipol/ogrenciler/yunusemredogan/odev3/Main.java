package tr.edu.medipol.ogrenciler.yunusemredogan.odev3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		int [] sayiDizisi1={1,2,3,45,7896,684};
		sayiDizisi1[5]=343;
		
		int [] sayiDizisi2 = new int[3];
		sayiDizisi2[0]=2;
		sayiDizisi2[1]=2456;
		sayiDizisi2[2]=212;
		
		List<Integer> sayiListesi = new ArrayList<Integer>();
		sayiListesi.add(new Integer(6));
		sayiListesi.add(new Integer(3));
		
		for (int i = 0; i < sayiListesi.size(); i++) {
			
			Integer mevcutDeger=sayiListesi.get(i);
			System.out.println(mevcutDeger);
			
		}
		sayiListesi.add(5);
		
		for (Integer mevcutDeger : sayiListesi) {
			System.out.println(mevcutDeger);
		}
	}

}
