package spark.template.freemarker.cihangunacti;

public class Basket {
	private int id;
    private String nameProduct;
    private float productPrice;
	private float discount;
	
	public static int quantity;
    public static int ID = 1;
    
    public Basket(int id, String nameProduct, float productPrice,float discount,int quantity) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.productPrice = productPrice;
        this.discount=discount;
        this.quantity=quantity;
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
   
	

}
