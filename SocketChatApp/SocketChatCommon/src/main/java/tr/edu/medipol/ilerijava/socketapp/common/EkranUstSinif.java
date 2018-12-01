package tr.edu.medipol.ilerijava.socketapp.common;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class EkranUstSinif extends JFrame {

	private static final long serialVersionUID = 1L;
	private Queue<String> mesajKuyrugu = new LinkedList<>();
	private JTextArea mesajlarJTA;
	private JScrollPane mesajlarJTAScroll;
	private java.util.List<String> mesajList;

	public Queue<String> getMesajKuyrugu() {
		return mesajKuyrugu;
	}

	public void init(String title) {
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
