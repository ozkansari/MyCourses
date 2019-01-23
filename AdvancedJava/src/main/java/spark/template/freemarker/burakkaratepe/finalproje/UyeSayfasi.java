package spark.template.freemarker.burakkaratepe.finalproje;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import java.util.List;
public class UyeSayfasi {
	private static dbUser db = new dbUser();
	public static void sayfalariTanimla() {
		get(new FreeMarkerRoute("/burakkaratepe/users/") {
			public ModelAndView handle(Request req, Response res) {
				// TODO Auto-generated method stub
				if(req.session().attribute("login")==null || req.session().attribute("type").equals("0")) {
					res.redirect("/burakkaratepe/homepage/"); return null;
				}
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("username",req.session().attribute("username"));
				model.put("admin",req.session().attribute("type"));
				model.put("response", "");
				List<String[]> list=db.find("");
				model.put("users",list);
				return new ModelAndView(model,"./burakkaratepe/finalproje/users_page.html");
			
			}
		});
		get(new FreeMarkerRoute("/burakkaratepe/removeUser/") {
			public ModelAndView handle(Request req, Response res) {
				// TODO Auto-generated method stub
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("username",req.session().attribute("username"));
				model.put("admin",req.session().attribute("type"));
				model.put("response", "");
				if(req.session().attribute("login")==null || req.session().attribute("type").equals("0")) {
					res.redirect("/burakkaratepe/homepage/"); return null;
				}
				int id=Integer.parseInt(req.queryParams("id"));
				if(db.remove(id)) {
					model.put("response", "Üye Silindi");
				}else {
					model.put("response", "Bir Hata oldu!");
				}
				List<String[]> list=db.find("");
				model.put("users",list);
				return new ModelAndView(model,"./burakkaratepe/finalproje/users_page.html");
			
			}
		});
		
		
	}

}
