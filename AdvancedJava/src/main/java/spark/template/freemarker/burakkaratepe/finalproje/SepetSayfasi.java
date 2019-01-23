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
public class SepetSayfasi {
	private static dbCart db = new dbCart();
	public static void sayfalariTanimla() {
		get(new FreeMarkerRoute("/burakkaratepe/cart/") {
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
				int userId=Integer.parseInt((String) req.session().attribute("id"));
				List<String[]> list=db.find("WHERE userId = "+userId);
				model.put("carts",list);
				return new ModelAndView(model,"./burakkaratepe/finalproje/cart_page.html");
			}
		});
		get(new FreeMarkerRoute("/burakkaratepe/addCart/") {
			public ModelAndView handle(Request req, Response res) {
				// TODO Auto-generated method stub
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("username",req.session().attribute("username"));
				model.put("admin",req.session().attribute("type"));
				model.put("response", "");
				if(req.session().attribute("login")==null || req.session().attribute("type").equals("0")) {
					res.redirect("/burakkaratepe/homepage/"); return null;
				}
				int productId=Integer.parseInt(req.queryParams("id"));
				int userId=Integer.parseInt((String) req.session().attribute("id"));
				String title=req.queryParams("title");
				int price=Integer.parseInt(req.queryParams("price"));
				System.out.println("pid:"+productId+"-userid:"+userId);
				if(db.insert(userId, productId,title,price)) {
					model.put("response", "Sepete Eklendi");
				}else {
					model.put("response", "Bir Hata oldu!");
				}
				List<String[]> list=db.find("where userId = "+userId);
				model.put("carts",list);
				return new ModelAndView(model,"./burakkaratepe/finalproje/cart_page.html");
			
			}
		});
		get(new FreeMarkerRoute("/burakkaratepe/removeCart/") {
			
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
					model.put("response", "Sipariş Silindi");
				}else {
					model.put("response", "Bir Hata oldu!");
				}
				
				int userId=Integer.parseInt((String) req.session().attribute("id"));
				List<String[]> list=db.find("where userId = "+userId);
				model.put("carts",list);
				return new ModelAndView(model,"./burakkaratepe/finalproje/cart_page.html");
			
			}
		});
		
		
	}

}
