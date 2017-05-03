package tr.edu.medipol.hafta11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionSamples {

    // http://www.vogella.com/tutorials/JavaDatastructures/article.html

    public static void main(String[] args) {

    	List<Integer> java7Liste = new ArrayList<Integer>();
    	java7Liste.add(1);
        for (Integer integer : java7Liste) {
			System.out.println(integer);
		}
        
        /* ****************************************************************** */
        // ARRAY LIST
        /* ****************************************************************** */
        System.out.println("list1: ");
        List<String> list1 = Arrays.asList("iPhone", "Ubuntu", "Android", "iPhone");
        list1.forEach(System.out::println);
        System.out.println("-----------------------------------");
        
        System.out.println("After Collections.reverse(list1): ");
        Collections.reverse(list1); // Sirayi ters cevir
        list1.forEach(System.out::println);
        System.out.println("-----------------------------------");
        
        System.out.println("After Collections.shuffle(list1): ");
        Collections.shuffle(list1); // Karistir
        list1.forEach(System.out::println);
        System.out.println("-----------------------------------");

        System.out.println("After Collections.sort(list1): ");
        Collections.sort(list1); // Sirala
        list1.forEach(System.out::println);
        System.out.println("-----------------------------------");
        
        /* ****************************************************************** */
        // LINKED LIST
        /* ****************************************************************** */
        /*-
         * In addition to implementing the List interface, the LinkedList class
         * provides uniformly named methods to get, remove and insert an element
         * at the beginning and end of the list. These operations allow linked
         * lists to be used as a stack, queue, or double-ended queue. 
         * 
         * The class implements the Deque interface, providing first-in-first-out 
         * queue operations for add, poll, along with other stack and deque operations.
         * 
         * - http://docs.oracle.com/javase/6/docs/api/java/util/LinkedList.html
         * - http://beginnersbook.com/2013/12/linkedlist-in-java-with-example/
         */
        
        System.out.println("LinkedList sample with list1: ");
        LinkedList<String> linkedlist = new LinkedList<String>(list1);
        linkedlist.forEach(System.out::println);
        System.out.println("-----------------------------------");
        
        /* ****************************************************************** */
        // HASH MAP
        /* ****************************************************************** */
        
        System.out.println("HashMap sample with map1: ");
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(123, "Dogan Koc");
        map1.put(124, "Yucel");
        map1.put(125, "Ibrahim");
        map1.put(126, "Cihan");
        String ogrenci = map1.get(123); // ogrenci = Dogan Koc
        for (Integer key : map1.keySet()) {
        	System.out.println(key);
		}
        for (String value : map1.values()) {
        	System.out.println(value);
		}
        for (Entry<Integer, String> entry : map1.entrySet()) {
        	System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
		}
        map1.forEach( (k, v) -> System.out.printf("%s : %s%n", k, v));
        System.out.println("-----------------------------------");
        
        /* ****************************************************************** */
        // SORTED MAP
        /* ****************************************************************** */
        /*-
         * A SortedMap is a Map that sort its entries in ascending order according to the keys’ natural ordering
         * 
         * - https://examples.javacodegeeks.com/core-java/util/treemap/java-sorted-map-example/
         */
        System.out.println("SortedMap sample with map1: ");
        Map sortedMap= new TreeMap(map1);
        sortedMap.forEach( (k, v) -> System.out.printf("%s : %s%n", k, v));
        System.out.println("-----------------------------------");
        
        /* ****************************************************************** */
        // HASH SET
        /* ****************************************************************** */
        System.out.println("HashSet list1: ");
        Set hashSet1 = new HashSet(list1);
        hashSet1.forEach(System.out::println);
        System.out.println("-----------------------------------");
        
        /* ****************************************************************** */
        // SORTED SET
        /* ****************************************************************** */
        System.out.println("SortedSet sample with list1: ");
        SortedSet sortedSet1 = new TreeSet(list1);
        sortedSet1.forEach(System.out::println);
        System.out.println("-----------------------------------");
        
        
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

    }
}
