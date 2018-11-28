package tr.edu.medipol.ilerijava.vize.TahaKeskin.ortak;

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
			String siradakiMesaj = ekran.getMesajKuyrugu().poll();
			if (siradakiMesaj != null) {
				socketeMesajGonder(siradakiMesaj);
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
			String a=(mesaj);
			socketeMesajGonder(a); 
			SocketYardimciAraclari3.threadBekle(beklemeSuresi);
			i++;
		} while(true);
	}

	public void socketeMesajGonder(String mesaj) {
		if (mesaj != null) {
			System.out.println(mesaj + " gonderiliyor.");
			socketMesajGonderici.println(mesaj + " = " +islembul(mesaj));
			socketMesajGonderici.flush();
		} 
	}
	
	
	
		public String  islembul(String gelendeger) {
		
		gelendeger = gelendeger.replace(" ", "");
    	String islem = "*/+-";
    
    	char [] a = gelendeger.toCharArray();
    	char [] yislem = islem.toCharArray();
    
    	String islemturu="",indexnolari="";
    
    	for(int i=0;i<a.length;i++) {
   	 		for (int x=0; x<yislem.length ;x++) {
   	 			if(yislem[x] == a[i]) {
   	 				islemturu= islemturu + yislem[x];
   	 				indexnolari=indexnolari+String.valueOf(i)+ " ";
   	 			}
   	 		}
    	}	 
	 	String[] index = indexnolari.split(" ");
	    int[] indexx= new int [index.length];
	 	for(int i=0;i<index.length;i++) {
	 	indexx[i] =Integer.parseInt(index[i]);
	 	}
	
	 	return sayilaraislemyap(gelendeger,indexx,islemturu );
		}
	
		public String sayilaraislemyap(String gelendeger, int dizi[], String islemler) {

        char [] yislem = islemler.toCharArray();
        String s1="",s2="",silinecek="";
        int sonuc=0 ;
        
        for(int i=0;i<yislem.length;i++) {
				if(yislem.length==1) {
        			s1 = gelendeger.substring(i, dizi[i]);
        			s2 = gelendeger.substring(dizi[i]+1);
        			silinecek= gelendeger.substring(i);
        				
					if(yislem[i]=='*') {
    					sonuc= Integer.valueOf(s1)* Integer.valueOf(s2);
    					gelendeger = gelendeger.replace(silinecek, String.valueOf(sonuc));
    					}
        			
    				else if(yislem[i]=='/') {
    					sonuc= Integer.valueOf(s1)/ Integer.valueOf(s2);
        				gelendeger = gelendeger.replace(silinecek, String.valueOf(sonuc));
        				}
					else if (yislem[i] =='+') {
        				sonuc= Integer.valueOf(s1)+ Integer.valueOf(s2);
        				gelendeger = gelendeger.replace(silinecek, String.valueOf(sonuc));
        				}
        			else {
        				sonuc= Integer.valueOf(s1)- Integer.valueOf(s2);
        				gelendeger = gelendeger.replace(silinecek, String.valueOf(sonuc));
        				}
					}		
        		}
        return gelendeger;
		}
}