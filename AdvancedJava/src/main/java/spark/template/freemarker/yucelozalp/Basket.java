package spark.template.freemarker.yucelozalp;

// TODO: Auto-generated Javadoc
/**
 * The Class Basket.
 */
public class Basket {
    
    /** The basketid. */
    private String basketid;
    
    /** The basket book name. */
    private String basketBookName;
    
    /** The quantity. */
    private String quantity;
    
    /** The basket book price. */
    private String basketBookPrice;
    
    /** The total price. */
    private int totalPrice;

    /**
     * Instantiates a new basket.
     *
     * @param basketid the basketid
     * @param basketBookName the basket book name
     * @param quantity the quantity
     * @param basketBookPrice the basket book price
     * @param totalPrice the total price
     */
    public Basket(String basketid, String basketBookName, String quantity, String basketBookPrice, 
    		int totalPrice) {
        this.basketid = basketid;
        this.basketBookName = basketBookName;
        this.quantity = quantity;
        this.basketBookPrice = basketBookPrice;
        this.totalPrice = totalPrice;
    }

    /**
     * Gets the basketid.
     *
     * @return the basketid
     */
    public String getBasketid() {
        return basketid;
    }

    /**
     * Gets the basket book name.
     *
     * @return the basket book name
     */
    public String getBasketBookName() {
        return basketBookName;
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }
    

    /**
     * Gets the basket book price.
     *
     * @return the basket book price
     */
    public String getBasketBookPrice() {
        return basketBookPrice;
    }

    /**
     * Gets the total price.
     *
     * @return the total price
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the basketid.
     *
     * @param basketid the new basketid
     */
    public void setBasketid(String basketid) {
        this.basketid = basketid;
    }

    /**
     * Sets the basket book name.
     *
     * @param basketBookName the new basket book name
     */
    public void setBasketBookName(String basketBookName) {
        this.basketBookName = basketBookName;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the new quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the basket book price.
     *
     * @param basketBookPrice the new basket book price
     */
    public void setBasketBookPrice(String basketBookPrice) {
        this.basketBookPrice = basketBookPrice;
    }

    /**
     * Sets the total price.
     *
     * @param totalPrice the new total price
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
