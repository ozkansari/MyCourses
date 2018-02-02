package spark.template.freemarker.cemhanoglu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Veritabani {
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

    }

    /**
     * @param id
     */
    public static boolean urunSil(int id) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "DELETE FROM urunler WHERE id=" + id;
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("DELETE hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar silindi.");
        return true;
    }

    public static boolean urunEkle(Urun urun) {
        return urunEkle(urun.ID, urun.getMarka(),urun.getModel(),urun.getAdet(),urun.getFiyat());
    }
    public static boolean urunEkle(int id, String marka, String model, int adet, int fiyat) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO urunler values (" + id + ",'" + marka + "', '" + model +"',"+adet+","+fiyat+")";
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
            String sql =  "CREATE TABLE urunler (id int,marka varchar(30), model varchar(30), adet int,fiyat int)";
            String sql2 = "CREATE TABLE VTSPT (id int,marka varchar(30), model varchar(30), adet int,fiyat int)";
            komut.executeUpdate(sql2);
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
            return false;
        }
        System.out.println("Tablo olusturuldu.");
        return true;
    }
    public static List <Urun> Sepetim (int id ) {

        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO VTSPT values (" + id + ")";
            ResultSet resultSet = komut.executeQuery(sql);
            List<Urun> Sepetimiz = new ArrayList<Urun>();
            while (resultSet.next()) {
                String marka = resultSet.getString(1);
                String model = resultSet.getString(2);
                int adet = resultSet.getInt(3);
                int fiyat = resultSet.getInt(4);
                Urun urun = new Urun(Urun.ID,marka,model,adet,fiyat);
                Sepetimiz.add(urun);
            }
            return Sepetimiz;
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
            return null;
        }
    }
    public static List<Urun> kayitlariAl() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM urunler";
            ResultSet resultSet = komut.executeQuery(sql);
            
            List<Urun> urunler = new ArrayList<Urun>();
            while (resultSet.next()) {
                String marka = resultSet.getString(1);
                String model = resultSet.getString(2);
                int adet = resultSet.getInt(3);
                int fiyat = resultSet.getInt(4);
                Urun urun = new Urun(Urun.ID,marka,model,adet,fiyat);
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
            String sql = "SELECT * FROM urunler";
            ResultSet resultSet = komut.executeQuery(sql);
            while (resultSet.next()) {
                String marka = resultSet.getString(1);
                String model = resultSet.getString(2);
                int adet = resultSet.getInt(3);
                int fiyat = resultSet.getInt(4);
            }
            
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
        System.out.println("Kayitlar listelendi.");
    }
}
