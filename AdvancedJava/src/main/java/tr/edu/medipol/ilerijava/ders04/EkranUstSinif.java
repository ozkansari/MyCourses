package tr.edu.medipol.ilerijava.ders04;

import java.util.Queue;

import javax.swing.JFrame;

public abstract class EkranUstSinif extends JFrame {

	public abstract void mesajEkle(String mesaj);
	
	public Queue<String> getMesajKuyrugu() {
		return null;
	}
}
