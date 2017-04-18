package tr.edu.medipol.odev1.ertankaraaslan;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

Gecersiz Musa Soysal ve Halil Onan ile ayni
*/

public class MenuOrnegi {

	private static Scanner ekranOkuyucu = new Scanner(System.in);
	
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
				yaz();
				break;
			case OGRENCI_SILME: // (2) Ogrenci Sil
				ogrenciSilmeIslemi();
				break;
			case OGRENCI_LISTELE: // (3) Ogrencileri Listele
				ogrenciListelemeIslemi();
				break;
			case CIKIS: // (0) Cikis
				System.out.println("Program sonlaniyor.");
				yaz();
				ekranOkuyucu.close();
		        System.exit(0);
				break;
			default:
				System.out.println("Gecersiz secim");
				break;
			}
		}
		
	}

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
		System.out.println(arrList.get(kullaniciSecimi-1) 
				+ " isimli ogrenci siliniyor.");
		arrList.remove(kullaniciSecimi-1);
		yaz();
	}
	static ArrayList<String> arrList = new ArrayList<String>();
	private static List<Ogrenci> ogrenciListesi2 = 
			new ArrayList<>();
	
	private static void ogrenciEklemeIslemi() {
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();

		System.out.print("Ogrenci Tip Giriniz (YL, Doktora vb.) : "); // 
		String ogrenciTipi = ekranOkuyucu.nextLine();
		
		System.out.print("Ogrenci Bolum Giriniz (MYO, Isletme vb..) : ");
		String bolum = ekranOkuyucu.nextLine();
		
	    arrList.add(adSoyad+" "+ogrenciTipi+" "+bolum+"\n");
		
		Ogrenci yeniOgrenci = null;
		if (ogrenciTipi.equals("YL")) {
			yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum);
		} else if (ogrenciTipi.equals("Doktora")) {
			yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum);
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
			
		oku();
		
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
		System.out.println("**********");
		System.out.println("MENU");
		System.out.println("(1) Ogrenci Ekle");
		System.out.println("(2) Ogrenci Sil");
		System.out.println("(3) Ogrencileri Listele");
		System.out.println("(0) Cikis");
		System.out.println("**********");
	}

	
	public static void yaz(){
		try {
			FileWriter fos = new FileWriter("Ogrenci.txt");
			PrintWriter out = new PrintWriter(fos);
			
			for (int i = 0; i < arrList.size();i++){
				out.write(String.valueOf(arrList.get(i)));
				out.write("\n");
			}
			out.close();
		}
		catch(Exception e){
			
		}
	}
	
	public static void oku(){
		File ogrencilerDosya = new File("Ogrenci.txt");
		Scanner dosyaOkuyucu;
		try {
			dosyaOkuyucu = new Scanner(ogrencilerDosya);
			for(int i=0; dosyaOkuyucu.hasNextLine(); i++) {
				String mevcutSatir = dosyaOkuyucu.nextLine();
				System.out.println(mevcutSatir);
			}
			dosyaOkuyucu.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}