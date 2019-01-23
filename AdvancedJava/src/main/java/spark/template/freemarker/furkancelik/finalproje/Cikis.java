package spark.template.freemarker.furkancelik.finalproje;

import spark.Request;
import spark.Response;

public class Cikis extends IsimAbstract {
    Sunucu sunucu;

    protected Cikis(String path, Sunucu sunucu) {
        super(path);
        this.sunucu = sunucu;
    }

    @Override
    public Object handle(Request request, Response response) {
        sunucu.girisYapmisKullanici = null;
        response.redirect("/furkancelik/giris_sayfasi");
        return null;
    }
}
