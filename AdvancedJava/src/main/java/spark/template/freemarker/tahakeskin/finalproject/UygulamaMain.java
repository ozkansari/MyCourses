package spark.template.freemarker.tahakeskin.finalproject;

import java.beans.Statement;

public class UygulamaMain {
	 
	public static void main(String[] args) {
		
		VeriTabaniClass.veritabaniAyarla();
		VeriTabaniClass.tablolariOlustur();
		
		VeriTabaniClass.kullaniciEkle("admin", "admin", 11, "e", "admin");//bi seferlik
		VeriTabaniClass.kullaniciEkle("user", "normal", 11, "e", "user");//bi seferlik
	
		
		//(1) http://localhost:4567/tahakeskin/giris_sayfasi
		GirisSayfasi.sayfalariTanimla();
		
		//(2) http://localhost:4567/tahakeskin/uye_sayfasi
		UyeSayfasi.sayfalariTanimla();
		
		//(3) http://localhost:4567/tahakeskin/				(giris sayfasindan çaðýrýlacak)
		//(4) http://localhost:4567/tahakeskin/yonetici 	(giris sayfasindan çaðýrýlacak)

	}
}






