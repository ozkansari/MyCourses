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


public class KitapEkle {
	    
    	
	    
	    private JFrame KitapEkle = new JFrame("Kitap Ekle");
	    private JButton okButon = new JButton("Ekle");
	    private JTextField KitapAdi = new JTextField();
	    private JTextField Yazar = new JTextField();
	    private JTextField Tur = new JTextField();
	    //private JComboBox<liste> Yayinevi = new JComboBox();
	    private JTextField Sayfa = new JTextField();

	    private JLabel label1 = new JLabel("Kitap �smi:");
	    private JLabel label2 = new JLabel("Yazar:");
	    private JLabel label3 = new JLabel("T�r:");
	    private JLabel label4 = new JLabel("Yay�n Evi:");
	    private JLabel label5 = new JLabel("Sayfa Say�s�:");

	    
	    public KitapEkle() throws FileNotFoundException {
	    	
	    
	    	ArrayList<String> liste = new ArrayList<String>();
	    	ArrayList<String> liste2 = new ArrayList<String>();

	    	/* OZKANS DUZELTME */ try {
	    	Scanner s = new Scanner(new File(".\\\\config\\\\Yayin_Evleri.txt"));
		    while (s.hasNext()){
		        liste.add(s.nextLine());
		        
		    }
		    s.close();
	    	/* OZKANS DUZELTME */ } catch(Exception e) {}
	    	
		    JComboBox Yayinevi = new JComboBox(liste.toArray());
		    
		    /* OZKANS DUZELTME */ try {
		    Scanner ss = new Scanner(new File(".\\\\config\\\\Kitaplar.txt"));
		    while (ss.hasNext()){
		        liste2.add(ss.nextLine());
		        
		    }
		    ss.close();
		    /* OZKANS DUZELTME */ } catch(Exception e) {}
		    
		    JList list = new JList(liste2.toArray());

	    	label1.setBounds(12,8,100,30);
	        KitapEkle.getContentPane().add(label1);
	        label1.setFont(new Font("Georgia", Font.PLAIN, 14));
	        label1.setForeground(new Color(50, 50, 25));

	        KitapEkle.getContentPane().add(KitapAdi);
	        KitapAdi.setBounds(150,10,200,30);
	        //
	    	label2.setBounds(12,48,100,30);
	        KitapEkle.getContentPane().add(label2);
	        label2.setFont(new Font("Georgia", Font.PLAIN, 14));
	        label2.setForeground(new Color(50, 50, 25));

	        KitapEkle.getContentPane().add(Yazar);
	        Yazar.setBounds(150,50,200,30);
	        //
	        label3.setBounds(12,83,100,30);
	        KitapEkle.getContentPane().add(label3);
	        label3.setFont(new Font("Georgia", Font.PLAIN, 14));
	        label3.setForeground(new Color(50, 50, 25));

	        KitapEkle.getContentPane().add(Tur);
	        Tur.setBounds(150,85,200,30);
	        //
	        label4.setBounds(12,123,100,30);
	        KitapEkle.getContentPane().add(label4);
	        label4.setFont(new Font("Georgia", Font.PLAIN, 14));
	        label4.setForeground(new Color(50, 50, 25));

	        KitapEkle.getContentPane().add(Yayinevi);
	        Yayinevi.setBounds(150,125,200,30);
	        //
	        label5.setBounds(12,163,100,30);
	        KitapEkle.getContentPane().add(label5);
	        label5.setFont(new Font("Georgia", Font.PLAIN, 14));
	        label5.setForeground(new Color(50, 50, 25));

	        KitapEkle.getContentPane().add(Sayfa);
	        Sayfa.setBounds(150,165,200,30);
	        //
	        okButon.setBounds(180, 210, 150, 50);
	        KitapEkle.getContentPane().add(okButon);
	        okButon.addActionListener(event -> {
	        	
	        	String mailSablonu = "^[0-9]";
	     		Pattern sablonNesnesi = Pattern.compile(mailSablonu, Pattern.CASE_INSENSITIVE);
	     		
	     		Matcher eslestirici = sablonNesnesi.matcher(Sayfa.getText());
	     		boolean eslestiMi = eslestirici.find();
	     		
	     		if(eslestiMi == false || Yayinevi.getItemCount() == 0 || Sayfa.getText() == null || Sayfa.getText().trim().isEmpty() || Sayfa.getText().equals("*")) {

			
	     			 JOptionPane.showMessageDialog(null, "Yay�n Evi Se�ili De�il veya sayfa Say�s� Yanl��", "Failure", JOptionPane.ERROR_MESSAGE);

	     		}
	     		else {
	     			
	     			liste2.add(KitapAdi.getText() + "	     " + Yazar.getText() + "	     " + Tur.getText() + "	     " + Yayinevi.getSelectedItem() + "	     " + Sayfa.getText());
	     			File ciktiDosyasi = new File(".\\config\\Kitaplar.txt");
	     			
	     			PrintWriter dosyaYazici = null;
	    			try {
	    				dosyaYazici = new PrintWriter(ciktiDosyasi);
	    			} catch (FileNotFoundException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}

	     			for (String o : liste2) {
	     				dosyaYazici.println(o);
	     			}
	     			dosyaYazici.close();
	     			
	     			
	     			 JOptionPane.showMessageDialog(null, "Kitap Eklendi");

	     		}
	        });
	        
	        
	        
	        //
	     
	        MenuBarOlustur();
	        
	        
	        KitapEkle.setLayout(null);
	        KitapEkle.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        KitapEkle.setSize(400, 400);
	        // KitapEkle.setLocation(700, 700);
	        KitapEkle.setLocationRelativeTo(null);
	        KitapEkle.setVisible(true);
	
	    }

	    private void MenuBarOlustur() {
	        // JMenuBar
	        
	    	 Icon yayinevi = UIManager.getIcon("FileChooser.homeFolderIcon");
		        JMenuItem dosyaAceMenuItem = new JMenuItem("Yay�n Evi Ekle", yayinevi);
		        dosyaAceMenuItem.addActionListener(e -> {
		        	KitapEkle.dispose();
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
		        	KitapEkle.dispose();
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
		        	KitapEkle.dispose();
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
	        KitapEkle.setJMenuBar(menubar);
	        menubar.add(filemenu);
	        
	        
	        
	    }

	}

	
	