package tr.edu.medipol.vizeproje.anil_bal;
import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import java.awt.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class Arayuz extends JFrame{
	private JPanel PanelAna = new JPanel();
	private JPanel PanelYayin = new JPanel();
	private JPanel PanelKitap = new JPanel();
	private JPanel PanelListele = new JPanel();
	private JButton yayinEviEkle = new JButton("Yayin Evi Ekle");
	private JButton KitapEkle = new JButton("Yeni Kitap Ekle");
	private JButton KitapListele = new JButton("Kitaplari Listele");
	private JButton Cikis = new JButton("iikii");
	
	//Yayin Evi Ekleme 
	private JTextField YayinEviismi = new JTextField();
	private JTextField YayinEviEposta = new JTextField();
	private JButton YayinEviButton = new JButton("Yayin Evini Ekle");
	private JLabel YayinEviText = new JLabel("");
	private File ciktiDosyasi = new File(".\\config\\YayinEvleri.txt");
	
	//Kitap Ekleme
	private JTextField KitabinAdi = new JTextField();
	private JTextField KitabinYazari = new JTextField();
	private JTextField KitabinTiri = new JTextField();
	private JTextField KitabinYayinEvi = new JTextField();
	private JTextField KitabinSayfaSayisi = new JTextField();
	private JLabel KitabinSayfaLabel= new JLabel("");
	private JLabel KitabinBilgi= new JLabel("");
	private JButton KitabinButton = new JButton("Kitabi Ekle");
	private File ciktiDosyasi2 = new File(".\\config\\Kitaplar.txt");
	
	public Arayuz() {
		
		setTitle("Kitiphane Otomasyonu");
		setSize(500,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		

		
		PanelAna.setLayout(new GridLayout(1,4));
		PanelAna.add(yayinEviEkle);
		PanelAna.add(KitapEkle);
		PanelAna.add(KitapListele);
		PanelAna.add(Cikis);
		add(PanelAna);
		
		
		yayinEviEkle.addActionListener(e -> {
			n_yayinEviEkle();
		});
		KitapEkle.addActionListener(e -> {
			n_KitapEkle();
		});
		KitapListele.addActionListener(e -> {
			n_KitapListele();
		});
		Cikis.addActionListener(e -> {
			System.exit(0);
		});
	}
	
	private void n_yayinEviEkle() {
		PanelAna.setVisible(false);
		setTitle("Kitap Ekle");
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelYayin.setLayout(new GridLayout(3,3));
		PanelYayin.add(new JLabel("Yayin Evi ismi:"));
		PanelYayin.add(YayinEviismi);
		PanelYayin.add(new JLabel("E-posta"));
		PanelYayin.add(YayinEviEposta);
		PanelYayin.add(YayinEviText);
		PanelYayin.add(YayinEviButton);
		add(PanelYayin);
		
		
		
		YayinEviButton.addActionListener(e -> {
		
			String Yayinismi = YayinEviismi.getText();
			String Eposta = YayinEviEposta.getText();
			String Eposta2 = Eposta;
				
		        
		        if (Eposta2.matches("(?simx)\\b[A-Z0-9._%+-]+" +"@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b"))
		        {
		        	YayinEviText.setText("Yayin Eviniz Baiariyla Kaydolmuitur.");
		        	try 
		        	{
						dosyayaz(Yayinismi);
					}
		        	catch (FileNotFoundException e1) 
		        	{
						e1.printStackTrace();
					}
		        	/*OZKANS DUZELTME */PanelAna.setVisible(true);
		        	/*OZKANS DUZELTME */PanelYayin.setVisible(false);
		        } 
		       else 
		       {
		          	YayinEviText.setText("Hatali Bir E Posta iekli Girildi. Litfen Kontrol Edip Tekrar Deneyiniz.");
		       } 

		});
		
	
	}

	private void dosyayaz(String yayinismi) throws FileNotFoundException {
	    
		
		PrintWriter yaz = new PrintWriter(ciktiDosyasi);
		yaz.println(YayinEviEposta.getText() + " || " + yayinismi);
		yaz.close();}
		

		
	private void n_KitapEkle() {
		PanelAna.setVisible(false);
		setTitle("Yayin Evi Ekle");
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		PanelKitap.setLayout(new GridLayout (7,2));
		
		PanelKitap.add(new JLabel("Kitabin Adi:"));
		PanelKitap.add(KitabinAdi);
		PanelKitap.add(new JLabel("Kitabin Yazari"));
		PanelKitap.add(KitabinYazari);
		PanelKitap.add(new JLabel("Kitabin Tiri:"));
		PanelKitap.add(KitabinTiri);
		PanelKitap.add(new JLabel("Kitabin Yayin Evi:"));
		PanelKitap.add(KitabinYayinEvi);
		PanelKitap.add(new JLabel("Kitabin Sayfa Sayisi:"));
		PanelKitap.add(KitabinSayfaSayisi);
		PanelKitap.add(new JLabel(""));
		PanelKitap.add(KitabinSayfaLabel);
		PanelKitap.add(KitabinBilgi);
		PanelKitap.add(KitabinButton);
		add(PanelKitap);
		
		KitabinSayfaSayisi.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				try {
					int i =Integer.parseInt(KitabinSayfaSayisi.getText());
					KitabinSayfaLabel.setText("");
				} catch (NumberFormatException e2) {
					KitabinSayfaLabel.setText("Sadece Sayi Giriniz");
				}
			}
			
		});
		
		
		KitabinButton.addActionListener(e -> {
		
			
			try {
				
				PrintWriter yazici = new PrintWriter(ciktiDosyasi2);
				yazici.println(KitabinAdi.getText() + " || " + KitabinYazari.getText()+ " || " + KitabinTiri.getText()+ " || " + KitabinYayinEvi.getText()+ " || " + KitabinSayfaSayisi.getText() );
				yazici.close();
				KitabinBilgi.setText("Baiariyla Kayit Olmuitur");
				
				/*OZKANS DUZELTME */PanelAna.setVisible(true);
	        	/*OZKANS DUZELTME */PanelKitap.setVisible(false);
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		});
		
		
	
		
	}
		
	private void n_KitapListele() {
		
	}
	
	
	
	
	
	
	
	
	
		
	
	
}



