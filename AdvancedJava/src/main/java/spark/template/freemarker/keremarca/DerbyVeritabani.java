package spark.template.freemarker.keremarca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Bu sinif veritabani islemlerini olusturur.
 * 
 * @author Kerem Arca
 *
 */

public class DerbyVeritabani {
	
	/**
	 * 
	 * Veritabani baglantisi olusturulur.
	 * 
	 * @param VeritabaniBaglantisi
	 * 
	 */
	private static Connection VeritabaniBaglantisi;

	/**
	 * 
	 * Veritabani yuklenmesi test edilir. Veritabani baglantisi test edilir. Siniflar
	 * cagirilir.
	 * 
	 * @param args
	 * @param VeritabaniYuklendiMi
	 * @param VeritabaninaBaglandiMi
	 * @exception SQLException
	 *                - UPDATE hatasi
	 * 
	 */
	public static void main(String[] args) {

		boolean VeritabaniYuklendiMi = VeritabaniniYukle();
		if (!VeritabaniYuklendiMi) {
			return;
		}

		boolean VeritabaninaBaglandiMi = VeritabaninaBaglan();
		if (!VeritabaninaBaglandiMi) {
			return;
		}

		TabloOlustur();
		TabloOlustur2();

		KitapEkle(1, "Kerem", "deneme", "deneme", "deneme", 3);

		KitapListele();

		KitapSil(1);

		KitapGuncelle(1, "Kerem", "deneme", "deneme", "deneme", 3);

		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "UPDATE kitaplar SET ad='Kerem' WHERE id=2";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("UPDATE hatasi: " + e);
		}
		System.out.println("Kayitlar guncellendi.");

		KitapListele();

	}

	/**
	 * 
	 * Veritabani yukleme islemi olusturulur.
	 * 
	 * @exception Exception
	 *                - Veritabani kutuphanesi hatasi
	 * @return boolean bir deger
	 * 
	 */
	public static boolean VeritabaniniYukle() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		} catch (Exception e) {
			System.out.println("Veritabani kutuphanesi hatasi: " + e.getMessage());
			return false;
		}
		System.out.println("Veritabani kutuphanesi yuklendi.");
		return true;
	}

	/**
	 * 
	 * Veritabani baglanma islemi olusturulur.
	 * 
	 * @exception SQLException
	 *                - Veritabani baglanti hatasi
	 * @return boolean bir deger
	 * 
	 */
	public static boolean VeritabaninaBaglan() {
		try {
			String VeritabaniDizini = ".\\keremarca\\";
			String url = "jdbc:derby:" + VeritabaniDizini + ";create=true";
			VeritabaniBaglantisi = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Veritabani baglanti hatasi: " + e.getMessage());
			return false;
		}
		System.out.println("Veritabani baglantisi kuruldu.");
		return true;
	}

	/**
	 * 
	 * Tablolari olusturulur.
	 * 
	 * @exception SQLException
	 *                - Tablo mevcut olabilir hatasi
	 * @return boolean bir deger
	 * 
	 */
	public static boolean TabloOlustur() {
		try {
			String KitapTabloAdi = "kitaplar";
			Statement komut = VeritabaniBaglantisi.createStatement();
			komut.executeUpdate(
					"CREATE TABLE " + KitapTabloAdi + 
					" (" + 
							"kitap_id int primary key, " + 
							"kitap_adi varchar(30)," + 
							"yazar_adi varchar(30)," + 
							"yazar_soyadi varchar(30)," + 
							"yayin_evi varchar(30)," + 
							"fiyati int" + 
					")"
			);
		} catch (SQLException e) {
			System.out.println("kitaplar tablosu mevcut olabilir: " + e);
			return false;
		}
		System.out.println("kitaplar tablosu olusturuldu.");
		return true;
	}
	
	public static boolean TabloOlustur2() {
		try {
			String KitapTabloAdi = "siparisler";
			Statement komut = VeritabaniBaglantisi.createStatement();
			komut.executeUpdate(
					"CREATE TABLE " + KitapTabloAdi + 
					" (" + 
							"kitap_id int primary key, " + 
							"siparis_veren varchar(30)," + 
							"toplam_ucret int" + 
					")"
			);
		} catch (SQLException e) {
			System.out.println("siparisler tablosu mevcut olabilir: " + e);
			return false;
		}
		System.out.println("siparisler tablosu olusturuldu.");
		return true;
	}


	/**
	 * 
	 * Siparis ekleme islemi olusturulur.
	 * 
	 * @param id
	 * @param siparis_veren
	 * @param toplam_ucret
	 * @exception SQLException
	 *                - INSERT hatasi
	 * @return boolean bir deger
	 * 
	 */
	public static boolean SiparisEkle(int id, String siparis_veren, int toplam_ucret) {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "INSERT INTO siparisler values (" + id + ",'" + siparis_veren + "', " + toplam_ucret +")";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("INSERT hatasi: " + e);
			return false;
		}
		System.out.println("Siparis Eklendi");
		return true;
	}

	/**
	 * 
	 * Siparis ozellikleri kitaplar sinifina baglanir.
	 * 
	 * @param siparisler
	 * @return getId, getSiparis_veren, getToplam_ucret
	 * 
	 */
	public static boolean SiparisEkle(siparisler siparisler) {
		return SiparisEkle(siparisler.getId(), siparisler.getSiparis_veren(),siparisler.getToplam_ucret());
	}
	
	
	/**
	 * 
	 * Kitap ekleme islemi olusturulur.
	 * 
	 * @param id
	 * @param adi
	 * @param yazar_adi
	 * @param yazar_soyadi
	 * @param yayinevi
	 * @param fiyati
	 * @exception SQLException
	 *                - INSERT hatasi
	 * @return boolean bir deger
	 * 
	 */
	public static boolean KitapEkle(int id, String ad, String yazarAdi, String yazarSoyadi, String yayinEvi, int fiyat) {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "INSERT INTO kitaplar values (" + id + ",'" + ad + "', '" + yazarAdi + "','" + yazarSoyadi + "','" + yayinEvi + "'," + fiyat +")";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("INSERT hatasi: " + e);
			return false;
		}
		System.out.println("Kitaplar Eklendi");
		return true;
	}

	/**
	 * 
	 * Kitap ozellikleri kitaplar sinifina baglanir.
	 * 
	 * @param kitaplar
	 * @return getId, getAd, getYazar_ad, getYazar_soyad, getYayinevi, getFiyat
	 * 
	 */
	public static boolean KitapEkle(kitaplar kitaplar) {
		return KitapEkle(kitaplar.getId(), kitaplar.getAd(),kitaplar.getYazar_ad(),kitaplar.getYazar_soyad(),kitaplar.getYayinevi(),kitaplar.getFiyat());
	}

	/**
	 * 
	 * Kitap silme islemi olusturulur.
	 * 
	 * @param id
	 * @exception SQLException
	 *                - DELETE hatasi
	 * @return boolean bir deger
	 * 
	 */
	public static boolean KitapSil(int id) {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "DELETE FROM kitaplar WHERE id=" + id;
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DELETE hatasi: " + e);
			return false;
		}
		System.out.println("Kitaplar silindi.");
		return true;
	}

	/**
	 * 
	 * Kitap guncelleme islemi olusturulur.
	 * 
	 * @param id
	 * @param adi
	 * @param yazar_adi
	 * @param yazar_soyadi
	 * @param yayinevi
	 * @param fiyati
	 * @exception SQLException
	 *                - UPDATE hatasi
	 * @return boolean bir deger
	 * 
	 */
	public static boolean KitapGuncelle(int id, String ad, String yazarAdi, String yazarSoyadi, String yayinEvi, int fiyat) {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			KayitlariAl();
			String sql = "UPDATE kitaplar SET " + "Ad='" + ad + "', " + "YazarAdi=" + yazarAdi + "', " + "YazarSoyadi=" + yazarSoyadi + "', " + "Yayinevi=" + yayinEvi + "', " + "Fiyat=" + fiyat +  " WHERE ID=" + id;
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("UPDATE hatasi: " + e);
			return false;
		}
		System.out.println("Kitaplar guncellendi.");
		return true;
	}

	/**
	 * 
	 * Veritabanina kayitli tum kitaplari alma islemi olusturulur.
	 * 
	 * @exception SQLException
	 *                - Komut hatasi
	 * @return kitaplar, null
	 * 
	 */
	public static List<kitaplar> KayitlariAl() {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM kitaplar";
			ResultSet resultSet = komut.executeQuery(sql);

			List<kitaplar> kitap = new ArrayList<kitaplar>();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String ad = resultSet.getString(2);
				String yazarAd = resultSet.getString(3);
				String yazarSoyad = resultSet.getString(4);
				String yayinevi = resultSet.getString(5);
				int fiyat = resultSet.getInt(6);
				kitaplar kitapp = new kitaplar(id, ad, yazarAd, yazarSoyad, yayinevi, fiyat);
				kitap.add(kitapp);
			}
			return kitap;

		} catch (SQLException e) {
			System.out.println("Komut hatasi: " + e);
			return null;
		}
	}

	/**
	 * 
	 * Veritabanindaki kayitlarin listeleme islemi olusturulur.
	 * 
	 * @exception SQLException
	 *                - Komut hatasi
	 * 
	 */
	private static void KitapListele() {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM kitaplar";
			ResultSet resultSet = komut.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String ad = resultSet.getString(2);
				String yazarAd = resultSet.getString(3);
				String yazarSoyad = resultSet.getString(4);
				String yayinevi = resultSet.getString(5);
				int fiyat = resultSet.getInt(6);
				System.out.println("kitaplar id " + id + ", ad: " + ad + ", yazarAd: " + yazarAd + ", yazarSoyad: " + yazarSoyad + ", yayinevi: " + yayinevi + ", fiyat: " + fiyat);
			}

		} catch (SQLException e) {
			System.out.println("Komut hatasi: " + e);
		}
		System.out.println("Kitaplar listelendi.");
	}
}
