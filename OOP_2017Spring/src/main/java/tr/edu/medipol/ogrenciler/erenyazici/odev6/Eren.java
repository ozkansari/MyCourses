package tr.edu.medipol.ogrenciler.erenyazici.odev6;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

public class Eren extends IslemlerGeneric {

	@Override
	public boolean kayitEkle(Object kayit) {
		
		kayitlar.add(kayit);
		
		return true;
	}

	@Override
	public boolean kayitSil(Object kayitNo) {
		
		kayitlar.remove(kayitNo);
		return true;
	}

	@Override
	public Object kayitBul(Object kayitNo) {
		
		kayitlar.sort(null);
		return kayitlar;
	}

	@Override
	public List kayitList() {
		return null;
	
	}

	@Override
	public LinkedList kayitLinkedList() {
		
		return null;
	}

	@Override
	public Set kayitSet() {
	
		return null;
	}

	@Override
	public SortedSet kayitSortedSet() {
		
		return null;
	}

	@Override
	public Map kayitMap() {
	
		return null;
	}

	@Override
	public SortedMap kayitSortedMap() {
		
		return null;
	}

}
