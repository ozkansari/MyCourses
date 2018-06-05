package tr.edu.medipol.odevler3.ahmet_ciloglu;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.derby.tools.sysinfo;

public class VeritabaniOdev {

	public static void main(String[] konsolParametreleri) throws Exception {
		new Ekran();
	}
}

class Ekran {
	public static final String VERITABANI_DIZINI = ".\\.ahmetciloglu\\odev3\\";

	public static final String VERITABANI_URL = "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";

// OZKANS DUZELTME
	private Connection conn;
// OZKANS DUZELTME
	
	public Ekran() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println(VERITABANI_URL);

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		conn = DriverManager.getConnection(VERITABANI_URL);

		Statement stmt = conn.createStatement();

		String Ogrenci = "ogrenci";

		// TABLO OLUSTURMA ISLEMI
		try {

			stmt.executeUpdate("CREATE TABLE " + Ogrenci + " (" + "ogrenci_id int primary key,"
					+ "ogrenci_ad varchar(30)," + "ogrenci_soyad varchar(30)," + "bolum varchar(30)," + "yili int"
					+ ")");
			System.out.println("Tablo " + Ogrenci + " olusturuldu");
		} catch (Exception e) {
			// zaten tablo varsa hata verir
			System.out.println("Tablo " + Ogrenci + " zaten mevcut " + e.getMessage());
		}

		// OZKANS DUZELME conn.close();

		JFrame ekran1 = new JFrame("Ogrenci Ekle");

		final JEditorPane text = new JEditorPane();
		text.setBounds(10, 70, 700, 500);
		ekran1.getContentPane().add(text);

		JButton yazdir = new JButton("Ogrencileri Yazdir");
		yazdir.setBounds(10, 10, 200, 50);
		ekran1.getContentPane().add(yazdir);

		yazdir.addActionListener(event -> {
			// KAYIT SORGULA
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM " + Ogrenci);
				while (rs.next()) {
					int ogrenciId = rs.getInt("ogrenci_id");
					String ad = rs.getString("ogrenci_ad");
					String soyad = rs.getString("ogrenci_soyad");
					String bolum = rs.getString("ogrenci_bolum");
					int yil = rs.getInt("yili");

					text.setPage(ogrenciId + ad + soyad + bolum + yil);
				}
			} catch (Exception e) {
				e.getMessage();
			}

		});

		// menu
		JMenuBar menubar = new JMenuBar();
		JMenu eklemenu = new JMenu("Ekle");
		JMenuItem ogrenciEkle = new JMenuItem("Ogrenci Ekle");
		JMenuItem cikis = new JMenuItem("ÇIKIŞ");
		ekran1.setJMenuBar(menubar);
		menubar.add(eklemenu);
		eklemenu.add(ogrenciEkle);
		eklemenu.add(cikis);
		ogrenciEkle.addActionListener(e -> {
			ekran2();
		});
		cikis.addActionListener(e -> {
			System.exit(0);

		});

		ekran1.setLayout(null);
		ekran1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ekran1.setBounds(100, 100, 800, 800);
		ekran1.setLocationRelativeTo(null);
		ekran1.setVisible(true);
	}

	public JFrame ekran2 = new JFrame("Ogrenci Ekle");
	public JButton ogrenciEkleme = new JButton("Ogrenci Ekle");
	public JTextField ogrenciAdi = new JTextField();
	public JTextField ogrenciSoyadi = new JTextField();
	public JTextField ogrenciBolum = new JTextField();
	public JTextField okulaGiris = new JTextField();
	public JLabel adiLabel = new JLabel("Ogrenci Adını Yazınız:");
	public JLabel soyadiLabel = new JLabel("Ogrenci Soyadını Yazınız:");
	public JLabel bolumLabel = new JLabel("Ogrenci Bolumunu Yazınız:");
	public JLabel girisLabel = new JLabel("Okula Giris Yılı");

	private void ekran2() {

		String karakter = "[a-zA-Z[ğüişöç0-9]]";

		ekran2.getContentPane().add(adiLabel);
		adiLabel.setBounds(10, 35, 200, 50);
		ekran2.getContentPane().add(soyadiLabel);
		soyadiLabel.setBounds(10, 85, 200, 50);
		ekran2.getContentPane().add(bolumLabel);
		bolumLabel.setBounds(10, 135, 200, 50);
		ekran2.getContentPane().add(girisLabel);
		girisLabel.setBounds(10, 185, 200, 50);

		ekran2.getContentPane().add(ogrenciAdi);
		ogrenciAdi.setBounds(150, 50, 100, 25);

		ekran2.getContentPane().add(ogrenciSoyadi);
		ogrenciSoyadi.setBounds(150, 100, 100, 25);

		ekran2.getContentPane().add(ogrenciBolum);
		ogrenciBolum.setBounds(150, 150, 100, 25);

		ekran2.getContentPane().add(okulaGiris);
		okulaGiris.setBounds(150, 200, 100, 25);

		ekran2.getContentPane().add(ogrenciEkleme);
		ogrenciEkleme.setBounds(250, 300, 125, 50);

		ogrenciEkleme.addActionListener(e -> {
			
			// OZKANS DUZELTME: Buraya tasindi
			Pattern dolumu = Pattern.compile(karakter, Pattern.CASE_INSENSITIVE);
			Matcher bosadi = dolumu.matcher(ogrenciAdi.getText());
			boolean adEs = bosadi.find();
			Matcher bossoyadi = dolumu.matcher(ogrenciSoyadi.getText());
			boolean esSoyad = bossoyadi.find();
			Matcher bosbolum = dolumu.matcher(ogrenciBolum.getText());
			boolean esBolum = bosbolum.find();

			String numaralar = "^[0-9]+{0,5}$";

			Pattern numara = Pattern.compile(numaralar, Pattern.CASE_INSENSITIVE);
			Matcher eseYili = numara.matcher(okulaGiris.getText());
			boolean esYili = eseYili.find();
			// OZKANS
			
			if ((adEs && esSoyad && esBolum && esYili) == true) {
				JOptionPane.showConfirmDialog(null, "Kayıt Oluşturuldu...\"", "Başarılı", JOptionPane.CLOSED_OPTION);

			}

			else if (adEs && esSoyad && esBolum && esYili == false) {
				JOptionPane.showConfirmDialog(null, "Yılı alanına sayı değeri giriniz\"", "Sayi degeri hatasi",
						JOptionPane.CLOSED_OPTION);
			}

			else {
				JOptionPane.showConfirmDialog(null, "Boş alan bırakmayınız\"", "Sayı Giriniz",
						JOptionPane.CLOSED_OPTION);
			}
			// KAYIT EKLE
			try {

				String sorgu = "insert into Ogrenci(ogrenci_ad,ogrenci_soyad,bolum,yili) values(?,?,?,?) ";
				PreparedStatement ps = conn.prepareStatement(sorgu);

				ps.setString(1, ogrenciAdi.getText());
				ps.setString(2, ogrenciSoyadi.getText());
				ps.setString(3, ogrenciBolum.getText());
				ps.setString(4, okulaGiris.getText());
				System.out.println("Kayit eklendi");
				
				// OZKANS EKLEME
				ps.executeUpdate();
			} catch (Exception e1) {
				System.out.println("Kayit zaten mevcut. Hata: " + e1.getMessage());
			}

			

		});
		ekran2.setBounds(10, 40, 400, 500);
		ekran2.setLayout(null);
		ekran2.setLocationRelativeTo(null);
		ekran2.setVisible(true);

	}

}
