package spark.template.freemarker.batuhankizil.finalproje;

import java.sql.*;

public class VeritabaniYonetimi {


    private static Connection conn = null;
    private static final String createURL = "jdbc:derby:"
                        + "./.veritabani1/"
                        + ";create=true;";
    
    private static final String openURL = "jdbc:derby:"
            + "./.veritabani1/"
            + ";open=true;";

    private static final String kullanicilarTable = "CREATE TABLE kullanicilar(kullanici_adi varchar(40), " +
            "kullanici_tipi varchar(40), " +
            "yas int, " +
            "cinsiyet varchar(1), " +
            "sifre varchar(40))";

    private static final String urunlerTable = "CREATE TABLE urunler(urun_id int primary key, " +
            "urun_adi varchar(40), " +
            "urun_kategori varchar(40), " +
            "fiyat decimal)";

    private static final String siparislerTable = "CREATE TABLE siparisler " +
            " (siparis_id int primary key, " +
            " kullanici_adi varchar(40), " +
            " urun_idler varchar(255), " +
            " toplam_ucret decimal)";


    public static Connection getVeriTabaniBaglanitisi() {
        try {
        	conn =  DriverManager.getConnection(openURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    

    public static void createTable()
    {
        try
        {
            createKullaniciTable();
            createUrunlerTable();
            createSiparislerTable();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }


    private static void createKullaniciTable() throws SQLException {
        
    	Connection conn =  DriverManager.getConnection(createURL);
    	Statement statement = conn.createStatement();
    	System.out.println("create kullanicilar table");
        statement.executeUpdate(kullanicilarTable);
        statement.close();
        conn.close();
    }

    private static void createUrunlerTable() throws SQLException {
    	Connection conn =  DriverManager.getConnection(createURL);
    	Statement statement = conn.createStatement();
        System.out.println("create urunler table");
        statement.executeUpdate(urunlerTable);
        statement.close();
        conn.close();	
    }

    private static void createSiparislerTable() throws SQLException {
    	Connection conn =  DriverManager.getConnection(createURL);
    	Statement statement = conn.createStatement();	
        System.out.println("create urunler table");
        statement.executeUpdate(siparislerTable);
        statement.close();
        conn.close();

    }

 
    
    public static Statement getStatement(){
        try {
            return getVeriTabaniBaglanitisi().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeVeritabani()
    {
        try
        {
            if (conn != null)
            {
                DriverManager.getConnection(openURL + ";shutdown=true");
                conn.close();
            }
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }

}
