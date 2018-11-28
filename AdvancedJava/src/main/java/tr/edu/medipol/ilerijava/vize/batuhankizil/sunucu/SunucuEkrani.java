package tr.edu.medipol.ilerijava.vize.batuhankizil.sunucu;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SunucuEkrani extends EkranUstSinif {
	
	private static final long serialVersionUID = 1L;
	private JTextArea hesaplamalarJTA;
	private JScrollPane hesaplamalarJTAScroll;

	public SunucuEkrani(final String title) {
		setTitle(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(720, 460);
		setLocation(100, 50);
		
		setLayout(new GridLayout(2, 1));
		
		hesaplamalarJTA = new JTextArea(); 
		hesaplamalarJTA.setEditable(false);
		hesaplamalarJTA.getScrollableTracksViewportHeight();
		hesaplamalarJTAScroll = new JScrollPane(hesaplamalarJTA);
		add(hesaplamalarJTAScroll);
		
	}	

	@Override
	public synchronized void ekranaYazdir(final String hesapla) {
				hesaplamalarJTA.setText( hesaplamalarJTA.getText() + hesapla + "\n");
				hesaplamalarJTA.setCaretPosition(hesaplamalarJTA.getDocument().getLength());
				repaint();
		
	}

}