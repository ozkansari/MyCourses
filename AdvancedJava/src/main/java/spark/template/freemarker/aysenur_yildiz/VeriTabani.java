package spark.template.freemarker.aysenur_yildiz;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import spark.template.freemarker.iskenderuzuner.Urun;
public class VeriTabani {
		private static Connection veritabaniBaglantisi;
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			boolean veritabaniYuklendiMi = veritabaniniYukle();
			if (!veritabaniYuklendiMi) {
				return;
			}
			boolean veritabaninaBaglandiMi = veritabaninaBaglan();
			if (!veritabaninaBaglandiMi) {
				return;
			}
			tablolariOlustur();
			kitapEkle("Kurk Mantolu Madonna", "Sabahattin Ali", 30);
			kayitlariListele();
			urunSil(1);
		}
		private static void kitapEkle(String string, String string2, int i) {	
		}
		public static void add(KitapEkleSil kitap) {	
		}
		/**
		 * @param id
		 * @return
		 */
		public static boolean urunSil(int id) {
			try {
				Statement komut = (Statement) veritabaniBaglantisi.createStatement();
				String sql = "DELETE FROM urun WHERE id=" + id;
				((java.sql.Statement) komut).executeUpdate(sql);
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
		public static boolean kitapEkle(Kitap kitap) {
			return kitapEkle(kitap.getId(), kitap.getkitapAdi(), kitap.getFiyat(),kitap.getkitapDetayi());
		}
		/**@param urunAdi
		 * @param id
		 * @param urunAdi
		 * @param fiyat
		 * @param urunDetayi
		 * @return
		 */
		public static boolean kitapEkle(int id, String urunAdi, int fiyat, String urunDetayi) {
			try {
				Statement komut = (Statement) veritabaniBaglantisi.createStatement();
				String sql = "INSERT INTO urun values (" + id + ",'" + urunAdi + "', " + fiyat + ",'" + urunDetayi + ")";
				((java.sql.Statement) komut).executeUpdate(sql);
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
				// veritabaniDizini: Dizin adi "C:\\veritabani\\" da olabilirdi.
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
				Statement komut = (Statement) veritabaniBaglantisi.createStatement();
				String sql = "CREATE TABLE urun (id int, ad varchar(30), fiyat int, detay varchar(100))";
				((java.sql.Statement) komut).executeUpdate(sql);
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
// OZKANS DUZELTME		public static ArrayList<Urun> kayitlariAl() {
		public static ArrayList<Kitap> kayitlariAl() {
			try {
				Statement komut = (Statement) veritabaniBaglantisi.createStatement();
				String sql = "SELECT * FROM urun";
				ResultSet resultSet = ((java.sql.Statement) komut).executeQuery(sql);

				// OZKANS DUZELTME ArrayList<Urun> urunler = new ArrayList<Urun>();
				ArrayList<Kitap> urunler = new ArrayList<Kitap>();
				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String ad = resultSet.getString(2);
					int fiyat = resultSet.getInt(3);
					String detay = resultSet.getString(4);
					Kitap kitap = new Kitap(id,ad,fiyat,detay);
					// OZKANS DUZELTME kitap.add(kitap);
					urunler.add(kitap);
				}

			} catch (SQLException e) {
				System.out.println("Komut hatasi: " + e);
				return null;
			}
			return null;
		}
		/**
		 * 
		 */
		private static void kayitlariListele() {
			try {
				Statement komut = (Statement) veritabaniBaglantisi.createStatement();
				String sql = "SELECT * FROM urun";
				ResultSet resultSet = ((java.sql.Statement) komut).executeQuery(sql);
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
		public static boolean Siparisdetay(Siparis sipariskisi) {
			return Siparisdetay(sipariskisi.getIsim(), sipariskisi.getEmail(), sipariskisi.getAdress());
		}

		public static boolean Siparisdetay(String isim, String email, String adress) {
			try {
				Statement komut1 = (Statement) veritabaniBaglantisi.createStatement();
				String sql = "INSERT INTO urun values (" + isim + ",'" + email + "', " + adress + ")";
				((java.sql.Statement) komut1).executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("INSERT hatasi: " + e);
				return false;
			}
			System.out.println("Kayitlar olusturuldu.");
			return true;
		}
}