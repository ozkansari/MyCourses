package tr.edu.medipol.ilerijava.final_odev1.tahakeskin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
			throws Exception {{
		 JFrame f=new JFrame("KAYIT OL");    
		 
		 JLabel l1=new JLabel("ADINIZ: ");    
	     l1.setBounds(20,20,80,30); 
	     f.add(l1); 
		     
	     JLabel l2=new JLabel("SOYADINIZ: ");    
	     l2.setBounds(20,75,80,30);
	     f.add(l2); 
		 
	     final JTextField ad = new JTextField();  
	     ad.setBounds(100,20,150,30);  
	     f.add(ad); 
	     
	     final JTextField soyad = new JTextField();   
	     soyad.setBounds(100,75,150,30); 
	     f.add(soyad); 
	     
	     JButton ekle = new JButton("KAYIT OL");  
	     ekle.setBounds(100,120,90,30);
	     f.add(ekle); 
	        
	     final JLabel l3 = new JLabel();            
	     l3.setBounds(20,150,200,50);  
	     f.add(l3);  
	         
	     f.setSize(300,300);    
	     f.setLayout(null);    
	     f.setVisible(true);  
	     f.setLocationRelativeTo(null);
	     
	     Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			
			Connection veritabaniBaglantisi = DriverManager.getConnection(
					"jdbc:derby:"
					 + ".\\.KullanicilarVeriTabani\\"
					//+ "./.veritabani1/"//ios
					+ ";create=true;"
					);
			
			final Statement veritabaniSorguStmt = veritabaniBaglantisi.createStatement();
			
			try  {
				veritabaniSorguStmt.executeUpdate(
						"CREATE TABLE "
								+ "kullanicilar ("
									+ "isim varchar(40), "
									+ "soyad varchar(40)"
								+ ")"
				);
			} catch(Exception e) {
				System.out.println("Tablo zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
			}
	     
	     ekle.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try  {
					veritabaniSorguStmt.executeUpdate("INSERT INTO kullanicilar VALUES (" + ad.getText() + "," + soyad.getText() + ")");
					l3.setText("islem basarili");
				} catch(Exception e1) {
					System.out.println("hatali islem :" + e1.getMessage());
					l3.setText("hatali islem");
				}
			}
		});
	               
	}  
	}
}
