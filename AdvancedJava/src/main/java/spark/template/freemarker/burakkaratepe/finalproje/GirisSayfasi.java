package spark.template.freemarker.burakkaratepe.finalproje;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.*;
import spark.template.freemarker.burakkaratepe.finalproje.VeritabaniYonetimi;
import spark.template.freemarker.burakkaratepe.finalproje.dbUser;

//import spark.*;
import static spark.Spark.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GirisSayfasi {
	public static dbUser db = new dbUser();
	
	public static void sayfalariTanimla() {
		get(new FreeMarkerRoute("/burakkaratepe/login/") {
			public ModelAndView handle(Request req, Response res) {
				// TODO Auto-generated method stub
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("response", "");
				if(req.session().attribute("login")!=null) {
					res.redirect("/burakkaratepe/homepage/");
					return null;
				}
				return new ModelAndView(model,"./burakkaratepe/finalproje/login_page.html");
			
			}
		});
		
		post(new FreeMarkerRoute("/burakkaratepe/login/") {
			public ModelAndView handle(Request req, Response res) {
				// TODO Auto-generated method stub			
				Map<String, Object> model = new HashMap<String, Object>();
				String username=req.queryParams("username");
				String password=req.queryParams("password");
				String[] result=db.findOne("where username = '"+username+"' and password = '"+password+"'");
				if(result==null) {
					model.put("response", "Giriş Başarısız");
				}else {
					System.out.println(result[0]+"-"+result[1]+"-"+result[2]+"-"+result[3]);
					
					req.session().attribute("login",true);
					req.session().attribute("id",result[0]);
					req.session().attribute("username",result[1]);
					
					req.session().attribute("type",Integer.parseInt(result[3]));
					res.redirect("/burakkaratepe/homepage/");
					return null;
					// return new ModelAndView(null,"./burakkaratepe/finalproje/login_page.html");
				}
			
				return new ModelAndView(model,"./burakkaratepe/finalproje/login_page.html");
			
			}
		});
		post(new FreeMarkerRoute("/burakkaratepe/register/") {
			public ModelAndView handle(Request req, Response res) {
				// TODO Auto-generated method stub			
				Map<String, Object> model = new HashMap<String, Object>();
				String username=req.queryParams("username");
				String password=req.queryParams("password");
				String[] result=db.findOne("where username = '"+username+"'");
				
				if(result!=null) {
					System.out.println(result);
					model.put("response", "Bu kullanıcı adı kullanımda!");
					return new ModelAndView(model,"./burakkaratepe/finalproje/login_page.html");
				}
				if(db.insert(username,password,0)) {
					model.put("response", "Kayıt Başarılı!");
				}else {
					model.put("response", "Bir hata oluştu!");
					
				}
				return new ModelAndView(model,"./burakkaratepe/finalproje/login_page.html");
			
			}
		});
		get(new FreeMarkerRoute("/burakkaratepe/logout/") {
			public ModelAndView handle(Request req, Response res) {
				// TODO Auto-generated method stub			
				req.session().attribute("login",null);
				res.redirect("/burakkaratepe/login/");
				return null;
				
			
			}
		});
		
	}

}
