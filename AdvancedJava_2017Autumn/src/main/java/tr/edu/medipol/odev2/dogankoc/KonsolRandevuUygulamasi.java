package tr.edu.medipol.odev2.dogankoc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

// 100

// Tr karakter sorunlari (-5)
// Henuz ogretilmeyen konular (-5)
// Menü bonus (+10)

public class KonsolRandevuUygulamasi {

	static File dir; 
	static BufferedReader cin,in;
	static PrintWriter out;
	Scanner scn=new Scanner(System.in);
	static int kayitSayisi=0;
	static String path = System.getProperty("user.home") + File.separator + "Documents";
    static String tarihAyraci=null;
	static boolean kayitYapilacakmi=false;
	private List<Randevular> randevular=new LinkedList<Randevular>();
	static long baslangic,bitis;
	
	public static void main(String[] args) throws IOException ,FileNotFoundException
	{
		baslangic=System.currentTimeMillis();
		klasorOlustur() ;
        File file=new File(path+"\\Randevular\\randevular.txt");
        if(!file.exists())
        	file.createNewFile();
		//genel(rendevu) okuma i�in	
		cin=new BufferedReader(new InputStreamReader(System.in));
		//yedeklenen veri programa dahil etmek i�in
		in=new BufferedReader(new InputStreamReader(
				new FileInputStream(new File(path+"\\Randevular\\randevular.txt"))));
		
		KonsolRandevuUygulamasi uygulama= new KonsolRandevuUygulamasi();
		kayitYapilacakmi=uygulama.verileriAl();
		uygulama.menu();
		
	}
	
	public void menu() throws IOException
	{		
		System.out.println("---------MENU----------");
		System.out.println("Randevu Eklemek ��in        (1)");
		System.out.println("Randevular� Listelemek ��in (2)");
		System.out.println("Randevu Bulmak ��in         (3)");
		System.out.println("Randevu Silmek ��in         (4)");
		System.out.println("Programdan ��kmak ��in      (5)");
		System.out.println("-----------------------");
		int secim=Integer.parseInt(scn.nextLine());
		
		switch(secim){
		case 1:
			randevuAl();
			
			break;
		case 2:
			listele();
			break;
		case 3:
			randevuAra();
			break;
		case 4:
			randevuSil();
			break;
		case 5:
			//int k=JOptionPane.showConfirmDialog(null,"Kapan�yor...","BYE BYE" ,1,1);
			//System.out.println(k);
			//if(k==0)
			if(kayitYapilacakmi){
				   verileriKaydet();
			}
		
			System.out.println("��kmak istedi�ine eminmisin Evet(1)");
			int cikilacakmi=Integer.parseInt(scn.nextLine());
			if(cikilacakmi==1){
				in.close();
				cin.close();
				bitis=System.currentTimeMillis();
				int gecenSure=(int)((bitis-baslangic)/1000);
				System.out.println(gecenSure+" saniyedir program �al���yor");
				System.exit(1);
			}
			   
			break;
		default:
			System.out.println("Hatal� Giri� Tekrar Deneyin..");
			menu();
		}
		menu();
	}
	
	
	public boolean verileriAl() throws IOException
	{
		

		while(in.ready()){
			String randevuAdi=in.readLine();
			String randevuTarihi=in.readLine();
			String randevuYeri=in.readLine();
			if(randevuTarihi.contains("/"))
				tarihAyraci="/";
			else if(randevuTarihi.contains("."))
				tarihAyraci=".";
			else if(randevuTarihi.contains(":"))
				tarihAyraci=":";
			else if(randevuTarihi.contains(" "))
				tarihAyraci=" ";
			
				Randevular randevu=new Randevular(randevuAdi,randevuTarihi,randevuYeri,tarihAyraci);
				kayitSayisi++;
				randevular.add(randevu);
			
		
		}
		if(kayitSayisi<=5){
			in.close();
			return true;
		}
		else return false;
	}
	
	public void verileriKaydet() throws IOException{
		
		//program verilerini saklamak i�in
		out=new PrintWriter(new OutputStreamWriter(
				new FileOutputStream(new File(path+"\\Randevular\\randevular.txt"))));
		
		SimpleDateFormat format_n=new SimpleDateFormat("dd"+tarihAyraci+"MM"+tarihAyraci+"yyyy");
		for(Randevular obj:randevular){
		  
				out.println(obj.getRandevuAdi());
				
				out.println(format_n.format(obj.getRandevuTarihi()));
			
				out.println(obj.getRandevuYeri());
				
				//out.flush();
		}
		out.close();
	}
	
	public void randevuAl() throws IOException
	{
		if(kayitSayisi==5){
			System.out.println("en fazla 5 randevu kaydedebilirsiniz..");
			return;
		}
		System.out.println("Randevular�n�z� Girin:");
		System.out.println("Randevu Ad�:");
		String randevuAdi=cin.readLine();
		
		System.out.println("Randevu Tarihi:");
		String randevuTarihi=cin.readLine();
		/*
		 *BUrada direk kullan�c�n�n girdi�i tarih al�n�p parse edilip date olark tutulabilir 
		 *ancak hatal� tarih giri�leri i�in kontrol sa�layamayacakt�m 
		  long randevuTarihi2=Date.parse(cin.readLine());
		  Date randavuDate=new Date(randevuTarihi2);
		*/
		
		if(randevuTarihi.contains("/"))
			tarihAyraci="/";
		else if(randevuTarihi.contains("."))
			tarihAyraci=".";
		else if(randevuTarihi.contains(":"))
			tarihAyraci=":";
		else if(randevuTarihi.contains(" "))
			tarihAyraci=" ";
		/*String tarihsablonu="^[0-9]{1,2}\\[./:\\][0-9]{1,2}\\[./:\\][0-9]{4}";
		Pattern pattern=Pattern.compile(tarihsablonu);
		Matcher matcher=pattern.matcher(randevuTarihi);*/
		if(tarihAyraci!=null){				
				System.out.println("Randevu Yeri:");
				String randevuYeri=cin.readLine();
				tarihAyraci=String.valueOf(tarihAyraci);
				Randevular randevu=new Randevular(randevuAdi,randevuTarihi,randevuYeri,tarihAyraci);
				randevular.add(randevu);	
				kayitSayisi++;
		}
			
		else{
			System.out.println("tarih formata uygun de�il..\n"
					            + "tekrar denemek i�in 1 ��kmak i�in 0 a bas�p enter a bas�n..");
			Integer devammi=0;
			devammi=Integer.valueOf(cin.readLine());
			if(devammi==1){
				randevuAl();
			}else
				System.exit(1);
		}

	}
	
	
	public void listele()
	{
		int adet=0;
		SimpleDateFormat format_n=new SimpleDateFormat("dd/MM/yyyy");
		for(Randevular obj:randevular){
			System.out.printf("%d. RANDEVU:\n",adet+1);
			
	    	System.out.println(obj.getRandevuAdi()+"\n"+obj.getRandevuYeri()+"\n"
	    	                   +format_n.format(obj.getRandevuTarihi()));
			adet++;
		}
	}
	
	public void randevuAra() throws IOException
	{
		SimpleDateFormat format_n=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Bulmak istedi�iniz randevu ad�n� yerini yada tarihini girin:");
		String aranan= cin.readLine();
		
		for(Randevular obj:randevular){
		    int dogrulaAd = obj.compareTo(aranan);
		    if(dogrulaAd==0){
		    	System.out.println("----BULUNAN RANDEVU----");
		    	System.out.println(obj.getRandevuAdi()+"\n"+obj.getRandevuYeri()+"\n"
		    			 +format_n.format(obj.getRandevuTarihi()));
		    	
		    }else{
		    	System.out.println("----ARANAN RANDEVU KAYITLARDA YOK----");
		    }
			
		}
	}
	
	
	public void randevuSil() throws IOException
	{
		SimpleDateFormat format_n=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Silmek istedi�iniz randevu ad�n� yerini yada tarihini girin:");
		String arananStr= cin.readLine();
		char[] arananKatar=new char[arananStr.length()];
		for(int i=0;i<arananKatar.length;i++){
			arananKatar[i]=arananStr.charAt(i);
		}
		for(int i=0;i<randevular.size();i++){
		    int dogrulaAd = randevular.get(i).compareTo(arananStr);
		    if(dogrulaAd==0){
		    	System.out.println(randevular.get(i).getRandevuAdi()+"\n"+randevular.get(i).getRandevuYeri()+"\n"
		    			 +format_n.format(randevular.get(i).getRandevuTarihi()));
		    	
		    	System.out.println("BU KAYIT S�L�NECEK EM�NM�S�N evet(1)");
		    	int silinecekmi=Integer.valueOf(cin.readLine()) ;
		    	if(silinecekmi==1){
		    		randevular.remove(randevular.get(i));
		    		System.out.println("BU KAYIT S�L�ND�");
		    	}
		    }else{
		    	System.out.println("B�YLE B�R RANDEVUNUZ YOK");
		    }
			
		}
	}
	

	
	 private static void klasorOlustur() {
	        dir= new File(path+"\\Randevular");
	        if(!dir.exists()){
	        	dir.mkdir(); // Klas�r olu�turuluyor
	        	System.out.println("Klas�r olu�turuldu");
	        }
	           
	    }

}
