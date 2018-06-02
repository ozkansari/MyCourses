package spark.template.freemarker.iskenderuzuner;
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
        return urunEkle(urun.getId(), urun.getKitap(),urun.getFiyati(),urun.getYazar(),urun.getYazarSoyadi(), urun.getYayinEvi());
    }
    private static boolean urunEkle(int id, String kitap, int fiyati, String yazar, String yazarSoyadi,
			String yayinEvi) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
     * @param marka
     * @param model TODO
     * @param adet
     * @param kategori
     * @param temelBilgiler
     * 
     */
    public static boolean urunEkle(int id, String kitap, String yazar, int fiyati, String yazarSoyadi,String yayinEvi) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO urunler values (" + id + ",'" + kitap + "', '" + yazar +"',"+fiyati+","+yazarSoyadi+","+yayinEvi+ ")";
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
            String sql =  "CREATE TABLE urunler (id int,kitapadi varchar(30), yazaradi varchar(30), fiyati int,yazarsoyadi varchar(30),yayinevi varchar(30))";
            String sql2 = "CREATE TABLE sepet (id int,kitapadi varchar(30), yazaradi varchar(30), fiyati int,yazarsoyadi varchar(30),yayinevi varchar(30))";
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
                String kitapadi = resultSet.getString(2);
                String yazaradi = resultSet.getString(3);
                int fiyati = resultSet.getInt(4);
                String yazarsoyadi = resultSet.getString(7);
                String yayinevi = resultSet.getString(7);
                Urun urun = new Urun(id, kitapadi, yazaradi, fiyati, yazarsoyadi, yayinevi);
               
                
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
            String sql = "SELECT * FROM urun";
            ResultSet resultSet = komut.executeQuery(sql);
            List<Urun> urunler = new ArrayList<Urun>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String kitapadi = resultSet.getString(2);
                String yazaradi = resultSet.getString(3);
                int fiyati = resultSet.getInt(4);
                String yazarsoyadi = resultSet.getString(7);
                String yayinevi = resultSet.getString(7);
                Urun urun = new Urun(id, kitapadi, yazaradi, fiyati, yazarsoyadi, yayinevi);
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
            String sql = "SELECT * FROM urun";
            ResultSet resultSet = komut.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String kitapadi = resultSet.getString(2);
                String yazaradi = resultSet.getString(3);
                int fiyati = resultSet.getInt(4);
                String yazarsoyadi = resultSet.getString(7);
                String yayinevi = resultSet.getString(7);
                System.out.println("Urun ID " + id + "kitapadi: " + kitapadi+"yazaradi:"+yazaradi+"fiyati:"+fiyati+"yazarsoyadi:"+yazarsoyadi+"yayinevi:"+yayinevi);
            }
            
        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
        System.out.println("Kayitlar listelendi.");
    }
}
