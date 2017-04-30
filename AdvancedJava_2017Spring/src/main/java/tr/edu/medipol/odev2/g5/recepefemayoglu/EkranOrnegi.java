package tr.edu.medipol.odev2.g5.recepefemayoglu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** ozkans Degerlendirme

- Erhan Kilic ile benzer ama birbirinden ayrilan yerler de var.
- Ilk odevdeki alakasiz kodlar silinmemis. Temiz kod ilkesine uymuyor.
- Turkce karakter sorunlari var.
- Hatali/bos giris kontrolu yok. Uygulama sorun oldugunda hata veriyor, bunu kullaniciya gostermiyor.

Ekran: 20/20
Ogrenci Islemleri: 10/15 (Bos kayit kontrolu yok)
Polimorphism: 15/15
Dosyadan Okuma: 15/20 (Dosya olmadiginda ilk calistirildiginda exception veriyor.)
Dosyaya Yazma:  15/20 (Yazma mantigi karisik)
Genel Program: 5/10
Bonus: 0/25
Benzer Kod Yazma Nedeniyle: -5 
--------------------------
SONUC: 75/125
 */
public class EkranOrnegi extends JFrame implements ActionListener {
	private JButton ekleButonu = new JButton("��renci Ekle");
	private JButton silButonu = new JButton("ID 'ye g�re Sil");
	private JButton listeButonu = new JButton("Listeyi G�ster");
	
	private JTextField txt_ad = new JTextField();	
	private JTextField txt_soyad = new JTextField();	
	private JTextField txt_bolum = new JTextField();
	private JTextField txt_tip = new JTextField();
	private JTextArea txtarea1 = new JTextArea();	
	private JTextArea txt_id = new JTextArea();	

	
	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
	public EkranOrnegi(){
		txtarea1.setEditable(false);
		setLayout(new GridLayout(2, 1));
		JPanel panel = new JPanel();
		add(panel);
		add(txtarea1);
		

		panel.setLayout(new GridLayout(18, 2)); // 2x2 grid

		panel.add( new JLabel("")); 
		panel.add( new JLabel("")); 
		panel.add( new JLabel("��renci Ekleme Men�s�")); 
		panel.add( new JLabel("")); 
		panel.add( new JLabel("")); 
		panel.add( new JLabel("")); 
		panel.add( new JLabel("Ogrenci Adi: ")); // 1. satir 1. sutun
		panel.add(txt_ad); 
		panel.add( new JLabel("��renci Soyadi")); // 2. satir 1. sutun
		panel.add(txt_soyad); 	
		
		panel.add( new JLabel("��renci B�l�m�(MYO,ISLETME,VB")); // 2. satir 1. sutun
		panel.add(txt_bolum); 	
		
		
		panel.add( new JLabel("1:Lisans   2:YuksekLisans   3:Doktora:")); 
		panel.add( txt_tip);  // 2. satir 2. sutun
		panel.add( new JLabel("")); 
		panel.add( ekleButonu);  // 2. satir 2. sutun

		panel.add( new JLabel("")); 
		panel.add( new JLabel("")); 
		panel.add( new JLabel("��renci Silme Men�s�")); 
		panel.add( new JLabel("")); 
		panel.add( new JLabel("")); 
		panel.add( new JLabel(""));
		panel.add( new JLabel("Silinecek ��renci ID: ")); // 1. satir 1. sutun
 

		panel.add(txt_id); 
		panel.add( new JLabel("")); 
		panel.add( new JLabel(""));
		panel.add( new JLabel(""));
		panel.add( silButonu);  // 2. satir 2. sutun

		 
		panel.add( new JLabel(""));
		panel.add( new JLabel(""));
		 
		panel.add( new JLabel(""));
		panel.add( new JLabel(""));
		
		 
		panel.add( new JLabel("��rencileri Listele"));
		panel.add( new JLabel(""));

		panel.add( new JLabel(""));
		panel.add(listeButonu);

		
		
		ekleButonu.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    txtarea1.setText(Uygulama.ogrenciEkleGUI(txt_ad.getText(),txt_soyad.getText(),
		    			Integer.parseInt(txt_tip.getText()),txt_bolum.getText()));
		    }
		});
		silButonu.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	txtarea1.setText(Uygulama.ogrenciSilGUI(Integer.parseInt(txt_id.getText())));
		    }
		});
		listeButonu.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	String dosyaIcerigi = "";
		    	for(String row:Uygulama.dosyaIcerigi())
		    		dosyaIcerigi+=row+"\n";
		    	txtarea1.setText(dosyaIcerigi);
		    }
		});
	} 
}