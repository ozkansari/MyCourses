
package tr.edu.medipol.vizeproje.aysenur_yildiz;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class YayinEviEkle{
	public static void main(String[] args) {
		JTextField sifre, eposta;
		sifre = new JTextField(10);
		eposta = new JTextField(10);
		JFrame Pencere = new JFrame("Yay�n Evi Ekle");
		
		Pencere.setBackground(Color.gray);
		Pencere.setLayout(new GridLayout()); 
		
		Pencere.add(new JLabel("Yay�n Evi Ad� Giriniz:"));
		Pencere.add(eposta);
		
		Pencere.add(new JLabel("E-posta Adresi Giriniz:"));
		Pencere.add(sifre);
		
		Pencere.add(new JButton("Ekle"));
		
		if(eposta.equals("E-posta")&&(sifre.equals(null)))
	    {
		 
			YayinEvi JFrame = new YayinEvi();
			Pencere.setVisible(true);
			Pencere.pack(); 
	    }
	    else 
	    {
	     JOptionPane.showMessageDialog(null, "Giri� Hatal�");
	    }
		Pencere.setVisible(true);
		Pencere.pack();

		

	}

}

