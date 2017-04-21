package tr.edu.medipol.odev1.firatkoc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

Gecersiz Gurkan Ertas'a cok benziyor
Aciklama yapmadi.

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 10/15 (Polimorfism var ama kullanilmamis, liste kullanilmis. Dosyaya yazarken de liste olarak yazilip okunmus.)
Dosyadan Okuma: 20/25
Dosyaya Yazma:  20/25
Genel Program: 5/15
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20
Benzer Kod Yazma Nedeniyle: -35
-----------------------------------
Sonuc: 40
 */
public class MenuOrnegi {

	private static Scanner ekranOkuyucu = new Scanner(System.in);
	
	public static void main(String[] args) {
		
	

		
		
		while(true) {
			ekranaMenuyuBas();
			
			System.out.println("Secim yapiniz: ");
			int kullaniciSecimi = kullaniciIntegerGirdiAl();
		
			System.out.println(kullaniciSecimi + " sectiniz.");

			switch (kullaniciSecimi) {
			case 1: // (1) Ogrenci Ekle
				ogrenciEklemeIslemi();
				break;
			case 2: // (2) Ogrenci Sil
				ogrenciSilmeIslemi();
				break;
			case 3: // (3) Ogrencileri Listele
				oku(true);
				//ogrenciListelemeIslemi();
				break;
			case 0: // (0) Cikis
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
		System.out.println("Silmek istediginiz ogrenci numarasini seciniz: ");
		ogrencileriEkranaBas();
		System.out.print("Numara seciminiz: ");
		int kullaniciSecimi = kullaniciIntegerGirdiAl();
				
		List<String> liste = new ArrayList<>();
		List<Ogrenci> ogrenciListesi = new ArrayList<>();
		for (Ogrenci ogr : ogrenciListesi2) {
			if(ogr.numara == kullaniciSecimi)
			{
				
			}
			else{
				ogrenciListesi.add(ogr);
				liste.add(ogr.adSoyad+" "+" Numara:"+ogr.numara+" "+ogr.bolum+" "+ogr.ogrenciTipiniAl()+"\n");
			}
		}
		ogrenciListesi2 = ogrenciListesi;
		yaz(liste);
		
	}
	
	private static void yaz(List<String> liste){	
		try{
			   File file = new File("dosya.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }

		        FileWriter fileWriter = new FileWriter(file, false);
		        BufferedWriter bWriter = new BufferedWriter(fileWriter);
		        String fullStr = "";
		        
		        for (String str : liste) {
		        	fullStr += str;
				}
		        bWriter.write(fullStr);
		        bWriter.close(); 
		 }
		 catch(Exception ex){
			 System.out.println("Hata yakaladi." + ex.toString());
		 }    
	}
	private static List<String> oku(boolean yontem){
		try {
			List<String> ogr_listesi = new ArrayList<>();
			  File file = new File("dosya.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }
			FileReader fileReader = new FileReader(file);
			String line;

			BufferedReader br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null) {
				ogr_listesi.add(line+"\n");
				if(yontem)
					System.out.println(line);
			}
			br.close();
			return ogr_listesi;
		} catch (Exception e) {
		
			System.out.println("Hata yakadi.");
			// TODO: handle exception
			return null;
		}
		
	}
	

	private static List<Ogrenci> ogrenciListesi2 = 
			new ArrayList<>();
	
	private static void ogrenciEklemeIslemi() {
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();

		System.out.print("Ogrenci Tip Giriniz (YL, Doktora vb.) : "); // 
		String ogrenciTipi = ekranOkuyucu.nextLine();
		
		System.out.print("Ogrenci Bolum Giriniz (MYO, Isletme vb..) : ");
		String bolum = ekranOkuyucu.nextLine();
		
		System.out.print("Numarasi : ");
		int numara = kullaniciIntegerGirdiAl();
		
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
	
	private static void okuVeYaz(Ogrenci ogrenci){
		List<String> a  = new ArrayList<>();
		a.add(ogrenci.adSoyad+" "+" Numara:"+ogrenci.numara+" "+ogrenci.bolum+" "+ogrenci.ogrenciTipiniAl());

		List<String> b = oku(false);
		
		List<String> c = new ArrayList<>();
		
		String fullStr = "";
		for (String string : b) {
			c.add(string);
		}
		for (String string : a) {
			c.add(string);
		}
		
		yaz(c);
	}


	
	private static void ogrencileriEkranaBas() {
		oku(true);
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
