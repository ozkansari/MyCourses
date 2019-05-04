package tr.edu.medipol.ilerijava.ders10.http;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Veritabani {

	public static Statement veritabaninaBaglan() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			String url = "jdbc:derby:"	 // jdbc araciligiyla derby veritabanina baglanacagimizi soyluyoruz (protocol)
					+ "./.veritabani1/;" // veritabani dosyalari ./veritabani1/ dizininde tutulacak.
					+ "create=true;";	 // veritabani eger mevcut degilse olusturmasini soyler
			Connection veritabaniBaglantisi = DriverManager.getConnection(url);
			return veritabaniBaglantisi.createStatement();
		} catch(Exception e) {
			System.out.printf("Veritabanina baglanirken hata alindi %s %n", e.getMessage());
			return null;
		}
	}
	
	public static void tablolariOlustur(Statement veritabaniKomutCalistirici) {
		// CREATE TABLE - Tablo Olustur - Sadece ilk defa calistiginda basarili calisir
		try  {
			String createTableSql = "CREATE TABLE ogrenciler ( isim varchar(40), yas int)";
			veritabaniKomutCalistirici.executeUpdate(createTableSql);
		} catch(Exception e) {
			System.out.println("Tablo zaten mevcut olabilir. " + e.getMessage());
		}
	}
	
	public static List<String> ogrenciListesiniAl(Statement veritabaniKomutCalistirici) {
		// SELECT : Veritabanini sorgula, sonuclari goster
		List<String> ogrenciListesi = new ArrayList<>();
		try  {
			ResultSet sonuclar = veritabaniKomutCalistirici.executeQuery(
				"SELECT * FROM ogrenciler"
			);
			while(sonuclar.next()) {
				String sonucIsim = sonuclar.getString("isim");
				int sonucYas = sonuclar.getInt(2);
				ogrenciListesi.add(sonucIsim + " " + sonucYas);
			}
			
		} catch(Exception e) {
			System.out.printf("Verileri veritabanindan alirken hata %s %n", e.getMessage());
		}
		return ogrenciListesi;
	}
	
	public static void ogrenciEkle(Statement veritabaniKomutCalistirici, String isim, String yas) {
		try {
			// INSERT INTO : Veritabanina kaiyt ekle
			veritabaniKomutCalistirici.executeUpdate(
				"INSERT INTO ogrenciler VALUES ('" + isim + "', " + yas + ")"
			);
		} catch(Exception e) {
			System.out.printf("Veritabanina veri yazarken hata %s %n", e.getMessage());
		}
	}
}
