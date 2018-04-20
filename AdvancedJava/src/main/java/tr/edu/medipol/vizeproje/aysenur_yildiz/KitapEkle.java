package tr.edu.medipol.vizeproje.aysenur_yildiz;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KitapEkle {
	public static void main(String[] args) {
		JTextField KitapAdi, YazarAdi, Tur,YayinEvi, SayfaSayisi;
		KitapAdi = new JTextField(10);
		YazarAdi = new JTextField(10);
		Tur = new JTextField(10);
		YayinEvi = new JTextField(10);
		SayfaSayisi= new JTextField(10);	
		JFrame Pencere2 = new JFrame("Kitap Ekle");
		
		
		Pencere2.setBackground(Color.gray);
		Pencere2.setLayout(new GridLayout()); 
		
		Pencere2.add(new JLabel("Kitap Ad� Giriniz:"));
		Pencere2.add(KitapAdi);
		
		Pencere2.add(new JLabel("Yazar Adi Giriniz:"));
		Pencere2.add(YazarAdi);
		
		Pencere2.add(new JLabel("Kitap T�r� Giriniz:"));
		Pencere2.add(Tur);
		
		Pencere2.add(new JLabel("Yayin Evi Giriniz:"));
		Pencere2.add(YayinEvi);
		
		Pencere2.add(new JLabel("Sayfa sayisi Giriniz:"));
		Pencere2.add(SayfaSayisi);
		
		KitapEkle JFrame = new KitapEkle();
		Pencere2.setVisible(true);
		Pencere2.pack(); 
		

}

}
