package tr.edu.medipol.odev2.g3a.muzafferanlas;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/** ozkans Degerlendirme

Ertan Karaaslan & Hasan Somuncu & Halil Onan & Huseyin Sirtikara & Bayram Ozkan Ozmutlu ile benzer.

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
public class Ekran extends JFrame implements ActionListener {
	private JButton silButonu = new JButton("Ögrenci Sil");
	private String sorgu = "";
	
	
	private final JPanel panel = new JPanel();
	private JTextField console;
	private JTextField ogrenciadi;
	private JTextField ogrencibolum;
	private JList list = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	 private JTextField txtDosya;
	 private JTextField txtpanelx;
	 private JTextField txttip;
	
	public void addse(String name){
		
		DLM.addElement(name);
	    list.setModel(DLM);
	}
	
	public Ekran(){
		
		silButonu.removeActionListener(this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 453, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(261, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		
		JButton btnekle = new JButton("\u00D6grenci Ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!ogrenciadi.getText().equals("")) {
					   if(!ogrencibolum.getText().equals("")) {
						   if(!txttip.getText().equals("")) {
						   
					console.setText("Son Eklenen Kişi : " + "' " + ogrenciadi.getText() + " '" + " - " + "' " + ogrencibolum.getText() + " '" + " - " + "' " + txttip.getText() + " '");
				    
					
					if (e.getSource() == btnekle){
						sorgu = ogrenciadi.getText();
						
						JOptionPane.showMessageDialog(null, sorgu + " Öğrencisi Eklendi.");
					    addse("' " + ogrenciadi.getText() + " '" +  " - " + "' " + ogrencibolum.getText() + " '" + " - " + "' " + txttip.getText() + " '");
					
					}
					
					txttip.setText("");
					ogrenciadi.setText("");
					ogrencibolum.setText("");
					
				
				    }else{JOptionPane.showMessageDialog(null, "Hata Boşlukları Doldurun.");}	
					}else{JOptionPane.showMessageDialog(null, "Hata Boşlukları Doldurun.");}
					}else {JOptionPane.showMessageDialog(null, "Hata Boşlukları Doldurun.");}
				
				
			}
		});
		
		JButton btnlstopen = new JButton("\u00D6grenci Listesi A\u00E7");
		btnlstopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpanelx.setText("");

				   try {
					   if(e.getSource()==btnlstopen) {
					        DefaultListModel listModel = (DefaultListModel) list.getModel();
					        listModel.removeAllElements();
				   } } catch (Exception exes) { }	 
				
		   BufferedReader in = null;
		   String line;

		   
		   try {

			   in = new BufferedReader(new FileReader(txtDosya.getText() + ".txt"));
			   
			   while ((line = in.readLine()) != null) {
				   String Str = new String(line);
				   
					Str.replaceAll("\\[", " ").replaceAll("\\]", " ");
		
				   
				   JOptionPane.showMessageDialog(null, "Dosya Açıldı.");
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
			
		   list.setModel(DLM);
				
				
				
				
				
			}
		});
		
		JButton btnlstkaydet = new JButton("Dosyay\u0131 Kaydet");
		btnlstkaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtpanelx.setText(""); 
				
				if (!(list.getModel().getSize() == 0)) {
				if(e.getSource() == btnlstkaydet) {
				
					try {
						File f = new File(txtDosya.getText() + ".txt");
						FileWriter fw=new FileWriter(f);
					
						
						int start = 0;
					    int end = list.getModel().getSize() - 1;
					    if (end >= 0) {
					      list.setSelectionInterval(start, end);
					      
					  	
					      String selectedText = (String)list.getSelectedValuesList().toString();
					      //list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					   
					
					      
					      JOptionPane.showMessageDialog(null, "Bilgiler Kaydedildi.");
					
					      fw.write(selectedText); 
					      
					      try {
							   if(e.getSource()==btnlstkaydet) {
							        DefaultListModel listModel = (DefaultListModel) list.getModel();
							        listModel.removeAllElements();
						   } } catch (Exception exes) { }
					      
					    //  list.setModel(DLM);

					    }
					    
						
						fw.close();
					
					}   catch (Exception exes) {
						System.out.println("HATA OLUSTU!");
					}	
				}}else{JOptionPane.showMessageDialog(null, "Liste Boş Kayıt Yapılamaz!");}
				}
		});
		
		console = new JTextField();
		console.setEditable(false);
		console.setColumns(10);
		
		JButton btnlstclose = new JButton("\u00D6grenci Listesi Kapat");
		btnlstclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpanelx.setText("");  
				try {
					   if(e.getSource()==btnlstclose) {
					        DefaultListModel listModel = (DefaultListModel) list.getModel();
					        listModel.removeAllElements();
				   } } catch (Exception exes) { }

				
			}
		});
		
		JLabel lblgrenciAd = new JLabel("\u00D6grenci \u0130sim :");
		
		JLabel lblgrenciBlm = new JLabel("\u00D6grenci B\u00F6l\u00FCm:");
		
		ogrenciadi = new JTextField();
		ogrenciadi.setColumns(10);
		
		ogrencibolum = new JTextField();
		ogrencibolum.setColumns(10);
		
		txtDosya = new JTextField();
		txtDosya.setText("dosya");
		txtDosya.setColumns(10);
		
		JLabel lblKaydetmeAd = new JLabel("Dosya Ad\u0131 :");
		
		txtpanelx = new JTextField();
		txtpanelx.setColumns(10);
		
		JLabel lblgrenciTipi = new JLabel("\u00D6grenci Tipi:");
		
		txttip = new JTextField();
		txttip.setColumns(10);
		
		JLabel lblrenciTipiniGriniz = new JLabel("(MYO/Lisans/YL/Doktora)");
		
		JLabel lblmhendislikiletmehukukvs = new JLabel("(M\u00FChendislik,Hukuk,vb.. )");
		
		JLabel lbladVeSoyad = new JLabel("(Ad\u0131 ve Soyad\u0131 )");
		
		JLabel lblrenciAd = new JLabel("\u00D6\u011Frenci G\u00FCncelle :");
		
		JButton btngnc = new JButton("\u00D6grenci G\u00FCncelle");
		btngnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				 
				DLM.setElementAt(txtpanelx.getText(), index);
				
			}
		});
		
		JButton btnsil = new JButton("\u00D6grenci Sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				
				DLM.removeElementAt(index);
				
				txtpanelx.setText("");
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(console, 409, 409, 409)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblrenciAd, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(btngnc, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(btnsil, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblKaydetmeAd)
												.addComponent(btnlstkaydet, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
												.addComponent(txtDosya, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
												.addComponent(btnlstopen, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
												.addComponent(btnlstclose, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblgrenciTipi, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblgrenciBlm, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblgrenciAd))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(ogrencibolum, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(txttip, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(ogrenciadi, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lbladVeSoyad, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblmhendislikiletmehukukvs)
										.addComponent(lblrenciTipiniGriniz)))))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(32)
							.addComponent(btnekle, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtpanelx, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
					.addGap(34))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ogrenciadi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbladVeSoyad)
						.addComponent(lblgrenciAd))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ogrencibolum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblmhendislikiletmehukukvs)
						.addComponent(lblgrenciBlm))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblgrenciTipi)
						.addComponent(txttip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblrenciTipiniGriniz))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnekle, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(console, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblKaydetmeAd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDosya, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnlstkaydet)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnlstopen)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnlstclose)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblrenciAd)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btngnc)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnsil))
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtpanelx, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
		);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
				
				String Selected2=list.getSelectedValue().toString();
				String Sample = Selected2;
				
			
				try{
				Sample = Sample.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "     <>   ");
         
                Selected2 = Sample;}
				catch (Exception exes) {System.out.println("Komut Düzeltme Hatası!");}	
				txtpanelx.setText(Selected2);
				
				
				   }catch (Exception exes) {System.out.println("Hata Liste Boş!");}	
				
			}	
		});  
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
	}
	
  
	
	public static void main(String[] args) {
		Ekran ekran = new Ekran();
		ekran.setTitle("Proje Ödevi - Muzaffer Anlaş");
		ekran.setSize(440, 540);
		ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekran.setResizable(false);
		ekran.setVisible(true);
	}	
}