package tr.edu.medipol.odevler2.anil_bal;
import java.sql.*;
import javax.swing.*;

public class Eklemevegosterme extends JFrame {
	private JPanel Panell = new JPanel();
	private JTextField adivesoyadi = new JTextField();
	private JTextField bolumismi = new JTextField();
	private JTextField yil = new JTextField();
	private JButton kisiyiEkle = new JButton("Ki�iyi Ekle");
	private static String tabloAdi = "ogrenciler";
	private static final String VERITABANI_DIZINI = 
			".\\.veritabani\\";
	
    private static final String VERITABANI_URL = 
    		"jdbc:derby:" + VERITABANI_DIZINI + ";create=true";

// OZKANS DUZELTME
    private static Statement stmt;
// OZKANS DUZELTME
    
	private static void main(String[] konsolParametreleri) throws Exception {
		System.out.println(VERITABANI_URL);
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		Connection conn = DriverManager.getConnection(VERITABANI_URL);
		
		stmt = conn.createStatement();
		
		
		
		
		try {
			stmt.executeUpdate(
					"CREATE TABLE " + tabloAdi + " ("
					+  "id int primary key not NULL auto_increment, "
					+  "ad_soyad varchar(30),"
					+ "bolum varchar(30),"
					+ "giris_yili int"
					+ ")"
			);
			System.out.println("Tablo " + tabloAdi + " olusturuldu");
		} catch(Exception e) {
		
		}

	}
	
	public  Eklemevegosterme() {
	
		setTitle("��renci Ekleme Ve ��karma");
		setSize(500,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Panell.add(adivesoyadi);
		Panell.add(bolumismi);
		Panell.add(yil);
		Panell.add(kisiyiEkle);
		add(Panell);
		
		kisiyiEkle.addActionListener(e -> {
			try {
				
				stmt.executeUpdate("INSERT INTO" + tabloAdi + "VALUES ("
						+ adivesoyadi.getText()
						+ bolumismi.getText()
						+ yil.getText()
						
						+")"
						);
					
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});
	}
}
