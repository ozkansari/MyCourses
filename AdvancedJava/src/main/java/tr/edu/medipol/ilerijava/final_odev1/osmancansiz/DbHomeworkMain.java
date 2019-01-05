package tr.edu.medipol.ilerijava.final_odev1.osmancansiz;

import java.sql.*;
import java.awt.event.*;  
import javax.swing.*; 

public class DbHomeworkMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		
		Connection connStr = DriverManager.getConnection("jdbc:derby:"
				+ ".\\.veritabani1\\" + ";create=true;"); 

		final Statement dbExecuteState = connStr.createStatement();
		
		try  {
			dbExecuteState.executeUpdate(
					"CREATE TABLE "
							+ "kullanicilar ("
								+ "id INTEGER , "
								+ "isim varchar(40),"
								+ "soyisim varchar(40)"
							+ ")"
			);
		} catch(Exception e) {
			System.out.println("Tablo daha önce oluşturulmuş: " + e.getMessage());
		}
		
		JFrame f=new JFrame("Derby Homework");  
	    final JTextField tf1=new JTextField();  
	    final JTextField tf2=new JTextField(); 
	    tf1.setBounds(50,30, 150,20);  
	    tf2.setBounds(50,60,150,20);  
	    JButton b=new JButton("Kaydet");  
	    b.setBounds(50,100,95,30);  
	    
	    b.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	            String name = tf1.getText();  
	            String surname = tf2.getText();  
	            try {
					dbExecuteState.executeUpdate("INSERT INTO kullanicilar VALUES (1,'"+name+"','"+surname+"') ");
					
					ResultSet sonuclar = dbExecuteState.executeQuery("SELECT * FROM kullanicilar");
					while (sonuclar.next()) {
						int id = sonuclar.getInt("id");
						String isim = sonuclar.getString("isim");
						String soyisim = sonuclar.getString("soyisim");
						System.out.println(id + " " + isim +" " + soyisim);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        }  
	    });  
	    f.add(b);
	    f.add(tf1); 
	    f.add(tf2); 
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true); 
		
	}

}
