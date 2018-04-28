package tr.edu.medipol.hafta09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*--
    Maven pom.xml dependency:
    
        <dependency>
          <groupId>org.apache.derby</groupId>
          <artifactId>derby</artifactId>
          <version>10.11.1.1</version>
        </dependency>
 */

// http://shengwangi.blogspot.com.tr/2015/10/how-to-use-embedded-java-db-derby-in-maven.html
public class VeritabaniOrnek0 {

    // memory: veritabani hafizada olusturulacak
    // private static final String VERITABANI_URL =
    // "jdbc:derby:memory:demo;create=true";

    // Dosya tabanli veritabani, yoksa olustur
    private static final String VERITABANI_DIZINI = ".\\.veritabani\\";
    private static final String VERITABANI_URL = "jdbc:derby:" + ".\\.veritabani\\" + ";create=true";

    private static Connection veritabaniBaglantisi = null;

    private static Statement veritabaniIfadesi = null;
    
    private static int mevcutOgrenciSayisi = 0;

    public static void main(String[] konsolParametreleri) throws SQLException {
        
        veritabaniBaglantisi = baglantiKur();
        veritabaniIfadesi = veritabaniBaglantisi.createStatement();
        
        boolean yeniVeritabani = tabloOlustur();
        mevcutOgrenciSayisi = mevcutOgrenciSayisiniAl();
        
        tabloyaKayitEkle();
        tabloyuSorgula();
        
        baglantiyiKapat();
    }

    
    private static boolean tabloOlustur() throws SQLException {
    
        // Veritabani tablosunu yoket
        // stmt.executeUpdate("Drop Table users");

        // Veritabani tablosu olustur
        try {
            veritabaniIfadesi.executeUpdate("Create table ogrenciler (ogrenci_id int primary key, ad_soyad varchar(30))");
            return true;
        } catch(SQLException e) {
            // Tablo zaten var
            return false;
        }
    }
    
    private static int mevcutOgrenciSayisiniAl() throws SQLException {
        ResultSet sorguSonucu = veritabaniIfadesi.executeQuery("SELECT max(ogrenci_id) maks_id FROM ogrenciler");
        sorguSonucu.next();
        int sonucDegeri = sorguSonucu.getInt("maks_id");
        return sonucDegeri;
    }
    
    private static void tabloyaKayitEkle() throws SQLException {

        // Veritabani tablosuna kayit ekle
        mevcutOgrenciSayisi++;
        veritabaniIfadesi.executeUpdate("insert into ogrenciler values (" + mevcutOgrenciSayisi + ",'Kadir Kadiroglu')");
        mevcutOgrenciSayisi++;
        veritabaniIfadesi.executeUpdate("insert into ogrenciler values (" + mevcutOgrenciSayisi + ",'Hatice Aferin')");

    }
    
    private static void tabloyuSorgula() throws SQLException {

        // Veritabanina sorgu at
        ResultSet rs2 = veritabaniIfadesi.executeQuery("SELECT * FROM ogrenciler");

        // Sorgu sonuclarini konsola bas
        while (rs2.next()) {
            int ogrenciId = rs2.getInt("ogrenci_id");
            String adSoyad = rs2.getString("ad_soyad");
            System.out.printf("%d\t%s\n", ogrenciId, adSoyad);
        }
    }

    private static Connection baglantiKur() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Connection conn = DriverManager.getConnection(VERITABANI_URL);
            return conn;
        } catch (Exception except) {
            except.printStackTrace();
        }
        return null;
    }

    private static void baglantiyiKapat() {
        try {
            if (veritabaniIfadesi != null) {
                veritabaniIfadesi.close();
            }
            if (veritabaniBaglantisi != null) {
                DriverManager.getConnection(VERITABANI_URL + ";shutdown=true");
                veritabaniBaglantisi.close();
            }
        } catch (SQLException sqlExcept) {
        }
    }
}
