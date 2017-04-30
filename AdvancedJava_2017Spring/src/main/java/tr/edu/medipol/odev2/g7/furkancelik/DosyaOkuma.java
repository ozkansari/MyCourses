package tr.edu.medipol.odev2.g7.furkancelik;

import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme

- tr.edu.medipol.odev2.g7.* dekilerle benzer
- Kod calismiyor.
- Kod formatlanmamis.
- Silme sadece listeden siliyor, dosyadan silinmiyor. Okuyunca uzerine yaziliyor.
- Ekranda bolum olarak ne girilecegi bahsedilmemis ama gecersiz deniyor.
- Tum hatalarda gecersiz bolum mesaji basiliyor.

Ekran: 20/20 
Ogrenci Islemleri: 5/15 (Listeleme sadece son kaydi gosteriyor, Silme sadece listeden siliyor, dosyadan silinmiyor. Okuyunca uzerine yaziliyor.)
Polimorphism: 15/15
Dosyadan Okuma: 20/20 
Dosyaya Yazma:  20/20 
Genel Program: 5/10 (Hata kontrolu duzgun degil)
Bonus: 5/25 (scrollpane) 
Benzer Kod Yazma Nedeniyle: -40 
Calismayan Kod: -20
--------------------------
SONUC: 30/125
 */
public class DosyaOkuma extends JFrame  {
private static Scanner ekranOkuyucu = new Scanner(System.in);
static File f=new File(".\\config\\ogrenciler.txt");
static FileWriter fw;
static BufferedReader reader;
static String satir;

static JLabel adl;
static JTextField adt;
static JLabel tipl;
static JTextField tipt;
static JLabel boluml;
static JTextField bolumt;

static JPanel panel;
static JFrame frame;
static JButton ekle;
static JList list;
static JButton listele;
static JButton sil;
static JButton cikis;
static DefaultListModel dm;




	

	public static void main(String[] args) throws IOException {
		
		frame = new JFrame("Java Proje");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 460);
	

		frame.setVisible(true);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		adl = new JLabel("Ad Soyad :");
		panel.add(adl);
		adl.setBounds(25, 20, 100, 30);
		adt = new JTextField();
		adt.setBounds(145,23, 210, 25);
		panel.add(adt);
		
		tipl = new JLabel("Ogrenci Tipi :");
		tipl.setBounds(25, 50, 100, 30);
		panel.add(tipl);
		tipt = new JTextField();
		tipt.setBounds(145,53, 210, 25);
		panel.add(tipt);
		
		boluml = new JLabel("Ogrenci Bolumu :");
		boluml.setBounds(25, 80, 100, 30);
		panel.add(boluml);
		bolumt = new JTextField();
		bolumt.setBounds(145,83, 210, 25);
		panel.add(bolumt);
	
		
		ekle = new JButton("Ogrenci Ekle");
		ekle.setBounds(145,113, 210, 25);
		
		listele = new JButton("Ogrencileri Listele");
		listele.setBounds(20, 300, 335, 25);
		panel.add(listele);
		
		sil = new JButton("Ogrenci Sil");
		sil.setBounds(20, 335, 335, 25);
		panel.add(sil);
		
		cikis = new JButton("��k��");
		cikis.setBounds(20, 370, 335, 25);
		panel.add(cikis);
		
		
		list = new JList() ;
		JScrollPane scrollPane = new JScrollPane(list,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setLocation(20,143);
		scrollPane.setSize(335,150);
		panel.add(scrollPane);
		
		frame.add(panel);
		panel.add(ekle);
		
		
		

		
		
		ekle.addActionListener(new ekleme());
		listele.addActionListener(new listele());
		sil.addActionListener(new sil());
		cikis.addActionListener(new cik());
		
		
	}
	static class cik implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
	static class sil implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int index = list.getSelectedIndex();
			dm.removeElementAt(index);

			
		}
	
	}
	static class listele implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				reader = new BufferedReader(new FileReader(f));
				satir =  reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
				if(satir==null){
						
				JOptionPane.showMessageDialog(null,"<< Sistemde kayitli ogrenci yok >>", "Hata", JOptionPane.INFORMATION_MESSAGE);
					 
				 }
				
				 while (satir!=null) {
					 			          
		                try {
		                	dm = new DefaultListModel();
		        		 	list.setModel(dm);
						 	dm.addElement(satir);
						 	
							satir = reader.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }

		}
	}
	
	static class ekleme implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String adSoyad = adt.getText();


			String ogrenciTipi = tipt.getText();

			String bolum = bolumt.getText();

			Ogrenci yeniOgrenci = null;
			if (ogrenciTipi.equals("YL")) {
				yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum);
			} else if (ogrenciTipi.equals("Doktora")) {
				yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum);
			} 

			try {
				fw=new FileWriter(f,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			if (yeniOgrenci != null) {
				try {
					fw.write(adSoyad+" "+bolum+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ogrenciListesi2.add(yeniOgrenci);
				JOptionPane.showMessageDialog(null,adSoyad+" isimli ogrenci eklendi.", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
			} else {

				JOptionPane.showMessageDialog(null,"Gecersiz ogrenci bolumu", "Hata", JOptionPane.INFORMATION_MESSAGE);

			}
			try {
				fw.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		adt.setText("");
		tipt.setText("");
		bolumt.setText("");
			
		}
		
		
	}

private static List<Ogrenci> ogrenciListesi2 = new ArrayList<>();

}
