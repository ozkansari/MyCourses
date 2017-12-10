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
	       
	       
		// Cal__an islemlerine bas_ld_g_nda yap_lacak i_lemler
		calisanlarButon.addActionListener(ae -> {
			calisanlarButon.setSize(400, 0);
			anaMenu.dispose();
			new calisanlarMenusu2();
		});
	       
		cikisButon.addActionListener(ae -> {
			anaMenu.dispose();
		});
	       
		// Stok Islemlerine basildiginda yap_lacak islemler
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
		  
		  // Cal_sanlar Menusunde Cal_san Ekleye Tiklandiginda Yapilacak Islemler
		  calisanEkleButton.addActionListener(ae -> {
			  calisanEkleButton.setSize(400, 0);
			  calisanEkleButton.getBackground();
			  calisanlarMenusu.dispose();
			  new calisanEklemeSecenekleri();
		  });
		  
		  //Cal_sanlar Menusunde Cal_sanlar_ Goruntuleye tiklandiginda yapilacak islemler
		  calisanlariGoruntule.addActionListener(ae -> {
			  //calisanlarMenusu.dispose();
			  
		  });
	  }
}


class stoklarMenusu {
	private JFrame stoklarMenusu = new JFrame("CalisanEklemeSecenekleri");
	private JButton yiyecek = new JButton("Yiyecek Ekle");
	private JButton giyecek = new JButton("Giyecek Ekle");
	private JButton aksesuar = new JButton("Aksesuar Ekle");

	public stoklarMenusu() {
		stoklarMenusu.setLayout(new GridLayout(3,3));
		stoklarMenusu.add(yiyecek);
		stoklarMenusu.add(giyecek);
		stoklarMenusu.add(aksesuar);
		stoklarMenusu.setSize(400,400);
		stoklarMenusu.setVisible(true);

		// 
		yiyecek.addActionListener(ae -> {
			yiyecek.setSize(400, 0);
			stoklarMenusu.dispose();
			new yiyecekEkleme();
		});

		
		giyecek.addActionListener(ae -> {
			giyecek.setSize(400, 0);
			stoklarMenusu.dispose();
			new giyecekEkleme();
		});

		
		aksesuar.addActionListener(ae -> {
			aksesuar.setSize(400, 0);
			stoklarMenusu.dispose();
			new AksesuarEkleme();
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
class giyecekEkleme {
    private JFrame giyecekEkleme = new JFrame("Giyecek Ekleme");
	private JFrame giyecekUyari = new JFrame("Uyari");
	private JTextField giyecekAd = new JTextField();
	private JTextField giyecekAdedi = new JTextField();
	private JTextField giyecekReferans_ = new JTextField();
	private JButton ekleButon = new JButton("Ekle");
	private JButton geriButon = new JButton("Geri Don");
	
    public giyecekEkleme() {
		giyecekEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		giyecekEkleme.setLayout(new GridLayout(4,2));
		giyecekEkleme.add(new JLabel("Giyecek Adı: "));
		giyecekEkleme.add(giyecekAd);
		giyecekEkleme.add(new JLabel("Giyecek Adedi: "));
		giyecekEkleme.add(giyecekAdedi);
		giyecekEkleme.add(new JLabel("Referansı "));
		giyecekEkleme.add(giyecekReferans_);
		giyecekEkleme.getContentPane().add(ekleButon);
		giyecekEkleme.getContentPane().add(geriButon);
		giyecekEkleme.setSize(400, 400);
		giyecekEkleme.setVisible(true);

        // Ekle Butonun ne is yapacagi 
		ekleButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Giyecek giyecek = new Giyecek();

				String isim = giyecekAd.getText();
				String soyisim = giyecekAdedi.getText();
				String ref = giyecekReferans_.getText();
	

				if(giyecek != null) {
					giyecek.giyecekEkle(isim, soyisim, ref);
					giyecek.dosyayaEkle();
					JOptionPane.showMessageDialog(giyecekUyari, "Giyecek Eklendi.");
				}
			}

		});
		geriButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				giyecekEkleme.dispose();
				new stoklarMenusu();
				
			}});
	}
}
class yiyecekEkleme {
    private JFrame yiyecekEkleme = new JFrame("Yiyecek Ekleme");
	private JFrame yiyecekUyari = new JFrame("Uyari");
	private JTextField yiyecekAd = new JTextField();
	private JTextField yiyecekAdedi = new JTextField();
	private JTextField yiyecekBarkodu = new JTextField();
	private JButton ekleButon = new JButton("Ekle");
	private JButton geriButon = new JButton("Geri Don");
	
    public yiyecekEkleme() {
		yiyecekEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		yiyecekEkleme.setLayout(new GridLayout(4,2));
		yiyecekEkleme.add(new JLabel("Yiyecek Adı: "));
		yiyecekEkleme.add(yiyecekAd);
		yiyecekEkleme.add(new JLabel("Yiyecek Adedi: "));
		yiyecekEkleme.add(yiyecekAdedi);
		yiyecekEkleme.add(new JLabel("Yiyecek Barkodu: "));
		yiyecekEkleme.add(yiyecekBarkodu);
		yiyecekEkleme.getContentPane().add(ekleButon);
		yiyecekEkleme.getContentPane().add(geriButon);
		yiyecekEkleme.setSize(400, 400);
		yiyecekEkleme.setVisible(true);

        // Ekle Butonun ne is yapacagi 
		ekleButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Yiyecek yiyecek = new Yiyecek();

				String isim = yiyecekAd.getText();
				String soyisim = yiyecekAdedi.getText();
				String ref = yiyecekBarkodu.getText();
	

				if(yiyecek != null) {
					yiyecek.giyecekEkle(isim, soyisim, ref);
					yiyecek.dosyayaEkle();
					JOptionPane.showMessageDialog(yiyecekUyari, "Yiyecek Eklendi.");
				}
			}

		});
		geriButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yiyecekEkleme.dispose();
				new stoklarMenusu();
				
			}});
	}
}
class AksesuarEkleme {
    private JFrame aksesuarEkleme = new JFrame("Aksesuar Ekleme");
	private JFrame aksesuarUyari = new JFrame("Uyari");
	private JTextField aksesuarAd = new JTextField();
	private JTextField aksesuarAdedi = new JTextField();
	private JTextField aksesuarBarkodu = new JTextField();
	private JButton ekleButon = new JButton("Ekle");
	private JButton geriButon = new JButton("Geri Don");
	
    public AksesuarEkleme() {
    		aksesuarEkleme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		aksesuarEkleme.setLayout(new GridLayout(4,2));
    		aksesuarEkleme.add(new JLabel("Aksesuar Adı: "));
    		aksesuarEkleme.add(aksesuarAd);
    		aksesuarEkleme.add(new JLabel("Aksesuar Adedi: "));
    		aksesuarEkleme.add(aksesuarAdedi);
    		aksesuarEkleme.add(new JLabel("Aksesuar Barkodu: "));
    		aksesuarEkleme.add(aksesuarBarkodu);
    		aksesuarEkleme.getContentPane().add(ekleButon);
    		aksesuarEkleme.getContentPane().add(geriButon);
    		aksesuarEkleme.setSize(400, 400);
		aksesuarEkleme.setVisible(true);

        // Ekle Butonun ne is yapacagi 
		ekleButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Aksesuar aksesuar = new Aksesuar();

				String isim = aksesuarAd.getText();
				String soyisim = aksesuarAdedi.getText();
				String ref = aksesuarBarkodu.getText();
	

				if(aksesuar != null) {
					aksesuar.aksesuarEkle(isim, soyisim, ref);
					aksesuar.dosyayaEkle();
					JOptionPane.showMessageDialog(aksesuarUyari, "Yiyecek Eklendi.");
				}
			}

		});
		geriButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aksesuarEkleme.dispose();
				new stoklarMenusu();
				
			}});
	}
}

	






