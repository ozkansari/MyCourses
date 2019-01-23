package spark.template.freemarker.burakkaratepe.finalproje;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import spark.template.freemarker.burakkaratepe.finalproje.SepetSayfasi;
import spark.template.freemarker.burakkaratepe.finalproje.UrunSayfasi;
import spark.template.freemarker.burakkaratepe.finalproje.UyeSayfasi;
import spark.template.freemarker.burakkaratepe.finalproje.VeritabaniYonetimi;

public class UygulamaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VeritabaniYonetimi.veritabaniBaglantisiKur();
		VeritabaniYonetimi.tablolariOlustur();
		
		SepetSayfasi.sayfalariTanimla();
		UrunSayfasi.sayfalariTanimla();
		GirisSayfasi.sayfalariTanimla();
		UyeSayfasi.sayfalariTanimla();
	}
}
