package tr.edu.medipol.ilerijava.vize.osman_cansiz.ServerPack;

import java.io.*;
import java.net.*;
import java.util.*;

import tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack.PageSuperClass;
import tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack.SocketHelperClass;

public class SocketStreamerThread extends Thread {

	private Map<String,Socket> allSockets;
	
	private Map<Socket,PrintWriter> allSocketsWriter;
	
	private PageSuperClass screen;
	
	public SocketStreamerThread(PageSuperClass ekran) {
		allSockets = new HashMap<>();
		allSocketsWriter = new HashMap<>();
		this.screen = ekran;
	}
	
	public synchronized boolean addSocket(String socketName, Socket socket) {
		allSockets.put(socketName, socket);
		PrintWriter socketMessageSender = SocketHelperClass.createSocketWriter(socket);
		allSocketsWriter.put(socket, socketMessageSender);
		return true;
	}
	
	@Override
	public void run() {

		while(true) {
			String nextMes = screen.getMessageQueue().poll();
			if (nextMes == null) {
				SocketHelperClass.waitForThread(1000);
				continue;
			}
			// Tum istemcilere gonder
			Collection<PrintWriter> writerList = allSocketsWriter.values();
			for (PrintWriter socketMessageSender : writerList) {
				socketMessageSender.println(nextMes);
				socketMessageSender.flush();
			} 
			
		} 
		
	}
	
	@Override
	public void destroy() {
		Collection<PrintWriter> yaziciList = allSocketsWriter.values();
		for (PrintWriter socketMesajGonderici : yaziciList) {
			socketMesajGonderici.close();
		}
	}
	
}
