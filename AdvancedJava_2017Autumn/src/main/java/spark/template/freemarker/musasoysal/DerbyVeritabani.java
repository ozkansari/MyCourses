package spark.template.freemarker.musasoysal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DerbyVeritabani {


    private static Connection veritabaniBaglantisi;
    
    public static void main(String[] args) {
        
    
        boolean veritabaniYuklendiMi = veritabaniniYukle();
        if (!veritabaniYuklendiMi) {
            return;
        }
        
     
        boolean veritabaninaBaglandiMi = veritabaninaBaglan();
        if (!veritabaninaBaglandiMi) {
            return;
        }
        
    
        tablolariOlustur();
        kayitlariListele();
         urunSil(1);
   
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

    public static boolean urunEkle(Urun urun) {
        return urunEkle(urun.getId(), urun.getUrunAdi(), urun.getFiyat());
    }
    
    public static boolean urunEkle(int id, String urunAdi, int fiyat) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO urun values (" + id + ",'" + urunAdi
                    + "', " + fiyat + ")";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("INSERT hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar olusturuldu.");
        return true;
    }

   
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
 
    public static boolean veritabaninaBaglan() {
        try {
            String veritabaniDizini= ".\\.veritabani\\"; 
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

   
    public static boolean tablolariOlustur() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "CREATE TABLE urun (id int, ad varchar(30), fiyat int)";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
            return false;
        }
        System.out.println("Tablo olusturuldu.");
        return true;
    }

   
    public static List<Urun> kayitlariAl() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM urun";
            ResultSet resultSet = komut.executeQuery(sql);
            
            List<Urun> urunler = new ArrayList<Urun>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ad = resultSet.getString(2);
                int fiyat = resultSet.getInt(3);
                Urun urun = new Urun(id, ad, fiyat);
                urunler.add(urun);
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
                int fiyat = resultSet.getInt(3);
                System.out.println("Urun ID " + id + ", ad: " + ad);
            }
            
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
        System.out.println("Kayitlar listelendi.");
    }
}
