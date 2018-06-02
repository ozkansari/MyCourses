package spark.template.freemarker.celal_sahin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class veriTabani {
	private static Connection veritabaniBaglantisi;

	public static void main(String[] args) {

	}

	public static boolean veritabaniniYukle() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			System.out.println("Veritabani kutuphanesi hatasi: " + e.getMessage());
			return false;
		}
		System.out.println("Veritabani kutuphanesi yuklendi.");
		return true;
	}

	public static boolean veritabaninaBaglan() {
		try {
			String veritabaniDizini = ".\\\\.celalsahinn\\\\veritabani\\\\";
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

	public static boolean tablolariOlustur() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "CREATE TABLE kitapBilgileri (id int, kitapAdi varchar(50), yazarAdi varchar(50),ySoyadi varchar(50),yayinEvi varchar(50), kitapFiyati int)";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Tablo mevcut olabilir: " + e);
			return false;
		}
		System.out.println("Tablo olusturuldu.");
		return true;
	}

	public static List<kitaplar> kayitlariAl() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM kitapBilgileri";
			ResultSet resultSet = komut.executeQuery(sql);

			List<kitaplar> kitapL = new ArrayList<kitaplar>();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String kad = resultSet.getString(2);
				String yad = resultSet.getString(3);
				String ySoyad = resultSet.getString(4);
				String yEvi = resultSet.getString(5);
				int kFiyat = resultSet.getInt(6);
				kitaplar kitap = new kitaplar(id, kad, yad, ySoyad, yEvi, kFiyat);
				kitapL.add(kitap);
			}
			return kitapL;

		} catch (SQLException e) {
			System.out.println("Komut hatasi: " + e);
			return null;
		}
	}

	public static boolean kitapEkle(kitaplar kitap) {
		return kitapEkle(kitap.getId(), kitap.getKitapAdi(), kitap.getYazarAdi(), kitap.getySoyadi(),
				kitap.getYayinEvi(), kitap.getKitapFiyati());
	}

	public static boolean kitapEkle(int id, String kitapAdi, String yazarAdi, String ySoyadi, String yayinEvi,
			int kitapFiyati) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "INSERT INTO kitapBilgileri values (" + id + ",'" + kitapAdi + ",'" + yazarAdi + ",'" + ySoyadi + ",'"
					+ yayinEvi + "', " + kitapFiyati + ")";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("INSERT hatasi: " + e);
			return false;
		}
		System.out.println("Kayitlar olusturuldu.");
		return true;
	}

}
