package tr.edu.medipol.hafta03;

import java.io.InputStream;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;



public class Tarihler {

	public static void main(String[] args) throws ParseException {
		
		// Kullanicidan girdi olarak alinan dogum tarihi stringini tarihi cevirmek icin (parse) fromatlayici
		SimpleDateFormat dogumTarihiFormatlayici = new SimpleDateFormat("yyyy-MM-dd"); // 2010-12-30
		
		// Konsoldan okuma icin scanner olustur
		InputStream konsolOkumaAkisi = System.in;
		Scanner kullaniciGirdisiOkuyucu = new Scanner(konsolOkumaAkisi);
		
		// Kullanici dogum tarihi al
		System.out.println("Dogum tarihinizi giriniz (2010-12-30 formatinda) : ");
		String kullaniciDogumTarihiString = kullaniciGirdisiOkuyucu.next();
		Date kullaniciDogumTarihiDate = dogumTarihiFormatlayici.parse(kullaniciDogumTarihiString);
		
		// Anne dogum tarihi al
		System.out.println("Annenizin dogum tarihini giriniz (2010-12-30 formatinda) : ");
		String anneDogumTarihiString = kullaniciGirdisiOkuyucu.next();
		Date anneDogumTarihiDate = dogumTarihiFormatlayici.parse(anneDogumTarihiString);
		
		// Baba dogum tarihi al
		System.out.println("Babanizin Dogum tarihinizi giriniz (2010-12-30 formatinda) : ");
		String babaDogumTarihiString = kullaniciGirdisiOkuyucu.next();
		Date babaDogumTarihiDate = dogumTarihiFormatlayici.parse(babaDogumTarihiString);
		
		int kullaniciYasi = 2018 - (kullaniciDogumTarihiDate.getYear() + 1900);
		System.out.println("Sizin Yasiniz " + kullaniciYasi);
		
		int annenizinYasi = 2018 - (anneDogumTarihiDate.getYear() + 1900);
		System.out.println("Annenizin Yasi " + annenizinYasi);
		
		int babanizinYasi = 2018 - (babaDogumTarihiDate.getYear() + 1900);
		System.out.println("Babanizin Yasi " + babanizinYasi);
		
		SimpleDateFormat yilinHaftasiFormatlayici = new SimpleDateFormat("w");
		SimpleDateFormat yilinGunuFormatlayici = new SimpleDateFormat("D");
		
		System.out.println("Siz yilin " + yilinHaftasiFormatlayici.format(kullaniciDogumTarihiDate) + " haftasında " +
				yilinGunuFormatlayici.format(kullaniciDogumTarihiDate) + " gununde dogmussunuz");
		
	}
}
