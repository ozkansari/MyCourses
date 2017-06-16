package spark.template.freemarker.salihcanterekli;
import static spark.Spark.*;

import java.awt.*;
import java.util.*;
import java.util.List;

import spark.*;
import spark.template.freemarker.*;

import javax.swing.*;

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
        ogrenciler.add(new Ogrenci("Salih Can Terekli", "On Lisans", "MYO","1","Türkçe"));
        ogrenciler.add(new Ogrenci("Zafer Ketenci", "On Lisans", "MYO","2","Matematik"));
        ogrenciler.add(new Ogrenci("Oytun Ofluoğlu", "On Lisans", "MYO","3","Fizik"));
        ogrenciler.add(new Ogrenci("Özkan Sarı", "On Lisans", "MYO","4","Kimya"));
        ogrenciler.add(new Ogrenci("Yavuz İrfanoğlu", "On Lisans", "MYO","5","Android"));
        ogrenciler.add(new Ogrenci("Ali Demir", "On Lisans", "MYO","6","Veri Yapıları"));
        ogrenciler.add(new Ogrenci("Bill Gates", "On Lisans", "MYO","4","Yazılım"));
        ogrenciler.add(new Ogrenci("Nikola Tesla", "On Lisans", "MYO","4","Elektrik ve Elektronik"));


        final List<OgrenciDetay> ogrenciler2 = new ArrayList<OgrenciDetay>();
        ogrenciler2.add(new OgrenciDetay("Öğrenci Seçilmedi", "null", "null","null","null"));




        //setPort(8015);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "salihcanterekli/ogrenciler.html"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);

        FreeMarkerRoute ogrenciSilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "salihcanterekli/ogrencisil.html"); // resources'daki ftl
            }
        };
        get(ogrenciSilGet);


        FreeMarkerRoute ogrenciDersGet = new FreeMarkerRoute("/ogrenciders") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "salihcanterekli/ogrenciders.html"); // resources'daki ftl
            }
        };
        get(ogrenciDersGet);

        FreeMarkerRoute ogrenciDetayGet = new FreeMarkerRoute("/ogrencidetay") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler2", ogrenciler2);
                return new ModelAndView(attributes, "salihcanterekli/ogrencidetay.html"); // resources'daki ftl
            }
        };
        get(ogrenciDetayGet);


        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "salihcanterekli/ogrenciekle.html"); // resources'daki ftl
            }
        };
        get(ogrenciekleGet);

        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {

                String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
                String numara = "70";
                String ders = istek.queryParams("ders");
                int otoNumara = 1;
                try{
                    for (Ogrenci OgrVeri :ogrenciler){
                        if (OgrVeri.ogrenciNo != numara){
                            otoNumara++;
                        }
                    }
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
                String otoNumara2 = Integer.toString(otoNumara);
                ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum, otoNumara2, ders));
                System.out.println("${variable} = "+ adSoyad);
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

                return new ModelAndView(attributes, "salihcanterekli/ogrenci.html");
            }
        };
        get(ogrenciGoruntule);



        FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil ") {
            public Object handle(Request req, Response resp) {

                String ogrenciNo = req.queryParams("ogrencino");
                System.out.println(ogrenciNo);


                System.out.println("${ogrencino} = " + ogrenciNo);

                try{
                    int otoNumara = 0;
                    for (Ogrenci OgrVeri :ogrenciler){
                        otoNumara++;
                        if (OgrVeri.ogrenciNo.equals(ogrenciNo)){
                            ogrenciler.remove(OgrVeri);
                            otoNumara=0;
                            for (Ogrenci ogrm : ogrenciler) {
                                    otoNumara++;
                                    int x = ogrenciNo.length();
                                    ogrm.ogrenciNo = Integer.toString(otoNumara);
                            }
                        }
                    }
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }


                resp.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrenciSil);



        FreeMarkerRoute ogrenciDetay = new FreeMarkerRoute("/ogrencidetay ") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.queryParams("ogrencinum");
                System.out.println(ogrenciNo);
                try {
                    Ogrenci bulunan = null;
                    for (Ogrenci ogrm : ogrenciler) {

                        String geciciAd = ogrm.adSoyad;
                        String geciciTip = ogrm.ogrenciTipi;
                        String geciciBolum = ogrm.bolum;
                        String geciciNum = ogrm.ogrenciNo;
                        String geciciDers = ogrm.ogrenciDers;
                        for (OgrenciDetay ogrgecici : ogrenciler2)
                        {
                            if (ogrm.ogrenciNo.equals(ogrenciNo)) {
                                int x = ogrenciNo.length();
                                String newvalue = ogrm.ogrenciDers.toString();
                                ogrgecici.adSoyad = geciciAd;
                                ogrgecici.ogrenciTipi = geciciTip;
                                ogrgecici.bolum = geciciBolum;
                                ogrgecici.ogrenciNo = geciciNum;
                                ogrgecici.ogrenciDers = geciciDers;
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                resp.redirect("/ogrencidetay");
                return null;
            }
        };
        post(ogrenciDetay);




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

                            ogrm.ogrenciDers = ogrm.ogrenciDers + "<br>" + ogrenciDers;

                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }


                resp.redirect("/ogrenciders");
                return null;
            }
        };
        post(ogrenciDersEkle);








    }
}


