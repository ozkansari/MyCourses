package tr.edu.medipol.odev1.nurcankarakulleoglu1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/** ozkans Degerlendirme

Gecersiz Salih Terekli ile ayni.
Aciklama yapmadi.
Salih Terekli kendisinin yaptigini soyledi.

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 0/15
Dosyadan Okuma: 20/25
Dosyaya Yazma:  20/25
Genel Program: 5/15 (txt gonderim, dizi kullanimi)
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20
Benzer Kod Yazma Nedeniyle: -30
-----------------------------------
Sonuc: 35
*/

public class odev1 {
	
	private static Scanner ekranOkuyucu = new Scanner(System.in);
	private static String []ogrenciler = new String[15];
	
	private static int i = 0;
	
	public static void main(String[] args) {
		
		String str = "";
		try{
			
			FileInputStream file = new FileInputStream("Ogrenciler.txt");
			DataInputStream data = new DataInputStream(file);
			BufferedReader okuyucu = new BufferedReader(new InputStreamReader(data));
			
			while((str = okuyucu.readLine()) != null){
				ogrenciler[i] = str;
				i++;
			}
			data.close();
		}
		catch(Exception e)
		{
			System.err.println("Hata: " + e.getMessage());
		}
		
		while(true){
			ekranaMenuyuBas();
			
	        System.out.print("Secim yapiniz: ");
			int kullaniciSecimi = kullaniciGirdiAl();
			
			if(kullaniciSecimi == 1){
				ogrenciEkle();
			}
			if(kullaniciSecimi == 2){
				ogrenciSil();
			}
			
			if(kullaniciSecimi == 3){
				ogrenciListele();
			}
			if(kullaniciSecimi == 4){
				
				ekranOkuyucu.close();
				System.out.println("Program sonlaniyor.");
				System.exit(0);
				
			}
			
		}
		
    }
	
	
	
	
	
	
	
	
	private static void ekranaMenuyuBas() {
		System.out.println("*******************");
		System.out.println("MENU");
		System.out.println(" Ogrenci Ekle(1)");
		System.out.println(" Ogrenci Sil(2)");
		System.out.println(" Ogrenci Listele(3)");
		System.out.println(" Cikis(0)");
		System.out.println("*******************");
	}
	
	
	
	
	
	private static Integer kullaniciGirdiAl() {
		String kullaniciGirisi = "";
		int girdi = -1;
		try {
			kullaniciGirisi = ekranOkuyucu.nextLine();
			girdi = Integer.valueOf( kullaniciGirisi );
		} catch(Exception e) {
			System.out.println("Gecerli bir deger giriniz. Girdiginiz deger: " 
					+ kullaniciGirisi);
		}
		return girdi;
	}
	
	
	
	
	
	private static void ogrenciListele() {
		System.out.println("��rencilerin Listesi: ");
		int ogrenciListesi = 0;
		while(ogrenciler[ogrenciListesi] != null){
			System.out.println("("+ ogrenciListesi + ") " + ogrenciler[ogrenciListesi]);
			ogrenciListesi++;
		}
		
		
	}
	
	
	
	
	
	private static void ogrenciEkle(){
		System.out.println("��rencinin Ad�n� ve Soyad�n� Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();
		
		System.out.println("Ogrenci Tipini Giriniz (YL, Doktora vb.): ");
		String tip = ekranOkuyucu.nextLine();
		
		System.out.println("Ogrenci B�l�m�n� Giriniz (MYO, Isletme vb..) ");
		String bolum = ekranOkuyucu.nextLine();
		
		String yeni =bolum +" "+"b�l�m� "+" "+ tip+" "+"��rencisi"+" "+adSoyad;
		
		System.out.println(bolum +" "+"b�l�m� "+" "+ tip+" "+"��rencisi"+" "+adSoyad+" "+ "isimli ��renci eklendi"  );
		
		int kayit = 0; 
		
		while(ogrenciler[kayit] != null){
			kayit++;
		}
		ogrenciler[kayit] = yeni;
		
		FileWriter file = null;
		BufferedWriter writer = null;
		try{
			file = new FileWriter("Ogrenciler.txt");
			writer = new BufferedWriter(file);
			for(int i = 0; i < (kayit+1); i++){
				writer.write(ogrenciler[i]);
				writer.newLine();
			}
			writer.close();
		}
		catch(Exception e){
			
		}
		
	}
	
	private static void ogrenciSil(){
		ogrenciListele();
		System.out.println("Silmek istedi�iniz ��rencinin numaras�n� giriniz: ");
		Scanner delete = new Scanner(System.in);
		int silinen = delete.nextInt();
		int x = 0;
		while(ogrenciler[x] != null){
			x++;
		}
		
		for(int z=silinen; z<x; z++){
			ogrenciler[z] = ogrenciler[z+1];
		}
		
		FileWriter file= null;
		BufferedWriter writer = null;
		try{
			file= new FileWriter("Ogrenciler.txt");
			writer = new BufferedWriter(file);
			for(int i = 0; i < (x+1); i++){
				writer.write(ogrenciler[i]);
				writer.newLine();
			}
			writer.close();
		}
		catch(Exception e){
			
		}
		
		
	}
	
	
	
}