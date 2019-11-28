package tr.edu.medipol.ilerijava.ders06.lab;
import java.sql.*;
import java.util.*;

public class VeritabaniOrnek1 {

	public static void main(String[] args) throws Exception {
		
		String jdbcUrl = "jdbc"
				+ ":derby:" // derby veritabanina baglaniyoruz
				+ "./.veritabani1" // C:\\temp gibi bir dizin
				+ ";create=true";
		Connection veritabaniBaglantisi = DriverManager.getConnection(jdbcUrl);
		System.out.printf("Veritabanina baglandi: %s %n", veritabaniBaglantisi.toString()); 
		
		Statement veritabaniKomutu = veritabaniBaglantisi.createStatement();
		
		// CREATE TABLE
		try {
			String sql = "CREATE TABLE ogrenciler ( isim varchar(40), yas int)";
			veritabaniKomutu.executeUpdate(sql);
		} catch(Exception e) {
			System.out.println("Tablo zaten var olabilir:" + e.getMessage());
		}
		
		// import java.util.*; unutma
		Scanner konsolOkuyucu = new Scanner(System.in);
		System.out.println("isim ve yas gir. Ornek: Ali 23");
		String kullaniciGiris = konsolOkuyucu.nextLine();
		String [] girdiler = kullaniciGiris.split(" ");
		String isim = girdiler[0];
		int yas = Integer.parseInt( girdiler[1] );
		
		String insertSql1 = String.format("INSERT INTO ogrenciler VALUES('%s',%d)", isim, yas);
		veritabaniKomutu.executeUpdate(insertSql1);
		
		ResultSet sonuclar = veritabaniKomutu.executeQuery("SELECT * FROM ogrenciler");
		while(sonuclar.next()) {
			String sonucIsim = sonuclar.getString("isim");
			int sonucYas = sonuclar.getInt(2);
			System.out.printf("%s %d %n", sonucIsim, sonucYas);
		}
	}

}
