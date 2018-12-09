package tr.edu.medipol.ilerijava.socketapp.client;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tr.edu.medipol.ilerijava.socketapp.common.EkranUstSinif;

public class IstemciEkrani extends EkranUstSinif {

	private final JTextField mesajAlani;
	
	private final JButton mesajGonderBtn;
	
	public IstemciEkrani(String title) {

		init(title);
		
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
