package tr.edu.medipol.ogrenciler.didemlaloglu.odev6;


import java.util.HashMap;
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

// ODEV 6
public class Odev6Islemler extends IslemlerGeneric<Ogrenci, String> {

    public List<Ogrenci> ogrenciler;

    @Override
    public boolean kayitEkle(Ogrenci kayit) {
        boolean returnResult = true;
        try {
            ogrenciler = this.kayitlar;
            ogrenciler.add(kayit);
        } catch (Exception ex) {
            returnResult = false;
            ex.getMessage();
        }
        return returnResult;
    }

    @Override
    public boolean kayitSil(String kayitNo) {
        boolean returnResult = true;
        try {
            for (Ogrenci object : ogrenciler) {
                if (object.getNo() == kayitNo) {
                    ogrenciler.remove(object);
                    System.out.println(kayitNo + " nolu ogrenci basariyla silindi");
                } else {
                    returnResult = false; // HATALI
                    System.out.println(kayitNo + " nolu ogrenci sistemde mevcut degil!");
                }
            }
        } catch (Exception ex) {
            System.out.println("Herhangi bir kay�t bulunamad�");
            returnResult = false;
        }
        return returnResult;
    }

    @Override
    public Ogrenci kayitBul(String kayitNo) {
        Ogrenci ogr = null;
        try {
            for (Ogrenci object : ogrenciler) {
                if (object.getNo() == kayitNo) {
                    ogr = object;
                } else { // HATALI
                    System.out.println(kayitNo + " nolu ogrenci sistemde mevcut degil!");
                }
            }
        } catch (Exception ex) {
            System.out.println("Herhangi bir kay�t bulunamad�");
        }
        return ogr;
    }

    @Override
    public List<Ogrenci> kayitList() {
        return ogrenciler;
    }

    @Override
    public LinkedList<Ogrenci> kayitLinkedList() {
        LinkedList<Ogrenci> list = new LinkedList<Ogrenci>();
        list.addAll(ogrenciler);
        return list;
    }

    @Override
    public Set<Ogrenci> kayitSet() {
        Set<Ogrenci> lSet = new TreeSet<Ogrenci>();
        lSet.addAll(ogrenciler);
        return lSet;
    }

    @Override
    public SortedSet<Ogrenci> kayitSortedSet() {
        SortedSet<Ogrenci> sSet = new TreeSet<Ogrenci>();
        sSet.addAll(ogrenciler);
        return sSet;
    }

    @Override
    public Map<String, Ogrenci> kayitMap() {
        Map<String, Ogrenci> map = new HashMap<String, Ogrenci>();
        for (Ogrenci i : ogrenciler) {
            map.put(i.getAdSoyad(), i);
            map.put(i.getNo(), i);
            map.put(i.ogrenciTipi(), i);
        }
        return map;
    }

    @Override
    public SortedMap<String, Ogrenci> kayitSortedMap() {
        SortedMap<String, Ogrenci> sortedMap = new TreeMap<String, Ogrenci>();
        for (Ogrenci i : ogrenciler) {
            sortedMap.put(i.getAdSoyad(), i);
            sortedMap.put(i.getNo(), i);
            sortedMap.put(i.ogrenciTipi(), i);
        }
        return sortedMap;
    }

}
