package tr.edu.medipol.odev1.fundakavak;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

Gec gonderim.
Derste yaptigim ornek aynen gonderilmis.

Menu: 5/5
Ogrenci Islemleri: 5/15
Polimorphism: 5/15
Dosyadan Okuma: 0/25
Dosyaya Yazma:  0/25
Genel Program: 0/15
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20

 */
public class OgrenciMenu {


	private static Scanner ekranOkuyucu = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			ekranaMenuyuBas();
			
			System.out.println("Se�im yap�n�z: ");
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
			case CIKIS: // 
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
		
		System.out.println("��RENC� Y�NET�M PROGRAMI");
		System.out.println("(1) ��renci Ekle");
		System.out.println("(2) ��renci Sil");
		System.out.println("(3) ��rencileri Listele");
		System.out.println("(0) ��k��");
	
	}

}
