package tr.edu.medipol.ilerijava.ders04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

import javax.swing.*;

public class IstemciEkrani extends SunucuEkrani {

	private Queue<String> mesajKuyrugu = new LinkedList<>();
	// private SynchronousQueue<String> mesajKuyrugu = new SynchronousQueue<>();
	
	private final JTextField mesajAlani;
	
	private final JButton mesajGonderBtn;
	
	public IstemciEkrani(String title) {
		super(title);
		
		JPanel mesajGonderimPaneli = new JPanel();
		
		mesajAlani = new JTextField(40);
		mesajGonderimPaneli.add(mesajAlani);
		
		mesajGonderBtn = new JButton("GONDER");
		mesajGonderimPaneli.add(mesajGonderBtn);
		mesajGonderBtn.addActionListener(event -> {
			mesajKuyrugu.offer(mesajAlani.getText());
			mesajAlani.setText("");
		});
		
		add(mesajGonderimPaneli);
	}
	
	public Queue<String> getMesajKuyrugu() {
		return mesajKuyrugu;
	}

}
