package tr.edu.medipol.odev2.g3.huseyinsirtikara;


import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;

/** ozkans Degerlendirme

Ertan Karaaslan & Hasan Somuncu & Sefa Okuyucu & Halil Onan & Muzaffer Anlas & Bayram Ozkan Ozmutlu ile benzer.

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
public class huseyinsirtikaraaa extends JFrame implements ActionListener {

	private JTextField adi;
	private JTextField bolumu;
	private JList Ekran = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	 private JTextField tipi;
	
	
	static ArrayList<String> arrList = new ArrayList<>();
	
	public huseyinsirtikaraaa(){
		
		
		
		getContentPane().setBackground(Color.ORANGE);
		setResizable(false);
		setBackground(new Color(51, 204, 102));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));


		adi = new JTextField();
		adi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		adi.setColumns(10);

		
		bolumu = new JTextField();
		bolumu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		bolumu.setColumns(10);
		
		tipi = new JTextField();
		tipi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		tipi.setColumns(10);
		
		JLabel LabelAd = new JLabel("\u00D6\u011Frencinin Ad\u0131 : ");
		LabelAd.setForeground(Color.BLACK);
		LabelAd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelBolum = new JLabel("\u00D6\u011Frencinin B\u00F6l\u00FCm\u00FC :");
		LabelBolum.setForeground(Color.BLACK);
		LabelBolum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelTip = new JLabel("\u00D6\u011Frencinin Tipi : ");
		LabelTip.setForeground(Color.BLACK);
		LabelTip.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnEkle = new JButton("\u00D6grenci Ekle");
		btnEkle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnListe = new JButton("Ogrenci Listele");
		btnListe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnSil = new JButton("Ogrenci Sil");
		btnSil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnClose = new JButton("\u00C7\u0131k\u0131\u015F");
		btnClose.setForeground(Color.RED);
		btnClose.setBackground(Color.RED);
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
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(btnListe, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
							.addComponent(btnClose)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Ekran, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnSil, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(LabelAd, Alignment.LEADING)
										.addComponent(LabelBolum, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
										.addComponent(LabelTip, Alignment.LEADING))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(tipi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
											.addComponent(bolumu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
											.addComponent(adi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addComponent(btnEkle, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
											.addGap(35)))))
							.addGap(59))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(LabelAd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(adi, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(bolumu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tipi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelTip, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSil, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEkle))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Ekran, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListe, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClose))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		
		btnEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!adi.getText().equals("")) {
					   if(!bolumu.getText().equals("")) {
						   if(!tipi.getText().equals("")) {
	
					if (e.getSource() == btnEkle){
						arrList.add("Ogrenci : "+adi.getText()+" "+"Bolumu : "+ bolumu.getText()+" "+"Tipi : "+tipi.getText()+"\n");
						yaz(); 
						
						
					}
					
					tipi.setText("");
					adi.setText("");
					bolumu.setText("");
					
				
				    }else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz.");}	
					}else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz.");}
					}else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz.");}
				
				
			}
		});
		

		btnListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(arrList.isEmpty()){
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

			   in = new BufferedReader(new FileReader("defter.txt"));
			   
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

		   in = new BufferedReader(new FileReader("defter.txt"));
		   
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
				catch (Exception exes) {System.out.println("Komut Düzeltme Hatası!");}	
				
				
				   }catch (Exception exes) {System.out.println("Hata Liste Boş!");}	
				
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
	}
		public static void main (String[] args) {
			huseyinsirtikaraaa ekrann = new huseyinsirtikaraaa();
			ekrann.setTitle("Proje");
			ekrann.setSize(440, 540);
			ekrann.setDefaultCloseOperation(EXIT_ON_CLOSE);
			ekrann.setResizable(false);
			ekrann.setVisible(true);
		}	
		
	}
	
	

