package tr.edu.medipol.ogrenciler.canerucar.odev5;

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

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;





public class Odev5Islemler extends IslemlerOgrenci 
{
	public boolean ogrenciEkle(Ogrenci ogrenci) 
	{
		tumOgrenciler.add(ogrenci);
		return true;
	}

	public boolean ogrenciSil(String ogrenciNo) 
	{
		
			for (Ogrenci ogrenciler : tumOgrenciler) 
			if(ogrenciler.getNo().equals(ogrenciNo))
			{
				tumOgrenciler.remove(ogrenciler);
				return true;
			 
			}
		return false;
	}
	public Ogrenci ogrenciBul(String ogrenciNo)
	{
		for (Ogrenci ogrenci : tumOgrenciler) 
			if(ogrenci.getNo().equals(ogrenciNo))
				return ogrenci;
						
		return null;
	}
	public List<Ogrenci> ogrenciList() 
	{
		
		return tumOgrenciler;
	}

	public List<Ogrenci> ogrenciSiraliList() 
	{
		List<Ogrenci> ogrSiraliList = new ArrayList<>(tumOgrenciler);
			return ogrSiraliList;
	}

	public LinkedList<Ogrenci> ogrenciLinkedList() 
	{
		// HATALI LinkedList<Ogrenci> ogrLinkedList = new LinkedList<tumOgrenciler>;
	    /* OZKANS */ LinkedList<Ogrenci> ogrLinkedList = new LinkedList<>(tumOgrenciler);
		return ogrLinkedList;
	}

	public Map<String, Ogrenci> ogrenciMap() 
	{
		Map<String, Ogrenci> ogrncMap = new HashMap<>();
			for (Ogrenci ogrenci : tumOgrenciler)
				// HATALI ogrncMap.put(ogrenci, ogrenci);
			    /* OZKANS */ ogrncMap.put(ogrenci.getNo(), ogrenci);
		return ogrncMap;
	}
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		
		SortedMap<String, Ogrenci> ogrncSortedMap = new TreeMap<String, Ogrenci>();
		// HATALI for (Ogrenci ogrenci : tumOgrenciler)
		return ogrncSortedMap;
	}

	/* OZKANS EKLEME */
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
    /* OZKANS EKLEME */
}
