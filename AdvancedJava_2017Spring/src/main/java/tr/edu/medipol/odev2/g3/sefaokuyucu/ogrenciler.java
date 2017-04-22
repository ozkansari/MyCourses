package tr.edu.medipol.odev2.g3.sefaokuyucu;


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

Ertan Karaaslan & Huseyin Sirtikara & Halil Onan & Muzaffer Anlas & Bayram Ozkan Ozmutlu ile benzer.

Ekran: 20/20 (Ekran tasarimi basarili)
Ogrenci Islemleri: 10/15
Polimorphism: 0/15
Dosyadan Okuma: 10/20 (Dosyadan okunananlar tek tek degil, topluca tek bir element gibi listede gosteriliyor)
Dosyaya Yazma:  20/20
Genel Program: 5/10 (Surukle-birak plugin kullanildigindan kod biraz duzensiz)
Bonus:15/25
--------------------------
SONUC: 80/100
 */
public class ogrenciler extends JFrame implements ActionListener {

	private JTextField ogrAdi;
	private JTextField ogrBolumu;
	private JList Ekran = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	 private JTextField ogrTipi;
	
	
	static ArrayList<String> arrList = new ArrayList<>();
	
	public ogrenciler(){
		
		
		
		getContentPane().setBackground(new Color(51, 153, 153));
		setResizable(false);
		setBackground(new Color(51, 204, 102));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));


		ogrAdi = new JTextField();
		ogrAdi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ogrAdi.setColumns(10);

		
		ogrBolumu = new JTextField();
		ogrBolumu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ogrBolumu.setColumns(10);
		
		ogrTipi = new JTextField();
		ogrTipi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ogrTipi.setColumns(10);
		
		JLabel LabelAd = new JLabel("\u00D6\u011Frencinin Ad\u0131 : ");
		LabelAd.setForeground(new Color(255, 255, 255));
		LabelAd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelBolum = new JLabel("\u00D6\u011Frencinin B\u00F6l\u00FCm\u00FC :");
		LabelBolum.setForeground(new Color(255, 255, 255));
		LabelBolum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelTip = new JLabel("\u00D6\u011Frencinin Tipi : ");
		LabelTip.setForeground(new Color(255, 255, 255));
		LabelTip.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnEkle = new JButton("\u00D6grenci Ekle");
		btnEkle.setBackground(new Color(153, 204, 204));
		btnEkle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnListe = new JButton("Ogrenci Listele");
		btnListe.setBackground(new Color(153, 204, 204));
		btnListe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnSil = new JButton("Ogrenci Sil");
		btnSil.setBackground(new Color(153, 204, 204));
		btnSil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnClose = new JButton("\u00C7\u0131k\u0131\u015F");
		btnClose.setBackground(new Color(153, 204, 204));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(LabelAd)
											.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
											.addComponent(LabelTip))
										.addGap(20)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(ogrTipi, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
											.addComponent(ogrBolumu, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
											.addComponent(ogrAdi, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addGap(10)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addComponent(btnEkle, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
												.addComponent(btnListe))
											.addComponent(Ekran, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))))
								.addGap(33))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(btnSil, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addGap(135)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnClose)
							.addGap(176))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(LabelAd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(ogrAdi, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(ogrBolumu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ogrTipi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelTip, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListe)
						.addComponent(btnEkle))
					.addGap(11)
					.addComponent(Ekran, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(btnSil)
					.addGap(31)
					.addComponent(btnClose))
		);
		
		
		btnEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!ogrAdi.getText().equals("")) {
					   if(!ogrBolumu.getText().equals("")) {
						   if(!ogrTipi.getText().equals("")) {
	
					if (e.getSource() == btnEkle){
						arrList.add("Ogrenci : "+ogrAdi.getText()+" "+"Bolumu : "+ ogrBolumu.getText()+" "+"Tipi : "+ogrTipi.getText()+"\n");
				
						yaz(); 
						
						
					}
					
					ogrTipi.setText("");
					ogrAdi.setText("");
					ogrBolumu.setText("");
					
				
				    }else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz.");}	
					}else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz.");}
					}else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz.");}
				
				
			}
		});
		

		btnListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(arrList.isEmpty()){
					{JOptionPane.showMessageDialog(null, "Liste Bo� ��renci Bulunmamaktad�r!");}
				}
				   try {
					   if(e.getSource()==btnListe) {
					        DefaultListModel listModel = (DefaultListModel) Ekran.getModel();
					        listModel.removeAllElements();
				   } } catch (Exception exes) { }	 
				
		   BufferedReader in = null;
		   String line;

		   
		   try {

			   in = new BufferedReader(new FileReader("ogr.txt"));
			   
			   while ((line = in.readLine()) != null) {
				   String Str = new String(line);
		
				   DLM.addElement(line); 

			   }

		   } catch (IOException exed) {
				System.out.println("B�R HATA MEYDANA GELD�!!!!");
		
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
				arrList.remove(index);			
			yaz();
			try {
				   if(e.getSource()==btnListe) {
				        DefaultListModel listModel = (DefaultListModel) Ekran.getModel();
				        listModel.removeAllElements();
			   } } catch (Exception exes) { }	 
			
	   BufferedReader in = null;
	   String line;

	   
	   try {

		   in = new BufferedReader(new FileReader("ogr.txt"));
		   
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
		

		Ekran.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
				
				String Selected2=Ekran.getSelectedValue().toString();
				String Sample = Selected2;
				
			
				try{
                Selected2 = Sample;}
				catch (Exception exes) {System.out.println("Komut D�zeltme Hatas�!");}	
				
				
				   }catch (Exception exes) {System.out.println("Hata Liste Bo�!");}	
				
			}	
		});
		getContentPane().setLayout(groupLayout);
		
	}
	
  
	
	public static void yaz(){
		try {
			FileWriter fos = new FileWriter("defter.txt");
			PrintWriter out = new PrintWriter(fos);
			
			for (int i = 0; i < arrList.size();i++){
				out.write(String.valueOf(arrList.get(i)));
				out.write("   ");
			}
			out.close();
		}
		catch(Exception e){
			
		}
		
	} public static void main(String[] args) {
		ogrenciler ekrann = new ogrenciler();
		ekrann.setTitle("Proje");
		ekrann.setSize(440, 540);
		ekrann.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekrann.setResizable(false);
		ekrann.setVisible(true);
	}
	
}
