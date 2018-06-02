package spark.template.freemarker.ismailsahin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Veritabani baglant�lar� ve fonksiyonlar� tutar..
 * @author bilgisayar
 *
 */
public class VeriTabani {
	private static final String VERITABANI_DIZINI = ".\\.veritabani\\";
    private static final String VERITABANI_URL = "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";
	
    private static final String ID = "ID";
    private static final String KITAP_ADI = "KITAP_ADI";
    private static final String YAZAR_ADI = "YAZAR_ADI";
    private static final String FIYAT = "FIYAT";
    private static final String SAYFA_SAYI = "SAYFA_SAYI";
    
    private static final String CREATE_KITAPLAR_TABLE = "CREATE TABLE KITAPLAR"
			+ "(" + ID + " INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
			+ KITAP_ADI + " VARCHAR(100)," + YAZAR_ADI + " VARCHAR(100)," + FIYAT +  " INT," + SAYFA_SAYI + " INT)";
    
    private static final String CREATE_SIPARISLER_TABLE = "CREATE TABLE SIPARIS(ID INT,"
    							+ "ADRES VARCHAR(300))";
    
    private static final String CREATE_SIPARIS_DETAY_TABLE = "CREATE TABLE SIPARIS_DETAY(SIPARIS_ID INT,KITAP_ID INT,ADET INT"
    							+ ")";
    
    private static ArrayList<Kitap> kitapList;
    
    private static Connection conn;
    private static Statement stmt;
    
    private static boolean veritabaniAcikMi = false;
    
	
	public VeriTabani() {
		
	}
	
	/**
	 * Veri taban�ndan kitaplar� list olarak doner
	 * @return kitapArrayList
	 * @throws Exception
	 */
	public ArrayList<Kitap> getKitapList() throws Exception {
		kitapList = new ArrayList();
    	
    	if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM KITAPLAR");
		while (rs.next()) {
			int id = rs.getInt(ID);
			int sayfaSayisi = rs.getInt(SAYFA_SAYI);
			int fiyat = rs.getInt(FIYAT);
			String kitapAdi = rs.getString(KITAP_ADI);
			String yazar = rs.getString(YAZAR_ADI);
			kitapList.add(new Kitap(id, kitapAdi, yazar, fiyat, sayfaSayisi));
		}
		
		veritabaniKapat();
    	return kitapList;
	}
	
	/**
	 * Veritaban�na kitap eklrt
	 * @param kitapAdi kitap adi
	 * @param yazar yazar adi
	 * @param fiyat fiyat
	 * @param sayfaSayisi sayfa
	 * @throws Exception
	 */
	public static void kitapEkle(String kitapAdi, String yazar, int fiyat, int sayfaSayisi) throws Exception{
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}

		try {
			String insertQuery = "INSERT INTO KITAPLAR(" + KITAP_ADI + "," + YAZAR_ADI + "," + SAYFA_SAYI + "," + FIYAT + ")" + " VALUES(" + "\'"
					+ kitapAdi + "\'" + "," + "\'" + yazar + "\'" + "," + sayfaSayisi + "," + fiyat + ")";
			stmt.executeUpdate(insertQuery);
			System.out.println("Ogrenci veritaban�na eklendi..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		veritabaniKapat();
	}
	
	/**
	 * Veritaban�ndan kitap siler.
	 * @param id kitap id
	 * @throws Exception
	 */
	public static void kitapSil(int id) throws Exception {
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		stmt.executeUpdate("DELETE FROM KITAPLAR WHERE " + ID + "=" + id);
		System.out.println("Ba�ar�yla silindi..");
		veritabaniKapat();
	}
	
	/**
	 * Kitap adi bilgisi doner
	 * @param id kitap id
	 * @return
	 * @throws Exception
	 */
	public String getKitapAdi(int id) throws Exception {
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		String Query = "SELECT KITAP_ADI FROM KITAPLAR WHERE" + " " + ID + "=" + id;
		
		ResultSet rs = stmt.executeQuery(Query);
		rs.next();
		
		String kitapAdi = rs.getString(KITAP_ADI);
		veritabaniKapat();
		return kitapAdi;
	}
	
	/**
	 * Kitap objesi doner
	 * @param id kitap id
	 * @return kitap
	 * @throws Exception
	 */
	public Kitap getKitap(int id) throws Exception {
    	if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM KITAPLAR WHERE" + " " + ID + "=" + id);
		rs.next();
		
		int kitapId = rs.getInt(ID);
		int sayfaSayisi = rs.getInt(SAYFA_SAYI);
		int fiyat = rs.getInt(FIYAT);
		String kitapAdi = rs.getString(KITAP_ADI);
		String yazar = rs.getString(YAZAR_ADI);
		
		Kitap kitap = new Kitap(kitapId, kitapAdi, yazar, fiyat, sayfaSayisi);

		veritabaniKapat();
    	return kitap;
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void veritabaniHazirla() throws Exception{
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		veritabaninaBaglan();
		tablolariOlustur();
	}
	
	/**
	 * Veritabn�na baglan�r.
	 * @throws Exception
	 */
	private static void veritabaninaBaglan() throws Exception {
		conn = DriverManager.getConnection(VERITABANI_URL);
		stmt = conn.createStatement();
		veritabaniAcikMi = true;
	}
	
	/**
	 * Veritaban� tablolar� olusturur.
	 * @throws Exception
	 */
	private void tablolariOlustur() throws Exception{
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		try {
			stmt.execute(CREATE_KITAPLAR_TABLE);
			ornekKitaplarEkle();
			System.out.println("kitaplar tablosu olu�uturuldu..");
		} catch (SQLException e) {
			System.out.println("Hata: " + e.getMessage());
		}
		
		try {
			stmt.execute(CREATE_SIPARISLER_TABLE);
			System.out.println("Siparis tablosu olu�uturuldu..");
		} catch (SQLException e) {
			System.out.println("Hata: " + e.getMessage());
		}
		
		try {
			stmt.execute(CREATE_SIPARIS_DETAY_TABLE);
			System.out.println("Siparis detay tablosu olu�uturuldu..");
		} catch (SQLException e) {
			System.out.println("Hata: " + e.getMessage());
		}
		
		veritabaniKapat();
	}

	/**
	 * Veritaban�na ornek kitap verisi ekler.
	 * @throws SQLException
	 */
	public void ornekKitaplarEkle() throws SQLException {
		String INSERT = "INSERT INTO KITAPLAR(" + KITAP_ADI + "," + YAZAR_ADI + "," + SAYFA_SAYI + "," + FIYAT + ")" + 
						" VALUES(\'A�k-� Memnu\',\'Halit Ziya U�akl�gil\'," +
						"100,10)";
		stmt.execute(INSERT);
		
		INSERT = "INSERT INTO KITAPLAR(" + KITAP_ADI + "," + YAZAR_ADI + "," + SAYFA_SAYI + "," + FIYAT + ")" + 
				" VALUES(\'Kuyucakl� Yusuf\',\'Sabahattin Ali\'," +
				"150,15)";
		stmt.execute(INSERT);
		
		INSERT = "INSERT INTO KITAPLAR(" + KITAP_ADI + "," + YAZAR_ADI + "," + SAYFA_SAYI + "," + FIYAT + ")" + 
				" VALUES(\'Yaban\',\'Yakup Kadri Karaosmano�lu\'," +
				"125,20)";
		stmt.execute(INSERT);
	}
	
	/**
	 * Veritaban� ac�ksa kapat�r
	 * @throws Exception
	 */
	private static void veritabaniKapat() throws Exception{
		if (veritabaniAcikMi == true) {
			conn.close();
			stmt.close();
			veritabaniAcikMi = false;
		}
	}
	
	/**
	 * Veritaban�na siparis ekler
	 * @param siparis siparis
	 * @throws Exception
	 */
	public void siparisEkle(Siparis siparis) throws Exception {
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		HashMap<Integer, Integer> urunList = siparis.getUrunList();
		String adres = siparis.getAdres();
		
		ResultSet rs = stmt.executeQuery("SELECT COUNT(ID) count FROM SIPARIS");
		rs.next();
		int siparis_id = rs.getInt("count");
		siparis_id++;
		
		try {
			String INSERT_YENI_SIPARIS = "INSERT INTO SIPARIS (ID,ADRES) VALUES(" + siparis_id + "," + "\'" + adres + "\')";
			stmt.execute(INSERT_YENI_SIPARIS);
			
			for (Integer id : urunList.keySet()) {
				String INSERT_SIPARIS_DETAY = "INSERT INTO SIPARIS_DETAY (SIPARIS_ID,KITAP_ID,ADET) VALUES(" + siparis_id
											+ "," + id + "," + urunList.get(id) + ")";
				stmt.execute(INSERT_SIPARIS_DETAY);
			}
			System.out.println("Siparis veritaban�na eklendi..");
		} catch (Exception e) {
			System.out.println("Siparis eklerken hata oldu.." + e.getMessage());
		}
		
		veritabaniKapat();
	}
	
	/**
	 * Veritaban�ndan siparisleri liste olarak doner
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Siparis> siparisList() throws Exception{
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		ArrayList<Siparis> siparisList = new ArrayList<Siparis>();
		try {
			ArrayList<Integer> siparislerList = new ArrayList<Integer>();
			
			ResultSet rs = stmt.executeQuery("SELECT ID FROM SIPARIS");
			while(rs.next()) {
				int id = rs.getInt("ID");
				siparislerList.add(id);
			}
			
			for (Integer i : siparislerList) {
				HashMap<Integer, Integer> urunlerList = new HashMap<Integer, Integer>();
				rs = stmt.executeQuery("SELECT KITAP_ID,ADET FROM SIPARIS_DETAY WHERE SIPARIS_ID = " + i);
				while(rs.next()) {
					int kitap_id = rs.getInt("KITAP_ID");
					int adet = rs.getInt("ADET");
					urunlerList.put(kitap_id, adet);
				}
				
				rs = stmt.executeQuery("SELECT ADRES FROM SIPARIS WHERE ID = " + i);
				rs.next();
				String adres = rs.getString("ADRES");
				
				Siparis siparis = new Siparis();
				siparis.setUrunList(urunlerList);
				siparis.setAdres(adres);
				siparisList.add(siparis);
			}
		} catch (Exception e) {
			System.out.println("siparis listeleme hatas� \n" + e.getMessage() + "\n");
			e.printStackTrace();
		}
		
		veritabaniKapat();
		return siparisList;
	}
}
