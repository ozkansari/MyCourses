package tr.edu.medipol.ogrenciler.muhittinayri.odev6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

public class Odev6Islemler extends IslemlerGeneric<Ogrenci,String>{
	

	@Override
	public boolean kayitEkle(Ogrenci kayit) 
	{
	    kayitlar.add(kayit);
		System.out.println(String.format("��renci Numaras�= %s",kayit.getNo() +  " ��renci Ad� Soyad�= " + kayit.getAdSoyad() + " ��renci Tipi = " + kayit.ogrenciTipi()));
		return true;
	}

	@Override
	public boolean kayitSil(String kayitNo) {
		for(int i=0; i<kayitlar.size(); i++){
			Ogrenci ogrenci = kayitlar.get(i);
			if(ogrenci.getNo().equals(kayitNo)){
				System.out.println("Silinen ��rencinin Numaras�= " + ogrenci.getNo() + " Ad� ve Soyad�= "+ogrenci.getAdSoyad() + "��renci Tipi= " + ogrenci.ogrenciTipi());
				kayitlar.remove(i);
			}
			else if(ogrenci.getNo() != kayitNo){
					System.out.println("Kay�t Yok!");
				
			}
		}
		return false;
	}

	@Override
	public Ogrenci kayitBul(String kayitNo) {
		for(int i=0; i<kayitlar.size(); i++){
			Ogrenci ogrenci = kayitlar.get(i);
			if(ogrenci.getNo().equals(kayitNo))
			{
				System.out.println("Bulunan ��rencinin Numaras�= " + ogrenci.getNo() + " Ad� ve Soyad�= " + ogrenci.getAdSoyad() + " ��renci Tipi= " + ogrenci.ogrenciTipi());
				return ogrenci;
			}
			else if (ogrenci.getNo() != kayitNo)
			{
				System.out.println("Kay�t Yok!");
				return null;
			}
		}
		return null;
	}

	@Override
	public List kayitList() {
		List<Ogrenci> List = new ArrayList<Ogrenci>();
	    List.forEach(System.out::println);
		return kayitlar;
	}

	@Override
	public LinkedList kayitLinkedList() {
		
		LinkedList<Ogrenci> linkedlist = new LinkedList<Ogrenci>(); 
	    linkedlist.forEach(System.out::println);
		return null;
	}

	@Override
	public Set kayitSet() {
		
		Set<Ogrenci> SET = new HashSet<Ogrenci>();
	    SET.forEach(System.out::println);
		return null;
	}

	@Override
	public SortedSet kayitSortedSet() {
		
		SortedSet<Ogrenci> sortedSet1 = new TreeSet<Ogrenci>();
	    sortedSet1.forEach(System.out::println);
		return null;
	}

	@Override
	public Map kayitMap() {
		
		Map<String, Ogrenci> map = new TreeMap<String, Ogrenci>();
		return null;
	}

	@Override
	public SortedMap kayitSortedMap() {
		
		Map<String, Ogrenci> sortedMAP = new TreeMap<String, Ogrenci>();
		return null;
	}

}
