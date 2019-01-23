package spark.template.freemarker.onurkaral.finalproje;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VeritabaniYonetimi {
    private static Statement veritabaniStatement;
    public static Statement veritabaniBaglantisiKur() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Connection veritabaniBaglantisi = DriverManager.getConnection(
                    "jdbc:derby:"
                             + ".\\.onurkaraldb\\"
                            + ";create=true;");
            veritabaniStatement = veritabaniBaglantisi.createStatement();
            return veritabaniStatement;

        } catch(Exception e) {
            System.out.println("Veritabanina Baglanirken Hata Olustu");
        }
        return null;
    }
    public static boolean tablolariOlustur() {
        try  {
            veritabaniStatement.executeUpdate(
                    "CREATE TABLE "
                            + "kullanicilar ("
                            + "kullanici_adi varchar(40), "
                            + "kullanici_tipi varchar(15), "
                            + "yas int, "
                            + "cinsiyet varchar(1), "  // E veya K
                            + "sifre varchar(25)"
                            + ")"
            );
            // TODO Diger tablolari olustur
            veritabaniStatement.executeUpdate(
            		"CREATE TABLE "
            			+"urunler ("
            			+"urun_id varchar(40),"
            			+"urun_adi varchar(40),"
            			+"urun_kategori varchar(40),"
            			+"fiyat int "
            			+")"
            		);
         // TODO Diger tablolari olustur
            veritabaniStatement.executeUpdate(
            		"CREATE TABLE "
            			+"siparisler ("
            			+"kullanici_adi varchar(40),"
            			+"urun_idler varchar(40),"
            			+"toplam_ucret int"
            			+")"
            		);
	
            System.out.println("Tablolar Basariyla olusturuldu.");

        } catch(Exception e) {
            System.out.println("Tablo Mevcut.! Tekrar olusturulmayacak: " + e.getMessage());
        }
        return true;
    }

    public static Kullanici kullaniciSorgula(String kullaniciAdi) {

        try  {
            ResultSet sonuclar = veritabaniStatement.executeQuery(
                    "SELECT * FROM kullanicilar WHERE kullanici_adi = '" + kullaniciAdi + "'"
            );
            while(sonuclar.next()) {
                String kullaniciTipi = sonuclar.getString("kullanici_tipi");
                int yas = sonuclar.getInt("yas");
                String cinsiyet = sonuclar.getString("cinsiyet");
                String sifre = sonuclar.getString("sifre");
                return new Kullanici(kullaniciAdi, kullaniciTipi, yas, cinsiyet, sifre);
            }
        } catch(Exception e) {
            System.out.println("Kullanici Sorgu Hatasi.!" + e.getMessage());
        }
        return null;
    }

    public static void kullanicilariOlustur() {
    	
        if(kullaniciSorgula("guest") != null) {
            System.out.println("Sistem kullanicilari mevcut");
            return;
        }
        try  {
            // "kullanicilar" tablosu: kullanici_adi, kullanici_tipi, yas, cinsiyet, sifre
            veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( "
                    + "'guest', 'NORMAL', 22, 'E', 'abcd'"
                    + ")");
            veritabaniStatement.executeUpdate("INSERT INTO kullanicilar VALUES ( "
                    + "'ADMIN', 'ADMIN', 22, 'K', 'xyz'"
                    + ")");
            
            System.out.println("Sistem kullanicilari olusturuldu.");
        } catch(Exception e) {
            System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
        }
        
    }
}
