package tr.edu.medipol.ogrenciler.cihangunacti.odev6;

import java.util.HashMap;
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

public class Odev6Islemler extends IslemlerGeneric<Ogrenci, String>{

	@Override
	public boolean kayitEkle(Ogrenci kayit) {
		// TODO Auto-generated method stub
		if(kayitlar.add(kayit))
		return true;
		else
			return  false;
	}

	@Override
	public boolean kayitSil(String kayitNo) {
		// TODO Auto-generated method stub
		for (Ogrenci ogr : kayitlar) {
			if(ogr.getNo().equals(kayitNo)){
				kayitlar.remove(ogr);
				return true;
		}
			}
		return false;
		}

	@Override
	public Ogrenci kayitBul(String kayitNo) {
		// TODO Auto-generated method stub
		for (Ogrenci ogr : kayitlar) {
			if(ogr.getNo().equals(kayitNo)){
				return ogr;
			}
		}
		return null;
	}

	@Override
	public List kayitList() {
		// TODO Auto-generated method stub
		return kayitlar;
	}

	@Override
	public LinkedList kayitLinkedList() {
		// TODO Auto-generated method stub
		
		LinkedList<Ogrenci> list=new LinkedList<Ogrenci>(kayitlar);
		return list;
	}

	@Override
	public Set kayitSet() {
		// TODO Auto-generated method stub
		
		Set Set1=new HashSet(kayitlar);
		return Set1;
	}

	@Override
	public SortedSet<Ogrenci> kayitSortedSet() {
		// TODO Auto-generated method stub
		
		SortedSet<Ogrenci> sortedSet1=new TreeSet<>();
		for (Ogrenci ogr : kayitlar) {
			sortedSet1.add(ogr);
		}
		return sortedSet1;
	}

	@Override
	public Map kayitMap() {
		// TODO Auto-generated method stub
		
		Map<String,Ogrenci> map1=new HashMap<>();
		for (Ogrenci ogr : kayitlar) {
			map1.put(ogr.getNo(), ogr);
		}
		return map1;
	}

	@Override
	public SortedMap kayitSortedMap() {
		// TODO Auto-generated method stub
		
		SortedMap<String, Ogrenci>sortedMap=new TreeMap(); 
		for (Ogrenci ogr : kayitlar) {
			sortedMap.put(ogr.getNo(), ogr);
		}
		return sortedMap;
	}



}
