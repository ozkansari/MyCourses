package tr.edu.medipol.ilerijava.BerkeSecgin.ortak;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketYaziciThread4 extends SocketThreadUstSinif3 {

	private static final Logger LOGGER = Logger.getLogger(SocketYaziciThread4.class.getName());
	
	private PrintWriter socketMesajGonderici;
	
	private EkranUstSinif2 ekran;
	
	public SocketYaziciThread4(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		init(socketBaglantisi);
	}

	public SocketYaziciThread4(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
	}

	public SocketYaziciThread4(Socket socketBaglantisi, boolean sunucu, EkranUstSinif2 ekran) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
		this.ekran = ekran;
	}
	
	public void init(Socket socketBaglantisi) {
		socketMesajGonderici = SocketYardimciAraclari3.socketYaziciOlustur(socketBaglantisi);
		LOGGER.info("Yazici Thread olusturuldu" + socketIsmi);
	}
	
	@Override
	public void run() {
		LOGGER.info("Yazici Thread calisiyor" + socketIsmi);
		
		// rastgeleMesajGonder();
		
		while(true) {
			String mesaj = ekran.getMesajKuyrugu().poll();
			if (mesaj != null) {
				socketeMesajGonder(mesaj);
			} else {
				SocketYardimciAraclari3.threadBekle(1000);
			}
		}
		
	}

	public void rastgeleMesajGonder() {
		int beklemeSuresi = 5000;// 5000 ms = 5 sn bekle
		int i = 1;
		do  {
			String mesaj = socketIsmi + ">Mesaj " + i;
			socketeMesajGonder(mesaj); 
			SocketYardimciAraclari3.threadBekle(beklemeSuresi);
			i++;
		} while(true);
	}

	public void socketeMesajGonder(String mesaj) {
		if (mesaj != null) {
			System.out.println(mesaj + " gonderiliyor."); 
			socketMesajGonderici.println(socketHesapla(mesaj));
			socketMesajGonderici.flush();
		} 
	}
	
public static String socketHesapla(String d1) {
		
		String num="0123456789";
		String hesapisaretleri="+-*/";
		char[] d2 = d1.toCharArray();
		char[] nums = num.toCharArray();
		char[] hesap = hesapisaretleri.toCharArray();
		
		int indeks=0,hesaptur=0;
		for(int y=0; y<d2.length; y++) {
	       	 for (int x=0; x<hesap.length; x++) {
	            	if(hesap[x] == d2[y]) {
	            		indeks=y;
	            		hesaptur=x;
	            	}
	            }
	        }
		char spac=' ';
		String num1 = "";
		String num2 = "";
		for(int c=0; c<d2.length; c++) {
			for(int n=0; n<nums.length; n++) {
				if(d2[c]==spac) {
					continue;
				}
				else if(d2[c] == nums[n] && c<indeks) {
					num1 = num1+String.valueOf(d2[c]);
				}
				else if(d2[c] == nums[n] && c>indeks) {
					num2 = num2+String.valueOf(d2[c]);
				}
				else if(d2[c] != nums[n] || hesap[n]!=d2[c]) {
					//hesaptur=4;
				}
			}
		}
		double yanit=0;
		switch(hesaptur) {
		
		case 0:
			yanit=Integer.valueOf(num1) + Integer.valueOf(num2);
			break;
		case 1:
			yanit=Integer.valueOf(num1) - Integer.valueOf(num2);
			break;
		case 2:
			yanit=Integer.valueOf(num1) * Integer.valueOf(num2);
			break;
		case 3:
			yanit=Double.valueOf(num1) / Double.valueOf(num2);
			break;
		default : 
			System.out.println("Lütfen doðru seçim yapýnýz...");
			break;
		}
		return d1 = d1 + " " + Double.valueOf(yanit);
	}
}