package tr.edu.medipol.ilerijava.ders10.db;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// https://db.apache.org/derby/papers/DerbyTut/embedded_intro.html

public class DerbyGUI extends JFrame {
	
	private JTextField adSoyadGirisi = new JTextField();
	private JTextField yasGirisi = new JTextField();
	private JTextArea bilgiAlani = new JTextArea();
	private JButton girisButonu = new JButton("Ekle");
	
	private Statement veritabaniKomutCalistirici = null;
	
	public static void main(String[] args) throws Exception {
		DerbyGUI ekran1 = new DerbyGUI();
		ekran1.setVisible(true);
	}
	
	public DerbyGUI() {

		veritabaniKomutCalistirici = veritabaninaBaglan();
		tablolariOlustur();
		verileriVeritabanindanYukle();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ders 9 - Derby GUI");
		this.setSize(500, 200);
		this.setLocation(600, 50);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.CYAN);
		this.bilgiAlani.setEditable(false);
		
		this.setLayout(new GridLayout(3,1));
		
		JPanel kullaniciGirisiPaneli = new JPanel();
		kullaniciGirisiPaneli.setLayout(new GridLayout(2,2));
		kullaniciGirisiPaneli.add(new JLabel("Ad-Soyad:"));
		kullaniciGirisiPaneli.add(adSoyadGirisi);
		kullaniciGirisiPaneli.add(new JLabel("Yas:"));
		kullaniciGirisiPaneli.add(yasGirisi);
		this.add(kullaniciGirisiPaneli);
		
		this.add(new JScrollPane(bilgiAlani));
		
		this.add(girisButonu);
		girisButonu.addActionListener( e -> butonIslemi(e) );

	}

	private void butonIslemi(ActionEvent event) {
		System.out.println("Buton cagrildi: " + event.getActionCommand());
		String isim = adSoyadGirisi.getText();
		String yas = yasGirisi.getText();
		bilgiEkle(isim, yas);
		// https://stackoverflow.com/questions/5147768/scroll-jscrollpane-to-bottom
		adSoyadGirisi.setText("");
		yasGirisi.setText("");
		
		veritabaninaEkle(isim, yas);
	}

	private void bilgiEkle(String isim, String yas) {
		bilgiAlani.setText( bilgiAlani.getText() 
				+ isim + " " 
				+ yas + "\n");
		bilgiAlani.setCaretPosition(bilgiAlani.getDocument().getLength());
	}
	
	/* ---------------------------------------------------------------- */
	/* VERITABANI BAGLANTI ILE ILGILI METOTLAR */
	/* ---------------------------------------------------------------- */
	
	private Statement veritabaninaBaglan() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			String url = "jdbc:derby:"	 // jdbc araciligiyla derby veritabanina baglanacagimizi soyluyoruz (protocol)
					+ "./.veritabani1/;" // veritabani dosyalari ./veritabani1/ dizininde tutulacak.
					+ "create=true;";	 // veritabani eger mevcut degilse olusturmasini soyler
			Connection veritabaniBaglantisi = DriverManager.getConnection(url);
			return veritabaniBaglantisi.createStatement();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Veritabanina baglanirken hata alindi.", 
					"Error", JOptionPane.ERROR_MESSAGE);
			System.out.printf("Veritabanina baglanirken hata alindi %s %n", e.getMessage());
			return null;
		}
	}
	
	private void tablolariOlustur() {
		// CREATE TABLE - Tablo Olustur - Sadece ilk defa calistiginda basarili calisir
		try  {
			String createTableSql = "CREATE TABLE ogrenciler ( isim varchar(40), yas int)";
			veritabaniKomutCalistirici.executeUpdate(createTableSql);
		} catch(Exception e) {
			System.out.println("Tablo zaten mevcut olabilir. " + e.getMessage());
		}
	}
	
	private void verileriVeritabanindanYukle() {
		// SELECT : Veritabanini sorgula, sonuclari goster
		try  {
			ResultSet sonuclar = veritabaniKomutCalistirici.executeQuery(
				"SELECT * FROM ogrenciler"
			);
			while(sonuclar.next()) {
				String sonucIsim = sonuclar.getString("isim");
				int sonucYas = sonuclar.getInt(2);
				bilgiEkle(sonucIsim , String.valueOf(sonucYas) );
			}
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Verileri yuklerken hata alindi: " + e.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void veritabaninaEkle(String isim, String yas) {
		try {
			// INSERT INTO : Veritabanina kaiyt ekle
			veritabaniKomutCalistirici.executeUpdate(
				"INSERT INTO ogrenciler VALUES ('" + isim + "', " + yas + ")"
			);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Veri eklerken hata alindi: " + e.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
