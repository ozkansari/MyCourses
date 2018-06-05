package tr.edu.medipol.odevler3.keremarca.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.edu.medipol.odevler3.keremarca.setget.ogrenciSetGet;

public class ogrenciDB {
	
	private static final String VERITABANI_DIZINI=".\\.keremarca\\odev2\\";
	
	private static final String VERITABANI_URL="jdbc:derby:" + VERITABANI_DIZINI + ";create=true";
	
	public static void main(String[] konsolParametreleri) throws Exception{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
	}
	
	public Connection getConnection() {
		Connection baglanti = null;
		
		try {
			baglanti = DriverManager.getConnection(VERITABANI_URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return baglanti;
	}
	
	public ogrenciDB() {
		Tablo();
	}
	
	public void Tablo() {
		Connection baglanti = getConnection();
		
		try {
			Statement sorgu = baglanti.createStatement();
			sorgu.executeUpdate("CREATE TABLE ogrenciler (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY "
					+ "(START WITH 1, INCREMENT BY 1),"
					+ "adsoyad VARCHAR(30),"
					+ "bolum VARCHAR(30),"
					+ "girisyili VARCHAR(30))");
		} catch (SQLException e) {
			System.out.print("Tablo Zaten Var!");
		}
	}
	
	public void yeniKayit(ogrenciSetGet yeniKayit) {
		Connection baglanti = getConnection();
		
		try {
			Statement sorgu = baglanti.createStatement();
			sorgu.executeUpdate("INSERT INTO ogrenciler (adsoyad, bolum, girisyili) VALUES ('" +yeniKayit.getAdsoyad()+ "', '" +yeniKayit.getBolum()+ "', '"+yeniKayit.getGirisyili()+"'  )");
		} catch (SQLException e) {
			System.out.print("Kay�t Zaten Var!");
		}
		
	}
	
	public List<ogrenciSetGet> listele(){
		
		List<ogrenciSetGet> list = new ArrayList<ogrenciSetGet>();
		Connection baglanti = getConnection();
		try {
			Statement sorgu = baglanti.createStatement();
			ResultSet rs = sorgu.executeQuery("SELECT * FROM ogrenciler");
			while(rs.next()) {
				ogrenciSetGet yeniListe = new ogrenciSetGet(); 
				
				yeniListe.setId(rs.getInt("id"));
				yeniListe.setAdsoyad(rs.getString("adsoyad"));
				yeniListe.setBolum(rs.getString("bolum"));
				yeniListe.setGirisyili(rs.getString("girisyili"));

				
				list.add(yeniListe);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
}
