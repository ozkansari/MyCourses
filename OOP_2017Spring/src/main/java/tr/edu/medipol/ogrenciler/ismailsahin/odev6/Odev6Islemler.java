package tr.edu.medipol.ogrenciler.ismailsahin.odev6;

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

public class Odev6Islemler extends IslemlerGeneric<Ogrenci, String> {

	public boolean kayitEkle(Ogrenci kayit) {
		kayitlar.add(kayit);
		return true;
	}

	@Override
	public boolean kayitSil(String kayitNo) {
		for (Ogrenci ogr : kayitlar) {
			if (ogr.getNo() == kayitNo) { // ozkans string karsilastirma equals olmali
				kayitlar.remove(ogr);
				return true;
			}
		}
		return false;
	}

	@Override
	public Ogrenci kayitBul(String kayitNO) {
		for(Ogrenci ogr : kayitlar){
			if(ogr.getNo().equals(kayitNO)){
				return ogr;
			}
		}
		return null;
	}

	@Override
	public List<Ogrenci> kayitList() {
		if (kayitlar.size() > 0) {
			return kayitlar;
		} else {
			return null;
		}
	}

	@Override
	public LinkedList<Ogrenci> kayitLinkedList() {
		LinkedList<Ogrenci> ll = new LinkedList<Ogrenci>();
		for (int i = 0; i < kayitlar.size(); i++) {
			ll.add(kayitlar.get(i));
		}
		return ll;
	}
	

	@Override
	public Map<String, Ogrenci> kayitMap() {
		Map<String, Ogrenci> map = new HashMap<String, Ogrenci>();
		for (int i = 0; i < kayitlar.size(); i++) {
			map.put(kayitlar.get(i).getNo(), kayitlar.get(i));
		}
		return map;
	}
	
	@Override
	public SortedMap<String, Ogrenci> kayitSortedMap() {
		SortedMap<String, Ogrenci> map = new TreeMap<String, Ogrenci>();
		for (int i = 0; i < kayitlar.size(); i++) {
			map.put(kayitlar.get(i).getNo(), kayitlar.get(i));
		}
		return map;
	}
	
	@Override
	public Set<Ogrenci> kayitSet() {
		Set<Ogrenci> st = new HashSet<Ogrenci>(kayitlar);
		return st;
	}

	@Override
	public SortedSet<Ogrenci> kayitSortedSet() {
		SortedSet<Ogrenci> st = new TreeSet<Ogrenci>(kayitlar);  //?
		return st;
	}

}
