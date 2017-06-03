package tr.edu.medipol.ogrenciler.erenyazici.odev5;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

public class Eren extends IslemlerOgrenci {

	@Override
	public boolean ogrenciEkle(Ogrenci ogrenci) {
		tumOgrenciler.add(ogrenci);
		return true;
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		tumOgrenciler.remove(ogrenciNo);
		return true;
	}

	@Override
	public Ogrenci ogrenciBul(String ogrenciNo) {
		
		ogrenciNo.contains("1111");
		return null;
	}

	@Override
	public List<Ogrenci> ogrenciList() {
		System.out.println(tumOgrenciler);
		return tumOgrenciler;
		}
	

	@Override
	public List<Ogrenci> ogrenciSiraliList() {
		tumOgrenciler.sort(null);
		return tumOgrenciler;
	}

	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		
		LinkedList<Ogrenci> linkedList = new LinkedList<>();
		for (Ogrenci ogrenci : tumOgrenciler) {
			linkedList.add(ogrenci);
		}
		
		return linkedList;
	}

	@Override
	public Set<Ogrenci> ogrenciSet() {

		Set<Ogrenci> hashSet1 = (Set<Ogrenci>) new HashSet(tumOgrenciler);
		 hashSet1.forEach(System.out::println);
		
		
		return hashSet1;
	}

	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		
		return null;
		
	}

	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		
		Map<String, Ogrenci> map1 = new HashMap<>();
		
		for(Ogrenci ogrenci : tumOgrenciler) {
			map1.put("eren",ogrenci);
		}
		
		return map1;
	}

	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		
		
		return null;
	}
		
		
}


