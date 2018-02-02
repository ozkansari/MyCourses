package spark.template.freemarker.dogankoc;

import java.beans.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

import static spark.Spark.*;
import spark.template.freemarker.*;

public class Spark {

	/**
	* This class draws a bar chart.
	* @author Dogan Koc
	* @version 1.0
	*/
	static DerbyDatabase database;
	static List<Products> products=new ArrayList<Products>();
	static List<Products> productDetail=new ArrayList<Products>();
	static String id="";
	
	public static void main(String[] args) {
 
		staticFileLocation("/spark/template/freemarker/dogankoc");
		
		database=new DerbyDatabase();
		
		// http://localhost:4567/dogankoc/Home
		homePage();
		
		addingProductsManagementPage();
		// http://localhost:4567/doganKoc/Management/AddingProducts
		addNewProductsManagement();
		// http://localhost:4567/doganKoc/Management/productsList
		productsListManagementPage();
		//productsList.html delete linkine t�klan�nca silme i�lemlerini yap
		deleteProductsManagementRoute();
		
		showProductDetailsManagementPage();
	
		// http://localhost:4567/dogankoc/payment
		paymentPage();
		paymentPage2();
		pay();
		myOrder();
		eraseProductOnCart();
		addProductOnCart();
		//http://localhost:4567/dogankoc/Details
		 detailsPage();
		 detailsProcess();
		 getSamsung();
		 getMsi();
		 getApple();
		 getAsus();
		 getLg();
		 getLenovo();
		 getVestel();
		 getLenovoPC();

		 homeProcess();
	}
	/**
	* bu method kullanicinin gordugu ana sayfa y� modelleyen FreeMarker nesnesine sahiptir.
	* t�m urunlerin bulundugu liste ile beraber siparislerin bulundugu ayri bir listeyle beraber
	* modeller ki bu methodun html tarafinda siparislerin adedi bulunabilsin
	* @return ModelAndView
	*/
	private static void homePage()
	{
			
		FreeMarkerRoute route=new FreeMarkerRoute("/dogankoc/Home"){
			@Override
			public Object handle(Request request, Response answer) {
				List<Products> products =getProductList();
                
			    Map<String,Object> model = new HashMap<String, Object>();
				model.put("products", products);
				List<Integer> paymentCount=new ArrayList<Integer>();
				paymentCount.add(DerbyDatabase.paymentList.size());
				model.put("paymentCount",paymentCount );
				return new ModelAndView(model,"dogankoc/dogankoc.Home.html");
			}
			
		};
		
		get(route);
	}
	/**
	*Ana sayfa uzerinden yapilan siparis gonderimini karsilar,urun id si alir ve bu id ye sahip olan urunu ana tablo(urunler) den bularak
	*bir sinif degiskeninde saklar ve   paymentList isimli siparisler listesine urun bilgilerini kaydeder
	* @return null
	*/
	private static void homeProcess()
	{
			
		FreeMarkerRoute route=new FreeMarkerRoute("/homeProcess"){
			@Override
			public Object handle(Request request, Response answer) {
				id=request.queryParams("id");
				//DerbyDatabase.takeAnOrder(DerbyDatabase.findProductsById(id));
				
				for(Products p: getProductList()){
					if(p.getId().equals(id)){
						DerbyDatabase.paymentList.add(p);
						System.out.println("sipari� sepete eklendi");
					}
				}
				
			   answer.redirect("/dogankoc/Home");
               return null;
			}
			
		};
		
		get(route);
	}
	
	/**
	*Ana sayfa uzerinden yapilan detay gorunteleme istegini karsilar,
	*urun id si alir ve bu id ye sahip olan urunu ana tablo(urunler) den bularak
	*productDetail isimli listeye ekleyen Details.html in islem Route unun yapildigi metoddur
	* @return null
	*/

	private static void detailsProcess()
	{
			
		FreeMarkerRoute route=new FreeMarkerRoute("/DetailsProcess"){
			@Override
			public Object handle(Request request, Response answer) {
				String id=request.queryParams("id");
				productDetail =DerbyDatabase.findProductsById(id);

	            answer.redirect("/dogankoc/Details");
				return null;
			}
			
		};
		
		get(route);
	}
	/**
    *DetailsProcess isimli Route ile yapilan islemlerden sonra Details sayfasinin gosterilmesi yapilan metoddur
	* @return ModelAndView
	*/
	private static void detailsPage()
	{
			
		FreeMarkerRoute route=new FreeMarkerRoute("/dogankoc/Details"){
			@Override
			public Object handle(Request request, Response answer) {
	           
			    Map<String,Object> model = new HashMap<String, Object>();
				model.put("products", productDetail);
				return new ModelAndView(model,"dogankoc/dogankoc.Details.html");
			}
			
		};
		
		get(route);
	}
	/**
	    * Tum urunlerin bulundugu tablodaki verileri anlik kullanim icin sakladigimiz listeye hizli erisim icin
		* @return List<Products>
		*/
	private static List<Products> getProductList(){
		return DerbyDatabase.products;
	}
	/**
	    * Ana sayfadan sepetteki urunlerin odemesi yapilmasi icin yonlendirilen sayfanin gosterilmesi
		* @return ModelAndView
		*/
	private static void paymentPage()
	{
		
		FreeMarkerRoute route=new FreeMarkerRoute("/dogankoc/payment"){
			@Override
			public Object handle(Request request, Response answer) {
			    Map<String,Object> model = new HashMap<String, Object>();
		        
				model.put("paymentList", DerbyDatabase.paymentList);
				return new ModelAndView(model,"dogankoc/dogankoc.payment.html");
			}
			
		};
		
		get(route);	
	}
	/**
	    * odeme sayfasi gosterilmeden once tiklanan urunun siparisler static Listemize eklenmesi islemlerinin yapildigi Route islemleri
		* @return null
		*/
	private static void paymentPage2()
	{
		
		FreeMarkerRoute route2=new FreeMarkerRoute("/paymentProcess"){
			@Override
			public Object handle(Request request, Response answer) {
				id=request.queryParams("id");
				DerbyDatabase.takeAnOrder(DerbyDatabase.findProductsById(id));
	
					
			    answer.redirect("/dogankoc/payment");
			    return null;
			}
			
		};
		
		get(route2);
	}
	/**
	 * odeme sayfasi olan /dogankoc/payment uzerinde bulunan form dan gelen post isteklerini karsilar
	 * input lardan alinan veriler veri tabanina kaydedilir ana tablodan stok bilgisi dusulur en sonunda 
	 * /dogankoc/myOrders isimli odemesi yapilan urunlerin goruntulendigi sayfaya yonlendirme yapilir
		* @return null
		*/
	private static void pay()
	{
		FreeMarkerRoute route= new FreeMarkerRoute("/dogankoc/payment"){

			@Override
			public Object handle(Request request, Response response) {
				try{
					
					String name=request.queryParams("name");
					String sirName=request.queryParams("sirName");
					String ccartNumber=request.queryParams("cartNumber");
					String expirationDate=request.queryParams("date");
					String ccv=request.queryParams("inputPassword");
					String adress=request.queryParams("Adress");
					DerbyDatabase.newOrder(DerbyDatabase.resumeOrderId()+1, name, sirName, ccartNumber, expirationDate, ccv, id,adress);
					DerbyDatabase.stokOut(id);
				}catch(Exception e){
					System.out.println("veri ekleme hatas�");
				}
				
				System.out.println("veri eklendi");         
				response.redirect("/dogankoc/myOrders");
				return null;
			
			}
			
		};
		
		post(route);
	}
	/**
	 * odeme sayfasi olan /dogankoc/payment uzerinde bulunan (+) butonuna basilinca sepete ayni urunden 1 tane daha ekler

		* @return null
		*/
	private static void addProductOnCart(){
		
		FreeMarkerRoute route=new FreeMarkerRoute("/addPc"){
			@Override
			public Object handle(Request request, Response answer) {
				List<Products> paymentList =DerbyDatabase.paymentList;
				paymentList.add(paymentList.get(paymentList.size()-1));
			    DerbyDatabase.paymentList=paymentList;
			    answer.redirect("/dogankoc/payment");
			    return null;
			}
			
		};
		get(route);
	}
	
	
	/**
	 * odeme sayfasi olan /dogankoc/payment uzerinde bulunan (x) butonuna basilinca sepetteki son urunu silen yonlendirici
	 * FreeMarkerRoute nesnesinin bulundugu metod
	* @return null
	*/
	private static void eraseProductOnCart(){
		
		FreeMarkerRoute route=new FreeMarkerRoute("/erasePc"){
			@Override
			public Object handle(Request request, Response answer) {
				List<Products> paymentList =DerbyDatabase.paymentList;
				if((paymentList.size()>=0)){
	                paymentList.remove(paymentList.size()-1);
	                DerbyDatabase.paymentList=paymentList;
	               
				}
				 answer.redirect("/dogankoc/payment");

			    
			    return null;
			}
			
		};
		get(route);
	}
	
	/**
	 * Siparislerin ilgili listeden alinip Modellegindi Router a sahip siparis sayfasinin gosterildigi metod
	* @return ModelAndView
	*/
	private static void myOrder()
	{
		
		FreeMarkerRoute route=new FreeMarkerRoute("/dogankoc/myOrders"){
			@Override
			public Object handle(Request request, Response answer) {
			    Map<String,Object> model = new HashMap<String, Object>();
		        
				model.put("paymentList", DerbyDatabase.paymentList);
				
				return new ModelAndView(model,"dogankoc/dogankoc.myOrders.html");
			}
			
		};
		
		get(route);
		
		
	}
	
	/**
	 *Yonetici panelinde yeni urun eklemeye yarayan sayfan�n post isteklerinin karsilanmasini yapan metod
	* @return null
	*/
	private static void addNewProductsManagement()
	{
		FreeMarkerRoute route= new FreeMarkerRoute("doganKoc/Management/AddingProducts"){

			@Override
			public Object handle(Request request, Response response) {
				try{
					String id=request.queryParams("id");
					String name=request.queryParams("name");
					String serialNo=request.queryParams("serialNo");
					String price=request.queryParams("price");
					int stok=(Integer.valueOf(request.queryParams("stok"))).intValue();
					String information=request.queryParams("information");
					DerbyDatabase.newRecord(DerbyDatabase.resumeRowCount()+1,id ,serialNo, name, price,stok,information); 
				}catch(Exception e){
					System.out.println("veri ekleme hatas�");
				}
				         
				response.redirect("/doganKoc/Management/productsList");
				return null;
			
			}
			
		};
		
		post(route);
	}

	/**
	 *Yonetici panelinde urun eklemeye yarayan sayfanin mevcut urunlerle modellenip gosterilmesi
	* @return ModelAndView
	*/
	private static void addingProductsManagementPage()
	{
		FreeMarkerRoute route= new FreeMarkerRoute("/doganKoc/Management/AddingProducts"){

			@Override
			public Object handle(Request request, Response response) {
			    Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("products",  DerbyDatabase.products);
				return new ModelAndView(ozellikler,"dogankoc/dogankoc.Management.AddingProducts.html");
			}
			
		};
		
		get(route);
	}
	
	/**
	 *Yonetici panelinde eklenen urunlerin modellenip gosterildigi sayfa
	* @return ModelAndView
	*/
	private static void productsListManagementPage()
	{
		FreeMarkerRoute route= new FreeMarkerRoute("/doganKoc/Management/productsList"){
			@Override
			public Object handle(Request request, Response response) {
				List<Products> products =DerbyDatabase.products;
			    Map<String,Object> model = new HashMap<String, Object>();
				model.put("products", products);
				return new ModelAndView(model,"dogankoc/dogankoc.Management.productsList.html");
			}
			
		};
		get(route);
	}

	/**
	 *Yonetici panelinden yonlendirilen urun id sine gore arama yapip ilgili urunu silen metod
	* @return ModelAndView
	*/
	private static void deleteProductsManagementRoute()
	{
		FreeMarkerRoute route= new FreeMarkerRoute("/deleteProducts"){

			@Override
			public Object handle(Request request, Response response) {
				String id=request.queryParams("Id");
				DerbyDatabase.deleteProduct(id);
				response.redirect("/doganKoc/Management/productsList");
				return null;
			}
			
		};
		get(route);
	}

	/**
	 *Urunlerin listelendigi /doganKoc/Management/productsList sayfasindan details linkleri ile yonlendirilen
	 *ilgili urunu id si ile bularak detayli bilgilerinin gosterilmesi icin olusturulan sayfanin 
	 *Modellenip gosterildigi metod
	* @return ModelAndView
	*/
	private static void showProductDetailsManagementPage()
	{
		FreeMarkerRoute route=new FreeMarkerRoute("/doganKoc/Management/showProductDetails"){

			@Override
			public Object handle(Request request, Response response) {
				String id=request.queryParams("id");
				List<Products> findedProducts =DerbyDatabase.findProductsById(id);
				
			    Map<String,Object> model = new HashMap<String, Object>();
				model.put("findedProducts", findedProducts);
				return new ModelAndView(model,"dogankoc/dogankoc.Management.showProductDetails.html");
			}
			
		};
		get(route);
	}
	

	/**
	 *Geriya kalan metodlarin tumu Ana sayfa uzerinde tiklanan her urun
	 *logosundan yonlendirilen  urunlerin genel siralamaya girebilmesi icin 
	 *islemlerin yapildigi metodlardir.
	* @return ModelAndView
	*/
	private static void  getSamsung(){
		
		FreeMarkerRoute route=new FreeMarkerRoute("/getSamsung"){
			
			@Override
			public Object handle(Request request, Response response) {
				products.clear();
				Map<String,Object> model = new HashMap<String, Object>();
				for(Products p:DerbyDatabase.products){
					if(p.getId().equals("SAMSUNG")){
						products.add(p);
					}
				}
				model.put("products", products);
				List<Integer> paymentCount=new ArrayList<Integer>();
				paymentCount.add(DerbyDatabase.paymentList.size());
				model.put("paymentCount",paymentCount );
				return new ModelAndView(model,"dogankoc/dogankoc.Home.html");
			}
			
		};
		get(route);
	}
	private static void getLg()
	{
			
			FreeMarkerRoute route=new FreeMarkerRoute("/getLg"){
				
			@Override
			public Object handle(Request request, Response response) {
				products.clear();
				Map<String,Object> model = new HashMap<String, Object>();
				for(Products p:DerbyDatabase.products){
					if(p.getId().equals("LG")){
						products.add(p);
					}
				}
				model.put("products", products);
				List<Integer> paymentCount=new ArrayList<Integer>();
				paymentCount.add(DerbyDatabase.paymentList.size());
				model.put("paymentCount",paymentCount );
				return new ModelAndView(model,"dogankoc/dogankoc.Home.html");
			}
			
		};
		get(route);
	}
	private static void getLenovo()
	{
			
			FreeMarkerRoute route=new FreeMarkerRoute("/getLenovo"){
				
			@Override
			public Object handle(Request request, Response response) {
				products.clear();
				Map<String,Object> model = new HashMap<String, Object>();
				for(Products p:DerbyDatabase.products){
					if(p.getId().equals("LENOVO")){
						products.add(p);
					}
				}
				model.put("products", products);
				List<Integer> paymentCount=new ArrayList<Integer>();
				paymentCount.add(DerbyDatabase.paymentList.size());
				model.put("paymentCount",paymentCount );
				return new ModelAndView(model,"dogankoc/dogankoc.Home.html");
			}
			
		};
		get(route);
	}
	private static void getVestel()
	{
			
			FreeMarkerRoute route=new FreeMarkerRoute("/getVestel"){
				
			@Override
			public Object handle(Request request, Response response) {
				products.clear();
				Map<String,Object> model = new HashMap<String, Object>();
				for(Products p:DerbyDatabase.products){
					if(p.getId().equals("VESTEL")){
						products.add(p);
					}
				}
				model.put("products", products);
				List<Integer> paymentCount=new ArrayList<Integer>();
				paymentCount.add(DerbyDatabase.paymentList.size());
				model.put("paymentCount",paymentCount );
				return new ModelAndView(model,"dogankoc/dogankoc.Home.html");
			}
			
		};
		get(route);
	}
	private static void getLenovoPC()
	{
			
			FreeMarkerRoute route=new FreeMarkerRoute("/getLenovoPC"){
				
			@Override
			public Object handle(Request request, Response response) {
				products.clear();
				Map<String,Object> model = new HashMap<String, Object>();
				for(Products p:DerbyDatabase.products){
					if(p.getId().equals("LENOVO-NOTEBOOK")){
						products.add(p);
					}
				}
				model.put("products", products);
				List<Integer> paymentCount=new ArrayList<Integer>();
				paymentCount.add(DerbyDatabase.paymentList.size());
				model.put("paymentCount",paymentCount );
				return new ModelAndView(model,"dogankoc/dogankoc.Home.html");
			}
			
		};
		get(route);
	}
	private static void getAsus()
	{
			
			FreeMarkerRoute route=new FreeMarkerRoute("/getAsus"){
				
			@Override
			public Object handle(Request request, Response response) {
				products.clear();
				Map<String,Object> model = new HashMap<String, Object>();
				for(Products p:DerbyDatabase.products){
					if(p.getId().equals("ASUS")){
						products.add(p);
					}
				}
				model.put("products", products);
				List<Integer> paymentCount=new ArrayList<Integer>();
				paymentCount.add(DerbyDatabase.paymentList.size());
				model.put("paymentCount",paymentCount );
				return new ModelAndView(model,"dogankoc/dogankoc.Home.html");
			}
			
		};
		get(route);
	}
	private static void getApple()
	{
			
			FreeMarkerRoute route=new FreeMarkerRoute("/getApple"){
				
			@Override
			public Object handle(Request request, Response response) {
				products.clear();
				Map<String,Object> model = new HashMap<String, Object>();
				for(Products p:DerbyDatabase.products){
					if(p.getId().equals("APPLE")){
						products.add(p);
					}
				}
				model.put("products", products);
				List<Integer> paymentCount=new ArrayList<Integer>();
				paymentCount.add(DerbyDatabase.paymentList.size());
				model.put("paymentCount",paymentCount );
				return new ModelAndView(model,"dogankoc/dogankoc.Home.html");
			}
			
		};
		get(route);
	}
	private static void getMsi()
	{
			
			FreeMarkerRoute route=new FreeMarkerRoute("/getMsi"){
				
			@Override
			public Object handle(Request request, Response response) {
				products.clear();
				Map<String,Object> model = new HashMap<String, Object>();
				for(Products p:DerbyDatabase.products){
					if(p.getId().equals("MSI")){
						products.add(p);
					}
				}
				model.put("products", products);
				List<Integer> paymentCount=new ArrayList<Integer>();
				paymentCount.add(DerbyDatabase.paymentList.size());
				model.put("paymentCount",paymentCount );
				return new ModelAndView(model,"dogankoc/dogankoc.Home.html");
			}
			
		};
		get(route);
	}
	
}