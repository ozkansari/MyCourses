package tr.edu.medipol.vizeproje.aysenur_yildiz;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class ListeEkle {
	
	public static void main(String[] args) {
		
	 JFrame n= new JFrame("K�t�phane Y�netim");
	 n.setSize(700, 300);
	 Container content = n.getContentPane();
	 content.setBackground(Color.gray);
	 content.setLayout(new FlowLayout());
	 
	 ArrayList <String> KitapListesi = new ArrayList <String> ();
	 KitapListesi.add("Beni orda bulacaks�n");
	 KitapListesi.add("K���k Mucizeler D�kkan�");
	 KitapListesi.add("Bah�emde Ye�eren D��ler");
	 KitapListesi.add("K�rk Mantolu Madonna");
	
	 
	 for(String d : KitapListesi){
		 System.out.println(d);
		 }

		 System.out.println();
	 


		
	 n.setVisible(true);
	 }
	} 
