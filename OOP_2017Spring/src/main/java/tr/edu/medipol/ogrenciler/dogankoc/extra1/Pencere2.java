package tr.edu.medipol.ogrenciler.dogankoc.extra1;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class Pencere2 extends JFrame implements ActionListener{
	
	private Listele ob;
	private JButton listeleButon=new JButton("LİSTELE");

	public void actionPerformed(ActionEvent arg1){
		ob.setVisible(true);
		ob.actionPerformed(arg1);
	}

	public Pencere2(ArrayList<String> isimler){

		setLayout(new GridLayout(7,2));
		add(listeleButon);

		ob=new Listele(isimler); 
		listeleButon.addActionListener(ob);
	}


}