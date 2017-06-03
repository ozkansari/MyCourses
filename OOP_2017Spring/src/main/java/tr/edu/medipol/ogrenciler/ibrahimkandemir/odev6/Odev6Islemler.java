package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev6;

import java.util.ArrayList;
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
import tr.edu.medipol.odev.odev6.IslemlerGeneric;

public class Odev6Islemler extends IslemlerGeneric<Ogrenci, String> {

	@Override
	public boolean kayitEkle(Ogrenci kayit) {
		if(kayitlar !=null){
			kayitlar.add(kayit);
			return true;
		}
		return false;
	}

	@Override
	public boolean kayitSil(String kayitNo) {
		
		for (Ogrenci ogrenci : kayitlar) {
			if(ogrenci.getNo().equals(kayitNo)){
				kayitlar.remove(ogrenci);
				return true;
			}
		}		
		return false;
	}

	@Override
	public Ogrenci kayitBul(String kayitNo) {
		for (Ogrenci ogrenci : kayitlar) {
			if(ogrenci.getNo().equals(kayitNo)){
				return ogrenci;
			}
		}
		return null;
	}

	@Override
	public List<Ogrenci> kayitList() {
		List<Ogrenci> kayitList = new ArrayList<>(kayitlar);
		return kayitList;
	}

	@Override
	public LinkedList<Ogrenci> kayitLinkedList() {
		LinkedList<Ogrenci> kayitLinkedList = new LinkedList<>(kayitlar);
		return kayitLinkedList;
	}

	@Override
	public Set<Ogrenci> kayitSet() {
		Set<Ogrenci> ogrnciKayitSet = new HashSet<Ogrenci>(kayitlar);
		return ogrnciKayitSet;
	}

	@Override
	public SortedSet<Ogrenci> kayitSortedSet() {
		SortedSet<Ogrenci> ogrncSortedSet = new TreeSet<Ogrenci>(kayitlar);
		return ogrncSortedSet;
	}

	@Override
	public Map<String, Ogrenci> kayitMap() {
		Map<String, Ogrenci> ogrncMap = new HashMap<>();
		for (Ogrenci ogrenci : kayitlar) {
			ogrncMap.put(ogrenci.getNo(), ogrenci);
		}
		return ogrncMap;
	}

	@Override
	public SortedMap<String, Ogrenci> kayitSortedMap() {
		SortedMap<String, Ogrenci> ogrncSortedMap = new TreeMap<>();
		for (Ogrenci ogrenci : kayitlar) {
			ogrncSortedMap.put(ogrenci.getNo(), ogrenci);
		}
		return ogrncSortedMap;
	}

}
