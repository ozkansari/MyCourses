package tr.edu.medipol.odevler3.ismail_sahin;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.sql.*;

/**
 * Uygulaman�n ana s�n�f�, buradan ba�lar..
 * @author bilgisayar
 *
 */
public class Main {
	
	public static Veritabani veritabani = new Veritabani();
	public static ArrayList<Ogrenci> ogrencilerList = new ArrayList<>();
	
	/**
	 * Uygulaman�n ana fonksyionu.
	 * @param args verilecek parametreler
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		veritabani.veritabaniHazirla();
		new anaEkran();
	}
	
	/**
	 * Uygulamadaki ana ekran� olu�turur ve g�r�nt�ler.
	 * @author bilgisayar
	 *
	 */
	static class anaEkran {
		private JFrame anaFrame = new JFrame("Kutuphane Yonetim");

		private JButton ogrenciEkleBtn = new JButton("Ogrenci Ekle");
		private JButton ogrenciListeleBtn = new JButton("Ogrenci Listele");
		private JButton cikisBtn = new JButton("��k��");

		/**
		 * Ana ekranin constructor'i. Olusturuldugunda cagrilir. Aksiyonlar� tan�mlar. 
		 */
		public anaEkran() {
			
			anaEkranHazirla();

			ogrenciEkleBtn.addActionListener(e -> {
				new OgrenciEkleEkrani();
			});

			ogrenciListeleBtn.addActionListener(e -> {
				try {
					if (veritabani.getOgrenciList().size() != 0) {
						new OgrenciListeleEkrani();
					}else {
						JOptionPane.showMessageDialog(anaFrame, "G�r�nt�lenecek kitap yok..");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});

			cikisBtn.addActionListener(e -> {
				System.exit(0);
			});
		}
		/**
		 * Ana ekran�n ayarlar�n� yapar..
		 */
		public void anaEkranHazirla() {
			anaFrame.setSize(300, 145);
			anaFrame.setLocation(700, 700);
			anaFrame.setLocationRelativeTo(null);
			anaFrame.setResizable(false);
			anaFrame.setLayout(null);
			anaFrame.setVisible(true);
			anaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			ogrenciEkleBtn.setBounds(15, 15, 125, 35);
			ogrenciEkleBtn.setBackground(Color.white);

			ogrenciListeleBtn.setBounds(155, 15, 125, 35);
			ogrenciListeleBtn.setBackground(Color.white);

			cikisBtn.setBounds(155, 65, 125, 35);
			cikisBtn.setForeground(Color.white);
			cikisBtn.setBackground(Color.red);

			anaFrame.add(ogrenciEkleBtn);
			anaFrame.add(ogrenciListeleBtn);
			anaFrame.add(cikisBtn);
		}
	}
	
	/**
	 * Veritaban�ndaki kitaplar� listeleme ekran� olu�turur, aksiyonlar�n� tan�mlar.
	 * @author ismail
	 *
	 */
	static class OgrenciListeleEkrani implements ListSelectionListener{
		private JFrame ogrenciListeleFrame = new JFrame("Kitap Listele");
		private JButton silBtn = new JButton("Sil");

		ArrayList<Ogrenci> ogrenciler = veritabani.getOgrenciList();

		private JList list;
		private DefaultListModel listModel;

		private JEditorPane detayEditor = new JEditorPane();
		boolean silmeBool = false;
		boolean listeBittiMi = false;

		
		/**
		 * OgrenciListeleEkrani'nin contructor fonksiyonu. Ekran� haz�rlar, listenelerlar� ayarlar..
		 * @throws Exception
		 */
		public OgrenciListeleEkrani() throws Exception {
			kitapListeleEkraniHazirla();

			silBtn.addActionListener(e -> {
				try {
					silmeIslemi();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
		}

		/**
		 * Frame'in �zelliklerini ayarlay�p haz�rlar.
		 */
		public void kitapListeleEkraniHazirla() {
			ogrenciListeleFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			ogrenciListeleFrame.setSize(560, 260);
			ogrenciListeleFrame.setLocation(700, 700);
			ogrenciListeleFrame.setLocationRelativeTo(null);
			ogrenciListeleFrame.setLayout(null);
			ogrenciListeleFrame.setResizable(false);
			ogrenciListeleFrame.setVisible(true);

			listModel = new DefaultListModel<>();
			
			for (Ogrenci ogr : ogrenciler) {
				listModel.addElement(ogr.getOgrenciAdiSoyadi());
			}
			
			list = new JList(listModel);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setSelectedIndex(0);
			list.addListSelectionListener(this);
			list.setVisibleRowCount(5);

			JScrollPane listScrollPane = new JScrollPane(list);
			listScrollPane.setBounds(15, 15, 250, 150);
			ogrenciListeleFrame.add(listScrollPane);
			
			JScrollPane detayEditorScroll = new JScrollPane(detayEditor);
			detayEditorScroll.setBounds(280, 15, 250, 150);
			detayEditor.setEditable(false);
			ogrenciListeleFrame.add(detayEditorScroll);

			detayEkraniGuncelle(list.getSelectedIndex());

			silBtn.setBounds(430, 180, 100, 25);
			silBtn.setBackground(Color.white);
			ogrenciListeleFrame.add(silBtn);
		}

		/**
		 * Listedeki se�ili ��renciyi siler. Ekran� g�nceller.
		 * @throws Exception
		 */
		public void silmeIslemi() throws Exception {
			int index = list.getSelectedIndex();
			
			if (index == 0 && listModel.size() > 1) {
				list.setSelectedIndex(1);
				listModel.remove(0);
				veritabani.ogrenciSil(ogrenciler.get(index).getId());
				ogrenciler.remove(index);
				detayEkraniGuncelle(list.getSelectedIndex());
			}else if(listModel.size() == 1){
				detayEditor.setText("");
				listeBittiMi = true;
				veritabani.ogrenciSil(ogrenciler.get(index).getId());
				listModel.remove(index);
				ogrenciler.remove(index);
			}else if(listModel.size() > 1) {
				list.setSelectedIndex(index - 1);
				listModel.remove(index);
				veritabani.ogrenciSil(ogrenciler.get(index).getId());
				ogrenciler.remove(index);
			}
			
			if (listModel.size() == 0) {
				silBtn.setEnabled(false);
				JOptionPane.showMessageDialog(ogrenciListeleFrame, "G�r�nt�lenecek kitap kalmad�..");
				ogrenciListeleFrame.dispose();
			}
		}

		/**
		 * Listede de�i�iklikleri kontrol eder.
		 */
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (listeBittiMi == false) {
				detayEkraniGuncelle(list.getSelectedIndex());
			}
		}
		
		/**
		 * Detay ekran�n�n� g�nceller. 
		 * @param index Listedeki se�ili index
		 */
		public void detayEkraniGuncelle(int index) {
			Ogrenci ogr = ogrenciler.get(index);
			String detayText = "Ad� Soyad�\t: " + ogr.getOgrenciAdiSoyadi() + "\n" + "Bolumu\t: " + ogr.getBolumu()
								+ "\n" + "Giris Yili\t: " + ogr.getGirisYili() + "\n" + "Kay�t Id\t: " + ogr.getId();

			detayEditor.setText(detayText);
		}
	}

	
	/**
	 * Ogrenci Ekleme ekran�n�n olu�turur, aksiyonlar�n� tan�mlar.
	 * @author ismail
	 * 
	 */
	static class OgrenciEkleEkrani {
		JFrame ogrenciEkleFrame = new JFrame("Yeni Kitap Ekle");

		JLabel adiLbl = new JLabel("Ad� Soyad�    :");
		JLabel bolumuLbl = new JLabel("B�l�m�         :");
		JLabel girisLbl = new JLabel("Giri� Y�l�         :");
		
		JTextField adiTxt = new JTextField();
		JTextField bolumuTxt = new JTextField();
		JTextField girisTxt = new JTextField();

		JButton ekleBtn = new JButton("Ekle");

		/**
		 * ��renci ekle ekran�n�n constructor�. Yeni ekran olu�turulunca �a��r�l�r.
		 */
		public OgrenciEkleEkrani() {
			ogrenciEkleEkraniHazirla();

			ekleBtn.addActionListener(e -> {
				boolean kontrol = kontrolEt();
				
				if (kontrol) {
					try {
						ogrenciEklemeIslemi();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
		}

		/**
		 * Bilgilerin yanl�� yada eksik girilip girilmedi�ini kontrol eder.
		 * @return Hepsi dogru ise true de�ilse false doner. 
		 */
		private boolean kontrolEt() {
			boolean kontrol = true;
			String mesaj = "";
			if(adiTxt.getText().equals("")) {
				mesaj+="Ad� alan� bo� ge�ilemez.\n";
				kontrol = false;
			}
			if(bolumuTxt.getText().equals("")) {
				mesaj+="Bolumu alan� bo� ge�ilemez.\n";
				kontrol=false;
			}
			if(girisTxt.getText().equals("")) {
				mesaj+="Giri� y�l� bo� ge�ilemez.\n";
				kontrol = false;
			}
			if(isNumeric(girisTxt.getText()) == false) {
				mesaj+="Bir say� girmelisiniz.";
				kontrol = false;
			}
			if (mesaj.equals("") == false && kontrol == false) {
				JOptionPane.showMessageDialog(ogrenciEkleFrame, mesaj);
			}
			return kontrol;
		}

		/**
		 * ��renci ekle ekran�n� haz�rlar.
		 */
		public void ogrenciEkleEkraniHazirla() {
			ogrenciEkleFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			ogrenciEkleFrame.setSize(305, 200);
			ogrenciEkleFrame.setLayout(null);
			ogrenciEkleFrame.setLocation(700, 700);
			ogrenciEkleFrame.setLocationRelativeTo(null);
			ogrenciEkleFrame.setVisible(true);

			adiLbl.setBounds(15, 15, 150, 15);
			adiTxt.setBounds(125, 15, 150, 15);

			bolumuLbl.setBounds(15, 50, 150, 15);
			bolumuTxt.setBounds(125, 50, 150, 15);

			girisLbl.setBounds(15, 85, 150, 15);
			girisTxt.setBounds(125, 85, 150, 15);

			ekleBtn.setBounds(175, 115, 100, 25);
			ekleBtn.setBackground(Color.WHITE);

			ogrenciEkleFrame.add(adiLbl);
			ogrenciEkleFrame.add(adiTxt);
			ogrenciEkleFrame.add(bolumuLbl);
			ogrenciEkleFrame.add(bolumuTxt);
			ogrenciEkleFrame.add(girisLbl);
			ogrenciEkleFrame.add(girisTxt);
			ogrenciEkleFrame.add(ekleBtn);
		}
		
		/**
		 * Alanlardaki bilgileri al�r, veritabanina ekler. Pencereyi kapat�r.
		 * @throws Exception
		 */
		private void ogrenciEklemeIslemi() throws Exception {
			String adi = adiTxt.getText();
			String bolumu = bolumuTxt.getText();
			int girisYili = Integer.parseInt(girisTxt.getText());
			
			veritabani.ogrenciEkle(adi, bolumu, girisYili);
			JOptionPane.showMessageDialog(ogrenciEkleFrame, "Ogrenci Ba�ar�yla Eklendi");
			ogrenciEkranTemizle();
			ogrenciEkleFrame.dispose();
		}
		
		/**
		 * Ekrandaki bilgileri siler..
		 */
		private void ogrenciEkranTemizle() {
			adiTxt.setText("");
			bolumuTxt.setText("");
			girisTxt.setText("");
		}

		/**
		 * Girilen de�erin say�m� oldu�unu kontrol eder..
		 * @param str Kontrolu yap�lcak metin.
		 * @return say� ise true, de�ilse false d�ner.
		 */
		private boolean isNumeric(String str) {
			return str.matches("-?\\d+(\\.\\d+)?");
		}
	}
}
