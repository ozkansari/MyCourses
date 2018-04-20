package tr.edu.medipol.vizeproje.ahmet_ciloglu;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		new Ekran();
		
	}
}
class Ekran{
	@SuppressWarnings("resource")
	public Ekran() {
		
		JFrame ekran1= new JFrame("K�T�PHANE");
		//Ana ekrandaki text
		final JEditorPane text = new JEditorPane();
		text.setBounds(10, 70, 700, 500);
		ekran1.getContentPane().add(text);
		//Ana ekrandaki buton
		
		JButton yazdir = new JButton("Kitaplar� Yazd�r");
		yazdir.setBounds(10, 10, 200, 50);
		ekran1.getContentPane().add(yazdir);
		//Kitap listele butonuna bas�l�nca yap�l�caklar
		yazdir.addActionListener(event ->{
			try {
				// OZKANS DUZELTME : File file = new File("C:\\Users\\Ahmet �ilo�lu\\Desktop\\kitap.txt");
				/* OZKANS DUZELTME */ File file = new File(".\\config\\kitap.txt");
		        BufferedReader reader = null;
		        reader = new BufferedReader(new FileReader(file));
		        String satir = reader.readLine();
		 
		            while (satir!=null) {
		            	 text.setPage(satir);
		            }
				}catch (IOException e1) {
					e1.printStackTrace();
				}
		});
		
		//menu
		JMenuBar menubar=new JMenuBar();
		JMenu eklemenu=new JMenu("Ekle");
		JMenuItem kitapEkle= new JMenuItem("Kitap Ekle");
		JMenuItem cikis=new JMenuItem("�IKI�");
		ekran1.setJMenuBar(menubar);
		menubar.add(eklemenu);
		eklemenu.add(kitapEkle);
		eklemenu.add(cikis);
		kitapEkle.addActionListener(e->{
			ekran2();
		});
		cikis.addActionListener(e->{
			System.exit(0);
						
		});
		
		//Ana ekran �zellikleri
		ekran1.setLayout(null);
		ekran1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ekran1.setBounds(100, 100, 800, 800);	
		ekran1.setLocationRelativeTo(null);
		ekran1.setVisible(true);			
	}
	public JFrame ekran2 = new JFrame("Kitap Ekle");
	public JButton yayinEkleButon = new JButton("Kitap Ekle");
	public JTextField kitapAdi = new JTextField();
	public JTextField yazarAdi = new JTextField();
	public JTextField yayinEv = new JTextField();
	public JTextField kitapTuru = new JTextField();
	public JTextField sayfaSayisi = new JTextField();
	public JLabel kitapLabel = new JLabel("Kitap Ad�n� Yaz�n�z:");
	public JLabel yazarLabel = new JLabel("Yazar Ad�n� Yaz�n�z:");
	public JLabel yayinLabel = new JLabel("Yay�nevi �smini Yaz�n�z:");
	public JLabel kitapturuLabel = new JLabel("Kitap T�r�n� Yaz�n�:");
	public JLabel sayfaLabel = new JLabel("Sayfa Say�s�: ");
			
	@SuppressWarnings("resource")
	private void ekran2() {
		ekran2.getContentPane().add(kitapLabel);
		kitapLabel.setBounds(10,35,200,50);
		ekran2.getContentPane().add(yazarLabel);
		yazarLabel.setBounds(10,85,200,50);
		ekran2.getContentPane().add(yayinLabel);
		yayinLabel.setBounds(10,135,200,50);
		ekran2.getContentPane().add(kitapturuLabel);
		kitapturuLabel.setBounds(10,185,200,50);
		ekran2.getContentPane().add(sayfaLabel);
		sayfaLabel.setBounds(10,235,200,50);
	
		ekran2.getContentPane().add(kitapAdi);
		kitapAdi.setBounds(150,50,100,25);
		
		ekran2.getContentPane().add(yazarAdi);
		yazarAdi.setBounds(150,100,100,25);
		
		ekran2.getContentPane().add(yayinEv);
		yayinEv.setBounds(150,150,100,25);
		
		ekran2.getContentPane().add(kitapTuru);
		kitapTuru.setBounds(150,200,100,25);
		
		ekran2.getContentPane().add(sayfaSayisi);
		sayfaSayisi.setBounds(150,250,100,25);
		
		ekran2.getContentPane().add(yayinEkleButon);
		yayinEkleButon.setBounds(250, 300, 125, 50);
		
		String kadi,yazar,turu,yayinEvi,sayfaS;
		kadi=kitapAdi.getText();
		yazar=yazarAdi.getText();
		yayinEvi=yayinEv.getText();
		turu=kitapTuru.getText();
		sayfaS=sayfaSayisi.getText();
		
		List<String> list=new ArrayList<>();  
	
		yayinEkleButon.addActionListener(e->{	
			list.add(kadi);
			list.add(yazar);
			list.add(yayinEvi);
			list.add(turu);
			list.add(sayfaS);
			try {     	 
			// OZKANS DUZELTME : File ciktiDosyasi = new File("C:\\Users\\Ahmet �ilo�lu\\Desktop\\kitap.txt");
			/* OZKANS DUZELTME */File ciktiDosyasi = new File(".\\config\\kitap.txt");
			PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
			for (String o : list) {
				dosyaYazici.println(o);
			}
			}catch (IOException e1) {
				e1.printStackTrace();
			}
			
		});	
		ekran2.setBounds(10, 40, 400, 500);
		ekran2.setLayout(null);
		ekran2.setLocationRelativeTo(null);
		ekran2.setVisible(true);
		
	}
}	






















