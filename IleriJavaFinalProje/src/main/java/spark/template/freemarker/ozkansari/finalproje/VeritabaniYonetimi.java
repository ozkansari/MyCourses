package spark.template.freemarker.ozkansari.finalproje;

import java.sql.*;

public class VeritabaniYonetimi {

	private static Statement veritabaniStatement;
	
	public static Statement veritabaniBaglantisiKur() {
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			
			Connection veritabaniBaglantisi = DriverManager.getConnection(
					"jdbc:derby:"
					// + ".\\.ozkansaridb\\" // windows ortami icin
					+ "./.ozkansaridb/"
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
	
}
