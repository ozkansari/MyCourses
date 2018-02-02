package spark.template.freemarker.ibrahimkandemir;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;
import com.google.gson.*;
import java.util.*;

public class Spark {

	 private static final List<Urunler> urunler = new ArrayList<Urunler>();
	 private static final Gson jsonYardimci = new GsonBuilder().create();
	 public static List urunDetay;
	 public static List<SepetUrunler> sepet;
	 
	 
	 static VeritabaniYonetim veritabani;
	 
	public static void main(String[] args) {
		
		veritabani = new VeritabaniYonetim();
		
		staticFileLocation("/spark/template/freemarker/ibrahimkandemir");
		
		// http://localhost:4567/ibrahimkandemir/
		anasayfa();
		
		sepetSayfa();
		sepetDetayIslemAnasayfa();
		sepetDetayIslem();
		urunSilmeSepet();
		
		odemeSayfa();
		odemeTamamlandiSayfa();
		
		secilenUrunDetay();
		secilenUrunDetayIslem();
		
		yonetimSayfa();
		
		urunEkleSayfa();
		urunEkleIslem();
		
		urunListeleSayfa();		
		urunSilmeIslem();
		
		urunDetaySayfaYonetim();
		urunDetaySafyaIslem();
		
		siparisListeleSayfa();
		
	}
	
	
	/*-------------------------------- ANASAYFA BOLUMU ----------------------------*/
	
	/**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
	private static void anasayfa() {
		FreeMarkerRoute anasayfaRoute = new FreeMarkerRoute("/ibrahimkandemir/") {
			@Override
			public Object handle(Request istek, Response cevap) {
				List<Urunler> urunler = VeritabaniYonetim.kayitlariAl();		
				Map<String, Object> ozellikler = new HashMap<String, Object>(); 
				ozellikler.put("urunler", urunler);
				return new ModelAndView(ozellikler, "ibrahimkandemir/index.html");
			}			
		};		
		get(anasayfaRoute);
	}
	
	/**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
	private static void sepetSayfa() {		
 		FreeMarkerRoute sepetRoute = new FreeMarkerRoute("ibrahimkandemir/sepet/") {
 			@Override
 			public Object handle(Request istek, Response cevap) {
 				List<SepetUrunler> sepetUrunler=VeritabaniYonetim.kayitlariAlSepet();
 				 Map<String, Object> ozellikler = new HashMap<String, Object>(); 
 				 ozellikler.put("sepetUrunler", sepetUrunler);
 				return new ModelAndView(ozellikler, "/ibrahimkandemir/urun_sepet.html");
 			} 			
 		};
 		get(sepetRoute);
 	}
	
	/**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void odemeSayfa() {
        FreeMarkerRoute odeme = new FreeMarkerRoute("ibrahimkandemir/sepet/odeme") {
            @Override
            public Object handle(Request istek, Response cevap) {                 
				 Map<String, Object> ozellikler = new HashMap<String, Object>();
				 ozellikler.put("urunler", urunler);
                return new ModelAndView(ozellikler, "ibrahimkandemir/odeme.html");
            }
        };
        get(odeme);
    }
    
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void odemeTamamlandiSayfa() {
        FreeMarkerRoute odemeTamam = new FreeMarkerRoute("ibrahimkandemir/sepet/odeme_tamam") {
            @Override
            public Object handle(Request istek, Response cevap) {                 
				 Map<String, Object> ozellikler = new HashMap<String, Object>();
				 ozellikler.put("urunler", urunler);
                return new ModelAndView(ozellikler, "ibrahimkandemir/odeme_tamam.html");
            }
        };
        get(odemeTamam);
    }
	
	/*-------------------------------- ANASAYFA BOLUMU / SONU ----------------------------*/
	
	/*-------------------------------- ANASAYFA ISLEM BOLUMU ----------------------------*/
	
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
	private static void secilenUrunDetay() {		
		FreeMarkerRoute urunDetayAnasayfa = new FreeMarkerRoute("/ibrahimkandemir/urun_detay") {
			@Override
			public Object handle(Request istek, Response cevap) {				
				 Map<String, Object> ozellikler = new HashMap<String, Object>(); 
				 ozellikler.put("urunler", urunDetay);
				return new ModelAndView(ozellikler, "/ibrahimkandemir/urun_detay.html");
			}			
		};		
		get(urunDetayAnasayfa);
	}
	
	/**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
	private static void secilenUrunDetayIslem() {
        FreeMarkerRoute urunSecilenIslem = new FreeMarkerRoute("ibrahimkandemir/urun_ayrinti_detay") {
            @Override
            public Object handle(Request istek, Response cevap) {                
                int id = Integer.valueOf( istek.queryParams("id") );
                urunDetay = VeritabaniYonetim.secilenKayitiAl(id);               
                cevap.redirect("/ibrahimkandemir/urun_detay");
                
                return null;
            }
        };
        get(urunSecilenIslem);
    }
	
	/**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
	private static void sepetDetayIslemAnasayfa() {
        FreeMarkerRoute sepetDetayIslemAnasayfa = new FreeMarkerRoute("ibrahimkandemir/sepet/islem") {
            @Override
            public Object handle(Request istek, Response cevap) {                
                int id = Integer.valueOf( istek.queryParams("id") );
                sepet=VeritabaniYonetim.secilenSepetKayitiAl(id);
                cevap.redirect("/ibrahimkandemir/");
                
                return null;
            }
        };
        get(sepetDetayIslemAnasayfa);
    }
	
	/**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
	private static void sepetDetayIslem() {
        FreeMarkerRoute sepetDetayIslemF = new FreeMarkerRoute("ibrahimkandemir/sepet/islem_detay") {
            @Override
            public Object handle(Request istek, Response cevap) {                
                int id = Integer.valueOf( istek.queryParams("id") );
                sepet=VeritabaniYonetim.secilenSepetKayitiAl(id);
                cevap.redirect("/ibrahimkandemir/urun_detay");
                
                return null;
            }
        };
        get(sepetDetayIslemF);
    }
	
	/**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void urunSilmeSepet() {
        FreeMarkerRoute urunSilSepet = new FreeMarkerRoute("ibrahimkandemir/sepet/urun_sil") {
            @Override
            public Object handle(Request istek, Response cevap) {                
                int id = Integer.valueOf( istek.queryParams("id") );
                VeritabaniYonetim.urunSilSepet(id);                
                cevap.redirect("/ibrahimkandemir/sepet/");                
                return null;
            }
        };
        get(urunSilSepet);
    }
    
	/*-------------------------------- ANASAYFA ISLEM BOLUMU / SONU ----------------------------*/
	
	/*-------------------------------- YONETIM BOLUMU ----------------------------*/
	
	
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void yonetimSayfa() {		
		FreeMarkerRoute yonetimRoute = new FreeMarkerRoute("ibrahimkandemir/yonetim/") {
			@Override
			public Object handle(Request istek, Response cevap) {
				 //List<Urunler> urunler = VeritabaniYonetim.kayitlariAl();
				 Map<String, Object> ozellikler = new HashMap<String, Object>();
				 ozellikler.put("urunler", urunler);
				return new ModelAndView(ozellikler, "ibrahimkandemir/admin_index.html");
			}
			
		};
		
		get(yonetimRoute);
	}
    
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void urunEkleSayfa() {
        FreeMarkerRoute urunEkle = new FreeMarkerRoute("ibrahimkandemir/yonetim/urun_ekle") {
            @Override
            public Object handle(Request istek, Response cevap) {                 
				 Map<String, Object> ozellikler = new HashMap<String, Object>();
				 ozellikler.put("urunler", urunler);
                return new ModelAndView(ozellikler, "ibrahimkandemir/admin_urun_ekle.html");
            }
        };
        get(urunEkle);
    }
    
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void urunListeleSayfa() {
        FreeMarkerRoute urunListele = new FreeMarkerRoute("ibrahimkandemir/yonetim/urun_listele_yonet") {
            @Override
            public Object handle(Request istek, Response cevap) {                
            	List<Urunler> urunler = VeritabaniYonetim.kayitlariAl();
			 Map<String, Object> ozellikler = new HashMap<String, Object>();
			 ozellikler.put("urunler", urunler);
			return new ModelAndView(ozellikler, "ibrahimkandemir/admin_urun_listele_yonet.html");
            }
        };
        get(urunListele);
    }
    
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void urunDetaySayfaYonetim() {
        FreeMarkerRoute urunDetay = new FreeMarkerRoute("ibrahimkandemir/yonetim/urun_goruntule_detay") {
            @Override
            public Object handle(Request istek, Response cevap) {                
            	List<Urunler> urunler = VeritabaniYonetim.kayitlariAl();
			Map<String, Object> ozellikler = new HashMap<String, Object>();
			ozellikler.put("urunler", urunler);
			return new ModelAndView(ozellikler, "ibrahimkandemir/admin_urun_goruntule_detay.html");
            }
        };
        get(urunDetay);
    }
    
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void siparisListeleSayfa() {
        FreeMarkerRoute siparisListe = new FreeMarkerRoute("ibrahimkandemir/yonetim/siparis_listesi") {
            @Override
            public Object handle(Request istek, Response cevap) {                
            	List<SepetUrunler> sepetUrunler=VeritabaniYonetim.kayitlariAlSepet();
			Map<String, Object> ozellikler = new HashMap<String, Object>(); 
			ozellikler.put("sepetUrunler", sepetUrunler);
			return new ModelAndView(ozellikler, "ibrahimkandemir/admin_siparis_listesi.html");
            }
        };
        get(siparisListe);
    }
    
	/*-------------------------------- YONETIM BOLUMU / SONU----------------------------*/
    
    
    /*-------------------------------- YONETIM ISLEM BOLUMU ----------------------------*/    
    
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void urunEkleIslem() {
        FreeMarkerRoute urunEkleIslem = new FreeMarkerRoute("ibrahimkandemir/yonetim/urun_ekle") {
            @Override
            public Object handle(Request istek, Response cevap) {   
            	try {
            		String urunBasligi = istek.queryParams("urunBasligi");
            		String marka = istek.queryParams("marka");            		
            		float urunFiyati = Float.valueOf(istek.queryParams("urunFiyati"));    
            		float urunIndirimliFiyati = Float.valueOf(istek.queryParams("urunIndirimliFiyati"));
	            String kargoBilgisi = istek.queryParams("kargoBilgi");
	            String kargoTeslimat = istek.queryParams("kargoTeslimat");
	            String urunAciklamasi = istek.queryParams("urunAciklama");
                
	            float indirimliFiyat;
	            	if(urunIndirimliFiyati == 0) {
	            		indirimliFiyat = urunFiyati;
	            		VeritabaniYonetim.urunEkle(Urunler.ID++, urunBasligi, marka, urunFiyati, indirimliFiyat, kargoBilgisi, kargoTeslimat, urunAciklamasi);
	            		
	            	}else {
	            		VeritabaniYonetim.urunEkle(Urunler.ID++, urunBasligi, marka, urunFiyati, urunIndirimliFiyati, kargoBilgisi, kargoTeslimat, urunAciklamasi);
	            	}
	            	               
            	}catch(Exception e) {
            		System.out.println("Urun ekleme hatasi. Error code " + e);
            	}

                cevap.redirect("/ibrahimkandemir/yonetim/urun_ekle");
                return null;
            }
        };
        post(urunEkleIslem);
    }
    
    
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */    
    private static void urunSilmeIslem() {
        FreeMarkerRoute urunSilmeIslem = new FreeMarkerRoute("ibrahimkandemir/yonetim/urun_listele_sil") {
            @Override
            public Object handle(Request istek, Response cevap) {                
                int id = Integer.valueOf( istek.queryParams("id") );
                VeritabaniYonetim.urunSil(id);                
                cevap.redirect("/ibrahimkandemir/yonetim/urun_listele_yonet");                
                return null;
            }
        };
        get(urunSilmeIslem);
    }
 
    /**
	 * FreeMarkerRoute url'de gozuken kismi olusturur.
	 */
    private static void urunDetaySafyaIslem() {
        FreeMarkerRoute urunDetayIslem = new FreeMarkerRoute("ibrahimkandemir/yonetim/urun_detay") {
        	 @Override
             public Object handle(Request istek, Response cevap) {                
             List<Urunler> urunler = VeritabaniYonetim.kayitlariAl();
 			 Map<String, Object> ozellikler = new HashMap<String, Object>();
 			 ozellikler.put("urunler", urunler);
 			 return new ModelAndView(ozellikler, "ibrahimkandemir/admin_urun_goruntule_detay.html");
             }
        };
        get(urunDetayIslem);
    }
    
    /*-------------------------------- YONETIM ISLEM BOLUMU / SONU----------------------------*/  
    
    

}
