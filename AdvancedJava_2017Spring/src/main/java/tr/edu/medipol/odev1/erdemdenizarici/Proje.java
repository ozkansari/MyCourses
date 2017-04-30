package tr.edu.medipol.odev1.erdemdenizarici;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import tr.edu.medipol.odev1.erdemdenizarici.MenuSecimi;


/** ozkans Degerlendirme

- Polimorfism yok.
- Silme secimi hatali oldugunda kapaniyor.
- Dosya her yazdiginda onceki kayitlari siliyor (append yok)
- Tr karakter sorunlari

Menu: 5/5
Ogrenci Islemleri: 10/15
Polimorphism: 0/15
Dosyadan Okuma: 20/25
Dosyaya Yazma:  15/25
Genel Program: 10/15 (Hata kontrolu eksik, TR karakter sorunlari)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 5/20
------------------------------------------------------------
SONUC: 65/120
 */
public class Proje {
private static Scanner scanner = new Scanner(System.in);
static ArrayList<String> OgrenciListesi = new ArrayList<String>();
	public static void main(String[] args) {

		while(true) {
			ekranaMenuyuBas();
			
			System.out.print("Secim yapiniz: ");

			int secim = kullaniciIntegerGirdiAl();
			 MenuSecimi menuSecimi = MenuSecimi.enumaCevir(secim);
			 System.out.println(secim + " sectiniz.");

			if(secim == 1){
				ogrenciEklemeIslemi();
				save();
			
			}else if(secim == 2){
				ogrenciSilmeIslemi();
				
			}else if(secim == 3){
				read();
				
			}else if(secim == 0){
				System.out.println("Program sonlaniyor.");
				save();
		        System.exit(0);
				
			}else{
				System.out.println("Gecersiz secim");
				break;
			}
		}
		
	}
	public static void save(){
		try {
			FileWriter fw = new FileWriter("Ogrenci.txt");
			PrintWriter out = new PrintWriter(fw);
			
			for (int i = 0; i < OgrenciListesi.size();i++){
				out.write(String.valueOf(OgrenciListesi.get(i)));
			}
			out.close();
		}
		catch(Exception e){
			
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

	public static void read(){
		File ogrencilerDosya = new File("Ogrenci.txt");
		Scanner dosyaOkuyucu;
		try {
			dosyaOkuyucu = new Scanner(ogrencilerDosya);
			for(int i=0; dosyaOkuyucu.hasNextLine(); i++) {
				for(int j = 1; dosyaOkuyucu.hasNextLine(); j++){
				String mevcutSatir = dosyaOkuyucu.nextLine();
				System.out.println(j+"-)"+mevcutSatir);
			}
			}
			dosyaOkuyucu.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void ogrenciSilmeIslemi() {
		read();
		System.out.println("Silmek istediginiz ogrenciyi seciniz: ");
		System.out.print("Seciminiz: ");
		int secim = kullaniciIntegerGirdiAl();
		System.out.println(OgrenciListesi.get(secim-1) 
				+ " isimli ogrenci siliniyor.");
		OgrenciListesi.remove(secim-1);
		save();
	}

	private static void ogrenciEklemeIslemi() {
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = scanner.nextLine();
		
		System.out.print("Ogrenci Tip Giriniz (YL, Doktora vb.) : "); // 
		String ogrenciTipi = scanner.nextLine();
		
		System.out.print("Ogrenci Bolum Giriniz (MYO, Isletme vb..) : ");
		String bolum = scanner.nextLine();
		
	    OgrenciListesi.add(adSoyad+" "+ogrenciTipi+" "+bolum+"\n");
		
	}
	
	private static Integer kullaniciIntegerGirdiAl() {
		String secim = "";
		int girdi = -1;
		try {
			secim = scanner.nextLine();
			girdi = Integer.valueOf( secim );
		} catch(Exception e) {
			System.out.println("Gecerli bir deger giriniz. Girdiginiz deger: " 
					+ secim);
		}
		return girdi;
	}	
}
