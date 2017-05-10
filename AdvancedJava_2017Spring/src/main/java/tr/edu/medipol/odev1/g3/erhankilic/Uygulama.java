package tr.edu.medipol.odev1.g3.erhankilic;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

/** ozkans Degerlendirme

Recep Efe Mayoglu ile cok benzer.
Erhan aciklama yapmadi.

Menu: 5/5
Ogrenci Islemleri: 13/15 (Ogrenci olmadiginda uyari verebilir)
Polimorphism: 15/15
Dosyadan Okuma: 20/25
Dosyaya Yazma:  15/25 (Yazma mantigi karisik)
Genel Program: 5/15 (Tr karakter sorunlari, Her seferinde dosyadan okuma mantikli degil, TODOlar silinmeli)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 2/20
Benzer Kod Yazma Nedeniyle: -15
-----------------------------------
Sonuc: 65

 */
public class Uygulama {
	public static void main(String[] args) {

		 Scanner ekranOkuyucu = new Scanner(System.in);

		// TODO Auto-generated method stub
		while(true) {
			ekranaMenuyuBas();			
			System.out.println("Secim yapiniz: ");
			int kullaniciSecimi =ekranOkuyucu.nextInt();
			System.out.println(kullaniciSecimi + " sectiniz.");
			switch (kullaniciSecimi) {
			case 1: 
				ogrenciEklemeIslemi();
				break;
			case 2: 
				ogrenciSilmeIslemi();
				break;
			case 3: 
				ogrenciListelemeIslemi();
				break;
			case 0: 
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

	
	private static void ogrenciListelemeIslemi() {
		// TODO Auto-generated method stub
		dosyaOkumaIslemi();
	}
	private static void ogrenciSilmeIslemi() {
		// TODO Auto-generated method stub
		dosyaOkumaIslemi();
		List<String> dosyaIcerigi = dosyaIcerik();
		Scanner ekranOkuyucu = new Scanner(System.in);
		System.out.println("Silmek istedi�iniz ��renci TC:");
		String tc = ekranOkuyucu.next();
		List<String> dosyaIcerigi2 = new ArrayList<String>();
		for (String string : dosyaIcerigi) {
			if(string.indexOf(tc) == -1)
				dosyaIcerigi2.add(string);
		}
		System.out.println("��renci silindi.");
		
		dosyaYazmaIslemi(dosyaIcerigi2, false);
	}

	private static List<String> dosyaIcerik(){
		try {
			File file = new File("OgrenciDosyasi.txt");
			if (!file.exists()) {
				file.createNewFile();
		    }

			List<String> dosyaIcerigi = new ArrayList<>();
			
			FileReader fileReader = new FileReader(file);
			String line;
			
			BufferedReader br = new BufferedReader(fileReader);
			
			while ((line = br.readLine()) != null) {
				dosyaIcerigi.add(line);
			}
			
			br.close();
			return dosyaIcerigi;
	
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}
	
	private static void dosyaOkumaIslemi(){
		try {
			File file = new File("OgrenciDosyasi.txt");
			if (!file.exists()) {
				file.createNewFile();
		    }

			FileReader fileReader = new FileReader(file);
			String line;
			
			BufferedReader br = new BufferedReader(fileReader);
			
			while ((line = br.readLine()) != null) {
			
			    System.out.println(line);
			
			}
			
			br.close();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static void ogrenciEklemeIslemi() {
		// TODO Auto-generated method stub	

		 Scanner ekranOkuyucu = new Scanner(System.in);

		System.out.print("Isim ve Soyisim:");
		String isimsoyisim = ekranOkuyucu.nextLine();

		
		System.out.print("Lisans - YuksekLisans - Doktora:");
		String lisans = ekranOkuyucu.nextLine();
		
		System.out.println("Tc:");
		String tc = ekranOkuyucu.next();
		
		Ogrenci ogrenci = null;
		if(lisans.equalsIgnoreCase("Lisans")){
			ogrenci = new Lisans(isimsoyisim, tc,lisans);
		}else if(lisans.equalsIgnoreCase("YuksekLisans")){
			ogrenci = new YuksekLisans(isimsoyisim, tc,lisans);
		}else if(lisans.equalsIgnoreCase("Doktora")){
			ogrenci = new Doktora(isimsoyisim, tc,lisans);
		}		
		dosyaYazmaIslemi(ogrenci,true);
	}
	private static void dosyaYazmaIslemi(Ogrenci ogrenci,boolean uzerineMi){
		try{
			File dosya = new File("OgrenciDosyasi.txt");
            FileWriter yazici = new FileWriter(dosya,uzerineMi);
            BufferedWriter yaz = new BufferedWriter(yazici);
            String ogenciBilgisi = "AdSoyad:"+ogrenci.adSoyad+" "+" TC:"+ogrenci.tc+" "+" B�l�m:"+ogrenci.bolum+"\n";
            yaz.write(ogenciBilgisi);
            yaz.close();
            System.out.println("Ekleme ��lemi Ba�ar�l�");
        }
        catch (Exception hata){
              hata.printStackTrace();
        }
	}
	private static void dosyaYazmaIslemi(List<String> ogrenci,boolean uzerineMi){
		try{
			File dosya = new File("OgrenciDosyasi.txt");
            FileWriter yazici = new FileWriter(dosya,uzerineMi);
            BufferedWriter yaz = new BufferedWriter(yazici);
            String ogrenciBilgisi="";
            for (String string : ogrenci) {
            	ogrenciBilgisi+=string+"\n";
			}
            yaz.write(ogrenciBilgisi);
            yaz.close();
            //System.out.println("Ekleme ��lemi Ba�ar�l�");
        }
        catch (Exception hata){
              hata.printStackTrace();
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