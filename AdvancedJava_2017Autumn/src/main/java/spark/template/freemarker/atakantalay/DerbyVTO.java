package spark.template.freemarker.atakantalay;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DerbyVTO {
    private static Connection veritabaniBaglantisi;
    private static void kayitlariListele() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM magaza";
            ResultSet resultSet = komut.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ad = resultSet.getString(2);
                String tur = resultSet.getString(3);
                int stok = resultSet.getInt(4);
                int deger = resultSet.getInt(5);
                System.out.println("Urun ID " + id + "ad: " + ad+"tur:"+tur+"stok:"+stok+"Deger:"+deger);
            }
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
        System.out.println("Kayitlar listelendi.");
    }
    public static List<Urun> kayitlariAl() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM magaza";
            ResultSet resultSet = komut.executeQuery(sql);

            List<Urun> urunler = new ArrayList<Urun>();
              while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String ad = resultSet.getString(2);
                String tur = resultSet.getString(3);
                int stok = resultSet.getInt(4);
                int deger = resultSet.getInt(5);
                Urun urun = new Urun(id,ad,tur,stok,deger);
                urunler.add(urun);
            }
            return urunler;
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
            return null;
        }
    }
    public static boolean urunEkle(Urun urun) {
        return urunEkle(urun.getId(), urun.getAd(),urun.getTur(),urun.getStok(),urun.getDeger());
    }
    public static boolean urunEkle(int id, String ad, String tur, int stok, int deger) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO magaza values (" + id + ",'" + ad + "', '" + tur +"',"+stok+","+deger+")";
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
            String sql =  "CREATE TABLE magaza (id int,ad varchar(30),tur varchar(30), stok int,deger int";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
            return false;
        }
        System.out.println("Tablo olusturuldu.");
        return true;
    }
    public static void KullaniciSepet(int id ) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO sepet values (" + id + ")";
            ResultSet resultSet = komut.executeQuery(sql);
            List<Urun> KullaniciSepeti = new ArrayList<Urun>();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                String ad = resultSet.getString(2);
                String tur = resultSet.getString(3);
                int stok = resultSet.getInt(4);
                int deger = resultSet.getInt(5);
                Urun urun = new Urun(id,ad,tur,stok,deger);
                KullaniciSepeti.add(urun);
            } }catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
    }
    /**
     * @param id
     */
    public static boolean urunSil(int id) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "DELETE FROM magaza WHERE id=" + id;
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("DELETE hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar silindi.");
        return true;
    }
    public static void main(String[] args) {
        
        // Veritabanı yüklendimi kontrol et
        boolean veritabaniYuklendiMi = veritabaniniYukle();
        if (!veritabaniYuklendiMi) {
            return;
        }
        // Veri tabanına bağlandımı kontrol et
        boolean veritabaninaBaglandiMi = veritabaninaBaglan();
        if (!veritabaninaBaglandiMi) {
            return;
        }
        // İstenilen Tabloları oluştur
        tablolariOlustur();
        // Eğer elimizde kayıt varsa mevcut kayıtları listele
        kayitlariListele();
    }
}

