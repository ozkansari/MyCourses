package tr.edu.medipol.odevler3.numan_gungur;

import java.sql.*;

import org.apache.derby.tools.sysinfo;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Numan3 {

	public static void main(String[] args)
			// ******
			// OZKANS DUZELTME
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	// ******
	{
		islem();

	}

	public static void islem()
			// ******
			// OZKANS DUZELTME
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	// ******
	{
		JFrame jform = new JFrame();

		jform.setSize(500, 300);
		jform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jform.setTitle("Kutuphane Yonetim");

		jform.setLayout(new GridLayout(1, 1));

		JPanel jformYayin = new JPanel();

		jformYayin.setLayout(new GridLayout(3, 1));

		JButton ogrenciEkle = new JButton("Ogrenci ekleme");
		jform.add(ogrenciEkle);
		JButton ogrenciGoruntule = new JButton("Ogrenci Goruntuleme");
		jform.add(ogrenciGoruntule);

		class ogrenciEkle implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				JFrame ogrenciEkle = new JFrame();
				ogrenciEkle.setSize(500, 300);
				ogrenciEkle.setTitle("Kitap Ekleme Application ");
				ogrenciEkle.setLayout(new GridLayout(5, 1));

				JLabel ad = new JLabel("Adınızı Giriniz:");
				ogrenciEkle.add(ad);
				final JTextField adGiris = new JTextField();
				ogrenciEkle.add(adGiris);

				JLabel soyad = new JLabel("Soyadınızı Giriniz:");
				ogrenciEkle.add(soyad);
				final JTextField soyadGiris = new JTextField();
				ogrenciEkle.add(soyadGiris);

				JLabel bolum = new JLabel("Bolum Adını Giriniz:");
				ogrenciEkle.add(bolum);
				final JTextField bolumGiris = new JTextField();
				ogrenciEkle.add(bolumGiris);

				JLabel girisYili = new JLabel("Giris Yilinızı Giriiz:");
				ogrenciEkle.add(girisYili);
				final JTextField girisYiliYazi = new JTextField();
				ogrenciEkle.add(girisYiliYazi);

				JButton gonder = new JButton("Gonder");
				ogrenciEkle.add(gonder);

				ogrenciEkle.setVisible(true);

				class ogrenciEkleVeriTabani implements ActionListener {
					public void actionPerformed(ActionEvent e) {

						String sayfaSayisiSablon = "^[0-9]+{0,5}$";

						Pattern sablonNesnesi = Pattern.compile(sayfaSayisiSablon, Pattern.CASE_INSENSITIVE);
						Matcher eslestiriciGirisYili = sablonNesnesi.matcher(girisYiliYazi.getText());
						boolean eslestiMiGirisYili = eslestiriciGirisYili.find();

						String bos = "[a-zA-Z[ğüişöç0-9]]";

						Pattern bosNesne = Pattern.compile(bos, Pattern.CASE_INSENSITIVE);
						Matcher eslesBosAd = bosNesne.matcher(adGiris.getText());
						boolean eslestiMiAd = eslesBosAd.find();
						Matcher eslesBosSoyad = bosNesne.matcher(soyadGiris.getText());
						boolean eslestiMiSoyad = eslesBosSoyad.find();
						Matcher eslesBosBolum = bosNesne.matcher(bolumGiris.getText());
						boolean eslestiMiBolum = eslesBosBolum.find();

						if ((eslestiMiAd && eslestiMiSoyad && eslestiMiBolum && eslestiMiGirisYili) == true) {
							JOptionPane.showConfirmDialog(null, "İşlemler Dogru Girişiniz Yapıldı\"", "",
									JOptionPane.CLOSED_OPTION);

						}

						else if (eslestiMiAd && eslestiMiSoyad && eslestiMiBolum && eslestiMiGirisYili == false) {
							JOptionPane.showConfirmDialog(null, "Sayi girmediniz\"", "Sayi degeri hatasi",
									JOptionPane.CLOSED_OPTION);
						}

						else {
							JOptionPane.showConfirmDialog(null, "Boş deger bulunmakta\"", "Sayi degeri hatasi",
									JOptionPane.CLOSED_OPTION);
						}

					}
				}
				gonder.addActionListener(new ogrenciEkleVeriTabani());
			}
		}
		ogrenciEkle.addActionListener(new ogrenciEkle());
		jform.setVisible(true);

		final String VERITABANI_DIZINI = ".\\.numangungor\\odev3\\";

		final String VERITABANI_URL = "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";

		// OZKANS DUZELTME public static void main (String[] konsolParametreleri) throws
		// Exception {
		System.out.println(VERITABANI_URL);

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
		Connection conn = DriverManager.getConnection(VERITABANI_URL);

		Statement stmt = conn.createStatement();

		String tabloAdi = "ogrenci";

		try {
			stmt.executeUpdate("CREATE TABLE " + tabloAdi + " (" + "ogrenci_id int primary key, "
					+ "ad varchar(30)" + ",soyad varchar(30)" + ",Bolum varchar(20)" + ",Giris Yılı varchar(10)" + ")");
			System.out.println("Tablo " + tabloAdi + " olusturuldu");
		} catch (Exception e) {

			System.out.println("Tablo " + tabloAdi + " zaten mevcut " + e.getMessage());
		}

		try {
			stmt.executeUpdate("INSERT INTO " + tabloAdi + " VALUES (" + "numan ," + "\'güngör\'" + "\'bilişim\'"
					+ "\'2015\'" + ")");
			System.out.println("Kayit eklendi");
		} catch (Exception e) {

			System.out.println("Kayit zaten mevcut. Hata: " + e.getMessage());
		}

		class ogrenciGoruntule implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				// OZKANS DUZELTME
				try {
					// ******

					ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabloAdi);
					while (rs.next()) {
						int ogrenciId = rs.getInt("ogrenci_id");
						String ad = rs.getString("ad");
						String Soyad = rs.getString("soyad");
						String Bolum = rs.getString("Bolum");
						String GirisYılı = rs.getString("Girisyılı");
						System.out.println(ogrenciId + ad + Soyad + Bolum + GirisYılı);
					}

					// OZKANS DUZELTME
					// ******
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				// ******

			}
		}
		// OZKANS DUZELTME
		ogrenciGoruntule.addActionListener(new ogrenciGoruntule());
		// OZKANS DUZELTME conn.close();
	}

	// OZKANS DUZELTME
	/*
	 * jform.setVisible(true);
	 * 
	 * }
	 */
}
