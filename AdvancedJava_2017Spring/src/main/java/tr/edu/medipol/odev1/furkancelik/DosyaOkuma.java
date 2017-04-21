package tr.edu.medipol.odev1.furkancelik;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

Gecersiz Fatih Furkan Mete, Samet Zengin ile ayni
Samet Zengin kodu Furkanin yazdigini ifade etti.
Furkan Celik aciklamada bulunmadi.

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 15/15
Dosyadan Okuma: 10/25 (Listeye okumuyor sadece ekrana basiyor)
Dosyaya Yazma:  10/25 (Ekleme var silme yok)
Genel Program: 10/15
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20
Benzer Kod Yazma Nedeniyle: -35
-----------------------------------
Sonuc: 30
*/

public class DosyaOkuma {
private static Scanner ekranOkuyucu = new Scanner(System.in);
static File dosya=new File(".\\config\\ogrenciler.txt");
static String cumle;
static FileWriter fw;
static BufferedReader oku;




	
	public static void main(String[] args) throws IOException {
		

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
	
	private static void ogrenciSilmeIslemi() throws IOException {
		System.out.println("Silmek istediginiz ogrenciyi seciniz: ");
		ogrencileriEkranaBas(0);
		System.out.print("Seciminiz: ");
		int kullaniciSecimi = kullaniciIntegerGirdiAl();
		System.out.println(ogrenciListesi2.get(kullaniciSecimi-1) + " isim1li ogrenci siliniyor.");	 
		ogrenciListesi2.remove(kullaniciSecimi-1);
		
	}
	
	

	
	private static List<Ogrenci> ogrenciListesi2 = new ArrayList<>();

	
	private static void ogrenciEklemeIslemi() throws IOException {
		fw=new FileWriter(dosya,true);
		
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();

		System.out.print("Ogrenci Tip Giriniz (YL, Doktora vb.) : "); // 
		String ogrenciTipi = ekranOkuyucu.nextLine();
		
		System.out.print("Ogrenci Bolum Giriniz (MYO, Isletme vb..) : ");
		String bolum = ekranOkuyucu.nextLine();
		
		Ogrenci yeniOgrenci = null;
		if (ogrenciTipi.equals("YL")) {
			yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum);
		} else if (ogrenciTipi.equals("Doktora")) {
			yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum);
		} 

		 
		if (yeniOgrenci != null) {
			fw.write(adSoyad+" "+bolum+"\n");
		
			System.out.println(yeniOgrenci.adSoyad + " isimli ogrenci eklendi.");
		} else {
			System.out.println("Gecersiz ogrenci bolumu");
		}
		fw.close();
		
			
	}

	private static void ogrenciListelemeIslemi() throws IOException {
		ogrencileriEkranaBas(0);
	}
	
	private static void ogrencileriEkranaBas(int yontem) throws IOException {
		
		oku = new BufferedReader(new FileReader(dosya));
		cumle =  oku.readLine();
		
		
		if (yontem == 0) {
			
			 while (cumle!=null) {
	                System.out.println(cumle);
	                cumle = oku.readLine();
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
