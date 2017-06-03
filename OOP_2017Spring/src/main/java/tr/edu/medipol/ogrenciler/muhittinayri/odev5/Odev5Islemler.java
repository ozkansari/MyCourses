package tr.edu.medipol.ogrenciler.muhittinayri.odev5;

import java.util.ArrayList;
import java.util.Collections;
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


public class Odev5Islemler extends IslemlerOgrenci {


@Override
public boolean ogrenciEkle(Ogrenci ogrenci) {
	    tumOgrenciler.add(ogrenci);
		System.out.println(String.format("iirenci Numarasi= %s",ogrenci.getNo() +  " iirenci Adi Soyadi= " + ogrenci.getAdSoyad() + " iirenci Tipi = " + ogrenci.ogrenciTipi()));
	    return true;
	    
}

@Override
public boolean ogrenciSil(String ogrenciNo){
	for(int i=0; i<tumOgrenciler.size(); i++){
		Ogrenci ogrenci = tumOgrenciler.get(i);
		if(ogrenci.getNo().equals(ogrenciNo)){
			System.out.println("Silinen iirencinin Numarasi= " + ogrenci.getNo() + " Adi ve Soyadi= "+ogrenci.getAdSoyad() + "iirenci Tipi= " + ogrenci.ogrenciTipi());
			tumOgrenciler.remove(i);
		}
		else if(ogrenci.getNo() != ogrenciNo){
				System.out.println("Kayit Yok!");
			
		}
	}
	return false;
}


@Override
public Ogrenci ogrenciBul(String ogrenciNo) {
	for(int i=0; i<tumOgrenciler.size(); i++){
		Ogrenci ogrenci = tumOgrenciler.get(i);
		if(ogrenci.getNo().equals(ogrenciNo))
		{
			System.out.println("Bulunan iirencinin Numarasi= " + ogrenci.getNo() + " Adi ve Soyadi= " + ogrenci.getAdSoyad() + " iirenci Tipi= " + ogrenci.ogrenciTipi());
			return ogrenci;
		}
		else if (ogrenci.getNo() != ogrenciNo)
		{
			System.out.println("Kayit Yok!");
			return null;
		}
	}
	return null;
}

@Override
public List<Ogrenci> ogrenciList() 
{
	List<Ogrenci> List = new ArrayList<Ogrenci>();
    List.forEach(System.out::println);
	return tumOgrenciler;
}

@Override
public List<Ogrenci> ogrenciSiraliList() 
{
	
	List<Ogrenci> OgrenciListeleSirali = new ArrayList<Ogrenci>();
	Collections.sort(OgrenciListeleSirali); 
	OgrenciListeleSirali.forEach(System.out::println);
	return tumOgrenciler;
}

@Override
public LinkedList<Ogrenci> ogrenciLinkedList() 
{
	
	LinkedList<Ogrenci> linkedlist = new LinkedList<Ogrenci>(); 
    linkedlist.forEach(System.out::println);
	return null;
}

@Override
public Set<Ogrenci> ogrenciSet() 
{
	
	Set<Ogrenci> SET = new HashSet<Ogrenci>();
    SET.forEach(System.out::println);
	return null;
}

@Override
public SortedSet<Ogrenci> ogrenciSortedSet() 
{
	SortedSet<Ogrenci> sortedSet1 = new TreeSet<Ogrenci>();
    sortedSet1.forEach(System.out::println);
	return null;
}

@Override
public Map<String, Ogrenci> ogrenciMap() {
	 Map<String, Ogrenci> map = new TreeMap<String, Ogrenci>();
	return null;
}

@Override
public SortedMap<String, Ogrenci> ogrenciSortedMap() {
	Map<String, Ogrenci> sortedMAP = new TreeMap<String, Ogrenci>();
	return null;
}
}
