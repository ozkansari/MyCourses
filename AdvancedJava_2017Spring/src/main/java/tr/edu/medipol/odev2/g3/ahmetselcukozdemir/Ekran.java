package tr.edu.medipol.odev2.g3.ahmetselcukozdemir;

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
	
	//tan�mlamalar
	
	
	private JButton silmeButonu = new JButton("��renci sil");
	private String sorgulama = "";
	
	
	private final JPanel panel = new JPanel();
	private JTextField console;
	private JTextField ogrenciBolum;
	private JTextField ogrenciAdi;

	private JList list = new JList();
	
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
	

	 DefaultListModel DLM = new DefaultListModel();
	 private JTextField txtDosya;
	 private JTextField txtPanel;
	 private JTextField txtTip;
	
	public void addse(String name){
		
		DLM.addElement(name);
	    list.setModel(DLM);
	}
	
	public Ekran(){
		
		silmeButonu.removeActionListener(this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(350, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE,
						
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		
		
		
		//��renci ekleme
		
		
		JButton btnekle = new JButton("��renci ekle");
		btnekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!ogrenciAdi.getText().equals("")) {
					   if(!ogrenciBolum.getText().equals("")) {
						   if(!txtTip.getText().equals("")) {
						   
					console.setText("Eklenen ��renci : " + "' " + ogrenciAdi.getText() + " '" + " - " + "' " + ogrenciBolum.getText() + " '" + " - " + "' " + txtTip.getText() + " '");
				    
					
					if (e.getSource() == btnekle){
						sorgulama = ogrenciAdi.getText();
						
						JOptionPane.showMessageDialog(null, sorgulama + " ��renci eklendi.");
					    addse("' " + ogrenciAdi.getText() + " '" + 
						" - " + "' " + ogrenciBolum.getText() + " '" + " - "
					    		+ "' " + txtTip.getText() + " '");
					
					}
					
					txtTip.setText("");
					ogrenciAdi.setText("");
					ogrenciBolum.setText("");
					
				
				    }
						   //bo� de�er girilip girilmedi�ini kontrol etme
					else{
						JOptionPane.showMessageDialog(null, "bo� de�er girdiniz");}	
					}else{JOptionPane.showMessageDialog(null, "bo� de�er girdiniz");}
					}else {JOptionPane.showMessageDialog(null, "bo� de�er girdiniz");}
				
				
			}
		});
		
		JButton btnlstopen = new JButton("��renci Listesi");
		btnlstopen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPanel.setText("");

				   try {
					   if(e.getSource()==btnlstopen) {
					        DefaultListModel listModel = (DefaultListModel) list.getModel();
					        listModel.removeAllElements();
				   } } catch (Exception exes) { }	 
				
		   BufferedReader rd = null;
		   String line;
		   
		   
		   
   //dosya a�ma i�lemi
		   
		   try {

			   rd = new BufferedReader(new FileReader(txtDosya.getText() + ".txt"));
			   
			   while ((line = rd.readLine()) != null) {
				   String Str = new String(line);
				   
					Str.replaceAll("\\(", " ").replaceAll("\\)", " ");
		
				   
				   JOptionPane.showMessageDialog(null, "dosya a��lmad�");
				   DLM.addElement(line); 

			   }

		   } catch (IOException exed) {
				System.out.println("hata");
		
		   } finally {
				       
			   if (rd != null) {
				   
				   try {
					rd.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			   }
				    }
			
		   list.setModel(DLM);
				
				
				
				
				
			}
		});
		
		//dosyay� kaydetme-yazd�rma
		
		
		
		JButton btnlstkaydet = new JButton("Dosyay� Kaydet");
		btnlstkaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtPanel.setText(""); 
				
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
					     
					   
					
					      
					      JOptionPane.showMessageDialog(null, "��renciler kaydedildi");
					
					      fw.write(selectedText); 
					      
					      try {
							   if(e.getSource()==btnlstkaydet) {
							        DefaultListModel listModel = (DefaultListModel) list.getModel();
							        listModel.removeAllElements();
						   } } catch (Exception exes) { }
					      
					    

					    }
					    
						
						fw.close();
					
					}   catch (Exception exes) {
						System.out.println("hatal�");
					}	
				}}else{JOptionPane.showMessageDialog(null, "Listede ��renci yok.");}
				}
		});
		
		console = new JTextField();
		console.setEditable(false);
		console.setColumns(15);
		
		JButton btnClose = new JButton("Listeyi kapat");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPanel.setText("");  
				try {
					   if(e.getSource()==btnClose) {
					        DefaultListModel listModel = (DefaultListModel) list.getModel();
					        listModel.removeAllElements();
				   } } catch (Exception exes) { }

				
			}
		});
		
		JLabel lblgrenciAd = new JLabel("��renci isimi:");
		
		JLabel lblgrenciBlm = new JLabel("��renci b�l�m�:");
		
		ogrenciAdi = new JTextField();
		ogrenciAdi.setColumns(15);
		
		ogrenciBolum = new JTextField();
		ogrenciBolum.setColumns(15);
		
		txtDosya = new JTextField();
		txtDosya.setText("txt dosyas�n�n isimi");
		txtDosya.setColumns(15);
		
		JLabel lblKaydetmeAd = new JLabel("Dosya ad�");
		
		txtPanel = new JTextField();
		txtPanel.setColumns(15);
		
		JLabel lblOgrenciTipi = new JLabel("��renci tipi:");
		
		txtTip = new JTextField();
		txtTip.setColumns(15);
		
		JLabel lblTip = new JLabel("(myo/Lisans/yl/doktora)");
		
		JLabel lblBolum = new JLabel("m�hendislik,Hukuk,vb.");
		
		JLabel lbladVeSoyad = new JLabel("��rencinin Ad�");
		
		JLabel lblrenciAd = new JLabel("��renci G�ncelleme");
		
		JButton btngnc = new JButton("��renci g�ncelleme");
		btngnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				 
				DLM.setElementAt(txtPanel.getText(), index);
				
			}
		});
		
		JButton btnsil = new JButton("��renci sil");
		btnsil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=list.getSelectedIndex();
				
				DLM.removeElementAt(index);
				
				txtPanel.setText("");
			}
		});
		GroupLayout group_panel = new GroupLayout(panel);
		group_panel.setHorizontalGroup(
			group_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(group_panel.createSequentialGroup()
					.addGroup(group_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, group_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(group_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(console, 409, 409, 409)
								.addGroup(group_panel.createSequentialGroup()
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(group_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblrenciAd, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
										.addGroup(group_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(btngnc, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
											.addGroup(group_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(btnsil, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblKaydetmeAd)
												.addComponent(btnlstkaydet, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
												.addComponent(txtDosya, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
												.addComponent(btnlstopen, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
												.addComponent(btnClose, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))))
								.addGroup(group_panel.createSequentialGroup()
									.addGroup(group_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblOgrenciTipi, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblgrenciBlm, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblgrenciAd))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(group_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(ogrenciBolum, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTip, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
										.addComponent(ogrenciAdi, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(group_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lbladVeSoyad, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBolum)
										.addComponent(lblTip)))))
						.addGroup(Alignment.TRAILING, group_panel.createSequentialGroup()
							.addGap(32)
							.addComponent(btnekle, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
						.addGroup(group_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtPanel, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)))
					.addGap(34))
		);
		group_panel.setVerticalGroup(
			group_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(group_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(group_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ogrenciAdi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbladVeSoyad)
						.addComponent(lblgrenciAd))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(group_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ogrenciBolum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBolum)
						.addComponent(lblgrenciBlm))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(group_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOgrenciTipi)
						.addComponent(txtTip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTip))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnekle, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(console, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(group_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(group_panel.createSequentialGroup()
							.addComponent(lblKaydetmeAd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDosya, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnlstkaydet)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnlstopen)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnClose)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblrenciAd)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btngnc)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnsil))
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPanel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
		);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
				
				String selected2=list.getSelectedValue().toString();
				String Sample = selected2;
				
			
				try{
				Sample = Sample.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "     <>   ");
         
                selected2 = Sample;}
				catch (Exception exes) {System.out.println("Komut hatas�");}	
				txtPanel.setText(selected2);
				
				
				   }catch (Exception exes) {System.out.println("Liste bo�");}	
				
			}	
		});  
		panel.setLayout(group_panel);
		getContentPane().setLayout(groupLayout);
		
	}
	
  
	
	public static void main(String[] args) {
		Ekran ekran = new Ekran();
		ekran.setTitle("Ahmet Sel�uk �ZDEM�R-H5150006	");
		ekran.setSize(550, 650);
		ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekran.setVisible(true);
		ekran.setResizable(false);
	}	

}
