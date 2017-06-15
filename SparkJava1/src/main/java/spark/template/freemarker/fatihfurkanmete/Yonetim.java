package spark.template.freemarker.fatihfurkanmete;
/**
 * Created by Mete on 25.05.2017.
 */
import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Yonetim {

    public static void main(String[] args) {

        List<Ogrenci> OgrenciListesi = new ArrayList<Ogrenci>();
        List<Ders> DersListesi = new ArrayList<Ders>();

        OgrenciListesi.add(new Ogrenci("Ogrenci Bir", "On Lisans", "MYO", 1));
        OgrenciListesi.add(new Ogrenci("Ogrenci Iki", "On Lisans", "MYO", 2));
        OgrenciListesi.add(new Ogrenci("Ogrenci Uc", "On Lisans", "MYO", 3));
        DersListesi.add(new Ders("Matematik", 1));

        // setPort(4567);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", OgrenciListesi);
                return new ModelAndView(attributes, "fatihfurkanmete/Ogrenciler.html");
            }
        };
        get(ogrencilerGet);
        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", OgrenciListesi);
                return new ModelAndView(attributes, "fatihfurkanmete/OgrenciEkle.html");
            }
        };
        get(ogrenciekleGet);

        FreeMarkerRoute ogrencidetayGet = new FreeMarkerRoute("/ogrencigoruntule") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", OgrenciListesi);
                return new ModelAndView(attributes, "fatihfurkanmete/OgrenciGoruntule.html");
            }
        };
        get(ogrencidetayGet);

        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                String adSoyad = req.queryParams("adSoyad");
                String ogrenciTipi = req.queryParams("ogrenciTipi");
                String bolum = req.queryParams("bolum");
                int numara = Integer.parseInt(req.queryParams("numara"));
                OgrenciListesi.add(new Ogrenci(adSoyad, ogrenciTipi, bolum, numara));
                resp.redirect("/Ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);

        FreeMarkerRoute ogrencisilPost = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                int silinecekOgrencininIndexi = 0;
                int secilenOgrenci = Integer.parseInt(req.queryParams("OgrenciSildirme"));
                for (int i = 0; i < OgrenciListesi.size(); i++) {
                    Ogrenci ogrenci = OgrenciListesi.get(i);
                    if (secilenOgrenci == ogrenci.numara) {
                        silinecekOgrencininIndexi = i;
                        OgrenciListesi.remove(silinecekOgrencininIndexi);
                        break;
                    }
                }
                resp.redirect("/Ogrenciler");
                return null;
            }
        };
        post(ogrencisilPost);

        FreeMarkerRoute dersdetayGet = new FreeMarkerRoute("/dersgoruntule") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", DersListesi);
                return new ModelAndView(attributes, "fatihfurkanmete/DersGoruntule.html");
            }
        };
        get(dersdetayGet);

        FreeMarkerRoute derslerGet = new FreeMarkerRoute("/dersler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", DersListesi);
                return new ModelAndView(attributes, "fatihfurkanmete/Dersler.html");
            }
        };
        get(derslerGet);

        FreeMarkerRoute dersEkleGet = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", DersListesi);
                return new ModelAndView(attributes, "fatihfurkanmete/DersEkle.html");
            }
        };
        get(dersEkleGet);
        FreeMarkerRoute dersDetayi = new FreeMarkerRoute("/dersgoruntule") {
            public Object handle(Request req, Response resp) {
                int dersIndeksi = 0;
                Ders dersDetayi =null ;
                int secilenDers = Integer.parseInt(req.queryParams("secilenDers"));
                for (int i = 0; i < DersListesi.size(); i++) {
                    Ders dersler = DersListesi.get(i);
                    if (secilenDers == dersler.dersId) {
                        dersIndeksi = i;
                        dersDetayi= DersListesi.get(dersIndeksi);
                        break;
                    }
                }
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersdetay", dersDetayi);
                return new ModelAndView(attributes, "fatihfurkanmete/DersGoruntule.html");
            }
        };
        post(dersDetayi);

        FreeMarkerRoute secilenOgrencininDetayi = new FreeMarkerRoute("/ogrencigoruntule") {
            public Object handle(Request req, Response resp) {
                int ogrenciIndeksi = 0;
                Ogrenci ogrenciDetayi = null ;
                int secilenOgrenci = Integer.parseInt(req.queryParams("OgrenciCheckbox"));
                for (int i = 0; i < OgrenciListesi.size(); i++) {
                    Ogrenci ogrenci = OgrenciListesi.get(i);
                    if (secilenOgrenci == ogrenci.numara) {
                        ogrenciIndeksi = i;
                            ogrenciDetayi = OgrenciListesi.get(ogrenciIndeksi);
                         break;
                    }
                }
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrencidetay", ogrenciDetayi);
                return new ModelAndView(attributes, "fatihfurkanmete/OgrenciGoruntule.html");
            }
        };
        post(secilenOgrencininDetayi);

        FreeMarkerRoute dersEklePost = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {

                String dersAdi = req.queryParams("dersAdi");
                int dersId = Integer.parseInt(req.queryParams("dersId"));
                // HATALI int aynıIdliDers = 0;
                int ayniIdliDers = 0;
                for (int i = 0; i < DersListesi.size(); i++) {
                    Ders dersler = DersListesi.get(i);
                    if (dersId == dersler.getDersId()) {
                    	ayniIdliDers = i;
                        DersListesi.remove(ayniIdliDers);
                        break;
                    }
                }
                DersListesi.add(new Ders(dersAdi, dersId));
                resp.redirect("/Dersler");
                return null;
            }
        };
        post(dersEklePost);
    }
}
