package tr.edu.medipol.ilerijava.vize.osman_cansiz.ServerPack;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;

import tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack.PageSuperClass;

public class ServerPage extends PageSuperClass {

	private static final long serialVersionUID = 1L;
	private JTextArea messageArea;
	private JScrollPane messageScroll;
	private java.util.List<String> messageList;

	private Queue<String> messageQueue = new LinkedList<>();
	// private SynchronousQueue<String> mesajKuyrugu = new SynchronousQueue<>();
	
	public ServerPage(String title) {
		setTitle(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(750, 500);
		setLocation(100, 50);
		
		setLayout(new GridLayout(2, 1));
		
		messageArea = new JTextArea(); 
		messageArea.setEditable(false);
		messageArea.getScrollableTracksViewportHeight();
		messageScroll = new JScrollPane(messageArea);
		add(messageScroll);
		
		messageList = new java.util.ArrayList<>();
	}
	
	@Override
	public synchronized void addMessage(String message) {
		messageList.add(message);
		
		// 1. Yontem
		messageArea.setText( messageArea.getText() + message+ "\n");
		messageArea.setCaretPosition(messageArea.getDocument().getLength());
		repaint();
	}
	
	@Override
	public Queue<String> getMessageQueue() {
		return messageQueue;
	}
	
}
