package spark.template.freemarker.yucelozalp;

// spark-core lib
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

// TODO: Auto-generated Javadoc
/**
 * The Class KitapSitesiMain.
 */
public class KitapSitesiMain {

	/** The Constant DATABASE_PATH. */
	private static final String DATABASE_PATH =
			".\\.yucel_ozalp\\database\\";
	
	/** The Constant DATABASE_URL. */
	private static final String DATABASE_URL =
    		"jdbc:derby:" + DATABASE_PATH + ";create=true";
	
	/** The Constant kitaplar. */
	private static final List<Kitap> kitaplar = new ArrayList<>();
	
	/** The Constant basket. */
	private static final List<Basket> basket = new ArrayList<>();
	
	/** The Constant ordersList. */
	private static final List<Orders> ordersList = new ArrayList<>();
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		System.out.println("Veritabani URL'i " + DATABASE_URL);
		
		/* ----------------------------------------------------------------- */
        /* VERITABANINA BAGLAN  */
        /* ----------------------------------------------------------------- */
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			conn = DriverManager.getConnection(DATABASE_URL);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println("Veritabanina baglanirken hata olustu: " + DATABASE_URL );
			e.printStackTrace();
			return;
		}
		
		final Statement stmt;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Veritabaniifadesi olustururken hata: " + DATABASE_URL );
			e.printStackTrace();
			return;
		}
		
		// TABLO OLUSTURMA ISLEMI
		String kitapTabloAdi = "books";
		try {
			stmt.executeUpdate(
					"CREATE TABLE " + kitapTabloAdi + 
					" (" + 
							"kitap_id int primary key, " +
							"book_name varchar(255)," +
							"yazar_adi varchar(255)," + 
							"yazar_soyadi varchar(255)," +
							"publisher varchar(255)," +
							"category varchar(255)," +
							"price int" +
							")"
			);
			System.out.println("Tablo " + kitapTabloAdi + " olusturuldu");
			
			// BUNDAN SONRASI BIR DEFA CALISIR
			// NEDEN? USTTEKI CREATE TABLE BIR DEFA CALISACAGI ICIN
			// Kullanacagimiz kitap listesi ornek veriler koyuluyor
	    	kitaplar.add( new Kitap("Simyaci", "Paulo", "Coelho", "Yucel" ,"NTV",7));
			kitaplar.add( new Kitap("Simyaci", "Paulo", "Coelho", "Yucel" ,"NTV",8));
	 
	    	for (int i = 0; i < kitaplar.size(); i++) {
				Kitap k = kitaplar.get(i);
				kayitekle(stmt, kitapTabloAdi, 
						k.getBook_name(),
						k.getYazar().getYazarAdi(), 
						k.getYazar().getYazarSoyadi(),
						k.getPublisher(),
						k.getCategory(),
						k.getPrice(),
						i+1);
				
			}
			
		} catch (Exception e) {
			// zaten tablo varsa hata verir
			System.out.println("Tablo " + kitapTabloAdi + " zaten mevcut " + e.getMessage());
		}
		

		
		String orderTableName = "orders";
		try {
			stmt.executeUpdate(
					"CREATE TABLE " + orderTableName + 
					" (" + 
							"id int primary key, " +
							"orders_id varchar(255), " +
							"book_name varchar(255)," +
							"book_id varchar(255)," + 
							"quantity varchar(255)," +
							"price int," +
							"name_surname varchar(255)," +
							"address varchar(255)," +
							"phone varchar(255)" +							
							")"
			);
			System.out.println("Tablo " + orderTableName + " olusturuldu");
			
			/*
			 * 
			 * String orderid,String book_name, String book_id,String quantity,int price,String name_surname,String address,String phone
			 */
			
	    	ordersList.add( new Orders("FFE234F", "Yucelin Kitabi", "1", "2344" ,2424,"Yucel Ozalp","Istanbul","05345107235"));
	    	ordersList.add( new Orders("FFE256F", "Berkin Kitabi", "5", "5323" ,21,"Berk Ozalp","Ankara","05345107223"));
	 
	    	for (int i = 0; i < ordersList.size(); i++) {
				Orders k = ordersList.get(i);
				orderEkle(stmt, orderTableName, 
						k.getBookName(),
						k.getBookId(), 
						k.getQuantity(),
						k.getPrice(),
						k.getNameSurname(),
						k.getAdress(),
						k.getPhone(),
						i+1,
						k.getOrderId());
				
			}
			
		} catch (Exception e) {
			// zaten tablo varsa hata verir
			System.out.println("Tablo " + orderTableName + " zaten mevcut " + e.getMessage());
		}
		
		
		
		/* ----------------------------------------------------------------- */
        /* VERI LISTESI  */
        /* ----------------------------------------------------------------- */
		
		// YAPILACAK: 
		// Listeye elle ekleyip insert yerine, 
		// select ile databaseden al, listeye ekle
		
		// KAYIT SORGULA
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + kitapTabloAdi);
			while (rs.next()) {
				int kitap_id = rs.getInt("kitap_id");
				String book_name = rs.getString("book_name");
				String yazar_adi = rs.getString("yazar_adi");
				String yazar_soyadi = rs.getString("yazar_soyadi");
				String book_publisher = rs.getString("publisher");
				String book_category = rs.getString("category");
				int book_price = rs.getInt("price");
				kitaplar.add( new Kitap(book_name, yazar_adi, yazar_soyadi,book_publisher,book_category,book_price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	/* ----------------------------------------------------------------- */
        /* ORNEK: HTML OLMADAN EKRANA MERHABA BAS */
        /* ----------------------------------------------------------------- */
    	
		// http://localhost:4567/yucelozalp/
        Route sayfa1 = new Route("/yucelozalp/merhaba") {
            public Object handle(Request istek, Response cevap) {
                return "Merhaba!";
            }
        };
        get(sayfa1);
        
        /* ----------------------------------------------------------------- */
        /* ANASAYFA */
        /* ----------------------------------------------------------------- */
        // http://localhost:4567/yucelozalp/
        FreeMarkerRoute anasayfa = new FreeMarkerRoute("/yucelozalp/") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<>();
            	ozellikler.put("basket", basket);
                return new ModelAndView(ozellikler, "/yucelozalp/index.html");
            }
        };
        get(anasayfa);
        
        /* ----------------------------------------------------------------- */
        /* KITAPLAR JSON SERVISI */
        /* ----------------------------------------------------------------- */
        
        // http://localhost:4567/yucelozalp/kitaplar/json
        Route sayfa2 = new Route("/yucelozalp/kitaplar/json") {
            public Object handle(Request istek, Response cevap) {
            	Gson jsonYardimci = new GsonBuilder().setPrettyPrinting().create();
				return jsonYardimci.toJson(kitaplar);
            }
        };
        get(sayfa2);
        
        /* ----------------------------------------------------------------- */
        /* KITAPLAR HTML SAYFA (GET) */
        /* ----------------------------------------------------------------- */
        
        // http://localhost:4567/yucelozalp/kitaplar/html
        FreeMarkerRoute kitaplarHtmlSayfa = new FreeMarkerRoute("/yucelozalp/kitaplar/html") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<>();
            	ozellikler.put("basket", basket);
                ozellikler.put("kitaplar", kitaplar);
                // Object kitaplarMap = ozellikler.get("kitaplar");
                return new ModelAndView(ozellikler, "/yucelozalp/kitaplar.html");
            }
        };
        get(kitaplarHtmlSayfa);
        
        /* ----------------------------------------------------------------- */
        /* KITAPLAR EKLE HTML (GET) */
        /* ----------------------------------------------------------------- */
        
        // http://localhost:4567/kitaplar/ekle/html
        FreeMarkerRoute kitaplarEkleHtmlSayfa = new FreeMarkerRoute("/yucelozalp/kitaplar/ekle/html") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<>();
            	ozellikler.put("basket", basket);
                return new ModelAndView(ozellikler, "/yucelozalp/kitaplar_ekle.html");
            }
        };
        get(kitaplarEkleHtmlSayfa);
        
        /* ----------------------------------------------------------------- */
        /* KITAPLAR EKLE HTMLDEN CAGRILAN POST ISTEGI (Bkz. kitaplar_ekle.html) */
        /* ----------------------------------------------------------------- */
        
        Route kitaplarEklePost = new Route("/yucelozalp/kitaplar/ekle/post") {
            public Object handle(Request istek, Response cevap) {
				//int id = Integer.parseInt(istek.queryParams("id"));
				String book_name = istek.queryParams("book_name");
				String yazarAdi = istek.queryParams("yazaradi");
				String yazarSoyadi = istek.queryParams("yazarsoyadi");
				String book_publisher = istek.queryParams("publisher");
				String book_category = istek.queryParams("category");
				int book_price = Integer.parseInt(istek.queryParams("price"));
				kitaplar.add(new Kitap(book_name, yazarAdi, yazarSoyadi,book_publisher,book_category,book_price));

				int id = kitaplar.size();

				// KAYIT EKLE
				kayitekle(stmt, kitapTabloAdi, book_name, yazarAdi, yazarSoyadi,book_publisher,book_category,book_price,id);


				cevap.redirect("/yucelozalp/kitaplar/html");
                return null;
            }
        };
        post(kitaplarEklePost);
        
       
        
        /* ----------------------------------------------------------------- */
        /* ORDERS ADD (Bkz. orders.html) */
        /* ----------------------------------------------------------------- */
        
        Route ordersEklePost = new Route("/yucelozalp/orders/post") {
            public Object handle(Request istek, Response cevap) {
				//int id = Integer.parseInt(istek.queryParams("id"));
            	String orderid = istek.queryParams("orderid");
				String book_name = istek.queryParams("book_name");
				String book_id = istek.queryParams("book_id");
				String quantity = istek.queryParams("quantity");
				int price = Integer.parseInt(istek.queryParams("price"));
				String name_surname = istek.queryParams("name_surname");
				String address = istek.queryParams("address");
				String phone = istek.queryParams("phone");
				ordersList.add(new Orders(orderid, book_name, book_id,quantity,price,name_surname,address,phone));

				int id = ordersList.size();
				
				// KAYIT EKLE
				orderEkle(stmt, orderTableName, book_name, book_id,quantity,price,name_surname,address,phone,id,orderid);

				basket.clear();
				cevap.redirect("/yucelozalp/ordersList/html");
                return null;
            }
        };
        post(ordersEklePost);
        
        
        

		/* ----------------------------------------------------------------- */
		/* BOOKS BASKET LIST HTML (GET) */
		/* ----------------------------------------------------------------- */

		// http://localhost:4567/basket/html
		FreeMarkerRoute basketListHTMLPage = new FreeMarkerRoute("/yucelozalp/basket/html") {
			public Object handle(Request istek, Response cevap) {
				Map<String, Object> ozellikler = new HashMap<>();
				ozellikler.put("basket", basket);
				// Object kitaplarMap = ozellikler.get("kitaplar");
				System.out.println();
				return new ModelAndView(ozellikler, "/yucelozalp/basket.html");
			}
		};
		get(basketListHTMLPage);

		
		/* ----------------------------------------------------------------- */
		/* ORDERS (GET) */
		/* ----------------------------------------------------------------- */

		// http://localhost:4567/basket/html
		FreeMarkerRoute ordersListHTMLPage = new FreeMarkerRoute("/yucelozalp/orders/html") {
			public Object handle(Request istek, Response cevap) {
				Map<String, Object> ozellikler = new HashMap<>();
				ozellikler.put("basket", basket);
				// Object kitaplarMap = ozellikler.get("kitaplar");
				
				for(int i = 0; i < basket.size(); i++) {
					System.out.println(basket.get(i).getBasketBookName());			
				}
			
				
				return new ModelAndView(ozellikler, "/yucelozalp/orders.html");
			}
		};
		get(ordersListHTMLPage);
		
		
		/* ----------------------------------------------------------------- */
		/* Cart Check (GET) */
		/* ----------------------------------------------------------------- */

		// http://localhost:4567/basket/html
		FreeMarkerRoute cartListHTMLPage = new FreeMarkerRoute("/yucelozalp/menu/html") {
			public Object handle(Request istek, Response cevap) {
				Map<String, Object> ozellikler = new HashMap<>();
				ozellikler.put("basket", basket);
				// Object kitaplarMap = ozellikler.get("kitaplar");
				
				for(int i = 0; i < basket.size(); i++) {
					System.out.println(basket.get(i).getBasketBookName());			
				}
			
				
				return new ModelAndView(ozellikler, "/yucelozalp/menu.html");
			}
		};
		get(cartListHTMLPage);
		
		
		/* ----------------------------------------------------------------- */
		/* ORDERS (GET) */
		/* ----------------------------------------------------------------- */

		// http://localhost:4567/basket/html
		FreeMarkerRoute ordersListLastHTMLPage = new FreeMarkerRoute("/yucelozalp/ordersList/html") {
			public Object handle(Request istek, Response cevap) {
				Map<String, Object> ozellikler = new HashMap<>();
				ozellikler.put("basket", basket);
				ozellikler.put("ordersList", ordersList);
				// Object kitaplarMap = ozellikler.get("kitaplar");
				
				for(int i = 0; i < ordersList.size(); i++) {
					System.out.println(ordersList.get(i).getOrderId());			
				}
			
				
				return new ModelAndView(ozellikler, "/yucelozalp/ordersList.html");
			}
		};
		get(ordersListLastHTMLPage);
		
		

		/* ----- */
		/* ADD BASKET POST */
		/* ----------------------------------------------------------------- */

		Route addbasketPost = new Route("/yucelozalp/basket/post") {
			public Object handle(Request istek, Response cevap) {
				String basketid =(istek.queryParams("id"));
				String book_name = istek.queryParams("book_name");
				String book_price = istek.queryParams("book_price");
				String quantity = (istek.queryParams("quantity"));

				//String totalPrice = "0";

				 int totalPrice = Integer.parseInt(book_price) * Integer.parseInt(quantity);
				 basket.add(new Basket(basketid,book_name,quantity,book_price,totalPrice));
				 
				cevap.redirect("/yucelozalp/kitaplar/html");
				return null;
			}
		};
		post(addbasketPost);

		/* ----- */
		/* DELETE BASKET POST */
		/* ----------------------------------------------------------------- */

		Route deleteItemBasket = new Route("/yucelozalp/basket/delete") {
			public Object handle(Request istek, Response cevap) {
				String id =(istek.queryParams("id"));
				String bookname2 = istek.queryParams("kitabinadi");
				String book_price = istek.queryParams("book_price");
				String quantity = (istek.queryParams("quantity"));

				//String totalPrice = "0";


				 int totalPrice = Integer.parseInt(book_price) * Integer.parseInt(quantity);
				basket.add(new Basket(id,bookname2,quantity,book_price,totalPrice));

				cevap.redirect("/yucelozalp/kitaplar/html");
				return null;
			}
		};
		post(deleteItemBasket);

        /* ----------------------------------------------------------------- */
        /* YAZARLAR HTML (GET) */
        /* ----------------------------------------------------------------- */
        
        // http://localhost:4567/yazarlar/html
        FreeMarkerRoute yazarlarHtmlSayfa = new FreeMarkerRoute("/yucelozalp/yazarlar/html") {
			
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
				return new ModelAndView(ozellikler , "/yucelozalp/yazarlar.html");
			}
		};
		get(yazarlarHtmlSayfa);
		
        
	}

	/**
	 * Kayitekle.
	 *
	 * @param stmt the stmt
	 * @param kitapTabloAdi the kitap tablo adi
	 * @param book_name the book name
	 * @param yazarAdi the yazar adi
	 * @param yazarSoyadi the yazar soyadi
	 * @param book_publisher the book publisher
	 * @param book_category the book category
	 * @param book_price the book price
	 * @param id the id
	 */
	private static void kayitekle(final Statement stmt, String kitapTabloAdi, String book_name, String yazarAdi,
			String yazarSoyadi,String book_publisher,String book_category,int book_price, int id) {
		try {
			stmt.executeUpdate(
					"INSERT INTO " + kitapTabloAdi + " VALUES ("
							+  id + " ,"
							+  "\'"+ book_name + "\',"
							+  "\'"+ yazarAdi + "\',"
							+  "\'"+ yazarSoyadi + "\',"
							+  "\'"+ book_publisher + "\',"
							+  "\'"+ book_category + "\',"
							+  "\'"+ book_price + "\'"
					+ ")"
			);
			System.out.println("Kayit eklendi");
		} catch(Exception e) {
			// zaten ayni id'Li kayit varsa hata verebilir.
			System.out.println("Kayit zaten mevcut. Hata: " + e.getMessage());
		}
	}
	
	
	/**
	 * Order ekle.
	 *
	 * @param stmt the stmt
	 * @param orderTableName the order table name
	 * @param book_name the book name
	 * @param book_id the book id
	 * @param quantity the quantity
	 * @param price the price
	 * @param name_surname the name surname
	 * @param address the address
	 * @param phone the phone
	 * @param id the id
	 * @param orderID the order ID
	 */
	private static void orderEkle(final Statement stmt, String orderTableName, String book_name, String book_id,
			String quantity,int price,String name_surname,String address,String phone, int id,String orderID) {
		try {
			stmt.executeUpdate(
					"INSERT INTO " + orderTableName + " VALUES ("
							+  id + " ,"
							+  "\'"+ orderID + "\',"
							+  "\'"+ book_name + "\',"
							+  "\'"+ book_id + "\',"
							+  "\'"+ quantity + "\',"
							+  "\'"+ price + "\',"
							+  "\'"+ name_surname + "\',"
							+  "\'"+ phone + "\',"
							+  "\'"+ address + "\'"
					+ ")"
			);
			System.out.println("Order Kayiti eklendi");
		} catch(Exception e) {
			// zaten ayni id'Li kayit varsa hata verebilir.
			System.out.println("Kayit zaten mevcut. Hata: " + e.getMessage());
		}
	}
	
	
}
