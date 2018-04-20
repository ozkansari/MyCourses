package tr.edu.medipol.vizeproje.betul_ozdemir;

	import java.awt.*;
import java.awt.event.MouseAdapter;

import javax.swing.*;
public class YayinEvi {
	
	 public static void main(String[] args) {
	
	 JFrame f = new JFrame("K�t�phane Y�netim");
	 f.setSize(600, 250);
	 Container content = f.getContentPane();
	 content.setBackground(Color.pink);
	 content.setLayout(new FlowLayout());
	 content.add(new JButton("Yay�n Evi Ekle"));
	 content.add(new JButton("Kitap Ekle"));
	 content.add(new JButton("Kitaplar� Listele"));
	 content.add(new JButton("��k��"));
	
	 f.setVisible(true);
	

	  
	 }

			

		
		}
	






