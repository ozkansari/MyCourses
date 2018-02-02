package spark.template.freemarker.cihangunacti;

public class Product {
    private int id;
    private String Nameproduct;
    private float productPrice;
    private float productDiscount;
    

	private String productDelivery;
    private String cargoInformation;
    private String productInformation;
   
    public static int ID = 1;
    
    public Product(int id, String Nameproduct, float productPrice,float productDiscount,String productDelivery,String cargoInformation,String productInformation) {
        this.id = id;
        this.Nameproduct = Nameproduct;
        this.productPrice = productPrice;
        this.productDiscount=productDiscount;
        this.productDelivery=productDelivery;
        this.cargoInformation=cargoInformation;
        this.productInformation=productInformation;
    }
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameproduct() {
		return Nameproduct;
	}

	public void setNameproduct(String nameproduct) {
		Nameproduct = nameproduct;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public float getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(float productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getProductDelivery() {
		return productDelivery;
	}

	public void setProductDelivery(String productDelivery) {
		this.productDelivery = productDelivery;
	}

	public String getCargoInformation() {
		return cargoInformation;
	}

	public void setCargoInformation(String cargoInformation) {
		this.cargoInformation = cargoInformation;
	}

	public String getProductInformation() {
		return productInformation;
	}

	public void setProductInformation(String productInformation) {
		this.productInformation = productInformation;
	}
}
