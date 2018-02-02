package spark.template.freemarker.didemlaloglu.model;

public class Product {

	private int productId;
	private int categoryId;
	private String productName;
	private String desc;
	private int unitPrice;
	private int unitsInStock;
	
    public static int ID = 1;

	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, int categoryId, String productName, String desc, int unitPrice, int unitsInStock) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.desc = desc;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName
				+ ", desc=" + desc + ", unitPrice=" + unitPrice + ", unitsInStock=" + unitsInStock + "]";
	}
}
