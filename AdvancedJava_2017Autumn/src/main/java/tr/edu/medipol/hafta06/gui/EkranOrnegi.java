package tr.edu.medipol.hafta06.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EkranOrnegi extends JFrame implements ActionListener {
	private JButton ekleButonu = new JButton("Ekle");
	private JTextField ogrenciGirdi = new JTextField();	
	private JTextField mesajAlani = new JTextField();	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mesajAlani.setText(ogrenciGirdi.getText());
	}
	public EkranOrnegi(){
		ekleButonu.addActionListener(this);
		mesajAlani.setEditable(false);
		setLayout(new GridLayout(5, 1));
		JPanel panel = new JPanel();
		add(panel);
		add(mesajAlani);
		
		panel.setLayout(new GridLayout(2, 2)); // 2x2 grid
		panel.add( new JLabel("Ogrenci adi: ")); // 1. satir 1. sutun
		panel.add(ogrenciGirdi); 
		panel.add( new JLabel("")); // 2. satir 1. sutun
		panel.add( ekleButonu);  // 2. satir 2. sutun
		
	}
	public static void main(String[] args) {
		EkranOrnegi ekran = new EkranOrnegi();
		ekran.setTitle("Ekran Ornegi");
		ekran.setSize(500, 600);
		ekran.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ekran.setResizable(false);
		ekran.setVisible(true);
	}	
}
