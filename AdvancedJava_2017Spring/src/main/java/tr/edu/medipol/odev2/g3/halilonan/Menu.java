package tr.edu.medipol.odev2.g3.halilonan;


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
Bonus: 10/25 (Imaj kullanimi)
Benzer Kod Yazma Nedeniyle: -35 (Sil kismi bayram ozkan mutlu ile ayni)
--------------------------
SONUC: 40/125
 */
public class Menu extends JFrame implements ActionListener {

	private JTextField ogrenciAdi;
	private JTextField ogrenciBolumu;
	private JList Ekran = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	 private JTextField ogrenciTipi;
	
	public void addse(String name){
		
		DLM.addElement(name);
		Ekran.setModel(DLM);
	}
	static ArrayList<String> arrList = new ArrayList<>();
	
	
	
	public Menu(){
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("kratos.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(800, 508, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		JLabel label = new JLabel(imageIcon);
		label.setForeground(new Color(0, 0, 0));
		setContentPane(label);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setBackground(new Color(51, 204, 102));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));


		ogrenciAdi = new JTextField();
		ogrenciAdi.setBackground(new Color(255, 255, 255));
		ogrenciAdi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ogrenciAdi.setColumns(10);

		
		ogrenciBolumu = new JTextField();
		ogrenciBolumu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ogrenciBolumu.setColumns(10);
		
		ogrenciTipi = new JTextField();
		ogrenciTipi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ogrenciTipi.setColumns(10);
		
		JLabel LabelAd = new JLabel("\u00D6\u011Frencinin Ad\u0131 : ");
		LabelAd.setForeground(Color.WHITE);
		LabelAd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelBolum = new JLabel("\u00D6\u011Frencinin B\u00F6l\u00FCm\u00FC :");
		LabelBolum.setForeground(Color.WHITE);
		LabelBolum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelTip = new JLabel("\u00D6\u011Frencinin Tipi : ");
		LabelTip.setForeground(Color.WHITE);
		LabelTip.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
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
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnListe)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSil, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnClose)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(7)
									.addComponent(Ekran, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(LabelAd)
										.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
										.addComponent(LabelTip))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(ogrenciTipi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
										.addComponent(ogrenciBolumu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
										.addComponent(ogrenciAdi, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
										.addComponent(btnEkle, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))
							.addGap(59))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(LabelAd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(ogrenciAdi, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(ogrenciBolumu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ogrenciTipi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelTip, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnEkle)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Ekran, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListe)
						.addComponent(btnSil)
						.addComponent(btnClose))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		
		
		btnEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!ogrenciAdi.getText().equals("")) {
					   if(!ogrenciBolumu.getText().equals("")) {
						   if(!ogrenciTipi.getText().equals("")) {
	
					if (e.getSource() == btnEkle){
						arrList.add("Ogrenci : "+ogrenciAdi.getText()+" "+"Bolumu : "+ ogrenciBolumu.getText()+" "+"Tipi : "+ogrenciTipi.getText()+"\n");
						
						JOptionPane.showMessageDialog(null, " ��renci Eklendi.");
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
				DLM.removeElementAt(index);
				arrList.remove(index);			
			yaz();
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
			FileWriter fos = new FileWriter("Ogrenci.txt");
			PrintWriter out = new PrintWriter(fos);
			
			for (int i = 0; i < arrList.size();i++){
				out.write(String.valueOf(arrList.get(i)));
				out.write("    ");
				  
			}
			out.close();
		}
		catch(Exception e){
			
		}
		
	}
	
	public static void main(String[] args) {
		Menu ekrann = new Menu();
		ekrann.setTitle("Proje - HAL�L ONAN H5150051");
		ekrann.setSize(440, 540);
		ekrann.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekrann.setResizable(false);
		ekrann.setVisible(true);
	}	
	
}
