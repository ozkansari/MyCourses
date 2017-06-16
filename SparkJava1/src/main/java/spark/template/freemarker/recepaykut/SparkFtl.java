package spark.template.freemarker.recepaykut;

import static spark.Spark.*;

import java.sql.SQLException;
import java.util.*;

import spark.*;
import spark.template.freemarker.*;


public class SparkFtl {
	

    public static void main(String[] args) throws SQLException {
    	
    	final List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Recep Aykut", "Yuksek Lisans", " Bilgisayar Programciligi"));
        ogrenciler.add(new Ogrenci("Buse Ozcelik", "Lisans", "Ekonomi"));
        ogrenciler.add(new Ogrenci("Miray Keskin", "On Lisans", " Finans"));
        
        
        // HATALI DatabaseConnection.baglantiKur();
        /* OZKANS */ DatabaseConnection.init();

        // setPort(1905);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "recepaykut/ogrenciler.html");
            }
            // BURADA TABLOYU SORGULAMA FONKSÝYONUNU ÇAÐIRMAK ÝSTÝYORUM AMA OLMUYOR.(Select*from için)
        };
        get(ogrencilerGet);

        FreeMarkerRoute ogrenciSilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "recepaykut/ogrencisil.html"); 
            }
        };
        get(ogrenciSilGet);


        final FreeMarkerRoute ogrencidersGet = new FreeMarkerRoute("/ogrenciders") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "recepaykut/ogrenciders.html"); 
            }
        };
        get(ogrencidersGet);


        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "recepaykut/ogrenciekle.html"); 
            }
        };
        get(ogrenciekleGet);

        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {

                String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
                String numara = istek.queryParams("numara");
                String ogrenciDers = istek.queryParams("ogrenciDers");
               

                ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum));
                
                try {
					DatabaseConnection.tabloyaKayitEkle();
				} catch (SQLException e) {
					e.printStackTrace();
				}

                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);

        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("ogrencino");
                Ogrenci bulunan = null;

                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bulunan);

                return new ModelAndView(attributes, "recepaykut/ogrenci.html");
            }
        };
        get(ogrenciGoruntule);


        FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.queryParams("ogrencino");
                
     
                
              //Burada db'ye ogrenci sil komutunu vermeyi bulamadým.
                

                

                try {
                    Ogrenci bulunan = null;
                    for (Ogrenci ogr : ogrenciler) {
                        if (ogr.ogrenciNo.equals(ogrenciNo)) {
                            ogrenciler.remove(ogr);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                resp.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrenciSil);




        final FreeMarkerRoute ogrenciDersEkle = new FreeMarkerRoute("/ogrenciders") {
            public Object handle(Request requ, Response resp) {
                String ogrenciNo = requ.queryParams("ogrencino");
                String ogrenciDers = requ.queryParams("ogrenciders");

                try {


                    Ogrenci bulunan = null;
                    for (Ogrenci ogrm : ogrenciler) {
                        if (ogrm.ogrenciNo.equals(ogrenciNo)) {
                            int x = ogrenciNo.length();
                           String newvalue = ogrm.ogrenciDers.toString();

                           ogrm.ogrenciDers = ogrenciDers;

                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }


                resp.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrenciDersEkle);

    }

}

