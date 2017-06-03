package tr.edu.medipol.ogrenciler.melissatemelli.odev6;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

public class Odev6Islemler extends IslemlerGeneric<Ogrenci, String> {

	@Override
	public boolean kayitEkle(Ogrenci kayit) {
		// TODO Auto-generated method stub
		if(kayitlar.add(kayit))
			return true;
			else
				return false;
		}

	@Override
	public boolean kayitSil(String kayitNo) {
		if(kayitlar.remove(kayitNo)) {
			return true;
	  }
			else{
			return false;
			}
	}

	@Override
	public Ogrenci kayitBul(String kayitNo) {
		for (Ogrenci ogrenci : kayitlar) {
			if(kayitlar.equals(kayitNo)){
				return ogrenci;
			}
			
		}
			
		return null;
	}

	@Override
	public List<Ogrenci> kayitList() {
		// TODO Auto-generated method stub
		return kayitlar;
	}

	@Override
	public LinkedList<Ogrenci> kayitLinkedList() {
		List<Ogrenci> yedekListe=new LinkedList<Ogrenci>(kayitlar);
		java.util.Collections.sort(yedekListe); // ozkans neden sort?
		return  (LinkedList<Ogrenci>) yedekListe; // gereksiz, basta linked list tanimlanabilirdi.
	}

	@Override
	public Set<Ogrenci> kayitSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Ogrenci> kayitSortedSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Ogrenci> kayitMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedMap<String, Ogrenci> kayitSortedMap() {
		// TODO Auto-generated method stub
		return null;
	}

}
