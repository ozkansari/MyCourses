package tr.edu.medipol.odev2.cihangunacti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// 100

//TR sinif ismi - encoding sorunu (-10)
// menü bonus (+10)

// public class �dev2 {
public class Ödev2 {

	public static void main(String[] args) throws ParseException {
		// Kullan�c�dan tarih saat al�n�z bunlar� bir date i�inde tutun ve ekrana bas�n
		// program�n�z ka� saniye
		// �al���yor
		List<String> liste = new ArrayList<String>();
		
		// String randevuGirdi , yerGirdi, g�nGirdi, ayGirdi, y�lGirdi, saatGirdi, dakikaGirdi,tarihGirdi;
		String randevuGirdi , yerGirdi, gunGirdi, ayGirdi, yilGirdi, saatGirdi, dakikaGirdi,tarihGirdi;
		
		long start = System.currentTimeMillis();
		
		SimpleDateFormat ft2 = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Scanner scn = new Scanner(System.in);
		while(true) {

		System.out.println("L�tfen Randevu Almak i�in 1 Tu�una bas�n�z");
		System.out.println("L�tfen Randevu Listelemek i�in 2 Tu�una bas�n�z");
		System.out.println("Programdan ��kmak i�in  3 Tu�una bas�n�z");
		// int men� = scn.nextInt();
		int menu = scn.nextInt();
		// if(men�==1) {
		if(menu==1) {
			System.out.println("Randevu Adetini Giriniz:");
			int adet=scn.nextInt();
			scn.nextLine();
			for (int i = 0; i < adet; i++) {
				System.out.println("Randevu'nun Ad�n� Giriniz:");
				randevuGirdi = scn.nextLine();
				liste.add(randevuGirdi);
				System.out.println("Randevu'nun Yerini Giriniz:");
				yerGirdi = scn.nextLine();
				liste.add(yerGirdi);
				System.out.println("Randavunun Tarihini dd.MM.YY HH:mm format�nda giriniz:");
				tarihGirdi=scn.nextLine();
				liste.add(tarihGirdi);
				/*System.out.println("Randevu'nun G�n'�n� giriniz:");
				g�nGirdi = scn.next();
				liste.add(g�nGirdi);
				System.out.println("Randevu'nun Ay'�n� giriniz:");
				ayGirdi = scn.next();
				liste.add(ayGirdi);
				System.out.println("Randevu'nun  Y�l'�n� giriniz:");
				y�lGirdi = scn.next();
				liste.add(y�lGirdi);
				System.out.println("Randevu'nun Saat'ini giriniz:");
				saatGirdi = scn.next();
				dakikaGirdi = scn.next();
				liste.add(saatGirdi);
				liste.add(dakikaGirdi);*/
				
			}
		}
		
		// if(men�==2) {
		if(menu==2) {
			if(liste.isEmpty()==true) {
				System.out.println("-------------------------------------------------");
				System.out.println("L�tfen Randevu Ekledikten sonra Listeleyiniz...!");
				System.out.println("-------------------------------------------------");
			}
			if(liste.isEmpty()==false) {
				
					System.out.println("");
					System.out.println("---------------RANDEVULAR-----------------------");
					int sayac = 0;
					for (int i = 0; i <liste.size()/3; i++) {
						System.out.println("Randevu Ad�:" + liste.get(sayac));//sayac=0
						System.out.println("Randevu Yeri:" + liste.get(sayac + 1));//sayac=1
						System.out.print("Randevu Tarihi:");
						Date dNow = ft2.parse(liste.get(sayac + 2)); 
						//+ "." + liste.get(sayac + 3) + "." + liste.get(sayac + 4)
						//sayac=2 -//sayac=3 -//sayac=4 //sayac=5  //sayac=6
								//+ " " + liste.get(sayac + 5) + ":" + liste.get(sayac + 6));
						System.out.println(ft2.format(dNow));
						System.out.println("-------------------------------");
						sayac += 3;
					}
						
					
						
				
			}
		}
		// if(men�==3) {
		if(menu==3) {
				long end = System.currentTimeMillis();
				long dif = end - start;
				System.out.println("Program " + dif / 1000 + " Saniyede �al��t�");
				System.exit(1);
			
			
		}
		// else if(men�!=1 && men�!=2 &&men�!=3 )
		else if(menu!=1 && menu!=2 &&menu!=3 )
		{
			System.out.println("-----------------------------------------------------");
			System.out.println("Yanl�� ��lem Girdiniz.L�tfen �stenen ��lemi Giriniz!");
			System.out.println("-----------------------------------------------------");
		}
		
}

		}
}

	



