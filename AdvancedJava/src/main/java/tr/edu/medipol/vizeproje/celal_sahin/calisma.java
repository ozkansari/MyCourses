package tr.edu.medipol.vizeproje.celal_sahin;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.regex.*;

public class calisma {

	public static void main(String[] args) throws IOException {
		anaForm();

	}

	public static void anaForm() {

		JFrame jform = new JFrame();// Form oluuturduk

		JFrame jformkitapListele = new JFrame();

		jform.setSize(400, 200);
		jform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jform.setTitle("Kutuphane Yonetim");

		jform.setLayout(new GridLayout(1, 1));

		// -------------------PANELLER--------------------//

		JPanel jformYayin = new JPanel();

		jformYayin.setLayout(new GridLayout(3, 1));

		JMenuBar menuBar = new JMenuBar(); // MenuBar oluuturduk
		jform.setJMenuBar(menuBar);

		// MenuBar uuerisindekiler
		//////////////////////////////////////////////////////////////////////////
		//
		JMenu yayinEvi = new JMenu("Yayun Evi");
		menuBar.add(yayinEvi);
		JMenuItem yayinEviEkle = new JMenuItem("Yayun Evi Ekle");
		yayinEvi.add(yayinEviEkle);

		JMenu kitap = new JMenu("Kitap");
		menuBar.add(kitap);
		JMenuItem kitapEkle = new JMenuItem("Kitap Ekle");
		kitap.add(kitapEkle);
		JMenuItem kitapListele = new JMenuItem("Kitaplaru Listele");
		kitap.add(kitapListele);

		JMenuItem cikis = new JMenuItem("uukuu");
		menuBar.add(cikis);
		//
		////////////////////////////////////////////////////////////////////////////

		jform.setVisible(true);

		// ------------------------ //BUTON KONTROLLERu//
		// -----------------------------------//

		// ------Yayun Evi Ekleme------------//
		class yayinEviEkleBas implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				JFrame jformyayinEkle = new JFrame();
				jformyayinEkle.setSize(400, 200);
				jformyayinEkle.setTitle("Yayun Evi Ekleme Application");
				jformyayinEkle.setLayout(new GridLayout(3, 1));

				JLabel yayinEviYazi = new JLabel("Yayun Evi Adu:");
				jformyayinEkle.add(yayinEviYazi);
				JTextField yayinEviGiris = new JTextField();
				jformyayinEkle.add(yayinEviGiris);

				JLabel epostaYazi = new JLabel("E-posta Adresiniz:");
				jformyayinEkle.add(epostaYazi);
				JTextField epostaGiris = new JTextField();
				jformyayinEkle.add(epostaGiris);

				JButton yayinEkleGonder = new JButton("Gunder");
				jformyayinEkle.add(yayinEkleGonder);
				//// ----**Yayin Evi Butona Tukalyunca Gonder** -----////
				class yayinEviGonderButon implements ActionListener {
					public void actionPerformed(ActionEvent e) {

						String mailSablonu = "^[a-zA-Z[uuuuuu0-9]]+@+[a-z]+.com$";
						String yayinEviSablonu = "[a-zA-Z[uuuuuu0-9]]";
						Pattern sablonNesnesi = Pattern.compile(mailSablonu, Pattern.CASE_INSENSITIVE);
						Pattern yayinEviSablonNesnesi = Pattern.compile(yayinEviSablonu, Pattern.CASE_INSENSITIVE);
						Matcher eslestirici = sablonNesnesi.matcher(epostaGiris.getText());
						Matcher eslestirici2 = yayinEviSablonNesnesi.matcher(yayinEviGiris.getText());
						boolean eslestiMi = eslestirici.find();
						boolean eslestiMi2 = eslestirici2.find();

						if (eslestiMi && eslestiMi2) {
							// OZKANS DUZELTME: File file = new File("C:\\Users\\celal\\Desktop\\yayinEviEkle.txt");
							/* OZKANS DUZELTME: */ File file = new File(".\\config\\yayinEviEkle.txt");
							if (!file.exists()) {
								try {
									file.createNewFile();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}

							FileWriter fileWriter = null;
							try {
								fileWriter = new FileWriter(file, true);
							} catch (IOException e2) {

								e2.printStackTrace();
							}
							BufferedWriter bWriter = new BufferedWriter(fileWriter);

							try {
								bWriter.write(yayinEviGiris.getText());

							} catch (IOException e1) {

								e1.printStackTrace();
							}
							try {
								JOptionPane.showConfirmDialog(null, "Yayunevi Bauaru ule Eklenmiutir\"", "Yuklendi",
										JOptionPane.CLOSED_OPTION);
								bWriter.newLine();
								bWriter.close();
							} catch (IOException e1) {

								e1.printStackTrace();
							}
						}

						else if (eslestiMi) {
							JOptionPane.showConfirmDialog(null, "Yayun Evi Adu Bou Geuilemez\"", "Yayun Evi Bou",
									JOptionPane.CLOSED_OPTION);
						} else if (eslestiMi2) {
							JOptionPane.showConfirmDialog(null,
									"E-posta Adresini kontrol ediniz\n@****.com biuiminde giriniz\"",
									"Yanluu E-posta giriui", JOptionPane.CLOSED_OPTION);
						} else {
							JOptionPane.showConfirmDialog(null, "Bou Geuilemez\"", "Bou Giriu",
									JOptionPane.CLOSED_OPTION);

						}
					}
				}

				//////////////////////////////////////////
				yayinEkleGonder.addActionListener(new yayinEviGonderButon());

				jformyayinEkle.setVisible(true);
			}
		}
		yayinEviEkle.addActionListener(new yayinEviEkleBas());

		// ----------------------Kitap Ekle--------------------//

		class kitapEkleBas implements ActionListener {
			public void actionPerformed(ActionEvent e) {

				JFrame jformkitapEkle = new JFrame();
				jformkitapEkle.setSize(400, 200);
				jformkitapEkle.setTitle("Kitap Ekleme Application ");
				jformkitapEkle.setLayout(new GridLayout(6, 1));

				JLabel kitapAdiYazi = new JLabel("Kitap Adu:");
				jformkitapEkle.add(kitapAdiYazi);
				JTextField kitapAdiGiris = new JTextField();
				jformkitapEkle.add(kitapAdiGiris);

				JLabel yazarYazi = new JLabel("Yazaru:");
				jformkitapEkle.add(yazarYazi);
				JTextField yazarGiris = new JTextField();
				jformkitapEkle.add(yazarGiris);

				JLabel kitapTuru = new JLabel("Turu:");
				jformkitapEkle.add(kitapTuru);
				JTextField kitapTuruGiris = new JTextField();
				jformkitapEkle.add(kitapTuruGiris);

				JLabel kitapsayfaSayisi = new JLabel("Sayfa Sayusu:");
				jformkitapEkle.add(kitapsayfaSayisi);
				JTextField kitapsayfaSayisiGiris = new JTextField();
				jformkitapEkle.add(kitapsayfaSayisiGiris);

				JLabel kitapYayinEvleri = new JLabel("Yayun Evi:");
				jformkitapEkle.add(kitapYayinEvleri);
				JComboBox yayinEvleriBilgileri = new JComboBox();
				yayinEvleriBilgileri.setBounds(46, 42, 140, 20);
				jformkitapEkle.add(yayinEvleriBilgileri);
				yayinEvleriBilgileri.addItem("Bou");

				// OZKANS DUZELTME: File file = new File("C:\\Users\\celal\\Desktop\\yayinEviEkle.txt");
				/* OZKANS DUZELTME: */ File file = new File(".\\config\\yayinEviEkle.txt");
				BufferedReader reader = null;
				try {
					reader = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e3) {

					e3.printStackTrace();
				}
				int i = 0;
				String satir = "";
				try {
					satir = reader.readLine();
				} catch (IOException e2) {

					e2.printStackTrace();
				}

				while (satir != null) {
					i++;

					try {
						satir = reader.readLine();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					yayinEvleriBilgileri.addItem(satir);

				}

				JButton kitapEkleGonder = new JButton("Gunder");
				jformkitapEkle.add(kitapEkleGonder);
				// ---------------------KuTAP EKLE BUTON-------------------//

				class kitapEkleButon implements ActionListener {
					public void actionPerformed(ActionEvent e) {

						String sayfaSayisiSablon = "^[0-9]+{0,5}$";

						Pattern sablonNesnesi = Pattern.compile(sayfaSayisiSablon, Pattern.CASE_INSENSITIVE);
						Matcher eslestirici = sablonNesnesi.matcher(kitapsayfaSayisiGiris.getText());
						boolean eslestiMi = eslestirici.find();

						if (eslestiMi) {
							// OZKANS DUZELTME: File file = new File("C:\\Users\\celal\\Desktop\\kitapEkle.txt");,
							/* OZKANS DUZELTME: */ File file = new File(".\\config\\kitapEkle.txt");

							if (!file.exists()) {
								try {
									file.createNewFile();
								} catch (IOException e1) {

									e1.printStackTrace();
								}
							}

							FileWriter fileWriter = null;
							try {
								fileWriter = new FileWriter(file, true);
							} catch (IOException e2) {

								e2.printStackTrace();
							}
							BufferedWriter bWriter = new BufferedWriter(fileWriter);

							try {
								bWriter.write(kitapAdiYazi.getText());
								bWriter.write(kitapAdiGiris.getText());
								bWriter.write("   ");
								bWriter.write(yazarYazi.getText());
								bWriter.write(yazarGiris.getText());
								bWriter.write("   ");
								bWriter.write(kitapTuru.getText());
								bWriter.write(kitapTuruGiris.getText());
								bWriter.write("   ");
								bWriter.write(kitapsayfaSayisi.getText());
								bWriter.write(kitapsayfaSayisiGiris.getText());
								bWriter.write("   ");
								bWriter.write(kitapYayinEvleri.getText());
								bWriter.write(yayinEvleriBilgileri.getSelectedItem().toString());
								JOptionPane.showConfirmDialog(null, "Kitap Bauaru ule Eklenmiutir\"", "Yuklendi",
										JOptionPane.CLOSED_OPTION);
								bWriter.newLine();
								bWriter.close();
							} catch (IOException e1) {

								e1.printStackTrace();
							}

						} else {
							JOptionPane.showConfirmDialog(null, "Sayfa sayusunu kontrol ediniz\"",
									"Sayfa Sayusu Hatasu", JOptionPane.CLOSED_OPTION);

						}
					}

				}
				kitapEkleGonder.addActionListener(new kitapEkleButon());
				/////////////////////////////////////////////////////////////

				jformkitapEkle.setVisible(true);
			}
		}

		kitapEkle.addActionListener(new kitapEkleBas());

		//////////// --------------KuTAP LuSTELE---------------//////////////
		class kitapListeleListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				JFrame jformkitapListele = new JFrame();
				jformkitapListele.setSize(600, 400);
				jformkitapListele.setTitle("Kitap Listeleme Application");

				jformkitapListele.setLayout(new GridLayout(2, 2));

				JTextArea listele = new JTextArea();
				jformkitapListele.add(listele);
				jformkitapListele.setVisible(true);

				JButton listeGuncelle = new JButton("Guncelle");
				jformkitapListele.add(listeGuncelle);

				try {
					// OZKANS DUZELTME: FileReader oku = new FileReader("C:\\Users\\celal\\Desktop\\kitapEkle.txt");
					/* OZKANS DUZELTME: */ FileReader oku = new FileReader(".\\config\\kitapEkle.txt");
					BufferedReader br = new BufferedReader(oku);
					listele.read(br, null);
					br.close();

				}

				catch (Exception e1) {
					JOptionPane.showInternalMessageDialog(null, e1);
				}

				class listeGuncelleListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						// OZKANS DUZELTME: File file = new File("C:\\Users\\celal\\Desktop\\kitapEkle.txt");,
						/* OZKANS DUZELTME: */ File file = new File(".\\config\\kitapEkle.txt");

						if (!file.exists()) {
							try {
								file.createNewFile();
							} catch (IOException e1) {

								e1.printStackTrace();
							}
						}

						FileWriter fileWriter = null;
						try {
							fileWriter = new FileWriter(file, false);
						} catch (IOException e2) {

							e2.printStackTrace();
						}
						BufferedWriter bWriter = new BufferedWriter(fileWriter);

						try {
							bWriter.write(listele.getText());
							bWriter.close();
						} catch (IOException e1) {

							e1.printStackTrace();
						}
					}
				}
				listeGuncelle.addActionListener(new listeGuncelleListener());

			}
		}

		kitapListele.addActionListener(new kitapListeleListener());
		/////////////////////////////////////////////////////////////////////

		class cikisYap implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}

		cikis.addActionListener(new cikisYap());

	}

}
