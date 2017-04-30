package tr.edu.medipol.odev2.g6.salihterekli;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


/** ozkans Degerlendirme

- Nurcan Karakulleoglu ile benzer ama birbirinden ayrilan yerler de var.
- Polimorfism yok.
- Turkce karakter sorunlari var.
- Hatali/bos giris kontrolu yok. 
- Listelerken gereksiz bos bir kayit eklenmis sekilde gosteriyor.

Ekran: 20/20 (Ekran dagilimi guzel, combobox kullanmi arti)
Ogrenci Islemleri: 10/15 (Bos kayit kontrolu yok, listeleme gereksiz bos kayit gosterilmesi)
Polimorphism: 0/15
Dosyadan Okuma: 20/20 
Dosyaya Yazma:  20/20 
Genel Program: 5/10 (dizi kullanimi, max 10 kayit)
Bonus: 10/25 (Combobox kullanimi)
Benzer Kod Yazma Nedeniyle: -10 
--------------------------
SONUC: 75/125
 */
public class arayuz {

	private JFrame frame;
	private JTextField txtAd;
	private JTextField txtIndex;
	private JComboBox txtTip;
	private JComboBox txtBolum;
	static private JTextPane txtListe;
	
	private static String []ogrenciler = new String[10];
	
	private static int i = 0;

	/**
	 * Launch the application.
	 */
	public static void listele(){
		int j = 0;
		String liste = "";
		while(ogrenciler[j] != null){
			liste =  liste + (j+1) + " - " + ogrenciler[j] + "\n";
			j++;
		}
		txtListe.setText(liste);
	}
	
	public static void main(String[] args) {
		String str = "";
		
		try{
			
			FileInputStream fStream = new FileInputStream("Ogrenciler.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
			
			while((str = bReader.readLine()) != null){
				ogrenciler[i] = str;
				i++;
			}
			dStream.close();
		}catch(Exception e){
			System.err.println("Hata: " + e.getMessage());
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					arayuz window = new arayuz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public arayuz() {
		initialize();
		listele();
	}

	/**
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 310, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAd = new JLabel("\u00D6\u011Frencinin Ad\u0131:");
		lblAd.setBounds(20, 13, 158, 14);
		frame.getContentPane().add(lblAd);
		
		JLabel lblBolum = new JLabel("\u00D6\u011Frencin B\u00F6l\u00FCm\u00FC:");
		lblBolum.setBounds(20, 38, 158, 14);
		frame.getContentPane().add(lblBolum);
		
		JLabel lblTip = new JLabel("\u00D6\u011Frencinin Tipi:");
		lblTip.setBounds(20, 63, 158, 14);
		frame.getContentPane().add(lblTip);
		
		txtAd = new JTextField();
		txtAd.setBounds(188, 10, 86, 20);
		frame.getContentPane().add(txtAd);
		txtAd.setColumns(10);
		
		JButton btnYeni = new JButton("Yeni Kay\u0131t");
		btnYeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Ad = txtAd.getText();
				String Bolum = txtBolum.getSelectedItem().toString();
				String Tip = txtTip.getSelectedItem().toString();
				
				String yeni_kayit = Ad + " " + Bolum + " " + Tip;
				
				int x = 0; 
				// Dizinin sonunu bulmak i�in.
				while(ogrenciler[x] != null){
					x++;
				}
				ogrenciler[x] = yeni_kayit;
				
				
				
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter("Ogrenciler.txt"));
					for(int i = 0; i < (x+1); i++){
						writer.write(ogrenciler[i]);
						writer.newLine();
					}
					writer.close();
					
				}
				catch(Exception e){
					
				}
				JOptionPane.showMessageDialog(null, "��renci Eklendi.");
				listele();
				
				
				
			}
		});
		btnYeni.setBounds(20, 98, 127, 23);
		frame.getContentPane().add(btnYeni);
		
		JButton btnYenile = new JButton("Listeyi Yenile");
		btnYenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listele();
				JOptionPane.showMessageDialog(null, "Liste Yenilendi.");
				
			}
		});
		btnYenile.setBounds(147, 98, 127, 23);
		frame.getContentPane().add(btnYenile);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int silinecek = Integer.parseInt(txtIndex.getText());
				int x = 0;
				while(ogrenciler[x] != null){
					x++;
				}
				int son = x;
				for(int z=(silinecek-1); z<x; z++){
					ogrenciler[z] = ogrenciler[z+1];
				}
				
				
				
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter("Ogrenciler.txt"));
					for(int i = 0; i < (son+1); i++){
						writer.write(ogrenciler[i]);
						writer.newLine();
					}
					writer.close();
				}catch(Exception e){
					
				}
				
				JOptionPane.showMessageDialog(null, "��renci Silindi.");
				listele();
				
			}
		});
		btnSil.setBounds(188, 267, 86, 23);
		frame.getContentPane().add(btnSil);
		
		txtIndex = new JTextField();
		txtIndex.setToolTipText("Silinecek \u00D6\u011Frenci \u0130ndexi");
		txtIndex.setBounds(130, 268, 43, 20);
		frame.getContentPane().add(txtIndex);
		txtIndex.setColumns(10);
		
		txtListe = new JTextPane();
		txtListe.setEditable(false);
		txtListe.setBounds(20, 134, 254, 122);
		frame.getContentPane().add(txtListe);
		
		JLabel lblSilinecekNumara = new JLabel("Silinecek Numara:");
		lblSilinecekNumara.setBounds(20, 271, 111, 14);
		frame.getContentPane().add(lblSilinecekNumara);
		
		txtBolum = new JComboBox();
		txtBolum.setModel(new DefaultComboBoxModel(new String[] {"MYO", "\u0130\u015Fletme", "M\u00FChendislik", "Sosyal B\u00F6l\u00FCmler", "Fen Bilimleri", "Di\u011Fer."}));
		txtBolum.setToolTipText("MYO\r\nBilmemne\r\nXD");
		txtBolum.setMaximumRowCount(3);
		txtBolum.setBounds(188, 35, 86, 20);
		frame.getContentPane().add(txtBolum);
		
		txtTip = new JComboBox();
		txtTip.setModel(new DefaultComboBoxModel(new String[] {"Lisans", "Y\u00FCksek Lisans", "Doktora"}));
		txtTip.setBounds(188, 60, 86, 20);
		frame.getContentPane().add(txtTip);
	}
}
