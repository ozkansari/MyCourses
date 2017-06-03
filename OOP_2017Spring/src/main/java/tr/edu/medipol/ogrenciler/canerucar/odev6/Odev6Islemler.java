package tr.edu.medipol.ogrenciler.canerucar.odev6;

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
import tr.edu.medipol.odev.odev6.*;

public class Odev6Islemler extends IslemlerGeneric<Ogrenci, String> 
{

	public boolean kayitEkle(Ogrenci kayit) 
	{
		if(kayitlar !=null)
			kayitlar.add(kayit);
			return true;
		// HATALI return false;
	}

	public boolean kayitSil(String kayitNo) 
	{
		for (Ogrenci ogrenci : kayitlar) 
		{
			if(ogrenci.getNo().equals(kayitNo))
				kayitlar.remove(ogrenci);
				return true;
		}		
		return false;
	}

	public Ogrenci kayitBul(String kayitNo) 
	{
		for (Ogrenci ogrenci : kayitlar) 
			if(ogrenci.getNo().equals(kayitNo))
			return ogrenci;
		
		return null;
	}

	public Map<String, Ogrenci> kayitMap() 
	{
		Map<String, Ogrenci> ogrncMap = new HashMap<>();
		for (Ogrenci ogrenci : kayitlar) 
			ogrncMap.put(ogrenci.getNo(), ogrenci);
		return ogrncMap;
	}
	
	public LinkedList<Ogrenci> kayitLinkedList() 
	{
		LinkedList<Ogrenci> kayitLinkedList = new LinkedList<>(kayitlar);
		return kayitLinkedList;
	}
	
	public List<Ogrenci> kayitList() 
	{
		List<Ogrenci> kayitList = new ArrayList<>(kayitlar);
		return kayitList;
	}

	public Set<Ogrenci> kayitSet() 
	{
		Set<Ogrenci> ogrnciKayitSet = new HashSet<Ogrenci>(kayitlar);
		return ogrnciKayitSet;
	}

	/* OZKANS EKLEME */
    @Override
    public SortedSet<Ogrenci> kayitSortedSet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SortedMap<String, Ogrenci> kayitSortedMap() {
        // TODO Auto-generated method stub
        return null;
    }
    /* OZKANS EKLEME */

}
