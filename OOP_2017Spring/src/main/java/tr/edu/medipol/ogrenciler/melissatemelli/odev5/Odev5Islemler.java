package tr.edu.medipol.ogrenciler.melissatemelli.odev5;

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
		if(tumOgrenciler.add(ogrenci)) {
			return true;
	  }
			else{
			return false;
			}
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		if(tumOgrenciler.remove(ogrenciNo)) {
			return true;
	  }
			else{
			return false;
			}
	}

	@Override
	public Ogrenci ogrenciBul(String ogrenciNo) {
		for (Ogrenci ogrenci : tumOgrenciler) {
			if(tumOgrenciler.equals(ogrenciNo)){
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
		List<Ogrenci> yedekListe=new LinkedList<Ogrenci>(tumOgrenciler);
		java.util.Collections.sort(yedekListe);
		return yedekListe;
	}

	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Ogrenci> ogrenciSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
