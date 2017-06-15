package spark.template.freemarker.tayyipemreornek;

import java.sql.*;

public class Veritabani {

    public static void main(String[] args) throws Exception {

        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        Connection veritabaniBaglantisi = DriverManager.getConnection(
                "jdbc:derby:c:\\_veritabani;create=true");

        Statement veritabaniIfadesi = veritabaniBaglantisi.createStatement();

        birDefaCalistirilacakKod(veritabaniIfadesi);

        ResultSet rs = veritabaniIfadesi.executeQuery("select * from ogrenciler");
        while(rs.next()) {
            int ogrenciId = rs.getInt(1); // rs.getInt("ogrenci_id")
            String ogrenciAd = rs.getString(2); // rs.getString("ad_soyad")
            System.out.println("ogrenciId: " + ogrenciId + ", ogrenciAd: " + ogrenciAd);
        }

    }

    // Create table ifadesi bir defa calistirilir
    // insert icin de ayni primary key'e sahip (ogrenci_id) iki key olusturamayiz
    private static void birDefaCalistirilacakKod(Statement veritabaniIfadesi) {
        try {
            veritabaniIfadesi.executeUpdate
                    ("Create table ogrenciler (ogrenci_id int primary key, ad_soyad varchar(30))");

            veritabaniIfadesi.executeUpdate
                    ("insert into ogrenciler values ( 1, 'Ali Demir')");
            veritabaniIfadesi.executeUpdate
                    ("insert into ogrenciler values ( 2, 'Mustafa Can Yilmaz')");
            veritabaniIfadesi.executeUpdate
                    ("insert into ogrenciler values ( 3, 'Bugra Emin Burunguz')");
            veritabaniIfadesi.executeUpdate
                    ("insert into ogrenciler values ( 4, 'Oguzhan Yalcin')");
        } catch(Exception e) {

        }
    }


}