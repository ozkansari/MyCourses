package tr.edu.medipol.vizeproje.kerem_arca;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;


public class YayinEviEkle {
	
		
	    
	    private static JFrame YayinEviEkle = new JFrame("Yay�n Evi Ekle");
	    private JButton okButon = new JButton("Ekle");
	    private JButton dltButon = new JButton("Sil");
	    private static JTextField ad = new JTextField();
	    private JTextField eposta = new JTextField();
	    private JLabel label1 = new JLabel("Yay�n Evi �smi:");
	    private JLabel label2 = new JLabel("E Posta Adresi:");
	    
	    
	   // private static JList list = new JList(liste.toArray()); 

		public YayinEviEkle() throws FileNotFoundException {	 
			
		    ArrayList<String> liste = new ArrayList<String>();

		    /* OZKANS DUZELTME */ try {
		    Scanner s = new Scanner(new File(".\\\\config\\\\Yayin_Evleri.txt"));
		    while (s.hasNext()){
		        liste.add(s.nextLine());
		        
		    }
		    s.close();
		    /* OZKANS DUZELTME */ } catch(Exception e) {}
		    
		    JList list = new JList(liste.toArray());

		    
	    	label1.setBounds(12,8,100,30);
	        YayinEviEkle.getContentPane().add(label1);
	        label1.setFont(new Font("Georgia", Font.PLAIN, 14));
	        label1.setForeground(new Color(50, 50, 25));

	        YayinEviEkle.getContentPane().add(ad);
	        ad.setBounds(150,10,200,30);
	        //
	    	label2.setBounds(12,48,100,30);
	        YayinEviEkle.getContentPane().add(label2);
	        label2.setFont(new Font("Georgia", Font.PLAIN, 14));
	        label2.setForeground(new Color(50, 50, 25));

	        YayinEviEkle.getContentPane().add(eposta);
	        eposta.setBounds(150,50,200,30);
	        //
	        okButon.setBounds(200, 100, 85, 35);
	        okButon.addActionListener(event -> {
	        	
	        	String mailSablonu = "^[A-Za-z0-9+_.-]+@(.+)$";
	     		Pattern sablonNesnesi = Pattern.compile(mailSablonu, Pattern.CASE_INSENSITIVE);
	     		
	     		Matcher eslestirici = sablonNesnesi.matcher(eposta.getText());
	     		boolean eslestiMi = eslestirici.find();
	     		
	     		if(eslestiMi) {
	
	     			liste.add(ad.getText());
	     			
	     			File ciktiDosyasi = new File(".\\config\\Yayin_Evleri.txt");
	     			
	     			PrintWriter dosyaYazici = null;
	    			try {
	    				dosyaYazici = new PrintWriter(ciktiDosyasi);
	    			} catch (FileNotFoundException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}

	     			for (String o : liste) {
	     				dosyaYazici.println(o);
	     			}
	     			dosyaYazici.close();
	     			
	     			
	     			 JOptionPane.showMessageDialog(null, "Yay�n Evi Eklendi");
	     		}
	     		
	     		else {
	     			 JOptionPane.showMessageDialog(null, "E-Posta Hatal�", "Failure", JOptionPane.ERROR_MESSAGE);
	     		}
	        });
	        YayinEviEkle.getContentPane().add(okButon);
	        //
	        
	        YayinEviEkle.getContentPane().add(list);
	        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        list.setBounds(12,150,250,220);
	        
	        YayinEviEkle.getContentPane().add(dltButon);
	        dltButon.setBounds(280,225,80,40);
	        dltButon.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
//	    	        int selectedIndex = list.getSelectedIndex();
//	    	        list.remove(selectedIndex);
	            }
	          });
	        

	        MenuBarOlustur();
	        
	        
	        YayinEviEkle.setLayout(null);
	        YayinEviEkle.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        YayinEviEkle.setSize(400, 500);
	        // YayinEviEkle.setLocation(700, 700);
	        YayinEviEkle.setLocationRelativeTo(null);
	        YayinEviEkle.setVisible(true);
	    }

	    private void MenuBarOlustur() {
	        // JMenuBar
	        
	    	 Icon yayinevi = UIManager.getIcon("FileChooser.homeFolderIcon");
		        JMenuItem dosyaAceMenuItem = new JMenuItem("Yay�n Evi Ekle", yayinevi);
		        dosyaAceMenuItem.addActionListener(e -> {
		        	YayinEviEkle.dispose();
		 	        try {
						new YayinEviEkle();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        });
		        
		        Icon kitap = UIManager.getIcon("FileChooser.upFolderIcon");
		        JMenuItem dosyaAceMenuItem2 = new JMenuItem("Kitap Ekle", kitap);
		        dosyaAceMenuItem2.addActionListener(e -> {
		        	YayinEviEkle.dispose();
		 	        try {
						new KitapEkle();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        });
		        
		        Icon liste = UIManager.getIcon("FileChooser.listViewIcon");
		        JMenuItem dosyaAceMenuItem3 = new JMenuItem("Kitaplar� Listele", liste);
		        dosyaAceMenuItem3.addActionListener(e -> {
		        	YayinEviEkle.dispose();
		 	        try {
						new Listele();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        });
	        // ImageIcon icon = new ImageIcon(getClass().getResource("exit.png"));
	        Icon icon = UIManager.getIcon("OptionPane.errorIcon");
	        JMenuItem eMenuItem = new JMenuItem("��k��", icon);
	        eMenuItem.addActionListener(event -> {
	            System.exit(0);
	        });

	        JMenu filemenu = new JMenu("Men�");
	        filemenu.add(dosyaAceMenuItem);
	        filemenu.add(dosyaAceMenuItem2);
	        filemenu.add(dosyaAceMenuItem3);
	        filemenu.add(eMenuItem);

	        JMenuBar menubar = new JMenuBar();
	        YayinEviEkle.setJMenuBar(menubar);
	        menubar.add(filemenu);
	    }

	}

	
	