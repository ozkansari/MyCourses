package spark.template.freemarker.iskenderuzuner_but;

import static spark.Spark.get;
import static spark.Spark.post;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;


import spark.template.freemarker.FreeMarkerRoute;

public class Main {
	
	static boolean giris_bilgisi = false;
	static String kullanici_tipi = "";
	
	private static final String VERITABANI_DIZINI = 
	// OZKANS FIX		".\\.ozkansari\\veritabani\\";
			".\\.iskenderuzuner_but\\veritabani\\";
	
	private static final String VERITABANI_URL = 
    		"jdbc:derby:" + VERITABANI_DIZINI + ";create=true";
	
	
	  private static Connection veritabaniBaglantisi = null;

	  private static Statement veritabaniIfadesi = null;
	
	  private static int mevcutKullaniciSayisi = 0;
	  
	static ArrayList<Kullanici> kullaniciListe = new ArrayList();
	
	static Statement stmt;
	
	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			conn = DriverManager.getConnection(VERITABANI_URL);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println("Veritabanina baglanirken hata olustu: " + VERITABANI_URL );
			e.printStackTrace();
			return;
		}
		
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Veritabaniifadesi olustururken hata: " + VERITABANI_URL );
			e.printStackTrace();
			return;
		}

		String kullanicilarTabloAdi = "kullanicilar_tablo";
		try {
			stmt.executeUpdate(
					"CREATE TABLE " + kullanicilarTabloAdi + 
					" (" + 
							"id int primary key, " + 
							"kullanici_adi varchar(50)," + 
							"kullanici_tipi varchar(30)," + 
							"cinsiyet varchar(30)," + 
							"sifre varchar(30)," + 
							"yas int" + 
					")"
			);
			System.out.println("Tablo " + kullanicilarTabloAdi + " olusturuldu");
			
			String insertQuery = "INSERT INTO kullanicilar_tablo(id,kullanici_adi,kullanici_tipi,cinsiyet,sifre,yas) "
					+ "VALUES(1, \'iskender\', \'admin\', \'erkek\', \'iskender123\', 20)";
					stmt.executeUpdate(insertQuery);
		} catch (Exception e) {
			System.out.println("Tablo " + kullanicilarTabloAdi + " zaten mevcut " + e.getMessage());
		}
			
	
	    FreeMarkerRoute girisSayfasi = new FreeMarkerRoute("/iskenderuzuner/giris_sayfasi") {
            public Object handle(Request istek, Response cevap) {
            		if(giris_bilgisi == true) {
            			cevap.redirect("/iskenderuzuner/");
            			return null;
            		}
            		return new ModelAndView(null, "/iskenderuzuner_but/giris.html");
            }
        };
        get(girisSayfasi);
        
        Route girisSayfasiPost = new Route("/iskenderuzuner/giris_sayfasi/post") {
            public Object handle(Request istek, Response cevap) {
            	
            		String kullanici_adi = istek.queryParams("kadi");
            		String sifre = istek.queryParams("sifre");
            		
            		System.out.println(kullanici_adi + " " + sifre);
            		try {
					ResultSet rs = stmt.executeQuery("select count(kullanici_adi) kull_sayi from kullanicilar_tablo "
								+ "where kullanici_adi = \'" + kullanici_adi + "\'");
						rs.next();
						
						int kull_sayisi = rs.getInt("kull_sayi");
						System.out.println(kull_sayisi);
						if(kull_sayisi == 1) {
							ResultSet rs1 = stmt.executeQuery("select * from kullanicilar_tablo "
													+ "where kullanici_adi = \'" + kullanici_adi + "\'");
							rs1.next();
							String k_sifre = rs1.getString("sifre");
							
							if(k_sifre.equals(sifre)) {
								String kul_tip = rs1.getString("kullanici_tipi");
								giris_bilgisi = true;
								kullanici_tipi = kul_tip;
								
								if(kullanici_tipi.equals("normal_kullanici")) {
									cevap.redirect("/iskenderuzuner/");
								}else {
									cevap.redirect("/iskenderuzuner/yonetici");
								}
							}else {
								cevap.redirect("/iskenderuzuner/giris_sayfasi");
								System.out.println("sifre hata");
							}
						}else {
							cevap.redirect("/iskenderuzuner/giris_sayfasi");
							System.out.println("kullanc� var hata");

						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            		
            		return null;
            }
        };
        post(girisSayfasiPost);
        
        FreeMarkerRoute uyeSayfasi = new FreeMarkerRoute("/iskenderuzuner/uye_sayfasi") {
            public Object handle(Request istek, Response cevap) {
            	if(giris_bilgisi == true) {
        			cevap.redirect("/iskenderuzuner/");
        			return null;
        		}
            
                return new ModelAndView(null, "/iskenderuzuner_but/uye.html");
            }
        };
        get(uyeSayfasi);
        
        Route uyeSayfasiPost = new Route("/iskenderuzuner/uye_sayfasi/post") {
            public Object handle(Request istek, Response cevap) {
            	
            	
            			String kullaniciAdi = istek.queryParams("kadi");
            		 String sifre = istek.queryParams("sifre");
            		 String cinsiyet = istek.queryParams("cinsiyet");
            		int yas = Integer.parseInt(istek.queryParams("yas"));
            		
            		//System.out.println(kullaniciAdi + sifre + cinsiyet + yas);
            		
            		int id = 0;
					try {
						id = mevcutOgrenciSayisi();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
            		id++;
            		
            		String kullanicitipi = "normal_kullanici";
            		
            		try {
            			String insertQuery = "INSERT INTO kullanicilar_tablo(id,kullanici_adi,kullanici_tipi,cinsiyet,sifre,yas) "
            									+ "VALUES(" + id  + ",\'" + kullaniciAdi + "\'," + "\'" +  kullanicitipi + "\'," 
            									+ "\'" + cinsiyet + "\'," + "\'" + sifre + "\'," + yas + ")";
            			stmt.executeUpdate(insertQuery);
            			System.out.println("kullanici eklendei veritaban�na");
            		} catch (Exception e) {
            			
            		}
            		
            		cevap.redirect("/iskenderuzuner/giris_sayfasi");
            		return null;
            }
        };
        post(uyeSayfasiPost);
        
        Route kullaniciyiSil = new Route("/iskenderuzuner/kullaniciyi_sil") {
            public Object handle(Request istek, Response cevap) {
            		
            	int id = Integer.parseInt(istek.queryParams("id"));
            		try {
						kullanicisil(id);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		if(kullanici_tipi.equals("normal_kullanici")) {
						cevap.redirect("/iskenderuzuner/");
					}else {
						cevap.redirect("/iskenderuzuner/yonetici");
					}            		
            		return null;
            }
        };
        post(kullaniciyiSil);
        
        
        FreeMarkerRoute hataSayfasi = new FreeMarkerRoute("/iskenderuzuner/hata") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/iskenderuzuner_but/hata.html");
            }
        };
        get(hataSayfasi);
        
        
        
        
        
        FreeMarkerRoute anaSayfa = new FreeMarkerRoute("/iskenderuzuner/") {
            public Object handle(Request istek, Response cevap) {
                if(giris_bilgisi == false) {
                		cevap.redirect("/iskenderuzuner/giris_sayfasi");
                		return null;
                }else {
                		if(kullanici_tipi.equals("normal_kullanici")) {
                			Map<String,Object> ozellikler = new HashMap<>() ;
                			try {
								kullaniciListe = kullanicilar();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    		ozellikler.put("kullanicilar", kullaniciListe);
                    		return new ModelAndView(ozellikler, "/iskenderuzuner_but/kullanici_anasayfa.html");
                		}else {
                			cevap.redirect("/iskenderuzuner/hata");
                    		return null;
                		}
                }
            }
        };
        get(anaSayfa);
        
        FreeMarkerRoute adminAnaSayfa = new FreeMarkerRoute("/iskenderuzuner/yonetici") {
            public Object handle(Request istek, Response cevap) {
            		if(giris_bilgisi == false) {
            			cevap.redirect("/iskenderuzuner/giris_sayfasi");
                		return null;
            		}else {
            			if(kullanici_tipi.equals("admin")) {
            				Map<String,Object> ozellikler = new HashMap<>() ;
            				
            				try {
								kullaniciListe = kullanicilar();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    		ozellikler.put("kullanicilar", kullaniciListe);
                    		return new ModelAndView(ozellikler, "/iskenderuzuner_but/admin_anasayfa.html");
                		}else {
                			cevap.redirect("/iskenderuzuner/hata");
                    		return null;
                		}
            		}
            }
        };
        get(adminAnaSayfa);
        
	}
	
	public static int mevcutOgrenciSayisi() throws SQLException {
		 ResultSet sorguSonucu = stmt.executeQuery("SELECT max(id) maks_id FROM kullanicilar_tablo");
	     sorguSonucu.next();
	     int sonucDegeri = sorguSonucu.getInt("maks_id");
	     return sonucDegeri;
	}
	
	public static ArrayList<Kullanici> kullanicilar() throws SQLException{
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM kullanicilar_tablo where kullanici_tipi = \'normal_kullanici\'");
		ArrayList<Kullanici> kullanicilar = new ArrayList<>();
		
		
		while (rs.next()) {
			int id = rs.getInt("id");
			int yas = rs.getInt("yas");
			
			String kullanici_adi = rs.getString("kullanici_adi");
			//String kullanici_tip = rs.getString("kullanici_tipi");
			String cinsiyet = rs.getString("cinsiyet");
				String sifre = rs.getString("sifre");
			
			
			kullanicilar.add(new Kullanici(id, yas, kullanici_adi, sifre, cinsiyet));
		}
		return kullanicilar;
	}
	
	public static void kullanicisil(int KULLANICI_ID) throws SQLException {
		stmt.executeUpdate("delete from kullanicilar_tablo where id = " + KULLANICI_ID);
	}
	
	
}
