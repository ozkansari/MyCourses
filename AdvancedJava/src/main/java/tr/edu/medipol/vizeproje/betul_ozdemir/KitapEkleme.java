package tr.edu.medipol.vizeproje.betul_ozdemir;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KitapEkleme {
	public static void main(String[] args) {
		JTextField KitapAdi, Yazar, Tur,YayinEvi, Sayfa;
		KitapAdi = new JTextField(10);
		Yazar = new JTextField(10);
		Tur = new JTextField(10);
		YayinEvi = new JTextField(10);
		Sayfa= new JTextField(10);	
		JFrame Cerceve2 = new JFrame("Kitap Ekle");
		
		
		Cerceve2.setBackground(Color.pink);
		Cerceve2.setLayout(new GridLayout()); 
		
		Cerceve2.add(new JLabel("Kitap Ad�:"));
		Cerceve2.add(KitapAdi);
		
		Cerceve2.add(new JLabel("Yazar Adi:"));
		Cerceve2.add(Yazar);
		
		Cerceve2.add(new JLabel("T�r�:"));
		Cerceve2.add(Tur);
		
		Cerceve2.add(new JLabel("Yayin Evi:"));
		Cerceve2.add(YayinEvi);
		
		Cerceve2.add(new JLabel("Sayfa sayisi:"));
		Cerceve2.add(Sayfa);
		
		KitapEkleme frame = new KitapEkleme();
		Cerceve2.setVisible(true);
		Cerceve2.pack(); 
		

}
}