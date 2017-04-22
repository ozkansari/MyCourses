package tr.edu.medipol.odev2.g3.resulvural;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Ekran extends JFrame implements ActionListener {
	private JButton silButonu = new JButton("��renci Sil");
	private String sorgu = "";
	
	
	private final JPanel panel = new JPanel();
	private JTextField console;
	private JTextField ogrenci_adi;
	private JTextField ogrenci_bolum;
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
		
		JButton btnekle = new JButton("��renci ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!ogrenci_adi.getText().equals("")) {
					   if(!ogrenci_bolum.getText().equals("")) {
						   if(!txttip.getText().equals("")) {
						   
					console.setText("Son eklenen ��renci: " + "' " + ogrenci_adi.getText() + " '" + " - " + "' " + ogrenci_bolum.getText() + " '" + " - " + "' " + txttip.getText() + " '");
				    
					
					if (e.getSource() == btnekle){
						sorgu = ogrenci_adi.getText();
						
						JOptionPane.showMessageDialog(null, sorgu + " ��rencisi eklendi.");
					    addse("' " + ogrenci_adi.getText() + " '" +  " - " + "' " + ogrenci_bolum.getText() + " '" + " - " + "' " + txttip.getText() + " '");
					
					}
					
					txttip.setText("");
					ogrenci_adi.setText("");
					ogrenci_bolum.setText("");
					
				
				    }else{JOptionPane.showMessageDialog(null, "Bo�luk hatas�");}	
					}else{JOptionPane.showMessageDialog(null, "Bo�luk hatas�");}
					}else {JOptionPane.showMessageDialog(null, "Bo�luk hatas�");}
				
				
			}
		});
		
		JButton btnlstopen = new JButton("��renci Listesi");
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
		
				   
				   JOptionPane.showMessageDialog(null, "Dosya hatas�");
				   DLM.addElement(line); 

			   }

		   } catch (IOException exed) {
				System.out.println("HATA OLU�TU");
		
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
		
		JButton btnlstkaydet = new JButton("Dosyay� Kaydet");
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
					   
					
					      
					      JOptionPane.showMessageDialog(null, "Kay�t i�lemi ba�ar�l�.");
					
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
						System.out.println("HATA OLU�TU");
					}	
				}}else{JOptionPane.showMessageDialog(null, "Liste bo� kay�t yap�lamaz.");}
				}
		});
		
		console = new JTextField();
		console.setEditable(false);
		console.setColumns(10);
		
		JButton btnlstclose = new JButton("��renci Listesi Kapat");
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
		
		JLabel lblgrenciAd = new JLabel("��renci �simi:");
		
		JLabel lblgrenciBlm = new JLabel("��renci b�l�m�:");
		
		ogrenci_adi = new JTextField();
		ogrenci_adi.setColumns(10);
		
		ogrenci_bolum = new JTextField();
		ogrenci_bolum.setColumns(10);
		
		txtDosya = new JTextField();
		txtDosya.setText("dosya");
		txtDosya.setColumns(10);
		
		JLabel lblKaydetmeAd = new JLabel("Dosya ad�:");
		
		txtpanelx = new JTextField();
		txtpanelx.setColumns(10);
		
		JLabel lblgrenciTipi = new JLabel("��renci tipi:");
		
		txttip = new JTextField();
		txttip.setColumns(10);
		
		JLabel lblrenciTipiniGriniz = new JLabel("(MYO/Lisans/YL/Doktora)");
		
		JLabel lblmhendislikiletmehukukvs = new JLabel("(M�hendislik,Hukuk,vb. )");
		
		JLabel lbladVeSoyad = new JLabel("Ad� ve Soyad�");
		
		JLabel lblrenciAd = new JLabel("��renci g�ncelle:");
		
		JButton btngnc = new JButton("��renci g�ncelle");
		btngnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				 
				DLM.setElementAt(txtpanelx.getText(), index);
				
			}
		});
		
		JButton btnsil = new JButton("��renci Sil");
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
										.addComponent(ogrenci_bolum, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(txttip, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(ogrenci_adi, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
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
							
						.addComponent(ogrenci_adi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbladVeSoyad)
						
						.addComponent(lblgrenciAd))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ogrenci_bolum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
				catch (Exception exes) {System.out.println("Komut d�zeltme hatas�");}	
				txtpanelx.setText(Selected2);
				
				
				   }catch (Exception exes) {System.out.println("Liste bo�!");}	
				
			}	
		});  
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
	}
	
  
	
	
	public static void main(String[] args) {
		Ekran ekran = new Ekran();
		ekran.setTitle("Resul-Vural-Vize");
		ekran.setSize(440, 580);
		
		ekran.setResizable(false);
		ekran.setVisible(true);
		ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}	
}
