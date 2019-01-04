package tr.edu.medipol.ilerijava.final_odev1.efkanidriscandir;

import javax.swing.*;
import java.sql.*;

public class veritabani extends JFrame 
  {
	JLabel bir,iki;
    static JTextField isim;
	static JTextField soyisim;
	static JButton ekle;
	
   public veritabani() 
   { 
    this.setTitle("Kullanýcý Adý Kayýt etme"); //Baþlýk
    this.setSize(300 , 300); //Pencere Boyu
    this.setLayout(null); //Yerleþim düzeni
    
    //Oluþturma
    bir = new JLabel("Ad:");
    iki = new JLabel("Soyad:");
    isim = new JTextField();
    soyisim = new JTextField();
    ekle = new JButton("Gönder");
    
    //Ekleme
    this.add(isim);
    this.add(soyisim);
    this.add(bir);
    this.add(iki);
    this.add(ekle); 
    
    //Konumlandýrma
    bir.setBounds(30,30,100,30);
    isim.setBounds(70,30,100,30);
    iki.setBounds(30,60,100,30);
    soyisim.setBounds(70,60,100,30);
    ekle.setBounds(70,100,100,40);
    
    this.setVisible(true); //Pencereyi görünür yapar
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kapanma davranýþý 
   } 
  

	public static void main(String[] args) throws Exception {
		//Baðlantý
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		Connection baglanti = DriverManager.getConnection("jdbc:derby://localhost:3306/"
				                                        + "veritabani;"
				                                        + "user=Efkan;"
				                                        + "password=12345;");
		
	    Statement sorgu = baglanti.createStatement();
		
	    
	    //Tablo oluþturma
		try  {
			sorgu.executeUpdate("CREATE TABLE " 
		                      + "isimler ("
					          + "Ad varchar(50), " 
					          + "Soyad varchar(50)"
					          +	")" );
		} catch(Exception e) {
			System.out.println("Tablo var. " + e.getMessage());
		}
		
		//Pencereyi baþlatma
		new veritabani();
		
		
		//Butona görev verme
		ekle.addActionListener(event->{
			try {
				
				//Ekleme
				sorgu.executeUpdate("INSERT INTO isimler VALUES ('"+isim.getText()+"','"+soyisim.getText()+"')");
				
				//Tablodaki verileri okuma
		        ResultSet veriler = sorgu.executeQuery("SELECT * FROM isimler");
	        	
		        while(veriler.next()) {
		         	String ad = veriler.getString("Ad");
		        	String soyad = veriler.getString("Soyad");
		        	
		        	//Tablodaki verileri gösterme
		        	System.out.println(ad + " " + soyad);
	            	}
	        	
		        
		        //Tablodaki veriler bittikten sonra araya ayýrmak için þerit
	        	System.out.println("-----------------------------------");
	        	
	        	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			});
	}
}