import java.sql.*;

public class DerbyVeritabaniOrnek {

    // BIRINCI ADIM
    // pom.xml tanimi
    /*
     <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>com.medipol</groupId>
      <artifactId>DerbyVeritabaniProje</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <dependencies>
        <dependency>
            <groupId>org.apache.derby</groupId>
            <artifactId>derby</artifactId>
            <version>10.11.1.1</version>
        </dependency>
      </dependencies>
    </project>
     */
    
    public static void main(String[] args) {
        
        // IKINCI ADIM -------------------------------------------------
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
            System.out.println("Veritabani kutuphanesi hatasi: " + e.getMessage());
            return;
        }
        System.out.println("Veritabani kutuphanesi yuklendi.");
        
        // UCUNCU ADIM -------------------------------------------------
        Connection veritabaniBaglantisi;
        try {
            String veritabaniDizini= ".\\.veritabani\\"; 
            // veritabaniDizini: Dizin adı "C:\\veritabani\\" da olabilirdi.
            String url = "jdbc:derby:"+veritabaniDizini+";create=true";
            veritabaniBaglantisi = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Veritabani baglanti hatasi: " + e.getMessage());
            return;
        }
        System.out.println("Veritabani baglantisi kuruldu.");
        
        // DORDUNCU ADIM ----------------------------------
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "CREATE TABLE ogrenciler (id int, ad varchar(30))";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
        }
        System.out.println("Tablo olusturuldu.");
        
        // BESINCI ADIM ------------------------------------
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO ogrenciler values (2,'Ali')";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("INSERT hatasi: " + e);
        }
        System.out.println("Kayitlar olusturuldu.");
        
        // ALTINCI ADIM ------------------------------------
        kayitlariListele(veritabaniBaglantisi);
        
        // YEDINCI ADIM ------------------------------------
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "DELETE FROM ogrenciler WHERE id=1";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("DELETE hatasi: " + e);
        }
        System.out.println("Kayitlar silindi.");
        kayitlariListele(veritabaniBaglantisi);
        
        // SEKIZINCI ADIM ------------------------------------
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "UPDATE ogrenciler SET ad='Musa' WHERE id=2";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("UPDATE hatasi: " + e);
        }
        System.out.println("Kayitlar guncellendi.");
        
        kayitlariListele(veritabaniBaglantisi);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    /**
     * @param veritabaniBaglantisi
     */
    private static void kayitlariListele(Connection veritabaniBaglantisi) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM ogrenciler";
            ResultSet resultSet = komut.executeQuery(sql);
            while (resultSet.next()) {
                int ogrenciID = resultSet.getInt(1);
                String ad = resultSet.getString(2);
                System.out.println("Ogrenci ID " + ogrenciID + ", ad: " + ad);
            }
            
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
        System.out.println("Kayitlar listelendi.");
    }
}
