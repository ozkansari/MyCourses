package tr.edu.medipol.odev1.firattarhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 0/15
Dosyadan Okuma: 0/25
Dosyaya Yazma:  0/25
Genel Program: 5/15
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20

 */
public class Menu {

	private static Scanner ekranOkuyucu = new Scanner(System.in);
	
	private static List<String> ogrenciListesi = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		while(true) {
			ekranaMenuyuBas();
			
			System.out.println("Secim yapiniz: ");
			int kullaniciSecimi = kullaniciIntegerGirdiAl();
			MenuSecimi menuSecimi = MenuSecimi.enumaCevir(kullaniciSecimi);
			
			System.out.println(kullaniciSecimi + " sectiniz.");

			switch (menuSecimi) {
			case OGRENCI_EKLEME: // (1) Ogrenci Ekle
				ogrenciEklemeIslemi();
				break;
			case OGRENCI_SILME: // (2) Ogrenci Sil
				ogrenciSilmeIslemi();
				break;
			case OGRENCI_LISTELE: // (3) Ogrencileri Listele
				ogrenciListelemeIslemi();
				break;
			case CIKIS: // (0) Cikis
				System.out.println("Program sonlaniyor.");
				ekranOkuyucu.close();
				System.exit(0);
				break;
			default:
				System.out.println("Gecersiz secim");
				break;
			}
		}
		
	}

	/**
	 * @return
	 */
	private static Integer kullaniciIntegerGirdiAl() {
		String kullaniciGirisi = "";
		int girdi = -1;
		try {
			kullaniciGirisi = ekranOkuyucu.nextLine();
			girdi = Integer.valueOf( kullaniciGirisi );
		} catch(Exception e) {
			System.out.println("Gecerli bir deger giriniz. Girdiginiz deger: " 
					+ kullaniciGirisi);
		}
		return girdi;
	}
	
	private static void ogrenciSilmeIslemi() {
		System.out.println("Silmek istediginiz ogrenciyi seciniz: ");
		ogrencileriEkranaBas(0);
		System.out.print("Seciminiz: ");
		int kullaniciSecimi = kullaniciIntegerGirdiAl();
		System.out.println(ogrenciListesi.get(kullaniciSecimi-1) 
				+ " isimli ogrenci siliniyor.");
		ogrenciListesi.remove(kullaniciSecimi-1);
		
	}
	
	private static List<Ogrenci> ogrenciListesi2 = 
			new ArrayList<>();
	
	private static void ogrenciEklemeIslemi() {
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();
		ogrenciListesi.add(adSoyad);
		
		System.out.print("Ogrenci Tip Giriniz: ");
		String ogrenciTipi = ekranOkuyucu.nextLine();
		/*
		String bolum = "";
		System.out.println("Ogrenci Bolum Giriniz: ");
		ekranaBolumleriBas();
		int bolumId = kullaniciIntegerGirdiAl();
		switch (bolumId) {
		case 1:
			bolum = "MYO"; break;
		case 2:
			bolum = "Isletme"; break;
		case 3:
			bolum = "Matematik"; break;
		default: break;
		}
		*/
		String bolum = ekranOkuyucu.nextLine();
		
		Ogrenci yeniOgrenci = new Ogrenci(adSoyad, ogrenciTipi, bolum);
		ogrenciListesi2.add(yeniOgrenci);
		
		System.out.println(adSoyad + " isimli ogrenci eklendi.");
	}

	private static void ogrenciListelemeIslemi() {
		ogrencileriEkranaBas(0);
	}
	
	private static void ogrencileriEkranaBas(int yontem) {
		if (ogrenciListesi.isEmpty()) {
			System.out.println("<< Sistemde kayitli ogrenci yok >>");
			return;
		}
		
		if (yontem == 0) {
			int no = 1;
			for (String ogrenci : ogrenciListesi) {
				System.out.println(no + " -) " + ogrenci);
				no++;
			}
		} else if (yontem == 1) {
			System.out.println(ogrenciListesi);
		} else {
			for (int i = 0; i < ogrenciListesi.size(); i++) {
				System.out.println(i + " -) " + ogrenciListesi.get(i));
			}
		}
	}

	private static void ekranaMenuyuBas() {
		System.out.println("************************");
		System.out.println("MENU");
		System.out.println("(1) Ogrenci Ekle");
		System.out.println("(2) Ogrenci Sil");
		System.out.println("(3) Ogrencileri Listele");
		System.out.println("(0) Cikis");
		System.out.println("************************");	
	}
	

}
