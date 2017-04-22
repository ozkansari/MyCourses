package tr.edu.medipol.odev1.havvagamzeakbas;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.util.List;

/** ozkans Degerlendirme

Menu: 5/5
Ogrenci Islemleri: 10/15 (Ogrenci ekleme bos kontrolu yok)
Polimorphism: 0/15
Dosyadan Okuma: 20/25 (Bos kontrolu yok, veri objesi okuma yok)
Dosyaya Yazma:  20/25 (Bos kontrolu yok, veri objesi yazimi yok)
Genel Program: 14/15 (Tr karakter sorunlari)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 15/20

 */
public class Menu {
	
	private static Scanner kGirdi = new Scanner(System.in);
	private static Scanner scan;
	public static ArrayList<String> ogrenciListesi = new ArrayList<String>();

	public static void main(String[] args) {

		while(true){
			menuyuGoruntule();
			System.out.println("Seciminizi Yapiniz: ");
			int secim = kGirdi.nextInt();
			
			switch (secim) {
			case 1:
				ogrenciEkle();
				break;
				
			case 2:
				ogrenciSilme();
				break;
				
			case 3:
				listeOku();
				break;
				
			case 4:
				System.out.println("Program sonlaniyor.");
				kGirdi.close();
				System.exit(0);
				break;	

			default:
				System.out.println("Gecersiz islem");
				break;
			}
		}
	}
	private static void menuyuGoruntule(){
		System.out.println("**************");
		System.out.println("*****Menu*****");
		System.out.println("1-Ogrenci Ekleme");
		System.out.println("2-Ogrenci Sil");
		System.out.println("3-Ogrencileri Listele");
		System.out.println("4-Cikis");
	}
	
	private static void ogrenciEkle(){
		scan = new Scanner(System.in);
		System.out.print("Ogrenci Adini ve soy adini Giriniz: ");
		String ogrenciAd = scan.nextLine();
		
		System.out.print("Ogrenci Bolumunu Giriniz MYO/YS");
		String bolum = scan.nextLine();
		
		System.out.println(ogrenciAd + " isimli ogrenci eklendi.");
	
		ogrenciListesi.add(ogrenciAd +" "+bolum);
		listeOku(ogrenciAd);
	}

	private static void ogrenciSilme() {
		System.out.println("Silmek istediginiz ogrenin ad�n� ve tipini listedei gibi yaziniz ");
		listeOku();
		Scanner scan = new Scanner(System.in);
		System.out.print("Seciminiz: ");
	    String secim = scan.nextLine();
	    
	    if (ogrenciListesi.contains(secim))
	    	ogrenciListesi.remove(secim);
	    else
	    	System.out.print("Sectiginiz isimli ogrenci kayitli degil, tekrar deneyiniz");
	    listeOku("");
	}
	   
	// ozkans listeYaz demek istedin sanirim?
	public static void listeOku(String metin){
		
		try {
			File f = new File("dosya.txt");
			FileWriter fw=new FileWriter(f,false);
			String genel="";
			for(String str: ogrenciListesi) {
				  genel+= str + "\n";
			}
			fw.write(genel);
			fw.close();
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("HATA OLUSTU!");
		}
	}
		
	public static void listeOku(){
		File ogrencilerDosya = new File("dosya.txt");
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


