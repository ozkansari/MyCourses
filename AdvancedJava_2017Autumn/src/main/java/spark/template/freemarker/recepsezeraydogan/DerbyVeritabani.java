package spark.template.freemarker.recepsezeraydogan;
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
        kayitlariListele();
    }
    /**
     * @param id
     */
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
    public static boolean musteriEkle(Musteri musteri) {
        return musteriEkle(musteri.getAdi(),musteri.getSoyadi(),musteri.getAdres(),musteri.getKkbilgisi(),musteri.getTckimlik(),musteri.getTelno());
    }
    /**
     * @param adi
     * @param soyadi TODO
     * @param adresi
     * @param tcno
     * @param kkbilgisi
     *
     */
    public static boolean musteriEkle(String adi,String soyadi,String adresi,int kkbilgisi,int telno,int tcno ) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO musteri values (" + adi + ",'" + soyadi + "', '" + adresi +"',"+kkbilgisi+","+telno+","+tcno+ ")";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("INSERT hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar olusturuldu.");
        return true;
    }
    public static boolean urunEkle(Urun urun) {
        return urunEkle(urun.getId(), urun.getMarka(),urun.getModel(),urun.getAdet(),urun.getKategori(), urun.getFiyat(),urun.getTemelBilgiler());
    }
    /**
     * @param marka
     * @param model TODO
     * @param adet
     * @param kategori
     * @param temelBilgiler
     * 
     */
    public static boolean urunEkle(int id, String marka, String model, int adet, int kategori, int fiyat, String temelBilgiler) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO urunler values (" + id + ",'" + marka + "', '" + model +"',"+adet+","+kategori+","+fiyat+ ",'"+temelBilgiler+"')";
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
            String sql =  "CREATE TABLE urunler (id int,marka varchar(30), model varchar(30), adet int,kategori int,fiyat int,temel bilgiler varchar(30))";
            String sql2 = "CREATE TABLE sepet (id int,marka varchar(30), model varchar(30), adet int,kategori int,fiyat int,temel bilgiler varchar(30))";
            String sql3 =  "CREATE TABLE sepet (adi varchar(30),soyadi varchar(30),adres varchar(30),int kkbilgisi,int telno,int tcno";
            komut.executeUpdate(sql2);
            komut.executeUpdate(sql3);
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
            return false;
        }
        System.out.println("Tablo olusturuldu.");
        return true;
    }
    public static void sepeteEkle( int id) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO sepet values (" + id + ")";
            ResultSet resultSet = komut.executeQuery(sql);
            List<Urun> sepete_gidecekler = new ArrayList<Urun>();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                String marka = resultSet.getString(2);
                String model = resultSet.getString(3);
                int adet = resultSet.getInt(4);
                int kategori = resultSet.getInt(5);
                int fiyat = resultSet.getInt(6);
                String temelBilgiler = resultSet.getString(7);
                Urun urun = new Urun(id, marka, model, adet, kategori, fiyat, temelBilgiler);
                sepete_gidecekler.add(urun);
            }   } catch(SQLException e){
                System.out.println("Komut hatasi: " + e);
            }
        }
        /**
     */
    public static List<Urun> kayitlariAl() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM urunler";
            ResultSet resultSet = komut.executeQuery(sql);
            List<Urun> urunler = new ArrayList<Urun>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String marka = resultSet.getString(2);
                String model = resultSet.getString(3);
                int adet = resultSet.getInt(4);
                int kategori = resultSet.getInt(5);
                int fiyat = resultSet.getInt(6);
                String temelBilgiler = resultSet.getString(7);
                Urun urun = new Urun(id, marka,model,adet,kategori,fiyat,temelBilgiler);
                urunler.add(urun);
            }
            return urunler;
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
            return null;
        }
    }

    public static boolean tabloSil(){
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql =  "DROP TABLE urunler";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo silinemedi!! " + e);
            return false;
        }
        System.out.println("Tablo silindi!!!!");
        return true;
    }

    private static void kayitlariListele() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM urunler";
            ResultSet resultSet = komut.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String marka = resultSet.getString(2);
                String model = resultSet.getString(3);
                int adet = resultSet.getInt(4);
                int kategori = resultSet.getInt(5);
                int fiyat = resultSet.getInt(6);
                String temelBilgiler = resultSet.getString(7);
                System.out.println("Urun ID " + id + "marka: " + marka+"model:"+model+"adet:"+adet+"kategori:"+kategori+"fiyat:"+fiyat+"temelBilgiler:"+temelBilgiler);
            }
            
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
        System.out.println("Kayitlar listelendi.");
    }
}
