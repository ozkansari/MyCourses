package spark.template.freemarker.furkancelik.finalproje;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class HataSayfasi extends IsimAbstract {

    Sunucu sunucu;
    protected HataSayfasi(String path, Sunucu sunucu) {
        super(path);
        this.sunucu = sunucu;
    }

    @Override
    public Object handle(Request request, Response response) {
        Map<String, Object> sayfaVerisi = new HashMap<String, Object>();
        sayfaVerisi.put("hata", sunucu.hata);
        return new ModelAndView(sayfaVerisi,"/furkancelik/finalproje/hata.html");
    }
}
