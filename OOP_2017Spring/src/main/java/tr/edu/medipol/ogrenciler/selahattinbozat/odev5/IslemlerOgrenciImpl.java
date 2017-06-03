package tr.edu.medipol.ogrenciler.selahattinbozat.odev5;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tr.edu.medipol.odev.odev5.IslemlerOgrenci;
import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;


// HATALI: public abstract class IslemlerOgrenci {
/* OZKANS */ public class IslemlerOgrenciImpl  /* extends IslemlerOgrenci */ {
    
	private static final List<String> OgrenciListesi = null;
	List<String> ogrenciListesi = new ArrayList<String>();
	@SuppressWarnings("unused")
	private List<String> getOgrenciListesi()
	{
		
		ogrenciListesi.add("1 Mehmet Goksu");
		ogrenciListesi.add("2 Erdem Kafa");
		ogrenciListesi.add("3 Ali Keskin");
		ogrenciListesi.add("4 Adem Ucmaz");
		ogrenciListesi.add("5 Fatih Kesik");
		return ogrenciListesi;
	}
	
	public String isim;
	public String soyisim;
	public String no;
	
	/* HATALI: 
	void Ogrenci(String isim, String soyisim)
	{
	this.isim=isim;
	this.soyisim=soyisim;
	this.soyisim=no;
	}
	*/
	
	protected List<Ogrenci> tumOgrenciler = new ArrayList<>();
	{
		@SuppressWarnings("unused")
		boolean ogrenci = false;

		for(String item : ogrenciListesi){
		if(OgrenciListesi.add(item)){
		ogrenci = true;
		break;
		
		}
		
	}
	}

	
	
	
	// HATALI: public abstract boolean ogrenciEkle(Ogrenci ogrenci);
	{
		@SuppressWarnings("unused")
		boolean ogrencilistesi;
		/* HATALI: if(Ogrenci.Remove(0))
		if(Ogrenci.Remove(0))
		{
			ogrencilistesi=true;
		}
		else
		{
			ogrencilistesi=false;
		}
		*/
	}
	
	
	
	// HATALI: public abstract boolean ogrenciSil(String No);
	/* OZKANS */ public boolean ogrenciSil(String No)
	{
		if(ogrenciListesi.contains("Osman")) 
		{
	        System.out.println("Osman bulundu");
	}
		else
		{
			System.out.println("");
		}
		/* OZKANS */ return false;
	}
	
	
	
	// HATALI: public abstract Ogrenci ogrenciBul (String No);
	/* OZKANS */ public Ogrenci ogrenciBul(String No)
	{
		System.out.println(ogrenciListesi);
		/* OZKANS */ return null;
		
	}
	
	
	
	// HATALI: public abstract List<Ogrenci> ogrenciList();
	/* OZKANS */ public List<Ogrenci> ogrenciList()
	{
	    /* OZKANS */return tumOgrenciler;
	}
	
	
	
	// HATALI: public abstract List<Ogrenci> ogrenciSiraliList();
	{
		LinkedListogrenciList nesnem=new LinkedListogrenciList();
	}
	
	// HATALI: public abstract LinkedList<Ogrenci> ogrenciLinkedList();
	{
		
	}
}




