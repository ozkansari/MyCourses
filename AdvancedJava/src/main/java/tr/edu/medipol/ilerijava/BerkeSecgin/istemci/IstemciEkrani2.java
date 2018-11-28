package tr.edu.medipol.ilerijava.BerkeSecgin.istemci;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

import javax.swing.*;

import tr.edu.medipol.ilerijava.BerkeSecgin.sunucu.SunucuEkrani2;

public class IstemciEkrani2 extends SunucuEkrani2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private final JTextField yapilacakislem;
	
	
	private final JButton mesajGonderBtn;
	
	public IstemciEkrani2(String title) {
		super(title);
		
		JPanel mesajGonderimPaneli = new JPanel();
		
		JLabel label = new JLabel("1.");
		mesajGonderimPaneli.add(label);
		
		yapilacakislem = new JTextField(40);
		mesajGonderimPaneli.add(yapilacakislem);

		
		mesajGonderBtn = new JButton("GONDER");
		mesajGonderimPaneli.add(mesajGonderBtn);
		mesajGonderBtn.addActionListener(event -> {
			getMesajKuyrugu().offer(yapilacakislem.getText());
			// this.mesajEkle(mesajAlani.getText());
			yapilacakislem.setText("");
		});
		
		add(mesajGonderimPaneli);
	}

}
