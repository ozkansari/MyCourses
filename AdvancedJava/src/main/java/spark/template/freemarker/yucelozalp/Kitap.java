package spark.template.freemarker.yucelozalp;

// TODO: Auto-generated Javadoc
/**
 * The Class Kitap.
 */
public class Kitap {

	/** The book name. */
	private String book_name;
	
	/** The yazar. */
	private Yazar yazar;
	
	/** The publisher. */
	private String publisher;
	
	/** The category. */
	private String category;
	
	/** The price. */
	private int price;
	
        
	/**
	 * Instantiates a new kitap.
	 *
	 * @param book_name the book name
	 * @param yazarAdi the yazar adi
	 * @param yazarSoyadi the yazar soyadi
	 * @param publisher the publisher
	 * @param category the category
	 * @param price the price
	 */
	public Kitap(String book_name,
			String yazarAdi, String yazarSoyadi,
				 String publisher,
				 String category,
				 int price) {
	
		this.book_name = book_name;
		this.yazar = new Yazar(yazarAdi, yazarSoyadi);
		this.publisher = publisher;
		this.category = category;
		this.price = price;

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
	 * Sets the kitap adi.
	 *
	 * @param kitapAdi the new kitap adi
	 */
	public void setKitapAdi(String kitapAdi) {
		this.book_name = kitapAdi;
	}
	
	/**
	 * Gets the yazar.
	 *
	 * @return the yazar
	 */
	public Yazar getYazar() {
		return yazar;
	}
	
	/**
	 * Sets the yazar.
	 *
	 * @param yazar the new yazar
	 */
	public void setYazar(Yazar yazar) {
		this.yazar = yazar;
	}

	/**
	 * Gets the book name.
	 *
	 * @return the book name
	 */
	public String getBook_name() {
		return book_name;
	}

	/**
	 * Gets the publisher.
	 *
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
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
	 * Sets the book name.
	 *
	 * @param book_name the new book name
	 */
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	/**
	 * Sets the publisher.
	 *
	 * @param publisher the new publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	
}
