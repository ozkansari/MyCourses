package tr.edu.medipol.ilerijava.ders04.lab;

import java.net.*;
import java.io.*;
import java.util.*;

public class SunucuProgrami2 {

	public static void main(String[] args) throws Exception {
		
		String myIp = getMyIp();
		ServerSocket sunucuSocket = new ServerSocket(8182);

		do {
			Socket istemciBaglantisi = sunucuSocket.accept();
			new IstemciThread(istemciBaglantisi).start();
		} while(true);
	}
	
	private static class IstemciThread extends Thread {
		private String kullaniciAdi;
		private Socket istemciBaglantisi;
		private DataInputStream alici;
		private DataOutputStream gonderici;
		private static Map<String, DataOutputStream> istemciOutMap = new HashMap< >();
		IstemciThread(Socket istemciBaglantisi) throws Exception {
			this.istemciBaglantisi = istemciBaglantisi;
			alici = new DataInputStream( this.istemciBaglantisi.getInputStream() );
			gonderici = new DataOutputStream( this.istemciBaglantisi.getOutputStream() );
		}
		public void run() {
			try {
				
				kullaniciAdi = alici.readUTF();
				if( istemciOutMap.get(kullaniciAdi) != null ) {
					System.out.println(kullaniciAdi + " alinmis.");
					throw new RuntimeException("Kullanici adi alinmis: " + kullaniciAdi);
				}
				istemciOutMap.put(kullaniciAdi, gonderici);
				setName(kullaniciAdi);
				
				do {
					String gelenMesaj = alici.readUTF();
					boolean ozelMesaj = ozelMesajKontrol(gelenMesaj);
					if(!ozelMesaj) {
						System.out.println(getName() + ">" + gelenMesaj);
						gonderici.writeUTF(" Mesaj alindi:" + gelenMesaj);
					}
					
				} while(true);
				
			} catch(Exception e) {
				System.out.println(getName() + " sonlandi." );
			}
		}
		private boolean ozelMesajKontrol(String gelenMesaj) throws Exception {
			int k = gelenMesaj.indexOf(" ");
			String hedefKullanici = gelenMesaj.substring(0, k+1).trim();
			DataOutputStream gonderici = istemciOutMap.get(hedefKullanici);
			if( gonderici == null) {
				return false;
			}
			// System.out.printf("[%s>%s] %s", kullaniciAdi , hedefKullanici, gelenMesaj.substring(k));
			gonderici.writeUTF( kullaniciAdi + " > " + gelenMesaj.substring(k) );
			return true;
		}
	}

	private static String getMyIp() {
		try {
			InetAddress inetAddress = InetAddress. getLocalHost();
			System.out.println("IP Address:- " + inetAddress. getHostAddress());
			System.out.println("Host Name:- " + inetAddress. getHostName());
			return inetAddress. getHostAddress();
		} catch(Exception e) {
			
		}
		return "bilinmiyor";
	}
}






