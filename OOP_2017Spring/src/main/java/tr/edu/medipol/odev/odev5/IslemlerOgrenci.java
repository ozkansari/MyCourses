package tr.edu.medipol.odev.odev5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import tr.edu.medipol.odev.Ogrenci;

public abstract class IslemlerOgrenci {

	/**
	 * Eklenen ogrenciler'in tutuldugu ana liste
	 */
	protected List<Ogrenci> tumOgrenciler = new ArrayList<>();
	
	/**
	 * tumOgrenciler listesine parametre alinan ogrenci'yi ekler.
	 * 
	 * @param ogrenci eklenecek ogrenci
	 * @return ekleme basariliysa true, degilse false
	 */
	public abstract boolean ogrenciEkle(Ogrenci ogrenci);
	
	/**
	 * tumOgrenciler listesine parametre alinan ogrenci'yi siler.
	 * 
	 * @param ogrenci silinecek ogrenci
	 * @return silme basariliysa true, degilse false
	 */
	public abstract boolean ogrenciSil(String ogrenciNo);
	
	/**
	 * tumOgrenciler listesinde parametre alinan ogrenci'yi bulur.
	 * 
	 * @param ogrenci aranacak ogrenci
	 * @return bulunan ogrenci, bulamazsa null
	 */
	public abstract Ogrenci ogrenciBul(String ogrenciNo);
	
	/**
	 * tumOgrenciler'i List olarak doner
	 * 
	 * @return
	 */
	public abstract List<Ogrenci> ogrenciList();
	
	/**
	 * tumOgrenciler'i LinkedList olarak doner
	 * 
	 * @return
	 */
	public abstract LinkedList<Ogrenci> ogrenciLinkedList();
	
	/**
	 * tumOgrenciler'i Set olarak doner
	 * 
	 * @return
	 */
	public abstract Set<Ogrenci> ogrenciSet();
	
	/**
	 * tumOgrenciler'i SortedSet olarak doner
	 * 
	 * @return
	 */
	public abstract SortedSet<Ogrenci> ogrenciSortedSet();
	
	/**
	 * tumOgrenciler'i Map olarak doner
	 * 
	 * @return
	 */
	public abstract Map<String, Ogrenci> ogrenciMap();
	
	/**
	 * tumOgrenciler'i SortedMap olarak doner
	 * 
	 * @return
	 */
	public abstract SortedMap<String, Ogrenci> ogrenciSortedMap();
	
}
