package tr.edu.medipol.odev1.kerimbiber;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 0/15
Dosyadan Okuma: 20/25 (Dosya yokken de calisabilmeli)
Dosyaya Yazma:  25/25
Genel Program: 10/15
Derste Yapýlan Ornegi farklilastirma/Eklentiler: Bonus 0/20

 */
public class Menu {

	private static Scanner ekranOkuyucu = new Scanner(System.in);
	private static ArrayList<Ogrenci> ogrenciListesi = new ArrayList<Ogrenci>();
	private static Path path = Paths.get("./dosya.txt");
	
	public static void main(String[] args) throws Exception{
		
		try{
			// ozkans duzeltme try icine alindi
			FileInputStream inputStream = new FileInputStream(path.getFileName().toString());
			ObjectInputStream oInputStream = new ObjectInputStream(inputStream);
			ogrenciListesi = (ArrayList<Ogrenci>) oInputStream.readObject();
		}catch(Exception e)
		{
			
		}
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
	
	private static void ogrenciSilmeIslemi() throws Exception{
		System.out.println("Silmek istediginiz ogrenciyi seciniz: ");
		ogrencileriEkranaBas(0);
		System.out.print("Seciminiz: ");
		int kullaniciSecimi = kullaniciIntegerGirdiAl();
		System.out.println(ogrenciListesi.get(kullaniciSecimi-1).AdSoyad 
				+ " isimli ogrenci siliniyor.");
		ogrenciListesi.remove(kullaniciSecimi-1);
		DosyaKaydet();
	}
	
	private static void ogrenciEklemeIslemi() throws Exception{
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();		
		String bolum = "";
		System.out.println("Ogrenci Bolum Giriniz: ");
		ekranaBolumleriBas();
		int bolumId = kullaniciIntegerGirdiAl();
		switch (bolumId) {
		case 1:
			bolum = "Lisans"; break;
		case 2:
			bolum = "Yuksek Lisans"; break;
		case 3:
			bolum = "Doktora"; break;
		default: 
			bolum = "Bolum Secilmedi";
			break;
		}
		
		
		
		Ogrenci yeniOgrenci = new Ogrenci();
		yeniOgrenci.AdSoyad = adSoyad;
		yeniOgrenci.Bolum = bolum;
		ogrenciListesi.add(yeniOgrenci);
		DosyaKaydet();
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
			for (Ogrenci ogrenci : ogrenciListesi) {
				System.out.println(no + " -) " + ogrenci.AdSoyad + " " +  ogrenci.Bolum);
				no++;
			}
		} else if (yontem == 1) {
			System.out.println(ogrenciListesi);
		} else {
			for (int i = 0; i < ogrenciListesi.size(); i++) {
				System.out.println(i + " -) " + ogrenciListesi.get(i).AdSoyad);
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
	
	private static void ekranaBolumleriBas() {
		System.out.println("**********");
		System.out.println("(1) Lisans");
		System.out.println("(2) Yuksek Lisans");
		System.out.println("(3) Doktora");
		System.out.println("**********");
	}
	
	private static void DosyaKaydet() throws Exception
	{
		FileOutputStream fileOut = new FileOutputStream(path.getFileName().toString());
		ObjectOutputStream outSerialize = new ObjectOutputStream(fileOut);
		outSerialize.writeObject(ogrenciListesi);
		outSerialize.flush();
		outSerialize.close();
		fileOut.close();
	}
}