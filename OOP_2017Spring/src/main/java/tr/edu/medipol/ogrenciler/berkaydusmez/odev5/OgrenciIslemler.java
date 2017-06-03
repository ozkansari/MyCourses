package tr.edu.medipol.ogrenciler.berkaydusmez.odev5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

public class OgrenciIslemler extends IslemlerOgrenci {

	private String firstName;
	private String lastName;
	private String className;
	private String rollNo;
	private int age;
	private int studentId;
	@Override
	public boolean ogrenciEkle(Ogrenci ogrenci) {
			ArrayList<String> myList = new ArrayList<String>();
							myList.add("Ali");
							myList.add("Veli");
							myList.add("Mehmet");
							String name = myList.get(2);
							System.out.println(name);
		return false;
	}

	@Override
	public boolean ogrenciSil(String ogrenciNo) {
		System.out.println("Demonstration of removeIf");
        List<String> l1 = createList();
        l1.removeIf(s-> s.toLowerCase().contains("x"));
        l1.forEach(s->System.out.println(s));
		return false;
}
private static List<String>  createList() {
        return Arrays.asList("Ali", "Veli", "Mehmet");		
	}

	@Override
	public Ogrenci ogrenciBul(String ogrenciNo) {
		ogrenciNo.contains("1111");
		return null;
	}

	@Override
	public List<Ogrenci> ogrenciList() {
		System.out.println(tumOgrenciler);
		return tumOgrenciler;
	}

	@Override
	public List<Ogrenci> ogrenciSiraliList() {
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
		}

	
	@Override
	public LinkedList<Ogrenci> ogrenciLinkedList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	/* HATALI public Map<String, Ogrenci> ogrenciSet() {
Map<String, Ogrenci> map1 = new HashMap<>();
		
		for(Ogrenci ogrenci : tumOgrenciler) {
			map1.put("berkay",ogrenci);
		}
		return map1;
	}
    */
	/*ozkans */
	public java.util.Set<Ogrenci> ogrenciSet() {
	    return null;
	}
	/*ozkans */
	
	@Override
	public SortedSet<Ogrenci> ogrenciSortedSet() {
		      SortedSet<String> set = new TreeSet<String>(); 
		      set.add("b");
		      set.add("c");
		      set.add("a");
		      Iterator<String> it = set.iterator();
		      while (it.hasNext()) {
		         Object element = it.next();
		         System.out.println(element.toString());
		      }
		return null;
	}

	
	@Override
	public Map<String, Ogrenci> ogrenciMap() {
		Map<Integer,String> map=new HashMap<Integer,String>();  
		  map.put(100,"ahmet");  
		  map.put(101,"Mehmet");  
		  map.put(102,"H�sn�");  
		  for (Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry<Integer, String> m = iterator.next();
			System.out.println(m.getKey()+" "+m.getValue());
		}
		return null;  
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public SortedMap<String, Ogrenci> ogrenciSortedMap() {
		Map unsortMap = new HashMap();
		extracted1(unsortMap);
		extracted1(unsortMap);
		extracted(6, "Mohamed");
		extracted(20, "Esraa");
		extracted(1, "Bahaa");
		extracted(7, "Dalia");
		extracted(8, "Amira");
		extracted(99, "Ahmed");
		extracted(50, "Sama");
		extracted(2, "Nada");
		extracted(9, "Osama");

		System.out.println("Unsort Map......");
		// HATALI printMap(unsortMap);

		System.out.println("\nSorted Map in ascending order......");
		@SuppressWarnings("rawtypes")
		Map ascSortedMap = new TreeMap();
		ascSortedMap.putAll(unsortMap);
		// HATALI printMap(ascSortedMap);

		System.out.println("\nSorted Map in descending order......");
		@SuppressWarnings("rawtypes")
		Map desSortedMap = new TreeMap(
				new Comparator() {

					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}

					@Override
					public int compare(Object arg0, Object arg1) {
						// TODO Auto-generated method stub
						return 0;
					}

				});
		desSortedMap.putAll(unsortMap);
		// HATALI printMap(desSortedMap);
		return null;

	}

	private void extracted(int i, String string) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	private Object extracted1(@SuppressWarnings("rawtypes") Map unsortMap) {
		return unsortMap.put(10, "Ashraf");
	}

	@SuppressWarnings("unused")
	private Object extracted(Map unsortMap) {
		return unsortMap.put(5, "Sara");
	}

	/* HATALI
	public static Object printMap(Map map) {
		for (Map.Entry entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : "
					+ entry.getValue());
		}
		return null;
	}
	*/
		public void ogrenciSortedMap(String firstName, String lastName, 
				String className, String rollNo, int age){
			this.firstName = firstName;
			this.lastName = lastName;
			this.className = className;
			this.rollNo = rollNo;
			this.age = age;		
		}
	 		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public String getRollNo() {
			return rollNo;
		}
		public void setRollNo(String rollNo) {
			this.rollNo = rollNo;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}