package tr.edu.medipol.ilerijava.ders08;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OgrenciYonetimEkrani extends JFrame {

	public OgrenciYonetimEkrani() {
		super("Ogrenci Yonetim");
		
		Statement veritabaniSorguStmt = veritabaniAyarla();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 500);
		setLocation(100, 50);
		setLayout(new GridLayout(2, 1));
		
		// --------------------------------------------------
		// Gosterim Paneli
		// --------------------------------------------------
		JPanel gosterimPaneli = new JPanel();
		JTextArea mesajlarJTA;
		mesajlarJTA = new JTextArea(50,50);
		mesajlarJTA.setSize(300, 300);
		mesajlarJTA.setEditable(false);
		mesajlarJTA.getScrollableTracksViewportHeight();
		JScrollPane mesajlarJTAScroll = new JScrollPane(mesajlarJTA);
		gosterimPaneli.add(mesajlarJTAScroll);
		add(gosterimPaneli);
		
		// --------------------------------------------------
		// Giris Paneli
		// --------------------------------------------------
		JPanel girisPaneli = new JPanel();
		
		JTextField ogrenciAdGiris, ogrenciSoyadGiris, ogrenciYasGiris;
		
		ogrenciAdGiris = new JTextField(10);
		girisPaneli.add(new JLabel("Ad : "));
		girisPaneli.add(ogrenciAdGiris);
		
		ogrenciSoyadGiris = new JTextField(10);
		girisPaneli.add(new JLabel("Soyad : "));
		girisPaneli.add(ogrenciSoyadGiris);
		
		ogrenciYasGiris = new JTextField(10);
		girisPaneli.add(new JLabel("Yas : "));
		girisPaneli.add(ogrenciYasGiris);
		
		JButton gonderBtn = new JButton("GONDER");
		girisPaneli.add(gonderBtn);
		gonderBtn.addActionListener(event -> {
			int id = findMaxId(veritabaniSorguStmt);
			kayitEkle(veritabaniSorguStmt, mesajlarJTA, id, ogrenciAdGiris, ogrenciSoyadGiris, ogrenciYasGiris);
		});
		
		add(girisPaneli);
		// --------------------------------------------------
	}
	
	private void kayitEkle(Statement veritabaniSorguStmt, JTextArea mesajlarJTA, int id, JTextField ogrenciAdGiris,
			JTextField ogrenciSoyadGiris, JTextField ogrenciYasGiris) {
		int yas = Integer.valueOf( ogrenciYasGiris.getText() );
		mesajlarJTA.setText( mesajlarJTA.getText() + 
				ogrenciAdGiris.getText() + " " + 
				ogrenciSoyadGiris.getText() + " " + 
				yas + "\n"
		);
		mesajlarJTA.setCaretPosition(mesajlarJTA.getDocument().getLength());
		ogrenciAdGiris.setText("");
		ogrenciSoyadGiris.setText("");
		ogrenciYasGiris.setText("");
		repaint();
		
		try  {
			veritabaniSorguStmt.executeUpdate("INSERT INTO ogrenciler VALUES ( "
					+ (id + 1) + " , "
					+ ogrenciAdGiris.getText() + " " + ogrenciSoyadGiris.getText() + " , "
					+ yas
					+ "' )");
		} catch(Exception e) {
			System.out.println("Ayni id'li kayit olusturulamaz :" + e.getMessage());
		}
	}

	private int findMaxId(Statement veritabaniSorguStmt) {
		
		int maxid = 0;
		try {
			ResultSet sonuclarMaxId = veritabaniSorguStmt.executeQuery("SELECT max(id) maxid FROM ogrenciler");
			while(sonuclarMaxId.next()) {
				maxid = sonuclarMaxId.getInt("maxid");
			}
		} catch (SQLException e) {
			System.out.println("Maxid sorgu hatasi" + e.getMessage());
			e.printStackTrace();
		}
		return maxid;
	}

	private Statement veritabaniAyarla()  {
		Statement veritabaniSorguStmt = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			
			Connection veritabaniBaglantisi = DriverManager.getConnection(
				"jdbc:derby:"
				// + ".\\.veritabaniDers7\\" // windows ortami icin
				+ "./.veritabaniDers7/"
				+ ";create=true;"
				);
		
			veritabaniSorguStmt = veritabaniBaglantisi.createStatement();
		} catch (Exception e) {
			System.out.println("Veritabani baglanti hatasi" + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		try  {
			veritabaniSorguStmt.executeUpdate(
					"CREATE TABLE "
							+ "ogrenciler ("
								+ "id int primary key, "
								+ "isim varchar(40), "
								+ "yas int"
							+ ")"
			);
		} catch(Exception e) {
			System.out.println("Tablo zaten mevcut. Tekrar olusturulmayacak: " + e.getMessage());
			return null;
		}
		return veritabaniSorguStmt;
	}

	public static void main(String[] args) {
		JFrame ekran = new OgrenciYonetimEkrani();
		ekran.setVisible(true);
	}
}
