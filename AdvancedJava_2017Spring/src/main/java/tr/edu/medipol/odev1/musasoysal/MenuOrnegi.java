package tr.edu.medipol.odev1.musasoysal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tr.edu.medipol.hafta3.MenuSecimi;

/** ozkans Degerlendirme

Gecersiz Halil Onan ile ayni

Menu: 5/5
Ogrenci Islemleri: 10/15 (Ogrenci ekleme bos kontrolu yok)
Polimorphism: 5/15 (Var ama kullanilmamis - String yaz oku mantigi var)
Dosyadan Okuma: 20/25 (Bos kontrolu yok, veri objesi okuma yok)
Dosyaya Yazma:  20/25 (Bos kontrolu yok, veri objesi yazimi yok)
Genel Program: 5/15 (arrList ve ogrenciListesi2 birbirine girmis)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20

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
				listeyiYaz();
				break;
			case OGRENCI_SILME: // (2) Ogrenci Sil
				ogrenciSilmeIslemi();
				break;
			case OGRENCI_LISTELE: // (3) Ogrencileri Listele
				ogrenciListelemeIslemi();
				break;
			case CIKIS: // (0) Cikis
				System.out.println("Program sonlaniyor.");
				listeyiYaz();
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
		listeyiOku();
		System.out.print("Seciminiz: ");
		Scanner scan = new Scanner(System.in);
		System.out.print("Seciminiz: ");
	    String secim = scan.nextLine();
	    
	    if (ogrenciListesi2.contains(secim))
	    	ogrenciListesi2.remove(secim);
	    else
	    	System.out.print("Sectiginiz isimli ogrenci kayitli degil, tekrar deneyiniz");
	    listeyiOku();
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
		
		   arrList.add(adSoyad+"  "+ogrenciTipi+"  "+bolum+"\n");
		
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
		
		listeyiOku();
		
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
		System.out.println("(1) Ogrenci Ekle");
		System.out.println("(2) Ogrenci Sil");
		System.out.println("(3) Ogrencileri Listele");
		System.out.println("(0) Cikis");
		System.out.println("************************");
	}

	public static void listeyiYaz(){
		try {
			FileWriter fos = new FileWriter("Ogrenciler");
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
	

	public static void listeyiOku(){
		File ogrencilerDosya = new File("Ogrenciler");
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