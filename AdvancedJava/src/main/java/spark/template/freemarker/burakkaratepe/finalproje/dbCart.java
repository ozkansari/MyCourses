package spark.template.freemarker.burakkaratepe.finalproje;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class dbCart {
	private final String table_name="cart";
	private static VeritabaniYonetimi vy = new VeritabaniYonetimi();
	public List<String[]> find(String where) {
		System.out.println("Select * from "+table_name+" "+where);
		List<String[]> list = new ArrayList<String[]>();
		try {
			ResultSet set= vy.veritabaniStatement.executeQuery("Select * from "+table_name+" "+where);
			while(set.next())
			{
				System.out.println("sa");
				String[] currentRow = new String[] {set.getString("id"),set.getString("userId"),
	                    set.getString("productId"),set.getString("title"),set.getString("price")};
				list.add(currentRow);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public String[]  findOne(String where) {
		
		try {
			ResultSet set= vy.veritabaniStatement.executeQuery("Select * from "+table_name+" "+where);
			while(set.next())
			{
				return new String[] {set.getString("id"),set.getString("userId"),
                    set.getString("productId"),set.getString("title"),set.getString("price")};
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		return null;
	}
	public boolean insert(int productId,int userId,String title,int price) {
		System.out.println("INSERT INTO "+table_name+" VALUES( default, "+productId+", "+userId+")");
		try {
		    vy.veritabaniStatement.execute("INSERT INTO "+table_name+" VALUES( default, "+productId+", "+userId+", '"+title+"', "+price+" )");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean remove(int id) {
		try {
			vy.veritabaniStatement.execute("DELETE from "+table_name+" WHERE id="+id);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
}
