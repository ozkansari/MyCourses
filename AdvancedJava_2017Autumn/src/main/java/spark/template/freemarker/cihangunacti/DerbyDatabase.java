package spark.template.freemarker.cihangunacti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DerbyDatabase {

    // BIRINCI ADIM
    // pom.xml tanimi
    /*
     <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>com.medipol</groupId>
      <artifactId>DerbyVeritabaniProje</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <dependencies>
        <dependency>
            <groupId>org.apache.derby</groupId>
            <artifactId>derby</artifactId>
            <version>10.11.1.1</version>
        </dependency>
      </dependencies>
    </project>
     */
    private static Connection databaseConnection;
    
    public static void main(String[] args) {
        
        // IKINCI ADIM -------------------------------------------------
        boolean veritabaniYuklendiMi = uploadDatabase();
        if (!veritabaniYuklendiMi) {
            return;
        }
        
        // UCUNCU ADIM -------------------------------------------------
        boolean veritabaninaBaglandiMi = connectDatabase();
        if (!veritabaninaBaglandiMi) {
            return;
        }
        //tableDrop2();
        //tabledeleteData();
    }

    /**
     * Verilecek olan id'deki bütün kayıtları silecek olan database methodu.
     *
     * @return true
     * @return false
     * @param id
     * @version 1.0
     */
    public static boolean deleteProduct(int id) {
        try {
            Statement command = databaseConnection.createStatement();
            String sql = "DELETE FROM products WHERE id=" + id;
            command.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("DELETE hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar silindi.");
        return true;
    }
    
    
    
   
/**
 * Product sınıfındaki verileri bu methoda vererek veritabanına Insert etmeyi sağlar.
 * 
 * @param product sınıf değişkeni
 * @return return addProductaddProduct(int id, String Nameproduct, float productPrice,float productDiscount,String productDelivery,String cargoInformation,String productInformation)
 */
    public static boolean addProduct(Product product) {
        return addProduct(product.getId(),product.getNameproduct(),product.getProductPrice(),product.getProductDiscount(),product.getProductDelivery(),product.getCargoInformation(),product.getProductInformation());
    }
    /**
     * Verilecek olan bilgileri "products" tablosuna ekleyen method
     * @return true,false
     * 
     * @param  int id, String Nameproduct, float productPrice,float productDiscount,String productDelivery,String cargoInformation,String productInformation
     * 
     */
   public static boolean addProduct(int id, String Nameproduct, float productPrice,float productDiscount,String productDelivery,String cargoInformation,String productInformation) {
        try {
            Statement command = databaseConnection.createStatement();
            String sql = "INSERT INTO products values (" + id + ",'" + Nameproduct+ "', " + productPrice +","+productDiscount+",'"+productDelivery+"','"+cargoInformation+"','"+productInformation+"')";
            command.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("INSERT hatasi: " + e);
            return false;
        }
        System.out.println("Kayitlar olusturuldu.");
        return true;
    }

    /**
     * İnternet üzerinden "org.apache.derby.jdbc.EmbeddedDriver"" veritabanını yükleyen method.
     * 
     * @return true,false
     */
    public static boolean uploadDatabase() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        } catch (Exception e) {
            System.out.println("Veritabani kutuphanesi hatasi: " + e.getMessage());
            return false;
        }
        System.out.println("Veritabani kutuphanesi yuklendi.");
        return true;
    }
    /**
     * 
     * Veritabanına bağlanan method.
     * 
     * @return true,false
     * 
     */
    public static boolean connectDatabase() {
        try {
            String databaseDirectory= ".\\.veritabani\\"; 
            // veritabaniDizini: Dizin adı "C:\\veritabani\\" da olabilirdi.
            String url = "jdbc:derby:"+databaseDirectory+";create=true";
            databaseConnection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Database connection failure: " + e.getMessage());
            return false;
        }
        System.out.println("Database Connected Installed.");
        return true;
    }

    /**
     * Veritabanın'da tablo oluşturan method.
     * 
     * @return true,false
     */
    public static boolean creatingTable() {
        try {
            Statement command = databaseConnection.createStatement();
            String sql = "CREATE TABLE products (id int, name varchar(30), price float,discount float,delivery_date varchar(30),"
            		+ "cargo_information varchar(30),product_information varchar(500))";
            command.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Table may be available: " + e);
            return false;
        }
        System.out.println("The table was created.");
        return true;
    }

    /**
     * Veritabanı listelemek için kullanılacak method.
     * @return products
     */
    public static List<Product> getRecords() {
        try {
            Statement command = databaseConnection.createStatement();
            String sql = "SELECT * FROM products";
            ResultSet resultSet = command.executeQuery(sql);
            
            List<Product> products = new ArrayList<Product>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String Nameproducts = resultSet.getString(2);
                float productsPrice = resultSet.getFloat(3);
                float discount=resultSet.getFloat(4);
                String delivery=resultSet.getString(5);
                String cargo=resultSet.getString(6);
                String productInformation=resultSet.getString(7);
                Product urun = new Product(id, Nameproducts, productsPrice,discount,delivery,cargo,productInformation);
                products.add(urun);
            }
            return products;
            
        } catch (SQLException e) {
            System.out.println("Command error: " + e);
            return null;
        }
    }
    /**
     * Gelen Id'ye göre tablo'dan kayıtları silen method.
     * 
     * @param gelen id Integer
     * @return products
     */
    public static List<Product> getSecuredLogins(int id2) {
        try {
            Statement command = databaseConnection.createStatement();
            String sql = "SELECT * FROM products WHERE id=" + id2;
            ResultSet resultSet = command.executeQuery(sql);
            
            List<Product> products = new ArrayList<Product>();
            while (resultSet.next()) {
            	 int id = resultSet.getInt(1);
                 String Nameproducts = resultSet.getString(2);
                 float productsPrice = resultSet.getFloat(3);
                 float discount=resultSet.getFloat(4);
                 String delivery=resultSet.getString(5);
                 String cargo=resultSet.getString(6);
                 String productInformation=resultSet.getString(7);
                 Product urun = new Product(id, Nameproducts, productsPrice,discount,delivery,cargo,productInformation);
                 products.add(urun);
            }
            return products;
            
        } catch (SQLException e) {
            System.out.println("Command error: " + e);
            return null;
        }
    }
    
    /*private static void listRecords() {
        try {
            Statement command = databaseConnection.createStatement();
            String sql = "SELECT * FROM products";
            ResultSet resultSet = command.executeQuery(sql);
            while (resultSet.next()) {
            	int id = resultSet.getInt(1);
                String Nameproducts = resultSet.getString(2);
                float productsPrice = resultSet.getFloat(3);
                float discount=resultSet.getFloat(4);
                String delivery=resultSet.getString(5);
                String cargo=resultSet.getString(6);
                String productInformation=resultSet.getString(7);
                /*System.out.println("Urun ID " + id + ", Urun Ad: " + Nameproducts+",Urun Fiyat"+fiyat+",İndirim"+indirim+",Urun teslimat Tarihi"+teslimat
                		+",Kargo"+kargo+",Urun Bilgileri"+urun_Bilgileri);          }
            
        } catch (SQLException e) {
            System.out.println("Command error:: " + e);
        }
        System.out.println("List of Records.");
    }*/
    //*************************SEPETE EKLEME KISMI********************************
    
    
    
    /**
     * basket adında yeni bir tablo oluşturmak için kullanılan method.
     * 
     * @return true,false
     * version 1.1
     */
    public static boolean createBasketTable() {
        try {
            Statement command = databaseConnection.createStatement();
            String sql = "CREATE TABLE basket (id int, name varchar(30), price float,discount float,quantity int)";
            command.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Table may be available: " + e);
            return false;
        }
        System.out.println("Table created.");
        return true;
    }
    /**
     * 
     * Basket tablosuna SELECT * FROM basket yani basket tablosunu  listeyen method.
     * 
     * @return basketAdd liste tipinde List<Basket> ...
     */
    public static List<Basket>  getBasketrecords() {
        try {
            Statement command = databaseConnection.createStatement();
            String sql = "SELECT * FROM basket";
            ResultSet resultSet = command.executeQuery(sql);
            
            List<Basket> basketAdd = new ArrayList<Basket>();
            while (resultSet.next()) {
            	   
                int id = resultSet.getInt(1);
                String Nameproducts = resultSet.getString(2);
                float productsPrice = resultSet.getFloat(3);
                float discount=resultSet.getFloat(4);
                int quantity=resultSet.getInt(5);
                Basket sepet=new Basket(id,Nameproducts,productsPrice,discount,quantity);
                basketAdd.add(sepet);
            }
            return basketAdd;
            
        } catch (SQLException e) {
            System.out.println("Command Error: " + e);
            return null;
        }
    }
    
    /**
     * 
     * Basket sınıfından gelen verileri databese'e Insert eden method
     * 
     * @param basket Sınıf Basket
     * @return addBasket(basket.getId(),basket.getNameProduct(),basket.getProductPrice(),basket.getDiscount(),basket.getQuantity())
     */
    
    public static boolean addBasket(Basket basket) {
        return addBasket(basket.getId(),basket.getNameProduct(),basket.getProductPrice(),basket.getDiscount(),basket.getQuantity());
    }
    /**
     * 
     * Kullanıcıdan yada özel olarak verilen bilgileri databese Insert eden method.
     * 
     * @return true,false
     * @param int id, String nameProduct, float productPrice,float discount,int quantity
     * 
     */
   public static boolean addBasket(int id, String nameProduct, float productPrice,float discount,int quantity) {
        try {
            Statement command = databaseConnection.createStatement();
            String sql = "INSERT INTO basket values (" + id + ",'" + nameProduct+ "', " + productPrice +","+ discount +","+quantity+")";
            command.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("INSERT error: " + e);
            return false;
        }
        System.out.println("Records were created.");
        return true;
    }
   
   /**
    * Verilen id'yi basket tablosunda eşlesen kayıtları silen method.
    * @param id
    * @return true,false
    */
   public static boolean deleteBasket(int id) {
       try {
           Statement command = databaseConnection.createStatement();
           String sql = "DELETE FROM basket WHERE id=" + id;
           command.executeUpdate(sql);
       } catch (SQLException e) {
           System.out.println("DELETE error: " + e);
           return false;
       }
       System.out.println("Records deleted.");
       return true;
   }
   
   /**Basket sınıfı---
    * Verilen id yi products tablosundan 
    * eşleşen kayıtlarla yeni tablo oluşturan method. 
    * 
    * @param id
    * @return basketAdd List tipinde List<Basket> 
    *  
    */
   public static List<Basket> pickSelectedBasket(int id2) {
       try {
           Statement command = databaseConnection.createStatement();
           String sql = "SELECT * FROM products WHERE id=" + id2;
           ResultSet resultSet = command.executeQuery(sql);
           
           List<Basket> basketAdd = new ArrayList<Basket>();
           while (resultSet.next()) {
        	       int quantity=1;
               int id = resultSet.getInt(1);
               String nameProducts = resultSet.getString(2);
               float productsPrice = resultSet.getFloat(3);
               float productsDiscount=resultSet.getFloat(4);
               
               
               
               Basket basket=new Basket(Basket.ID++,nameProducts,productsPrice,productsDiscount,quantity);
               addBasket(basket);
               basketAdd.add(basket);
           }
           return basketAdd;
           
       } catch (SQLException e) {
           System.out.println("Command Error: " + e);
           return null;
       }
   }
   /**
    * verilen Basket sınıfından veriler baske tablosundaki eşleşen veriyi döndüren method.
    * 
    * @param basket
    * @return id2
    */
   public static int SelectedBasket(Basket basket) {
       try {
           Statement command = databaseConnection.createStatement();
           String sql = "SELECT * FROM basket WHERE quantity=" + basket;
           ResultSet resultSet = command.executeQuery(sql);
           int id2 = 0;
           while (resultSet.next()) {
        	   id2 = resultSet.getInt(1);
              
           }
           return id2;
           
       } catch (SQLException e) {
           System.out.println("Command Errore: " + e);
           return (Integer) null;
       }
   }
   //Tablo drop etme
   
   /**
    * products tablosunu "DROP TABLE product" yani drop eden method.
    * 
    * @return true,false
    */
   public static boolean tableDrop() {
       try {
           Statement command = databaseConnection.createStatement();
           String sql = "DROP TABLE products ";
           command.executeUpdate(sql);
       } catch (SQLException e) {
           System.out.println("Drop Error: " + e);
           return false;
       }
       System.out.println("Drop It was.");
       return true;
   }
   /**
    * basket tablosunu "DROP TABLE basket" yani drop eden method.
    * 
    * @return true,false
    */
   public static boolean tableDrop2() {
       try {
           Statement command = databaseConnection.createStatement();
           String sql = "DROP TABLE basket ";
           command.executeUpdate(sql);
       } catch (SQLException e) {
           System.out.println("Drop Error: " + e);
           return false;
       }
       System.out.println("Drop It was.");
       return true;
   }
   /**
    * order_com tablosunu "DROP TABLE order_com" yani drop eden method.
    * 
    * @return true,false
    */
   public static boolean tableDrop3() {
       try {
           Statement command = databaseConnection.createStatement();
           String sql = "DROP TABLE order_com ";
           command.executeUpdate(sql);
       } catch (SQLException e) {
           System.out.println("Drop Error: " + e);
           return false;
       }
       System.out.println("Drop It was.");
       return true;
   }
   

 //*************************SİPARİŞ KISMI********************************
   /**
    * order_com adlı veritabanına yeni tablo oluşturan method
    * 
    * @return true,false
    */
   public static boolean creatingOrderTable() {
       try {
           Statement command = databaseConnection.createStatement();
           String sql = "CREATE TABLE order_com (id int, orderName varchar(30), order_lastname varchar(30),order_country varchar(30),order_address varchar(500),order_addressname varchar(50),order_telephone varchar(50),order_type varchar(30))";
           command.executeUpdate(sql);
       } catch (SQLException e) {
           System.out.println("Table may be available: " + e);
           return false;
       }
       System.out.println("Table created." + 
       		".");
       return true;
   }
   
   /**
    * Order sınıfından gelen veriler'le order_com tablosuna veri ekleyen method.
    * @param order
    * @return addOrder(order.getId(), order.getName(), order.getLastName(), order.getCountry(), order.getAddress(), order.getAddressName(), order.getTelephone(), order.getType())
    */
   public static boolean addOrder(Order order) {
       return addOrder(order.getId(), order.getName(), order.getLastName(), order.getCountry(), order.getAddress(), order.getAddressName(), order.getTelephone(), order.getType());
   }
   /**
    * 
    * Kullanıcıdan yada elle girilen verileri order_com tablosuna Insert eden method.
    * 
    * @param id
    * @param name
    * @param lastName
    * @param country
    * @param address
    * @param addressName
    * @param telephone
    * @param type
    * @return true
    * @return false
    */
  public static boolean addOrder(int id, String name,String lastName,String country,String address,String addressName,String telephone,String type) {
       try {
           Statement command = databaseConnection.createStatement();
           String sql = "INSERT INTO order_com values (" + id + ",'" + name+ "', '" + lastName +"','"+ country +"','"+address+"','"+addressName+"','"+telephone+"','"+type+"')";
           command.executeUpdate(sql);
       } catch (SQLException e) {
           System.out.println("INSERT error: " + e);
           return false;
       }
       System.out.println("Records were created.");
       return true;
   }
  /**
   * Verilen name parametresi order_com tablosundan olan kayıtları list olarak döndüren method.
   * @param name
   * @return orderList
   * @return null
   */
  public static List<Order> orderdate(String name) {
      try {
          Statement command = databaseConnection.createStatement();
          String sql = "SELECT * FROM order_com WHERE orderName=" + name;
          ResultSet resultSet = command.executeQuery(sql);
          
          List<Order> orderList = new ArrayList<Order>();
          while (resultSet.next()) {
              int id = resultSet.getInt(1);
              String Pname = resultSet.getString(2);
              String lastname = resultSet.getString(3);
              String country=resultSet.getString(4);
              String address=resultSet.getString(5);
              String addressname=resultSet.getString(6);
              String telephone=resultSet.getString(7);
              String type=resultSet.getString(8);
              
              Order order=new Order(Order.ID++, Pname, lastname, country, address, addressname, telephone, type);
              orderList.add(order);
          }
          return orderList;
          
      } catch (SQLException e) {
          System.out.println("Command Error: " + e);
          return null;
      }
  }
  /**
   * order_com tablosundan verileri silen method
   * 
   * @return true
   * @return false
   */
  public static boolean tabledeleteData() {
      try {
          Statement command = databaseConnection.createStatement();
          String sql = "DELETE FROM order_com ";
          command.executeUpdate(sql);
      } catch (SQLException e) {
          System.out.println("Delete Error: " + e);
          return false;
      }
      System.out.println("DELETE It was.");
      return true;
  }
  
}
