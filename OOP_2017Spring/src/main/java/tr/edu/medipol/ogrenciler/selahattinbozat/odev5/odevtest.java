package tr.edu.medipol.ogrenciler.selahattinbozat.odev5;

// package �dev5;
import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/**
 DEGERLENDIRME ozkans: Odev tamamen hatali. Gonderdigin ve yaptiklarin icin 30 puan
 */
public class odevtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // HATALI: IslemlerOgrenci islemlerOgrenci = null;
	    /* OZKANS */ IslemlerOgrenci islemlerOgrenci = null;
		
		
		
		// HATALI: Ogrenci ogrenci = new Ogrencilistesi("11111","Ogrenci 1");
		/* OZKANS */ Ogrenci ogrenci = new OgrenciLisans("11111","Ogrenci 1");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci bulunanOgrenci = islemlerOgrenci.ogrenciBul("11111");
		System.out.println("Karsilastirma true olmali: " + ogrenci.getNo().equals(bulunanOgrenci.getNo()));
		
		Ogrenci bulunanOgrenci2 = islemlerOgrenci.ogrenciBul("22222");
		System.out.println("bulunanOgrenci2 null olmali: " + bulunanOgrenci2);
		
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("1");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);
	}

}
