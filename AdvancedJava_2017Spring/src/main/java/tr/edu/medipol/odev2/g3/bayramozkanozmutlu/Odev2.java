package tr.edu.medipol.odev2.g3.bayramozkanozmutlu;



import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;


/** ozkans Degerlendirme

tr.edu.medipol.odev2.g3.* paketindekilerle benzer

+ Bos kayit kontrolu var.
- Secim yapmadan sile basinca hata veriyor.
- Ekle dedikten sonra listede gostermiyor. Ekstra liste tiklamak gerekiyor.
- ilk kayittan sonrakilerin basinda bosluk gosteriliyor.
- Program yeniden acildiginda List demeden onceki kayitlari gostermiyor.

Ekran: 20/20
Ogrenci Islemleri: 10/15
Polimorphism: 0/15
Dosyadan Okuma: 15/20
Dosyaya Yazma:  15/20
Genel Program: 5/10
Bonus: 0/25
Benzer Kod Yazma Nedeniyle: -20 (Sil kismi farkli +10)
--------------------------
SONUC: 45/125
 */
public class Odev2 extends JFrame implements ActionListener {

	private JTextField ogrenciAdi;
	private JTextField ogrenciBolumu;
	private JList Ekran = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	 private JTextField ogrenciTipi;
	
	
	static ArrayList<String> arrayList = new ArrayList<>();
	
	public Odev2(){
		
		
		
		getContentPane().setBackground(Color.CYAN);
		setResizable(false);
		setBackground(new Color(51, 204, 102));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));


		ogrenciAdi = new JTextField();
		ogrenciAdi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ogrenciAdi.setColumns(10);

		
		ogrenciBolumu = new JTextField();
		ogrenciBolumu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ogrenciBolumu.setColumns(10);
		
		ogrenciTipi = new JTextField();
		ogrenciTipi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ogrenciTipi.setColumns(10);
		
		JLabel LabelAd = new JLabel("Adı");
		LabelAd.setForeground(Color.BLACK);
		LabelAd.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel LabelBolum = new JLabel("Bölümü");
		LabelBolum.setForeground(Color.BLACK);
		LabelBolum.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel LabelTip = new JLabel("Tipi");
		LabelTip.setForeground(Color.BLACK);
		LabelTip.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnEkle = new JButton("EKLE");
		btnEkle.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnListe = new JButton("LİSTELE");
		btnListe.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnSil = new JButton("SİL");
		btnSil.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnClose = new JButton("ÇIKIŞ");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblrenciOtomasyonSistemi = new JLabel("Öğrenci Otomasyon Sistemi");
		lblrenciOtomasyonSistemi.setForeground(Color.BLACK);
		lblrenciOtomasyonSistemi.setFont(new Font("Arial", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Ekran, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnEkle, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(ogrenciAdi, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
												.addGap(34)
												.addComponent(ogrenciBolumu, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(2)
											.addComponent(LabelAd, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
											.addGap(142)
											.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(LabelTip)
											.addGap(87))
										.addComponent(ogrenciTipi, 0, 0, Short.MAX_VALUE))))
							.addContainerGap(14, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(btnListe, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnSil)
							.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
							.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(46))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(145, Short.MAX_VALUE)
					.addComponent(lblrenciOtomasyonSistemi, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(137))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(lblrenciOtomasyonSistemi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 1, GroupLayout.PREFERRED_SIZE)
							.addComponent(LabelAd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(LabelTip, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(4)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ogrenciAdi, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(ogrenciBolumu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(ogrenciTipi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnEkle)
					.addGap(18)
					.addComponent(Ekran, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListe)
						.addComponent(btnSil)
						.addComponent(btnClose))
					.addGap(54))
		);
		
		
		btnEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!ogrenciAdi.getText().equals("")) {
					   if(!ogrenciBolumu.getText().equals("")) {
						   if(!ogrenciTipi.getText().equals("")) {
	
					if (e.getSource() == btnEkle){
						arrayList.add("Ogrenci : "+ogrenciAdi.getText()+" "+"Bolumu : "+ ogrenciBolumu.getText()+" "+"Tipi : "+ogrenciTipi.getText()+"\n");

						yaz(); 
						
						
					}
					
					ogrenciTipi.setText("");
					ogrenciAdi.setText("");
					ogrenciBolumu.setText("");
					
				
				    }else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz.");}	
					}else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz.");}
					}else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz.");}
				
				
			}
		});
		

		btnListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(arrayList.isEmpty()){
					{JOptionPane.showMessageDialog(null, "Liste Boş Öğrenci Bulunmamaktadır!");}
				}
				   try {
					   if(e.getSource()==btnListe) {
					        DefaultListModel listModel = (DefaultListModel) Ekran.getModel();
					        listModel.removeAllElements();
				   } } catch (Exception exes) { }	 
				
		   BufferedReader in = null;
		   String line;

		   
		   try {

			   in = new BufferedReader(new FileReader("Ogrenci.txt"));
			   
			   while ((line = in.readLine()) != null) {
				   String Str = new String(line);
		
				   DLM.addElement(line); 

			   }

		   } catch (IOException exed) {
				System.out.println("HATA OLUSTU!");
		
		   } finally {
				       
			   if (in != null) {
				   
				   try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			   }
				    }
			
		   Ekran.setModel(DLM);
				
				
				
				
				
			}
		});
		
	

		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=Ekran.getSelectedIndex();
				DLM.removeAllElements();
				arrayList.remove(index);			
			yaz();
			try {
				   if(e.getSource()==btnListe) {
				        DefaultListModel listModel = (DefaultListModel) Ekran.getModel();
				        listModel.removeAllElements();
			   } } catch (Exception exes) { }	 
			
	   BufferedReader in = null;
	   String line;

	   
	   try {

		   in = new BufferedReader(new FileReader("ogrenci.txt"));
		   
		   while ((line = in.readLine()) != null) {
			   String Str = new String(line);
	
			   DLM.addElement(line); 

		   }

	   } catch (IOException exed) {
			System.out.println("ERROR VERDİ ;)");
	
	   } finally {
			       
		   if (in != null) {
			   
			   try {
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		   }
			    }
		
	   Ekran.setModel(DLM);
			
			
			
			
			
		}
	});
		

		Ekran.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
				
				String Selected2=Ekran.getSelectedValue().toString();
				String Sample = Selected2;
				
			
				try{
                Selected2 = Sample;}
				catch (Exception exes) {System.out.println("Komut Düzeltme Hatası!");}	
				
				
				   }catch (Exception exes) {System.out.println("Hata Liste Boş!");}	
				
			}	
		});
		getContentPane().setLayout(groupLayout);
		
	}
	
  
	
	public static void yaz(){
		try {
			FileWriter fos = new FileWriter("ogrenci.txt");
			PrintWriter out = new PrintWriter(fos);
			
			for (int i = 0; i < arrayList.size();i++){
				out.write(String.valueOf(arrayList.get(i)));
				out.write("  ");

			}
			out.close();
		}
		catch(Exception e){
			
		}
		
	}
	
	public static void main(String[] args) {
		Odev2 ekrann = new Odev2();
		ekrann.setTitle("Proje");
		ekrann.setSize(440, 540);
		ekrann.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekrann.setResizable(false);
		ekrann.setVisible(true);
	}	
	
}
