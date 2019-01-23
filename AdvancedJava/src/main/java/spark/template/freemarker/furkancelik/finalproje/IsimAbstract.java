package spark.template.freemarker.furkancelik.finalproje;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.*;

/**
 * Isim abstract sınıfı tüm ürllerin başına isim eklemek için kullandım
 * örneğin /(herhangi bir isim)/sayfa-adi
 * Sparkın route classi ile extend edildi, sebebi her sınıf aslında sparkın bir sınıfı gibi davranacaktır
 */
public class IsimAbstract extends FreeMarkerRoute {

    /**
     * Bunu kullanan sınıfların bu fonksiyonu super ile cağırması gerekmektedir
     *
     * @param path
     */
    protected IsimAbstract(String path) {
        super("furkancelik/" + path);
    }

    /**
     * Bu method eğer sınıf içinden cağırılmamışsa tetiklenecektir
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object handle(Request request, Response response) {
        return "Sayfa bulunamadı";
    }
}
