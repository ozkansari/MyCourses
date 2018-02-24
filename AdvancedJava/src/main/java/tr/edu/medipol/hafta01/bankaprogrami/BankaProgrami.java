package tr.edu.medipol.hafta01.bankaprogrami;

import java.util.*;

import bankaprogrami.model.Musteri;

public class BankaProgrami {

	private static int versiyon = 3;
	private static List<Musteri> musteriler = new ArrayList<>();
	
	public static void main(String[] args) {
		Musteri ismail = new Musteri("Ismail YK");
		musteriler.add(ismail);
		/*
		System.out.println(ismail.getAd());
		System.out.println(ismail.MILLET);
		System.out.println(Musteri.MILLET);
		*/
		Musteri iskender = new Musteri("Imparator Iskender");
		musteriler.add(iskender);
		/*
		System.out.println(iskender.getAd());
		System.out.println(iskender.MILLET);
		*/
		// final oldugu icin sonraki satir gecersiz
		// iskender.MILLET = "INGILTERE";
		
		// ismail = iskender;
		// System.out.println(ismail.getAd());
		
		musteriler.add(new Musteri());
		
		for (int i = 0; i < musteriler.size(); i++) {
			Musteri m = musteriler.get(i);
			System.out.println(m.getAd());
		}
		
		for (Musteri m : musteriler) {
			System.out.println(m.getAd());
		}
		// System.out.println(m); // m burada tanimsiz
		
		
	}

}
