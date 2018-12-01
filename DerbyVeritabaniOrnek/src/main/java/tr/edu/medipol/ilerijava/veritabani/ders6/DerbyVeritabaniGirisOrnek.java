package tr.edu.medipol.ilerijava.veritabani.ders6;

import java.sql.*;

public class DerbyVeritabaniGirisOrnek {

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
		/*
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
		
		try  {
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( 1, 'Mehmet Hercai' )");
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( 2, 'Ahmet Hercai' )");
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( 3, 'Zeynep Hercai' )");
		} catch(Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
		*/
		ResultSet sonuclar = veritabaniSorguStmt.executeQuery("SELECT * FROM ogrenciler WHERE id=2");
		while(sonuclar.next()) {
			int id = sonuclar.getInt("id");
			String isim = sonuclar.getString("isim");
			System.out.println(id + " " + isim);
		}
	}
}
