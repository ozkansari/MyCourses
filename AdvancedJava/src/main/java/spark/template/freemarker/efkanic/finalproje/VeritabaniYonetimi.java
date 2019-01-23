package spark.template.freemarker.efkanic.finalproje;


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
			//"urunler" tablosu: urunid eþsiz , urunadi, urunkategori, fiyat tl 
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "urunler ("
								+ "urunid int PRIMARY KEY, "
								+ "urunadi varchar(15), "
								+ "urunkategori varchar(10), "
								+ "fiyat int " 
							+ ")"
			);
			// "uyeler" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
			veritabaniStatement.executeUpdate(
					"CREATE TABLE "
							+ "uyeler ("
								+ "kullanici_adi varchar(40), "
								+ "kullanici_tipi varchar(15), "
								+ "yas int, "
								+ "cinsiyet varchar(10), " // E-K
								+ "sifre varchar(25)"
							+ ")"
			);
			
			// TODO Diger tablolari olustur
			
			System.out.println("Tablolar basariyla olsuturuldu");
			
		} catch(Exception e) {
			System.out.println("Tablo zaten mevcut. Tekrar olusturulmayacak: ");
		}
		
		return true;
	}
	
	public static User kullaniciSorgula(String kullaniciAdi) {
		
		try  {
			ResultSet sonuclar = veritabaniStatement.executeQuery(
					"SELECT * FROM uyeler WHERE kullanici_adi = '" + kullaniciAdi + "'"
			);
			while(sonuclar.next()) {
				// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
				String kullaniciTipi = sonuclar.getString("kullanici_tipi");
				int yas = sonuclar.getInt("yas");
				String cinsiyet = sonuclar.getString("cinsiyet");
				String sifre = sonuclar.getString("sifre");
				return new User(kullaniciAdi, kullaniciTipi, yas, cinsiyet, sifre);
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
			veritabaniStatement.executeUpdate("INSERT INTO uyeler VALUES ( "
					+ "'guest', 'NORMAL', 22, 'E', 'abcd'"
					+ ")");
			veritabaniStatement.executeUpdate("INSERT INTO uyeler VALUES ( "
					+ "'admin', 'ADMIN', 22, 'K', 'xyz'"
					+ ")");
			System.out.println("Sistem kullanicilari olusturuldu.");
		} catch(Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
	}
	public static void kayitol(String kullaniciadi,String yas,String cinsiyet,String Sifre)  {
		try {
			int yass = Integer.valueOf(yas);
		    try {
			    veritabaniStatement.executeUpdate("INSERT INTO uyeler VALUES("
					+ "'"+kullaniciadi+"','NORMAL',"+yass+",'"+cinsiyet+"','"+Sifre+"')");
		        }
		    catch (Exception e){
			    System.out.println("Üye olurken hata oluþtu "+ e.getMessage());
		    }
		}catch (Exception e) {
			System.out.println("Yaþý Sayý olarak belirtiniz.");
		}
		return;
	}
	public static void urunleriolustur() {
		if(urunsorgula("Ekmek") != null) {
		System.out.println("ürünler mevcut");
		return;
	}
	
	try  {
		// "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
		veritabaniStatement.executeUpdate("INSERT INTO urunler VALUES ( "
				+ "1, 'Ekmek', 'Manav', 5"
				+ ")");
		veritabaniStatement.executeUpdate("INSERT INTO urunler VALUES ( "
				+ "2, 'Soðan', 'Manav', 7"
				+ ")");
		System.out.println("ürünler olusturuldu.");
	} catch(Exception e) {
		System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
	}
	
}
	public static Urun urunsorgula(String urunadi) {
	
	try  {
		ResultSet sonuclar = veritabaniStatement.executeQuery(
				"SELECT * FROM urunler WHERE urunadi = '" + urunadi + "'"
		);
		while(sonuclar.next()) {
			return new Urun(urunadi);
		}
	} catch(Exception e) {
		System.out.println("ürün sorgu hata" + e.getMessage());
	}
	return null;
}
}
