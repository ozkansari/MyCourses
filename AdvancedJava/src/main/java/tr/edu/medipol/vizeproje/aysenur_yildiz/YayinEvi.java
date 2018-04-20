package tr.edu.medipol.vizeproje.aysenur_yildiz;
import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.*;


public class YayinEvi {
	 public static void main(String[] args) {
			
		 JFrame f = new JFrame("K�t�phane Y�netim");
		 f.setSize(700, 300);
		 Container content = f.getContentPane();
		 content.setBackground(Color.gray);
		 content.setLayout(new FlowLayout());
		 content.add(new JButton("Yay�n Evi Ekle"));
		 content.add(new JButton("Kitap Ekle"));
		 content.add(new JButton("Kitaplar� Listele"));
		 content.add(new JButton("��k��"));
		
		 f.setVisible(true);
		
		  
		 }
}
