package tr.edu.medipol.odevler2.celal_sahin;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.*;
import javax.swing.*;
/*
 * Derby veri tabani bilgisayarimda hata veriyordu, mysql ile veri gonderme islemi yaptim
 * 
 *  Veri Tabani URL = https://www.db4free.net/phpMyAdmin/sql.php?db=celalsahin&table=ogrenciBilgileri&pos=0
 * 
 * kullanici adi = celalssahinn
 * parola = *.60.*cek
 */
public class calisma<User> {

	public static void main(String[] args) throws ClassNotFoundException {
		islem();

	}

	public static void islem() {

		JFrame janaForm = new JFrame();
		janaForm.setResizable(false);

		janaForm.setSize(400, 200);
		janaForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janaForm.setTitle("Ogrenci is");
		janaForm.setLayout(new GridLayout(2, 1));

		JMenuBar menuBar = new JMenuBar();
		janaForm.setJMenuBar(menuBar);
		menuBar.setBackground(Color.ORANGE);

		JMenu ogrenciKayitislemleriMenu = new JMenu("Ogrenci Kayit islemleri");
		menuBar.add(ogrenciKayitislemleriMenu);
		JMenuItem ogrenciEkleMenu = new JMenuItem("Ogrenci Ekle");
		ogrenciKayitislemleriMenu.add(ogrenciEkleMenu);

		JMenu ogrenciGoruntulemeislemleriMenu = new JMenu("Ogrenci Goruntuleme islemleri");
		menuBar.add(ogrenciGoruntulemeislemleriMenu);
		JMenuItem ogrenciGoruntuleMenu = new JMenuItem("Ogrenci Goruntule");
		ogrenciGoruntulemeislemleriMenu.add(ogrenciGoruntuleMenu);

		JMenuItem cikis = new JMenuItem("cikis");
		menuBar.add(cikis);
		cikis.setBackground(Color.ORANGE);

		class cikisYap implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		cikis.addActionListener(new cikisYap());

		class ogrenciEkle implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				JFrame ogrenciEkle = new JFrame("Ogrenci Kayit");
				ogrenciEkle.setSize(400, 200);
				ogrenciEkle.setBackground(Color.yellow);
				ogrenciEkle.setLayout(new GridLayout(5, 1));

				JLabel ad = new JLabel("Ad:");
				ogrenciEkle.add(ad);
				final JTextField adGiris = new JTextField();
				ogrenciEkle.add(adGiris);

				JLabel soyad = new JLabel("Soyad:");
				ogrenciEkle.add(soyad);
				final JTextField soyadGiris = new JTextField();
				ogrenciEkle.add(soyadGiris);

				JLabel bolum = new JLabel("Bolum:");
				ogrenciEkle.add(bolum);
				final JTextField bolumGiris = new JTextField();
				ogrenciEkle.add(bolumGiris);

				JLabel girisYili = new JLabel("Giris Yili:");
				ogrenciEkle.add(girisYili);
				final JTextField girisYiliYazi = new JTextField();
				ogrenciEkle.add(girisYiliYazi);

				JButton gonder = new JButton("Gonder");
				ogrenciEkle.add(gonder);

				ogrenciEkle.setVisible(true);

				class ogrenciEkleVeriTabani implements ActionListener {
					public void actionPerformed(ActionEvent e) {

						String girisYiliKontrol = "^[0-9]+{0,5}$";

						Pattern pgirisYiliKontrol = Pattern.compile(girisYiliKontrol, Pattern.CASE_INSENSITIVE);
						Matcher eslestiriciGirisYili = pgirisYiliKontrol.matcher(girisYiliYazi.getText());
						boolean eslestiMiGirisYili = eslestiriciGirisYili.find();

						String bos = "[a-zA-Z[iiiiii0-9]]";

						Pattern bosNesne = Pattern.compile(bos, Pattern.CASE_INSENSITIVE);
						Matcher eslesBosAd = bosNesne.matcher(adGiris.getText());
						boolean eslestiMiAd = eslesBosAd.find();
						Matcher eslesBosSoyad = bosNesne.matcher(soyadGiris.getText());
						boolean eslestiMiSoyad = eslesBosSoyad.find();
						Matcher eslesBosBolum = bosNesne.matcher(bolumGiris.getText());
						boolean eslestiMiBolum = eslesBosBolum.find();

						if ((eslestiMiAd && eslestiMiSoyad && eslestiMiBolum && eslestiMiGirisYili) == true) {

							try {
								kodGiris("insert into ogrenciBilgileri (ad,soyad,bolum,girisYili) values('"
										+ adGiris.getText() + "','" + soyadGiris.getText() + "','"
										+ bolumGiris.getText() + "'," + girisYiliYazi.getText() + ")");
							} catch (Exception ex) {

							}

						}

						else if (eslestiMiAd && eslestiMiSoyad && eslestiMiBolum && eslestiMiGirisYili == false) {
							JOptionPane.showConfirmDialog(null, "Giris yili sayi olmak zorundadir",
									"Sayi degeri hatasi", JOptionPane.CLOSED_OPTION);
						}

						else {
							JOptionPane.showConfirmDialog(null, "Bos deger bulunmakta", "Bos deger hatasi",
									JOptionPane.CLOSED_OPTION);
						}

					}
				}
				gonder.addActionListener(new ogrenciEkleVeriTabani());
			}
		}
		ogrenciEkleMenu.addActionListener(new ogrenciEkle());

		class ogrencileriListele implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JFrame ogrenciListele = new JFrame("Ogrenci Listele");

				ogrenciListele.setSize(400, 200);
				ogrenciListele.setBackground(Color.yellow);
				ogrenciListele.setLayout(new GridLayout(5, 1));

				JTextField verilerCekilemedi=new JTextField("VERiLER CEKiLEMEDi");
				ogrenciListele.add(verilerCekilemedi);
				
				
				ogrenciListele.setVisible(true);
			}
		}
		ogrenciGoruntuleMenu.addActionListener(new ogrencileriListele());

		janaForm.setVisible(true);
	}

	public static void kodGiris(String kod) throws ClassNotFoundException {

		try {
			Statement st = null;

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/celalsahin", "celalssahinn",
					"*.60.*cek");
			JOptionPane.showConfirmDialog(null, "islem tamamlandi", "islem basari ile tamamlanmistir",
					JOptionPane.CLOSED_OPTION);
			st = con.createStatement();
			st.executeUpdate(kod);
			st.close();
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Veri Tabani Baglanti HATASi");
		}
	}

}
