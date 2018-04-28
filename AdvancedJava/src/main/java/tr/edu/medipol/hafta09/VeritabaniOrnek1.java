package tr.edu.medipol.hafta09;

import java.sql.*;

import org.apache.derby.tools.sysinfo;

/*--
Maven icin JDK gerekli. 
Eclipse'de JDK tanimli mi bakmak icin: 
	Windows>Preferences. 
	"jre" arat. 
	Installed JRE's tikla. 
	Burada JDK gormelisin. 
	Gormuyorsan ekle'den directories sec ve jdk kurulu dizini sec.
	
Create Project > Other : Maven Project
"Create a simple..." checkbox tikla ve next
Group: tr.edu.medipol, Artifact ID: VeritabaniProjesi

Pom.xml dosyasini ac, en alttan sagdaki pom.xml tabina tikla.
Maven pom.xml dosyasinda <project></project> tnagleri arasina ekle:

	<dependencies>
	
	    <dependency>
	      <groupId>org.apache.derby</groupId>
	      <artifactId>derby</artifactId>
	      <version>10.11.1.1</version>
	    </dependency>
    
    <dependencies>
    
Proje'ye sag tikla. Run>Maven Install

src/main/java altina new class VeritabaniOrnek1
*/
public class VeritabaniOrnek1 {

	private static final String VERITABANI_DIZINI = 
			".\\.veritabani\\";
	
    private static final String VERITABANI_URL = 
    		"jdbc:derby:" + VERITABANI_DIZINI + ";create=true";

	public static void main(String[] konsolParametreleri) throws Exception {
		System.out.println(VERITABANI_URL);
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		Connection conn = DriverManager.getConnection(VERITABANI_URL);
		
		Statement stmt = conn.createStatement();
		
		String tabloAdi = "ogrenciler";
		
		// TABLO OLUSTURMA ISLEMI
		try {
			stmt.executeUpdate(
					"CREATE TABLE " + tabloAdi + " ("
					+  "ogrenci_id int primary key, "
					+  "ad_soyad varchar(30)"
					+ ")"
			);
			System.out.println("Tablo " + tabloAdi + " olusturuldu");
		} catch(Exception e) {
			// zaten tablo varsa hata verir
			System.out.println("Tablo " + tabloAdi + " zaten mevcut " + e.getMessage());
		}
        
		// KAYIT EKLE
		try {
			stmt.executeUpdate(
					"INSERT INTO " + tabloAdi + " VALUES ("
					+  "3 ,"
					+  "\'Duygu Hercai\'"
					+ ")"
			);
			System.out.println("Kayit eklendi");
		} catch(Exception e) {
			// zaten ayni id'Li kayit varsa hata verebilir.
			System.out.println("Kayit zaten mevcut. Hata: " + e.getMessage());
		}
		
		// KAYIT SORGULA
	    ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabloAdi);
		while (rs.next()) {
			int ogrenciId = rs.getInt("ogrenci_id");
			String adSoyad = rs.getString("ad_soyad");
			System.out.println(ogrenciId + " " + adSoyad);
		}
	    
		conn.close();
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	

}
