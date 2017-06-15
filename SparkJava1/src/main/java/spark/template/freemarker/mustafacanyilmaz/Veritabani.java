package spark.template.freemarker.mustafacanyilmaz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Veritabani {

	// Dosya tabanli veritabani, yoksa olustur
	private static final String VERITABANI_DIZINI = "c:\\MustafaCanYilmaz";
	private static final String VERITABANI_URL = "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";

	private static Connection veritabaniBaglantisi = null;

	private static Statement veritabaniIfadesi = null;
	
	private static int mevcutOgrenciSayisi = 0;

	public static void main(String[] konsolParametreleri) throws SQLException {
		
		veritabaniBaglantisi = baglantiKur();
		veritabaniIfadesi = veritabaniBaglantisi.createStatement();
		
		boolean yeniVeritabani = tabloOlustur();
		mevcutOgrenciSayisi = mevcutOgrenciSayisiniAl();
		
		//Veritabanına kayıt ekliyorum, Webden aldığım verileri parametre olarak geçecektim fakat hata verdi çözemedim.
		tabloyaKayitEkle(22,"Mustafa Can Yilmaz","YuksekLisans","Myo","22","Java","C++");
		tabloyuSorgula();
		//tablodan Kayit Silme
		TablodanKayitSil(22);
		
		baglantiyiKapat();
	}

	
	private static boolean tabloOlustur() throws SQLException {
	
		// Veritabani tablosunu yoket
		// stmt.executeUpdate("Drop Table users");

		// Veritabani tablosu olustur
		try {
			veritabaniIfadesi.executeUpdate("Create table ogrenciler (ogrenci_id int primary key, ad_soyad varchar(30),bolum varchar(30),ogrenciTipi varchar(30),yas varchar(30),ders1 varchar(30),ders2 varchar(30))");
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
	
	private static void tabloyaKayitEkle(int Id, String adSoyad,String bolum,String ogrenciTipi,String yas, String ders1,String ders2) throws SQLException {

		// Veritabani tablosuna kayit ekle
		//mevcutOgrenciSayisi++;
		//veritabaniIfadesi.executeUpdate("insert into ogrenciler values (" + mevcutOgrenciSayisi + ",'Kadir Kadiroglu')");
		//mevcutOgrenciSayisi++;
		//String maz = "coci";
		
		//parametre olarak alınan veriyi tabloya ekletiyorum.
		veritabaniIfadesi.executeUpdate("insert into ogrenciler values (" + Id + "," + "'"  +  adSoyad +  "'" +  "," + "'"  +  bolum +  "'" +  "," + "'"  +  ogrenciTipi +  "'"  + "," + "'"  +  yas +  "'" + "," + "'"  +  ders1 +  "'"  + "," + "'"  +  ders2 +  "'" +    ")");

	}
	
	//tablodan kayit Silme
	private static void TablodanKayitSil(int Id) throws SQLException {

		veritabaniIfadesi.executeUpdate("select * from ogrenciler(where ogrenci_id= Id ");

	}
	
	private static void tabloyuSorgula() throws SQLException {

		// Veritabanina sorgu at
		ResultSet rs2 = veritabaniIfadesi.executeQuery("SELECT * FROM ogrenciler");

		// Sorgu sonuclarini konsola bas
		while (rs2.next()) {
			int ogrenciId = rs2.getInt("ogrenci_id");
			String adSoyad = rs2.getString("ad_soyad");
			String bolum = rs2.getString("bolum");
			String ogrenciTipi = rs2.getString("ogrenciTipi");
			String yas = rs2.getString("yas");
			String ders1 = rs2.getString("ders1");
			String ders2 = rs2.getString("ders2");
			
			System.out.printf("%d\t%s\n", ogrenciId, adSoyad,bolum,ogrenciTipi,yas,ders1,ders2);
		}
	}

	private static Connection baglantiKur() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			Connection conn = DriverManager.getConnection(VERITABANI_URL);
			return conn;
		} catch (Exception except) {
			except.printStackTrace();
		}
		return null;
	}

	private static void baglantiyiKapat() {
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