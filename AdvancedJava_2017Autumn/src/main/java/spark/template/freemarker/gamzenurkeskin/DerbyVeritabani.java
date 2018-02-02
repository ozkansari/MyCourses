package spark.template.freemarker.gamzenurkeskin;
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
 * @author Gamze Keskin
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
	 * Veritabani y�klenisi test edilir. Veritabani baglantisi test edilir. Siniflar
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

		UrunEkle(1, "Gamze", 100);

		KayitListele();

		UrunSil(1);

		UrunGuncelle(1, "Gamze", 100);

		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "UPDATE Urun SET ad='Gamze' WHERE id=2";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("UPDATE hatasi: " + e);
		}
		System.out.println("Kayitlar guncellendi.");

		KayitListele();

	}

	/**
	 * 
	 * Veritabani y�kleme islemi olusturulur.
	 * 
	 * @exception Exception
	 *                - Veritabani kutuphanesi hatasi
	 * @return boolean bir de�er
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
	 * @return boolean bir de�er
	 * 
	 */
	public static boolean VeritabaninaBaglan() {
		try {
			String VeritabaniDizini = ".\\.veritabani\\";
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
	 * Tablo olusturulur.
	 * 
	 * @exception SQLException
	 *                - Tablo mevcut olabilir hatasi
	 * @return boolean bir de�er
	 * 
	 */
	public static boolean TabloOlustur() {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "CREATE TABLE urun (id int, ad varchar(30), fiyat int)";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Tablo mevcut olabilir: " + e);
			return false;
		}
		System.out.println("Tablo olusturuldu.");
		return true;
	}

	/**
	 * 
	 * Urun ekleme islemi olusturulur.
	 * 
	 * @param id
	 * @param urunAdi
	 * @param fiyat
	 * @exception SQLException
	 *                - INSERT hatasi
	 * @return boolean bir de�er
	 * 
	 */
	public static boolean UrunEkle(int id, String urunAdi, int fiyat) {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "INSERT INTO urun values (" + id + ",'" + urunAdi + "', " + fiyat + ")";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("INSERT hatasi: " + e);
			return false;
		}
		System.out.println("Kayitlar olusturuldu.");
		return true;
	}

	/**
	 * 
	 * Urunun ozellikleri urun ekle sinifina baglanir.
	 * 
	 * @param urun
	 * @return getId, getUrunAdi, getFiyat
	 * 
	 */
	public static boolean UrunEkle(Urun urun) {
		return UrunEkle(urun.getId(), urun.getUrunAdi(), urun.getFiyat());
	}

	/**
	 * 
	 * Urun silme islemi olusturulur.
	 * 
	 * @param id
	 * @exception SQLException
	 *                - DELETE hatasi
	 * @return boolean bir de�er
	 * 
	 */
	public static boolean UrunSil(int id) {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "DELETE FROM urun WHERE id=" + id;
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DELETE hatasi: " + e);
			return false;
		}
		System.out.println("Kayitlar silindi.");
		return true;
	}

	/**
	 * 
	 * Urun guncelleme islemi olusturulur.
	 * 
	 * @param id
	 * @param urunAdi
	 * @param fiyat
	 * @exception SQLException
	 *                - UPDATE hatasi
	 * @return boolean bir de�er
	 * 
	 */
	public static boolean UrunGuncelle(int id, String urunAdi, int fiyat) {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			KayitlariAl();
			String sql = "UPDATE Urun SET " + "Ad='" + urunAdi + "', " + "Fiyat=" + fiyat + " WHERE ID=" + id;
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("UPDATE hatasi: " + e);
			return false;
		}
		System.out.println("Kayitlar g�ncellendi.");
		return true;
	}

	/**
	 * 
	 * Veritabanina kayitli tum urunleri alma islemi olusturulur.
	 * 
	 * @exception SQLException
	 *                - Komut hatasi
	 * @return urunler, null
	 * 
	 */
	public static List<Urun> KayitlariAl() {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM urun";
			ResultSet resultSet = komut.executeQuery(sql);

			List<Urun> urunler = new ArrayList<Urun>();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String ad = resultSet.getString(2);
				int fiyat = resultSet.getInt(3);
				Urun urun = new Urun(id, ad, fiyat);
				urunler.add(urun);
			}
			return urunler;

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
	private static void KayitListele() {
		try {
			Statement komut = VeritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM urun";
			ResultSet resultSet = komut.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String ad = resultSet.getString(2);
				int fiyat = resultSet.getInt(3);
				System.out.println("Urun ID " + id + ", ad: " + ad);
			}

		} catch (SQLException e) {
			System.out.println("Komut hatasi: " + e);
		}
		System.out.println("Kayitlar listelendi.");
	}
}
