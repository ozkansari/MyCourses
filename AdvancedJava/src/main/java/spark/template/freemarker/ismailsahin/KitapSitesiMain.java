package spark.template.freemarker.ismailsahin;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.*;

import spark.template.freemarker.*;


public class KitapSitesiMain {
	static ArrayList<Kitap> kitapList = new ArrayList<Kitap>();
	static VeriTabani veriTabani;
	static Siparis siparis;
	
	static ArrayList<Integer> sepetList = new ArrayList<Integer>();
	
	
	/**
	 * Uygulaman�n main fonksiyonu. Uygulama buradan ba�lar..
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		veriTabani = new VeriTabani();
		veriTabani.veritabaniHazirla();
		
		siparis = new Siparis();
		
		
		//sepetList.add(2);
		
		/**
		 * Ana sayfa get method
		 */
		FreeMarkerRoute anaSayfaRoute = new FreeMarkerRoute("ismail_sahin/ana_sayfa") {
            public Object handle(Request istek, Response cevap) {
                
            	Map<String, Object> ozellikler = new HashMap<String, Object>();
                
            	try {
					kitapList = veriTabani.getKitapList();
				} catch (Exception e) {
					e.printStackTrace();
				}
            	ozellikler.put("kitaplar", kitapList);
            	
            	ozellikler.put("siparis", siparis);
                ozellikler.put("sepet", siparis.getUrunList());
            	
                return new ModelAndView(ozellikler, "/ismailsahin/anasayfa.html");
            }
        };
        get(anaSayfaRoute);
        
        /**
         * kitap ekle get
         */
        FreeMarkerRoute kitapEkleRoute = new FreeMarkerRoute("/ismail_sahin/yonetim/kitap_ekle") {
            public Object handle(Request istek, Response cevap) {
            	return new ModelAndView(null, "/ismailsahin/kitap_ekle.html");
            }
        };
        get(kitapEkleRoute);
        
        /**
         * kitap ekleme post method
         */
        Route kitapEklePostRoute = new FreeMarkerRoute("/ismail_sahin/yonetim/yeni_kitap_ekle") {
        	public Object handle(Request istek, Response cevap) {
            	String kitapAdi = istek.queryParams("kitapAdi"); 
            	String yazar = istek.queryParams("yazarAdi"); 
            	int sayfaSayi = Integer.parseInt(istek.queryParams("sayfaSayisi"));
            	int fiyat = Integer.parseInt(istek.queryParams("fiyat"));
            	
            	try {
					veriTabani.kitapEkle(kitapAdi, yazar, fiyat, sayfaSayi);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                cevap.redirect("/ismail_sahin/yonetim/kitap_listele");
                return null;
            }
        };
        post(kitapEklePostRoute);
        
        /**
         * veritaban�ndan kitap sil post
         */
        Route kitapSilPostRoute = new FreeMarkerRoute("/ismail_sahin/yonetim/kitap_sil") {
        	public Object handle(Request istek, Response cevap) {

            	int id =  Integer.parseInt(istek.queryParams("kitap_id"));
            	
            	try {
					veriTabani.kitapSil(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                cevap.redirect("/ismail_sahin/yonetim/kitap_listele");
                return null;
            }
        };
        post(kitapSilPostRoute);
        
        /**
         * veritaban�na siparis ekle
         */
        Route sepetEklePostRoute = new FreeMarkerRoute("/ismail_sahin/sepete_ekle") {
        	public Object handle(Request istek, Response cevap) {

        		int id =  Integer.parseInt(istek.queryParams("kitap_id"));
            	siparis.urunEkle(id);
        		System.out.println("sepete eklendi.");
            	
                cevap.redirect("/ismail_sahin/ana_sayfa");
                return null;
            }
        };
        post(sepetEklePostRoute);
        
        
        /**
         * kitap listele get method
         */
        FreeMarkerRoute kitapListeleRoute = new FreeMarkerRoute("/ismail_sahin/yonetim/kitap_listele") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<String, Object>();
               
            	try {
					kitapList = veriTabani.getKitapList();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	ozellikler.put("kitaplar", kitapList);
                
            	return new ModelAndView(ozellikler, "/ismailsahin/kitap_listele.html");
            }
        };
        get(kitapListeleRoute);
        
        /**
         * kitap detay goruntuler get method
         */
        FreeMarkerRoute kitapDetayRoute = new FreeMarkerRoute("/ismail_sahin/yonetim/kitap_detay") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<String, Object>();
            	
            	int id = Integer.parseInt(istek.queryParams("kitapId"));
            	Kitap kitap = null;
            	try {
					kitap = veriTabani.getKitap(id);
					System.out.println(kitap.getKitapAdi());
				} catch (Exception e) {
					e.printStackTrace();
				}
            	ozellikler.put("kitap", kitap);
            	
            	return new ModelAndView(ozellikler, "/ismailsahin/kitap_detay.html");
            }
        };
        get(kitapDetayRoute);
        
        
        /**
         * siparis onay get method
         */
        Route siparisOnayRoute = new FreeMarkerRoute("/ismail_sahin/siparis_onay") {
        	public Object handle(Request istek, Response cevap) {
        		Map<String, Object> ozellikler = new HashMap<String, Object>();
                
        		ozellikler.put("siparis", siparis);
                ozellikler.put("sepet", siparis.getUrunList());
                
            	return new ModelAndView(ozellikler, "/ismailsahin/siparis_onay.html");
            }
        };
        get(siparisOnayRoute);
        
        /**
         * siparis onay post method
         */
        Route siparisOnayPostRoute = new FreeMarkerRoute("/ismail_sahin/siparis_onay_post") {
        	public Object handle(Request istek, Response cevap) {
        		Map<String, Object> ozellikler = new HashMap<String, Object>();

        		String adres = istek.queryParams("siparisAdres"); 
        		System.out.println(adres);
        		siparis.setAdres(adres);
                try {
					veriTabani.siparisEkle(siparis);
				} catch (Exception e) {
					e.printStackTrace();
				}
                
                siparis = new Siparis();
            	cevap.redirect("/ismail_sahin/ana_sayfa");
                return null;
            }
        };
        post(siparisOnayPostRoute);
        
        /**
         * siparis listele get
         */
        FreeMarkerRoute siparisListeleRoute = new FreeMarkerRoute("/ismail_sahin/siparis_listele") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<String, Object>();
            	
            	try {
					ArrayList<Siparis> siparisList = veriTabani.siparisList();
					ozellikler.put("siparis_list", siparisList);
				} catch (Exception e) {
					e.printStackTrace();
				}
            	return new ModelAndView(ozellikler, "/ismailsahin/siparis_listele.html");
            }
        };
        get(siparisListeleRoute);
        
        
	}
}
