package tr.edu.medipol.ogrenciler.didemlaloglu.odev5;


import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

public class IslemlerOgrenciExtends extends IslemlerOgrenci {

	public List<Ogrenci> ogrenciler;
	
	@Override
	public boolean ogrenciEkle(Ogrenci ogrenci) {
		boolean returnResult = true;
		try{
			ogrenciler = this.tumOgrenciler; // ozkans gereksiz atama
			ogrenciler.add(ogrenci);
		}catch(Exception ex){
			returnResult = false;
			ex.getMessage();
		}
		return returnResult;
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		boolean returnResult = true;
		try{
			for(Ogrenci object : ogrenciler){
				if(object.getNo() == ogrenciNo){ // ozkans equals olmali
					ogrenciler.remove(object);
					System.out.println(ogrenciNo + " nolu ogrenci basariyla silindi");
				}else{ // ozkans bu kontrol burada olmamali
					returnResult = false;
					System.out.println(ogrenciNo + " nolu ogrenci sistemde mevcut degil!");
				}
			}
		}catch(Exception ex){
			System.out.println("Herhangi bir kay�t bulunamad�");
			returnResult = false;
		}
		return returnResult;
	}

	@Override
	public Ogrenci ogrenciBul(String ogrenciNo) {
		Ogrenci ogr = null;
		try{
			for(Ogrenci object : ogrenciler){
				if(object.getNo() == ogrenciNo){  // ozkans equals olmali
					ogr = object;
				}else{ // ozkans bu kontrol burada olmamali
					System.out.println(ogrenciNo + " nolu ogrenci sistemde mevcut degil!");
				}
			}
		}catch(Exception ex){
			System.out.println("Herhangi bir kay�t bulunamad�");
		}
		return ogr;
	}
	
	public void displayOgrenci(List<Ogrenci> ogr){
		try{
			for(Ogrenci object : ogr){
				System.out.println(object.getAdSoyad() + " " + object.getNo() + " nolu bir " + object.ogrenciTipi() + " ��rencisidir.");
			}
		}catch(Exception ex){
			System.out.println("Herhangi bir kay�t bulunamad�");
		}
	}

	@Override
	public List<Ogrenci> ogrenciList() {
		return ogrenciler;
	}

	@Override
	public List<Ogrenci> ogrenciSiraliList() {
	    // ozkans stram kullanimini derste gostermemistim
		ogrenciler = ogrenciler.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		return ogrenciler;
	}

	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		LinkedList<Ogrenci> list = new LinkedList<Ogrenci>();
		list.addAll(ogrenciler);
		return list;

	}

	@Override
	public Set<Ogrenci> ogrenciSet() {
		Set<Ogrenci> lSet = new TreeSet<Ogrenci>(); // ozkans hashset olsa daha iyiydi
		lSet.addAll(ogrenciler);
		return lSet;
	}

	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		SortedSet<Ogrenci> sSet = new TreeSet<Ogrenci>();
		sSet.addAll(ogrenciler);
		return sSet;
	}

	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		Map<String,Ogrenci> map = new HashMap<String,Ogrenci>();
		for (Ogrenci i : ogrenciler){
		    // ozkans bir ogrenciye ait bir mapping olsa daha iyi
			 map.put(i.getAdSoyad() , i);
			 map.put(i.getNo() , i);
			 map.put(i.ogrenciTipi() , i);
		}
		return map;
	}

	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		SortedMap<String,Ogrenci> sortedMap = new TreeMap<String,Ogrenci>();
		for (Ogrenci i : ogrenciler){
			sortedMap.put(i.getAdSoyad() , i);
			sortedMap.put(i.getNo() , i);
			sortedMap.put(i.ogrenciTipi() , i);
		}
		return sortedMap;
	}

}
