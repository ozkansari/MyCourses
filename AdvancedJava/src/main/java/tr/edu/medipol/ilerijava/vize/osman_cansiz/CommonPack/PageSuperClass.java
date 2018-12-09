package tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack;

import java.util.Queue;

import javax.swing.JFrame;

public abstract class PageSuperClass extends JFrame {

	public abstract void addMessage(String message);
	
	public Queue<String> getMessageQueue() {
		return null;
	}
}
