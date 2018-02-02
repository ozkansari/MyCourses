package spark.template.freemarker.dogankoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DerbyDatabase {

	private static Connection connection;
	/**
	 * Programin akisina gore Database tablolarindaki verilerin anlik kullanimi icin olusturulmus listeler
	*/
    public static List<Products> products=new ArrayList<Products>();
    public static List<Products> paymentList=new ArrayList<Products>();
    public static List<Orders> ordersList=new ArrayList<Orders>();
    private static int orderId=0,t=4;
    
	/**
	 * Spark main metodundan baslayan program orada DerbyDatabase sinifinin yaratilmasiyla
	 * bu yapici metod ile DataBase islemleri baslatilir
	*/
	public DerbyDatabase()
	{
		start() ;
	}
	
	/**
	 *veritabani baglantisi, tablonun olusturulmasi,data eklenmesi silinmesi bulunmasi gibi islemlerin baslatildigi metod
	* @return void
	*/
	public static void start() {
		
       if(!loadDerbyDatabase())
    	   return;
       
       if(!connectDatabase())
    	   return;
       
 
     
       //dropTable();
       
       createTable();    
       
       //veri tabanýndan eski verileri al
       if((products=getTable())==null)
    	   return;
       
       createTableOrder();
       
       //dropOrderTable();
       
       
	}

	/**
	 *Siparis tablosunu silmeye yarar
	* @return void
	*/
	private static void dropOrderTable() {
		try {
			Statement k=connection.createStatement();
			k.executeUpdate("drop table siparisler");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *Urunler tablosunu siler
	* @return ModelAndView
	*/
	private static void dropTable() {
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("drop table urunler");
		   } catch (SQLException e) {
			   System.out.println(e.getSQLState());
		   }
		   System.out.println("tablo drop edildi");
	}
	
	/**
	 *urunler tablosunda satir sayisi olarak tutulan degerin duzenli artisi islemlerini yap 
	* @return int 
	*/
	public static int resumeRowCount(){
		Statement statement;
		int rowCount=0;
		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select max(rowCount) from urunler");
			if(result.next())
				return rowCount=result.getInt(1);	
		} catch (SQLException e) {
			System.out.println("max rowCount hatasý"+e);
		}
	    return 0;
	}
	/**
	 *siparisler tablosunda ID degerinin  duzenli artisi islemlerini yap 
	* @return int 
	*/
	public static int resumeOrderId(){
		Statement statement;
		int id=0;
		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select max(id) from siparisler");
			if(result.next())
				return id=result.getInt(1);	
		} catch (SQLException e) {
			System.out.println("max id hatasý"+e);
		}
	    return 0;
	}
	
	/**
	 *Urunun kendine has Unic olan Id bilgisi ile tum urunler arasindan ilgili urunu bulup bir listeye ekleyerek donduren fonksiyon
	 *@param String urun ozel id si 
	* @return List bulunan urunun bulundugu List 
	*/
	public static List<Products> findProductsById(String id)
	{
		List<Products> finded=new ArrayList<Products>();
		
		for(Products p: products){
			if(p.getId().equals(id)){
				finded.add(p);
				return finded;
			}
		}
		return null;
	}

	/**
	 *veri tabanina baglanmak icin yuklenmesi islemleri
	* @return boolean islem basarili ise true 
	*/
	private static boolean loadDerbyDatabase() 
	{
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		   } catch (InstantiationException e) {
			   System.out.println("Veritabani kutuphanesi hatasi: " + e.getMessage());
			   e.printStackTrace();
			   return false;
		   } catch (IllegalAccessException e) {
			   System.out.println("Veritabani kutuphanesi hatasi: " + e.getMessage());
			   e.printStackTrace();
			   return false;
		   } catch (ClassNotFoundException e) {
			   System.out.println("Veritabani kutuphanesi hatasi: " + e.getMessage());
			   e.printStackTrace();
			   return false;
		   }
		System.out.println("Veritabaný kütüphanesi yüklendi");
		return true;
	}

	/**
	 *yuklenen database'e yapilan baglanti islemleri
	* @return boolean islem basarili ise true 
	*/
	private static boolean  connectDatabase() 
	{
		   //String dataBasePath=path+"\\database";
		   String dataBasePath=".\\.database\\";
		   String url="jdbc:derby:"+dataBasePath+";create=true";
		   try{
			   connection=DriverManager.getConnection(url);
		   } catch (SQLException e) {
		       System.out.println("Veritabani baglanti hatasi: " + e.getMessage());
	            return false;
		   }
	        System.out.println("Veritabani baglantisi kuruldu.");
	        return true;
	}
	
	/**
	 *urunler tablosunu olusturur
	* @return void
	*/
	private static void createTable()
	{
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("create table urunler(rowCount int,id varchar(50),serialNo varchar(30),name varchar(20),price varchar(20),stok int,information varchar(50))");
		} catch (SQLException e) {
			System.out.println("Tablo mevcut olabilir: " + e);
			return ;
		}
		System.out.println("tablo oluþturuldu");
	}
	
	/**
	 *odemesi yapilan siparislerin bilgerinin bulanacagi tabloyu olusturur
	* @return void
	*/
	private static void createTableOrder()
	{
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("create table siparisler(id int,name varchar(20),sirName varchar(20),ccartNumber varchar(16),expirationDate varchar(4),ccv varchar(5),productId varchar(20),adress varchar(20) )");
		} catch (SQLException e) {
			System.out.println("Tablo mevcut olabilir: " + e);
			return ;
		}
		System.out.println("siparisler tablosu oluþturuldu");
	}
	
	/**
	 *siparislere eklenen urunun odemesi yapilirken kullanilan tabloya Odeme bilgilerinin eklendigi metod
	* @return void
	*/
	public static void newOrder(int id ,String name,String sirName,String ccartNumber,String expirationDate,String ccv,String productId,String adress)
	{
		try {
			Statement statement=connection.createStatement();
	        
            String sql = "INSERT INTO siparisler values (" + id + ",'"+name+ "','" + sirName + "','"+ccartNumber+"','" + expirationDate +"','"+ccv+"','"+productId+"','"+adress+"')";               
            
            statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("INSERT hatasi: " + e);
            return;
		}
		ordersList.add(new Orders(id,name,sirName,ccartNumber,expirationDate,ccv,productId,adress));
		System.out.println("Yeni kayit eklendi.");

	}
	
	/**
	 *alinan siparis bilgilerinin silinmesi islemleri
	* @return boolean silinirse true
	*/
	public static boolean deleteOrder(int id)
	{
		
		try {
			Statement statement=connection.createStatement();
			String sql = "DELETE FROM siparisler WHERE id=" + id;
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DELETE hatasi: " + e);
			return false;
		}
		for(Orders o : ordersList){
			if(o.getId()==id){
				ordersList.remove(o);
			}
		}
		System.out.println("Siparis silindi");
		return true;
	}
	
	/**
	 *alinan siparis bilgilerinin silinmesi islemleri
	 *@param List html uzerinden id si gonderilen urunun bulunduktan sonra siparislerin tutuldugu listeye eklenmesi
	 *islemini yapan metod
	* @return void
	*/
	public static void takeAnOrder(List<Products> pList)
	{
		if(pList.size()>1){
			System.out.println("sipariþ alma hatasý");
			return ;
		}
		Products p=pList.get(0);
	
		paymentList.add(p);
	}
	
	/**
	 *alinan siparisin ana tablodaki stok bilgisinden dusulmesi
	* @return void
	*/
	public static void stokOut(String id)
	{
		ResultSet resultSet=null;

		try {
			Statement statement=connection.createStatement();
			resultSet = statement.executeQuery("select  * from urunler");
			while(resultSet.next()){
			 	int stok=resultSet.getInt("stok");
			 	if(stok<=0){
			 		DerbyDatabase.deleteProduct(id);
			 		return;
			 	}
			 }
		    statement.executeUpdate("update  urunler set stok=stok-1 where id='"+id+"'");
		    System.out.println("ürün stoktan çýkarýldý");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("çýkarma hatasý");
			return;
		}
	}
	
	
	/**
	 *Urunler tablosundaki verileri alarak sinif degiskeni olan listede saklanmasi yani database deki verilerin cekilmesi
	* @return List
	*/
	private static List<Products> getTable()
	{
		List<Products> products=new ArrayList<Products>();
		ResultSet resultSet=null;
		try {
			Statement statement=connection.createStatement();
			resultSet = statement.executeQuery("select  * from urunler");
		while(resultSet.next()){
			int rowCount=resultSet.getInt("rowCount");
			String id=resultSet.getString("id");
			String serialNo=resultSet.getString("serialNo");
			String name=resultSet.getString("name");
			String price=resultSet.getString("price");
			int stok=resultSet.getInt("stok");
			String information=resultSet.getString("information");
			products.add(new Products(rowCount,id,serialNo,name,price,stok,information));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("listeleme hatasý");
			return null;
		}
		System.out.println("veriler alýndý");
		return products;
	}
	
	/**
	 *Urunler tablosuna Admin panelinde veri ekleme sayfasindan yapilan yonlendirme sonucu cagiralarak ana tabloya
	 *yeni urun ekleyen metod
	 *@param int,String urun bilgileri
	* @return void
	*/
	public static void newRecord(int rowCount ,String id,String serialNo,String name,String price,int stok,String information)
	{
		try {
			Statement statement=connection.createStatement();
	        
            String sql = "INSERT INTO urunler values (" + rowCount + ",'"+id+ "','" + serialNo + "','"+name+"','" + price +"',"+stok+",'"+information +"')";               
            statement.executeUpdate(sql);
            products.add(new Products(rowCount,id,serialNo,name,price,stok,information));
		} catch (SQLException e) {
			e.printStackTrace();
            System.out.println("INSERT hatasi: " + e);
            return;
		}
		System.out.println("Yeni kayit eklendi.");

	}
	
	/**
	 *Urunler tablosundan veri silmek icin 
	* @return boolean silinirse true
	*/
	public static boolean deleteProduct(String id)
	{
		
		try {
			Statement statement=connection.createStatement();
			String sql = "DELETE FROM urunler WHERE id=" + id;
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DELETE hatasi: " + e);
			return false;
		}
		for(Products p : products){
			if(p.getId().equals(id)){
				products.remove(p);
			}
		}
		System.out.println("Urun silindi");
		return true;
	}
	


  
}
