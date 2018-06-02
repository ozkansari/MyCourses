package tr.edu.medipol.odevler2.ismail_sahin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Veritaban� ba�lant�s�n�, kontrolunu sa�lar..
 * @author bilgisayar
 *
 */
public class Veritabani{
	private static final String VERITABANI_DIZINI = ".\\.veritabani\\";
    private static final String VERITABANI_URL = "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";
	
    private static final String ID = "OGRENCI_ID";
    private static final String AD_SOYAD = "AD_SOYAD";
    private static final String BOLUM = "OKUDUGU_BOLUM";
    private static final String YIL = "GIRIS_YILI";
    
    private static final String CREATE_OGRENCI_TABLE = "CREATE TABLE ogrenci"
			+ "(" + ID + " INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
			+ AD_SOYAD + " VARCHAR(60)," + BOLUM + " VARCHAR(50)," + YIL +  " INT)";
    
    private static ArrayList<Ogrenci> ogrenciList;
    
    private static Connection conn;
    private static Statement stmt;
    
    private static boolean veritabaniAcikMi = false;
    
    /**
     * Veritaban�ndaki ��rencileri d�ner.
     * @return - ��renciList d�ner.
     * @throws Exception
     */
    public static ArrayList<Ogrenci> getOgrenciList() throws Exception {
    	ogrenciList = new ArrayList<>();
    	
    	if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM ogrenci");
		while (rs.next()) {
			int ogrenciId = rs.getInt(ID);
			String adSoyad = rs.getString(AD_SOYAD);
			String bolumu = rs.getString(BOLUM);
			int girisYili = rs.getInt(YIL);
			ogrenciList.add(new Ogrenci(ogrenciId, girisYili, adSoyad, bolumu));
		}
		veritabaniKapat();
    	return ogrenciList;
	}
    
    /**
     * Veritaban� constructor�.
     */
	public Veritabani() {
		
	}
	
    /**
     * Veritaban�n� haz�rlar..
     * @throws Exception
     */
	public void veritabaniHazirla() throws Exception{
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		veritabaninaBaglan();
		tablolariOlustur();
	}
	
	/**
	 * ��renciler tablosunu olu�turur.
	 * @throws Exception
	 */
	private void tablolariOlustur() throws Exception{
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		try {
			stmt.execute(CREATE_OGRENCI_TABLE);
			System.out.println("ogrenciler tablosu olu�uturuldu..");
		} catch (SQLException e) {
			System.out.println("Hata: " + e.getMessage());
		}
		veritabaniKapat();
	}

	/**
	 * Veritaban�na ba�lan�r.
	 * @throws Exception
	 */
	private static void veritabaninaBaglan() throws Exception {
		conn = DriverManager.getConnection(VERITABANI_URL);
		stmt = conn.createStatement();
		veritabaniAcikMi = true;
		System.out.println("Veritaban�na ba�land�..");
	}
	
	/**
	 * A��k olan veritaban�n� kapat�r..
	 * @throws Exception
	 */
	private static void veritabaniKapat() throws Exception{
		if (veritabaniAcikMi == true) {
			conn.close();
			stmt.close();
			veritabaniAcikMi = false;
			System.out.println("Veritabani kapand�..");
		}
	}

	/**
	 * Veritaban�na ��renci ekler.
	 * @param adiSoyadi - ��rencinin ad� soyad� bilgisi
	 * @param bolumu - ��rencinin b�l�m� bilgisi
	 * @param girisYili - giri� y�l� bilgisi
	 * @throws Exception
	 */
	public static void ogrenciEkle(String adiSoyadi, String bolumu, int girisYili) throws Exception{
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}

		try {
			String insertQuery = "INSERT INTO ogrenci(" + AD_SOYAD + "," + BOLUM + "," + YIL + ")" + " VALUES(" + "\'"
					+ adiSoyadi + "\'" + "," + "\'" + bolumu + "\'" + "," + girisYili + ")";
			stmt.executeUpdate(insertQuery);
			System.out.println("Ogrenci veritaban�na eklendi..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		veritabaniKapat();
	}
	
	/**
	 * Verilen id'deki kayd� veritaban�ndan siler.
	 * @param id - silinecek kayd�n id'si
	 * @throws Exception
	 */
	public static void ogrenciSil(int id) throws Exception {
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		stmt.executeUpdate("DELETE FROM ogrenci WHERE " + ID + "=" + id);
		System.out.println("Ba�ar�yla silindi..");
		veritabaniKapat();
	}
	
}