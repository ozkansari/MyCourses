package tr.edu.medipol.ogrenciler.mucahiddeniz.odev6;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;


public class Odev6Islemler extends IslemlerGeneric<Ogrenci, String>{

	@Override
	public boolean kayitEkle(Ogrenci kayit) {
		boolean basari = kayitlar.add(kayit);
		System.out.println(String.format("��renci NO: %s - Ad� ve Soyad� : %s", kayit.getNo(),kayit.getAdSoyad()));
		return basari;
	}

	@Override
	public boolean kayitSil(String kayitNo) {
		int index = 1;
		boolean aramaSonuc = false;
		
		System.out.println("Aran�yor..");
		for(int i=0; i<kayitlar.size(); i++){
			Ogrenci n = kayitlar.get(i);
			if(n.getNo() == kayitNo){
				System.out.println("��renci veritaban�nda bulundu, silme i�lemi yap�ld�.");
				System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+ " - Numaras�: "+n.getNo());
				index = i+1;
				kayitlar.remove(i);
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
	public Ogrenci kayitBul(String kayitNo) {
		int index = 1;
		boolean aramaSonuc = false;
		
		System.out.println("Aran�yor..");
		for(int i=0; i<kayitlar.size(); i++){
			Ogrenci n = kayitlar.get(i);
			if(n.getNo() == kayitNo){
				System.out.println("��renci veritaban�nda bulundu.");
				System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+ " - Numaras�: "+n.getNo());
				index = i+1;
				aramaSonuc = true;
				break;
			}
		}
		
		if(aramaSonuc != true){
			System.out.println("Kay�t Bulunamad�!");
		}
		return null;
	}

	@Override
	public List<Ogrenci> kayitList() {
		int i=0;
		while(i<kayitlar.size()){
			Ogrenci n = kayitlar.get(i);
			System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+" - Numaras�: "+n.getNo());
			i++;
		}
		return null;
	}

	@Override
	public LinkedList<Ogrenci> kayitLinkedList() {
		LinkedList<Ogrenci> linked = new LinkedList<>();
		linked.addAll(kayitlar);
		
		for (Ogrenci n : linked) {
			System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+" - Numaras�: "+n.getNo());
		}
		return null;
	}

	@Override
	public Set<Ogrenci> kayitSet() {
		Set<Ogrenci> setlist = new HashSet<>();
			setlist.addAll(kayitlar);
			
			for (Ogrenci n : setlist) {
				System.out.println("Ad� ve Soyad�: "+n.getAdSoyad()+" - Numaras�: "+n.getNo());
			}
			
		return null;
	}

	@Override
	public SortedSet<Ogrenci> kayitSortedSet() {
		TreeSet three = new TreeSet<>();
		three.addAll(kayitlar);
		
		Iterator k = three.iterator();
		
		for(int i=0; i<three.size(); i++){
			Iterator n = three.iterator();
			System.out.println(n.next());
		}
		return null;
	}

	@Override
	public Map<String, Ogrenci> kayitMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedMap<String, Ogrenci> kayitSortedMap() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}