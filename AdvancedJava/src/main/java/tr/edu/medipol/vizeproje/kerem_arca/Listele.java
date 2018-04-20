package tr.edu.medipol.vizeproje.kerem_arca;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Listele {
	    
    	
	    
	    private JFrame Listele = new JFrame("Listele");
	    private JButton okButon = new JButton("Ekle");
	    private JButton dltButon = new JButton("Sil");
	    private JTextField KitapAdi = new JTextField();
	    private JTextField Yazar = new JTextField();
	    private JTextField Tur = new JTextField();
	    private JTextField Sayfa = new JTextField();

	    private JLabel label1 = new JLabel("Kitap �smi:");
	    private JLabel label2 = new JLabel("Yazar:");
	    private JLabel label3 = new JLabel("T�r:");
	    private JLabel label4 = new JLabel("Yay�n Evi:");
	    private JLabel label5 = new JLabel("Sayfa Say�s�:");

	    
	    public Listele() throws FileNotFoundException {
	    	
	       final DefaultListModel model = new DefaultListModel();
	       model.addElement("Kitap �smi	                    " + "Yazar	             " + "T�r	            " + "Yay�n Evi	        " + "Sayfa");

	       JList listt = new JList(model);
	    	
	    	
	    	ArrayList<String> liste2 = new ArrayList<String>();

	    	/* OZKANS DUZELTME */ try {	    
		    Scanner ss = new Scanner(new File(".\\\\config\\\\Kitaplar.txt"));
		    while (ss.hasNext()){
		        liste2.add(ss.nextLine());
		        
		    }
		    ss.close();
	    	/* OZKANS DUZELTME */ } catch(Exception e) {}
		    
		    JList list = new JList(liste2.toArray());

	        listt.setBounds(12, 8, 360, 20);
	        Listele.getContentPane().add(listt);
	        
	        list.setBounds(12, 40, 360, 200);
	        Listele.getContentPane().add(list);
	        
	        dltButon.setBounds(375, 41, 50, 20);
	        Listele.getContentPane().add(dltButon);
	        dltButon.addActionListener(event -> {
	        	int index = list.getSelectedIndex();
	        	liste2.remove(index);
	        	list.remove(index);
	        });
	        
	        MenuBarOlustur();
	        
	        
	        Listele.setLayout(null);
	        Listele.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        Listele.setSize(460, 350);
	        Listele.setLocationRelativeTo(null);
	        Listele.setVisible(true);
	
	    }

	    private void MenuBarOlustur() {
	        // JMenuBar
	        
	    	 Icon yayinevi = UIManager.getIcon("FileChooser.homeFolderIcon");
		        JMenuItem dosyaAceMenuItem = new JMenuItem("Yay�n Evi Ekle", yayinevi);
		        dosyaAceMenuItem.addActionListener(e -> {
		        	Listele.dispose();
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
		        	Listele.dispose();
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
		        	Listele.dispose();
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
	        Listele.setJMenuBar(menubar);
	        menubar.add(filemenu);
	        
	        
	        
	    }

	}

	
	