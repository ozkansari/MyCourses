package spark.template.freemarker.furkancelik.finalproje;

import spark.template.freemarker.furkancelik.finalproje.modeller.Kullanici;
import spark.template.freemarker.furkancelik.finalproje.modeller.Siparis;
import spark.template.freemarker.furkancelik.finalproje.modeller.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VeritabaniIslemleri {

    private Statement anaBaglanti;

    public VeritabaniIslemleri() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

            Connection veritabaniBaglantisi = DriverManager.getConnection("jdbc:derby:"
                    + ".\\.furkancelik10\\" // windows ortami icin
                    //+ "./.furkancelik/"
                    + ";create=true;");

            anaBaglanti = veritabaniBaglantisi.createStatement();

        } catch (Exception e) {
            System.out.println("Veritabani Baglantisi Hatasi : " + e.getMessage());
        }


    }

    public boolean TablolariOlustur() {

        try {
            // Kullanicilar tablosunu ekle
            System.out.println("Kullanıcılar tablosu ekleniyor...");
            anaBaglanti.execute("create table kullanicilar(" +
                    "kullanici_adi varchar(255)," +
                    "kullanici_tipi varchar(255)," +
                    "yas int," +
                    "cinsiyet varchar(255)," +
                    "sifre varchar(255))");
            System.out.println("Kullanıcılar tablosu eklendi...");


            // urunler tablosunu ekle
            System.out.println("Ürünler tablosu ekleniyor...");
            anaBaglanti.execute("create table urunler(" +
                    "urun_id int," +
                    "urun_adi varchar(255)," +
                    "urun_kategori varchar(255)," +
                    "fiyat int)");
            System.out.println("Ürünler tablosu Eklendi...");


            // siparisler tablosunu ekle
            System.out.println("Siparisler tablosu ekleniyor...");
            anaBaglanti.execute("create table siparisler(" +
                    "siparis_id int," +
                    "kullanici_adi varchar(255)," +
                    "urun_idler varchar(255)," +
                    "toplam_ucret int)");
            System.out.println("Siparisler tablosu Eklendi...");


            System.out.println("Test kullanicilari ekleniyor...");
            // admin kullanicisi ekle
            anaBaglanti.execute("INSERT INTO kullanicilar(kullanici_adi,kullanici_tipi,yas,cinsiyet,sifre)" +
                    "VALUES('admin','ADMIN', 25, 'E', 'admin')");

            // user kullanici ekle
            anaBaglanti.execute("INSERT INTO kullanicilar(kullanici_adi,kullanici_tipi,yas,cinsiyet,sifre)" +
                    "VALUES('user','NORMAL', 25, 'E', 'user')");

            System.out.println("Test kullanicilari eklendi...");

        } catch (Exception e) {
            System.out.println("Tablolar zaten mevcut. " + e.getMessage() + e.toString());
        }

        System.out.println("Veritabanı baglanti islemi tamamlandi...");

        return true;
    }

    public List<Kullanici> KullanicilariGetir() {

        List<Kullanici> kullanicilar = new ArrayList<Kullanici>();

        try {
            ResultSet sorguSonucu = this.anaBaglanti.executeQuery("SELECT * FROM kullanicilar");

            while (sorguSonucu.next()) {
                kullanicilar.add(new Kullanici(
                        sorguSonucu.getString("kullanici_adi"),
                        sorguSonucu.getString("kullanici_tipi"),
                        sorguSonucu.getInt("yas"),
                        sorguSonucu.getString("cinsiyet"),
                        sorguSonucu.getString("sifre")
                ));
            }
        } catch (Exception e) {
            System.out.println("Kullanici bulunamadi");
        }


        return kullanicilar;
    }

    public Kullanici KullaniciBul(String kullaniciAdi) {

        try {
            ResultSet sorguSonucu = this.anaBaglanti.executeQuery("SELECT * FROM kullanicilar WHERE kullanici_adi='" + kullaniciAdi + "'");

            while (sorguSonucu.next()) {
                Kullanici kullanici = new Kullanici(
                        sorguSonucu.getString("kullanici_adi"),
                        sorguSonucu.getString("kullanici_tipi"),
                        sorguSonucu.getInt("yas"),
                        sorguSonucu.getString("cinsiyet"),
                        sorguSonucu.getString("sifre")
                );
                return kullanici;
            }
        } catch (Exception e) {
            System.out.println("Kullanici bulunamadi : " + e.getMessage());
        }

        return null;
    }

    public void KullaniciEkle(Kullanici kullanici) {
        try {
            anaBaglanti.execute("INSERT INTO kullanicilar(kullanici_adi,kullanici_tipi,yas,cinsiyet,sifre)" +
                    "VALUES('" + kullanici.getKullaniciAdi() + "','" + kullanici.getKullaniciTipi() + "', " +
                    kullanici.getYas() + ", '" + kullanici.getCinsiyet() + "', '" + kullanici.getSifre() + "')");

        } catch (Exception e) {
            System.out.println("Kullanici eklenemedi : " + e.getMessage());
        }
    }

    public void KullaniciSil(String kullaniciAdi) {
        try {
            anaBaglanti.execute("DELETE FROM kullanicilar WHERE kullanici_adi='" + kullaniciAdi +"'");

        } catch (Exception e) {
            System.out.println("Kullanici silinemedi : " + e.getMessage());
        }
    }


    public List<Urun> UrunleriGetir() {

        List<Urun> urunler = new ArrayList<Urun>();

        try {
            ResultSet sorguSonucu = this.anaBaglanti.executeQuery("SELECT * FROM urunler");

            while (sorguSonucu.next()) {
                urunler.add(new Urun(
                        sorguSonucu.getInt("urun_id"),
                        sorguSonucu.getString("urun_adi"),
                        sorguSonucu.getString("urun_kategori"),
                        sorguSonucu.getInt("fiyat")
                ));
            }
        } catch (Exception e) {
            System.out.println("Urunler bulunamadi");
        }

        return urunler;
    }

    public Urun UrunGetir(String urunId){

        try {
            ResultSet sorguSonucu = this.anaBaglanti.executeQuery("SELECT * FROM urunler WHERE urun_id=" + Integer.parseInt(urunId));

            while (sorguSonucu.next()) {
                Urun urun = new Urun(
                        sorguSonucu.getInt("urun_id"),
                        sorguSonucu.getString("urun_adi"),
                        sorguSonucu.getString("urun_kategori"),
                        sorguSonucu.getInt("fiyat")
                );
                return urun;
            }
        } catch (Exception e) {
            System.out.println("Urun bulunamadi : " + e.getMessage());
        }

        return null;

    }

    public void UrunEkle(Urun urun) {
        try {
            anaBaglanti.execute("INSERT INTO urunler(urun_id, urun_adi, urun_kategori, fiyat)" +
                    "VALUES("+ urun.getUrunId() +",'" + urun.getUrunAdi() + "', '" +
                    urun.getUrunKategori() + "', " + urun.getFiyat() + ")");

        } catch (Exception e) {
            System.out.println("Urun eklenemedi : " + e.getMessage());
        }
    }

    public List<Siparis> SiparisleriGetir() {
        List<Siparis> siparisler = new ArrayList<Siparis>();

        try {
            ResultSet sorguSonucu = this.anaBaglanti.executeQuery("SELECT * FROM siparisler");

            while (sorguSonucu.next()) {
                siparisler.add(new Siparis(
                        sorguSonucu.getInt("siparis_id"),
                        sorguSonucu.getString("kullanici_adi"),
                        sorguSonucu.getString("urun_idler"),
                        sorguSonucu.getInt("toplam_ucret")
                ));
            }
        } catch (Exception e) {
            System.out.println("Siparisler bulunamadi");
        }


        return siparisler;
    }

    public void KullaniciSiparisleriniGetir() {

    }

    public void SiparisEkle(Siparis siparis){
        try {
            anaBaglanti.execute("INSERT INTO siparisler(siparis_id, kullanici_adi, urun_idler, toplam_ucret)" +
                    "VALUES(" + siparis.getSiparisId() + ",'" + siparis.getKullaniciAdi() + "', '" +
                    siparis.getUrunIdler() + "', " + siparis.getToplamUcret() + ")");

        } catch (Exception e) {
            System.out.println("Siparis eklenemedi : " + e.getMessage());
        }
    }

    public Integer EssizIdGetir(String tabloAdi){
        try {
            ResultSet sorguSonucu = this.anaBaglanti.executeQuery("SELECT COUNT(*) as sayi FROM " + tabloAdi);
            sorguSonucu.next();
            return sorguSonucu.getInt("sayi") + 1;
        }catch (Exception e){

        }
        Date tarih = new Date();
        return (int) (tarih.getSeconds() + tarih.getMinutes() * 60);
    }

}
