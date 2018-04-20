package tr.edu.medipol.vizeproje.ismail_sahin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class KutuphaneController {
	public static ArrayList<Kitap> kitaplarList;
	public static ArrayList<YayinEvi> yayinEviList = new ArrayList<>();
	
	public KutuphaneController() {
		kitaplarList = dosyadanOkuKitaplar();
		yayinEviList = dosyadanOkuYayinEvi();
	}
	
	public static boolean ePostaKontrol(String ePosta) {
		String mailSablonu = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		
		Pattern sablonNesnesi = Pattern.compile(mailSablonu, Pattern.CASE_INSENSITIVE);
		String mailAdresi = ePosta;

		Matcher eslestirici = sablonNesnesi.matcher(mailAdresi);
		boolean eslestiMi = eslestirici.find();
		
		return eslestiMi;
	}
	
	public static void dosyayaYaz() {
		File kitapCiktiDosyasi = new File(".\\config\\KitaplarList.txt");
		File yayinEviCiktiDosyasi = new File(".\\config\\YayinEviList.txt");
		
		PrintWriter dosyaYazici = null;
		PrintWriter dosyaYazici2 = null;
		try {
			dosyaYazici = new PrintWriter(kitapCiktiDosyasi);
			for (Kitap ktp : kitaplarList) {
				dosyaYazici.println(ktp.getKitapAdi() + "," + ktp.getKitapYazari() +  "," + ktp.getKitapTuru()+","
						+ ktp.getKitapSayfaSayisi() + "," + ktp.getKitapYayinEvi().getYayinEviAdi());
			}
			
			dosyaYazici2 = new PrintWriter(yayinEviCiktiDosyasi);
			for (YayinEvi yayinEvi : yayinEviList) {
				dosyaYazici2.println(yayinEvi.getYayinEviAdi() + "," + yayinEvi.getYayinEviEPosta());
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if (dosyaYazici != null && dosyaYazici2 != null) {
				dosyaYazici.close();
				dosyaYazici2.close();
			}
		}
	}
	
	public static ArrayList<Kitap> dosyadanOkuKitaplar() {
		ArrayList<Kitap> kitapList = new ArrayList<>();
		
		File kitaplarDosya = new File(".\\config\\KitaplarList.txt");
		Scanner dosyaOkuyucu = null;
		
		try {
			dosyaOkuyucu = new Scanner(kitaplarDosya);
			while (dosyaOkuyucu.hasNext()) {
				String satir = dosyaOkuyucu.nextLine();
				String dizi[] = satir.split(",");
				
				YayinEvi yayinEvi = new YayinEvi(dizi[dizi.length-1]);
				
				kitapList.add(new Kitap(dizi[0], dizi[1], dizi[2], Integer.parseInt(dizi[3]), yayinEvi));
			}
		} catch (FileNotFoundException | NullPointerException e) {
			System.out.println("Dosya bulunamad� \n" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (dosyaOkuyucu != null) {
				dosyaOkuyucu.close();
			}
		}
		return kitapList;
	}
	
	public static ArrayList<YayinEvi> dosyadanOkuYayinEvi() {
		ArrayList<YayinEvi> yayinEviListe = new ArrayList<>();
		
		File kitaplarDosya = new File(".\\config\\YayinEviList.txt");
		Scanner dosyaOkuyucu = null;
		
		try {
			dosyaOkuyucu = new Scanner(kitaplarDosya);
			while (dosyaOkuyucu.hasNext()) {
				String satir = dosyaOkuyucu.nextLine();
				String dizi[] = satir.split(",");
				
				yayinEviListe.add(new YayinEvi(dizi[0], dizi[1]));
			}
		} catch (FileNotFoundException | NullPointerException e) {
			System.out.println("Dosya bulunamad� \n" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (dosyaOkuyucu != null) {
				dosyaOkuyucu.close();
			}
		}
		
		return yayinEviListe;
	}
	
	private static void kitapEkle(Kitap kitap) {
		kitaplarList.add(kitap);
	}
	
	private static void kitapSil(Kitap kitap) {
		kitaplarList.remove(kitap);
	}
	
}
