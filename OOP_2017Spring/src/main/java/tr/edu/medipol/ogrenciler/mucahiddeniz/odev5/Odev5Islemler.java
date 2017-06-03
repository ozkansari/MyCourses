package tr.edu.medipol.ogrenciler.mucahiddeniz.odev5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Scanner;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

public class Odev5Islemler extends IslemlerOgrenci {

	@Override
	public boolean ogrenciEkle(Ogrenci ogrenci) {
		boolean basari = tumOgrenciler.add(ogrenci);
		System.out.println(String.format("��renci NO:: %s - ��renci Ad� ve Soyad� : %s", ogrenci.getNo(),ogrenci.getAdSoyad()));
		return basari;
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		int index = 1;
		boolean aramaSonuc = false;
		
		System.out.println("Aran�yor..");
		for(int i=0; i<tumOgrenciler.size(); i++){
			Ogrenci n = tumOgrenciler.get(i);
			if(n.getNo() == ogrenciNo){ 
				System.out.println("��renci veritaban�nda bulundu, silme i�lemi yap�ld�.");
				System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+ " - Numaras�: "+n.getNo());
				index = i+1;
				tumOgrenciler.remove(i);
				aramaSonuc = true;
				break;
			}
		}
		
		if(aramaSonuc != true){
			System.out.println("Kay�t Bulunamad�!");
		}
		return false;
	}

	@Override
	public Ogrenci ogrenciBul(String ogrenciNo) {
		int index = 1;
		boolean aramaSonuc = false;
		System.out.println("Aran�yor..");
		for(int i=0; i<tumOgrenciler.size(); i++){
			Ogrenci n = tumOgrenciler.get(i);
			if(n.getNo() == ogrenciNo){
				System.out.println("��renci veritaban�nda bulundu");
				System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+ " - Numaras�: "+n.getNo());
				index = i+1;
				aramaSonuc = true;
				break;
			}
		}
		
		if(aramaSonuc != true){
			System.out.println("Kay�t bulunamad�!");
		}	
		return null;
	
	}

	@Override
	public List<Ogrenci> ogrenciList() {
		int i=0;
		while(i<tumOgrenciler.size()){
			Ogrenci n = tumOgrenciler.get(i);
			System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+" - Numaras�: "+n.getNo());
			i++;
		}
		return null;
	}

	@Override
	public List<Ogrenci> ogrenciSiraliList() {
		int i=0;
		
		while(i<tumOgrenciler.size()){
			Ogrenci n = tumOgrenciler.get(i);
			System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+" - Numaras�: "+n.getNo());
			i++;
		}
		return null;
	}

	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		LinkedList<Ogrenci> linked = new LinkedList<>();
		linked.addAll(tumOgrenciler);
		
		for (Ogrenci n : linked) {
			System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+" - Numaras�: "+n.getNo());
		}
		
		
		return null;
	}

	@Override
	public Set<Ogrenci> ogrenciSet() {
		Set<Ogrenci> sett = new HashSet<>();
		sett.addAll(tumOgrenciler);
		
		for (Ogrenci n : sett) {
			System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+" - Numaras�: "+n.getNo());
		}
		return null;
	}

	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		
		//SortedSet<Ogrenci> sorted = new HashSet<>();
		return null;
	}

	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		return null;
	}

	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		return null;
	}

}
