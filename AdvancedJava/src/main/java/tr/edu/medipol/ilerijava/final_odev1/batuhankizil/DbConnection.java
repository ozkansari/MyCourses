package tr.edu.medipol.ilerijava.final_odev1.batuhankizil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DbConnection {
	
	Connection conn;
	
	public Connection getConnection() {
		
		Connection connectionDb = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			connectionDb = DriverManager.getConnection("jdbc:derby:" + ".\\.database\\" + ";create=true;");
			System.out.println("Connection Successful.");
		} catch (Exception e) {
			System.out.println("Connection Failed.");
		}
		return connectionDb;
	}	
	
	public void createDB() {
		try {
		   conn = getConnection();
		   final Statement databaseQuery = conn.createStatement();
		   databaseQuery.execute("CREATE TABLE users (" + " id CHAR(10) NOT NULL PRIMARY KEY, " + " name CHAR(50)," + " surname CHAR(50) )");	
		   } catch (Exception e) {
			System.out.println("Table Already Available.");
		}
	}	
	
	public boolean insertData(final String name, final String surname) {
	
		try {
			   final Statement databaseQuery = conn.createStatement();
			   
			   final ResultSet rs = databaseQuery.executeQuery("SELECT count(*) FROM users");
			   int number = 0;
	            while(rs.next()){
	                number = (rs.getInt(1));
	            } 
	            number = number + 1;
	            databaseQuery.executeUpdate("INSERT INTO users VALUES ('" + number + "', '" + name + "', '" + surname + "')");
	            System.out.println("Number : " + number + " Name : " + name + " Surname : " + surname);
	            return true;
	            
			} catch (final Exception e) {
				e.printStackTrace();
			}
			return false;
		
	}
	

}
