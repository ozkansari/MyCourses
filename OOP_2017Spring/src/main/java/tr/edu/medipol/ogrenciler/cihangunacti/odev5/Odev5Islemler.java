package tr.edu.medipol.ogrenciler.cihangunacti.odev5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import tr.edu.medipol.odev.odev5.*;

public class Odev5Islemler extends IslemlerOgrenci  {

	@Override
	public boolean ogrenciEkle(Ogrenci ogrenci) {
		// TODO Auto-generated method stub
		if(tumOgrenciler.add(ogrenci))
		return true;
		else
			return false;
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		// TODO Auto-generated method stub
		for (Ogrenci ogr : tumOgrenciler) {
			if(ogr.getNo().equals(ogrenciNo)){
				return true;
			}
		}
		return false;
	}

	public Ogrenci  ogrenciBul(String ogrenciNo) {
		// TODO Auto-generated method stub
		for (Ogrenci o : tumOgrenciler) {
			if(o.getNo().equals(ogrenciNo)){	
				System.out.println(o.getNo()+" "+o.getAdSoyad()+" "+o.ogrenciTipi());
				return o;
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
		// TODO Auto-generated method stub
		ArrayList<Ogrenci> ogr=new ArrayList<>(tumOgrenciler);
		return ogr;
		
	}

	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		// TODO Auto-generated method stub
		LinkedList<Ogrenci> list=new LinkedList<Ogrenci>(tumOgrenciler);
		return list;
	}

	@Override
	public Set<Ogrenci> ogrenciSet() {
		// TODO Auto-generated method stub
        Set Set1 = new HashSet(tumOgrenciler);
		return Set1;
	}

	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		// TODO Auto-generated method stub
		SortedSet<Ogrenci> sortedSet1=new TreeSet<Ogrenci>();
		for (Ogrenci ogr : tumOgrenciler) {
			sortedSet1.add(ogr);
		}
		return sortedSet1;
	}

	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		// TODO Auto-generated method stub
		Map<String, Ogrenci> map1 = new HashMap<>();
			for (Ogrenci ogr : tumOgrenciler) {
				map1.put(ogr.getNo(), ogr);
			}
		return map1;
	}

	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		// TODO Auto-generated method stub
	
        SortedMap<String, Ogrenci> sortedMap= new TreeMap();
        for (Ogrenci ogrenci : tumOgrenciler) {
			sortedMap.put(ogrenci.getNo(), ogrenci);
		}
		return sortedMap;
	}

}
