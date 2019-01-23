package spark.template.freemarker.erhankilic.finalproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VeritabaniYonetimi {


	private static Statement veritabaniStatement;
	
	@SuppressWarnings("deprecation")
	public static Statement veritabaniBaglantisiKur() {
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance()
			;
			
			Connection veritabaniBaglantisi = DriverManager.getConnection(
					"jdbc:derby:"
					+ "./.erhankilicdb/"
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
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "kullanicilar ("
								+ "kullanici_adi varchar(40), "
								+ "kullanici_tipi varchar(15), "
								+ "yas int, "
								+ "cinsiyet varchar(1), " 
								+ "sifre varchar(25)"
							+ ")"
			);
			
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

}
