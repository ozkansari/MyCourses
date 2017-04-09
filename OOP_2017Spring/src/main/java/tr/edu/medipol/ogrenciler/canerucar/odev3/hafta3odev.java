package tr.edu.medipol.ogrenciler.canerucar.odev3;

import java.util.*;

public class hafta3odev {
	public String ogrenci;
	public int not;

	public hafta3odev(String ogr, int ogrNot) {
		ogrenci = ogr;
		not = ogrNot;
	}

	public static void main(String[] args) {
		String ogrenci;
		int not;

		Scanner tarama = new Scanner(System.in);
		List<hafta3odev> OgrenciListesi = new ArrayList<hafta3odev>();

		for (int i = 0; i < 2; i++) {
			System.out.println("Ogrenci Adini Giriniz: ");
			ogrenci = tarama.next();

			System.out.println("Ogrenci Notunu Giriniz: ");
			not = tarama.nextInt();

			OgrenciListesi.add(new hafta3odev(ogrenci, not));

		}
		for (int i = 0; i < OgrenciListesi.size(); i++) {
			hafta3odev ogr = OgrenciListesi.get(i);
			System.out.println("Ogrenci Adi: " + ogr.ogrenci);
			System.out.println("Ogrenci Notu: " + ogr.not);
		}

	}
}
