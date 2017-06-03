package tr.edu.medipol.ogrenciler.selahattinbozat.odev5.ikincigonderim;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

public class Islemler extends IslemlerOgrenci{


@Override
public boolean ogrenciEkle(Ogrenci ogrenci) {
	if(tumOgrenciler.add(ogrenci))
	{
		System.out.println(String.format("��renci No : ��renci Ad� ve Soyad� :   ��renci Tipi : ",ogrenci.getNo(),ogrenci.getAdSoyad(),ogrenci.ogrenciTipi()));
		return true;
		}
		else
		{
	return false;
		}
}

@Override
public boolean ogrenciSil(String ogrenciNo) {
	if(tumOgrenciler.remove(ogrenciNo))
	{
		System.out.println("��renci Silindi.");
		return true;
	}
	else
	{
		System.out.println("��renci Silenemedi.");
	return false;
	}
}

@Override
public Ogrenci ogrenciBul(String ogrenciNo)
{
	if(tumOgrenciler.contains(ogrenciNo))
	{
        System.out.printf("��renci Buluncu..", ogrenciNo);
	}
	else
	{
	return null;
	}
	return null;
}

@Override
public List<Ogrenci> ogrenciList() {
	
	for(int i=0; i<=tumOgrenciler.size(); i++) 
	{
		Ogrenci listeleme = tumOgrenciler.get(i);
		System.out.println("��renci Numaras�: "+listeleme.getNo());
	}
	return null;
}

@Override
public List<Ogrenci> ogrenciSiraliList() {
	
	for(int i=0; i<=tumOgrenciler.size(); i++) 
	{
		Ogrenci listeleme = tumOgrenciler.get(i);
		System.out.println("��renci Ad ve Soyad : "+listeleme.getAdSoyad());
		
	}
	return null;
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