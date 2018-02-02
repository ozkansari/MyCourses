package spark.template.freemarker.caglaoz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Magaza_Yonetim {

	// BIRINCI ADIM
	private static Connection veritabaniBaglantisi;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// IKINCI ADIM -------------------------------------------------
		boolean veritabaniYuklendiMi = veritabaniniYukle();
		if (!veritabaniYuklendiMi) {
			return;
		}

		// UCUNCU ADIM -------------------------------------------------
		boolean veritabaninaBaglandiMi = veritabaninaBaglan();
		if (!veritabaninaBaglandiMi) {
			return;
		}

		// DORDUNCU ADIM ----------------------------------
		tablolariOlustur();

		// BESINCI ADIM ------------------------------------
		urunEkle(1, "etek", 50, "k�rm�z� pileli etek");

		// ALTINCI ADIM ------------------------------------
		kayitlariListele();

		// YEDINCI ADIM ------------------------------------
		urunSil(1);

		// SEKIZINCI ADIM ------------------------------------

		urunGuncelle(2);

	}

	/**
	 * @param id
	 */
	public static void urunGuncelle(int id) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "UPDATE urun WHERE id=" + id;
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("UPDATE hatasi: " + e);
		}
		System.out.println("Kayitlar guncellendi.");

		kayitlariListele();
	}

	/**
	 * @param id
	 * @return
	 */
	public static boolean urunSil(int id) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
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
	 * @param urun
	 * @return
	 */
	public static boolean urunEkle(Urun urun) {
		return urunEkle(urun.getId(), urun.getUrunAdi(), urun.getFiyat(), urun.getUrunDetayi());
	}

	/**@param urunAdi
	 * @param id
	 * @param urunAdi
	 * @param fiyat
	 * @param urunDetayi
	 * @return
	 */
	public static boolean urunEkle(int id, String urunAdi, int fiyat, String urunDetayi) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "INSERT INTO urun values (" + id + ",'" + urunAdi + "', " + fiyat + ",'" + urunDetayi + ")";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("INSERT hatasi: " + e);
			return false;
		}
		System.out.println("Kayitlar olusturuldu.");
		return true;
	}


	/**
	 * @return
	 */
	public static boolean veritabaniniYukle() {
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
	 * @return
	 */
	public static boolean veritabaninaBaglan() {
		try {
			String veritabaniDizini = ".\\.veritabani\\";
			// veritabaniDizini: Dizin ad� "C:\\veritabani\\" da olabilirdi.
			String url = "jdbc:derby:" + veritabaniDizini + ";create=true";
			veritabaniBaglantisi = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Veritabani baglanti hatasi: " + e.getMessage());
			return false;
		}
		System.out.println("Veritabani baglantisi kuruldu.");
		return true;
	}

	/**
	 * 
	 */
	/**
	 * @return
	 */
	public static boolean tablolariOlustur() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "CREATE TABLE urun (id int, ad varchar(30), fiyat int, detay varchar(100))";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Tablo mevcut olabilir: " + e);
			return false;
		}
		System.out.println("Tablo olusturuldu.");
		return true;
	}

	/**
	 * @param veritabaniBaglantisi
	 */
	/**
	 * @return
	 */
	public static List<Urun> kayitlariAl() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM urun";
			ResultSet resultSet = komut.executeQuery(sql);

			List<Urun> urunler = new ArrayList<Urun>();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String ad = resultSet.getString(2);
				int fiyat = resultSet.getInt(3);
				String detay = resultSet.getString(4);
				Urun urun = new Urun(id, ad, fiyat, detay);
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
	 */
	private static void kayitlariListele() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM urun";
			ResultSet resultSet = komut.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String ad = resultSet.getString(2);
				int fiyat = resultSet.getInt(3);
				String detay = resultSet.getString(4);
				System.out.println("Urun ID " + id + ", ad: " + ad + "fiyat " + fiyat + ", detay:" + detay);
			}

		} catch (SQLException e) {
			System.out.println("Komut hatasi: " + e);
		}
		System.out.println("Kayitlar listelendi.");
	}

	/**
	 * @param sipariskisi
	 * @return
	 */
	public static boolean Siparisdetay(Siparis_detay sipariskisi) {
		return Siparisdetay(sipariskisi.getIsim(), sipariskisi.getEmail(), sipariskisi.getAdres());
	}

	public static boolean Siparisdetay(String isim, String email, String adres) {
		try {
			Statement komut1 = veritabaniBaglantisi.createStatement();
			String sql = "INSERT INTO urun values (" + isim + ",'" + email + "', " + adres + ")";
			komut1.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("INSERT hatasi: " + e);
			return false;
		}
		System.out.println("Kayitlar olusturuldu.");
		return true;
	}

}