package tr.edu.medipol.ogrenciler.umutkurudervis.odev5;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* ozkans */ import java.util.*;
import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

public class Odev5Islemler extends IslemlerOgrenci{

	@Override
	public boolean ogrenciEkle(Ogrenci ogrenci) {
		tumOgrenciler.add(ogrenci);
		return true;
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		for(int i =0;i<tumOgrenciler.size();i++){
			if(tumOgrenciler.get(i).getNo().equals(ogrenciNo)==true){
				tumOgrenciler.remove(i);
				return true;		
			}
		}
		return false ;
	}

	@Override
	public Ogrenci ogrenciBul(String ogrenciNo) {
		for(int i =0;i<tumOgrenciler.size();i++){
			if(tumOgrenciler.get(i).getNo().equals(ogrenciNo)==true){
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
	
		return null;
	}

	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		LinkedList<Ogrenci> bagliList = new LinkedList<Ogrenci>();
		for(int i=0;i<tumOgrenciler.size();i++){
			bagliList.add(tumOgrenciler.get(i));
			
		}
		return bagliList;
	}

	@Override
	public Set<Ogrenci> ogrenciSet() {
		Set<Ogrenci> ogrenciset = new HashSet<Ogrenci>();
		for(int i=0;i<tumOgrenciler.size();i++){
			if(ogrenciset.contains(tumOgrenciler.get(i))==false){
				ogrenciset.add(tumOgrenciler.get(i));
				
			}
		
		}
		return ogrenciset;
	}

	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		SortedSet<Ogrenci> ogrencisort = new TreeSet<Ogrenci>();
		for(int i=0;i<tumOgrenciler.size();i++){
				ogrencisort.add(tumOgrenciler.get(i));
		
		}
		return ogrencisort;
	}

	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		/* HATALI Map<String, Ogrenci> ogrenciMap = new HashMap<Ogrenci>; */
	    /* ozkans */ Map<String, Ogrenci> ogrenciMap = new HashMap<String, Ogrenci>();
		for(int i=0;i<tumOgrenciler.size();i++){
		    /* HATALI ogrenciMap.add(tumOgrenciler.get(i)); */
		    /* ozkans */ ogrenciMap.put(tumOgrenciler.get(i).getNo(), tumOgrenciler.get(i));
		}
		return ogrenciMap;
	}

	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
