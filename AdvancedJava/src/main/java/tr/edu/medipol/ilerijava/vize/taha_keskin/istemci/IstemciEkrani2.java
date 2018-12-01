package tr.edu.medipol.ilerijava.vize.taha_keskin.istemci;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

import javax.swing.*;

import tr.edu.medipol.ilerijava.vize.taha_keskin.sunucu.SunucuEkrani2;

public class IstemciEkrani2 extends SunucuEkrani2 {

	private final JTextField mesajAlani;
	
	private final JButton mesajGonderBtn;
	
	public IstemciEkrani2(String title) {
		super(title);
		
		JPanel mesajGonderimPaneli = new JPanel();
		
		mesajAlani = new JTextField(40);
		mesajGonderimPaneli.add(mesajAlani);
		
		mesajGonderBtn = new JButton("GONDER");
		mesajGonderimPaneli.add(mesajGonderBtn);
		mesajGonderBtn.addActionListener(event -> {
			getMesajKuyrugu().offer(mesajAlani.getText());
			// this.mesajEkle(mesajAlani.getText());
			mesajAlani.setText("");
		});
		
		add(mesajGonderimPaneli);
	}

}