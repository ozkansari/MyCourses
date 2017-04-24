package tr.edu.medipol.odev2.g1.gurkanertas;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

/** ozkans Degerlendirme

Firat Koc ile benzer. Oldukca refactor edilip degistirilmis ama genel mantik hic degismemis.

Ekran: 15/20
Ogrenci Islemleri: 15/15
Polimorphism: 10/15 (Polimorfism var ama kullanilmamis, liste kullanilmis. Dosyaya yazarken de liste olarak yazilip okunmus.)
Dosyadan Okuma: 15/20
Dosyaya Yazma:  15/20
Genel Program: 5/10
Bonus:0/25
Benzer Kod Yazma Nedeniyle: -30
--------------------------
SONUC: 45/125
 */
public class MenuOrnegi  extends JFrame implements ActionListener  {

	public static Scanner ekranOkuyucu = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MenuOrnegi ekran = new MenuOrnegi();
		ekran.setTitle("��renci Otomasyon Sistemi");
		ekran.setSize(500, 600);
		ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekran.setResizable(false);
		ekran.setVisible(true);
		
		while(true) {
			ekranaMenuyuBas();
			
			System.out.println("Secim yapiniz: ");
			int kullaniciSecimi = kullaniciIntegerGirdiAl();		
			System.out.println(kullaniciSecimi + " sectiniz.");
			switch (kullaniciSecimi) {
				case 1: 
					ogrenciEklemeIslemi();
					break;
				case 2: 
					ogrenciSilmeIslemi();
					break;
				case 3: 
					ogrencileriEkranaBas();
					break;
				case 4: 
					System.out.println("Program sonlaniyor.");
					ekranOkuyucu.close();
					System.exit(0);
					break;
				default:
					System.out.println("Gecersiz secim");
					break;
			}
		}
		
	}
	/**
	 * @return
	 */
	public static Integer kullaniciIntegerGirdiAl() {
		String kullaniciGirisi = "";
		int girdi = -1;
		try {
			kullaniciGirisi = ekranOkuyucu.nextLine();
			girdi = Integer.valueOf( kullaniciGirisi );
		} catch(Exception e) {
			System.out.println("Gecerli bir deger giriniz. Girdiginiz deger: " 
					+ kullaniciGirisi);
		}
		return girdi;
	}
	
	public static void ogrenciSilmeIslemi() {
		ogrencileriEkranaBas();
		System.out.print("Numara :");
		int kullaniciSecimi = kullaniciIntegerGirdiAl();
				
		List<String> stringOgrenciliste = new ArrayList<>();
		
		List<Ogrenci> ogrenciYeniListe = new ArrayList<>();
		
		for (Ogrenci ogrenci : ogrenciListesi2) {
			if(ogrenci.numara != kullaniciSecimi)
			{
				ogrenciYeniListe.add(ogrenci);
				stringOgrenciliste.add(ogrenci.adSoyad+"   "+"  Bolum:"+ogrenci.bolum+"   "+ogrenci.ogrenciTipiniAl()+" Numara:"+ogrenci.numara+" "+"\n");
			}
		}
		ogrenciListesi2 = null;
		ogrenciListesi2 = ogrenciYeniListe;
		dosya_yaz(stringOgrenciliste);	
	}
	
	
	public static String ogrenciSilmeIslemi(int kullaniciSecimi) {
				
		List<String> stringOgrenciliste = new ArrayList<>();
		
		List<Ogrenci> ogrenciYeniListe = new ArrayList<>();
		
		for (Ogrenci ogrenci : ogrenciListesi2) {
			if(ogrenci.numara != kullaniciSecimi)
			{
				ogrenciYeniListe.add(ogrenci);
				stringOgrenciliste.add(ogrenci.adSoyad+"   "+"  Bolum:"+ogrenci.bolum+"   "+ogrenci.ogrenciTipiniAl()+" Numara:"+ogrenci.numara+" "+"\n");
			}
		}
		ogrenciListesi2 = ogrenciYeniListe;
		dosya_yaz(stringOgrenciliste);	
		return "Silme i�lemi Ba�ar�l�";
	}
	
	
	public static void dosya_yaz(List<String> stringOgrenciListesi){	
		try{
			   File file = new File("ogrenci.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }
		        FileWriter fileWriter = new FileWriter(file, false);
		        BufferedWriter bWriter = new BufferedWriter(fileWriter);	
		        StringBuilder b = new StringBuilder();
		        stringOgrenciListesi.forEach(b::append);        
		        bWriter.write(b.toString());
		        bWriter.close(); 
		 }
		 catch(Exception ex){
				System.out.println("Hata olustu l�tfen daha sonra tekrar deneyiniz.");
		 }    
	}
	public static List<String> oku_geriye_liste_don(){
		try {
			List<String> stringOgrenciListesi = new ArrayList<>();
			  File file = new File("ogrenci.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }
			FileReader fileReader = new FileReader(file);
			String line;

			BufferedReader br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null) {
				String l_line = line + "\n";
				stringOgrenciListesi.add(l_line);
			}
			br.close();
			return stringOgrenciListesi;
		} catch (Exception e) {
			System.out.println("Hata olustu l�tfen daha sonra tekrar deneyiniz.");
			return (new ArrayList<String>());
		}
		
		
	}
	public static void okuVeYaz(Ogrenci ogrenci){		
		String gelenOgrenciString = ogrenci.adSoyad+"   "+"  Bolum:"+ogrenci.bolum+"   "+ogrenci.ogrenciTipiniAl()+" Numara:"+ogrenci.numara+" ";

		List<String> eski_liste = oku_geriye_liste_don();
		
		List<String> yeni_liste = eski_liste;
		
		yeni_liste.add(gelenOgrenciString);
		dosya_yaz(yeni_liste);
	}
	
	public static void dosya_oku(){
		try {
			  File file = new File("ogrenci.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }
			FileReader fileReader = new FileReader(file);
			String line;
			BufferedReader br = new BufferedReader(fileReader);
			while ((line = br.readLine()) != null) {
				String l_line = line + "\n";
				System.out.println(l_line);
			}
			br.close();
		} catch (Exception e) {	
			System.out.println("Hata olustu l�tfen daha sonra tekrar deneyiniz.");
		}
	}
	

	public static List<Ogrenci> ogrenciListesi2 = 
			new ArrayList<>();
	
	public static void ogrenciEklemeIslemi() {
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();
		
		System.out.print("Numarasi : ");
		int numara = kullaniciIntegerGirdiAl();

		System.out.print("Ogrenci Tip Giriniz (YL, Doktora vb.) : "); // 
		String ogrenciTipi = ekranOkuyucu.nextLine();
		
		System.out.print("Ogrenci Bolum Giriniz (MYO, Isletme vb..) : ");
		String bolum = ekranOkuyucu.nextLine();
		
		
		
		Ogrenci yeniOgrenci = null;
		if (ogrenciTipi.equals("YL")) {
			yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum,numara);
		} else if (ogrenciTipi.equals("Doktora")) {
			yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum,numara);
		} 

		if (yeniOgrenci != null) {
			ogrenciListesi2.add(yeniOgrenci);
			System.out.println(adSoyad + " isimli ogrenci eklendi.");
			okuVeYaz(yeniOgrenci);
			
			
		} else {
			System.out.println("Gecersiz ogrenci bolumu");
		}
			
	}
	
	
	public static String ogrenciEklemeIslemi(String adSoyad,int numara,String ogrenciTipi,String bolum) {
				
		Ogrenci yeniOgrenci = null;
		if (ogrenciTipi.equals("YL")) {
			yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum,numara);
		} else if (ogrenciTipi.equals("Doktora")) {
			yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum,numara);
		} 

		if (yeniOgrenci != null) {
			ogrenciListesi2.add(yeniOgrenci);
			
			okuVeYaz(yeniOgrenci);		
			return adSoyad + " isimli ogrenci eklendi.";
		} else {
			return "Gecersiz ogrenci bolumu";
		}

	}
	
	public static void ogrencileriEkranaBas() {
		dosya_oku();
	}

	public static void ekranaMenuyuBas() {
		System.out.println("************************");
		System.out.println("MENU");
		System.out.println("(1) Ogrenci Ekle");
		System.out.println("(2) Ogrenci Sil");
		System.out.println("(3) Ogrencileri Listele");
		System.out.println("(4) Cikis");
		System.out.println("************************");
	}

	private JButton ekleButonu = new JButton("Ekle");
	private JButton silButonu = new JButton("Sil");
	private JButton listeleButonu = new JButton("Listele");
	private JTextField ogrenciAdi = new JTextField();	
	private JTextField ogrenciSoyadi = new JTextField();	
	private JTextField ogrenciBolumu = new JTextField();	
	private JTextField ogrenciTipi = new JTextField();	
	private JTextField ogrenciNumara = new JTextField();	
	private JTextField ogrenciNumara2 = new JTextField();	
	private JLabel v22 = new JLabel();	

	private JTextField ogrenciNumarasi = new JTextField();	

	private JTextArea mesajAlani = new JTextArea();	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		 
		mesajAlani.setText(ogrenciAdi.getText());
	}
	public  MenuOrnegi() {
		ekleButonu.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  mesajAlani.setText(ogrenciEklemeIslemi(ogrenciAdi.getText(), Integer.parseInt(ogrenciNumara.getText()),ogrenciTipi.getText(),ogrenciBolumu.getText()));
	      }
	    });
		silButonu.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	 mesajAlani.setText(ogrenciSilmeIslemi(Integer.parseInt(ogrenciNumara2.getText())));

	      }
	    });
		listeleButonu.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	  		 List<String> liste = oku_geriye_liste_don();
	  		 
	  		 String icerik="";
	  		
	  		 for (String string : liste) {
	  			 icerik+= string;
			}
	  		 mesajAlani.setText(icerik);
	  		 
	      }
	    });
		
		mesajAlani.setEditable(false);
		setLayout(new GridLayout(5, 1));
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel2 = new JPanel();
		add(panel2);
		
		
		JPanel panel3 = new JPanel();
		add(panel3);
		
		JPanel panel4 = new JPanel();
		add(panel4);
		
		add(mesajAlani);
		
		panel.setLayout(new GridLayout(6, 2)); // 2x2 grid
		panel.add( new JLabel("Ogrenci adi: ")); // 1. satir 1. sutun
		panel.add(ogrenciAdi);
		
		panel.add(new JLabel("Ogrenci Soyadi: "));
		panel.add(ogrenciSoyadi);
		
		panel.add(new JLabel("Ogrenci Tipi(YL,Doktora): "));
		panel.add(ogrenciTipi);
		
		panel.add(new JLabel("Ogrenci Numarasi: "));
		panel.add(ogrenciNumara);

		panel.add(new JLabel("Ogrenci B�l�m(MYO): "));
		panel.add(ogrenciBolumu);
		
		panel.add( new JLabel("")); // 2. satir 1. sutun
		panel.add( ekleButonu);  // 2. satir 2. sutun
		
		 
		
		panel2.setLayout(new GridLayout(2,2));
		panel2.add( new JLabel("Ogrenci Numarasi: ")); // 1. satir 1. sutun
		panel2.add( ogrenciNumara2);  // 2. satir 2. sutun

		panel2.add( silButonu);  // 2. satir 2. sutun

		panel3.setLayout(new GridLayout(1,1));
		panel2.add( listeleButonu);  // 2. satir 2. sutun
		
	}
	
}
