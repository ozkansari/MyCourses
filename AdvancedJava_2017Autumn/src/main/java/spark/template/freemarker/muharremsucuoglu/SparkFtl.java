package spark.template.freemarker.muharremsucuoglu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import spark.template.freemarker.muharremsucuoglu.yonetim.data.Urun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class SparkFtl {

    /*--
     * http://taywils.me/2013/11/05/javasparkframeworktutorial/
     */
    public static void main(String[] args) {


        Logger logger = LoggerFactory.getLogger(SparkFtl.class);
        logger.info("Hello World");


        List<Urun> urunListesi = new ArrayList<>();
        urunListesi.add(new Urun("Camsil", 12.50, "Temizlik", 124));
        urunListesi.add(new Urun("Ekmek", 1.25, "Yemek", 2));
        urunListesi.add(new Urun("Coca Cola", 4.75, "İçecek", 3));

        setPort(4567);

//Yonetim kisminin kodlari

        FreeMarkerRoute getUrunList = new FreeMarkerRoute("/MuharremSucuoglu/yonetim/urunListesi") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("urunListesi", urunListesi);
                return new ModelAndView(attributes, "/muharremsucuoglu/Urunler.html"); // resources'daki html veya ftl
            }
        };
        get(getUrunList);

        FreeMarkerRoute getAddUrun = new FreeMarkerRoute("/MuharremSucuoglu/yonetim/urunEkle") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("urunListesi", urunListesi);
                return new ModelAndView(attributes, "/muharremsucuoglu/UrunEkle.html"); // resources'daki html veya ftl
            }
        };
        get(getAddUrun);

        FreeMarkerRoute getUrunDetail = new FreeMarkerRoute("/MuharremSucuoglu/yonetim/urunDetay") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("urunListesi", urunListesi);
                return new ModelAndView(attributes, "/muharremsucuoglu/UrunDetay.html"); // resources'daki html veya ftl
            }
        };
        get(getUrunDetail);

//kullanici Kismi

        FreeMarkerRoute getKullaniciUrunList = new FreeMarkerRoute("/MuharremSucuoglu/Anasayfa") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("urunListesi", urunListesi);
                return new ModelAndView(attributes, "/muharremsucuoglu/Anasayfa.html"); // resources'daki html veya ftl
            }
        };
        get(getKullaniciUrunList);


        // ------------------------------------------------------------------------------------- üst kısım hash maplerle alakalı ----------------------------------------------------
        FreeMarkerRoute postAddUrun = new FreeMarkerRoute("/MuharremSucuoglu/yonetim/urunEkle") {
            public Object handle(Request req, Response resp) {
                String urunAdi = req.queryParams("urunAdi");
                String urunKategori = req.queryParams("urunKategori");
                double fiyat = Double.parseDouble(req.queryParams("urunFiyati"));
                int urunNo = Integer.parseInt(req.queryParams("urunNo"));

                urunListesi.add(new Urun(urunAdi, fiyat, urunKategori, urunNo));

                resp.redirect("/MuharremSucuoglu/yonetim/urunListesi");
                return null;
            }
        };
        post(postAddUrun);

        FreeMarkerRoute postDeleteUrun = new FreeMarkerRoute("/MuharremSucuoglu/yonetim/urunListesi") {
            public Object handle(Request req, Response resp) {
                int silinecekUrunIndexi = -1;
                int secilenUrun = Integer.parseInt(req.queryParams("urunSildirme"));
                for (int i = 0; i < urunListesi.size(); i++) {
                    Urun student = urunListesi.get(i);
                    if (secilenUrun == student.urunNo) {
                        silinecekUrunIndexi = i;
                        break;
                    }
                }
                urunListesi.remove(silinecekUrunIndexi);
                resp.redirect("/MuharremSucuoglu/yonetim/urunListesi");
                return null;
            }
        };
        post(postDeleteUrun);

        FreeMarkerRoute postSelectedUrunDetail = new FreeMarkerRoute("/MuharremSucuoglu/yonetim/urunDetay") {
            public Object handle(Request req, Response resp) {

                int urunIndeksi = -1;
                int secilenUrun = Integer.parseInt(req.queryParams("urunlerCheckbox"));
                for (int i = 0; i < urunListesi.size(); i++) {
                    Urun student = urunListesi.get(i);
                    if (secilenUrun == student.urunNo) {
                        urunIndeksi = i;
                        break;
                    }
                }
                Urun urunDetayi = urunListesi.get(urunIndeksi);
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("urunDetay", urunDetayi);
                return new ModelAndView(attributes, "/muharremsucuoglu/UrunDetay.html");
            }
        };
        post(postSelectedUrunDetail);
    }
}
