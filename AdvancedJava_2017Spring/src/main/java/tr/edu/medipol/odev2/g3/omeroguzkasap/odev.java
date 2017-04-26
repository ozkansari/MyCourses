package tr.edu.medipol.odev2.g3.omeroguzkasap;


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
Ozellikle Ertan Karaaslan ile

+ Bos kayit kontrolu var.
- Silince dosyaya kaydetmiyor.
- Secim yapmadan sile basinca hata veriyor.
- Ekle dedikten sonra listede gostermiyor. Ekstra liste tiklamak gerekiyor.
- ilk kayittan sonrakilerin basinda bosluk gosteriliyor.
- Program yeniden acildiginda List demeden onceki kayitlari gostermiyor.

Ekran: 20/20
Ogrenci Islemleri: 5/15
Polimorphism: 0/15
Dosyadan Okuma: 15/20
Dosyaya Yazma:  15/20
Genel Program: 5/10
Bonus: 0/25
Benzer Kod Yazma Nedeniyle: -35
--------------------------
SONUC: 25/125
 */
public class odev extends JFrame implements ActionListener {

	private JTextField ad;
	private JTextField bolum;
	private JList Ekran = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	 private JTextField tip;
	 
	 public static void main(String[] args) {
			odev ekran = new odev();
			ekran.setTitle("Proje");
			ekran.setSize(440, 540);
			ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
			ekran.setResizable(false);
			ekran.setVisible(true);
		}
	
	static ArrayList<String> arrList = new ArrayList<>();
		
	public odev(){
		
		
		
		getContentPane().setBackground(Color.CYAN);
		setResizable(false);
		setBackground(new Color(51, 204, 102));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));


		ad = new JTextField();
		ad.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		ad.setColumns(10);

		
		bolum = new JTextField();
		bolum.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		bolum.setColumns(10);
		
		tip = new JTextField();
		tip.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		tip.setColumns(10);
		
		JLabel LabelAd = new JLabel("\u00D6\u011Frencinin Ad\u0131 : ");
		LabelAd.setForeground(Color.BLACK);
		LabelAd.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelBolum = new JLabel("\u00D6\u011Frencinin B\u00F6l\u00FCm\u00FC :");
		LabelBolum.setForeground(Color.BLACK);
		LabelBolum.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelTip = new JLabel("\u00D6\u011Frencinin Tipi : ");
		LabelTip.setForeground(Color.BLACK);
		LabelTip.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnEkle = new JButton("\u00D6grenci Ekle");
		btnEkle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnListe = new JButton("Ogrenci Listele");
		btnListe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnSil = new JButton("Ogrenci Sil");
		btnSil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnClose = new JButton("\u00C7\u0131k\u0131\u015F");
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
						.addComponent(LabelAd)
						.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelTip))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(tip, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
						.addComponent(bolum, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
						.addComponent(ad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
					.addGap(59))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEkle, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnListe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(61))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(Ekran, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(btnSil)
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(LabelAd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(ad, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(bolum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tip, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelTip, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEkle)
						.addComponent(btnListe))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSil)
						.addComponent(btnClose))
					.addGap(47)
					.addComponent(Ekran, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(116))
		);
		
		
		btnEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!ad.getText().equals("")) {
					   if(!bolum.getText().equals("")) {
						   if(!tip.getText().equals("")) {
	
					if (e.getSource() == btnEkle){
						arrList.add("  Ogrenci : "+ad.getText()+" "+"Bolumu : "+ bolum.getText()+" "+"Tipi : "+tip.getText()+"\n");
						ekleme(); 
						
						
					}
					
					tip.setText("");
					ad.setText("");
					bolum.setText("");
					
				
				    }else{JOptionPane.showMessageDialog(null, "Bilgileri Kontrol edin");}	
					}else{JOptionPane.showMessageDialog(null, "Bilgileri Kontrol edin");}
					}else{JOptionPane.showMessageDialog(null, "Bilgileri Kontrol edin");}
				
				
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
				DLM.removeElementAt(index);
				arrList.remove(index);			
			
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
	
  
	
	public static void ekleme(){
		try {
			FileWriter fos = new FileWriter("Ogrenci.txt");
			PrintWriter out = new PrintWriter(fos);
			
			for (int i = 0; i < arrList.size();i++){
				out.write(String.valueOf(arrList.get(i)));
			
			}
			out.close();
		}
		catch(Exception e){
			
		}
		
	}
		
	
	
}
