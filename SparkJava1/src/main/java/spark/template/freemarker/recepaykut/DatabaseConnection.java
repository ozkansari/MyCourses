package spark.template.freemarker.recepaykut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
		
		private static final String VERITABANI_DIZINI = ".\\_db\\recepaykut";
		private static final String VERITABANI_URL = "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";

		private static Connection veritabaniBaglantisi = null;

		private static Statement veritabaniIfadesi = null;
		
		private static int mevcutOgrenciSayisi = 0;

		// hatali public static void main(String[] konsolParametreleri) throws SQLException {
		/* OZKANS */ public static void init() throws SQLException {
			
			veritabaniBaglantisi = baglantiKur();
			veritabaniIfadesi = veritabaniBaglantisi.createStatement();
			
			boolean yeniVeritabani = tabloOlustur();
			mevcutOgrenciSayisi = mevcutOgrenciSayisiniAl();
			
			tabloyaKayitEkle();
			tabloyuSorgula();
			// OZKANS baglantiyiKapat();
		}

		
		private static boolean tabloOlustur() throws SQLException {
		
			// Veritabani tablosunu yoket
			// stmt.executeUpdate("Drop Table users");

			// Veritabani tablosu olustur
			try {
				veritabaniIfadesi.executeUpdate("Create table ogrenciler (ogrenci_id int primary key, ad_soyad varchar(30))");
				return true;
			} catch(SQLException e) {
				// Tablo zaten var
				return false;
			}
		}
		
		private static int mevcutOgrenciSayisiniAl() throws SQLException {
			ResultSet sorguSonucu = veritabaniIfadesi.executeQuery("SELECT max(ogrenci_id) maks_id FROM ogrenciler");
			sorguSonucu.next();
			int sonucDegeri = sorguSonucu.getInt("maks_id");
			return sonucDegeri;
		}
		
		public static void tabloyaKayitEkle() throws SQLException {

			
			mevcutOgrenciSayisi++;
			veritabaniIfadesi.executeUpdate("insert into ogrenciler values (" + mevcutOgrenciSayisi + ",'Kadir Kadiroglu')");
			mevcutOgrenciSayisi++;
			veritabaniIfadesi.executeUpdate("insert into ogrenciler values (" + mevcutOgrenciSayisi + ",'Hatice Aferin')");

		}
		
		public static void tabloyuSorgula() throws SQLException {

			ResultSet rs2 = veritabaniIfadesi.executeQuery("SELECT * FROM ogrenciler");
			while (rs2.next()) {
				int ogrenciId = rs2.getInt("ogrenci_id");
				String adSoyad = rs2.getString("ad_soyad");
				System.out.printf("%d\t%s\n", ogrenciId, adSoyad);
			}
		}

		public static Connection baglantiKur() {
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
				Connection conn = DriverManager.getConnection(VERITABANI_URL);
				return conn;
			} catch (Exception except) {
				except.printStackTrace();
			}
			return null;
		}

		public static void baglantiyiKapat() {
			try {
				if (veritabaniIfadesi != null) {
					veritabaniIfadesi.close();
				}
				if (veritabaniBaglantisi != null) {
					DriverManager.getConnection(VERITABANI_URL + ";shutdown=true");
					veritabaniBaglantisi.close();
				}
			} catch (SQLException sqlExcept) {
			}
		}
	}

