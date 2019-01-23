package spark.template.freemarker.emretanrisever.finalproje;

import java.sql.*;

import org.eclipse.jetty.http.HttpTester.Request;

public class VeritabaniYonetimi {

	private static Statement veritabaniStatement;
	
	public static Statement veritabaniBaglantisiKur() {
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			
			Connection veritabaniBaglantisi = DriverManager.getConnection(
					"jdbc:derby:"
					// + ".\\.emretanriseverdb\\" // windows ortami icin
					+ "./.emretanrisever/"
					+ ";create=true;"
					);
			
			veritabaniStatement = veritabaniBaglantisi.createStatement();
			
			return veritabaniStatement;
			
		} catch(Exception e) {
			System.out.println("Veritabanina baglanirken hata olustu");
		}
		
		return null;
	}
	
	public static boolean tablolariOlustur() {
		
		try  {
			// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "kullanicilar ("
								+ "kullanici_adi varchar(40), "
								+ "kullanici_tipi varchar(15), "
								+ "yas int, "
								+ "cinsiyet varchar(1), " // E-K
								+ "sifre varchar(25)"
							+ ")"
			);
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "urunler ("
								+ "ID int NOT NULL IDENTITY(1,1), "
								+ "urun_adi varchar(15), "
								+ "urun_kategori varchar(20), "
								+ "urun_fiyat MONEY " // 
							+ ")"
			);
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "siparisler ("
								+ "ID int NOT NULL IDENTITY(1,1), "
								+ "kullanici_adi varchar(15), "
								+ "urun_id int, "
								+ "toplam_fiyat MONEY " // 
							+ ")"
			);
			// TODO Diger tablolari olustur
			
			System.out.println("Tablolar basariyla olsuturuldu");
			
		} catch(Exception e) {
			System.out.println("Tablo zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
		}
		
		return true;
	}
	
	public static Kullanici kullaniciSorgula(String kullaniciAdi) {
		
		try  {
			ResultSet sonuclar = veritabaniStatement.executeQuery(
					"SELECT * FROM kullanicilar WHERE kullanici_adi = '" + kullaniciAdi + "'"
			);
			while(sonuclar.next()) {
				// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
				String kullaniciTipi = sonuclar.getString("kullanici_tipi");
				int yas = sonuclar.getInt("yas");
				String cinsiyet = sonuclar.getString("cinsiyet");
				String sifre = sonuclar.getString("sifre");
				return new Kullanici(kullaniciAdi, kullaniciTipi, yas, cinsiyet, sifre);
			}
		} catch(Exception e) {
			System.out.println("Kullanici sorgu hata" + e.getMessage());
		}
		return null;
	}

	public static void kullanicilariOlustur() {
		
		if(kullaniciSorgula("guest") != null) {
			System.out.println("Sistem kullanicilari mevcut");
			return;
		}
		
		try  {
			// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( "
					+ "'guest', 'NORMAL', 22, 'E', 'abcd'"
					+ ")");
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( "
					+ "'admin', 'ADMIN', 22, 'K', 'xyz'"
					+ ")");
			System.out.println("Sistem kullanicilari olusturuldu.");
		} catch(Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
	}
	
	public static Boolean kullanici_Kayit(String KullaniciAdi,int KullaniciYas, char Cinsiyet,String Sifre) {
		if(kullaniciSorgula(KullaniciAdi) != null) {
			System.out.println("Ayný kullanýcýdan 2 tane olamaz.");
			return null;
		}
		try {
			String deger="NORMAL";
			System.out.println(KullaniciAdi +KullaniciYas +Cinsiyet +Sifre);
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( "
					+ "'"+KullaniciAdi+"', '"+deger+"', "+KullaniciYas+", '"+Cinsiyet+"', '"+Sifre+"'"
					+ ")");
			System.out.println("Kullanicilar basariyla olusturuldu.");
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Kullanicilar oluþturulamadý"+ e.getMessage());
			return false;
		}
	}
	
	public static Boolean admin_Kayit(String KullaniciAdi,int KullaniciYas, char Cinsiyet,String Sifre) {
		if(kullaniciSorgula(KullaniciAdi)!=null) {
			System.out.println("Ayný isimden 2 kullanýcý kayýt olamaz.");
			return null;
		}
		try {
			String deger = "ADMIN";
			System.out.println(KullaniciAdi +KullaniciYas +Cinsiyet +Sifre);
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( "
					+ "'"+KullaniciAdi+"', '"+deger+"', "+KullaniciYas+", '"+Cinsiyet+"', '"+Sifre+"'"
					+ ")");
			System.out.println("Kullanicilar basariyla olusturuldu.");
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Kullanicilar oluþturulamadý"+ e.getMessage());
			return false;
		}
		
	}
	
}


