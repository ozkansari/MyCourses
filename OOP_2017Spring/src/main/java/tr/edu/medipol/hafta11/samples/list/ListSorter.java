package tr.edu.medipol.hafta11.samples.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * You can sort lists using their natural order of via lambdas for defining the Comparator.compare(). 
 * Typically in Java 8 you use a lambda expression or a method reference for the definition of the compare method.
 * 
 * http://www.vogella.com/tutorials/JavaCollections/article.html
 *
 */
public class ListSorter {
    public static void main(String[] args) {
        
        System.out.println("Sorting with Collections.sort with natural order");
        List<String> l0 = createStringList();
        Collections.sort(l0);
        l0.forEach(System.out::println);
        
        System.out.println("Sorting with Collections.sort with different order");
        List<Integer> l1 = createIntegerList();
        Collections.sort(l1, (o1, o2) -> (o1>o2 ? -1 : (o1==o2 ? 0 : 1)));

        
        System.out.println("Sorting with natural order");
        List<String> l2 = createStringList();
        l2.sort(null);
        l2.forEach(System.out::println);

        System.out.println("Sorting with a lamba expression for the comparison");
        List<String> l3 = createStringList();
        l3.sort((o1, o2) -> o1.compareToIgnoreCase(o2)); // sort ignoring case
        l3.forEach(System.out::println);
        /*
         Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		 };
		 l3.sort(comp);
         */
        System.out.println("Sorting with a method references");
        List<String> l4 = createStringList();
        l4.sort(String::compareToIgnoreCase);
        l4.forEach(System.out::println);

        
    }

    private static List<String> createStringList() {
        return Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X");
    }
    
    private static List<Integer> createIntegerList() {
        return Arrays.asList(5,4,3,7,2,1);
    }

}
