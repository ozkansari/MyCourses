package spark.template.freemarker.ibrahimkandemir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeritabaniYonetim {
	private static Connection veritabaniBaglantisi;	
	
	public VeritabaniYonetim() {
		
		veritabaniIslemleri();
	}


	public static void veritabaniIslemleri() {

		boolean veritabaniKontrol = veritabaniYukle();

		if (!veritabaniKontrol)
			return;

		boolean veritabaninaBaglanti = veritabaninaBaglan();

		if (!veritabaninaBaglanti)
			return;

		tabloOlustur();
		tabloOlusturSepet();

		
		

	}
	
	
	
	/*-------------------------------- VERITABANI BOLUMU ----------------------------*/
	
	
	/**
	 * Veritabani baglantisini olusturur. Eger olusturamazsa konsol ekranina hata
	 * mesaji basar. Veritabanini basariyla olusturursa bilgilendirme mesaji yazar
	 * console ekranina
	 * 
	 * @return boolean deger doner
	 */
	public static boolean veritabaniYukle() {

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		} catch (Exception e) {
			System.out.println("Veritabani kutuphanesi hatasi. Error code " + e.getMessage());
			return false;
		}
		System.out.println("Veritabani kutuphanesi basarili bir sekilde yuklendi");
		return true;
	}

	/**
	 * Derby veri tabanina(jdbc) baglantisi icin url paremetresi gerekir. 
	 * Url'i olusturup baglanti icin paremetre olarak verilir.
	 * Veritabanina baglanti saglar. Yapilan islemler hakkinda bilgilendirme mesaji yazar console ekranina.
	 * @return boolean sonuc doner
	 */
	public static boolean veritabaninaBaglan() {

		try {
			String veritabaniDizini = ".\\.veritabani\\";
			String url = "jdbc:derby:" + veritabaniDizini + ";create=true";
			veritabaniBaglantisi = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Veritabani baglanti hatasi. Error code " + e.getMessage());
			return false;
		}
		System.out.println("Veritabani baglantisi basariyla kuruldu.");
		return true;
	}
	
	/*-------------------------------- VERITABANI BOLUMU / SONU ----------------------------*/
	
	
	/*-------------------------------- TABLO ISLEM BOLUMU ----------------------------*/

	/**
	 * Veritanininda urunler  tablosunu olusturur. Tabloyu basariyla olusturursa bilgilendirir. Hata ile karsılasırsa hata mesajını gosterir.
	 * @return boolean doner
	 */
	public static boolean tabloOlustur() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "CREATE TABLE URUNLER (ID int, URUN_BASLIGI varchar(50), MARKA varchar(20), URUN_FIYAT float, URUN_INDIRIM float, KARGO_BILGISI varchar(15), KARGO_TESLIMAT varchar(10), URUN_ACIKLAMA varchar(1000) )";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Boyle bir tablo olabilir. Error code " + e);
			return false;
		}
		System.out.println("Tablo basarili bir sekilde olusturuldu.");
		return true;
	}

	/**
	 * Veritqbaninda sepetteki urunler icin bir tablo olusturur.Tabloyu basariyla olusturursa bilgilendirir. Hata ile karsılasırsa hata mesajını gosterir.
	 * @return boolean doner
	 */
	public static boolean tabloOlusturSepet() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "CREATE TABLE SEPET_URUNLER (ID int, URUN_BASLIGI varchar(50), MARKA varchar(20), URUN_FIYAT float, URUN_TOPLAM_FIYAT float )";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Boyle bir tablo olabilir. Error code " + e);
			return false;
		}
		System.out.println("Tablo basarili bir sekilde olusturuldu.");
		return true;
	}

	/*-------------------------------- TABLO ISLEM BOLUMU / SONU ----------------------------*/

	/*-------------------------------- KAYITLARI ALMA ISLEM BOLUMU ----------------------------*/
	
	/**
	 * Veritabani uzerindeki urunler tablosundan butun kayitlari alir ve urunler icin olusturulmus bir listeye ekler.
	 * @return olarak olusturulmus listeyi doner.
	 */
	public static List<Urunler> kayitlariAl() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM URUNLER";
			ResultSet resultSet = komut.executeQuery(sql);
			
			List<Urunler> urunler = new ArrayList<Urunler>();
			
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String urunBasligi = resultSet.getString(2);
				String marka = resultSet.getString(3);
				float urunFiyati = resultSet.getFloat(4);
				float urunIndirimliFiyati = resultSet.getFloat(5);
				String kargoBilgisi = resultSet.getString(6);
				String kargoTeslimat = resultSet.getString(7);
				String urunAciklamasi = resultSet.getString(8);
			
				Urunler urun = new Urunler(id, urunBasligi, marka, urunFiyati, urunIndirimliFiyati, kargoBilgisi, kargoTeslimat, urunAciklamasi);
				urunler.add(urun);
			}
			return urunler;

		} catch (SQLException e) {
			System.out.println("Islem gerceklestirilmedi.SQL hatasi. Error code hatasi " + e);
			return null;
		}
	}

	/**
	 * Veritabani uzerindeki sepet urunler tablosundan butun kayitlari alir ve urunler icin olusturulmus bir listeye ekler.
	 * @return olarak olusturulmus listeyi doner.
	 */
	public static List<SepetUrunler> kayitlariAlSepet() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM SEPET_URUNLER";
			ResultSet resultSet = komut.executeQuery(sql);
			
			List<SepetUrunler> sepetUrunler = new ArrayList<SepetUrunler>();
			
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String urunBasligi = resultSet.getString(2);
				String marka = resultSet.getString(3);
				float urunFiyati = resultSet.getFloat(4);
				float urunToplamFiyati = resultSet.getFloat(5);
			
				SepetUrunler sepetUrun = new SepetUrunler(id, urunBasligi, marka, urunFiyati, urunToplamFiyati);
				sepetUrunler.add(sepetUrun);
			}
			return sepetUrunler;

		} catch (SQLException e) {
			System.out.println("Islem gerceklestirilmedi.SQL hatasi. Error code hatasi " + e);
			return null;
		}
	}
	
	/*-------------------------------- KAYITLARI ALMA ISLEM BOLUMU / SONU ----------------------------*/
	
	/*-------------------------------- KAYITLAR ISLEM BOLUMU ----------------------------*/
	
	/**
	 * Urunler class 'inda getterlar yardimiyla urunler ile ilgili bilgiler alir.
	 * @param Urunler class 'ından olusmus bir degisken alir paremetre olarak
	 * @return	urunEkle method'una gonderir.
	 */
	public static boolean urunEkle(Urunler urun) {
		return urunEkle(urun.getId(), urun.getUrunBasligi(), urun.getMarka(), urun.getUrunFiyati(), urun.getUrunIndirimliFiyati(), urun.getKargoBilgisi(), urun.getKargoTeslimat(), urun.getUrunAciklamasi());
	}

	/**
	 * urunEkle methodundan gelen verileri veritabanina urunler tablosuna insert eder.
	 * @param id urunIdsi urun ekle bolumunde int tipinde urunnun idsini icerir.
	 * @param urunBasligi urun ekle bolumunde string tipinde urunnun basligini icerir.
	 * @param marka urun ekle bolumunde string tipinde urunnun markasini icerir.
	 * @param urunFiyati urun ekle bolumunde float tipinde urunnun fiyatini icerir.
	 * @param urunIndirimliFiyati urun ekle bolumunde float tipinde urunun indirimli fiyatini icerir.
	 * @param kargoBilgisi urun ekle bolumunde string tipinde urunun kargo bilgisini icerir.
	 * @param kargoTeslimat urun ekle bolumunde string tipinde urunnun kargo teslimat suresiniicerir.
	 * @param urunAciklamasi urun ekle bolumunde string tipinde urun aciklamasini icerir.
	 * @return boolean doner
	 */
	public static boolean urunEkle(int id, String urunBasligi, String marka, float urunFiyati, float urunIndirimliFiyati, String kargoBilgisi, String kargoTeslimat, String urunAciklamasi) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "INSERT INTO URUNLER VALUES (" + id + ",'" + urunBasligi + "', '"+ marka +"', " + urunFiyati + "," + urunIndirimliFiyati + " ,'" + kargoBilgisi +"', '" + kargoTeslimat + "', '" + urunAciklamasi +"')";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("INSERT hatasi: " + e);
			return false;
		}
		return true;
	}
	
	
	
	/**
	 * Verilen paremetreyi tablodaki kayitla karsilastirir ve o veriyi tablodan siler.
	 * @param int tipinde paremetre alir.
	 * @return boolean doner.
	 */
	public static boolean urunSil(int id) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "DELETE FROM URUNLER WHERE ID=" + id;
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Silme islemi gerceklestirilemedi. Error code " + e);
			return false;
		}
		return true;
	}
	
	/**
	 * Verilen paremetreyi tablodaki kayitla karsilastirir ve o veriyi tablodan siler.
	 * @param int tipinde paremetre alir.
	 * @return boolean doner.
	 */
	public static boolean urunSilSepet(int id) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "DELETE FROM SEPET_URUNLER WHERE ID=" + id;
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Silme islemi gerceklestirilemedi. Error code " + e);
			return false;
		}
		return true;
	}

	/*-------------------------------- KAYITLAR ISLEM BOLUMU / SONU ----------------------------*/
	
	
	
	/*-------------------------------- SEPET ISLEM BOLUMU ----------------------------*/
	
	/**
	 * Ana sayfa uzerinden secilen urunun id 'sini alir ve veri tabanindan secilen kayitin bilgilerini listeye ekler.
	 * @param int tipinde p_id alir.
	 * @return urunler ile dolu olan listeyi doner.
	 */
	public static List<Urunler> secilenKayitiAl(int p_id) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM URUNLER WHERE ID=" + p_id;
			ResultSet resultSet = komut.executeQuery(sql);
			
			List<Urunler> urunler = new ArrayList<Urunler>();
			
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String urunBasligi = resultSet.getString(2);
				String marka = resultSet.getString(3);
				float urunFiyati = resultSet.getFloat(4);
				float urunIndirimliFiyati = resultSet.getFloat(5);
				String kargoBilgisi = resultSet.getString(6);
				String kargoTeslimat = resultSet.getString(7);
				String urunAciklamasi = resultSet.getString(8);
			
				Urunler urun = new Urunler(id, urunBasligi, marka, urunFiyati, urunIndirimliFiyati, kargoBilgisi, kargoTeslimat, urunAciklamasi);
				urunler.add(urun);
			}
			return urunler;

		} catch (SQLException e) {
			System.out.println("Islem gerceklestirilmedi.SQL hatasi. Error code hatasi " + e);
			return null;
		}
	}
	
	/**
	 * Sepet sayfa uzerinden secilen urunun id 'sini alir ve veri tabanindan secilen kayitin bilgilerini listeye ekler.
	 * @param int tipinde p_id alir.
	 * @return urunler ile dolu olan listeyi doner.
	 */
	public static List<SepetUrunler> secilenSepetKayitiAl(int p_id) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM URUNLER WHERE ID=" + p_id;
			ResultSet resultSet = komut.executeQuery(sql);
			
			List<SepetUrunler> sepetUrunler = new ArrayList<SepetUrunler>();
			
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String urunBasligi = resultSet.getString(2);
				String marka = resultSet.getString(3);
				float urunFiyati = resultSet.getFloat(4);
				float urunToplamFiyati = resultSet.getFloat(5);
				urunToplamFiyati = 0;
			
				SepetUrunler sepetUrun = new SepetUrunler(SepetUrunler.ID++, urunBasligi, marka, urunFiyati, urunToplamFiyati);
				sepetUrunEkle(sepetUrun);
				sepetUrunler.add(sepetUrun);
			}
			return sepetUrunler;

		} catch (SQLException e) {
			System.out.println("Islem gerceklestirilmedi.SQL hatasi. Error code hatasi " + e);
			return null;
		}
	}
	
	/**
	 * SepetUrunler class 'inda getterlar yardimiyla sepetteki urunler ile ilgili bilgiler alir.
	 * @param SepetUrunler class 'ından olusmus bir degisken alir paremetre olarak
	 * @return	sepetUrunEkle method'una gonderir.
	 */
	public static boolean sepetUrunEkle(SepetUrunler urun) {
		return sepetUrunEkle(urun.getId(), urun.getUrunBasligi(), urun.getMarka(), urun.getUrunFiyati(), urun.getUrunToplamFiyati());
	}

	/**
	 * sepetUrunEkle methodundan gelen verileri veritabanina sepet_urunler tablosuna insert eder.
	 * @param id sepetteki urunun id'si int tipinde
	 * @param urunBasligi sepetteki urunun basligi string tipinde
	 * @param marka sepetteki urunun markasi string tipinde
	 * @param urunFiyati sepetteki urunun fiyati float tipinde
	 * @param urunToplamFiyati sepetteki urunun toplam fiyati float tipinde
	 * @return olarak boolean doner.
	 */
	public static boolean sepetUrunEkle(int id, String urunBasligi, String marka, float urunFiyati, float urunToplamFiyati) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "INSERT INTO SEPET_URUNLER VALUES (" + id + ",'" + urunBasligi + "', '"+ marka +"', " + urunFiyati + ", " + urunToplamFiyati +" )";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("INSERT hatasi: " + e);
			return false;
		}
		return true;
	}
	
	/*-------------------------------- SEPET ISLEM BOLUMU / SONU ----------------------------*/
	
	/*-------------------------------- TABLO SILME ISLEM BOLUMU ----------------------------*/
	
	/**
	 * Cagrildiginda urunler tablosunu drop eder ve bilgilendirme mesaji basar. Hata ile karsilasinca hata mesajını basar.
	 * @return olara boolean doner
	 */
	public static boolean tabloSilUrunler() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "DROP TABLE URUNLER";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error code " + e);
			return false;
		}
		System.out.println("Basarili bir sekilde drop edildi.");
		return true;
	}
	
	/**
	 * Cagrildiginda sepet_urunler tablosunu drop eder ve bilgilendirme mesaji basar. Hata ile karsilasinca hata mesajını basar.
	 * @return olara boolean doner
	 */
	public static boolean tabloSilSepetUrunler() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "DROP TABLE SEPET_URUNLER";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Error code " + e);
			return false;
		}
		System.out.println("Basarili bir sekilde drop edildi.");
		return true;
	}
	
	/*-------------------------------- TABLO SILME ISLEM BOLUMU / SONU ----------------------------*/
}
