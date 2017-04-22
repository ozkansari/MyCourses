package tr.edu.medipol.odev1.g7.gurkanertas;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

/** ozkans Degerlendirme

Gecersiz Firat Koc'a cok benziyor
Aciklama yapmadi.
Firat Koc once gonderdi.

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 10/15 (Polimorfism var ama kullanilmamis, liste kullanilmis. Dosyaya yazarken de liste olarak yazilip okunmus.)
Dosyadan Okuma: 20/25
Dosyaya Yazma:  20/25
Genel Program: 5/15
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20
Benzer Kod Yazma Nedeniyle: -40
-----------------------------------
Sonuc: 35
*/
public class MenuOrnegi {

	public static Scanner ekranOkuyucu = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			ekranaMenuyuBas();
			
			System.out.println("Secim yapiniz: ");
			int kullaniciSecimi = kullaniciIntegerGirdiAl();
		
			System.out.println(kullaniciSecimi + " sectiniz.");

			switch (kullaniciSecimi) {
			case 1: 
				ogrenciEklemeIslemi();
				break;
			case 2: 
				ogrenciSilmeIslemi();
				break;
			case 3: 
				ogrencileriEkranaBas();
				break;
			case 4: 
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
	public static Integer kullaniciIntegerGirdiAl() {
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
	
	public static void ogrenciSilmeIslemi() {
		ogrencileriEkranaBas();
		System.out.print("Numara :");
		int kullaniciSecimi = kullaniciIntegerGirdiAl();
				
		List<String> stringOgrenciliste = new ArrayList<>();
		
		List<Ogrenci> ogrenciYeniListe = new ArrayList<>();
		
		for (Ogrenci ogrenci : ogrenciListesi2) {
			if(ogrenci.numara != kullaniciSecimi)
			{
				ogrenciYeniListe.add(ogrenci);
				stringOgrenciliste.add(ogrenci.adSoyad+"   "+"  Bolum:"+ogrenci.bolum+"   "+ogrenci.ogrenciTipiniAl()+" Numara:"+ogrenci.numara+" "+"\n");
			}
		}
		ogrenciListesi2 = null;
		ogrenciListesi2 = ogrenciYeniListe;
		dosya_yaz(stringOgrenciliste);	
	}
	
	public static void dosya_yaz(List<String> stringOgrenciListesi){	
		try{
			   File file = new File("ogrenci.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }
		        FileWriter fileWriter = new FileWriter(file, false);
		        BufferedWriter bWriter = new BufferedWriter(fileWriter);	
		        StringBuilder b = new StringBuilder();
		        stringOgrenciListesi.forEach(b::append);        
		        bWriter.write(b.toString());
		        bWriter.close(); 
		 }
		 catch(Exception ex){
				System.out.println("Hata olustu l�tfen daha sonra tekrar deneyiniz.");
		 }    
	}
	public static List<String> oku_geriye_liste_don(){
		try {
			List<String> stringOgrenciListesi = new ArrayList<>();
			  File file = new File("ogrenci.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }
			FileReader fileReader = new FileReader(file);
			String line;

			BufferedReader br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null) {
				String l_line = line + "\n";
				stringOgrenciListesi.add(l_line);
			}
			br.close();
			return stringOgrenciListesi;
		} catch (Exception e) {
			System.out.println("Hata olustu l�tfen daha sonra tekrar deneyiniz.");
			return (new ArrayList<String>());
		}
		
		
	}
	public static void okuVeYaz(Ogrenci ogrenci){		
		String gelenOgrenciString = ogrenci.adSoyad+"   "+"  Bolum:"+ogrenci.bolum+"   "+ogrenci.ogrenciTipiniAl()+" Numara:"+ogrenci.numara+" ";

		List<String> eski_liste = oku_geriye_liste_don();
		
		List<String> yeni_liste = eski_liste;
		
		yeni_liste.add(gelenOgrenciString);
		dosya_yaz(yeni_liste);
	}
	
	public static void dosya_oku(){
		try {
			  File file = new File("ogrenci.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }
			FileReader fileReader = new FileReader(file);
			String line;
			BufferedReader br = new BufferedReader(fileReader);
			while ((line = br.readLine()) != null) {
				String l_line = line + "\n";
				System.out.println(l_line);
			}
			br.close();
		} catch (Exception e) {	
			System.out.println("Hata olustu l�tfen daha sonra tekrar deneyiniz.");
		}
	}
	

	public static List<Ogrenci> ogrenciListesi2 = 
			new ArrayList<>();
	
	public static void ogrenciEklemeIslemi() {
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();
		
		System.out.print("Numarasi : ");
		int numara = kullaniciIntegerGirdiAl();

		System.out.print("Ogrenci Tip Giriniz (YL, Doktora vb.) : "); // 
		String ogrenciTipi = ekranOkuyucu.nextLine();
		
		System.out.print("Ogrenci Bolum Giriniz (MYO, Isletme vb..) : ");
		String bolum = ekranOkuyucu.nextLine();
		
		
		
		Ogrenci yeniOgrenci = null;
		if (ogrenciTipi.equals("YL")) {
			yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum,numara);
		} else if (ogrenciTipi.equals("Doktora")) {
			yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum,numara);
		} 

		if (yeniOgrenci != null) {
			ogrenciListesi2.add(yeniOgrenci);
			System.out.println(adSoyad + " isimli ogrenci eklendi.");
			okuVeYaz(yeniOgrenci);
			
			
		} else {
			System.out.println("Gecersiz ogrenci bolumu");
		}
			
	}
	

	public static void ogrencileriEkranaBas() {
		dosya_oku();
	}

	public static void ekranaMenuyuBas() {
		System.out.println("************************");
		System.out.println("MENU");
		System.out.println("(1) Ogrenci Ekle");
		System.out.println("(2) Ogrenci Sil");
		System.out.println("(3) Ogrencileri Listele");
		System.out.println("(4) Cikis");
		System.out.println("************************");
	}
	
}
