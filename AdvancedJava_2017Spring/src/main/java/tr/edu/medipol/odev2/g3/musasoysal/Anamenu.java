package tr.edu.medipol.odev2.g3.musasoysal;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.awt.Image;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Anamenu extends JFrame implements ActionListener {

	private JTextField adSoyad;
	private JTextField bolum;
	private JList Listele = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	
	
	static ArrayList<String> arrayList = new ArrayList<>();
	private JTextField ogrenciTipi;
	
	public Anamenu(){
		
		
		
		getContentPane().setBackground(Color.BLACK);
		setResizable(false);
		setBackground(new Color(96, 96, 96));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));


		adSoyad = new JTextField();
		adSoyad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adSoyad.setColumns(10);

		
		bolum = new JTextField();
		bolum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bolum.setColumns(10);
		
		JLabel LabelAd = new JLabel("\u00D6\u011Frenci Ad\u0131");
		LabelAd.setForeground(Color.WHITE);
		LabelAd.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel LabelBolum = new JLabel("\u00D6\u011Frenci B\u00F6l\u00FCm\u00FC");
		LabelBolum.setForeground(new Color(255, 255, 255));
		LabelBolum.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel LabelTip = new JLabel("\u00D6\u011Frenci Tipi");
		LabelTip.setForeground(new Color(255, 255, 255));
		LabelTip.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton ogrenciEkle = new JButton("\u00D6grenci Ekle");
		ogrenciEkle.setBackground(new Color(153, 204, 204));
		ogrenciEkle.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton ogrencileriListele = new JButton("Ogrenci Listele");
		ogrencileriListele.setBackground(new Color(153, 204, 204));
		ogrencileriListele.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton ogrencileriSil = new JButton("Ogrenci Sil");
		ogrencileriSil.setBackground(new Color(153, 204, 204));
		ogrencileriSil.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnClose = new JButton("\u00C7\u0131k\u0131\u015F");
		btnClose.setBackground(new Color(153, 204, 204));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		ogrenciTipi = new JTextField();
		ogrenciTipi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ogrenciTipi.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(LabelTip)
					.addContainerGap(307, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(120, Short.MAX_VALUE)
					.addComponent(ogrenciEkle, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(117))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(ogrencileriListele)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ogrencileriSil)
					.addGap(4)
					.addComponent(btnClose)
					.addContainerGap(46, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(Listele, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ogrenciTipi, Alignment.LEADING)
						.addComponent(LabelAd, Alignment.LEADING)
						.addComponent(LabelBolum, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addComponent(adSoyad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
						.addComponent(bolum, Alignment.LEADING))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		Listele.setFont(new Font("Tahoma", Font.PLAIN, 13));
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(LabelAd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(adSoyad, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LabelBolum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(bolum, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(LabelTip, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ogrenciTipi, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(ogrenciEkle)
					.addGap(21)
					.addComponent(Listele, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(ogrencileriListele)
							.addComponent(ogrencileriSil))
						.addComponent(btnClose))
					.addGap(84))
		);
		
		
		ogrenciEkle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!adSoyad.getText().equals("")) {
					   if(!bolum.getText().equals("")) {
						if(!ogrenciTipi.getText().equals("")) {
					if (e.getSource() == ogrenciEkle){
						arrayList.add(adSoyad.getText()+" "+"Bolumu : "+ bolum.getText()+" "+"Tipi : "+ogrenciTipi.getText()+"\n");
				listeyiYaz(); 
					}
	
					ogrenciTipi.setText("");
					adSoyad.setText("");
					bolum.setText("");
					
				    }else{JOptionPane.showMessageDialog(null, "Lutfen Tum Alanlari Doldurun");}	
					}else{JOptionPane.showMessageDialog(null, "Lutfen Tum Alanlari Doldurun");}
					}else{JOptionPane.showMessageDialog(null, "Lutfen Tum Alanlari Doldurun");}
	
			}
		}
		);
		
		ogrencileriListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(arrayList.isEmpty()){
					{JOptionPane.showMessageDialog(null, "Kay�tl� Ogrenci Yok");}
				}
				   try {
					   if(e.getSource()==ogrencileriListele) {
					        DefaultListModel listModel = (DefaultListModel) Listele.getModel();
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
			
		   Listele.setModel(DLM);
	
			}
		}
		);

		ogrencileriSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=Listele.getSelectedIndex();
				DLM.removeAllElements();
				arrayList.remove(index);			
			    listeyiYaz();
			try {
				   if(e.getSource()==ogrencileriListele) {
				        DefaultListModel listModel = (DefaultListModel) Listele.getModel();
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
		
	   Listele.setModel(DLM);

		}
	}
		);
		
		Listele.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
				
				String Selected2=Listele.getSelectedValue().toString();
				String Sample = Selected2;
					
				try{
                Selected2 = Sample;}
				catch (Exception exes) {System.out.println("Hata");}	

				   }catch (Exception exes) {System.out.println("Kay�tl� Ogrenci Yok");}	
			}	
		}
		);
		getContentPane().setLayout(groupLayout);
		
	}

	public static void listeyiYaz(){
		try {
			FileWriter fos = new FileWriter("Ogrenci.txt");
			PrintWriter out = new PrintWriter(fos);
			
			for (int i = 0; i < arrayList.size();i++){
				out.write(String.valueOf(arrayList.get(i)));
				out.write("   ");
			}
			out.close();
		}
		catch(Exception e){
			
		}
		
	} public static void main(String[] args) {
		Anamenu goruntu = new Anamenu();
		goruntu.setTitle("Musa Soysal Odev2");
		goruntu.setSize(400, 550);
		goruntu.setDefaultCloseOperation(EXIT_ON_CLOSE);
		goruntu.setResizable(false);
		goruntu.setVisible(true);
	}
}
