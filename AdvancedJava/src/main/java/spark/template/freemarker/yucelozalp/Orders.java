package spark.template.freemarker.yucelozalp;

// TODO: Auto-generated Javadoc
/**
 * The Class Orders.
 */
public class Orders {
	
	/** The orderid. */
	private String orderid;
    
    /** The book name. */
    private String book_name;
    
    /** The book id. */
    private String book_id;
    
    /** The quantity. */
    private String quantity;
    
    /** The price. */
    private int price;
    
    /** The name surname. */
    private String name_surname;
    
    /** The address. */
    private String address;
    
    /** The phone. */
    private String phone;

    /**
     * Instantiates a new orders.
     *
     * @param orderid the orderid
     * @param book_name the book name
     * @param book_id the book id
     * @param quantity the quantity
     * @param price the price
     * @param name_surname the name surname
     * @param address the address
     * @param phone the phone
     */
    public Orders(String orderid,String book_name, String book_id,String quantity,int price,String name_surname,String address,String phone) {
        this.orderid = orderid;
        this.book_name = book_name;
        this.book_id = book_id;
        this.quantity = quantity;
        this.price = price;
        this.name_surname = name_surname;
        this.address = address;
        this.phone = phone;
        
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    public String getOrderId() {
        return orderid;
    }

    /**
     * Gets the book name.
     *
     * @return the book name
     */
    public String getBookName() {
        return book_name;
    }

    /**
     * Gets the book id.
     *
     * @return the book id
     */
    public String getBookId() {
        return book_id;
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
     * Gets the price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }
    
    /**
     * Gets the name surname.
     *
     * @return the name surname
     */
    public String getNameSurname() {
        return name_surname;
    }
    
    /**
     * Gets the adress.
     *
     * @return the adress
     */
    public String getAdress() {
        return address;
    }
    
    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    

    /**
     * Sets the order id.
     *
     * @param orderid the new order id
     */
    public void setOrderId(String orderid) {
        this.orderid = orderid;
    }
    
    /**
     * Sets the book name.
     *
     * @param book_name the new book name
     */
    public void setBookName(String book_name) {
        this.book_name = book_name;
    }

    /**
     * Sets the book id.
     *
     * @param book_id the new book id
     */
    public void setBookId(String book_id) {
        this.book_id = book_id;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Sets the name surname.
     *
     * @param name_surname the new name surname
     */
    public void setNameSurname(String name_surname) {
        this.name_surname = name_surname;
    }
    
    /**
     * Sets the adress.
     *
     * @param address the new adress
     */
    public void setAdress(String address) {
        this.address = address;
    }
    
    /**
     * Sets the phone.
     *
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
