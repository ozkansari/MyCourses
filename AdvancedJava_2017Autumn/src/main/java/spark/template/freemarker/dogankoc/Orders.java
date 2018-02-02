package spark.template.freemarker.dogankoc;

public class Orders {
	int id ;
	String name, sirName, ccartNumber, expirationDate, ccv, productId,adress;
	int size=0;
	public Orders(int id ,String name,String sirName,String ccartNumber,String expirationDate,String ccv,String productId,String adress)
	{
		this.id=id; this.name=name; this.sirName=sirName; this.ccartNumber=ccartNumber; 
		this.expirationDate=expirationDate; this.ccv=ccv; this.productId=productId; this.adress=adress;
	}
	
	public  int getId(){
		return id;
	}
	        
	public  String getName()
	{
		return name;
	}
	public  String getSirName(){
		return sirName;
	}
	public String getCcartNumber()
	{
		return ccartNumber;
	}
	public String getExpirationDate(){
		return expirationDate;
	}
	public String getCcv()
	{
		return ccv;
	}
	public String getProductId()
	{
		return productId;
	}
	public  String getAdress(){
		return adress;
	}
	public Orders(int size){
		this.size=size;
	}
	public int getSize(){
		return size;
	}
}
