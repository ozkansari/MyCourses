package tr.edu.medipol.ilerijava.ders04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SunucuEkrani extends EkranUstSinif {

	private static final long serialVersionUID = 1L;
	private JTextArea mesajlarJTA;
	private JScrollPane mesajlarJTAScroll;
	private java.util.List<String> mesajList;

	public SunucuEkrani(String title) {
		setTitle(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(750, 500);
		setLocation(100, 50);
		
		setLayout(new GridLayout(2, 1));
		
		mesajlarJTA = new JTextArea(); 
		mesajlarJTA.setEditable(false);
		mesajlarJTA.getScrollableTracksViewportHeight();
		mesajlarJTAScroll = new JScrollPane(mesajlarJTA);
		add(mesajlarJTAScroll);
		
		mesajList = new java.util.ArrayList<>();
	}
	
	@Override
	public synchronized void mesajEkle(String mesaj) {
		mesajList.add(mesaj);
		
		// 1. Yontem
		mesajlarJTA.setText( mesajlarJTA.getText() + mesaj+ "\n");
		mesajlarJTA.setCaretPosition(mesajlarJTA.getDocument().getLength());
		repaint();
		
		/*
		// 2. yontem
		String mesajStr = new String();
		for (String msj : mesajList) {
			mesajStr += msj + "\n";
		}
		mesajlarJTF.setText(mesajStr);
		
		// 3. yontem : java 8
		final StringBuilder sb = new StringBuilder();
		mesajList.forEach( msj -> {
			sb.append(msj + "\n");
		});
		mesajlarJTF.setText(sb.toString());
		*/
	}
	
}
