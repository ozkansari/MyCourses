package tr.edu.medipol.vizeproje.betul_ozdemir;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class Liste {
	
	public static void main(String[] args) {
		
	 JFrame f = new JFrame("Kutuphane Yonetim");
	 f.setSize(600, 250);
	 Container content = f.getContentPane();
	 content.setBackground(Color.pink);
	 content.setLayout(new FlowLayout());
	 
	 ArrayList <String> KitapListesi = new ArrayList <String> ();
	 KitapListesi.add("Kurk Mantolu Madonna");
	 KitapListesi.add("Kucuk Prens");
	 KitapListesi.add("Ucurtma Avcisi");
	 KitapListesi.add("seker Portakali");
	 KitapListesi.add("Tutunamayanlar");
	 KitapListesi.add("Sevgilimden Son Mektup");
	 
	 for(String d : KitapListesi){
		 System.out.println(d);
		 }

		 System.out.println();
	 


		
	 f.setVisible(true);
	 }
	} 


