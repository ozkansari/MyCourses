package tr.edu.medipol.odev1.recepefemayoglu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

Erhan Kilic ile cok benzer

Menu: 5/5
Ogrenci Islemleri: 13/15 (Ogrenci olmadiginda uyari verebilir)
Polimorphism: 15/15
Dosyadan Okuma: 20/25 (Dosya olmadiginda ilk calistirildiginda exception veriyor.)
Dosyaya Yazma:  15/25 (Yazma mantigi karisik)
Genel Program: 5/15 (Tr karakter sorunlari, Her seferinde dosyadan okuma mantikli degil, TODOlar silinmeli)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 2/20 (Cikis yapilmasa da dosyaya yazmasi avantaj)

 */
public class Uygulama {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {	
		menuGoster();
		dosyaOkuma();	
	}
	public static void menuGoster(){
		while(true){
			System.out.println("1) ��renci Ekleme");
			System.out.println("2) ��renci Silme");
			System.out.println("3) ��renci Listele");
			System.out.println("4) �IKI�");
			
			System.out.print("Se�iniz :");
			int secim = scan.nextInt();
			
			switch (secim) {
			case 1:
				ogrenciEkle();
				break;
			case 2:	
				ogrenciSil();
				break;
			case 3:
				ogrenciListele();
				break;
			case 4:
				System.out.println("��k�� yap�l�yor...");
				System.exit(0);
				break;
			default:
				System.out.println("Hatal� se�im yapt�n�z. L�tfen Tekrar deneyiniz");
				break;
			}
			
		}		
	}
	private static void ogrenciListele() {
		// TODO Auto-generated method stub
		dosyaOkuma();
	}
	private static void ogrenciSil() {
		// TODO Auto-generated method stub
		List<String> icerik =  dosyaIcerigi();
		for (String i : icerik) {
			System.out.println(i);
		}
		System.out.print("Silmek istedi�iniz ��renci Id\'si :");
		int secim = scan.nextInt();
		List<String> yeniListe = new ArrayList<String>();
		for (String i : icerik) {
			if(i.indexOf("Id:"+secim) == -1 ){
				yeniListe.add(i);
			}
			else{
			}
		}
		dosyaYazma(yeniListe);
		
		if(yeniListe.size() != icerik.size())	
			System.out.println("��renci silindi.");
		else
			System.out.println("��renci silinemedi.");

	}
	
	private static void ogrenciEkle() {
		// TODO Auto-generated method stub
		System.out.print("��renci Ad�:");
		String ad = scan.next();
		System.out.print("��renci Soyad�:");
		String soyad = scan.next();
		while(true){
			System.out.print("Lisans Derecesisi Se�imleri:\n"
					+ "1 - Lisans\n"
					+ "2 - Y�ksek Lisans\n"
					+ "3 - Doktora )\n");
			System.out.print("Se�im:");
			int secim = scan.nextInt();
			if(secim ==1 || secim ==2 || secim ==3 ){
				Ogrenci ogrenci = null;
				if (secim == 1) {
					ogrenci = new Lisans(ad, soyad);										
				}else if(secim == 2){
					ogrenci = new YuksekLisans(ad, soyad);
				}
				else if(secim == 3){
					ogrenci = new Doktora(ad, soyad);
				}
				dosyaYazma(ogrenci);	
				System.out.println("��renci eklendi.");
				break;
			}
			else{
				System.out.println("Hatal� se�im yapt�n�z. L�tfen Tekrar giriniz.");
			}
		}
	}
	
	public static void dosyaYazma(List<String> ogrListe){
		try {
			String eski_icerik = "";	
			File f = new File("ogrenciDosyasi.txt");
			FileWriter fw=new FileWriter(f);
			int u = 1;
			for(String i: ogrListe){
				String idsi = i.substring(0, i.indexOf(" "));
				i = i.replace(idsi, "Id:"+u);
				eski_icerik+=i+"\n";		
				u++;
			}		
			fw.write(eski_icerik); 
			fw.close();	
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("hata");
		}
	}
	
	public static void dosyaYazma(Ogrenci ogr){
		try {
			String eski_icerik = "";
			List<String> eskiIcerik = dosyaIcerigi();	
			File f=new File("ogrenciDosyasi.txt");
			FileWriter fw=new FileWriter(f);
			int count = eskiIcerik.size();
			int u = 1;
			for(String i: eskiIcerik){
				eski_icerik += i+"\n";	
			}
			String icerik = eski_icerik +"Id:"+( (count+1) ) +"   Ad� ve Soyad�:" + ogr.ad+" "+ogr.soyad +"   Derecesi:"+ogr.ogrenciTipi();
			fw.write(icerik); 
			fw.close();
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("hata");
		}
	}
	public static void dosyaOkuma(){
		File ogrencilerDosya = new File("ogrenciDosyasi.txt");
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
	public static List<String> dosyaIcerigi(){
		List<String> dosyaIcerigi = new ArrayList<String>();
		File ogrencilerDosya = new File("ogrenciDosyasi.txt");
		Scanner dosyaOkuyucu;
		try {
			dosyaOkuyucu = new Scanner(ogrencilerDosya);
			for(int i=0; dosyaOkuyucu.hasNextLine(); i++) {
				String mevcutSatir = dosyaOkuyucu.nextLine();
				if(mevcutSatir.length()>0)
					dosyaIcerigi.add(mevcutSatir);
			}
			dosyaOkuyucu.close();
			return dosyaIcerigi;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}