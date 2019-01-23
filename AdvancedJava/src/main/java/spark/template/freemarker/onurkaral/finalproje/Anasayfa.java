package spark.template.freemarker.onurkaral.finalproje;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.get;

public class Anasayfa {
    public static void sayfalariTanimla() {
        anaSayfaGET();
    }

    private static void anaSayfaGET() {
        FreeMarkerRoute anaSayfa = new FreeMarkerRoute("/onurkaral/") {
            @Override
            public Object handle(Request istek, Response cevap) {

                Kullanici kullanici = UygulamaMain.girisYapmisKullanici;
                if (kullanici == null) {
                    System.out.println("Once Giris Yapilmali");
                    cevap.redirect("/onurkaral/giris_sayfasi/");
                }

                Map<String, Object> sayfaVerisi = new HashMap<String, Object>();
                sayfaVerisi.put("kullaniciadi", kullanici.getKullaniciAdi());
                return new ModelAndView(sayfaVerisi, "/onurkaral/finalproje/anasayfa.html");
            }
        };
        get(anaSayfa);
    }
}
