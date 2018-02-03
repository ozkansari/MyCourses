package spark.template.freemarker.hasansomuncu;
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
        urunEkle(1,"Gofret", "�ok guzel bir gofrettir",10);
        
        // ALTINCI ADIM ------------------------------------
        kayitlariListele();
        
        // YEDINCI ADIM ------------------------------------
        //urunSil(1);
        
        // SEKIZINCI ADIM ------------------------------------
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "UPDATE ogrenciler SET ad='Musa' WHERE id=2";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("UPDATE hatasi: " + e);
        }
        System.out.println("Kayitlar guncellendi.");
        
        kayitlariListele();
        
        
        
    }

    /**
     * @param id
     */
    
    
    
    public static boolean tablolariSil() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "DROP TABLE urun";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
            return false;
        }
        System.out.println("Tablo silindi.");
        return true;
    }
    
    
    
    
    public static boolean urunSil(int id) {
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

    public static boolean urunEkle(Urun urun) {
        return urunEkle(urun.getId(), urun.getUrunAdi(), urun.getAciklama(), urun.getFiyat());
    }
    /**
     * @param urunAdi TODO
     * 
     */
    public static boolean urunEkle(int id, String urunAdi, String aciklama, int fiyat) {
    	System.out.println(urunAdi + aciklama);
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO urun values (" + id + ",'" + urunAdi
                    + "', '"+ aciklama +"' , " + fiyat + ")";
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
            String sql = "CREATE TABLE urun (id int, ad varchar(30), aciklama varchar(255), fiyat int)";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
            return false;
        }
        System.out.println("Tablo olusturuldu.");
        return true;
    }

    /**
     * @param veritabaniBaglantisi
     */
    public static List<Urun> kayitlariAl() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM urun";
            ResultSet resultSet = komut.executeQuery(sql);
            
            List<Urun> urunler = new ArrayList<Urun>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ad = resultSet.getString(2);
                String aciklama = resultSet.getString(3);
                int fiyat = resultSet.getInt(4);
                Urun urun = new Urun(id, ad, aciklama, fiyat);
                urunler.add(urun);
                System.out.println(urun);
            }
            return urunler;
            
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
            return null;
        }
    }
    
    private static void kayitlariListele() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM urun";
            ResultSet resultSet = komut.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ad = resultSet.getString(2);
                String aciklama = resultSet.getString(3);
                int fiyat = resultSet.getInt(4);
            }
            
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
        System.out.println("Kayitlar listelendi.");
    }
}
