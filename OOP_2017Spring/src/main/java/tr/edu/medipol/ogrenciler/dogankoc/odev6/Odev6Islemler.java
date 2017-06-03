package tr.edu.medipol.ogrenciler.dogankoc.odev6;

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

public class Odev6Islemler extends IslemlerGeneric<Ogrenci, String>{

	@Override
	public boolean kayitEkle(Ogrenci kayit) {
		if(kayit!=null){
			kayitlar.add(kayit);
			return true;
		}
		else return false;
	}

	@Override
	public boolean kayitSil(String kayitNo) {
		for(Ogrenci  o:kayitlar){
			if(o.getNo().equals(kayitNo)){
				kayitlar.remove(o);
				return true;
			}
				
		}
		return false;
	}

	@Override
	public Ogrenci kayitBul(String kayitNo) {
		for(Ogrenci  o:kayitlar){
			if(o.getNo().equals(kayitNo)){
				return o;
			}
		}
		return null;
	}

	@Override
	public List<Ogrenci> kayitList() {
		List <Ogrenci> geciciList=new ArrayList<>(kayitlar);
		return geciciList;
	}

	@Override
	public LinkedList<Ogrenci> kayitLinkedList() {
		LinkedList <Ogrenci> geciciList=new LinkedList<>(kayitlar);
		/*Ogrenci geciciOgr=null;
		if(kayitlar.isEmpty()){
			return null;
		}
		else{
			for(Ogrenci o:kayitlar){
				if(o.ogrenciTipi().equals("Lisans")){
					geciciOgr=new OgrenciLisans(o.getNo(),o.getAdSoyad());
				}
				if(o.ogrenciTipi().equals("Yuksek L.")){
					geciciOgr=new OgrenciYuksekLisans(o.getNo(),o.getAdSoyad());
				}
				geciciList.add(geciciOgr);
			}
		}*/
		return geciciList;
	}

	@SuppressWarnings("null")
	@Override
	public Set<Ogrenci> kayitSet() {
		Set<Ogrenci> ogrSet=new HashSet<Ogrenci>(kayitlar);
			return ogrSet;

	}

	@Override
	public SortedSet<Ogrenci>  kayitSortedSet() {
		SortedSet<Ogrenci> ogrSortedSet=new TreeSet<Ogrenci>(kayitlar);
		return  ogrSortedSet;
	}

	@Override
	public Map<String,Ogrenci> kayitMap() {
		Map<String,Ogrenci> mapOgr=new HashMap<String,Ogrenci>();
		for(Ogrenci o: kayitlar){
			mapOgr.put(o.getNo(), o);
		}	
		return mapOgr;
	}

	@Override
	public SortedMap<String,Ogrenci> kayitSortedMap() {
		SortedMap<String,Ogrenci> ogrSortedMap=new TreeMap<String,Ogrenci>();
		for(Ogrenci o: kayitlar){
			ogrSortedMap.put(o.getNo(),o);
		}		
		return ogrSortedMap;
	}


}
