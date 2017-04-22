package tr.edu.medipol.odev2.g3.ertankaraaslan;


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

Halil Onan & Hasan Somuncu & Sefa Okuyucu & Muzaffer Anlas & Huseyin Sirtikara & Bayram Ozkan Ozmutlu ile benzer.

Ekran: 20/20
Ogrenci Islemleri: 15/15
Polimorphism: 15/15
Dosyadan Okuma: 20/20
Dosyaya Yazma:  20/20
Genel Program: 10/10
Bonus:25/25
--------------------------
SONUC: 125/125
 */
public class odev extends JFrame implements ActionListener {

	private JTextField Girilenisim;
	private JTextField GirilenBolum;
	private JList cikti = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	 private JTextField GirilenTip;
	 
	 public static void main(String[] args) {
			odev cikti = new odev();
			cikti.setTitle("Proje");
			cikti.setSize(440, 540);
			cikti.setDefaultCloseOperation(EXIT_ON_CLOSE);
			cikti.setResizable(false);
			cikti.setVisible(true);
		}
	
	static ArrayList<String> arrList = new ArrayList<>();
		
	public odev(){
		
		
		
		getContentPane().setBackground(Color.CYAN);
		setResizable(false);
		setBackground(new Color(51, 204, 102));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));


		Girilenisim = new JTextField();
		Girilenisim.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		Girilenisim.setColumns(10);

		
		GirilenBolum = new JTextField();
		GirilenBolum.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		GirilenBolum.setColumns(10);
		
		GirilenTip = new JTextField();
		GirilenTip.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		GirilenTip.setColumns(10);
		
		JLabel LabelAd = new JLabel("\u00D6\u011Frencinin Ad\u0131 : ");
		LabelAd.setForeground(Color.BLACK);
		LabelAd.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelGirilenBolum = new JLabel("\u00D6\u011Frencinin B\u00F6l\u00FCm\u00FC :");
		LabelGirilenBolum.setForeground(Color.BLACK);
		LabelGirilenBolum.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		
		JLabel LabelGirilenTip = new JLabel("\u00D6\u011Frencinin GirilenTipi : ");
		LabelGirilenTip.setForeground(Color.BLACK);
		LabelGirilenTip.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 15));
		
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnListe, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(btnSil)
					.addGap(37)
					.addComponent(btnClose)
					.addGap(35))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(116, Short.MAX_VALUE)
					.addComponent(btnEkle, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(112))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(cikti, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(126)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(GirilenTip, Alignment.LEADING)
						.addComponent(LabelGirilenTip, Alignment.LEADING)
						.addComponent(LabelGirilenBolum, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelAd, Alignment.LEADING)
						.addComponent(Girilenisim, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
						.addComponent(GirilenBolum, Alignment.LEADING))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(LabelAd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Girilenisim, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(LabelGirilenBolum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(GirilenBolum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(LabelGirilenTip)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(GirilenTip, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(btnEkle)
					.addGap(18)
					.addComponent(cikti, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListe)
						.addComponent(btnClose)
						.addComponent(btnSil))
					.addContainerGap())
		);
		btnListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(arrList.isEmpty()){
					{JOptionPane.showMessageDialog(null, "Liste Bo� ��renci Bulunmamaktad�r!");}
				}
				   try {
					   if(e.getSource()==btnListe) {
					        DefaultListModel listModel = (DefaultListModel) cikti.getModel();
					        listModel.removeAllElements();
				   } } catch (Exception exes) { }	 
				
		   BufferedReader in = null;
		   String line;

		   
		   try {

			   in = new BufferedReader(new FileReader("notDefteri.txt"));
			   
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
			
		   cikti.setModel(DLM);
				
				
				
				
				
			}
		});
		
		btnEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!Girilenisim.getText().equals("")) {
					   if(!GirilenBolum.getText().equals("")) {
						   if(!GirilenTip.getText().equals("")) {
	
					if (e.getSource() == btnEkle){
						arrList.add("  Ogrenci Ad� : "+Girilenisim.getText()+" "+"Girilen Bolumu : "+ GirilenBolum.getText()+" "+"Girilen Tipi : "+GirilenTip.getText()+"\n");
						ekleme(); 
						
						
					}
					
					GirilenTip.setText("");
					Girilenisim.setText("");
					GirilenBolum.setText("");
					
				
				    }else{JOptionPane.showMessageDialog(null, "Bilgiler Eksik");
				    }	
					}else{JOptionPane.showMessageDialog(null, "Bilgiler Eksik");
					}
					}else{JOptionPane.showMessageDialog(null, "Bilgiler Eksik");
					}
				
				
			}
		});
		

		
		
	

		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=cikti.getSelectedIndex();
				DLM.removeElementAt(index);
				arrList.remove(index);			
			
		}
	});
		

		cikti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
				
				String Selected2=cikti.getSelectedValue().toString();
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
			FileWriter fos = new FileWriter("notDefteri.txt");
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
