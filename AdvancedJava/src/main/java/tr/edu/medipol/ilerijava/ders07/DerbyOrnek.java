package tr.edu.medipol.ilerijava.ders07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DerbyOrnek {
	public static void main(String[] args) 
			throws Exception {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		
		Connection veritabaniBaglantisi = DriverManager.getConnection(
				"jdbc:derby:"
				// + ".\\.veritabani1\\" // windows ortami icin
				+ "./.veritabani1/"
				+ ";create=true;"
				);
		
		Statement veritabaniSorguStmt = veritabaniBaglantisi.createStatement();
		
		try  {
			veritabaniSorguStmt.executeUpdate(
					"CREATE TABLE "
							+ "ogrenciler ("
								+ "id int primary key, "
								+ "isim varchar(40)"
							+ ")"
			);
		} catch(Exception e) {
			System.out.println("Tablo zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
		}
		
		ResultSet sonuclarCount = veritabaniSorguStmt.executeQuery("SELECT max(id) maxid FROM ogrenciler");
		int count = 0;
		while(sonuclarCount.next()) {
			count = sonuclarCount.getInt("maxid");
			System.out.println("Max id: " + count);
		}
		
		try  {
			/*
			veritabaniSorguStmt.executeUpdate("DELETE from ogrenciler WHERE id < 10000");
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( 1, 'Mehmet Hercai' )");
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( 2, 'Ahmet Hercai' )");
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( 3, 'Zeynep Hercai' )");
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( 4, 'Efkan Idris' )");
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( 5, 'Osman Cansiz' )");
			*/
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( "
					+ (count + 1)
					+ ", '"
					+ "Ali Demir"
					+ "' )");
		} catch(Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
		
		ResultSet sonuclar = veritabaniSorguStmt.executeQuery("SELECT * FROM ogrenciler WHERE id > 2");
		while(sonuclar.next()) {
			int id = sonuclar.getInt("id");
			String isim = sonuclar.getString("isim");
			System.out.println(id + " " + isim);
		}
	}
}
