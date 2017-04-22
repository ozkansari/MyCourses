package tr.edu.medipol.odev2.g3.havvagamzeakbas;


import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.LayoutStyle.ComponentPlacement;



import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class gamzeFinal extends JFrame implements ActionListener {

	private JTextField adSoyad;
	private JTextField ogrenciBolum;
	private JList menu = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	 private JTextField ogrenciTip;
	
	
	static ArrayList<String> arList = new ArrayList<>();
	
	public gamzeFinal(){
		
		
		
		getContentPane().setBackground(new Color(50, 205, 50));
		setResizable(false);
		setBackground(new Color(96, 96, 96));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));


		adSoyad = new JTextField();
		adSoyad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		adSoyad.setColumns(10);

		
		ogrenciBolum = new JTextField();
		ogrenciBolum.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ogrenciBolum.setColumns(10);
		
		ogrenciTip = new JTextField();
		ogrenciTip.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		ogrenciTip.setColumns(10);
		
		JLabel LabelAd = new JLabel("\u00D6\u011Frencinin Ad\u0131");
		LabelAd.setForeground(new Color(255, 221, 21));
		LabelAd.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel LabelBolum = new JLabel("B\u00F6l\u00FCm");
		LabelBolum.setForeground(Color.ORANGE);
		LabelBolum.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel LabelTip = new JLabel("Ogrenci Tipi ");
		LabelTip.setForeground(Color.ORANGE);
		LabelTip.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton ogrenciEkle = new JButton("Ogrenci Ekle");
		ogrenciEkle.setBackground(Color.CYAN);
		ogrenciEkle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton ogrencileriListele = new JButton("Ogrenci Listele");
		ogrencileriListele.setBackground(new Color(153, 204, 204));
		ogrencileriListele.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton ogrencileriSil = new JButton("Ogrenci Sil");
		ogrencileriSil.setBackground(new Color(153, 204, 204));
		ogrencileriSil.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblOgrenciListesi = new JLabel("Ogrenci Listesi");
		lblOgrenciListesi.setBackground(Color.CYAN);
		lblOgrenciListesi.setForeground(Color.RED);
		lblOgrenciListesi.setFont(new Font("Stencil Std", Font.BOLD | Font.ITALIC, 17));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(LabelAd)
								.addComponent(LabelBolum)
								.addComponent(LabelTip))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(ogrenciTip, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
								.addComponent(ogrenciBolum, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(adSoyad, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(ogrenciEkle)
							.addGap(21))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ogrencileriListele, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(ogrencileriSil, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
							.addGap(53))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(menu, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
							.addGap(8))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(130)
					.addComponent(lblOgrenciListesi)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(LabelAd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(adSoyad, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(LabelBolum)
								.addComponent(ogrenciBolum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(ogrenciEkle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(LabelTip, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(ogrenciTip, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addComponent(lblOgrenciListesi)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(menu, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ogrencileriListele)
						.addComponent(ogrencileriSil))
					.addGap(118))
		);
			
		ogrenciEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!adSoyad.getText().equals("")) {
					   if(!ogrenciBolum.getText().equals("")) {
						if(!ogrenciTip.getText().equals("")) {
	
					if (e.getSource() == ogrenciEkle){
						arList.add("Ogrenci : "+adSoyad.getText()+" "+"Bolumu : "+ ogrenciBolum.getText()+" "+"Tipi : "+ogrenciTip.getText()+"\n");
						listeyeYAZ(); 
			
					}
					ogrenciTip.setText("");
					adSoyad.setText("");
					ogrenciBolum.setText("");
					
				    }else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girmeyiniz.");}	
					}else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girmeyiniz");}
					}else{JOptionPane.showMessageDialog(null, "Eksik Bilgi Girmeyiniz");}
	
			}
		});
		
		
		ogrencileriListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(arList.isEmpty()){
					{JOptionPane.showMessageDialog(null, "Liste Bos");}
				}
				   try {
					   if(e.getSource()==ogrencileriListele) {
					        DefaultListModel listModel = (DefaultListModel) menu.getModel();
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
				    System.out.print("Hata");
		
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
			
		   menu.setModel(DLM);
								
			}
		});
		

		ogrencileriSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=menu.getSelectedIndex();
				DLM.removeAllElements();
				arList.remove(index);			
			    listeyeYAZ();
			try {
				   if(e.getSource()==ogrencileriListele) {
				        DefaultListModel listModel = (DefaultListModel) menu.getModel();
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
			System.out.println("HATA !");
	
	   
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
		
	   menu.setModel(DLM);

		
		}
	});
		

		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
				
				String Selected2=menu.getSelectedValue().toString();
				String Sample = Selected2;
				
			
				try{
                Selected2 = Sample;}
				catch (Exception exes) {System.out.println("Komut D�zeltme Hatas�!");}	
				
				
				   }catch (Exception exes) {System.out.println("Hata Liste Bo�!");}	
				
			}	
		});
		getContentPane().setLayout(groupLayout);
			}
	

	public static void listeyeYAZ(){
		try {
			FileWriter fos = new FileWriter("ogrenci.txt");
			PrintWriter out = new PrintWriter(fos);
			for (int i = 0; i < arList.size();i++){
				
				out.write(String.valueOf(arList.get(i)));
				
				out.write(" ");
			}
			out.close();
		}
		catch(Exception e){
			
		}
		
	} public static void main(String[] args) {
		gamzeFinal ekrann = new gamzeFinal();
		ekrann.setTitle("Ogrenci Takip");
		ekrann.setSize(450, 500);
		ekrann.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekrann.setResizable(false);
		ekrann.setVisible(true);
	}
}
