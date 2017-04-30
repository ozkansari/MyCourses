package tr.edu.medipol.odev2.erdemdenizarici;


import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;


/** ozkans Degerlendirme

- Polimorfism yok.
- Dosya her yazdiginda onceki kayitlari siliyor (append yok)
- TR karakter sorunlari
- Bos kayit kontrolu yok.

Ekran: 20/20
Ogrenci Islemleri: 10/15 
Polimorphism: 0/15 (Yok)
Dosyadan Okuma: 20/20 
Dosyaya Yazma:  10/20
Genel Program: 5/10 ( TR karakter sorunlari )
Bonus:5/25 (DLM kullanimi) 
Diger Projelere Benzerlik: -10
--------------------------
SONUC: 60/125
 */
public class projem extends JFrame implements ActionListener {
	public static void main(String[] args) {
		projem ekrann = new projem();
		ekrann.setSize(440, 540);
		ekrann.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekrann.setResizable(false);
		ekrann.setVisible(true);
	}	

	private JTextField isim;
	private JTextField Bolumu;
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
	private JTextField uyari;
	
	
	
	public projem(){
		
		
		getContentPane().setBackground(new Color(128, 0, 0));
		setResizable(false);
		setBackground(new Color(51, 204, 102));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));


		isim = new JTextField();
		isim.setBounds(207, 21, 220, 26);
		isim.setForeground(Color.WHITE);
		isim.setBackground(new Color(0, 0, 0));
		isim.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		isim.setColumns(10);

		
		Bolumu = new JTextField();
		Bolumu.setBounds(207, 60, 220, 26);
		Bolumu.setForeground(Color.WHITE);
		Bolumu.setBackground(new Color(0, 0, 0));
		Bolumu.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		Bolumu.setColumns(10);
		
		ogrenciTipi = new JTextField();
		ogrenciTipi.setBounds(207, 99, 220, 27);
		ogrenciTipi.setForeground(Color.WHITE);
		ogrenciTipi.setBackground(new Color(0, 0, 0));
		ogrenciTipi.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		ogrenciTipi.setColumns(10);
		
		JLabel LabelAd = new JLabel("Ogrencinin Adi : ");
		LabelAd.setBounds(10, 21, 199, 25);
		LabelAd.setForeground(Color.WHITE);
		LabelAd.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelBolum = new JLabel("Ogrencinin Bolumu :");
		LabelBolum.setBounds(10, 60, 199, 25);
		LabelBolum.setForeground(Color.WHITE);
		LabelBolum.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelTip = new JLabel("Ogrencinin Tipi :");
		LabelTip.setBounds(10, 105, 199, 21);
		LabelTip.setForeground(Color.WHITE);
		LabelTip.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		
		JButton eklemeButonu = new JButton("Ogrenci Ekle");
		eklemeButonu.setBounds(118, 148, 199, 27);
		eklemeButonu.setForeground(Color.WHITE);
		eklemeButonu.setBackground(Color.BLACK);
		eklemeButonu.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		
		JButton ListelemeButonu = new JButton("Ogrenci Listele");
		ListelemeButonu.setBounds(118, 186, 199, 27);
		ListelemeButonu.setForeground(Color.WHITE);
		ListelemeButonu.setBackground(Color.BLACK);
		ListelemeButonu.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		
		JButton silmeButonu = new JButton("Ogrenci Sil");
		silmeButonu.setBounds(118, 224, 199, 27);
		silmeButonu.setForeground(Color.WHITE);
		silmeButonu.setBackground(Color.BLACK);
		silmeButonu.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		
		JButton close = new JButton("cikis");
		close.setBounds(153, 260, 129, 27);
		close.setForeground(Color.WHITE);
		close.setBackground(Color.BLACK);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				System.exit(0);
			}
		});
		close.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 15));
		Ekran.setBounds(10, 351, 417, 119);
		Ekran.setFont(new Font("GodOfWar", Font.BOLD | Font.ITALIC, 13));
		Ekran.setForeground(Color.WHITE);
		Ekran.setBackground(Color.BLACK);
		
		
		eklemeButonu.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
					if (e.getSource() == eklemeButonu){
						arrList.add("Ogrenci : "+isim.getText()+" "+"Bolumu : "+ Bolumu.getText()+" "+"Tipi : "+ogrenciTipi.getText());
						yaz(); 		
						uyari.setText(isim.getText() + " Adli iirenci Listeye Eklenmiitir");
					}		
					ogrenciTipi.setText(null);;
					isim.setText(null);
					Bolumu.setText(null);
			}
		});
		

		ListelemeButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sayac = 0;
				for(int i = 0; i<arrList.size(); i++){
					sayac++;
				}
				if(!arrList.isEmpty()){
					uyari.setText("       Listede     "+sayac+"   ogrenci Bulunmaktadir");			
				}
					
				
				   try {
					   if(e.getSource()==ListelemeButonu) {
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
		
	

		silmeButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=Ekran.getSelectedIndex();
				DLM.removeElementAt(index);
				arrList.remove(index);			
				uyari.setText("                                    iirenci Silinmiitir");
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
				catch (Exception exes) {
				}			
				   }catch (Exception exes) {
					   
				   }	
				
			}	
		});
		getContentPane().setLayout(null);
		getContentPane().add(ListelemeButonu);
		getContentPane().add(silmeButonu);
		getContentPane().add(close);
		getContentPane().add(Ekran);
		getContentPane().add(LabelAd);
		getContentPane().add(LabelBolum);
		getContentPane().add(LabelTip);
		getContentPane().add(ogrenciTipi);
		getContentPane().add(Bolumu);
		getContentPane().add(isim);
		getContentPane().add(eklemeButonu);
		
		uyari = new JTextField();
		uyari.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		uyari.setForeground(Color.WHITE);
		uyari.setBackground(Color.BLACK);
		uyari.setBounds(10, 313, 417, 27);
		getContentPane().add(uyari);
		uyari.setColumns(10);
		
	}
	
  
	
	public static void yaz(){
		try {
			FileWriter fos = new FileWriter("Ogrenci.txt");
			PrintWriter out = new PrintWriter(fos);
			
			for (int i = 0; i < arrList.size();i++){
				out.write(String.valueOf(arrList.get(i)));		
				out.write("\n");			  
			}
			out.close();
		}
		catch(Exception e){
			
		}	
	}
	
}

	
