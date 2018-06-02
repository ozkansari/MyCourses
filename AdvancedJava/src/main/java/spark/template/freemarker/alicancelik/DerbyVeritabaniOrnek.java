package spark.template.freemarker.alicancelik;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    private static Connection veritabaniBaglantisi;
    
    public static void main(String[] args) {
        
        // IKINCI ADIM -------------------------------------------------
        boolean veritabaniYuklendiMi = veritabaniniYukle();
        if (!veritabaniYuklendiMi) {
            return;
        }
        
        // UCUNCU ADIM -------------------------------------------------
        boolean veritabaninaBaglandiMi = veritabaninaBaglan();
        if (!veritabaninaBaglandiMi) {
            return;
        }
        
        // DORDUNCU ADIM ----------------------------------
        tablolariOlustur();
        
        // BESINCI ADIM ------------------------------------
        kitapEkle(1,"Kürkmantolu Madonna","Sabattin","Ali", "LİMON",10);
        
        // ALTINCI ADIM ------------------------------------
        kitaplariListele();
        
        // YEDINCI ADIM ------------------------------------
        //kitapSil(1);
        
        // SEKIZINCI ADIM ------------------------------------

        
        kitaplariListele();
        
        
        
    }


    
    
    public static boolean tablolariSil() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "DROP TABLE kitap";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
            return false;
        }
        System.out.println("Tablo silindi.");
        return true;
    }
    
    
    
    
    public static boolean kitapSil(int id) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "DELETE FROM urun WHERE id=" + id;
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("DELETE hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar silindi.");
        return true;
    }
    
    
    public static boolean sepeteEkle(int id) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            
            String sql = "INSERT INTO sepet values ("+id+")";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("INSERT hatasi: " + e);
            return false;
        }
        System.out.println("Kayit sepete.");
        return true;
    }

    public static boolean kitapEkle(Kitap kitap) {
        return kitapEkle(kitap.getId(), kitap.getKitapadi(), kitap.getYazaradi(), kitap.getYazarsoyadi(),kitap.getYayinevi(),kitap.getFiyat());
    }
    /**

     * @param kitapadi TODO
     * 
     */
    public static boolean kitapEkle(int id, String kitapadi, String yayinevi, String yazaradi, String yazarsoyadi, int fiyat) {
    	System.out.println(kitapadi + yazaradi+yazarsoyadi+yayinevi);
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO kitap values (" + id + ",'"+ kitapadi
                    + "', '"+ yazaradi+"',"+yazarsoyadi+"',"+yayinevi+"'," +"' , " + fiyat + ")";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("INSERT hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar olusturuldu.");
        return true;
    }

    /**
     * 
     */
    public static boolean veritabaniniYukle() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
            System.out.println("Veritabani kutuphanesi hatasi: " + e.getMessage());
            return false;
        }
        System.out.println("Veritabani kutuphanesi yuklendi.");
        return true;
    }
    /**
     * 
     */
    public static boolean veritabaninaBaglan() {
        try {
            String veritabaniDizini= "C:\\\\veritabani\\\\"; 
            // veritabaniDizini: Dizin adı "C:\\veritabani\\" da olabilirdi.
            String url = "jdbc:derby:"+veritabaniDizini+";create=true";
            veritabaniBaglantisi = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Veritabani baglanti hatasi: " + e.getMessage());
            return false;
        }
        System.out.println("Veritabani baglantisi kuruldu.");
        return true;
    }

    /**
     * 
     */
    public static boolean tablolariOlustur() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "CREATE TABLE kitap (id int, kitapAdi varchar(30), yazarAdi varchar(30),yazarSoyadi varchar(30),yayinEvi varchar(30) fiyat int)";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
            return false;
        }
        System.out.println("Tablo olusturuldu.");
        return true;
    }


    public static List<Kitap> kayitlariAl() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM kitap";
            ResultSet resultSet = komut.executeQuery(sql);
            
            List<Kitap> kitaplar = new ArrayList<Kitap>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String kitapadi = resultSet.getString(2);
                String yazaradi = resultSet.getString(3);
                String yazarsoyadi = resultSet.getString(4);
                String yayinevi = resultSet.getString(5);
                int fiyat = resultSet.getInt(6);
                Kitap kitap = new Kitap(id, kitapadi, yazaradi,yazarsoyadi,yayinevi, fiyat);
                kitaplar.add(kitap);
                System.out.println(kitap);
            }
            return kitaplar;
            
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
            return null;
        }
    }
    
    private static void kitaplariListele() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM kitap";
            ResultSet resultSet = komut.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String kitapadi = resultSet.getString(2);
                String yazaradi = resultSet.getString(3);
                String yazarsoyadi = resultSet.getString(4);
                String yayinevi = resultSet.getString(5);
                int fiyat = resultSet.getInt(6);
            }
            
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
        System.out.println("Kayitlar listelendi.");
    }
}
