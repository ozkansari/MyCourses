package tr.edu.medipol.vizeproje.kerem_arca;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;


public class anasayfa {
	    public static void main(String[] args) {
	        new AnasayfaPencere();
	    }
}

class AnasayfaPencere{
		private JFrame anasayfaPencere = new JFrame("Ana Men�");
	    final JEditorPane editorPane = new JEditorPane();
	    
	    public AnasayfaPencere() {

	        JScrollPane editorScroll = new JScrollPane(editorPane);
	        editorScroll.setBounds(10, 30, 460, 135);
	        editorPane.setText("K�t�phane Y�netim Uygulamas�na Ho�geldiniz!\n\n\n\n                                             Kerem Arca - H5170061");
	        editorPane.setFont(new Font("Georgia", Font.PLAIN, 20));
	        editorPane.setForeground(new Color(50, 50, 25));
	        
	        anasayfaPencere.getContentPane().add(editorScroll);

	

	       

	        MenuBarOlustur();
	        
	        
	        anasayfaPencere.setLayout(null);
	        anasayfaPencere.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        anasayfaPencere.setSize(500, 280);
	        anasayfaPencere.setLocationRelativeTo(null);
	        anasayfaPencere.setVisible(true);
	    }

	    private void MenuBarOlustur() {
	        // JMenuBar
	        
	        Icon yayinevi = UIManager.getIcon("FileChooser.homeFolderIcon");
	        JMenuItem dosyaAceMenuItem = new JMenuItem("Yay�n Evi Ekle", yayinevi);
	        dosyaAceMenuItem.addActionListener(e -> {
	        	anasayfaPencere.dispose();
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
	        	anasayfaPencere.dispose();
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
	        	anasayfaPencere.dispose();
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
	        anasayfaPencere.setJMenuBar(menubar);
	        menubar.add(filemenu);
	    }

	  

	}

	
	