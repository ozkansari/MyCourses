package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev5;

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

import tr.edu.medipol.odev.Ogrenci;
import tr.edu.medipol.odev.odev5.IslemlerOgrenci;



public class Odev5Islemler extends IslemlerOgrenci {

	@Override
	public boolean ogrenciEkle(Ogrenci ogrenci) {
		try{
		    tumOgrenciler.add(ogrenci);
		}catch(Exception e){
			e.getMessage();
		}
		return true;
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		
		try{
			for (Ogrenci ogrenciler : tumOgrenciler) {
		
			if(ogrenciler.getNo().equals(ogrenciNo)){
				tumOgrenciler.remove(ogrenciler);
				return true;
			 }
			}
		}catch(Exception e){
		return false;
		}
		return false;
	}

	@Override
	public Ogrenci ogrenciBul(String ogrenciNo){
		for (Ogrenci ogrenci : tumOgrenciler) {
			if(ogrenci.getNo().equals(ogrenciNo)){
				return ogrenci;
			}
		}				
		return null;
	}

	@Override
	public List<Ogrenci> ogrenciList() {
		
		return tumOgrenciler;
	}

	@Override
	public List<Ogrenci> ogrenciSiraliList() {
		
		List<Ogrenci> ogrSiraliList = new ArrayList<>(tumOgrenciler);
			return ogrSiraliList;
	}

	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		LinkedList<Ogrenci> ogrLinkedList = new LinkedList<Ogrenci>(tumOgrenciler);
		return ogrLinkedList;
	}

	@Override
	public Set<Ogrenci> ogrenciSet() {
		Set<Ogrenci> ogrSet = new HashSet<Ogrenci>(tumOgrenciler);
		return ogrSet;
	}

	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		
		SortedSet<Ogrenci> sortedSetOgrnc = new TreeSet<Ogrenci>();
		for (Ogrenci ogrenci : tumOgrenciler) {
			sortedSetOgrnc.add(ogrenci);
		}
		
		return sortedSetOgrnc;
	}

	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		
		Map<String, Ogrenci> ogrncMap = new HashMap<>();
			for (Ogrenci ogrenci : tumOgrenciler) {
				ogrncMap.put(ogrenci.getNo(), ogrenci);
			}
		return ogrncMap;
	}

	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		
		SortedMap<String, Ogrenci> ogrncSortedMap = new TreeMap<String, Ogrenci>();
		for (Ogrenci ogrenci : tumOgrenciler) {
			ogrncSortedMap.put(ogrenci.getNo(), ogrenci);
		}
		return ogrncSortedMap;
	}
}
