package tr.edu.medipol.ilerijava.ders09.db;

import java.sql.*;
import java.util.*;

// https://db.apache.org/derby/papers/DerbyTut/embedded_intro.html

public class DerbyVeritabaniOrnek1 {

	public static void main(String[] args) throws Exception {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		
		String url = "jdbc:derby:./.veritabani1/;create=true;";
		Connection veritabaniBaglantisi = DriverManager.getConnection(url);
		
		Statement veritabaniKomutu = veritabaniBaglantisi.createStatement();
		
		// CREATE TABLE - Tablo Olustur - Sadece ilk defa calistiginda basarili calisir
		try  {
			String createTableSql = "CREATE TABLE ogrenciler ( isim varchar(40), yas int)";
			veritabaniKomutu.executeUpdate(createTableSql);
		} catch(Exception e) {
			System.out.println("Tablo zaten mevcut" + e.getMessage());
		}
		
		// Konsoldan oku
		Scanner consolOkuyucu = new Scanner(System.in);
		System.out.println("Isim Gir ve Enter'a bas: ");
		String isim = consolOkuyucu.nextLine();
		// INSERT INTO : Veritabanina kaiyt ekle
		veritabaniKomutu.executeUpdate(
				"INSERT INTO ogrenciler VALUES ('" + isim + "', 21)"
		);
		
		// SELECT : Veritabanini sorgula, sonuclari goster
		ResultSet sonuclar = veritabaniKomutu.executeQuery(
				"SELECT * FROM ogrenciler WHERE yas>=18"
		);
		while(sonuclar.next()) {
			String sonucIsim = sonuclar.getString("isim");
			int sonucYas = sonuclar.getInt(2);
			System.out.println(sonucIsim + " " + sonucYas);
		}
	}

}
