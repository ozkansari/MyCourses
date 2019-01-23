package spark.template.freemarker.osmancansiz.finalproje;

import java.sql.*;

public class VeritabaniYonetimi {

	private static Statement veritabaniStatement;

	public static Statement veritabaniBaglantisiKur() {
		try {

			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

			Connection veritabaniBaglantisi = DriverManager.getConnection("jdbc:derby:"
					+ "./.osmancansizdb/" + ";create=true;");

			veritabaniStatement = veritabaniBaglantisi.createStatement();

			return veritabaniStatement;

		} catch (Exception e) {
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
			System.out.println("Kullanicilar Tablosu basariyla olusuturuldu");
			
		} catch(Exception e) {
			System.out.println("Kullanici Tablo zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
		}
		
		try {
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "urunler ("
								+ "urun_id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), "
								+ "urun_adi varchar(40), "
								+ "urun_kategori varchar(40), " 
								+ "fiyat int"
							+ ")"
					);
			System.out.println("Ürünler Tablosu basariyla olusturuldu");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ürünler Tablo zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
		}
		
		
		try {
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "siparisler ("
								+ "siparis_id INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), "
								+ "kullanici_adi varchar(40), "
								+ "urun_idler int, " 
								+ "toplamucret int"
							+ ")"
						);
			System.out.println("Siparisler Tablosu basariyla olusturuldu");
		} catch (SQLException e) {
			System.out.println("Sipariş Tablo zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
		}		
		return true;
	}

	public static Kullanici kullaniciSorgula(String kullaniciAdi) {

		try {
			ResultSet sonuclar = veritabaniStatement
					.executeQuery("SELECT * FROM kullanicilar WHERE kullanici_adi = '" + kullaniciAdi + "'");
			while (sonuclar.next()) {
				// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
				String kullaniciTipi = sonuclar.getString("kullanici_tipi");
				int yas = sonuclar.getInt("yas");
				String cinsiyet = sonuclar.getString("cinsiyet");
				String sifre = sonuclar.getString("sifre");
				return new Kullanici(kullaniciAdi, kullaniciTipi, yas, cinsiyet, sifre);
			}
		} catch (Exception e) {
			System.out.println("Kullanici sorgu hata" + e.getMessage());
		}
		return null;
	}
	

	public static Kullanici kullanicilariOlustur(String kullaniciAdi, int yas, String cinsiyet, String sifre) {

		if (kullaniciSorgula("guest") != null) {
			System.out.println("Sistem kullanicilari mevcut");
		}

		try {
			// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( " + " '" + kullaniciAdi
					+ "' , 'NORMAL', " + yas + ", '" + cinsiyet + "', '" + sifre + "' " + ")");

			
			  veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( " +
			  "'admin', 'ADMIN', 22, 'K', 'xyz'" + ")");
			  
			  veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( " +
					  "'guest', 'NORMAL', 18, 'E', 'abcd'" + ")");
			 
			System.out.println("Sistem kullanicilari olusturuldu.");
		} catch (Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
		return null;
	}
	
	public static void urunleriOlustur() {

		if (kullaniciSorgula("Urun1") != null) {
			System.out.println("Sistem ürünleri mevcut");
		}

		try {
			// "urunler" tablosu: urun_id , urun_adi , urun_kategori, fiyat 	
			 veritabaniStatement.executeUpdate("INSERT INTO urunler (urun_adi , urun_kategori, fiyat ) VALUES ( " 
			+ " 'Urun1', 'Kategori1', 10 " + ")");
			 veritabaniStatement.executeUpdate("INSERT INTO urunler (urun_adi , urun_kategori, fiyat ) VALUES ( " 
			+ " 'Urun2', 'Kategori2', 18 " + ")");
			 
			System.out.println("Sistem ürünleri olusturuldu.");
		} catch (Exception e) {
			System.out.println("Urunler tablosu daha önce oluşturuldu. :" + e.getMessage());
		}
	}
	
	public static void urunleriListele() {
		try {
			// "urunler" tablosu: urun_id , urun_adi , urun_kategori, fiyat 	
			veritabaniStatement.executeQuery("SELECT * FROM urunler");
	 
			System.out.println("Sistem ürünleri listelendi.");
		} catch (Exception e) {
			System.out.println("Urunler tablosunda problem var :" + e.getMessage());
		}
	}

	

}
