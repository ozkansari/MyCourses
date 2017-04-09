package tr.edu.medipol.ogrenciler.dogankoc.extra1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Listele extends JFrame implements ActionListener {

	public JTextField listele=new JTextField();
	ArrayList<String> isimler;
	
	public Listele(ArrayList<String> isimler){
		add(listele);
		this.setSize(500,500);
		this.isimler = isimler;
	}
	
	public void actionPerformed(ActionEvent arg1) {

		JButton basilan = (JButton) arg1.getSource();
		String basilanButonAdi = basilan.getText();

		String l = getList();
		listele.setText(l);
		
	}

	public String getList() {
		String etiketMesajAlani = "";
		for (String i : isimler) {
			etiketMesajAlani += i + " ";
		}

		return etiketMesajAlani;
	}
}
