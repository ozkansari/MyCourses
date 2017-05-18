package tr.edu.medipol.odev.odev6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public abstract class IslemlerGeneric<TYPE, KEY> {

	/**
	 * Eklenen kayitlarin tutuldugu ana liste
	 */
	protected List<TYPE> kayitlar = new ArrayList<>();
	
	/**
	 * kayitlar listesine parametre alinan kayit'yi ekler.
	 * 
	 * @param kayit eklenecek kayit
	 * @return ekleme basariliysa true, degilse false
	 */
	public abstract boolean kayitEkle(TYPE kayit);
	
	/**
	 * kayitlar listesine parametre alinan kayit'yi siler.
	 * 
	 * @param kayit silinecek kayit
	 * @return silme basariliysa true, degilse false
	 */
	public abstract boolean kayitSil(KEY kayitNo);
	
	/**
	 * kayitlar listesinde parametre alinan kayit'yi bulur.
	 * 
	 * @param kayit aranacak kayit
	 * @return bulunan kayit, bulamazsa null
	 */
	public abstract TYPE kayitBul(KEY kayitNo);
	
	/**
	 * kayitlar'i List olarak doner
	 * 
	 * @return
	 */
	public abstract List<TYPE> kayitList();
	
	/**
	 * kayitlar'i LinkedList olarak doner
	 * 
	 * @return
	 */
	public abstract LinkedList<TYPE> kayitLinkedList();
	
	/**
	 * kayitlar'i Set olarak doner
	 * 
	 * @return
	 */
	public abstract Set<TYPE> kayitSet();
	
	/**
	 * kayitlar'i SortedSet olarak doner
	 * 
	 * @return
	 */
	public abstract SortedSet<TYPE> kayitSortedSet();
	
	/**
	 * kayitlar'i Map olarak doner
	 * 
	 * @return
	 */
	public abstract Map<KEY, TYPE> kayitMap();
	
	/**
	 * kayitlar'i SortedMap olarak doner
	 * 
	 * @return
	 */
	public abstract SortedMap<KEY, TYPE> kayitSortedMap();
	
}
