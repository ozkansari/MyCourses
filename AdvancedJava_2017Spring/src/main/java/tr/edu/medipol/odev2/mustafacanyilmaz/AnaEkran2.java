package tr.edu.medipol.odev2.mustafacanyilmaz;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

/** ozkans Degerlendirme

Ekran: 20/20
Ogrenci Islemleri: 5/15 (silme hatali)
Polimorphism: 0/15 (Yok)
Dosyadan Okuma: 15/20 (Program acildiginda dosya okunsa daha iyi olabilir, Dosya dizini yokken de calisabilmeli)
Dosyaya Yazma:  20/20
Genel Program: 5/10 (Bos/hatali giris kontrolu eklenmeli: combo giris daha iyi olabilir)
Bonus:25/25
--------------------------
SONUC: 90/125
 */
public class AnaEkran2 extends JFrame implements ActionListener  {
	public static ArrayList<String> Listem = new ArrayList<String>();	
	public static String dosyaminYolu = ".//config//Verilerimiz2.txt";
	public static File veriDosyasi = new File(dosyaminYolu);
	//public static List<String> dizi = new ArrayList<String>();
	public static String satir;
	public static String[] dizimiz;
	public static List<Ogrenci> ogrenciListesi = new ArrayList<>();

	// BUTONLARIM
	public static JButton ekleButonu = new JButton("Öğrenci Ekle");
	public static JButton silButonu = new JButton("Öğrenci Sil");
	public static JButton listeleButonu = new JButton("Öğrencileri Listele");
	public static JButton cikisButonu = new JButton("Çıkış !");
	public static JButton yardimButonu = new JButton("Yardim ! ");
	
	public static JButton ekraniTemizle = new JButton("Ekrani Temizle");
	public static JButton dosyadanVeriAl = new JButton("Dosyadan Veri AL");
	public static JButton diziyiTemizle = new JButton("Diziyi Temizle");
	public static JButton dosyaKontrolButonu = new JButton("Dosyayi Kontrol ET ! ");
	
	//TEXTV�EWLER
	public JTextField ogrenciAdiEkle = new JTextField();	
	public JTextField ogrenciTipiEkle = new JTextField();
	public JTextField ogrenciBolumEkle = new JTextField();
	
	public JTextField ogrenciSil = new JTextField();
	public JTextField ogrenciListele =  new JTextField();
	public static JTextField mesajAlani = new JTextField();
	public JTextArea  mesajAlani2 = new JTextArea();
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	public AnaEkran2(){
		yardimButonu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mesajAlani2.append("Programımıza HOŞGELDİNİZ \n");
				mesajAlani2.append("1. Adim : Verilerinizin Kayit Edileceği Dosyayi Kontrol Ediniz. \"Dosyayi Kontrol ET ! \" Butonuna Basiniz. \n");
				mesajAlani2.append("2. Adim : Dosyaya Veri Eklemek İçin \"Öğrenci Adini\", \"Öğrenci Tipini\", \"Öğrenci Bölümünü \" Girip Öğrenci Ekle Butonuna Basiniz.\n");
				mesajAlani2.append("3. Adim : Dosyadan Veri Silmek İçin Önce Öğrenci Listele Butonuna Basiniz.\n Ardindan"
						+ " \"Silmek İstediğiniz Öğrencinin Satirini Kopyalayip\" İnputText'e Giriniz, Öğrenci Sil Butonuna Basiniz. \n");
				mesajAlani2.append("4. Adim : Eğer Öğrenci Listele Butonuna Basildiğinda \"Üzgünüm Listen BOŞ, Önce Dosyadan Veriyi Almalısın \"\n"
						+ "Mesaji İle Karşılaşıyorsaniz Ayni İşlemi \"Dosyadan Veri Al\" Butonuna Basip Tekrarlayiniz.\n ");
				mesajAlani2.append("\n");
				mesajAlani2.append("ÖNEMLİ NOT : DOSYADAN VERİ AL BUTONUNA SADECE İLK AÇILIŞTA TIKLAYINIZ,AKSİ TAKTİRDE VERİ TEKRAR DİZİYE YAZILIR.\n"
						+ " BU DURUMDA \" DİZİYİ TEMİZLE BUTONUNA TIKLAYIP ARDINDAN SADECE 1 KEZ DOSYADAN VERİ AL BUTONUNA TIKLAYINIZ.\" \n");
				mesajAlani2.append("Design By \"Mustafa Can YILMAZ\" ");
			}
		});
		 
		ekleButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Listem.add("Öğrencinin Adi : " + ogrenciAdiEkle.getText() + " Öğrencinin Tipi : " +  ogrenciTipiEkle.getText() + " Öğrencinin Bölümü " + ogrenciBolumEkle.getText());
				try {
					for(int i = 0; i<Listem.size(); i++){
						BufferedWriter yazici = new BufferedWriter(new FileWriter (veriDosyasi));
						for (String a : Listem) {
							yazici.write(a);
							yazici.newLine();
						}
						yazici.close();	
					}
				} 	catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
					}
				
				/*
				
					for(int i =0; i<Listem.size(); i++){
					
						String ogrenciTipi = ogrenciTipiEkle.getText();
				        String bolum = ogrenciBolumEkle.getText();
				        
				        Ogrenci yeniOgrenci = null;
				        if (ogrenciTipi.equals("YL")) {
				            yeniOgrenci = new YuksekLisansOgrencisi("Mustafa",dizimiz[i] , bolum);
				        } 
				        else if (ogrenciTipi.equals("yl")) {
				            yeniOgrenci = new YuksekLisansOgrencisi("Mustafa",dizimiz[i], bolum);
				        } 
				        else if (ogrenciTipi.equals("DOKTORA")) {
				            yeniOgrenci = new DoktoraOgrencisi(dizimiz[i], bolum);
				        }
				        else if (ogrenciTipi.equals("Doktora")) {
				            yeniOgrenci = new DoktoraOgrencisi(dizimiz[i], bolum);
				        }
				        if (yeniOgrenci != null) {
				        	ogrenciListesi.add(yeniOgrenci);
				            System.out.println(dizimiz[i] + " isimli ogrenci eklendi.");
				        } else {
				            System.out.println("Lütfen büyük küçük harf duyarli giriniz");
				        }
						
					}
					*/
				mesajAlani.setText("Öğrencinin Adı : " + ogrenciAdiEkle.getText() + " Öğrencinin Tipi "  + ogrenciTipiEkle.getText() + " Öğrencinin Bölümü " +ogrenciBolumEkle.getText() +  " Başarıyla  Eklendi");
				
			}
		});
		
		silButonu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Listem Bu  : " + Listem);
				for(int i = 0; i<Listem.size(); i++){
					// ozkans Bu kontrol hatali
					if(ogrenciSil.getText().equals(Listem.get(i))){
						Listem.remove(i);
					}
				}
			
				System.out.println("Silindikten Sonraki hali : " + Listem);
				try {
						BufferedWriter yazici = new BufferedWriter(new FileWriter (veriDosyasi));
						for (String a : Listem) {
							yazici.write(a);
							yazici.newLine();
						}
						yazici.close();	
					
				} 	catch (IOException e1) {
				e1.printStackTrace();
					}
			}
		});
		
		listeleButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
				File f = new File(dosyaminYolu);
				FileReader fr;
				fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				
			} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			}
				
				System.out.println(Listem);
				
				Scanner fileScanner = null;
				try {
					fileScanner = new Scanner(veriDosyasi);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mesajAlani2.append("Listenizdeki Öğrenciler Sırasıyla :\n" );
				while(fileScanner.hasNextLine()){
					mesajAlani2.append(fileScanner.nextLine() + "\n ");
				}
				if(Listem.isEmpty()){
					mesajAlani2.setText("Üzgünüm Listen BOŞ, Önce Dosyadan Veriyi Almalısın ");
				}
			}
		});
		cikisButonu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		dosyaKontrolButonu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(veriDosyasi.exists()){
					mesajAlani.setText("Dosya Dizini  = " + veriDosyasi.getAbsolutePath());
					mesajAlani.setText("Dosya Kontrolu Yapıldı, Dosya Yazılmaya Hazır. DOSYA ADI  = " + veriDosyasi.getName());
				}else{
					mesajAlani.setText("Dosya YOK ! ");
				}
			}
		});
		
		dosyadanVeriAl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					File f = new File(dosyaminYolu);
					FileReader fr;
					fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr);
					try {
						if(satir==null){
							mesajAlani.setText("Şuanda Dosyanizda Herhangi Bir Veri YOK ! ");
						}
						//Bos satir olana kadar oku
							while ((satir = br.readLine()) != null) {	
							Listem.add(satir);
							mesajAlani.setText("Txt Dosyanizdan Veriler Başarıyla Dizinize Aktarildi." );
							}
				} catch (IOException e1) {
				e1.printStackTrace();
				}
				 
				} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				}
				
				
				
			}
		});
		diziyiTemizle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Listem.isEmpty()){
					mesajAlani.setText("Dizi Zaten Boş " );
				}else{
					Listem.clear();
					mesajAlani.setText("Dizi Temizlendi " );
				}
			
			}
		});
		ekraniTemizle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mesajAlani.setText("");
				mesajAlani2.setText("");
				
			}
		});
		
		
		mesajAlani.setEditable(false);
		mesajAlani2.setEditable(true);
		setLayout(new GridLayout(3,1));
		JPanel panel = new JPanel();
		add(panel);
		add(mesajAlani);
		add(mesajAlani2);
	
		
		panel.setLayout(new GridLayout(10,1)); 
		panel.add(dosyaKontrolButonu);
		panel.add(yardimButonu);
		panel.add(cikisButonu);
		panel.add(new JLabel(" "));
		panel.add(new JLabel(" "));
		panel.add(new JLabel(" "));
		
		panel.add(new JLabel("Öğrenci Adini Giriniz :")); 
		panel.add(ogrenciAdiEkle); 
		panel.add(new JLabel(""));
		panel.add(new JLabel("Öğrenci Tipi Giriniz :  ( YL, Doktora )"));
		panel.add(ogrenciTipiEkle);
		panel.add(new JLabel(" "));
		panel.add(new JLabel("Öğrenci Bolum Giriniz : ( Eczacilik, Myo ) "));
		panel.add(ogrenciBolumEkle);
		panel.add(new JLabel(" "));
		panel.add(new JLabel(" "));
		panel.add(ekleButonu);
		panel.add(new JLabel(" "));
		
		panel.add(new JLabel(" "));
		panel.add(new JLabel(" "));
		panel.add(new JLabel(" "));
		
		
		panel.add( new JLabel("Silinecek Ogrenciyi Giriniz :"));
		panel.add(ogrenciSil);
		panel.add(silButonu);
		
		panel.add(ekraniTemizle);
		panel.add( new JLabel("")); 
		panel.add( new JLabel("")); 
		
		panel.add(diziyiTemizle);
		panel.add(dosyadanVeriAl);
		panel.add(listeleButonu);

	}
	
	public static void main(String[] args) {
		AnaEkran2 ekran = new AnaEkran2();
		ekran.setTitle("Öğrenci İslemleri");
		ekran.setSize(800, 600);
		ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekran.setResizable(false);
		ekran.setVisible(true);
		
	}
}
