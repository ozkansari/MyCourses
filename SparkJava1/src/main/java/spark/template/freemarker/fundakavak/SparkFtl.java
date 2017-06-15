package spark.template.freemarker.fundakavak;
import java.util.*;

import spark.*;
import spark.template.freemarker.*;

import static spark.Spark.*;

/**
 * Created by berka on 27.05.2017.
 */
public class SparkFtl {
    public static void main(String[] args) {

        List<Ogrenci> ogrencilistesi = new ArrayList<Ogrenci>();
        List<Ders> derslistesi = new ArrayList<Ders>();


        ogrencilistesi.add(new Ogrenci("Ogrenci Bir", "Yüksek Lisans", "MYO", 1));
        ogrencilistesi.add(new Ogrenci("Ogrenci Iki", "On Lisans", "MYO", 2));
        ogrencilistesi.add(new Ogrenci("Ogrenci Uc", "On Lisans", "MYO", 3));
        derslistesi.add(new Ders("Bilişim Hukuku", 15, 12, 1235));

        setPort(4567);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrencilistesi);
                return new ModelAndView(attributes, "fundakavak/ogrenciler.html"); // resources'daki html veya ftl
            }
        };
        get(ogrencilerGet);

        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrencilistesi);
                return new ModelAndView(attributes, "fundakavak/ogrenciekle.html"); // resources'daki html veya ftl
            }
        };
        get(ogrenciekleGet);

        FreeMarkerRoute ogrencidetayGet = new FreeMarkerRoute("/ogrencidetay") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrencilistesi);
                return new ModelAndView(attributes, "fundakavak/ogrencidetay.html"); // resources'daki html veya ftl
            }
        };
        get(ogrencidetayGet);
        FreeMarkerRoute dersdetayGet = new FreeMarkerRoute("/dersdetay") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", derslistesi);
                return new ModelAndView(attributes, "fundakavak/dersdetay.html"); // resources'daki html veya ftl
            }
        };
        get(dersdetayGet);

        FreeMarkerRoute derslerGet = new FreeMarkerRoute("/dersler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", derslistesi);
                return new ModelAndView(attributes, "fundakavak/dersler.html"); // resources'daki html veya ftl
            }
        };
        get(derslerGet);

        FreeMarkerRoute dersEkleGet = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", derslistesi);
                return new ModelAndView(attributes, "fundakavak/dersekle.html"); // resources'daki html veya ftl
            }
        };
        get(dersEkleGet);
       /* Öğrenci ekle */
        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                String ad = req.queryParams("ad");
                String tip = req.queryParams("tip");
                String bolum = req.queryParams("bolum");
                int no = Integer.parseInt(req.queryParams("no"));
                ogrencilistesi.add(new Ogrenci(ad, tip, bolum, no));

                resp.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);
/* öğrenci ekle bitiş*/

/*öğrenci sil*/
        FreeMarkerRoute ogrencisilPost = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                int silinecekOgrencininIndexi = -1;
                int secilenOgrenci = Integer.parseInt(req.queryParams("OgrenciSildirme"));
                for (int i = 0; i < ogrencilistesi.size(); i++) {
                    Ogrenci student = ogrencilistesi.get(i);
                    if (secilenOgrenci == student.no) {
                        silinecekOgrencininIndexi = i;
                        break;
                    }
                }
                ogrencilistesi.remove(silinecekOgrencininIndexi);
                resp.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencisilPost);
/* öğrenci sil bitiş*/

        FreeMarkerRoute dersDetayi = new FreeMarkerRoute("/dersdetay") {
            public Object handle(Request req, Response resp) {
                int dersIndeksi = -1;
                int secilenDers = Integer.parseInt(req.queryParams("secilenDers"));
                for (int i = 0; i < derslistesi.size(); i++) {
                    Ders dersler = derslistesi.get(i);
                    if (secilenDers == dersler.dersId) {
                        dersIndeksi = i;
                        break;
                    }
                }
                Ders dersdetayi = derslistesi.get(dersIndeksi);
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersdetay", dersdetayi);
                return new ModelAndView(attributes, "fundakavak/dersdetay.html");
            }
        };
        post(dersDetayi);

        FreeMarkerRoute secilenOgrencininDetayi = new FreeMarkerRoute("/ogrencidetay") {
            public Object handle(Request req, Response resp) {

                int ogrenciIndeksi = -1;
                int secilenOgrenci = Integer.parseInt(req.queryParams("OgrenciCheckbox"));
                for (int i = 0; i < ogrencilistesi.size(); i++) {
                    Ogrenci student = ogrencilistesi.get(i);
                    if (secilenOgrenci == student.no) {
                        ogrenciIndeksi = i;
                        break;
                    }
                }
                Ogrenci ogrencidetayi = ogrencilistesi.get(ogrenciIndeksi);
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrencidetay", ogrencidetayi);
                /* OZKANS: EKLENDI*/ return null;
            }
        };

        post(secilenOgrencininDetayi);

        FreeMarkerRoute ogrenciyeDersEkleme = new FreeMarkerRoute("/ogrencidetay") {
            public Object handle(Request req, Response resp) {
                int ogrenciNum = Integer.parseInt(req.queryParams("ogrenciNum"));
                int dersler = Integer.parseInt(req.queryParams("DersSecim"));
                int ogrenciIndeksi = -1;
                for (int i = 0; i < ogrencilistesi.size(); i++) {
                    Ogrenci student = ogrencilistesi.get(i);
                    if (ogrenciNum == student.no) {
                        ogrenciIndeksi = i;
                        break;
                    }
                }
                int dersinIndeksi = -1;
                for (int i = 0; i < derslistesi.size(); i++) {
                    Ders lesson = derslistesi.get(i);
                    if (dersler == lesson.dersId) {
                        dersinIndeksi = i;
                        break;
                    }
                }
                Ogrenci secilenOgrenci = ogrencilistesi.get(ogrenciIndeksi);
                Ders secilenDers = derslistesi.get(dersinIndeksi);

                secilenOgrenci.getSecilenDersler().add(secilenDers);
                secilenDers.getDersinOgrencileri().add(secilenOgrenci);

                return null;
            }
        };

        post(ogrenciyeDersEkleme);

        FreeMarkerRoute dersEklePost = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {

                String dersAdi = req.queryParams("dersAdi");
                int dersKredi = Integer.parseInt(req.queryParams("dersKredi"));
                int dersAKTS = Integer.parseInt(req.queryParams("dersAKTS"));
                int dersId = Integer.parseInt(req.queryParams("dersId"));
                int ayniidliders = -1;

                for (int i = 0; i < derslistesi.size(); i++) {
                    Ders dersler = derslistesi.get(i);
                    if (dersId == dersler.getDersId()) {
                        ayniidliders = i;
                        derslistesi.remove(ayniidliders);
                        break;
                    }
                }
                derslistesi.add(new Ders(dersAdi, dersKredi, dersAKTS, dersId));

                resp.redirect("/dersler");
                return null;
            }
        };
        post(dersEklePost);

    }
}
