package tr.edu.medipol.ogrenciler.dogankoc.odev5;

// HATALI package tr.edu.medipol.ogrenciler.adinizsoyadiniz.odev5


import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
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

public class Odev5Islemler  extends IslemlerOgrenci implements Comparator<String>  {
	
	@Override
	public  boolean ogrenciEkle(Ogrenci ogrenci){
		try{
			tumOgrenciler.add(ogrenci);
		}catch(Error e){
			return false;
		}
		return true;
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		try{
			for(Ogrenci o:tumOgrenciler){
				if(o.getNo().equals(ogrenciNo)){
						tumOgrenciler.remove(o);
						return true;
				}
					else break; // OZKANS HATALI
			}
		}catch(InputMismatchException e){
			return false;
		}

		return false;
	}

	@Override
	public Ogrenci ogrenciBul(String ogrenciNo){
		try{
            for(Ogrenci o:tumOgrenciler){
	            if(o.getNo().equals(ogrenciNo)){		            
		          return o;
	            }            
            }
		}catch(InputMismatchException e){
			throw e;
		}
		return null;
	}

	@Override
	public List<Ogrenci> ogrenciList() {
        return tumOgrenciler;
	}

	@Override
	public List<Ogrenci> ogrenciSiraliList() {
		List<Ogrenci> ogrenciSiraliList=new ArrayList<>(tumOgrenciler);
		Odev5Islemler obj=new Odev5Islemler();
		int boyut=tumOgrenciler.size();
		for(int i=1;i<boyut;i++){
			for(int j=0;j<boyut-i;j++){
				String no1=ogrenciSiraliList.get(j).getNo();
				String no2=ogrenciSiraliList.get(j+1).getNo();
				if(obj.compare(no1, no2)>0){
				    Ogrenci buyukOgr=ogrenciSiraliList.get(j);  //no su b�y�k olan ogrenci..
				    Ogrenci kucukOgr=ogrenciSiraliList.get(j+1);
				    ogrenciSiraliList.set(j, kucukOgr); //k����� ba�a al
				    ogrenciSiraliList.set(j+1,buyukOgr );
				}
			}
			//Liste Object s�n�f� nesneleri tutmad���ndan sort metodu ile s�ralayamad�m..
		}
		return ogrenciSiraliList;
	}
	//implements Comparator
	@Override
	public int compare(String s1, String s2) {	
		return s1.compareTo(s2); //s2 b�y�kse -1 d�ner//Comparable interface indeki compareTo...
	}
	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		 LinkedList<Ogrenci> yedekList = new LinkedList<>(tumOgrenciler);
		return yedekList;
	}

	@Override
	public Set<Ogrenci> ogrenciSet() {
		Set<Ogrenci> ogrenciSet=new HashSet<Ogrenci>(tumOgrenciler);
		return ogrenciSet;
	}

	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		SortedSet<Ogrenci> sortedSetOgr=new TreeSet<Ogrenci>(tumOgrenciler);
		return sortedSetOgr;
	}

	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		Map<String,Ogrenci> mapOgr=new HashMap<String,Ogrenci>();
		for(Ogrenci o: tumOgrenciler){
			mapOgr.put(o.getNo(), o);
		}	
		return mapOgr;
	}

	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		SortedMap<String,Ogrenci> sortedMapOgr=new TreeMap<String,Ogrenci>();
		for(Ogrenci o: tumOgrenciler){
			sortedMapOgr.put(o.getNo(), o);
		}
		return sortedMapOgr;
	}
	
}
