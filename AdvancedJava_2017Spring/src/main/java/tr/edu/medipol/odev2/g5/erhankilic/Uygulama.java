package tr.edu.medipol.odev2.g5.erhankilic;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class Uygulama extends JFrame implements ActionListener  {
	
	private JButton EKLE = new JButton("EKLE");
	private JButton SIL = new JButton("S�L");
	private JButton OGRENCILER = new JButton("L�STELE");
	private JTextField OGRENCIAD = new JTextField();	
	private JTextField OGRENCISOYAD = new JTextField();	
	private JTextField OGRENCITC = new JTextField();	
	private JTextField OGRENCIBOLUM = new JTextField();
	private JTextField OGRENCITIP = new JTextField();		

	private JTextField OGRENCITC2 = new JTextField();	

	private JTextArea mesajAlani = new JTextArea();	
	@Override
	public void actionPerformed(ActionEvent e) {
		 
	}
	public  Uygulama() {
		EKLE.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	  mesajAlani.setText(ogrenciEklemeIslemi(OGRENCIAD.getText() , OGRENCISOYAD.getText() ,OGRENCITC.getText(),OGRENCITIP.getText(),OGRENCIBOLUM.getText()));
	      }
	    });
		SIL.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	 mesajAlani.setText(ogrenciSilmeIslemi((Integer.parseInt(OGRENCITC2.getText()))));
	      }
	    });
		OGRENCILER.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	  		 List<String> ogr_liste = dosyaIcerik();
	  		 
	  		 String depo="";
	  		
	  		 for (String string : ogr_liste) {
	  			 depo+= string;
			}
	  		 mesajAlani.setText(depo); 		 
	      }
	    });
		
		mesajAlani.setEditable(false);
		setLayout(new GridLayout(5, 3));
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel2 = new JPanel();
		add(panel2);
		
		
		JPanel panel3 = new JPanel();
		add(panel3);
		
		JPanel panel4 = new JPanel();
		add(panel4);
		
		add(mesajAlani);
		
		panel.setLayout(new GridLayout(3, 3));
		panel.add( new JLabel("Ogrenci AD: ")); 
		panel.add(OGRENCIAD);
		
		panel.add(new JLabel("Ogrenci SOYAD: "));
		panel.add(OGRENCISOYAD);
		
		panel.add(new JLabel("OgrenciTip(Lisans,YuksekLisans,Doktora)"));
		panel.add(OGRENCITIP);
		
		panel.add(new JLabel("Ogrenci TC: "));
		panel.add(OGRENCITC);

		panel.add(new JLabel("Ogrenci BOLUM(MYO,ENTST�T�): "));
		panel.add(OGRENCIBOLUM);
		
		panel.add( new JLabel("")); 
		panel.add( EKLE); 
		 
		
		panel2.setLayout(new GridLayout(3,2));
		panel2.add( new JLabel("Ogrenci TC: ")); 
		panel2.add( OGRENCITC2); 

		panel2.add( SIL); 

		panel3.setLayout(new GridLayout(2,2));
		panel2.add( OGRENCILER); 
	
	}
	
	public static void main2(){
		Uygulama ekran = new Uygulama();
		ekran.setTitle("ILERI AVA GUI");
		ekran.setSize(500, 600);
		ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekran.setResizable(false);
		ekran.setVisible(true);
	}
	
	public static void main(String[] args) {

		main2();
		 Scanner ekranOkuyucu = new Scanner(System.in);
		// TODO Auto-generated method stub
		while(true) {
			ekranaMenuyuBas();			
			System.out.println("Secim yapiniz: ");
			int kullaniciSecimi =ekranOkuyucu.nextInt();
			System.out.println(kullaniciSecimi + " sectiniz.");
			switch (kullaniciSecimi) {
			case 1: 
				ogrenciEklemeIslemi();
				break;
			case 2: 
				ogrenciSilmeIslemi();
				break;
			case 3: 
				ogrenciListelemeIslemi();
				break;
			case 0: 
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

	
	private static void ogrenciListelemeIslemi() {
		// TODO Auto-generated method stub
		dosyaOkumaIslemi();
	}
	private static void ogrenciSilmeIslemi() {
		// TODO Auto-generated method stub
		dosyaOkumaIslemi();
		List<String> dosyaIcerigi = dosyaIcerik();
		Scanner ekranOkuyucu = new Scanner(System.in);
		System.out.println("Silmek istedi�iniz ��renci TC:");
		String tc = ekranOkuyucu.next();
		List<String> dosyaIcerigi2 = new ArrayList<String>();
		for (String string : dosyaIcerigi) {
			if(string.indexOf(tc) == -1)
				dosyaIcerigi2.add(string);
		}
		System.out.println("��renci silindi.");
		
		dosyaYazmaIslemi(dosyaIcerigi2, false);
	}
	
	private static String ogrenciSilmeIslemi(int tc) {
		// TODO Auto-generated method stub
		List<String> dosyaIcerigi = dosyaIcerik();
		Scanner ekranOkuyucu = new Scanner(System.in);
		List<String> dosyaIcerigi2 = new ArrayList<String>();
		for (String string : dosyaIcerigi) {
			if(string.indexOf(("TC:"+tc)) == -1)
				dosyaIcerigi2.add(string);
			System.out.println(string);
		}
		
		dosyaYazmaIslemi(dosyaIcerigi2, false);
		return  tc+" TC li ��renci silindi.";
	}
	
	
	private static List<String> dosyaIcerik(){
		try {
			File file = new File("OgrenciDosyasi.txt");
			if (!file.exists()) {
				file.createNewFile();
		    }

			List<String> dosyaIcerigi = new ArrayList<>();
			
			FileReader fileReader = new FileReader(file);
			String line;
			
			BufferedReader br = new BufferedReader(fileReader);
			
			while ((line = br.readLine()) != null) {
				dosyaIcerigi.add(line);
			}
			
			br.close();
			return dosyaIcerigi;
	
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}
	
	private static void dosyaOkumaIslemi(){
		try {
			File file = new File("OgrenciDosyasi.txt");
			if (!file.exists()) {
				file.createNewFile();
		    }

			FileReader fileReader = new FileReader(file);
			String line;
			
			BufferedReader br = new BufferedReader(fileReader);
			
			while ((line = br.readLine()) != null) {
			
			    System.out.println(line);
			
			}
			
			br.close();
	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static void ogrenciEklemeIslemi() {
		// TODO Auto-generated method stub	

		 Scanner ekranOkuyucu = new Scanner(System.in);

		System.out.print("Isim ve Soyisim:");
		String isimsoyisim = ekranOkuyucu.nextLine();

		
		System.out.print("Lisans - YuksekLisans - Doktora:");
		String lisans = ekranOkuyucu.nextLine();
		
		System.out.println("Tc:");
		String tc = ekranOkuyucu.next();
		
		Ogrenci ogrenci = null;
		if(lisans.equalsIgnoreCase("Lisans")){
			ogrenci = new Lisans(isimsoyisim, tc,lisans);
		}else if(lisans.equalsIgnoreCase("YuksekLisans")){
			ogrenci = new YuksekLisans(isimsoyisim, tc,lisans);
		}else if(lisans.equalsIgnoreCase("Doktora")){
			ogrenci = new Doktora(isimsoyisim, tc,lisans);
		}		
		dosyaYazmaIslemi(ogrenci,true);
	}
	
	private static String ogrenciEklemeIslemi(String ad,String soyad,String tc,String tip,String bolum) {
		// TODO Auto-generated method stub	
		Ogrenci ogrenci = null;
		if(tip.equalsIgnoreCase("Lisans")){
			ogrenci = new Lisans(ad+soyad, tc,tip);
		}else if(tip.equalsIgnoreCase("YuksekLisans")){
			ogrenci = new YuksekLisans(ad+soyad, tc,tip);
		}else if(tip.equalsIgnoreCase("Doktora")){
			ogrenci = new Doktora(ad+soyad, tc,tip);
		}	
		else{
			System.out.println("asdfas");
		}
		
		dosyaYazmaIslemi(ogrenci,true);
		
		return ad+soyad+" adl� ��renci eklendi";
	}
	private static void dosyaYazmaIslemi(Ogrenci ogrenci,boolean uzerineMi){
		 
		try{
			File dosya = new File("OgrenciDosyasi.txt");
            FileWriter yazici = new FileWriter(dosya,uzerineMi);
            BufferedWriter yaz = new BufferedWriter(yazici);
            String ogenciBilgisi = "AdSoyad:"+ogrenci.adSoyad+" "+" TC:"+ogrenci.tc+" "+" B�l�m:"+ogrenci.bolum+"\n";
            yaz.write(ogenciBilgisi);
            yaz.close();
            System.out.println("Ekleme ��lemi Ba�ar�l�");
        }
        catch (Exception hata){
              hata.printStackTrace();
        }
	}
	private static void dosyaYazmaIslemi(List<String> ogrenci,boolean uzerineMi){
		try{
			File dosya = new File("OgrenciDosyasi.txt");
            FileWriter yazici = new FileWriter(dosya,uzerineMi);
            BufferedWriter yaz = new BufferedWriter(yazici);
            String ogrenciBilgisi="";
            for (String string : ogrenci) {
            	ogrenciBilgisi+=string+"\n";
			}
            yaz.write(ogrenciBilgisi);
            yaz.close();
            //System.out.println("Ekleme ��lemi Ba�ar�l�");
        }
        catch (Exception hata){
              hata.printStackTrace();
        }
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
}