package spark.template.freemarker.muzafferanlas;
import static spark.Spark.*;

import java.util.*;

import spark.*;
import spark.template.freemarker.*;

/*--
 * Programi calistirmak icin Maven projesi olusturun ve pom.xml dosyasina
 *  asagidaki bagimliliklari (dependency) ekleyin:

        <dependency>
            <groupId>com.sparkjava</groupId>
            <artifactId>spark-core</artifactId>
            <version>1.1.1</version>
        </dependency>
        <dependency>
            <groupId>com.sparkjava</groupId>
            <artifactId>spark-template-freemarker</artifactId>
            <version>1.0</version>
        </dependency>

 */
public class SparkFtl {

    /*--
     * http://taywils.me/2013/11/05/javasparkframeworktutorial/
     */
    public static void main(String[] args) {

        final List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Muzaffer Anlaş", "Yüksek Lisans", " Bilgisayar Mühendisliği", "H5150048","-"));
        ogrenciler.add(new Ogrenci("Duygu Özaslan", "Lisans", "Ekonomi", "H5150036","-"));
        ogrenciler.add(new Ogrenci("Miray Keskin", "On Lisans", " Finans", "H150012","-"));



        setPort(1905);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "muzafferanlas/ogrenciler.html"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);

        FreeMarkerRoute ogrenciSilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "muzafferanlas/ogrencisil.html"); // resources'daki ftl
            }
        };
        get(ogrenciSilGet);


        final FreeMarkerRoute ogrencidersGet = new FreeMarkerRoute("/ogrenciders") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "muzafferanlas/ogrenciders.html"); // resources'daki ftl
            }
        };
        get(ogrencidersGet);


        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "muzafferanlas/ogrenciekle.html"); // resources'daki ftl
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


                ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum, numara, ogrenciDers));

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);

        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("ogrencino");

                // Ogrenciyi bul
                Ogrenci bulunan = null;

                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bulunan);

                return new ModelAndView(attributes, "muzafferanlas/ogrenci.html");
            }
        };
        get(ogrenciGoruntule);


        FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.queryParams("ogrencino");

                // Ogrenciyi bul

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

                //ogrenciler.remove(bulunan);

                // Map<String, Object> attributes = new HashMap<>();
                // attributes.put("ogrenci", bulunan);

                // belirtilen uri'ye yonlendir.
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

