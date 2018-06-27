package spark.template.freemarker.betulozdemir_but;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class Betul_Ozdemir_VeriTabani<kullanici> {
	private static final String VERITABANI_DIZINI = ".\\.veritabani\\";
    private static final String VERITABANI_URL = "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";
	
    private static final String ID= "ID";
    private static final String KULLANİCİ_ADİ= "KULLANİCİ_ADİ";
    private static final String KULLANİCİ_TİPİ = "KULLANİCİ_TİPİ";
    private static final String YAS = "YAS";
    private static final String CİNSİYET = "CİNSİYET";
    private static final String SİFRE = "SİFRE";
    
    private static final String CREATE_KULLANİCİLAR_TABLE = "CREATE TABLE KULLANİCİLAR"
			+ "(" + ID + " INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),"
			+ KULLANİCİ_ADİ + " VARCHAR(100)," + KULLANİCİ_TİPİ + " VARCHAR(100)," + YAS +  " INT," + CİNSİYET + " VARCHAR(100)," + SİFRE + " VARCHAR(100)";
	private static final Betul_Ozdemir_VeriTabani kullanici = null;
    
 private static ArrayList<Betul_Ozdemir_VeriTabani> kullaniciList;
    
    private static Connection conn;
    private static Statement stmt;
    
    private static boolean veritabaniAcikMi = false;
    
	
	public void VeriTabani() {
		
	}


	public ArrayList<kullanici> getKullaniciList() throws Exception {
		kullaniciList = new ArrayList();
    	
    	if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM KULLANİCİLAR");
		while (rs.next()) {
			String kullaniciAdi = rs.getString(KULLANİCİ_ADİ);
			String kullaniciTipi = rs.getString(KULLANİCİ_TİPİ);
			int yas=rs.getInt(YAS);
			String ecinsiyet=rs.getString(CİNSİYET);
			String sifre=rs.getString(SİFRE);
			kullaniciList.add (new Betul_Ozdemir_VeriTabani());
		}
		
		veritabaniKapat();
    	return (ArrayList<kullanici>) kullaniciList;

	}
	private static void veritabaniKapat() {
		// TODO Auto-generated method stub
		
	}

	public static void kullaniciSil(String kullaniciAdi) throws Exception {
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		stmt.executeUpdate("DELETE FROM KULLANİCİLAR WHERE " + KULLANİCİ_ADİ+ "=" + kullaniciAdi);
		System.out.println("Başarıyla silindi..");
		veritabaniKapat();
	}
	

	public String getKullaniciAdi(String kullaniciAdi) throws Exception {
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		String Query = "SELECT KULLANİCİ_ADİ FROM KULLANİCİLAR WHERE" + " " + KULLANİCİ_ADİ + "=" + kullaniciAdi;
		
		ResultSet rs = stmt.executeQuery(Query);
		rs.next();
		
		String KULLANİCİ_ADİ = rs.getString(kullaniciAdi);
		veritabaniKapat();
		return kullaniciAdi;
	}
	

	
	public Betul_Ozdemir_VeriTabani getKullanici(String kullaniciAdi) throws Exception {
    	if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM KULLANİCİLAR WHERE" + " " + KULLANİCİ_ADİ + "=" + kullaniciAdi);
		rs.next();
		
		String kullaniciAdi1= rs.getString(KULLANİCİ_ADİ);
		String kullaniciTipi = rs.getString(KULLANİCİ_TİPİ);
		int yas=rs.getInt(YAS);
		String cinsiyet=rs.getString(CİNSİYET);
		String sifre=rs.getString(SİFRE);
		kullaniciList.add(new Betul_Ozdemir_VeriTabani());
	

		veritabaniKapat();
    	return kullanici;
	}

	public void veritabaniHazirla() throws Exception{
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		veritabaninaBaglan();
		tablolariOlustur();
	}
	

	private static void veritabaninaBaglan() throws Exception {
		conn = DriverManager.getConnection(VERITABANI_URL);
		stmt = conn.createStatement();
		veritabaniAcikMi = true;
	}
	

	private void tablolariOlustur() throws Exception{
		if (veritabaniAcikMi == false) {
			veritabaninaBaglan();
			veritabaniAcikMi = true;
		}
		
		try {
			stmt.execute(CREATE_KULLANİCİLAR_TABLE);
			System.out.println("kullanici tablosu olu�uturuldu..");
		} catch (SQLException e) {
			System.out.println("Hata: " + e.getMessage());
		}
		

		veritabaniKapat();
	}
}
    