package tr.edu.medipol.odev2.g1.firatkoc;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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

/** ozkans Degerlendirme

Gurkan Ertas ile benzer. Oldukca refactor edilip degistirilmis ama genel mantik hic degismemis.

Ekran: 15/20
Ogrenci Islemleri: 15/15
Polimorphism: 10/15 (Polimorfism var ama kullanilmamis, liste kullanilmis. Dosyaya yazarken de liste olarak yazilip okunmus.)
Dosyadan Okuma: 15/20
Dosyaya Yazma:  15/20
Genel Program: 5/10
Bonus:0/25
Benzer Kod Yazma Nedeniyle: -25
--------------------------
SONUC: 50/125
 */
public class MenuOrnegi   extends JFrame implements ActionListener{

	private static Scanner ekranOkuyucu = new Scanner(System.in);
	
	
	public static void showGUI(){
		MenuOrnegi ekran = new MenuOrnegi();
		ekran.setTitle("FIRAT KO�");
		ekran.setSize(800,800);
		ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekran.setResizable(false);
		ekran.setVisible(true);
	}
	
	public static void main(String[] args) {
		showGUI();
		while(true) {
			ekranaMenuyuBas();
			
			System.out.println("Secim yapiniz: ");
			int kullaniciSecimi = kullaniciIntegerGirdiAl();
		
			System.out.println(kullaniciSecimi + " sectiniz.");

			switch (kullaniciSecimi) {
			case 1: // (1) Ogrenci Ekle
				ogrenciEklemeIslemi();
				break;
			case 2: // (2) Ogrenci Sil
				ogrenciSilmeIslemi();
				break;
			case 3: // (3) Ogrencileri Listele
				oku(true);
				//ogrenciListelemeIslemi();
				break;
			case 0: // (0) Cikis
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
	private static Integer kullaniciIntegerGirdiAl() {
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
	
	private static void ogrenciSilmeIslemi() {
		System.out.println("Silmek istediginiz ogrenci numarasini seciniz: ");
		ogrencileriEkranaBas();
		System.out.print("Numara seciminiz: ");
		int kullaniciSecimi = kullaniciIntegerGirdiAl();
				
		List<String> liste = new ArrayList<>();
		List<Ogrenci> ogrenciListesi = new ArrayList<>();
		for (Ogrenci ogr : ogrenciListesi2) {
			if(ogr.numara == kullaniciSecimi)
			{
				
			}
			else{
				ogrenciListesi.add(ogr);
				liste.add(ogr.adSoyad+" "+" Numara:"+ogr.numara+" "+ogr.bolum+" "+ogr.ogrenciTipiniAl()+"\n");
			}
		}
		ogrenciListesi2 = ogrenciListesi;
		yaz(liste);
		
	}
	
	private String ogrenciSilmeIslemi2(int parseInt) {
		// TODO Auto-generated method stub
		int kullaniciSecimi = parseInt;
				
		List<String> liste = new ArrayList<>();
		List<Ogrenci> ogrenciListesi = new ArrayList<>();
		for (Ogrenci ogr : ogrenciListesi2) {
			if(ogr.numara == kullaniciSecimi)
			{
				
			}
			else{
				ogrenciListesi.add(ogr);
				liste.add(ogr.adSoyad+" "+" Numara:"+ogr.numara+" "+ogr.bolum+" "+ogr.ogrenciTipiniAl()+"\n");
			}
		}
		ogrenciListesi2 = ogrenciListesi;
		yaz(liste);
		
		
		
		return "��RENC� �SLME ��LEM� BA�ARILI.";
	}
	
	private static void yaz(List<String> liste){	
		try{
			   File file = new File("dosya.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }

		        FileWriter fileWriter = new FileWriter(file, false);
		        BufferedWriter bWriter = new BufferedWriter(fileWriter);
		        String fullStr = "";
		        
		        for (String str : liste) {
		        	fullStr += str;
				}
		        bWriter.write(fullStr);
		        bWriter.close(); 
		 }
		 catch(Exception ex){
			 System.out.println("Hata yakaladi." + ex.toString());
		 }    
	}
	private static List<String> oku(boolean yontem){
		try {
			List<String> ogr_listesi = new ArrayList<>();
			  File file = new File("dosya.txt");
		        if (!file.exists()) {
		            file.createNewFile();
		        }
			FileReader fileReader = new FileReader(file);
			String line;

			BufferedReader br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null) {
				ogr_listesi.add(line+"\n");
				if(yontem)
					System.out.println(line);
			}
			br.close();
			return ogr_listesi;
		} catch (Exception e) {
		
			System.out.println("Hata yakadi.");
			// TODO: handle exception
			return null;
		}
		
	}

	private static void okuVeYaz(Ogrenci ogrenci){
		List<String> a  = new ArrayList<>();
		a.add(ogrenci.adSoyad+" "+" Numara:"+ogrenci.numara+" "+ogrenci.bolum+" "+ogrenci.ogrenciTipiniAl());

		List<String> b = oku(false);
		
		List<String> c = new ArrayList<>();
		
		String fullStr = "";
		for (String string : b) {
			c.add(string);
		}
		for (String string : a) {
			c.add(string);
		}
		
		yaz(c);
	}

	private static List<Ogrenci> ogrenciListesi2 = 
			new ArrayList<>();
	
	private static void ogrenciEklemeIslemi() {
		System.out.print("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();

		System.out.print("Ogrenci Tip Giriniz (YL, Doktora vb.) : "); // 
		String ogrenciTipi = ekranOkuyucu.nextLine();
		
		System.out.print("Ogrenci Bolum Giriniz (MYO, Isletme vb..) : ");
		String bolum = ekranOkuyucu.nextLine();
		
		System.out.print("Numarasi : ");
		int numara = kullaniciIntegerGirdiAl();
		
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
	
	private String ogrenciEklemeIslemi2(String adSoyad, String ogrenciTipi, String bolum,int numara) {
		// TODO Auto-generated method stub			 
		Ogrenci yeniOgrenci = null;
		if (ogrenciTipi.equals("YL")) {
			yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum,numara);
		} else if (ogrenciTipi.equals("Doktora")) {
			yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum,numara);
		} 

		if (yeniOgrenci != null) {
			ogrenciListesi2.add(yeniOgrenci);
			okuVeYaz(yeniOgrenci);
			return ""+adSoyad + " isimli ogrenci eklendi.";

		} else {
			return "Gecersiz ogrenci bolumu";
		}
	}
	
	private static void ogrencileriEkranaBas() {
		oku(true);
	}

	private static void ekranaMenuyuBas() {
		System.out.println("************************");
		System.out.println("MENU");
		System.out.println("(1) Ogrenci Ekle");
		System.out.println("(2) Ogrenci Sil");
		System.out.println("(3) Ogrencileri Listele");
		System.out.println("(0) Cikis");
		System.out.println("************************");
	}
	

	
	private JTextField ad = new JTextField();	
	private JTextField soyad = new JTextField();	
	private JTextField tip = new JTextField();	
	private JTextField numara = new JTextField();	
	private JTextField numara2 = new JTextField();	
	private JTextField bolum = new JTextField();	


	private JTextField ogrenciNumarasi = new JTextField();	

	private JTextArea mesajAlani = new JTextArea();	
		
	private JButton ekle = new JButton("��renci Ekle");
	private JButton goster = new JButton("��rencileri G�ster");
	private JButton sil = new JButton("��renci Sil");

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
	
	public  MenuOrnegi() {
		ekle.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  mesajAlani.setText(ogrenciEklemeIslemi2(ad.getText(),tip.getText(),bolum.getText(),Integer.parseInt(numara.getText())));
	      }
	    });
		sil.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	 mesajAlani.setText(ogrenciSilmeIslemi2(Integer.parseInt(numara2.getText())));

	      }
	    });
		goster.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	  		 List<String> ogr_liste = oku(false);
	  		 
	  		 String metin="";
	  		
	  		 for (String string : ogr_liste) {
	  			metin += string;
			}
	  		 mesajAlani.setText(metin);
	  		 
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
		
		panel.setLayout(new GridLayout(7, 2)); // 2x2 grid
		panel.add( new JLabel(" adi: ")); // 1. satir 1. sutun
		panel.add(ad);
		
		panel.add(new JLabel(" Soyadi: "));
		panel.add(soyad);
		
	
		panel.add(new JLabel(" Numarasi: "));
		panel.add(numara);

		panel.add(new JLabel(" B�l�m( MYO.Isletme...): "));
		panel.add(bolum);
		panel.add(new JLabel(" Tipi(YL,Doktora): "));
		panel.add(tip);
		
		panel.add( new JLabel("")); // 2. satir 1. sutun
		panel.add( ekle);  // 2. satir 2. sutun
			
		panel2.setLayout(new GridLayout(2,2));
		panel2.add( new JLabel("Ogrenci Numarasi: ")); // 1. satir 1. sutun
		panel2.add( numara2);  // 2. satir 2. sutun

		panel2.add( sil);  // 2. satir 2. sutun

		panel3.setLayout(new GridLayout(3,1));
		panel2.add( goster);  // 2. satir 2. sutun
		
	}
	
}