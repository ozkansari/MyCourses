package spark.template.freemarker.gurselbariskoksal_but;
/**
 * Kullanici nesnesi.
 * @author bariskoksal
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class veriTabani {

    private static Connection veritabaniBaglantisi;

    /**
     * Veritabani nesnesi olusturuldugunda
     * veritabani yukle, bagla ve olustur methodlari calisarak
     * veritabani baglantisi saglanir.
     *
     */
    veriTabani(){
        boolean veritabaniYuklendiMi = veritabaniniYukle();
        if (!veritabaniYuklendiMi) {
            return;
        }
        boolean veritabaninaBaglandiMi = veritabaninaBaglan();
        if (!veritabaninaBaglandiMi) {
            return;
        }
        tablolariOlustur();



    }



    public static boolean kullaniciSil() {
        return kullaniciSil();
    }

    /**
     * Verilen kullanici adina ait, verileri tablodan siler.
     * @param kullanici_adi
     * @return boolean
     * @throws Exception
     */

    public static boolean kullaniciSil(String kullanici_adi) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "DELETE FROM kullanicilar WHERE kullanici_adi= '" + kullanici_adi+"'";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("DELETE hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar silindi.");
        return true;
    }
    /**
     * Kullaniciyi veritabanina ekler.
     * @param kul kullanici
     * @return boolean
     * @throws Exception
     */

    public static boolean kullaniciEkle(kullanici kul) {
        return kullaniciEkle(kul.getKullanici_adi(), kul.getKullanici_tipi(), kul.getYas(),kul.getCinsiyet(),kul.getSifre() );
    }

    /**
     * Bilgileri verilen ullaniciyi veritabanina ekler.
     * @param kullanici_adi string
     * @param kullanici_tipi String
     * @param yas int
     * @param cinsiyet String
     * @param sifre String
     * @return boolean
     * @throws Exception
     */

    public static boolean kullaniciEkle(String kullanici_adi, String kullanici_tipi, int yas, String cinsiyet , String sifre) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "INSERT INTO kullanicilar values ('"+ kullanici_adi + "','" + kullanici_tipi
                    + "', " + yas + ",'" + cinsiyet + "','" + sifre +"')";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("INSERT hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar olusturuldu.");
        return true;
    }

    /**
     * Veritabanini yukler.
     * @return boolean
     * @throws Exception
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
     * Veritabanina baglanir.
     * @return boolean
     * @throws Exception
     */
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
    /**
     *Veritabanini olusturur.
     * @return boolean
     */
    public static boolean tablolariOlustur() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "CREATE TABLE kullanicilar (kullanici_adi varchar(30) , kullanici_tipi varchar(10), yas int, " +
                    "cinsiyet varchar(1), sifre varchar(30) , PRIMARY KEY (kullanici_adi))";
            komut.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Tablo mevcut olabilir: " + e);
            return false;
        }
        System.out.println("Tablo olusturuldu.");
        return true;
    }

    /**
     * Veritabaninda bulunan kullanici kayitlarini ceker.
     * return List kullanici
     * @throws Exception
     */
    public static List<kullanici> kayitlariAl() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM kullanicilar";
            ResultSet resultSet = komut.executeQuery(sql);

            List<kullanici> kullanicilar = new ArrayList<kullanici>();
            while (resultSet.next()) {
                String kullanici_adi = resultSet.getString(1);
                String kullanici_tipi = resultSet.getString(2);
                int yas = resultSet.getInt(3);
                String cinsiyet = resultSet.getString(4);
                String sifre = resultSet.getString(5);

                kullanici kullanici_ = new kullanici(kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre);
                kullanicilar.add(kullanici_);
            }
            return kullanicilar;

        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
            return null;
        }
    }

    /**
     * Veritabaninda bulunan kullanici kayitlarini konsola listeler.
     * return List kullanici
     * @throws Exception
     */
    private static void kayitlariListele() {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM kullanicilar";
            ResultSet resultSet = komut.executeQuery(sql);
            while (resultSet.next()) {
                String kullanici_adi = resultSet.getString(1);
                String kullanici_tipi = resultSet.getString(2);
                int yas = resultSet.getInt(3);
                String cinsiyet = resultSet.getString(4);
                String sifre = resultSet.getString(5);

                System.out.println("Kullanici adi: " + kullanici_adi + ", sifre: " + sifre);
            }

        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
        }
        System.out.println("Kayitlar listelendi.");
    }

    /**
     * Girilen kullanici adi ve sifreye sahip birinin veritabaninda bulunup bulunmadigini doner.
     * @param kul_adi
     * @param sifre_
     * @return boolean
     * @throws Exception
     */

    public static boolean kullaniciKontrol(String kul_adi, String sifre_) {
        try {
            Statement komut = veritabaniBaglantisi.createStatement();
            String sql = "SELECT * FROM kullanicilar WHERE kullanici_adi='"+kul_adi+"' AND sifre='"+sifre_+"'";
            ResultSet resultSet = komut.executeQuery(sql);
            while (resultSet.next()) {
                String kullanici_adi = resultSet.getString(1);
                String kullanici_tipi = resultSet.getString(2);
                int yas = resultSet.getInt(3);
                String cinsiyet = resultSet.getString(4);
                String sifre = resultSet.getString(5);

                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Komut hatasi: " + e);
            return false;
        }
    }



}