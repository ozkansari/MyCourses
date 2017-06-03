package tr.edu.medipol.ogrenciler.berkaydusmez.odev6;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

/* ozkans */ import java.util.*;
public class Odev6Islemler {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = new IslemlerGeneric<Ogrenci, String>() {
			
			@Override
			public SortedSet<Ogrenci> kayitSortedSet() {
				 SortedSet<String> sortedNames = new TreeSet<>();
				    sortedNames.add("Java");
				    sortedNames.add("SQL");
				    sortedNames.add("HTML");
				    sortedNames.add("CSS");
				    System.out.println(sortedNames);			
			return null;
			}
			
			@Override
			public SortedMap<String, Ogrenci> kayitSortedMap() {
				 SortedMap<String, Integer> sortedMap = new TreeMap<String, Integer>();
				    sortedMap.put("A", 1);
				    sortedMap.put("B", 2);
				    sortedMap.put("C", 3);
				    sortedMap.put("D", 4);
				    sortedMap.put("E", 5);
				    sortedMap.put("java2s", 6);
				      
				    SortedMap<String, Integer> map = sortedMap.headMap("C");
				    System.out.println(map);			
			return null;
			}
			
			@Override
			public boolean kayitSil(String kayitNo) {
			    /* HATALI
				System.out.println("Demonstration of removeIf");
		        List<String> l1 = createList();
		        l1.removeIf(s-> s.toLowerCase().contains("x"));
		        l1.forEach(s->System.out.println(s));
		        */
				return false;
			}
			
			@Override
			public Set<Ogrenci> kayitSet() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Map<String, Ogrenci> kayitMap() {
					    SortedMap<String, Integer> sortedMap = new TreeMap<String, Integer>();
					    sortedMap.put("A", 1);
					    sortedMap.put("B", 2);
					    sortedMap.put("C", 3);
					    sortedMap.put("D", 4);
					    sortedMap.put("E", 5);
					    sortedMap.put("java2s", 6);
					      
					    SortedMap<String, Integer> map = sortedMap.subMap("B","E");
					    System.out.println(map);
				return null;
			}
			
			@Override
			public List<Ogrenci> kayitList() {
			    /* HATALI
				final int Ali = 0;
				final int Veli = 0;
				final int Mehmet = 0;

			        int a = Ali;
			        int b = Veli;
			        int c = Mehmet;

			        ArrayList<Integer> listem = new ArrayList<Integer>();
			        listem.add(a);
			        listem.add(b);
			        listem.add(c);

			        Collections.sort(listem);

			        for(int i = 0 ; i < listem.size(); i++){
			           System.out.println(listem.get(i));
			        }
					return tumOgrenciler;
				*/
			    return null;
			}
			
			@Override
			public LinkedList<Ogrenci> kayitLinkedList() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean kayitEkle(Ogrenci kayit) {
			    /* HATALI
				 Student student1 = new Student("ahmet", 13);
				 Student student2 = new Student("Mehmet", 12);
				 Student student3 = new Student("Ahmet", 11);
				 Student student4 = new Student("H�seyin", 10);
				 Student student5 = new Student("Nuri", 10);
				 Student student6 = new Student("Cem", 13);
				 Collection<Student> students = new TreeSet<Student>();
				 students.add(student1);
				 students.add(student2);
				 students.add(student3);
				 students.add(student4);
				 students.add(student5);
				 students.add(student6);
				 for(Student student : students)
				 {
				    String name = student.getName();
				    System.out.println(name);
				 }				
				 */
				 return false;
			}
			
			@Override
			public Ogrenci kayitBul(String kayitNo) {
				return null;
			}
		} /* ozkans */ ;
/* ozkans */ }