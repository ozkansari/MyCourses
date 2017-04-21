package tr.edu.medipol.odev1.beyzaodeyen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/** ozkans Degerlendirme

Gecersiz Cenkhan Akdemir ve Oguzhan Yalcin ile ayni.
Komsusundan yardim alarak yaptigini itiraf etti.
Kodu aciklayamadi.

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 15/15
Dosyadan Okuma: 20/25 (substring mantigi efektif degil,  hata cikabilir)
Dosyaya Yazma:  25/25
Genel Program: 10/15 (otomatikOgrenciEklemeIslemi() ile ortak kod kullanimi olabilirdi)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20
Benzer Kod Yazma Nedeniyle: -50
-----------------------------------
Sonuc: 40
 */
public class MenuOrnegi {

	private static Scanner ekranOkuyucu = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		dosyadanOkumaIslemi();
		
		while(true) {
			ekranaMenuyuBas();
			
			System.out.println("Merhaba,menulerden yapmak istediginiz islemi secerek devam edebilirsiniz.\nSecim yapiniz: ");
			int kullaniciSecimi = kullaniciIntegerGirdiAl();
			MenuSecimi menuSecimi = MenuSecimi.enumaCevir(kullaniciSecimi);
			
			System.out.println(kullaniciSecimi + " sectiniz.");

			switch (menuSecimi) {
			case OGRENCI_EKLEME: 
				ogrenciEklemeIslemi();
				break;
			case OGRENCI_SILME:
				ogrenciSilmeIslemi();
				break;
			case OGRENCI_LISTELE:
				ogrenciListelemeIslemi();
				break;
			case CIKIS:
				ogrencileriDosyayaYaz();
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

	private static void ogrencileriDosyayaYaz() {
		
		System.out.print("\nListedeki ��renciler dosyaya yaz�l�yor...\n");
		
		try{
		    PrintWriter writer = new PrintWriter(new FileWriter("ogrenciListesi.txt"));
		    int no = 1;
			for (Ogrenci ogrenci : ogrenciListesi2) {
				writer.println(no + " -) " + ogrenci.ogrenciBilgileriAl());
				no++;
			}
			writer.close();
		} catch (IOException e) {
		   System.out.println("Error\n");
		}
	}

	private static void dosyadanOkumaIslemi() {
		System.out.println("��renciler dosyadan okunuyor...\n");
		try (BufferedReader br = new BufferedReader(new FileReader("ogrenciListesi.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.toLowerCase().contains("Yuksek Lisans Ogrencisi".toLowerCase()))
					otomatikOgrenciEklemeIslemi(line.substring(line.indexOf("Ogrencisi ") + 10), "YL", "");
				else if (line.toLowerCase().contains("Doktora Ogrencisi".toLowerCase()))
					otomatikOgrenciEklemeIslemi(line.substring(line.indexOf("Ogrencisi ") + 10), "Doktora", "");
				else if (line.toLowerCase().contains("Lisans Ogrencisi".toLowerCase()))
					otomatikOgrenciEklemeIslemi(line.substring(line.indexOf("Ogrencisi ") + 10), "Lisans", "");
			}
		}
		catch (IOException e) {
	   		System.out.println("Error\n");
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
		System.out.println(ogrenciListesi2.get(kullaniciSecimi-1) 
				+ " isimli ogrenci siliniyor.");
		ogrenciListesi2.remove(kullaniciSecimi-1);
		
	}
	
	private static List<Ogrenci> ogrenciListesi2 = 
			new ArrayList<>();
	
	private static void ogrenciEklemeIslemi() {
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();

		System.out.print("Ogrenci Tipi Giriniz (YL, Doktora , Lisans) : "); // 
		String ogrenciTipi = ekranOkuyucu.nextLine();
		
		System.out.print("Ogrenci Bolum Giriniz (MYO, Isletme vb..) : ");
		String bolum = ekranOkuyucu.nextLine();
		
		// ozkans otomatikOgrenciEklemeIslemi() ile ortak kod kullanimi olabilirdi
		Ogrenci yeniOgrenci = null;
		if (ogrenciTipi.equals("YL")) {
			yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum);
		} else if (ogrenciTipi.equals("Doktora")) {
			yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum);
		} else if (ogrenciTipi.equals("Lisans")) {
			yeniOgrenci = new LisansOgrencisi(adSoyad, bolum);
		} 

		if (yeniOgrenci != null) {
			ogrenciListesi2.add(yeniOgrenci);
			System.out.println(adSoyad + " isimli ogrenci eklendi.");
		} else {
			System.out.println("Gecersiz ogrenci bolumu");
		}
			
	}
	
	private static void otomatikOgrenciEklemeIslemi(String adSoyad, String ogrenciTipi, String bolum) {
		
		Ogrenci yeniOgrenci = null;
		if (ogrenciTipi.equals("YL")) {
			yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum);
		} else if (ogrenciTipi.equals("Doktora")) {
			yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum);
		} else if (ogrenciTipi.equals("Lisans")) {
			yeniOgrenci = new LisansOgrencisi(adSoyad, bolum);
		} 

		if (yeniOgrenci != null) {
			ogrenciListesi2.add(yeniOgrenci);
			System.out.println(adSoyad + " isimli ogrenci eklendi.");
		} else {
			System.out.println("Gecersiz ogrenci bolumu");
		}
			
	}

	private static void ogrenciListelemeIslemi() {
		ogrencileriEkranaBas(0);
	}
	
	private static void ogrencileriEkranaBas(int yontem) {
		
		if (ogrenciListesi2.isEmpty()) {
			System.out.println("<< Sistemde kayitli ogrenci yok >>");
			return;
		}
		
		if (yontem == 0) {
			int no = 1;
			for (Ogrenci ogrenci : ogrenciListesi2) {
				System.out.println(no + " -) " + ogrenci.ogrenciBilgileriAl());
				no++;
			}
		} else if (yontem == 1) {
			System.out.println(ogrenciListesi2);
		} else {
			for (int i = 0; i < ogrenciListesi2.size(); i++) {
				System.out.println(i + " -) " + ogrenciListesi2.get(i));
			}
		}
	}

	private static void ekranaMenuyuBas() {
		System.out.println("************************");
		System.out.println("MENU");
		System.out.println("(1)--> Ogrenci Ekle");
		System.out.println("(2)--> Ogrenci Sil");
		System.out.println("(3)--> Ogrencileri Listele");
		System.out.println("(0)--> Cikis");
		System.out.println("************************");
	}
	
}