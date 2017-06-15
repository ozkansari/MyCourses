package spark.template.freemarker.mustafacanyilmaz;
import static spark.Spark.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.derby.impl.sql.execute.AutoincrementCounter;
import org.apache.log4j.BasicConfigurator;

import spark.*;
import spark.template.freemarker.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SparkFtl {


public static void main(String[] args) throws SQLException  {
	BasicConfigurator.configure();
        List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        
        ogrenciler.add(new Ogrenci(55,"Mustafa Can Yilmaz", "On Lisans", "MYO","17","Android","Matematik"));
     
        ogrenciler.add(new Ogrenci(66,"Ahmet Canli", "On Lisans", "MYO","20","Java","C++"));
        
        ogrenciler.add(new Ogrenci(77,"Candan Ozturk",  "On Lisans", "Eczacilik","33","Eczacilik","Matematik"));
   

        
         //setPort(7575);
        
        FreeMarkerRoute hakkimizda = new FreeMarkerRoute("/hakkimizda") {
            public Object handle(Request req, Response resp) {
               return new ModelAndView(null, "mustafacanyilmaz/hakkimizda.ftl"); 
            }
        };
        get(hakkimizda);
     
        
        //anasayfa ilk açılacak sayfa.
        FreeMarkerRoute anasayfa = new FreeMarkerRoute("/anasayfa") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                
                return new ModelAndView(attributes, "mustafacanyilmaz/anasayfa.ftl"); 
            }
        };
        get(anasayfa);
        
        FreeMarkerRoute ogrencilistele = new FreeMarkerRoute("/ogrencilistele") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                
                return new ModelAndView(attributes, "mustafacanyilmaz/ogrencilistele.ftl"); // resources'daki ftl
            }
        };
        get(ogrencilistele);
        

        FreeMarkerRoute ogrenciDetaySayfasi = new FreeMarkerRoute("/ogrenciDetaySayfasi") {
            public Object handle(Request req, Response resp) {
            
            	int ogrenciIndex = -1;
            	int ogrenciNo = Integer.parseInt(req.queryParams("ogrenciNo"));
            	for(int i = 0; i<ogrenciler.size(); i++){
            		if(ogrenciler.get(i).Id == ogrenciNo){
            			ogrenciIndex = i;
            			break;
            		}
            	}
            
            	Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", ogrenciler.get(ogrenciIndex));
                
                return new ModelAndView(attributes, "mustafacanyilmaz/ogrenciDetay.ftl"); // resources'daki ftl
            }
        };
        post(ogrenciDetaySayfasi);
        
        
        // Textbox ile bir input alıp silmenin sebebi örnek 500 tane kayıt var 500 kayıt içinden kişiyi arayıp,
        // butonla yanından silmek yerine orda ID'sini biliyorsa Id'yi girip silmesi. Bir nevi kolaylık sağlamak adına yaptım.
        FreeMarkerRoute ogrencilisteleSilme = new FreeMarkerRoute("/ogrencilistele2") {
            public Object handle(Request req, Response resp) {
            
            	int silinecekId = -1;
            	int silinecekOgrenciIdAl = Integer.parseInt(req.queryParams("silText"));
            	         
            	for(int i = 0; i<ogrenciler.size(); i++){
            		Ogrenci ogrenci1 = ogrenciler.get(i);
            		
            		if(silinecekOgrenciIdAl == ogrenci1.Id){
            			silinecekId = i;
            			break;
            		}
            		
            	}
            	ogrenciler.remove(silinecekId);
            	resp.redirect("/ogrencilistele");
            	return null;
            }
        };
        post(ogrencilisteleSilme);
        
        // Ogrenciyi butonla silme
        FreeMarkerRoute ogrenciButonlaSil = new FreeMarkerRoute("/ogrencilistele") {
            public Object handle(Request req, Response resp) {
            		int silinecekOgrencininIndexi = -1;
            	   
            	 int alinanOgrenciId = Integer.parseInt(req.queryParams("ogrenciNo"));
            	 for (int i = 0; i < ogrenciler.size(); i++) {
                     Ogrenci ogrenci1 = ogrenciler.get(i);
                     if (alinanOgrenciId == ogrenci1.Id) {
                         silinecekOgrencininIndexi = i;
                         break;
                     }
                 }
            	ogrenciler.remove(silinecekOgrencininIndexi);
            	resp.redirect("/ogrencilistele");
            	return null;
            }
        };
        post(ogrenciButonlaSil);

        //Ogrenci Detay
        FreeMarkerRoute ogrenciDetay = new FreeMarkerRoute("/ogrencidetay") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "mustafacanyilmaz/ogrenciDetay.ftl");
            }
        };
        get(ogrenciDetay);
           
        //ogrenci ekle
        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "mustafacanyilmaz/ogrenciekle2.ftl"); 
            }
        };
        get(ogrenciekleGet);
        
        //Girilen ogrenci değerlerini post yani gönderme, yazma
        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
        	
            public Object handle(Request istek, Response cevap) {
            	
            	int Id = Integer.parseInt(istek.queryParams("ogrenciId"));
            	String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
                String ogrenciYas = istek.queryParams("ogrenciYas");
                String ogrenciDers1 = istek.queryParams("ogrenciDers1");
                String ogrenciDers2 = istek.queryParams("ogrenciDers2");
                if(adSoyad.isEmpty() || ogrenciTipi.isEmpty() || bolum.isEmpty() ||
                		ogrenciYas.isEmpty() || ogrenciDers1.isEmpty() || ogrenciDers2.isEmpty()){
                	System.out.println("Ogrenci Gerekli Kisimlar Bos Olamaz.");
                	cevap.redirect("/ogrenciekle");
                }else{
                	
                	if(ogrenciTipi.equals("yuksekLisans")){
                		ogrenciler.add(new YuksekLisansOgrencisi(Id, adSoyad, ogrenciTipi, bolum, ogrenciYas, ogrenciDers1, ogrenciDers2));
                	}else if(ogrenciTipi.equals("doktora")){
                		ogrenciler.add(new DoktoraOgrencisi(Id, adSoyad, ogrenciTipi, bolum, ogrenciYas, ogrenciDers1, ogrenciDers2));
                	}
                	else if(ogrenciTipi.equals("prof")){
                		ogrenciler.add(new ProfOgrencisi(Id, adSoyad, ogrenciTipi, bolum, ogrenciYas, ogrenciDers1, ogrenciDers2));
                	}else{
                		 ogrenciler.add(new Ogrenci(Id,adSoyad, ogrenciTipi, bolum,ogrenciYas,ogrenciDers1,ogrenciDers2));
                	}
                	
                
                   cevap.redirect("/ogrencilistele");
                }
                
               
                return null;
            }
        };
        post(ogrencieklePost);
        

        
    }

}

	
