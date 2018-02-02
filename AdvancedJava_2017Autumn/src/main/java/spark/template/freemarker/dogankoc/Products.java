package spark.template.freemarker.dogankoc;

public class Products {
	private int rowCount;
	private String id;
	private String serialNo;
	private String name;
	private String price;
	private int stok;
	private String information;
	private int size=0;
	public Products(int rowCount,String id,String serialNo,String name,String price,int stok,String information){
		this.rowCount=rowCount; this.id=id; this.serialNo=serialNo; this.name=name; this.price=price;this.stok=stok; this.information=information;
	}
	public int getRowCount(){
		return rowCount;
	}
	public String getId()
	{
		return id;
	}
	public String getSerialNo(){
		return serialNo;
	}
	public String getName(){
		return name;
	}
	public String getPrice(){
		return price;
	}
	public int getStok(){
		return stok;
	}
	public String getInformation(){
		return information;
	}
	public Products(int size){
		this.size=size;
	}
	public int getSize(){
		return size;
	}

}
