package spark.template.freemarker.didemlaloglu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import spark.template.freemarker.didemlaloglu.model.Product;

/**
 * 
 * @author didemlaloglu
 * @version 1.0.0
 * @since 2018-01-30
 */
public class DerbyDb {

	private static Connection veritabaniBaglantisi;

	public static boolean addProduct(Product product) {
		return addProduct(product.getProductId(), product.getCategoryId(), product.getProductName(), product.getDesc(),
				product.getUnitPrice(), product.getUnitsInStock());
	}

	/**
	 * addProduct metodu product tablosuna kayıt ekler sonuç olarak eklerse true
	 * ekleyemezse false döner
	 * 
	 * @param productId
	 *            ürün id
	 * @param categoryId
	 *            kategori id
	 * @param productName
	 *            ürün adı
	 * @param desc
	 *            ürün açıklaması
	 * @param unitPrice
	 *            ürün fiyatı
	 * @param unitsInStock
	 *            ürün stok miktarı
	 * @return boolean tipinde dönüş yapar.
	 */
	private static boolean addProduct(int productId, int categoryId, String productName, String desc, int unitPrice,
			int unitsInStock) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "INSERT INTO product values (" + productId + "," + categoryId + ",'" + productName + "', '"
					+ desc + "', " + unitPrice + ", " + unitsInStock + ")";
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("INSERT hatasi: " + e);
			return false;
		}
		System.out.println("Kayitlar olusturuldu.");
		return true;
	}

	/**
	 * removeProduct metodu ürün id sini alır ve ilgili ürünü veritabanından siler.sonuç
	 * olarak silinirse true ekleyemezse false döner
	 * 
	 * @param id
	 *            ürün id si
	 * @return
	 */
	public static boolean removeProduct(int id) {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "DELETE FROM PRODUCT WHERE product_Id=" + id;
			komut.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("DELETE hatasi: " + e);
			return false;
		}
		System.out.println("Kayitlar silindi.");
		return true;
	}

	/**
	 * getProductById metodu ürün id sini alır ilgilir ürünü oluşturur ve geri döndürür.
	 * 
	 * @param Id
	 *            ürün idsi
	 * @return Product nesnesi(ürün)
	 */
	public static Product getProductById(int Id) {

		Product product = null;
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM product where product_Id =" + Id;
			ResultSet resultSet = komut.executeQuery(sql);

			while (resultSet.next()) {
				int productId = resultSet.getInt(1);
				int categoryId = resultSet.getInt(2);
				String productName = resultSet.getString(3);
				String desc = resultSet.getString(4);
				int unitPrice = resultSet.getInt(5);
				int unitsInStock = resultSet.getInt(6);
				product = new Product(productId, categoryId, productName, desc, unitPrice, unitsInStock);
			}
		} catch (SQLException e) {
			System.out.println("SELECT hatasi: " + e);
		}
		return product;

	}

	/**
	 * getProductByCategoryId metodu kategori id si alır ve o kategoriye ait ürünleri geri
	 * döndürür.
	 * 
	 * @param Id
	 *            kategori Id si
	 * @return ürün listesi geri döner.
	 */
	public static List<Product> getProductByCategoryId(int Id) {

		List<Product> products = new ArrayList<>();
		Product product = null;
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM product where category_Id =" + Id;
			ResultSet resultSet = komut.executeQuery(sql);

			while (resultSet.next()) {
				int productId = resultSet.getInt(1);
				int categoryId = resultSet.getInt(2);
				String productName = resultSet.getString(3);
				String desc = resultSet.getString(4);
				int unitPrice = resultSet.getInt(5);
				int unitsInStock = resultSet.getInt(6);
				product = new Product(productId, categoryId, productName, desc, unitPrice, unitsInStock);
				products.add(product);

			}
		} catch (SQLException e) {
			System.out.println("SELECT hatasi: " + e);
		}
		return products;

	}

	/**
	 * getProductAll metodu veritabanındaki bütün ürünleri döner.
	 * 
	 * @return ürün listesi döner.
	 */
	public static List<Product> getProductAll() {

		List<Product> products = new ArrayList<>();
		try {
			Statement komut = veritabaniBaglantisi.createStatement();
			String sql = "SELECT * FROM product ";
			ResultSet resultSet = komut.executeQuery(sql);
			Product product;
			while (resultSet.next()) {
				int productId = resultSet.getInt(1);
				int categoryId = resultSet.getInt(2);
				String productName = resultSet.getString(3);
				String desc = resultSet.getString(4);
				int unitPrice = resultSet.getInt(5);
				int unitsInStock = resultSet.getInt(6);
				product = new Product(productId, categoryId, productName, desc, unitPrice, unitsInStock);
				products.add(product);
			}
		} catch (SQLException e) {
			System.out.println("SELECT hatasi: " + e);
		}
		return products;

	}

	/**
	 * veritabaniniYukle metodu veritabanı driver ını yükler.Başarılı ise true ,
	 * değilse false döner.
	 * 
	 * @return boolean sonuç üretir.
	 */
	public static boolean veritabaniniYukle() {
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
	 * veritabaninaBaglan metodu veritabanı ile bağlantı kurar. Başarılı ise true , değilse
	 * false döner.
	 * 
	 * @return boolean sonuç üretir.
	 */
	public static boolean veritabaninaBaglan() {
		try {
			String veritabaniDizini = "Databases\\didemlaloglu";
			String url = "jdbc:derby:" + veritabaniDizini + ";create=true";
			veritabaniBaglantisi = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Veritabani baglanti hatasi: " + e.getMessage());
			return false;
		}
		System.out.println("Veritabani baglantisi kuruldu.");
		return true;
	}

	/**
	 * tablolariOlustur metodu Product tablosunu oluşturur. Başarılı ise true ,
	 * değilse false döner.
	 * 
	 * @return boolean sonuç üretir.
	 */
	public static boolean tablolariOlustur() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();

			String sql = "CREATE TABLE PRODUCT (product_Id int,category_Id int, name varchar(30),description varchar(3000), unitPrice int, unitsInStock int)";

			komut.execute(sql);

		} catch (SQLException e) {
			System.out.println("Tablo mevcut olabilir: " + e);
			return false;
		}
		System.out.println("Tablo olusturuldu.");
		return true;
	}

	/**
	 * tablolariSil metodu product tablosunu siler
	 * Başarılı ise true , değilse false döner.
	 * 
	 * @return boolean sonuç üretir.
	 */
	public static boolean tablolariSil() {
		try {
			Statement komut = veritabaniBaglantisi.createStatement();

			String sql = "DROP TABLE PRODUCT"; // (product_Id int,category_Id int, name varchar(30),description
												// varchar(30), unitPrice int, unitsInStock int)";

			komut.execute(sql);

		} catch (SQLException e) {
			System.out.println("Tablo silinmedi: " + e);
			return false;
		}
		System.out.println("Tablo silindi.");
		return true;
	}

}
