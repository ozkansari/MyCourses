package tr.edu.medipol.ogrenciler.ismailsahin.odev5;

import java.lang.reflect.Array;
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

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

public class Odev5Islemler extends IslemlerOgrenci {

	@Override
	public boolean ogrenciEkle(Ogrenci ogrenci) {
		tumOgrenciler.add(ogrenci);
		return true;
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		for(int i=0;i<tumOgrenciler.size();i++){
			if(tumOgrenciler.get(i).getNo()==ogrenciNo){ // ozkans string karsilastirma equals olmali
				tumOgrenciler.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Ogrenci ogrenciBul(String ogrenciNo) {
		for (int i = 0; i < tumOgrenciler.size(); i++) {
			if(tumOgrenciler.get(i).getNo()==ogrenciNo){ // ozkans string karsilastirma equals olmali
				return tumOgrenciler.get(i);			
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
		Collections.sort(tumOgrenciler);
		return tumOgrenciler;
	}

	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		LinkedList<Ogrenci> ll = new LinkedList<>();
		for (int i = 0; i < tumOgrenciler.size(); i++) {
			ll.add(tumOgrenciler.get(i));
		}
		return ll;
	}

	@Override
	public Set<Ogrenci> ogrenciSet() {
		Set<Ogrenci> st = new HashSet<Ogrenci>();
		for(int i=0;i<tumOgrenciler.size();i++){
			if(!st.contains(tumOgrenciler.get(i))){ // ozkans setde contains kontrolune gerek yok, zaten 1 tane olmayi garanti etmeli
				st.add(tumOgrenciler.get(i));
			}	
		}
		return st;
	}
	
	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		Map<String, Ogrenci> ogrencimap = new HashMap<String,Ogrenci>();
		for(int i=0;i<tumOgrenciler.size();i++){
			ogrencimap.put(tumOgrenciler.get(i).getAdSoyad(), tumOgrenciler.get(i));
		}
		return ogrencimap;
	}

	//son ikisinden emin degilim..
	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		Map<String, Ogrenci> ogrencimap = new HashMap<String,Ogrenci>();
		for(int i=0;i<tumOgrenciler.size();i++){
			ogrencimap.put(tumOgrenciler.get(i).getAdSoyad(), tumOgrenciler.get(i));
		}
		return (SortedMap<String, Ogrenci>) ogrencimap;
	}
	
	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		Set<Ogrenci> srtSt = new HashSet<Ogrenci>();
		for(int i=0;i<tumOgrenciler.size();i++){
			if(!srtSt.contains(tumOgrenciler.get(i))){
				srtSt.add(tumOgrenciler.get(i));
			}	
		}
		return (SortedSet<Ogrenci>) srtSt;
	}
}	
