package spark.template.freemarker.burakkaratepe.finalproje;
import java.sql.*;
public class VeritabaniYonetimi {
	public static Statement veritabaniStatement;
	public void VeritabaniYonetimi(){
		
	}
	public static Statement veritabaniBaglantisiKur() {
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			
			Connection veritabaniBaglantisi = DriverManager.getConnection(
					"jdbc:derby:"
					// + ".\\.ozkansaridb\\" // windows ortami icin
					+ "./.burakaratepe/"
					+ ";create=true;"
					);
			
			veritabaniStatement = veritabaniBaglantisi.createStatement();
			
			return veritabaniStatement;
			
		} catch(Exception e) {
			System.out.println("Veritabanina baglanirken hata olustu");
		}
		
		return null;
	}
	
	public static boolean tablolariOlustur() {
		
		try  {
	//		veritabaniStatement.executeUpdate(
	//				"DROP TABLE users"
	//		);
			veritabaniStatement.executeUpdate(
					"CREATE TABLE users ( id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) , username varchar(20) NOT NULL , password varchar(20) NOT NULL , type INT NOT NULL )"
			);
			veritabaniStatement.executeUpdate(
					"CREATE TABLE products ( id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) , title varchar(20) NOT NULL , description varchar(20) NOT NULL , price INT NOT NULL )"
			);
			veritabaniStatement.executeUpdate(
					"CREATE TABLE cart ( id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) , userId INT NOT NULL , productId INT NOT NULL, title varchar(20) NOT NULL , price INT NOT NULL )"
			);
			
			veritabaniStatement.executeUpdate("INSERT INTO products VALUES( default, 'Pc', 'Fena' , 150)");
			
			veritabaniStatement.executeUpdate("INSERT INTO users VALUES ( "
					+ "default ,'guest', '123456', 0"
					+ ")");
			veritabaniStatement.executeUpdate("INSERT INTO users VALUES ( "
					+ "default ,'admin', '123456', 1"
					+ ")");
			// TODO Diger tablolari olustur
			
			System.out.println("Tablolar basariyla olsuturuldu");
			
		} catch(Exception e) {
			System.out.println("Hata: " + e.getMessage());
		}
		
		return true;
	}
}
