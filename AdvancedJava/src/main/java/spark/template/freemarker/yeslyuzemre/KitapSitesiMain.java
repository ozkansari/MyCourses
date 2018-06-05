package spark.template.freemarker.yeslyuzemre;


import static spark.Spark.get;
import static spark.Spark.post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// java standart utilility lib
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// gson lib
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
// spark-template-freemarker lib
import spark.template.freemarker.FreeMarkerRoute;

public class KitapSitesiMain {

	private static final String VERITABANI_DIZINI = 
			".\\.yesilyuzemre\\veritabani\\";
	
	private static final String VERITABANI_URL = 
    		"jdbc:derby:" + VERITABANI_DIZINI + ";create=true";
	
	private static final List<Kitap> kitaplar = new ArrayList<>();
	
	public static void main(String[] args) {

		System.out.println("Veritabani URL'i " + VERITABANI_URL);
		
		
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			conn = DriverManager.getConnection(VERITABANI_URL);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println("Veritabanina baglanirken hata olustu: " + VERITABANI_URL );
			e.printStackTrace();
			return;
		}
		
		final Statement stmt;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Veritabaniifadesi olustururken hata: " + VERITABANI_URL );
			e.printStackTrace();
			return;
		}
		
		
		String kitapTabloAdi = "kitaplar";
		try {
			stmt.executeUpdate(
					"CREATE TABLE " + kitapTabloAdi + 
					" (" + 
							"kitap_id int primary key, " + 
							"kitap_adi varchar(30)," + 
							"yazar_adi varchar(30)," + 
							"yazar_soyadi varchar(30)" + 
					")"
			);
			System.out.println("Tablo " + kitapTabloAdi + " olusturuldu");
			
			
	    	kitaplar.add( new Kitap("KitapAdı", "KitapAdı", "Yazar"));
	    	kitaplar.add(new Kitap("KitapAdı ", "Yazar", "Yazar"));
	    	kitaplar.add(new Kitap("KitapAdı", "Yazar", "Yazar"));
	    	String Siparis = "sıparıs";
// ********************
// OZKANS DUZELTME: try {
// ********************
				stmt.executeUpdate(
						"CREATE TABLE " + Siparis + 
						" (" + 
								"siparis_id int primary key, " + 
								"siparisverenin_adi varchar(30)," + 
								"siparisverenin_adress varchar(100)," + 
								"para_fiyat int" + 
						")"
				);
				System.out.println("Tablo " + Siparis + " olusturuldu");
	 
	    	for (int i = 0; i < kitaplar.size(); i++) {
				Kitap k = kitaplar.get(i);
				kayitekle(stmt, kitapTabloAdi, 
						k.getKitapAdi(), 
						k.getYazar().getYazarAdi(), 
						k.getYazar().getYazarSoyadi(),
						i+1);
				
			}
			
		} catch (Exception e) {
			
			System.out.println("Tablo " + kitapTabloAdi + " zaten mevcut " + e.getMessage());
		}
		
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + kitapTabloAdi);
			while (rs.next()) {
				int kitap_id = rs.getInt("kitap_id");
				String kitap_adi = rs.getString("kitap_adi");
				String yazar_adi = rs.getString("yazar_adi");
				String yazar_soyadi = rs.getString("yazar_soyadi");
				kitaplar.add( new Kitap(kitap_adi, yazar_adi, yazar_soyadi));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
    	
       
     
        FreeMarkerRoute anasayfa = new FreeMarkerRoute("/yeslyuzemre/") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/yeslyuzemre/index.html");
            }
        };
        get(anasayfa);
        
   
        Route sayfa2 = new Route("/yeslyuzemre/kitaplar/json") {
            public Object handle(Request istek, Response cevap) {
            	Gson jsonYardimci = new GsonBuilder().setPrettyPrinting().create();
				return jsonYardimci.toJson(kitaplar);
            }
        };
        get(sayfa2);
        
       
        FreeMarkerRoute kitaplarHtmlSayfa = new FreeMarkerRoute("/yeslyuzemre/kitaplar/html") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<>();
                ozellikler.put("kitaplar", kitaplar);
                
                return new ModelAndView(ozellikler, "/yeslyuzemre/kitaplar.html");
            }
        };
        get(kitaplarHtmlSayfa);
        
       
        FreeMarkerRoute kitaplarEkleHtmlSayfa = new FreeMarkerRoute("/yeslyuzemre/kitaplar/ekle/html") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/yeslyuzemre/kitaplar_ekle.html");
            }
        };
        get(kitaplarEkleHtmlSayfa);
        
        FreeMarkerRoute kitaplarıSilHtmlSayfa = new FreeMarkerRoute("/yeslyuzemre/kitaplar/sil/html") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/yeslyuzemre/kitaplar_ekle.html");
            }
        };
        get(kitaplarıSilHtmlSayfa);
		
       
     
        
        Route kitaplarEklePost = new Route("/yeslyuzemre/kitaplar/ekle/post") {
            public Object handle(Request istek, Response cevap) {
            	String kitapAdi = istek.queryParams("kitapadi"); 
            	String yazarAdi = istek.queryParams("yazaradi"); 
            	String yazarSoyadi = istek.queryParams("yazarsoyadi"); 
            	kitaplar.add(new Kitap(kitapAdi, yazarAdi, yazarSoyadi));

            	int id = kitaplar.size();
            	
            	
        		kayitekle(stmt, kitapTabloAdi, kitapAdi, yazarAdi, yazarSoyadi, id);
            	
                cevap.redirect("/yeslyuzemre/kitaplar/html");
                return null;
            }
        };
        post(kitaplarEklePost);
        
       
    FreeMarkerRoute yazarlarHtmlSayfa = new FreeMarkerRoute("/yeslyuzemre/yazarlar/html") {
			
			@Override
			public Object handle(Request request, Response response) {
				
				List<Yazar> yazarListesi = new ArrayList<>();
				for (Kitap kitap : kitaplar) {
					yazarListesi.add(kitap.getYazar());
				}
				
				
				Map<String,Object> ozellikler = new HashMap<>() ;
				ozellikler.put("yazarListesi", yazarListesi);
				return new ModelAndView(ozellikler , "/yeslyuzemre/yazarlar.html");
	
			
			}
		 };
		get(yazarlarHtmlSayfa);
		
		
        
	}

	private static void kayitekle(final Statement stmt, String kitapTabloAdi, String kitapAdi, String yazarAdi,
			String yazarSoyadi, int id) {
		try {
			stmt.executeUpdate(
					"INSERT INTO " + kitapTabloAdi + " VALUES ("
					+  id + " ,"
					+  "\'"+ kitapAdi + "\',"
					+  "\'"+ yazarAdi + "\',"
					+  "\'"+ yazarSoyadi + "\'"
					+ ")"
			);
			System.out.println("Kayit eklendi");
		} catch(Exception e) {
			
			System.out.println("Kayit zaten mevcut. Hata: " + e.getMessage());
		}
	}
	
	
}
