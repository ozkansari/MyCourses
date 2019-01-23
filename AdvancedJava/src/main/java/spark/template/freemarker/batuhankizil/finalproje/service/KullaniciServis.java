package spark.template.freemarker.batuhankizil.finalproje.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spark.template.freemarker.batuhankizil.finalproje.VeritabaniYonetimi;
import spark.template.freemarker.batuhankizil.finalproje.model.Kullanici;

public class KullaniciServis {

    public KullaniciServis(){}
    
    
    /**
     * Admin tipinde kullanýcý oluþturur.
     **/
    public void adminKullaniciEkle() {
    	Kullanici kullanici = new Kullanici();
        kullanici.setKullanici_adi("admin");
        kullanici.setKullanici_tipi("ADMIN");
        kullanici.setCinsiyet("E");
        kullanici.setYas(45);
        kullanici.setSifre("admin");
        kullaniciKaydet(kullanici);
    }
    
    /**
     * Normal tipde kullanýcý oluþturur.
     **/
    public void questKullaniciEkle() {
    	Kullanici kullanici = new Kullanici();
        kullanici.setKullanici_adi("quest");
        kullanici.setKullanici_tipi("NORMAL");
        kullanici.setCinsiyet("E");
        kullanici.setYas(45);
        kullanici.setSifre("quest");
        kullaniciKaydet(kullanici);
    }

    public boolean kullaniciKaydet(Kullanici kullanici){
        String selectSql = "select count(*)  from kullanicilar where kullanici_adi = ?";
        ResultSet rs = null;
        int kullaniciSay = 0;
        try {
            PreparedStatement stmt = VeritabaniYonetimi.getVeriTabaniBaglanitisi().prepareStatement(selectSql);
            stmt.setString(1,kullanici.getKullanici_adi());
            rs = stmt.executeQuery();
            while (rs.next()){
                kullaniciSay = rs.getInt(1);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (kullaniciSay > 0) {
            //System.out.println("Hata bu isimde kullanici var");
            return false;
        }else{
            try {
                String insertSql = "insert into kullanicilar(kullanici_adi,kullanici_tipi,yas,cinsiyet,sifre) " +
                        "values('" + kullanici.getKullanici_adi() + "','" + kullanici.getKullanici_tipi() + "'," + kullanici.getYas() + "," +
                        " '" +kullanici.getCinsiyet()+ "','" +kullanici.getSifre() +"' )";
                Statement stmt = VeritabaniYonetimi.getVeriTabaniBaglanitisi().createStatement();
                int updatedRowCount = stmt.executeUpdate(insertSql);
                if (updatedRowCount > 0){
                    return true;
                }else {
                    System.out.println("Kaydedilemedi");
                }
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public Kullanici kullaniciGiris(String username, String password){
        Connection conn = VeritabaniYonetimi.getVeriTabaniBaglanitisi();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Kullanici kullanici = null;
        int count = 0;
        try {
            stmt = conn.prepareStatement("select * from kullanicilar where kullanici_adi = ? and sifre = ? ");
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs = stmt.executeQuery();

            while (rs.next()){
                String ad = rs.getString("kullanici_adi");
                String tipi = rs.getString("kullanici_tipi");
                int yas = rs.getInt("yas");
                String cinsiyet = rs.getString("cinsiyet");
                String sifre = rs.getString("sifre");
                kullanici = new Kullanici(ad,tipi,yas,cinsiyet,sifre);
            }
            stmt.close();
            rs.close();
            return kullanici;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public Kullanici kullaniciGetir(String kullanici_adi){
        Connection conn = VeritabaniYonetimi.getVeriTabaniBaglanitisi();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Kullanici kullanici = null;
        int count = 0;
        try {
            stmt = conn.prepareStatement("select * from kullanicilar where kullanici_adi = ?");
            stmt.setString(1,kullanici_adi);
            rs = stmt.executeQuery();

            while (rs.next()){
                String ad = rs.getString("kullanici_adi");
                String tipi = rs.getString("kullanici_tipi");
                int yas = rs.getInt("yas");
                String cinsiyet = rs.getString("cinsiyet");
                String sifre = rs.getString("sifre");
                kullanici = new Kullanici(ad,tipi,yas,cinsiyet,sifre);
            }
            stmt.close();
            rs.close();
        return kullanici;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

  
    
    
    public List<Kullanici> tumKullanicilar(){
        Connection conn = VeritabaniYonetimi.getVeriTabaniBaglanitisi();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Kullanici kullanici = null;
        List<Kullanici> kullanicilar = new ArrayList<>();
        int count = 0;
        try {
            stmt = conn.prepareStatement("select * from kullanicilar ");
            rs = stmt.executeQuery();

            while (rs.next()){
                String ad = rs.getString("kullanici_adi");
                String tipi = rs.getString("kullanici_tipi");
                int yas = rs.getInt("yas");
                String cinsiyet = rs.getString("cinsiyet");
                String sifre = rs.getString("sifre");
                kullanici = new Kullanici(ad,tipi,yas,cinsiyet,sifre);
                kullanicilar.add(kullanici);
            }
            stmt.close();
            rs.close();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kullanicilar;
    }
    
    
    public boolean kullaniciSil(String kullaniciAdi){

        try {
            Connection conn = VeritabaniYonetimi.getVeriTabaniBaglanitisi(); 
        	PreparedStatement stmt = conn.prepareStatement("delete from kullanicilar where kullanici_adi = ?");
            stmt.setString(1,kullaniciAdi);
            int executeUpdate = stmt.executeUpdate();
            stmt.close();
            if(executeUpdate > 0)
            return true;
            else
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
