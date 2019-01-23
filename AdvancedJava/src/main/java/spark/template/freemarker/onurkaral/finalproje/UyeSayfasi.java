package spark.template.freemarker.onurkaral.finalproje;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.get;
import static spark.Spark.post;

public class UyeSayfasi {
    public static void sayfalariTanimla() {
        UyeSayfasiTanimla();
        UyeFormTanimla();
    }

		private static void UyeFormTanimla() {
        	Route girisFormPostAction = new Route("/onurkaral/Uye_Sayfasi/create") {
                @Override
                public Object handle(Request istek, Response cevap) {
                    String kullaniciadi = istek.queryParams("kullaniciadi");
                        String sifre = istek.queryParams("sifre");
                        
                    return null;
                }
            };
            post(girisFormPostAction);
        }

		private static void UyeSayfasiTanimla(){
        FreeMarkerRoute UyeSayfasi = new FreeMarkerRoute("/onurkaral/Uye_Sayfasi/") {
            @Override
            public Object handle(Request istek1, Response cevap1) {
                return new ModelAndView(null, "/onurkaral/finalproje/Uye_Sayfasi.html");
            }
        };
        get(UyeSayfasi);
    }
    }

