package tr.edu.medipol.odev2.g6.nurcankarakulleoglu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.io.*;
import java.awt.SystemColor;
import javax.swing.JTextPane;


/** ozkans Degerlendirme

- Salih Terekli ile benzer ama birbirinden ayrilan yerler de var.
- Polimorfism yok.
- Turkce karakter sorunlari var.
- Hatali/bos giris kontrolu yok. 
- Listelerken gereksiz bos bir kayit eklenmis sekilde gosteriyor.

Ekran: 15/20
Ogrenci Islemleri: 10/15 (Bos kayit kontrolu yok, listeleme gereksiz bos kayit gosterilmesi)
Polimorphism: 0/15
Dosyadan Okuma: 20/20 
Dosyaya Yazma:  20/20 
Genel Program: 5/10 (dizi kullanimi, max 10 kayit)
Bonus: 0/25
Benzer Kod Yazma Nedeniyle: -15 
--------------------------
SONUC: 55/125
 */
public class odev2 {

	private JFrame frmIndex;
	private JTextField txtAdSoy;
	private JTextField txtOgrenciTip;
	private JTextField txtOgrenciBolumu;
	private JTextPane txtListe;

	/**
	 * Launch the application.
	 */
	
    private static String []ogrenciDizi = new String[15];
	
	private static int i = 0;
	private JTextField txtNumara;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					odev2 window = new odev2();
					window.frmIndex.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String str = "";
		try{
			
			FileInputStream file = new FileInputStream("Ogrenciler.txt");
			DataInputStream data = new DataInputStream(file);
			BufferedReader okuyucu = new BufferedReader(new InputStreamReader(data));
			
			while((str = okuyucu.readLine()) != null){
				ogrenciDizi[i] = str;
				i++;
			}
			data.close();
		}
		catch(Exception e)
		{
			System.err.println("Hata: " + e.getMessage());
		}
	}

	/**
	 * Create the application.
	 */
	public odev2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIndex = new JFrame();
		frmIndex.setTitle("\u00D6\u011Frenci Ekleme, Silme, Kaydetme ve Listeleme Aray\u00FCz\u00FC");
		frmIndex.setBounds(100, 100, 600, 328);
		frmIndex.getContentPane().setLayout(null);
		frmIndex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnSil = new JButton("\u00D6\u011Frenci Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int delete = Integer.parseInt(txtNumara.getText());
				int sayac = 0;
				while(ogrenciDizi[sayac] != null){
					sayac++;
				}
				
				for(int z=delete; z<sayac; z++){
					ogrenciDizi[z] = ogrenciDizi[z+1];
				}
				
				FileWriter file= null;
				BufferedWriter writer = null;
				try{
					file= new FileWriter("Ogrenciler.txt");
					writer = new BufferedWriter(file);
					for(int i = 0; i < (sayac+1); i++){
						writer.write(ogrenciDizi[i]);
						writer.newLine();
					}
					writer.close();
					
					
				}
				catch(Exception E){
					
					String Liste = "";
					int ogrenciListesi = 0;
					
					while(ogrenciDizi[ogrenciListesi] != null){
						Liste = Liste + "("+ ogrenciListesi + ") "+ ogrenciDizi[ogrenciListesi] + "\n";
						ogrenciListesi++;
						
					}
					txtListe.setText(Liste);
					
				}
				}
					
				
			});
		
		JButton btnEkle = new JButton("\u00D6\u011Frenci Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				String adSoyad = txtAdSoy.getText();
				
				String tip = txtOgrenciTip.getText();
				
				String bolum = txtOgrenciBolumu.getText();
				
				String yeni =bolum +" "+"b�l�m� "+" "+ tip+" "+"��rencisi"+" "+adSoyad;
				
				JOptionPane.showMessageDialog(btnEkle, bolum +" "+"b�l�m� "+" "+ tip+" "+"��rencisi"+" "+adSoyad+" "+ "isimli ��renci eklendi");
				
				int kayit = 0; 
				
				while(ogrenciDizi[kayit] != null){
					kayit++;
				}
				ogrenciDizi[kayit] = yeni;
				
				FileWriter file = null;
				BufferedWriter writer = null;
				try{
					file = new FileWriter("Ogrenciler.txt");
					writer = new BufferedWriter(file);
					for(int i = 0; i < (kayit+1); i++){
						writer.write(ogrenciDizi[i]);
						writer.newLine();
					}
					writer.close();
				}
				catch(Exception E){
					
					
					
				}
				
				
			}
		});
		btnEkle.setBounds(10, 29, 136, 23);
		frmIndex.getContentPane().add(btnEkle);
		btnSil.setBounds(10, 167, 136, 23);
		frmIndex.getContentPane().add(btnSil);
		
		JButton btnListele = new JButton("\u00D6\u011Frenci Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Liste = "";
				int ogrenciListesi = 0;
				
				while(ogrenciDizi[ogrenciListesi] != null){
					Liste = Liste + "("+ ogrenciListesi + ") "+ ogrenciDizi[ogrenciListesi] + "\n";
					ogrenciListesi++;
					
				}
				txtListe.setText(Liste);
			}
		});
		btnListele.setBounds(10, 63, 136, 23);
		frmIndex.getContentPane().add(btnListele);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnCikis.setBounds(10, 211, 136, 23);
		frmIndex.getContentPane().add(btnCikis);
		
		JLabel lblAdSoy = new JLabel("Ad\u0131n\u0131z ve Soyad\u0131n\u0131z");
		lblAdSoy.setBounds(174, 33, 117, 14);
		frmIndex.getContentPane().add(lblAdSoy);
		
		JLabel lbltip = new JLabel("\u00D6\u011Frenci Tipi(YL,Doktora vb)");
		lbltip.setBounds(174, 67, 186, 14);
		frmIndex.getContentPane().add(lbltip);
		
		JLabel lblBolum = new JLabel("\u00D6\u011Frenci B\u00F6l\u00FCm\u00FC(MYO, \u0130\u015Fletme vb)");
		lblBolum.setBounds(174, 101, 195, 14);
		frmIndex.getContentPane().add(lblBolum);
		
		txtAdSoy = new JTextField();
		txtAdSoy.setBounds(370, 30, 185, 20);
		frmIndex.getContentPane().add(txtAdSoy);
		txtAdSoy.setColumns(10);
		
		txtOgrenciTip = new JTextField();
		txtOgrenciTip.setBounds(370, 64, 185, 20);
		frmIndex.getContentPane().add(txtOgrenciTip);
		txtOgrenciTip.setColumns(10);
		
		txtOgrenciBolumu = new JTextField();
		txtOgrenciBolumu.setBounds(370, 98, 185, 20);
		frmIndex.getContentPane().add(txtOgrenciBolumu);
		txtOgrenciBolumu.setColumns(10);
		
	    txtListe = new JTextPane();
		txtListe.setBackground(SystemColor.menu);
		txtListe.setBounds(174, 131, 400, 147);
		frmIndex.getContentPane().add(txtListe);
		
		JLabel lblSilmekIin = new JLabel("Silmek i\u00E7in");
		lblSilmekIin.setBounds(10, 104, 68, 14);
		frmIndex.getContentPane().add(lblSilmekIin);
		
		JLabel lblrenciNumaras = new JLabel("\u00D6\u011Frenci Numaras\u0131 Girin");
		lblrenciNumaras.setBounds(10, 118, 136, 14);
		frmIndex.getContentPane().add(lblrenciNumaras);
		
		txtNumara = new JTextField();
		txtNumara.setBounds(10, 137, 136, 20);
		frmIndex.getContentPane().add(txtNumara);
		txtNumara.setColumns(10);
	}
}
