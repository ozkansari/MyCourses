package tr.edu.medipol.ilerijava.ders05.gui;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GUIOrnek2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JButton girisButonu = new JButton("TIKLA");

	private void butonIslemi(ActionEvent event) {
		System.out.println("Buton cagrildi.");
	}
	
	public GUIOrnek2() {
		this.setSize(500, 200);
		this.add(girisButonu);
		girisButonu.addActionListener( e -> butonIslemi(e) );
	}
	
	public static void main(String [] args) {
		GUIOrnek2 ekran = new GUIOrnek2();
		ekran.setVisible(true);
	}
}



