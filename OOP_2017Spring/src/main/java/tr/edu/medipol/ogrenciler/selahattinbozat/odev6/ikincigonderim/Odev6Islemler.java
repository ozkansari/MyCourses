package tr.edu.medipol.ogrenciler.selahattinbozat.odev6.ikincigonderim;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import tr.edu.medipol.odev.odev6.*;

import tr.edu.medipol.odev.Ogrenci;

public class Odev6Islemler extends IslemlerGeneric<Ogrenci,String>{
	

	@Override
	public boolean kayitEkle(Ogrenci kayit) 
	{
		if(kayitlar.add(kayit))
		{
			System.out.println(String.format("Kay�t No : Kay�t Ad� ve Soyad� :   Kay�t Tipi : ",kayit.getNo(),kayit.getAdSoyad(),kayit.ogrenciTipi()));
			return true;
			}
			else
			{
		return false;
			}
	}

	@Override
	public boolean kayitSil(String kayitNo) {
		if(kayitlar.remove(kayitNo))
		{
			System.out.println("Kay�t Silindi.");
			return true;
		}
		else
		{
			System.out.println("Kay�t Silenemedi.");
		return false;
		}
	}

	@Override
	public Ogrenci kayitBul(String kayitNo) {
		if(kayitlar.contains(kayitNo))
		{
	        System.out.printf("Kay�t Bulundu..", kayitNo);
		}
		else
		{
		return null;
		}
		return null;
	}

	@Override
	public List<Ogrenci> kayitList() {
		for(int i=0; i<=kayitlar.size(); i++) 
		{
			Ogrenci listeleme = kayitlar.get(i);
			System.out.println("Kay�t Numaras�: "+listeleme.getNo());
		}
		return null;
	}

	@Override
	public LinkedList<Ogrenci> kayitLinkedList() {
		
		LinkedList<Ogrenci> linkedlist = new LinkedList<Ogrenci>(); 
	    linkedlist.forEach(System.out::println);
		return null;
	}

	@Override
	public Set<Ogrenci> kayitSet() {
		
		Set<Ogrenci> SET = new HashSet<Ogrenci>();
	    SET.forEach(System.out::println);
		return null;
	}

	@Override
	public SortedSet<Ogrenci> kayitSortedSet() {
		
		
		return null;
	}

	@Override
	public Map<String, Ogrenci> kayitMap() {
		
		
		return null;
	}

	@Override
	public SortedMap<String, Ogrenci> kayitSortedMap() {
		
		
		return null;
	}

}
