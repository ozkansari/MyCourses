package spark.template.freemarker.burakkaratepe.finalproje;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class dbProducts {
	private final String table_name="products";
	private static VeritabaniYonetimi vy = new VeritabaniYonetimi();
	public List<String[]> find(String where) {
		
		List<String[]> list = new ArrayList<String[]>();
		try {
			ResultSet set= vy.veritabaniStatement.executeQuery("Select * from "+table_name+" "+where);
			while(set.next())
			{
				String[] currentRow = new String[] {set.getString("id"),set.getString("title"),
                        set.getString("description"),set.getString("price")};
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
				return new String[] {set.getString("id"),set.getString("title"),
                    set.getString("description"),set.getString("price")};
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		return null;
	}
	public boolean insert(String title,String description,int price) {
		String sql="INSERT INTO "+table_name+" VALUES( default, '"+title+"', '"+description+"' , "+price+")";
		try {
			vy.veritabaniStatement.execute(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(sql);
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
