package tr.edu.medipol.ogrenciler.muhammetaktas.odev3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


	public class Notlar {
	    private String AdSoyad;
	    private int Notlar;
		private static Scanner adSoyadScn,notScn,ogrenciSayisiScn;
		public Notlar(String ogrenci,int Not) {
			AdSoyad=ogrenci;
			Notlar=Not;
		}
		public static void main(String[] args) {
			  String AdSoyad;
			  int Notlar;
			  int ogrenciSayisi;
			  System.out.println("Girisi yapilacak ogrenci sayisini giriniz : ");
			  List<Notlar> ogrencilerListesi=new ArrayList<>();
			  adSoyadScn = new Scanner(System.in);
			  notScn = new Scanner(System.in);
			  ogrenciSayisiScn = new Scanner(System.in); 
			  ogrenciSayisi=ogrenciSayisiScn.nextInt();
			  
			for(int i=0;i<ogrenciSayisi;i++){
				System.out.println((i+1)+".Ogrenci:");
				System.out.println("Ad Soyad: ");
				AdSoyad=adSoyadScn.nextLine();
				System.out.println("Not: ");
				Notlar=notScn.nextInt();
				ogrencilerListesi.add(new Notlar(AdSoyad,Notlar));
			}
			for(int i=0;i<ogrenciSayisi;i++){
	          	Notlar a=ogrencilerListesi.get(i);
				System.out.println("Ad Soyad: "+a.AdSoyad+" - "+ " Not:"+a.Notlar);
			}
			
			
		}


	}

