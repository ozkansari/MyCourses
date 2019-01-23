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
public class UrunSayfasi {
	private static dbProducts db = new dbProducts();
	public static void sayfalariTanimla() {
		get(new FreeMarkerRoute("/burakkaratepe/homepage/") {
			public ModelAndView handle(Request req, Response res) {
				// TODO Auto-generated method stub
				if(req.session().attribute("login")==null) {
					 res.redirect("/burakkaratepe/login/");
					 return null;
				}
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("username",req.session().attribute("username"));
				model.put("admin",req.session().attribute("type"));
				model.put("response", "");
				List<String[]> list=db.find("");
				model.put("products",list);
				return new ModelAndView(model,"./burakkaratepe/finalproje/home_page.html");
			
			}
		});
		post(new FreeMarkerRoute("/burakkaratepe/addProduct/") {
			public ModelAndView handle(Request req, Response res) {
				// TODO Auto-generated method stub
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("username",req.session().attribute("username"));
				model.put("admin",req.session().attribute("type"));
				model.put("response", "");
				if(req.session().attribute("login")==null || req.session().attribute("type").equals("0")) {
					res.redirect("/burakkaratepe/homepage/"); return null;
				}
				String title=req.queryParams("title");
				String description=req.queryParams("description");
				int price=Integer.parseInt(req.queryParams("price"));
				if(db.insert(title, description, price)) {
					model.put("response", "Ürün Eklendi");
				}else {
					model.put("response", "Bir Hata oldu!");
				}
				List<String[]> list=db.find("");
				model.put("products",list);
				return new ModelAndView(model,"./burakkaratepe/finalproje/home_page.html");
			
			}
		});
		get(new FreeMarkerRoute("/burakkaratepe/removeProduct/") {
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
					model.put("response", "Ürün Silindi");
				}else {
					model.put("response", "Bir Hata oldu!");
				}
				List<String[]> list=db.find("");
				model.put("products",list);
				return new ModelAndView(model,"./burakkaratepe/finalproje/home_page.html");
			
			}
		});
		
		
	}

}
