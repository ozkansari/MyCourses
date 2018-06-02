package spark.template.freemarker.anilbal;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

public class KitapSitesiMain {

	private static final String VERITABANI_DIZINI = 
			".\\.anilbal\\veritabani\\";
	
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
			
		} catch (Exception e) {
			// zaten tablo varsa hata verir
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// http://localhost:4567/anilbal/
        Route sayfa1 = new Route("/anilbal/merhaba") {
            public Object handle(Request istek, Response cevap) {
                return "Merhaba!";
            }
        };
        get(sayfa1);
        

        // http://localhost:4567/anilbal/
        FreeMarkerRoute anasayfa = new FreeMarkerRoute("/anilbal/") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/anilbal/index.html");
            }
        };
        get(anasayfa);
        

        
        // http://localhost:4567/anilbal/kitaplar/json
        Route sayfa2 = new Route("/anilbal/kitaplar/json") {
            public Object handle(Request istek, Response cevap) {
            	Gson jsonYardimci = new GsonBuilder().setPrettyPrinting().create();
				return jsonYardimci.toJson(kitaplar);
            }
        };
        get(sayfa2);
        

        
        // http://localhost:4567/anilbal/kitaplar/html
        FreeMarkerRoute kitaplarHtmlSayfa = new FreeMarkerRoute("/anilbal/kitaplar/html") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<>();
                ozellikler.put("kitaplar", kitaplar);
                // Object kitaplarMap = ozellikler.get("kitaplar");
                return new ModelAndView(ozellikler, "/anilbal/kitaplar.html");
            }
        };
        get(kitaplarHtmlSayfa);
        

        
        // http://localhost:4567/kitaplar/ekle/html
        FreeMarkerRoute kitaplarEkleHtmlSayfa = new FreeMarkerRoute("/anilbal/kitaplar/ekle/html") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/anilbal/kitaplar_ekle.html");
            }
        };
        get(kitaplarEkleHtmlSayfa);
        

        
        Route kitaplarEklePost = new Route("/anilbal/kitaplar/ekle/post") {
            public Object handle(Request istek, Response cevap) {
            	String kitapAdi = istek.queryParams("kitapadi"); 
            	String yazarAdi = istek.queryParams("yazaradi"); 
            	String yazarSoyadi = istek.queryParams("yazarsoyadi"); 
            	kitaplar.add(new Kitap(kitapAdi, yazarAdi, yazarSoyadi));

            	int id = kitaplar.size();
            	
            	
        		kayitekle(stmt, kitapTabloAdi, kitapAdi, yazarAdi, yazarSoyadi, id);
            	
                cevap.redirect("/anilbal/kitaplar/html");
                return null;
            }
        };
        post(kitaplarEklePost);
        

        
        // http://localhost:4567/yazarlar/html
        FreeMarkerRoute yazarlarHtmlSayfa = new FreeMarkerRoute("/anilbali/yazarlar/html") {
			
			@Override
			public Object handle(Request request, Response response) {
				
				List<Yazar> yazarListesi = new ArrayList<>();
				for (Kitap kitap : kitaplar) {
					yazarListesi.add(kitap.getYazar());
				}
				
				// Ekstra bilgi. Java 8 Fonksiyonel Programlama
				// kitaplar.forEach( k -> yazarListesi.add(k.getYazar()));
				
				Map<String,Object> ozellikler = new HashMap<>() ;
				ozellikler.put("yazarListesi", yazarListesi);
				return new ModelAndView(ozellikler , "/anilbal/yazarlar.html");
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
			// zaten ayni id'Li kayit varsa hata verebilir.
			System.out.println("Kayit zaten mevcut. Hata: " + e.getMessage());
		}
	}
	
	
}
