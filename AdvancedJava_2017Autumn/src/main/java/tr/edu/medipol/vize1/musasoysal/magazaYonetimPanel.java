package tr.edu.medipol.vize1.musasoysal;
import javax.swing.*;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class magazaYonetimPanel {

    public static void main(String[] args) {
    	
        new anaPencere();
        
    }
}

class anaPencere {
	private JFrame anaMenu = new JFrame("Ana Menu");
	private JButton calisanlarButon = new JButton("Calisan Islemleri");
	private JButton stokButon = new JButton("Stok Islemleri");
	private JButton cikisButon = new JButton("Cikis");
	private JButton calisanEkleButon = new JButton("Calisan Ekle");

	public anaPencere() {
		anaMenu.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//Gorunecek butonlar
		anaMenu.getContentPane().add(calisanlarButon);
		anaMenu.getContentPane().add(stokButon);
		anaMenu.getContentPane().add(cikisButon);
		
		
		calisanlarButon.setBackground(Color.white);
		stokButon.setBackground(Color.white);
		cikisButon.setBackground(Color.white);
		calisanlarButon.setForeground(Color.black);
		stokButon.setForeground(Color.black);
		cikisButon.setForeground(Color.red);
	       
	       
		// Cal��an islemlerine bas�ld�g�nda yap�lacak i�lemler
		calisanlarButon.addActionListener(ae -> {
			calisanlarButon.setSize(400, 0);
			anaMenu.dispose();
			new calisanlarMenusu2();
		});
	       
		cikisButon.addActionListener(ae -> {
			anaMenu.dispose();
		});
	       
		// Stok Islemlerine basildiginda yap�lacak islemler
		stokButon.addActionListener(ae -> {
			anaMenu.dispose();
			new stoklarMenusu();
	   });
	       
	       
		//Anamenu  pencere ayarlari
		anaMenu.setSize(550, 500);
		anaMenu.setLayout(new GridLayout(3, 0));
		anaMenu.setVisible(true);
	}

}
class calisanlarMenusu2 {
	  private JFrame calisanlarMenusu = new JFrame("calisanlarMenusu");
	  private JButton calisanEkleButton = new JButton("Calisan Ekle");
	  private JButton calisanlariSil = new JButton("Calisan Sil");
	  private JButton calisanlariGoruntule = new JButton("Calisanlari Goruntule");
	  
	  public calisanlarMenusu2() {
		  calisanlarMenusu.setLayout(new GridLayout(3,3));
		  calisanlarMenusu.add(calisanEkleButton);
		  calisanlarMenusu.add(calisanlariSil);
		  calisanlarMenusu.add(calisanlariGoruntule);
		  calisanlarMenusu.setSize(400,400);
		  calisanlarMenusu.setVisible(true);
		  
		  // Cal�sanlar Menusunde Cal�san Ekleye Tiklandiginda Yapilacak Islemler
		  calisanEkleButton.addActionListener(ae -> {
			  calisanEkleButton.setSize(400, 0);
			  calisanEkleButton.getBackground();
			  calisanlarMenusu.dispose();
			  new calisanEklemeSecenekleri();
		  });
		  
		  //Cal�sanlar Menusunde Cal�sanlar� Goruntuleye tiklandiginda yapilacak islemler
		  calisanlariGoruntule.addActionListener(ae -> {
			  //calisanlarMenusu.dispose();
			  
		  });
	  }
}

class stoklarMenusu {
	  private JFrame stokMenusu = new JFrame("stoklarMenusu");
	  private JButton stokEkle = new JButton("Stok Ekle");
	  private JButton stokSil = new JButton("Stok Sil");
	  private JButton stoklariGoruntule = new JButton("Stoklar� Goruntule");
	  
	  public stoklarMenusu() {
		  
		  stokMenusu.setLayout(new GridLayout(3,3));
		  stokMenusu.add(stokEkle);
		  stokMenusu.add(stokSil);
		  stokMenusu.add(stoklariGoruntule);
		  stokMenusu.setSize(400,400);
		  stokMenusu.setVisible(true);
		  
		// Stok Ekle men�s�nde stok ekleye bas�ld�g�nda yap�lacak islem
		  stokEkle.addActionListener(ae -> {
			  stokEkle.setSize(400, 0);
			  stokEkle.getBackground();
              stokMenusu.dispose();
			
	        });
		  
		  //Calisanlar Menusunde Calisanlari Goruntuleye Tiklandiginda Yapilacak Islemler
		  stoklariGoruntule.addActionListener(ae -> {
			  
		
		              
		        });
	  }
}

class calisanEklemeSecenekleri {
	private JFrame calisanEklemeSecenekleri = new JFrame("CalisanEklemeSecenekleri");
	private JButton stajyer = new JButton("Stajyer Ekle");
	private JButton personel = new JButton("Personel Ekle");
	private JButton mudur = new JButton("Mudur Ekle");

	public calisanEklemeSecenekleri() {
		calisanEklemeSecenekleri.setLayout(new GridLayout(3,3));
		calisanEklemeSecenekleri.add(stajyer);
		calisanEklemeSecenekleri.add(personel);
		calisanEklemeSecenekleri.add(mudur);
		calisanEklemeSecenekleri.setSize(400,400);
		calisanEklemeSecenekleri.setVisible(true);

		// 
		stajyer.addActionListener(ae -> {
			stajyer.setSize(400, 0);
			calisanEklemeSecenekleri.dispose();
			new stajyerEklemeIslemleri();
		});

		
		personel.addActionListener(ae -> {
			personel.setSize(400, 0);
			calisanEklemeSecenekleri.dispose();
			new personelEklemeIslemleri();
		});

		
		mudur.addActionListener(ae -> {
			mudur.setSize(400, 0);
			calisanEklemeSecenekleri.dispose();
			new mudurEklemeIslemleri();
		});
	}



}

class stajyerEklemeIslemleri {
    private JFrame stajyerEkleme = new JFrame("Calisan Ekleme Islemleri");
	private JFrame calisanUyari = new JFrame("Uyari");
	private JTextField adGirdi = new JTextField();
	private JTextField soyadGirdi = new JTextField();
	private JTextField tckimliknoGirdi = new JTextField();
	private JButton ekleButon = new JButton("Ekle");
	private JButton geriButon = new JButton("Geri Don");
	
    public stajyerEklemeIslemleri() {
		stajyerEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stajyerEkleme.setLayout(new GridLayout(4,2));
		stajyerEkleme.add(new JLabel("Adi: "));
		stajyerEkleme.add(adGirdi);
		stajyerEkleme.add(new JLabel("Soyadi: "));
		stajyerEkleme.add(soyadGirdi);
		stajyerEkleme.add(new JLabel("TC Kimlik No: "));
		stajyerEkleme.add(tckimliknoGirdi);
		stajyerEkleme.getContentPane().add(ekleButon);
		stajyerEkleme.getContentPane().add(geriButon);
		stajyerEkleme.setSize(400, 400);
		stajyerEkleme.setVisible(true);

        // Ekle Butonun ne is yapacagi 
		ekleButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Stajyer stajyer = new Stajyer();

				String isim = adGirdi.getText();
				String soyisim = soyadGirdi.getText();
				String tckn = tckimliknoGirdi.getText();
	

				if(stajyer != null) {
					stajyer.calisannEkle(isim, soyisim, tckn);
					stajyer.dosyayaEkle();
					JOptionPane.showMessageDialog(calisanUyari, "Stajyer Eklendi");
				}
			}

		});
		geriButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stajyerEkleme.dispose();
				new calisanEklemeSecenekleri();
				
			}});
	}
}

class personelEklemeIslemleri {
	private JFrame personelEkleme = new JFrame("Personel Ekleme Islemleri");
	private JFrame calisanUyari = new JFrame("Uyari");
	private JTextField adGirdi = new JTextField();
	private JTextField soyadGirdi = new JTextField();
	private JTextField tckimliknoGirdi = new JTextField();
	private JButton ekleButon = new JButton("Ekle");
	private JButton geriButon = new JButton("Geri Don");

	public personelEklemeIslemleri() {
		personelEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		personelEkleme.setLayout(new GridLayout(4,2));
		personelEkleme.add(new JLabel("Adi: "));
		personelEkleme.add(adGirdi);
		personelEkleme.add(new JLabel("Soyadi: "));
		personelEkleme.add(soyadGirdi);
		personelEkleme.add(new JLabel("TC Kimlik No: "));
		personelEkleme.add(tckimliknoGirdi);
		personelEkleme.getContentPane().add(ekleButon);
		personelEkleme.getContentPane().add(geriButon);
		personelEkleme.setSize(400, 400);
		personelEkleme.setVisible(true);

		// Ekle Butonun ne is yapacagi
		ekleButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Personel personel = new Personel();

				String isim = adGirdi.getText();
				String soyisim = soyadGirdi.getText();
				String tckn = tckimliknoGirdi.getText();
		

				if(personel != null) {
					personel.calisannEkle(isim, soyisim, tckn);
					personel.dosyayaEkle();
					JOptionPane.showMessageDialog(calisanUyari, "Personel Eklendi");
				}
			}
		});
		geriButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personelEkleme.dispose();
				new calisanEklemeSecenekleri();
				
			}});
		
	}

}

class mudurEklemeIslemleri {
    private JFrame mudurEkleme = new JFrame("Calisan Ekleme Islemleri");
	private JFrame calisanUyari = new JFrame("Uyari");
	private JTextField adGirdi = new JTextField();
	private JTextField soyadGirdi = new JTextField();
	private JTextField tckimliknoGirdi = new JTextField();
	private JButton ekleButon = new JButton("Ekle");
	private JButton geriButon = new JButton("Geri Don");
	
    public mudurEklemeIslemleri() {
		mudurEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mudurEkleme.setLayout(new GridLayout(4,2));
		mudurEkleme.add(new JLabel("Adi: "));
		mudurEkleme.add(adGirdi);
		mudurEkleme.add(new JLabel("Soyadi: "));
		mudurEkleme.add(soyadGirdi);
		mudurEkleme.add(new JLabel("TC Kimlik No: "));
		mudurEkleme.add(tckimliknoGirdi);
		mudurEkleme.getContentPane().add(ekleButon);
		mudurEkleme.getContentPane().add(geriButon);
		mudurEkleme.setSize(400, 400);
		mudurEkleme.setVisible(true);

        // Ekle Butonun ne is yapacagi 
		ekleButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Mudur mudur = new Mudur();

				String isim = adGirdi.getText();
				String soyisim = soyadGirdi.getText();
				String tckn = tckimliknoGirdi.getText();
	

				if(mudur != null) {
					mudur.calisannEkle(isim, soyisim, tckn);
					mudur.dosyayaEkle();
					JOptionPane.showMessageDialog(calisanUyari, " Mudur Eklendi");
				}
			}

		});
		geriButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudurEkleme.dispose();
				new calisanEklemeSecenekleri();
				
			}});
	}
}



	






