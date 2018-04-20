package tr.edu.medipol.vizeproje.ismail_sahin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class KutuphaneYonetimMain {
	public static KutuphaneController ktphnController = new KutuphaneController();
	public static boolean degisiklikVarMi = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new anaEkran();
			}
		});
	}

	static class anaEkran {
		private JFrame anaFrame = new JFrame("Kutuphane Yonetim");

		private JButton kitapEkleBtn = new JButton("Kitap Ekle");
		private JButton yayinEviEkleBtn = new JButton("Yay�nevi Ekle");
		private JButton kitapListeleBtn = new JButton("Kitap Listele");
		private JButton kaydetVeCikBtn = new JButton("Kaydet Ve ��k");

		public anaEkran() {
			
			anaEkranHazirla();

			kitapEkleBtn.addActionListener(e -> {
				// JOptionPane.showMessageDialog(anaFrame, "Epostay� yanl�� girdiniz...");
				new KitapEkleEkrani();
			});

			yayinEviEkleBtn.addActionListener(e -> {
				new YayineviEkleEkrani();
			});

			kitapListeleBtn.addActionListener(e -> {
				if (ktphnController.kitaplarList.size() != 0) {
					new KitapListeleEkrani();
				} else {
					JOptionPane.showMessageDialog(anaFrame, "Listenelecek kitap bulunmamaktad�r..");
				}
			});

			kaydetVeCikBtn.addActionListener(e -> {
				if (degisiklikVarMi == true) {
					ktphnController.dosyayaYaz();
					JOptionPane.showMessageDialog(anaFrame, "Ba�ar�yla kaydedildi..");
				}
				System.exit(0);
			});
			
		}

		public void anaEkranHazirla() {
			anaFrame.setSize(300, 145);
			anaFrame.setLocation(700, 700);
			anaFrame.setLocationRelativeTo(null);
			anaFrame.setResizable(false);
			anaFrame.setLayout(null);
			anaFrame.setVisible(true);
			anaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			kitapEkleBtn.setBounds(15, 15, 125, 35);
			kitapEkleBtn.setBackground(Color.white);

			yayinEviEkleBtn.setBounds(155, 15, 125, 35);
			yayinEviEkleBtn.setBackground(Color.white);

			kitapListeleBtn.setBounds(15, 65, 125, 35);
			kitapListeleBtn.setBackground(Color.white);

			kaydetVeCikBtn.setBounds(155, 65, 125, 35);
			kaydetVeCikBtn.setForeground(Color.white);
			kaydetVeCikBtn.setBackground(Color.red);

			anaFrame.add(kitapEkleBtn);
			anaFrame.add(yayinEviEkleBtn);
			anaFrame.add(kitapListeleBtn);
			anaFrame.add(kaydetVeCikBtn);
		}

		class KitapEkleEkrani {
			JFrame kitapEkleFrame = new JFrame("Yeni Kitap Ekle");

			JLabel adiLbl = new JLabel("Kitap Ad�         :");
			JLabel yazarLbl = new JLabel("Yazar               :");
			JLabel sayfaLbl = new JLabel("Sayfa Say�s�   :");
			JLabel turuLbl = new JLabel("T�r�                 :");
			JLabel yayinEviLbl = new JLabel("Yayinevi          :");

			JTextField adiTxt = new JTextField();
			JTextField yazarTxt = new JTextField();
			JTextField turuTxt = new JTextField();
			JTextField sayfaTxt = new JTextField();

			JButton ekleBtn = new JButton("Ekle");

			int size = ktphnController.yayinEviList.size();
			String[] yayinEviListe = new String[size];

			private void listeHazirla() {
				for (int i = 0; i < yayinEviListe.length; i++) {
					yayinEviListe[i] = ktphnController.yayinEviList.get(i).getYayinEviAdi();
				}
			}

			JComboBox yayinEviCb;

			public KitapEkleEkrani() {
				kitapEkleEkraniHazirla();

				ekleBtn.addActionListener(e -> {
					kitapEklemeIslemi();
				});
			}

			public void kitapEkleEkraniHazirla() {
				kitapEkleFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				kitapEkleFrame.setSize(305, 305);
				kitapEkleFrame.setLayout(null);
				kitapEkleFrame.setLocation(700, 700);
				kitapEkleFrame.setLocationRelativeTo(null);
				kitapEkleFrame.setVisible(true);

				adiLbl.setBounds(15, 15, 150, 15);
				adiTxt.setBounds(125, 15, 150, 15);

				yazarLbl.setBounds(15, 50, 150, 15);
				yazarTxt.setBounds(125, 50, 150, 15);

				turuLbl.setBounds(15, 85, 150, 15);
				turuTxt.setBounds(125, 85, 150, 15);

				sayfaLbl.setBounds(15, 120, 150, 15);
				sayfaTxt.setBounds(125, 120, 150, 15);

				listeHazirla();
				yayinEviCb = new JComboBox(yayinEviListe);

				yayinEviLbl.setBounds(15, 155, 150, 15);
				yayinEviCb.setBounds(125, 155, 150, 20);
				yayinEviCb.setBackground(Color.WHITE);

				ekleBtn.setBounds(175, 190, 100, 25);
				ekleBtn.setBackground(Color.WHITE);

				kitapEkleFrame.add(adiLbl);
				kitapEkleFrame.add(adiTxt);
				kitapEkleFrame.add(yazarLbl);
				kitapEkleFrame.add(yazarTxt);
				kitapEkleFrame.add(turuLbl);
				kitapEkleFrame.add(turuTxt);
				kitapEkleFrame.add(sayfaLbl);
				kitapEkleFrame.add(sayfaTxt);
				kitapEkleFrame.add(yayinEviLbl);
				kitapEkleFrame.add(yayinEviCb);
				kitapEkleFrame.add(ekleBtn);
			}

			public void kitapEklemeIslemi() {
				String[] bilgiler = {adiTxt.getText(), yazarTxt.getText(), turuTxt.getText(), sayfaTxt.getText()};
				String hata_mesaji = "";
				int tmp = 0;
				boolean sayiMi = isNumeric(sayfaTxt.getText());
				for (int i = 0; i < bilgiler.length; i++) {
					if (bilgiler[i].equals("") != true) {
						tmp++;
					}else {
						switch (i) {
						case 0:
							hata_mesaji += "Ad� k�sm� bo� ge�ilemez.." + "\n";
							break;
						case 1:
							hata_mesaji += "Yazar ad� bo� ge�ilemez.." + "\n";
							break;
						case 2:
							hata_mesaji += "T�r� k�sm� bo� ge�ilemez.." + "\n";
							break;
						case 3:
							hata_mesaji += "Sayfa k�sm� bo� ge�ilemez..";
							break;
						}
					}
				}
				if (tmp == bilgiler.length) {
					if (sayiMi == true) {
						YayinEvi yayinEvi = new YayinEvi(yayinEviListe[yayinEviCb.getSelectedIndex()]);
						
						Kitap ktp = new Kitap(adiTxt.getText(), yazarTxt.getText(), turuTxt.getText(),
								Integer.parseInt(sayfaTxt.getText()), yayinEvi);
						
						ktphnController.kitaplarList.add(ktp);
						degisiklikVarMi = true;
						
						JOptionPane.showMessageDialog(kitapEkleFrame, "Ba�ar�yla eklendi..");
						kitapEkleFrame.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(kitapEkleFrame, "Sayfa say�s� n�merik olmal�d�r!");
					}
				}else {
					JOptionPane.showMessageDialog(kitapEkleFrame, hata_mesaji);
				}
			}

			private boolean isNumeric(String str) {
				return str.matches("-?\\d+(\\.\\d+)?");
			}
		}

		class YayineviEkleEkrani {
			JFrame yayineviEkleFrame = new JFrame("Yayin Evi Ekle");
			JLabel adiLbl = new JLabel("Yay�nevi Ad�      : ");
			JLabel ePostaLbl = new JLabel("E-Posta Giriniz : ");
			JTextField adiTxt = new JTextField();
			JTextField ePostaTxt = new JTextField();
			JButton ekleBtn = new JButton("Ekle");

			public YayineviEkleEkrani() {
				yayinEviEkranHazirla();

				ekleBtn.addActionListener(e -> {
					yayinEviEklemeIslemi();
				});
			}

			public void yayinEviEklemeIslemi() {
				String ad = adiTxt.getText();
				if (ad.equals("") == false) {
					String ePosta = ePostaTxt.getText();
					if (ePosta.equals("") == false) {
						if (KutuphaneController.ePostaKontrol(ePosta) == true) {
							ktphnController.yayinEviList.add(new YayinEvi(ad, ePosta));
							yayineviEkleFrame.setVisible(false);
							degisiklikVarMi = true;
						} else {
							JOptionPane.showMessageDialog(yayineviEkleFrame, "Ge�ersiz Eposta Girdiniz..");
						}
					} else {
						JOptionPane.showMessageDialog(yayineviEkleFrame, "Eposta k�sm� bo� ge�ilemez..");
					}
				} else {
					if (ePostaTxt.getText().equals("")) {
						JOptionPane.showMessageDialog(yayineviEkleFrame, "Ad� ve Eposta k�sm� bo� ge�ilemez..");
					} else {
						JOptionPane.showMessageDialog(yayineviEkleFrame, "Ad� k�sm� bo� ge�ilemez..");
					}
				}
			}

			public void yayinEviEkranHazirla() {
				yayineviEkleFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				yayineviEkleFrame.setSize(305, 150);
				yayineviEkleFrame.setLayout(null);
				yayineviEkleFrame.setLocation(700, 700);
				yayineviEkleFrame.setLocationRelativeTo(null);
				yayineviEkleFrame.setResizable(false);
				yayineviEkleFrame.setVisible(true);

				adiLbl.setBounds(15, 15, 150, 15);
				adiTxt.setBounds(125, 15, 150, 15);

				ePostaLbl.setBounds(15, 50, 150, 15);
				ePostaTxt.setBounds(125, 50, 150, 15);

				ekleBtn.setBounds(175, 75, 100, 25);
				ekleBtn.setBackground(Color.white);

				yayineviEkleFrame.add(adiLbl);
				yayineviEkleFrame.add(ePostaLbl);
				yayineviEkleFrame.add(adiTxt);
				yayineviEkleFrame.add(ePostaTxt);
				yayineviEkleFrame.add(ekleBtn);
			}
		}

		class KitapListeleEkrani implements ListSelectionListener{
			JFrame kitapListeleFrame = new JFrame("Kitap Listele");
			JButton silBtn = new JButton("Sil");

			ArrayList<Kitap> kitaplar;

			private JList list;
			private DefaultListModel listModel;

			private JEditorPane detayEditor = new JEditorPane();
			boolean silmeBool = false;
			boolean listeBittiMi = false;

			public KitapListeleEkrani() {
				// kitaplarHazirla_deneme();

				kitapListeleEkraniHazirla();

				silBtn.addActionListener(e -> {
					silmeIslemi();
				});
				
			}

			public void kitapListeleEkraniHazirla() {
				kitaplar = ktphnController.kitaplarList;

				kitapListeleFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				kitapListeleFrame.setSize(560, 260);
				kitapListeleFrame.setLocation(700, 700);
				kitapListeleFrame.setLocationRelativeTo(null);
				kitapListeleFrame.setLayout(null);
				kitapListeleFrame.setResizable(false);
				kitapListeleFrame.setVisible(true);

				listModel = new DefaultListModel<>();

				for (Kitap ktp : kitaplar) {
					listModel.addElement(ktp.getKitapAdi());
				}

				list = new JList(listModel);
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				list.setSelectedIndex(0);
				list.addListSelectionListener(this);
				list.setVisibleRowCount(5);

				JScrollPane listScrollPane = new JScrollPane(list);
				listScrollPane.setBounds(15, 15, 250, 150);
				kitapListeleFrame.add(listScrollPane);
				
				JScrollPane detayEditorScroll = new JScrollPane(detayEditor);
				detayEditorScroll.setBounds(280, 15, 250, 150);
				detayEditor.setEditable(false);
				kitapListeleFrame.add(detayEditorScroll);

				detayEkraniGuncelle(list.getSelectedIndex());

				silBtn.setBounds(430, 180, 100, 25);
				silBtn.setBackground(Color.white);
				kitapListeleFrame.add(silBtn);
			}

			public void silmeIslemi() {
				int index = list.getSelectedIndex();
				
				if (index == 0 && listModel.size() > 1) {
					list.setSelectedIndex(1);
					listModel.remove(0);
					ktphnController.kitaplarList.remove(index);
					detayEkraniGuncelle(list.getSelectedIndex());
				}else if(listModel.size() == 1){
					detayEditor.setText("");
					listeBittiMi = true;
					listModel.remove(index);
					ktphnController.kitaplarList.remove(index);
				}else if(listModel.size() > 1) {
					list.setSelectedIndex(index - 1);
					listModel.remove(index);
					ktphnController.kitaplarList.remove(index);
				}
				
				degisiklikVarMi = true;

				if (listModel.size() == 0) {
					silBtn.setEnabled(false);
					JOptionPane.showMessageDialog(kitapListeleFrame, "G�r�nt�lenecek kitap kalmad�..");
					kitapListeleFrame.setVisible(false);
				}
			}

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (listeBittiMi == false) {
					detayEkraniGuncelle(list.getSelectedIndex());
				}
			}

			public void detayEkraniGuncelle(int index) {
				Kitap ktp = ktphnController.kitaplarList.get(index);
				String detayText = "Kitap Ad�\t: " + ktp.getKitapAdi() + "\n" + "Yazar\t: " + ktp.getKitapYazari()
						+ "\n" + "T�r�\t: " + ktp.getKitapTuru() + "\n" + "Sayfa\t: " + ktp.getKitapSayfaSayisi() + "\n"
						+ "Yay�nevi\t: " + ktp.getKitapYayinEvi().getYayinEviAdi();

				detayEditor.setText(detayText);
			}
		}
	}
}
