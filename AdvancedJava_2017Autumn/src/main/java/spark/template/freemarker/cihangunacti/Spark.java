package spark.template.freemarker.cihangunacti;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.awt.Image;
import java.util.*;
public class Spark {
    
    private static final List<Product> PRODUCTS = new ArrayList<Product>();
    private static final Gson jsonYardimci = new GsonBuilder().create();
    public static List<Product>findProduct;
    public static List<Basket> findBasket;
    public static List<Order> findOrder;
 
    public static void main(String[] args) {
        
      	staticFileLocation("/spark/template/freemarker/cihangunacti/public");
        DerbyDatabase.uploadDatabase();
        DerbyDatabase.connectDatabase();
        DerbyDatabase.creatingTable();
        DerbyDatabase.createBasketTable();
        DerbyDatabase.creatingOrderTable();
        
        viewProducts();
        addProductspage();
        addingProducts();
        productDelete();
        
        managementPage();
        homePage();
        detailPage();
        detailPage2();
        findDetail();
        basketPage();
        addtoBasket();
        
        deleteBasket();
        
        orderPage();
        orderPage2();
        
        homedetails();
        detailFindpage();
        detailAddtoCartPage();
        addOrderProcess2();
        
        //order_cm();
        order_complete();
        
    }

    /**
     * "/cihangunacti/management/deleteProduct" linkinde localhost'ta Spark oluşturur.
     * @return null
     */
    private static void productDelete() {
        FreeMarkerRoute productDeletion = new FreeMarkerRoute("/cihangunacti/management/deleteProduct") {
            @Override
            public Object handle(Request request, Response response) {
                
                int id = Integer.valueOf( request.queryParams("id") );
                DerbyDatabase.deleteProduct(id);
                
                // Islem bitince /urunler sayfasina geri don
                response.redirect("/cihangunacti/management/productList");
                
                return null;
            }
        };
        get(productDeletion);
    }
    /**
     * https://localhost:4567/cihangunacti/management/addProduct
     * 
     * gelen post isteklerini karsilasilayan method.Kullanıcıdan gelen verileri alıyor. 
     * @return null
     */
    private static void addingProducts() {
        FreeMarkerRoute productAdditionProcess = new FreeMarkerRoute("/cihangunacti/management/addProduct") {
            @Override
            public Object handle(Request request, Response response) {
                
                // Kullanicinin urunekle.html'den girdigi form degerlerini al
                String nameProduct = request.queryParams("urunadi"); 
                // urunadi html input text'deki name
               
                float productPrice;
                float productDiscount;
                try {
                		productPrice = Float.valueOf( request.queryParams("fiyat") );
                		productDiscount=Float.valueOf(request.queryParams("indirim"));
                } catch(Exception e) {
                    e.printStackTrace();
                    response.redirect("/cihangunacti/yonetim/urunEkle");
                    return null;
                }
                String deliveryDate=request.queryParams("teslimat");
                String cargoInformation=request.queryParams("bedava");
                String productInformation=request.queryParams("urunbilgi");
                
                // Urun olustur ve listeye ekle
                float indsonuc;
                indsonuc=productPrice*(1-(productDiscount/100));
                productDiscount=indsonuc;
                System.out.println(productDiscount);
                Product urun = new Product(Product.ID++,nameProduct, productPrice,indsonuc,deliveryDate,cargoInformation,productInformation);
                // URUNLER.add(urun);
                DerbyDatabase.addProduct(urun);
 
                // Islem bitince /urunler sayfasina geri don
                response.redirect("/cihangunacti/management/addProduct");
                
                return null;
            }
        };
        post(productAdditionProcess); // bu yonlendirme post isteklerini karsilasin
    }

    /**
     * https://localhost:4567/cihangunacti/management/addProduct"
     * get'le post'a gönderiyoruz...
     * @return ModelAndView yeni bir sayfa döndürüyor 
     */
    private static void addProductspage() {
        FreeMarkerRoute productInsertionPage = new FreeMarkerRoute("/cihangunacti/management/addProduct") {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> features = new HashMap<String, Object>();
                features.put("products", PRODUCTS);
                return new ModelAndView(features, "cihangunacti/addProduct.html");
            }
        };
        get(productInsertionPage);
    }

    /**
     * "https://localhost:4567/cihangunacti/management/productList"
     * 
     * Web sitesinde eklenen verileri listeleyen method.
     * 
     * @return new MdelAndView
     * 
     */
    private static void viewProducts() {
        FreeMarkerRoute productList = new FreeMarkerRoute("/cihangunacti/management/productList") {
            @Override
            public Object handle(Request request, Response response) {
                
                List<Product> products = DerbyDatabase.getRecords();
                
                Map<String, Object> features = new HashMap<String, Object>();
                features.put("products", products);
                return new ModelAndView(features, "cihangunacti/products.html");
            }
        };
        get(productList);
    }
     /**
      * 
      * "https://localhost:4567/cihangunacti/cihangunacti/management"
      * 
      * Sitenin yönetim paneline oluşturan Spark.
      * @return new ModelAdView  
      */
     private static void managementPage() {
            FreeMarkerRoute managementPage = new FreeMarkerRoute("/cihangunacti/management") {
                @Override
                public Object handle(Request request, Response response) {
                    Object features=null;
                    return new ModelAndView(features, "cihangunacti/manager.html");
                }
            };
            get(managementPage);
}
     /**
      * "https://localhost:4567/cihangunacti/cihangunacti/management"
      * 
      * anasayfa'ya için oluşturulan Spark'tır.
      * 
      * NEW SPARKK
      * 
      * @return new ModelAndView
      */
     private static void homePage() {
         FreeMarkerRoute home = new FreeMarkerRoute("/cihangunacti/home") {
             @Override
             public Object handle(Request request, Response response) {
            	 List<Product> products = DerbyDatabase.getRecords();
                 
                 Map<String, Object> features = new HashMap<String, Object>();
                 // ozellikler.put("urunler", URUNLER);
                 features.put("products", products);
                 return new ModelAndView(features, "cihangunacti/home.html");
             }
         };
         get(home);
     }
     /**
      * "https://localhost:4567/cihangunacti/management/details"
      * 
      * 
      * @return new ModelAndView detail.html
      */
     private static void detailPage() {
         FreeMarkerRoute detail = new FreeMarkerRoute("/cihangunacti/management/details") {
             @Override
             public Object handle(Request request, Response response) {
            	 List<Product> products = DerbyDatabase.getRecords();
             Map<String, Object> features = new HashMap<String, Object>();
             features.put("products", products);
             return new ModelAndView(features, "cihangunacti/detail.html");
             }
         };
         get(detail);
     }
     /**
      * 
      * "https://localhost:4567/cihangunacti/management/details2"
      * 
      * @return ModelAndView detail2.html
      */
     private static void detailPage2() {
         FreeMarkerRoute details = new FreeMarkerRoute("/cihangunacti/management/details2") {
             @Override
             public Object handle(Request request, Response response) {
            	 
             Map<String, Object> features = new HashMap<String, Object>();
             features.put("products", findProduct);
             return new ModelAndView(features, "cihangunacti/details2.html");
                 
             }
         };
         get(details);
     }
     /**
      * "https://localhost:4567/cihangunacti/management/findDetail"
      * 
      * Detail arayan method.
      * 
      * @return null,response.redirect new Page
      */
     private static void findDetail() {
         FreeMarkerRoute findDetails = new FreeMarkerRoute("/cihangunacti/management/findDetail") {
             @Override
             public Object handle(Request request, Response response) {
            	 int id = Integer.valueOf( request.queryParams("id") );
            	 findProduct=DerbyDatabase.getSecuredLogins(id);
                 
            	 response.redirect("/cihangunacti/management/details2");
             return null;
             }
         };
         get(findDetails);
     }

     /**
      * "https://localhost:4567/cihangunacti/Basket"
      * @return new ModelAndView cart.html
      */
     private static void basketPage() {
         FreeMarkerRoute basket = new FreeMarkerRoute("/cihangunacti/Basket") {
             @Override
             public Object handle(Request request, Response response) {
                 //DerbyDatabase.tabledeleteData();
            	    List<Basket> basket = DerbyDatabase.getBasketrecords();
                 Map<String, Object> features = new HashMap<String, Object>();
                 features.put("basket", basket);
                 return new ModelAndView(features, "cihangunacti/cart.html");
             }
         };
         get(basket);
     }
     /**
      * "https://localhost:4567/cihangunacti/management/addBasket"
      * 
      * @return null,response.redirect New Page
      */
     private static void addtoBasket() {
         FreeMarkerRoute basket = new FreeMarkerRoute("/cihangunacti/management/addBasket") {
             @Override
             public Object handle(Request request, Response response) {
            	 int id = Integer.valueOf( request.queryParams("id") );
            	 
            	 findBasket=DerbyDatabase.pickSelectedBasket(id);
                 
            	 response.redirect("/cihangunacti/home");
             return null;
             }
         };
         get(basket);
     }
     /**
      * "https://localhost:4567/cihangunacti/management/deleteBasket"
      * 
      * @return null,response.redirect new Page
      */
     private static void deleteBasket() {
         FreeMarkerRoute deleteBasket = new FreeMarkerRoute("/cihangunacti/management/deleteBasket") {
             @Override
             public Object handle(Request request, Response response) {
            	 int id = Integer.valueOf( request.queryParams("id") );
            	 
            	 DerbyDatabase.deleteBasket(id);
              
            	 response.redirect("/cihangunacti/Basket");
             return null;
             }
         };
         get(deleteBasket);
     }
     /**
      * 
      * "https://localhost:4567/cihangunacti/management/order"
      * 
      * @return new ModelAndView order.html new PaGE
      */
     private static void orderPage() {
         FreeMarkerRoute order = new FreeMarkerRoute("/cihangunacti/management/order") {
             @Override
             public Object handle(Request request, Response response) {
            	 List<Basket> order = DerbyDatabase.getBasketrecords();
                 Map<String, Object> features = new HashMap<String, Object>();
                 features.put("order", order);
                 return new ModelAndView(features, "cihangunacti/order.html");
             }
         };
         get(order);
     }
   
     /**
      * 
      * "https://localhost:4567/cihangunacti/home/details"
      * 
      * @return new ModelAndView homedetails.html new Page
      */
     private static void homedetails() {
         FreeMarkerRoute homedetails = new FreeMarkerRoute("/cihangunacti/home/details") {
             @Override
             public Object handle(Request request, Response response) {
            	 
            	 
            	 	Map<String, Object> features = new HashMap<String, Object>();
       
            	 	features.put("products", findProduct);
                 return new ModelAndView(features, "cihangunacti/homedetails.html");
             }
         };
         get(homedetails);
     }
     
     /**
      * 
      * "https://localhost:4567/cihangunacti/home/detailsFind"
      * 
      * @return null,response.redirect details
      */
     private static void detailFindpage() {
         FreeMarkerRoute details = new FreeMarkerRoute("/cihangunacti/home/detailsFind") {
             @Override
             public Object handle(Request request, Response response) {
            	 int id = Integer.valueOf( request.queryParams("id") );
            	 findProduct=DerbyDatabase.getSecuredLogins(id);
                 
            	 response.redirect("/cihangunacti/home/details");
             return null;
             }
         };
         get(details);
     }
     /**
      * 
      * "https://localhost:4567/cihangunacti/home/addBasket"
      * 
      * @return null,response.redirect details
      */
     private static void detailAddtoCartPage() {
         FreeMarkerRoute detailscart = new FreeMarkerRoute("/cihangunacti/home/addBasket") {
             @Override
             public Object handle(Request request, Response response) {
            	 int id = Integer.valueOf( request.queryParams("id") );
            	 
            	 findBasket=DerbyDatabase.pickSelectedBasket(id);
                 
            	 response.redirect("/cihangunacti/home/details");
             return null;
             }
         };
         get(detailscart);
     }
     
     
     /**
      * "https://localhost:4567/cihangunacti/cihangunacti/order"
      * 
      * 
      * @return null, response.redirect orderc 
      */
     private static void addOrderProcess2() {
         FreeMarkerRoute orderProcess = new FreeMarkerRoute("/cihangunacti/order") {
             @Override
             public Object handle(Request request, Response response) {
                 
                 // Kullanicinin urunekle.html'den girdigi form degerlerini al
                 
                 // urunadi html input text'deki name
            	     String name=request.queryParams("name");
            	     String  lastname= request.queryParams("lastname");
                 String  orderCountry=request.queryParams("country");
                 String address=request.queryParams("address");
                 String address_name=request.queryParams("address_name");
                 String telephone=request.queryParams("telephone");
                 String order_type=request.queryParams("type");
                 
                 Order order=new Order(Order.ID++, name, lastname, orderCountry, address, address_name, telephone, order_type);
                 
                 DerbyDatabase.addOrder(order);
                 response.redirect("/cihangunacti/orderc");
                 
                 return null;
             }
         };
         post(orderProcess); // bu yonlendirme post isteklerini karsilasin
     }
     /**
      * "https://localhost:4567/cihangunacti/order"
      * 
      * 
      * @RETURN NEW ModelAndView order2.html newPage
      */
     private static void orderPage2() {
         FreeMarkerRoute order2 = new FreeMarkerRoute("/cihangunacti/order") {
             @Override
             public Object handle(Request request, Response response) {
            	 Map<String, Object> features = new HashMap<String, Object>();
                 
             	 features.put("products", findOrder);
                 return new ModelAndView(features, "cihangunacti/order2.html");
             }
         };
         get(order2);
     }
     /**
      * 
      * "https://localhost:4567/cihangunacti/orderc"
      * 
      * @return new ModelAndView order_complete.html
      */
     private static void order_complete() {
         FreeMarkerRoute detailscart = new FreeMarkerRoute("/cihangunacti/orderc") {
             @Override
             public Object handle(Request request, Response response) {
            	 Map<String, Object> features = new HashMap<String, Object>();
                 
         	 features.put("products", findOrder);
              return new ModelAndView(features, "cihangunacti/order_complete.html");
             }
         };
         get(detailscart);
     }

     /*private static void order_cm() {
         FreeMarkerRoute ordercm = new FreeMarkerRoute("/cihangunacti/orderdata") {
             @Override
             public Object handle(Request request, Response response) {
            	 String name =  request.queryParams("name");
            	 
            	 findOrder=DerbyDatabase.orderdate(name);
                 
            	 response.redirect("/cihangunacti/orderc");
             return null;
             }
         };
         get(ordercm);
     }*/
    
}